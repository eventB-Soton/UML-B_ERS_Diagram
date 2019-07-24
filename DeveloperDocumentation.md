
# Developer documentation

This is the developer documentation for the Sirius-based ERS Diagram Editor, and the ERS Activity Diagram View.
Use it if you need to maintain / update the said diagram editor tool.

## Requirements
The last version of the ERS-Diagram editor is based on [Eclipse Sirius](https://www.eclipse.org/sirius/getstarted.html).

If you are not familiar with Sirius yet, I recommend to have a look at :
* [Sirius Basic Tutorial](https://wiki.eclipse.org/Sirius/Tutorials/StarterTutorial) : Will introduce you to Sirius basic concepts like Nodes and Edges. It also gives a few practical development tips (like how to use the expression interpreter).
* [Sirius Advanced Tutorial](https://wiki.eclipse.org/Sirius/Tutorials/AdvancedTutorial) : Will explain you how to create tools, use containers, as well as a few more advanced features.

Once you are familiar with the concepts introduced in these tutorials, you should be able to understand the general features used in the ERS diagram editor.

## Concepts and Acronyms
Sirius uses a bunch of acronyms and concepts that you may not be familiar with.
So here is a short glossary that describes a few of them, that in my opinion are not detailed enough in the documentation.

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


## General Helpful Links
Here you can find a few links that proved to be useful during the development of the Sirius-based ERS editor.

[Sirius Best Practices](https://www.obeodesigner.com/resource/guidelines/EclipseSirius_BestPractices_EN.pdf) : Contains a few useful tips to design a user friendly/maintainable tool
[AQL documentation](https://www.eclipse.org/acceleo/documentation/aql.html) : Will be useful if you need to write or understand complex AQL instructions.