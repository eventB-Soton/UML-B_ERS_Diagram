

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
