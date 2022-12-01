# a00-rameses

## Introduction

In this assignment, you will use the model-view-controller design pattern together with the JavaFX UI library to design a complete, functioning GUI application designed to prepare you for the upcoming final assignment.

This application should be a simple way to give you some hands on experience with JavaFX and MVC before ramping up to the final. For the purposes of this assignment you will be creating an application that returns a statement "He loves me" or "He loves me not" based off of user interaction with the GUI. All you need to do is have an application with a way for a user to interact with it and upon interaction return a statement that alternates with "he loves me" or "he loves me not". Since the model should be relatively simple for this assignment feel free to get creative with your views! There is a picture at the bottom to display what this might look like.

The starter interfaces will provide you with direction on what needs to be implemented in terms of the model and controller, but the views will leave some room for creativity. If you are stuck with how to design your views, then please refer to the youtube tutorial discussing one idea on how to structure them. 

## Model

The `Model` interface represents the model of MVC, and therefore contains all data necessary to display the current state of the application. In particular, the `Model` for a00-rameses should encapsulate the following concepts:

1. A boolean to determine whether loves me or loves me not should be returned.
2. A way to track how many times the user has clicked the button asking loves me?
3. A `List<ModelObserver>` of active model observers in support of the observer design pattern

### ModelImpl

You must create a class named `ModelImpl` in the `model` package which implements the `Model` interface. The `ModelImpl` class must expose a constructor with the following signature:
```java
public ModelImpl() {
    // Your constructor code here
    }
```

The `ModelImpl` class should be a "subject" with respect to the observer design pattern. This is because your view class will likely register one or more active observers of the model, and will re-render itself in response to model changes. See the `ModelObserver` interface below for more information about how to implement this.

### ModelObserver

the `ModelObserver` interface defines a single method, `update()`, and is used together with the `ModelImpl` class to implement the observer design pattern.

`ModelImpl` should therefore notify its active observers whenever *any* `Model` field value is changed. 

You need not implement the `ModelObserver` interface, but you may wish to implement it in your `View` class so your view can respond to model changes. Refer to youtube tutorial if you are confused on what this means in practice.

## Controller

All code related to your application's controller should be placed in the `controller` package.

Remember, the controller in MVC is intended to act as the "glue" between the model and the view.

To help you get started, an interface named `ClassicMvcController` is included with the starter code.

To use `ClassicMvcController`, first create a new class in the `controller` package named `ControllerImpl` which implements your chosen interface. Your `ControllerImpl` class should encapsulate a `Model` object as an instance field. Therefore, add a constructor to the `ControllerImpl` class with the following signature:
```java
public ControllerImpl(Model model) {
    // Constructor code goes here
    }
```

## View

All code related to the application's view should be placed in the `view` package.

Remember, the `view` in MVC is intended to hold all code related to the GUI. 

Regardless of the structure that you use for your view, you are required to use JavaFX as your GUI library. Therefore, the code in the `view` package will primarily create and manipulate JavaFX objects. To help you get started with a good structure for your app, one class (`AppLauncher`) and one interface (`FXComponent`) are provided.


### AppLauncher

By default, this class is the launching point of your application (although you can change that if you'd like). The `Main` class is set up to forward to `AppLauncher`, which extends `Application` and therefore launches the JavaFX GUI.

To write the view, you'll need to fill in the `start()` method in `AppLauncher` to actually set up and create your UI. Inside the `start()` method, you should create a `Model` instance and a `Controller` instance.

### FXComponent

Although you could put all the UI generation code directly in the `start()` method of `AppLauncher`, this might not be a good idea since it would clutter the method with a lot of JavaFX code. Instead, a better idea is to encapsulate each section of the UI in a separate class.

In GUI programming, it's common to build compound UI components which can be composed together. To this end, a suggested interface named `FXComponent` has been provided. You can use `FXComponent` to represent a compound UI component. For instance, you might decide to create one `FXComponent` class called `ButtonView` to display the user interaction buttons. You may then make another `FXComponent` class called `MessageView` to display the message on screen. Finally, a third `FXComponent` class called `MainView` may tie these two components together and provide a structure for them.

The `FXComponent` interface has just one method, named `render()`. `render()` is a (non-`static`) factory method which constructs the compound component's UI tree. Calling `render()` should instantiate and return a new JavaFX `Parent` object, representing the current, up-to-date scene graph for that section of the UI. Each time `render()` is called on a `FXComponent`, the `Parent` should be completely re-built from scratch, using the controller to reflect the latest state values of the application. Each `FXComponent` class should therefore encapsulate a reference to the `Controller` or `Model` for retrieving the current application state (depending on whether "classic" or "alternate" MVC is being used).

The view must be re-rerendered every time a value in the model is changed. To accomplish this, the view must register an active `ModelObserver` to observe the model instance. The easiest way to do this is by using an anonymous class or a lambda expression directly in the `start()` method of the `AppLauncher` class, since that is where you have a reference to the model. When a model change occurs, the `render()` methods should be called on each `FXComponent` instance, and the resulting new `Parent` objects should be inserted in the `Scene`, while being careful to clear any old, "stale" UI components.

Finally, the view must react to user actions, such as clicking on certain user interface elements. Do this by registering observers on the relevant JavaFX UI component events. Sometimes, an application state change is necessary in response to a user action. For example, if the user clicks the "next puzzle" button, the model must be instructed to go to the next puzzle. Make use of the controller's methods to do this. By utilizing the controller, you will enforce separation of concerns between your model and view, and enforce that the controller is an intermediary between the two.


![example](https://raw.githubusercontent.com/edwardb1203/a00-rameses/master/Screen%20Shot%202022-12-01%20at%202.11.47%20PM.png)
![example](https://raw.githubusercontent.com/edwardb1203/a00-rameses/master/Screen%20Shot%202022-12-01%20at%202.11.59%20PM.png)










