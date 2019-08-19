
# ERS Diagram Editor - User documentation
This is the User documentation of the Sirius-based ERS Diagram Editor, and the ERS Activity Diagram View.

It describes the main features that this tool provides, and aims to help you to use it.

# Requirements
Rodin, Sirius, Atomicity Project installed.
TODO : complete this

# Getting started

This part explains how to open the ERS Diagram Editor.

## 0) Create a Rodin Project, and a Machine
First of all, you need to create a Rodin Project, and create a Machine in it.
To do so : 

 - New > EventB Project > Name it, then click "Finish".
 - Right Click on your Project > New > EventB Component > Name your Machine > Finish

## 1) Open Event-B Perspective and Add a FlowDiagram
Open Event-B Perspective : 

 - Window > Perspective > Open Perspective > Other ... > Event-B > Open


![Image which shows the Perspective Dialog](/docImages/OpenEventBPerspective.PNG)

Then, create a FlowDiagram in your Machine : 

 - Right Click on your Machine > Add FlowDiagram > Give it a Name > Ok


![Image which shows the Add FlowDiagram](/docImages/addFlowDiagram.png)

The new FlowDiagram should now show in your machine.


![Image which shows the Add FlowDiagram](/docImages/FlowDiagAdded.PNG)

Then, you'll need to go into Sirius Perspective

## 2) Open Sirius Perspective, configure your project as a Modelling Project
Open Sirius Perspective : 

 - Window > Perspective > Open Perspective > Other ... > Sirius > Open


![Image which shows the Perspective Dialog](/docImages/openSiriusPerspective.PNG)

Then convert your project as a Modelling Project : 

 - Right Click on your Project > Configure > Convert to Modelling Project


![Image which shows the Add FlowDiagram](/docImages/ConvertToModelingProject.png)

## 3) Create an ERS Diagram Representation for your FlowDiagram

Then, you need to create a representation for your FlowDiagram : 

 - "Show the contents" of the m1.bum file (by clicking on the arrow next to it)
 -  "Show the contents" of the Machine in it
 You should now see your FlowDiagram.
 - Now create a Representation for it : Right Click on it > New Representation > Other ...
 
 
![Image which shows how to Create a representation](/docImages/CreateRepresentation.png)

A Dialog should now open.
As we want to create an ERS Diagram Representation of our FlowDiagram, select "ERS Diagram" then click on "Finish".


![Image which shows said Dialog](/docImages/CreateRepresentation2.png)


The ERS Diagram should now open.
From here you will be able to edit the diagram via the Creation Tool located on the right of the Editor.


![Image which shows the Editor Panel](/docImages/editorPanel.PNG)

# ERS Editor Main Functions
Now that you've opened the editor, you can now add Leaves, Constructors, and create links between them.

All those operations can be done via the menu on the left.

## Add a Leaf
To add a Leaf, simply click on the "Leaf" tool, then click on the diagram.


![Image which shows the Leaf creation tool](/docImages/LeafCreation.PNG)

You can then rename the Leaf by selecting the Leaf (by clicking on it), then clicking once on its name.


![Image which shows how to rename a Leaf](/docImages/RenameLeaf.png)

## Add a Constructor (All, And, Loop, ...)
To add a Constructor, click on the desired tool, then click on the diagram.

The Constructor is the added on the diagram.

![Image which shows how to create a Constructor](/docImages/ConstructorCreation.PNG)

If the constructor has a parameter, a dialog will open to allow you to enter the parameter's information.

![Image which shows said Dialog](/docImages/ConstructionCreationParameter.PNG)

## Create connections
The "Create links" tool allows you to create links between elements of the Diagram.

![Image which shows the linking tools](/docImages/CreateLinks.PNG)

### Constructor -> Leaf link
As its name implies, this tool allows to link a Constructor (All, And, Loop, ...) with a Leaf.

### Refines link
With this tool you can link a Leaf or a constructor to a FlowDiagram.

