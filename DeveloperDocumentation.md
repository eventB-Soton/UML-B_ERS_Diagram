

# Developer documentation

This is the developer documentation for the Sirius-based ERS Diagram Editor, and the ERS Activity Diagram View.
Use it if you need to maintain / update the said diagram editor tool.


# Preparing your Eclipse Environment
To contribute to the ERS Diagram Editor, I recommend that you configure your environment as follows :

On your "Main development Platform", **import the following plug-ins projects** :

 -  ac.soton.eventb.atomicitydecomposition
 -  ac.soton.eventb.atomicitydecomposition.design.layout
 -  ac.soton.eventb.atomicitydecomposition.edit
 -  ac.soton.eventb.atomicitydecomposition.editor
 -  ac.soton.eventb.atomicitydecomposition.generator (optional)
 -  ac.soton.eventb.atomicitydecomposition.navigator
 -  ac.soton.eventb.atomicitydecomposition.persistence

Then **create a new Run Configuration** based on your target platform (Rodin platform with needed plugins installed). You should probably name it with something significant like "Sirius Test Platform".
Make sure that the previously imported plug-ins are loaded into your Run Configuration, **then run it.**

In the run configuration that you've just run, **load the Sirius description project** :
- ac.soton.eventb.atomicitydecomposition.design

That way, the ERS Diagram meta model, and the related plugins will be loaded in your run configuration.
It will **allow you to use features like diagram validation,** which tend to have issues if you reference a meta-model existent in an open project instead of one installed into your platform.

**With those steps you should now be able to make contributions to the ERS Diagram Editor.**

# Project Organization
### ac.soton.eventb.atomicitydecomposition.design.layout
The project *ac.soton.eventb.atomicitydecomposition.design.layout* describes the layout algorithm that is used in the ERS diagram to organize Nodes as a tree.

### ac.soton.eventb.atomicitydecomposition.design
The project *ac.soton.eventb.atomicitydecomposition.design* is the Sirius specification project.
This project specifies the way that ERS diagrams models are displayed as ERS diagrams and ERS Activity Diagram Views.

The project contains ***Services classes*** (located in the src folder).

It also contains the ***atomicity.odesign*** file that describes the specification of ERS diagrams and ERS Activity Diagram Views.


# Quick Reference / Developer Tips

