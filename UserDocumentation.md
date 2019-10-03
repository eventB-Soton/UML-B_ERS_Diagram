


# ERS Diagram Editor - User documentation
This is the User documentation of the Sirius-based ERS Diagram Editor, and the ERS Activity Diagram View.

It describes the main features that this tool provides, and aims to help you to use it.

# Installation details

## Download Rodin

First of all download and extract Rodin 3.4.0 : 
https://sourceforge.net/projects/rodin-b-sharp/files/Core_Rodin_Platform/3.4/


## Install Sirius
The ERS Diagram Editor is based on Sirius.
So, you need to install Sirius for the editor to work.

### Get Sirius update Site link
The first step to install Sirius is to get its update site link.

Since Rodin is currently based on Eclipse Oxygen (as of Rodin 3.4.0), you will need to install the latest Sirius version for Eclipse Oxygen.


Currently it is that one : 
http://download.eclipse.org/sirius/updates/releases/6.1.3/oxygen

(All Sirius update sites can be seen here : https://wiki.eclipse.org/Sirius/Update_Sites)

### Add Sirius update site as a source
Open Rodin, then :

 - Help > Install New Software ...
 - Click on the button "Add ..."
 - on the "Add Repository" Dialog, type "Sirius update SIte" as the name and Sirius update site source (e.g. : http://download.eclipse.org/sirius/updates/releases/6.1.3/oxygen) as the Location.
 - Click on Ok


![Image of the update site dialog](/docImages/updateSite.png)

### Install Sirius
Now, install Sirius.

 - Open the "Sirius" category
 - Select all elements BUT uncheck the ones marked as "(Experimental)" (see image bellow)
 - Click on "Next"


![Image that show the elements to install](/docImages/elementsToInstall.PNG)


Rodin will now look for dependencies and install Sirius.
This can take several minutes.

Once the operation in finished, click on "Next", accept the license agreement, then click on "Finish".

Sirius will be installed.

You will need to restart Rodin once the process is finished (a Dialog will open to notify you).


## Install the "AtomicityDecomposition" plugin

Note on that part : 
I created a "test" update site, containing the various plugins, but you should probably check it before release. 
View it more like a "pre-release" build.
Also, please update this documentation accordingly.

To install the atomicity decomposition plugin, download or clone the latest ERS Project from here : 
https://github.com/NSavatier/UML-B_ERS_Diagram

If you've chosen to download it, you'll need to extract the archive.

Now in Rodin : 
 - Help > Install New Software ...
 - Click on the button "Add ..."
 - on the "Add Repository" Dialog, type "AtomicityDecomposition Local Copy" as the name and select the "ac.soton.eventb.atomicitydecomposition.testUpdateSite" folder as the Location (Click on the "Local..." button then browse to the folder location).
 - Click on Ok


![Image of the AtomicityDecomposition "update site" dialog](/docImages/updateSite2.PNG)

Now install the AtomicityDecomposition feature, by checking it and pressing next.



Accept the licence (which is, for now, empty).



A confirmation dialog telling you that this software is unsigned may appear.
Click on "install anyway".


![Image of the AtomicityDecomposition "update site" dialog](/docImages/warningUnsigned.PNG)


When asked, restart Rodin.


The installation of the AtomicityDecomposition should now be complete.
You can now start to use it.


The next sections of this guide explain how to create an ERS Diagram, as well as the main features of the plugin.


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
## Properties View

The Editor provides multiple properties views, that allows you to modify properties of any selected diagram element.

To open the properties tab, do the following : 

 - Window > Show View > Properties

Once the Properties view is open, you can use it to see and modify properties of any selected element.

## FlowDiagram Properties
When you select a FlowDiagram with the properties view open you can see its properties.

The Editor provides two properties tabs for FlowDiagram elements.

 - The Parameter View
 - The Refinements View
 
 ### Parameter View
 This view allows you to see the parameters of the currently selected FlowDiagram.


 For the root FlowDiagram, this tab also allows you to create new parameters, and to delete and modify existing ones.


You can also use the "up" and "down" arrows buttons to reorder parameters (works on any FlowDiagram).

![Image which shows the parameter View](/docImages/FlowDiagramParameterView.png)

 #### Create a new parameter
 New parameters can be created only for the root FlowDiagram (the one that is a direct child of the Machine you created it in).


To create a new parameter : 

 - Select the root FlowDiagram
 -  Click on the button "Add a parameter"
 A Dialog will open to allow you to type the parameter properties.
 - When you validate, the parameter will be created.
 
 Note that the newly created parameter in automatically added to any FlowDiagram in the Diagram.
 i.e. : Any created parameter will be known by the whole diagram when you create it.

![Image which shows how to create a parameter](/docImages/AddParameter.PNG)

 #### Delete a parameter
 To delete a parameter, simply click on the red cross next to it in the Parameters Properties.


A confirmation Dialog will be shown.


The parameter will then be deleted from the root FlowDiagram and from all the FlowDiagram elements in the diagram.

![Image which shows how to deletea parameter](/docImages/deleteParameter.PNG)

 #### Reorder Parameters
You can modify the order to which parameters are shown by using the arrows in the parameter Properties view.


Note that this reordering is only done on the selected FlowDiagram.
This means that you will have to do this reordering manually for every FlowDiagram element in which you want the reordering to be done.


This reordering simply modifies the order of the parameters in the selected FlowDiagram parameter's list.


![Image which shows how to reorder a parameter](/docImages/ReorderParameter.PNG)


### Refinements view
The Refinements View allows you to see and reorder refinements of a FlowDiagram.


This tool is especially useful if you want to modify the order of Leaves and Constructors in the diagram.


To modify the order, open the Refinements properties tab, then select the element to be reordered, and use the "up" and "down" yellow arrows buttons to reorder it.

You can then re-layout the diagram (Layout > Arrange all), it will be redrawn using the new order.


![Image which shows how to reorder refinements](/docImages/reorderRefinements.PNG)

## Modify the "ref" value of a Child
A FlowDiagram must have at least one child (refinement) whose "ref" properties is true for the model to be valid.

To modify this property, the easiest way is to use the dedicated Properties tab.

To use it : 

 - Select a Child (Leaf or Constructor)
 - Open the properties view 
 - In it, open the "Child properties" tab
 - Use the checkbox to set the "ref" value of the selected Child

![Image which shows how to modify the "ref" value of a Child](/docImages/ModifyRef.PNG)

## Reorder children of a Constructor
You can modify the order of children of a Constructor by using the "Links view" Properties tab.

To open it : 
 - Select a Constructor (Xor, And, ...)
 - Open the properties view 
 - In it, open the "Links View" tab
 - Use the yellow arrow to reorder the children of the constructor
 - Re-layout (Layout > Arrange all) the diagram, the diagram will be redrawn using the new order.

![Image which shows how to reorder constructor links](/docImages/ReorderConstructorLinks.PNG)

## Modify a Parametrized Constrcutor parameter (All, Par, Some, ...)

You can modify a parametrized Constructor parameter's properties by using the dedicated Properties view.


To do so : 
 - Select a parametrized Constructor (All, Par, Some, ...)
 - Open the properties view 
 - In it, open the "Parameter View" tab
 - Use the text fields to modify the parameter's properties.


The parameter will be updated automatically in the whole diagram hierarchy (including children FlowDiagram of the updated Constructor).


![Image which shows how to update a constructor parameter](/docImages/ConstructorParameterUpdate.PNG)

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
