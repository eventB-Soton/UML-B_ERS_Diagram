

# Developer documentation - ERS Diagram Specification

This is the developer documentation for the Sirius-based ERS Diagram Editor, and the ERS Activity Diagram View.
Use it if you need to maintain / update the said diagram editor tool.
This file contains information more specific on the ERS Diagram Editor.
If you need help with Sirius in general, or are looking for more general development tips, have a look at the Developer Documentation - Quick Reference file.

In this file, I will be talking about the contents of the *ac.soton.eventb.atomicitydecomposition.design* project.


## Required knowledge
In this Documentation, I suppose that you have a decent understanding of the ERS Diagram Meta-Model.
So make sure that you are familiar with FlowDiagram, Constructor, Child, Leaf, and so on before reading it.

If you need to remind yourself, that meta model in located in the *ac.soton.eventb.atomicitydecomposition* project.

I also assume that you have a good enough knowledge of Java.

## Project Contents

### Diagram Specification
The *ac.soton.eventb.atomicitydecomposition.design* project contains, like any Sirius project, the *atomicity.odesign* file that describes the specification of the ERS Diagram, and the Activity Diagram View.

This file **describes the Graphical components** that are used to display elements of an **atomicitydecomposition model.**
It also describes the various **tools** that are given to the user (creation tools, connection tools, ...), and different **operations** that are provided to him (open other type of diagram, show/hide decomposition, add refinement ...).

The atomicity.odesign describes two types of Diagrams : 

 - The **ERS Diagram** : Describes the tree-like representation of an ERS/atomicity model.
 - The **ERS Activity Diagram View** : Descibes the UML-like Activity view of an ERS model.

Both Diagrams use FlowDiagram as their root semantic element (root DomainClass).

### Services
The project also contains two Services files : 

 - *Services.java* : contains Services mostly used in the ERS Diagram Editor (some of them are used in the Activity View Diagram too).
 - *ActivityDiagramViewServices* : This class contains Services used exclusively by the Activity View Diagram.

## Note about both Diagrams Layout Algorithms
As you can see in the ERS Diagram's specification, both diagrams use a Composite Layout who is configured to display elements in a "Top to Bottom" way.

### Layout of the ERS Diagram

One important thing to note is that, **in the case of the ERS Diagram**, this **layout is overriden** by the GMF-based one that is declared in the project *ac.soton.eventb.atomicitydecomposition.design.layout* in the *ERSDiagramLayoutProvider.java* class.