## Knowledge Requirements
The last version of the ERS-Diagram editor is based on [Eclipse Sirius](https://www.eclipse.org/sirius/getstarted.html).

If you are not familiar with Sirius yet, I recommend to have a look at :
* [Sirius Basic Tutorial](https://wiki.eclipse.org/Sirius/Tutorials/StarterTutorial) : Will introduce you to Sirius basic concepts like Nodes and Edges. It also gives a few practical development tips (like how to use the expression interpreter).
* [Sirius Advanced Tutorial](https://wiki.eclipse.org/Sirius/Tutorials/AdvancedTutorial) : Will explain you how to create tools, use containers, as well as a few more advanced features.

Once you are familiar with the concepts introduced in these tutorials, you should be able to understand the general features used in the ERS diagram editor.




## Concepts and Acronyms
Sirius uses a bunch of acronyms and concepts that you may not be familiar with.
So here is a short glossary that describes a few of them, that in my opinion are not detailed enough in the documentation.

### Expressions
In the documentation I may be talking about "expressions".
By this word, I just refer to any kind of Sirius-interpretable piece of code (ie : any valid expression that can be interpreted and executed by Sirius).
Those "expressions" are the ones that you can evaluate using Sirius built-in interpreter *(Sirius Perspective > Window > Show View > Interpreter)* and the ones that you can use in "Yellow Fields" (interpreted fields).

**In short they can be any AQL Query, Acceleo Expression, OCL Expression, Service call, Variable Access, etc ...**

Some Examples of Expressions :

    aql:self
    feature:refine
    service:getFlowDiagramAndChildrenNodes()
    var:target
    ocl:name
    ['hello'/]

### [AQL](https://www.eclipse.org/acceleo/documentation/aql.html)
In Sirius world, AQL stands for "*Acceleo Query Language*".

 It is a query language that allows you to manipulate elements in the EMF model that you are representing using your Sirius tool (in our case, ERS Diagram models).

This language allows you to write queries to access to specific elements in your model.
You can even call Services on elements returned by a AQL query (more on this later).

**Some examples of AQL queries :**

    aql:self.oclIsKindOf(atomicitydecomposition::Leaf)
This query checks if the element on which the query is executed is a subclass of Leaf (or an instance of Leaf).

**A more complex one :**

    aql: if (self.eContainer().oclIsKindOf(atomicitydecomposition::FlowDiagram) or self.eContainer().oclIsKindOf(atomicitydecomposition::Loop)) then self.getFollowingChild() else null endif
That one checks if the Object that contains self is a subclass of FlowDiagram or Loop, and if true, calls the Service getFollowingChild(self) and else returns null.

**Where to use them ?**
You can use AQL queries in all "Yellow Fields".
ie : any field that is interpreted.

Example :
![An image displaying an example of AQL expression use](/docImages/aqlCallExample.PNG)

### Services
Services are Java methods that can be called in any "yellow field".
They are an alternative to writing AQL expressions, for accessing and manipulating elements of your EMF model.

Where AQL expressions allows you to write queries on elements of your model, Java code provides you a way to do so in a more classical imperative way.
Both paradigms have their uses, so both AQL queries and Services can help you to do what you want.

In the current ERS Diagram Editor specification, there are two Classes providing Services :

    ac.soton.eventb.atomicity.design.Services

Provides Services to access / show elements of the ERS Diagram model.
The Services written in this file are used in the ERS Diagram and (some) in the ERS Diagram Activity View.

    ac.soton.eventb.atomicity.design.ActivityDiagramViewServices
This file contains services used only by the ERS Diagram Activity View.

#### How to write services ?
Pretty simple : You only have to link them to your model :
*New Extension > Java Extension*

Then type in the Fully Qualified Class Name of your Service.

Example :
`ac.soton.eventb.atomicity.design.Services`

The linked Services of a Specification File can then be viewed in the editor :
![An image displaying Services in the Editor](/docImages/linkedServices.PNG)

Then all you have to do is to write the Service that you want to provide as a method in
A Service can return a primitive wrapper class (Boolean, Double, ...), a String, or any subClass of *java.util.Collection*.

(Other return types might work but I cannot guarantee it, and did not find documentation specifying this point. If you find some, please update this documentation).

#### Use of Services in Expressions

To call a Service, you just have to write :
`service:theNameOfYourService()`

**You can even call Services using the result of an AQL expression as a parameter !**
Example :

    aql: self.getFollowingChild()
This expression calls  the Service `getFollowingChild()`, using `self` as the parameter.
So, an equivalent Java call would be : `getFollowingChild(self)`

**Remember :** If you write an expression like :

    aql: <AQL_QUERY>.serviceCall(param2, param3, param4)
It will do the following :

 - Evaluate the Query, get the query result
 - Use the query result as the FIRST parameter of the service call, ie, in my example :
 `serviceCall(QUERY_RESULT, param2, param3, param4)`

A concrete use of this combination of Query can be found in the Creation Constructor -> Leaf link code :
![An image displaying an example of AQL/Service combined use](/docImages/exampleCombinedAQLServices.PNG)

### Expressions Context
All Expressions are evaluated based on a context.
The context of an expression depends on where you have written this expression.

**Context for Nodes**
For example, in the "ERS Diagram" Diagram Specification, its DomainClass is FlowDiagram (see image below).
![An image displaying ERS Diagram Specification DomainClass](/docImages/ERSDomainClass.PNG)

This has the effect that all Nodes that are specified in the "ERS Diagram" Diagram  specification use FlowDiagram as their context.
More specifically, they use the displayed FlowDiagram as `self`.

So, an expression like this one :
![An image displaying a Node Expression](/docImages/expressionContext1.PNG)
is executed using a FlowDiagram as self.
So in the end this expression is similar to the pseudo code :

    self <- get displayed diagram
    result <- call service : getFlowDiagramAndChildrenNodes(self)
    return result

**Context for Edges**
Expression written for Edges use their source element as context.
For example, in a loopLinkEdge, who has a source element of type LoopNode, the following expression is evaluated :
![An image displaying an Edge Expression](/docImages/edgeContext.PNG)
In the end this expression is similar to the Java code :

    public Leaf evaluateExpression(Loop self){
	    return self.getLoopLink();
    }

## Development tips

### Use CTRL+SPACE !
Sirius provides auto-completition, so use it !

In any "yellow field", or "green field" you can use CTRL+SPACE to have suggestions proposed to you, like in any Eclipse Text Editor.

### Testing Expressions using the Interpreter
Sometimes you can have a hard time to write the correct expression to access to an element.

In those cases, I recommend that you **build an example of ERS Diagram model** :
Add a FlowDiagram element to an EventB machine, and then add some children to this FlowDiagram using RoseEditor or the Sample Reflexive ECore Editor.

Then, you can test the result of some Expressions using the built-in **Sirius interpreter.**
To access it, make sure you are in Sirius Perspective, then *Window > Show View > Interpreter*.

Then, you can write the expression that you want to evaluate in the Interpreter, and see its result.
To change the context in which the expression in executed, just click on the element of your meta-model.

A quite universal expression that you can try for example is :

    aql:self.name

Try to click on various elements on your model to see how this expression is executed.

## General Helpful Links
Here you can find a few links that proved to be useful during the development of the Sirius-based ERS editor.

 - [Sirius Best Practices](https://www.obeodesigner.com/resource/guidelines/EclipseSirius_BestPractices_EN.pdf) : Contains a few useful tips to design a user friendly/maintainable tool
 - [AQL documentation](https://www.eclipse.org/acceleo/documentation/aql.html) : Will be useful if you need to write or understand complex AQL instructions.