To use it, click on the tool. 
You can then click on the FlowDiagram which will be the source of the connection, and then on the element (Leaf or Constructor) which will be its target.

The connection will then be created.

## Refine an Event / Leaf
To add refinements to a Leaf, right click on it, then click on "Add Refinement".

![Image which shows the refine tool](/docImages/ud_AddRefinement.png)

A new FlowDiagram is then created as the decomposition of the Leaf (decompose attribute of the Leaf in the model).

![Image which shows the FlowDiagram added](/docImages/ud_AddRefinement2.png)

## Re-layout the diagram

After creating some elements on the diagram, you will probably want to rearrange the ERS diagram.

This can be done easily by calling a re-layout on the Diagram. 
To do so : 

 - Right Click on the diagram
 - Layout
 - Click on "Arrange All"

You can use this tool at any time to reorganize the Diagram.

### Pinned Elements
Note that Sirius allows to pin elements on the diagram.
Pinned elements are not considered when the diagram is "re-layouted". 
Elements can be pinned in two ways :

 - If you manually move an element, it is automatically pinned.
 - You can also Right click on an element > Layout > Pin element

![Image which shows how to pin an element](/docImages/PinElements.png)
### Unpin an element
Pinned elements can mess-up the automatic layout of the diagram, since pinned elements are not considered in the automatic layout.
To avoid this, you may want to unpin elements.
To do so : 

 - Right click on the pinned element
 - Layout
 - Click on "unpin selected elements"

![Image which shows how to unpin an element](/docImages/UnpinElement.png)

The Diagram can then be re-layouted correctly.
 
![Image which shows the relayouted diagram](/docImages/UnpinElement2.png)
## Open a sub ERS DIagram
The editor provides a command to open any FlowDiagram is a separate diagram.

Let suppose for example that you have an ERS Diagram like this one :

![Example of large diagram](/docImages/exampleLargeDiagram.jpg)
And let's suppose that you are interested in refining the add_curr_path Event.

You can do so directly in the "main" Diagram, but you can also open the specific refinement that you want to develop, in a separate Diagram.

Let's, in our example open the decomposition of add_path_curr in a separate diagram.

To do so : 

 - Right click on the FlowDiagram node
 - Click on "Open in a separate ERS Diagram"
 A new ERS Diagram will be created and opened. (If one already exists for that FlowDiagram, it is simply opened).

![How to open in a separate ERS Diagram](/docImages/ud_OpenInSeparateERSDiagram.png)

The diagram opens.
You can now layout it using the arrange all command : 
Right click on the diagram > Layout > Arrange All

The sub diagram is now open in a separate diagram.
Any change that you do in this window will be applied on the model, and thus will be visible on the "initial" diagram (the one which represents the whole model).

![The sub diagram open](/docImages/ud_OpenInSeparateERSDiagram2.png)

## Open the Activity View
The ERS Editor also provides a way to view an ERS Diagram in an activity diagram-like representation.

To open this view for any FlowDiagram : 

 - Right click on a FlowDiagram element (or in the background of an ERS Diagram)
 - Click on "Open Activity View"

![Image that shows how to open the Activity View](/docImages/OpenActivityView.png)


Once the Activity Diagram View is open, you can then layout the diagram using the "Layout > Arrange All" command.

When first opened, The Activity Diagram View shows only the abstract refinement level : 
decompositions of Leaves are hidden by default.

![Image that shows the Activity View](/docImages/OpenActivityView2.png)


This can be configured via various commands which will be detailed in the next section.

# Activity View Main Functions

The Activity View Diagram provides an Activity Diagram-like representation of an ERS Diagram model.
This section details the main features of this diagram.


### Open Related ERS Diagram

This command allows you to open the ERS Diagram that corresponds to an Activity Diagram View.

That way, you can easily navigate between the Activity View and the ERS Diagram Editor of a FlowDiagram element.

To use it : 
 - Right click on a FlowDiagram element (or on the background of the Activity Diagram View)
 - Click on "Open Related ERS Diagram"


![Image of the Open Related ERS Diagram](/docImages/OpenRelatedERSDiagram.png)


The related ERS Diagram will open. 
(If one does not already exists for the selected FlowDiagram, it will be created).

![Image of the Open Related ERS Diagram](/docImages/OpenRelatedERSDiagram2.png)


### Show Decompositions
This command allows you to display decompositions of a Leaf (if those are currently hidden).

To use it : 
 - Right click on a Leaf
 - Click on "Show Decompositions"

![Image of the Show Decompositions](/docImages/ShowDecomposition.png)


The decomposition are drawn.
Re-layout the diagram.
To do so : 
 - Layout > Arrange All
 

![Image of the Show Decompositions](/docImages/ShowDecomposition2.png)


The decompositions are now shown correctly.

![Image of the Show Decompositions](/docImages/ShowDecomposition3.png)


### Hide Decompositions

The counterpart of the "Show decompositions".
It allows to hide the decompositions of a Leaf.

To use it : 

 - Right click on a Leaf
 - Click on "Hide Decompositions"

![Image of the Hide Decompositions](/docImages/HideDecompositions.png)


The decompositions are now hidden.
Re-layout the diagram.
To do so : 
 - Layout > Arrange All


![Image of the Hide Decompositions](/docImages/HideDecompositions2.png)


The diagram is now shown with the selected Leaf's decompositions hidden.


![Image of the Hide Decompositions](/docImages/HideDecompositions3.png)


### Open in a separate Activity View Diagram

This command allows you to open a decomposition of a Leaf in a separate Activity Diagram View.

This command can be useful if you want to focus on a specific part of the diagram.

To use it : 

 - Right click on a decomposition of a Leaf (the light-green zone
 - Click on "Open in a separate Activity View Diagram"


![Image of the Open in a separate Activity Diagram](/docImages/OpenInSeparateActivityDiagram.png)


The Activity Diagram View is then opened.


![Image of the Open in a separate Activity Diagram](/docImages/OpenInSeparateActivityDiagram2.png)



### Open Decompositions in a Separate Activity Diagram

This command is quite similar to the "Open in a separate Activity View Diagram" command.
The only difference is that it is available on a Leaf instead of a FlowDiagram element.

It allows you to open decompositions of a Leaf in a separate Activity Diagram.

To use it : 

 - Right click on a Leaf which has decompositions (the command won't show if the Leaf has none)
 - Click on "Open Decompositions in a Separate Activity Diagram"


![Image of the Open Decompositions in a Separate Activity Diagram](/docImages/OpenDecompositionsinSeparateActivityDiagram.png)


The selected Leaf's decomposition(s) will then open in a separated Diagram.


![Image of the Open Decompositions in a Separate Activity Diagram](/docImages/OpenDecompositionsinSeparateActivityDiagram2.png)



### Show Decomposition up to a certain level


This command allows you to select the level of decomposition that you want to be shown on the diagram.

To use it : 

 - Right Click on the background of an Activity Diagram View
 - Click on "Show Decomposition up to a certain level"
 

![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel.png)

A Dialog then opens, to ask you which decomposition level you want.

The level 0 is considered to be the "abstract level" or the "root level".  i.e. : Only the direct children of the root FlowDiagram are shown.

The level 1 shows the direct decompositions of "root level" elements.

The level 2 shows decompositions of level 1 elements, and so on.

![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel2.png)

Select the desired decomposition level.

![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel3.png)

Then Click on "Ok".

The decomposition level is drawn. 


![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel4.png)


The diagram now needs to be re-layout.
To do so : 

 - Layout > Arrange All

 
![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel5.png)



The diagram is then correctly shown with the wanted decomposition level.


![Image of the Show Decomposition up to a certain level](/docImages/ShowDecompositionUpToCertainLevel6.png)


Note that for large diagrams, you might need to re-layout the diagram more than once in order to organize it correctly.
