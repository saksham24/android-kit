## This repository explains:

### Understanding In-app coding patterns, their importance, and where to use them:
1. Builder pattern.
2. Factory patterns
3. Command line patterns

### Power of java interfaces and generics

4. Make custom lightweight Asynctask class.
5. Find android application minimize callback solution(Unlike IOS Android doesn't provide any callback on application minimized by the user) but with little power interfaces implementation, we can achieve the solution.
6. Making custom live-data classes.
7. Making custom live-data classes with thread control.<br><br>

## 1. Builder pattern
The builder pattern is used to build an object of a class using method chaining. In java, Method Chaining is used to invoke multiple methods on the same object which occurs as a single statement. 

<p align="center"><img src="https://github.com/saksham24/android-kit/blob/main/In-app%20coding%20patterns/image1.png" width="68%"><br><br>
 
 ### Advantages of builder pattern:question:
 1. When we want to make immutable class objects and fields the builder pattern is useful. You can make an object of the main class final and initialize multiple parameters of its builder class and build the main object in last.
 2. Builder design pattern also helps in minimizing the number of parameters in the constructor and thus there is no need to pass in null for optional parameters to the constructor.
 3. Object is always instantiated in a complete state.
 4. Method chaining makes codes readable.
 
 **Note:** Using the builder pattern will increase the lines of code for building a class. LOC is almost double.
 
 <br>
 
## 2. Factory pattern
 
Factory pattern works under the inheritance principle. This is mostly used where we don't know which sub-class instance needs to be created. Which sub-class object will be created is defined at runtime, not at compile time.

 <p align="center"><img src="https://github.com/saksham24/android-kit/blob/main/In-app%20coding%20patterns/image4.png" width="60%">

 Use factory class like this:
<p align="center"><img src="https://github.com/saksham24/android-kit/blob/main/In-app%20coding%20patterns/image3.png" width="75%"><br><br>
 
  ### Advantages of factory pattern:question:

 1. Factory Method Pattern allows the sub-classes to choose the type of objects to create.
 2. It promotes the loose-coupling by eliminating the need to bind application specific classes into the code.
 3. Easy unit-testing can be achieved as there are fewer dependencies of multiple subclasses in the code.
 4. Easily scalable codes- If we want to add more subclasses and conditions, so we need to change the factory class majorly. Very few code changes are required in the main class.

 <br>
 
 ## 2. Command pattern
 
Command pattern also works under the inheritance principle. This provides complete decoupling between sender and receiver. Which command will be finally executed is decided at runtime, not at compile time. This pattern is also called the **producer-consumer pattern**.
Sometimes Command pattern looks the same as the factory pattern since both patterns share the same principle of OOPs(inheritance) but they are few differences in their implementations.
Every command pattern code can be easily converted to a factory pattern due to their similarity on inheritance principle.
 <p align="center"><img src="https://github.com/saksham24/android-kit/blob/main/In-app%20coding%20patterns/image2.png" width="75%"><br><br>

 <br>
  
   ### Advantages of command pattern:question:

 1. It allows you to create a sequence of commands by providing a queue system.
 2. Easily scalable - Addition of a new command is easy and can be done without changing the existing code.
 3. Easy unit test cases can be written for different commands. If we implement major functionality of the application in command pattern then business-related unit test cases will be the same as the number of commands. We just need to write the test cases to run the command and get the expected result.
 4. Better readability and understanding the code is easy. By understanding all the commands we can understand the major business logic of the application.
  
<br>
  
## Power of java interfaces and generics:
  1. Mini Asynctask.
  2. Base Activity for application minimize controller callbacks.
  3. Mini live-data.
  4. Mini live-data with thread control.
  
   <p align="start"><img src="https://github.com/saksham24/android-kit/blob/main/power%20of%20interfaces/image1.png" width="75%"><br><br>

For **"Base Activity for application minimize controller callbacks"** use **BaseActivity** provided in the above code and integrate application class code in the same manner to achieve application's **minimize** or **reopen** events like IOS.
    
**Mini Asynctask, mini live-data, mini live-data with thread control** works the same as android's well-known **LiveData** and **Aysnctask** classes.
For mini live-data and mini live-data(Thread controlled) remember to unregister the observer when activity is destroyed as we have not integrated activity life cycle callbacks in these classes yet. This is simple Java-interfaces and generic's implementation to give a raw idea that how these well known classes are developed by android itself.
    
**Note:** LiveData and Asynctask classes in android do a lot of things if we see their class implementation. what if we don't need those heavy threading and other hierarchy features and just need to use simple basic functionality they provide? --> Answer to this is making mini copycat wrapper classes and implement only basic functionality in them and in this way our agenda is completed with lightweight classes.
  
<br><br>
  
    
# END     :warning:

