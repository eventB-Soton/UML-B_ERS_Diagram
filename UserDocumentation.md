
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

# Editor Main Functions

Redaction in progress