This layout declares itself as an extension to *org.eclipse.gmf.runtime.diagram.ui.layoutProviders*, which allows it to override the default Sirius-provided layout algorithm (See [Sirius Documentation](https://www.eclipse.org/sirius/doc/developer/extensions-provide_custom-arrange-all.html) and [Obeo Documentation](http://docs.obeonetwork.com/obeodesigner/6.2/viewpoint/developer/general/extensions-provide_custom_arrange-all.html) for more details about providing a custom "arrange-all" feature).

Basically this extension in declared in the plugin.xml of the  *ac.soton.eventb.atomicitydecomposition.design.layout* project as follows : 

    <extension point="org.eclipse.gmf.runtime.diagram.ui.layoutProviders">
          <layoutProvider class="ac.soton.eventb.atomicitydecomposition.design.layout.ERSDiagramLayoutProvider">
             <Priority name="High"> </Priority>
          </layoutProvider>
    </extension>

This "Top to Bottom" Layout only acts as a fallback one, in the case the specific Layout provider could not be loaded.

So keep in mind that, **if you want to modify the Layout of the ERS Diagram**, you will need to modify the *ERSDiagramLayoutProvider.java* class in the *ac.soton.eventb.atomicitydecomposition.design.layout* project.

### Layout of the Activity View Diagram
In the case of the Activity View Diagram, the *ERSDiagramLayoutProvider.java* provides() method, returns false.
That will mean that its layout algorithm will not be used for that type of diagram.

**Sirius's default layout algorithm is thus used in an Activity View Diagram.**

The Top-Down Composite Layout is then applied to the diagram, to organize Graphical elements in a top-down manner.

If you want to modify this diagram layout, you will have to write your own Layout algorithm.
(See [Sirius Documentation](https://www.eclipse.org/sirius/doc/developer/extensions-provide_custom-arrange-all.html) and [Obeo Documentation](http://docs.obeonetwork.com/obeodesigner/6.2/viewpoint/developer/general/extensions-provide_custom_arrange-all.html) for more details about that).


# Specification of the ERS Diagram
The ERS Diagram provides only one layer, where all elements are displayed.

The diagram specification then declares different kind of Nodes and Edges to display the elements of the ERS-model.


## Nodes
### A note about Nodes semantic Candidate expressions
You may have noted that all Nodes declared in the ERS Diagram specification use `service:getFlowDiagramAndChildrenNodes()`as their Semantic Candidate Expression.

Why calling a service and not using `feature:refine` you may ask ?
Simply because a`FlowDiagram`'s `refine` attribute only point to its **direct children**. 

In an ERS Diagram however, we want to display the **whole model tree-structure**, containing direct children, but also children of children, and so on.

That's why I wrote a service who simply follows the different elements' references to **get the whole model hierarchy.**
This service is then used by all Nodes as their semantic candidate expression.

**Performance Note :**
 Because of this, this service is called once per type of Node.
If you ever happen to have huge models, it might be useful to have a look at this service if you look at methods to optimize, since the model hierarchy is browsed multiple times by it (once each time it is called).
On way to optimize it would be to keep the diagram hierarchy in cache (store in in a variable at first call and return it on next calls). This cache would then have to be invalidated each time the model is changed/updated.
I did not implement such a cache in order to keep the service simple and easy to understand, but you can try to implement it if performance becomes an issue.


### LeafNode
This Node Represents Leaf elements as a light green square.

This Node label is generated by executing the following AQL expression : 
`aql: self.getLeafLabelWithParameters(self.eContainer(), self.eContainer().eContainer())`

This expression calls the *getLeafLabelWithParameters()* Service that accesses the parameters declared in its various ancestors, and displays them - with the Leaf name - in the label.

### XorNode, AndNode, LoopNode, OrNode
These Nodes represent respectively Xor, And, Loop, and Or elements in the ERS diagrams.
These Nodes are the light blue ellipses shown with their type as label ("XOR" for a Xor, and so on).
Since they declare no parameters, these node's label are constant texts that show their type.

### SomeNode, ParNode, OneNode, AllNode
These Nodes represent respectively Some, Par, One, and All elements in the ERS diagrams.
They are quite similar as the other Constructor nodes, but since they declare a parameter, their label is generated using a dedicated service : 

 - `getOneLabelWithParameters(One)` for One constructors
 - `getAllLabelWithParameters(All)` for All constructors.
 - and so on ..

### SubFlowNode
This node is the grey circle that is shown on an ERS diagram to represent a FlowDiagram.
You will find one at the root of the diagram, as well one for any FlowDiagram that defines a decomposition of a Leaf.


## Edges
### refinesEdge
This edge represents the "refine" relationship between a FlowDiagram and any of its Child.

### andLinkEdge, loopLinkEdge, allLinkEdge, someLinkEdge, orLinkEdge, orLinkEdge, parLinkEdge, xorLinkEdge, oneLinkEdge
These edges represents the "link" relationship between a Constructor and its linked Leaf.

### decomposesEdge 
This edge represent the "decomposes" relationship between a Leaf and a FlowDiagram.

## Leaf Creation tools
### Node Creation Leaf
This tool allows the user to create Leaves.
It basically create a Leaf instance and sets its name to "New Event X".
This creation tool also calls `EcoreUtil.getID(instance)`in order to make sure that the newly created instance's ID is correctly initialized (this is a workaround to what looked like an *org.eventb.emf.core* bug, see [this commit](https://github.com/NSavatier/UML-B_ERS_Diagram/commit/a268dd794f1fa0e1a013a47c8f48d8e728a43a3b) for more details on that).

### DirectEditLeafName
This tool allows to directly edit the name of a Leaf.

### Add Refinement Operation
This operation allows an user to right click on a Leaf and choose "Add Refinement" to create a new FlowDiagram as decomposition of the clicked Leaf.
One important thing that this tool does is to access to parameters declared on the parent FlowDiagram and the parent Constructor (if any), and copy their parameters into the newly created FlowDiagram.
That way, the parameters declared higher in the diagram hierarchy  are inherited by the newly created FlowDiagram.

## Constructor Creation tools
### Node Creation for  And, Loop, Or, Xor
These creation tools allow to create Xor, And, Loop, and Or Nodes.
They simply create an instance of said Constructors.
As for Leafs, this creation tool also calls `EcoreUtil.getID(instance)`in order to make sure that the newly created instance's ID is correctly initialized.

### SomeNode, ParNode, OneNode, AllNode
These creation tools allow to create Some, Par, One, All Nodes.
They create an instance of said objects, and then show a Dialog to the user so that he can enter the parameter's properties.

## Create Links tools
### Constructor -> Leaf link
This tool allows the user to create a link between Constructor Nodes and Leaf Nodes.
Its role is to update the "link" attribute of the Constructor to represent the newly created connection.

This link uses `service:checkIsConstructorConnectionStartAllowed()` as its precondition. 
That precondition must be true for the connection to be started.

This expression simply checks if the constructor on which the connection is started allows more links to be added, and returns true if it does.

### Refines Link
This tool allows a user to create links between a SubFlowDiagram Node and a Leaf.
Its simply adds the linked Leaf to the list of refinements ("refine" attribute) of the linked FlowDiagram.

## Open Diagrams tools
### Open Activity View
This tool allows the user to right click on a SubFlowDiagram (or the root FlowDiagram), and to open its representation as an Activity View Diagram. 
If such a representation already exists, it is opened, else it is created.
This tool is a simple call to Sirius built-in Navigation tool.

### Open in a separate ERS Diagram
This tool allows the user to right click on a SubFlowDiagram (or the root FlowDiagram), and to open it in a separate ERS Diagram.
That way, a user can focus on any sub-part of an ERS Diagram. 
If such a representation already exists, it is opened, else it is created.
This tool is a simple call to Sirius built-in Navigation tool.

# Specification of the Activity View Diagram
The ERS Activity View Diagram provides only one layer, where all elements are displayed.


## Filters
### Hide all Leaf Decompositions
This filter allows an user to hide all DecomposeSubNode.
This filter has a stronger seniority than the "Show Decomposition up to a certain level" tool.
i.e. : if this filter is activated, no decompositions will be shown, no matter what.
(The  "Show Decomposition up to a certain level" tool will have no effect while this filter is activated).

##  ERS Diagram => Activity view equivalence
As the Activity View Diagram bases itself on the same model (an atomicitydecomposition model) as the ERS Diagram one, its behavior is less straight forward.

For example, in the ERS diagram, any element that exist in the displayed model is represented by one and only one graphical element. There is a one in one mapping between model elements and their graphical representation.
In the Activity View, however, that is not the case : one model element has multiple graphical elements linked to it. 

In this part, I will detail how the "translation" is made. 
i.e. : How a model element is displayed in the Activity Diagram View.

### Representation of a FlowDiagram element
Any ERS diagram model has a FlowDiagram element as its root.
In an ERS Diagram, a FlowDiagram is displayed as a gray circle. 
In the Activity View Diagram, such an element is displayed via two Nodes : An **InitialNode** and a **FinalNode**, which represent the start and the end of the flow displayed by the Activity Diagram.
This relation can be shown in the image bellow : 
![An image displaying the Activity Diagram View](/docImages/Sequence.png)

### Representation of a Leaf element
In the Activity View, Leaves are represented in a way that is quite similar to their ERS diagram representation.
Any Leaf is represented by an **ActivityNode**. 
Such a representation can be seen in the following image : 
![An image displaying the Activity Diagram View](/docImages/Sequence2.png)

If a Leaf has a sub-FlowDiagram - that is, if its "refines" attributes contains a FlowDiagram - this FlowDiagram is displayed in a light-green container, which shows this sub-FlowDiagram as an Activity Diagram.
This graphical container is called a **DecomposeSubNode** in the diagram specification.
The image below shows an example of this sub-flow representation :
![An image displaying the Activity Diagram View](/docImages/Sequence3.png)

Note that by default, sub-flows are hidden, but they can be shown via one of the two following commands : 

 - Right Click on the Leaf which has decompositions, and click on "Show Decompositions"
 - Right click on the diagram > "Show decomposition up to a certain level" > select a decomposition level over 0 > OK

### Sequence between elements
Sequence between elements is represented by the left-to-right order of elements in an ERS diagram.
In the Activity View, sequence is represented simply via arrows between said elements.
In the specification, three types of Edges are declared to represent this sequence : 

 - **InitialEdge**, which goes from a StartingNode to various other kinds of Nodes.
 - **SequenceEdge**, which links various kinds of elements (excluding StartingNodes and FinalNodes)
 - **FinalEdge**, which links various kinds of Nodes to a FinalNode.

The following image shows these different edges in a diagram : 
![An image displaying the Activity Diagram View](/docImages/Sequence4.png)

**Why using specific Edges for Initial and Final Nodes you may ask ?**
Simply because these Edges are resolved in an completely different context : 

 - InitialEdges target finder expressions are resolved in a FlowDiagram context (since a StartingNode is their Source).
 - SequenceEdges expressions are resolved in a Child context
 - FinalEdge is resolved in a Child context too, but must be shown only if the current element is the last of their parent's content.
 
Because of these different situations, I thought that it would be easier to maintain to have three Edges with pretty simple target finder expressions, instead of one Edge type with a quite complex expression, which would have to consider all possible combinations.


### Representation of Xor Nodes
Xor Nodes are represented as Decision/Merge Nodes in the Activity View.
In the diagram Sirius specification, these Nodes are called **DecisionNode** and **MergeNode**. 
Those nodes declare the graphical representation of Decision and Merge Nodes.

The Services *getElementsWithMergeNodeRepresentation()* and *getElementsWithDecisionNodeRepresentation()* are used to determine which model elements need to have a DecisionNode or MergeNode as their representation (Xor elements are not the only model element which has Merge and Decision Nodes as their Activity View representation).

In the case of a Xor Node, both Decision and merge Nodes are used. 
This means that for each Xor node in the model, one DecisionNode and one MergeNode are added to the Activity View Diagram.

All Leaves that are declared as xorLinks of the Xor Node are linked to the DecisionNode and the MergeNode by a **DecisionBranchingEdge** and a **DecisionMergeEdge** respectively.

This representation is shown in the image bellow : 
![An image displaying the Activity Diagram View](/docImages/XorNodes.png)

### Representation of And Nodes
And Nodes are represented as Fork/join regions in the Activity View.
Like for Xor Nodes, these graphical elements are declared in the diagram specification file as **ForkNode** and **JoinNode**. 

The Service *getElementsWithForkNodeRepresentation()* is used to get which model elements needs to have a ForkNode as their representation. 
No specific service is used for JoinNodes since And elements are the only one which use this graphical element for now.

All Leaves that are declared as andLinks of the And Node are linked to the ForkNode and the JoinNode by a **ForkEdge** and a **JoinEdge** respectively.

This representation is shown in the image bellow : 
![An image displaying the Activity Diagram View](/docImages/AndNodes.png)

### Representation of Or Nodes 
Or Nodes are represented as "Fork/Merge regions" in the Activity View.
So these representation simply use ForkNodes, MergeNodes, ForkEdges, and DecisionMergeEdges.

See the respective Services (getElementsWithForkNodeRepresentation(), getElementsWithMergeNodeRepresentation()) for more details.

This representation is shown in the image bellow : 
![An image displaying the Activity Diagram View](/docImages/OrNodes.png)

### Representation of Loop Nodes
Loop Representation in the Activity View is composed of a **LoopStartNode**, a **LoopDecisionNode** and different Edges : 

 - a **LoopStartToBranchEdge** between the LoopStartNode and the **LoopDecisionNode**.
 - a **LoopStartBranchEdge** between the DecisionNode and the first element (Leaf) of the loop
 - some SequenceEdges between the loop Leaves (if there are multiples).
 - and finally a **LoopBodyEndEdge** which goes from the last Leaf of the loop to the DecisionNode.

This representation is shown in the image bellow : 
![An image displaying the Activity Diagram View](/docImages/LoopNodes.png)

### Representation of other Constructors (Some, One, Par, All)
We haven't decided for a definitive Activity View representation for other Constructors (Some, One, Par, All Nodes).
Right now they are displayed as blue boxes which contain their linked Leaves (someLink, oneLink, ...).

For example, the representation of a Some Node is as follows : 
![An image displaying the Activity Diagram View](/docImages/OthersConstructors.png)

On the specification, these Nodes representation is declared as : 

 - **AllNode** for All
 - **SomeNode** for Some
 - **ParNode** for Par
 - **OneNode** for One

All these nodes are containers which are composed of two parts : 

 - A BorderedNode, an **Ellipse**, which shows an ERS-like representation of the node (**AllNodeSubEllipse** for All Nodes).
 - A container, **ActivitySubNode**, which shows the representation of linked activities.
 

##  Commands
At the moment, the Activity View Diagram does not provide any creation tool, as it is designed to be a view of an ERS model (which can be modified via the ERS diagram editor), and not a stand-alone tool.

However, its specification declares a few commands to help the user navigate between the Activity view and  the ERS Diagram.
It also declares a few commands to show and hide Leaf decompositions in the view.

### Open in a separate Activity View Diagram
This command simply uses the Sirius built-in command "Navigate" to open the ERS Activity View related to any FlowDiagram element. 
That way, a user can easily open a sub-FlowDiagram in a separate window.
(By simply right-clicking on any graphical component linked to a FlowDiagram element).


### Open Related ERS Diagram
This command also uses the Sirius built-in command "Navigate" to open the ERS Diagram related to any FlowDiagram element.
It allows thus a user to open the ERS Diagram representation of any FlowDiagram element.

### Show Decompositions
This command allows the user to show the decompositions of a Leaf.
What is does is to show the DecomposeSubNode of that Leaf.

To understand how it works, you should have a look at the following : 

 - Look at the definition of **ActivityNode > DecomposeSubNode** in the Sirius diagram specification.
 In the "Advanced" tab, note that this node is declaring a **precondition expression**.
 That expression determines when the element must be shown/drawn/displayed or not.
 *getDisplayLeafDecompositionsProperty()* is a Service which accesses to the display property associated to a given Leaf.
 - This "display property" is maintained via an HashMap, declared in *ActivityDiagramViewServices.java*.  
 Basically, this HashMap associates a boolean to the ID of each Leaf it knows.
 That way, it contains a "display property" for each Leaf.
 [See the javadoc of that hashmap for more details.](/ac.soton.eventb.atomicitydecomposition.design/src/ac/soton/eventb/atomicity/design/ActivityDiagramViewServices.java)
 - This "display property" can then be modified by calling the *setSubDiagramVisibility(Leaf, bool)* Service which just modifies the HashMap entry for that Leaf.

This command does exactly that : It simply calls the  *setSubDiagramVisibility(Leaf, bool)* Service to change the "display property" of the Leaf, which causes its ActivityNode > DecomposeSubNode precondition to become true, which finally causes the said Node to be shown/drawn.

After that, the command calls the *relayoutDiagram()* Service to re-layout the diagram.
*(Note that this "re-layout pass" does not layout the diagram correctly : the root container is not resized. 
So, currently, the user needs to "re-layout" manually once for the said container to be correctly resized (via the arrange-all feature).
I did not manage to do it programmatically, but it would probably be an improvement if it was implemented.
So that might be a thing you might want to have a look at. This "first re-layout pass" is only there so that the user has to re-layout the diagram only once and not twice).*

Oh, and in case you're wondering, no, the "callReturn" and "callReturn2" variables values are unused.
I just used Sirius's "let" instruction to make a call to a Service, since it was the easiest way to do so.
This might seem unorthodox, but in my opinion, its not a big deal. 
I just wanted to signal this to you so that you are not confused, wondering "what the heck are those variables here for ?".

### Hide Decompositions
The counterpart of the "Show decompositions". It works exactly the same way, and just calls the Service setSubDiagramVisibility(Leaf, bool) by passing false instead of true.

### Open Decompositions in a Separate Activity Diagram
This command is quite similar to the "Open in a separate Activity View Diagram" command.
The only difference is that it is available on a Leaf instead of a FlowDiagram element.
It just calls Sirius's "Navigate" built-in command for each of the decompositions of the selected Leaf.
So basically, it just opens each of the decompositions of a Leaf in a separate diagram.


### Show Decomposition up to a certain level
This command allows a user to select the level of decomposition that it wants to be displayed on the diagram.
The level 0 is considered to be the "abstract level" or the "root level". 
i.e. : Only the direct children of the root FlowDiagram are shown.

This command opens a Dialog which asks the user which decomposition level he wants to display.
To determine which level is the maximum, the *getMaxLevelOfDecomposition()* Service is called, which determines the depth of the tree (in terms of highest number of Leaves traversed on all branches).

The user is then asked which level he wants to display (the level going from 0 to maxLevelOfDecomposition).

Then, when the user validates his choice (by pressing the "OK" button), the *showDecompositionUpToLevel(fieldValue)* Service is called.
This service then recursively modifies the sets the "visibility property" (see the "Show Decompositions"  command explanation) for Leave in its hierarchy, in order to display decompositions up to the user-chosen level.

# Properties Tabs declared in the specification
Using Sirius, you can declare custom properties-tab to help your tool user to manipulate a model properties.
In order to help the user to access quickly to its model properties (and also to help with debugging), I declared some new properties tab, which I will describe in this section.

## Constructor Parameter View
This tab allows to display the parameters of a Constructor element.
It is thus displayed when a Constructor element who have a "newParameter" attribute (All, Par, One ...) is clicked on.
This parameter tab displays the name, type and InputExpression of the TypedParameter declared in a Constructor.
All these properties are made to be non modifiable, in order to keep the consistency of inherited parameters for  children FlowDiagrams of this Constructor in the ERS model.

## Constructor Links View
This tab allows to display the links of a Constructor.
Basically, it allows the user to have a look (and modify/reorder) the content of the "links"  attribute of a Constructor (orLinks, allLink, ...).

## FlowDiagram Parameter View
This tab allows the user to have a look at all the parameters declared for a FlowDiagram.
The tab only shows the parameters who are directly declared in the selected FlowDiagram.

## FlowDiagram Refines View
This tab shows the refinements of a FlowDiagram.
It thus shows all Leaves and Constructors that are declares in the "refines" attribute of the selected FlowDiagram.
Like in other tabs, the user can reorder and add/delete "refinements" to the FlowDiagram.


