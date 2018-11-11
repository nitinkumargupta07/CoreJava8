<h1>Object Serialization with Inheritance in Java</h1>

Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

1. Case 1: If superclass is serializable then subclass is automatically serializable : If superclass is Serializable, then by default every subclass is serializable. Hence, even though subclass doesn’t implement Serializable interface( and if it’s superclass implements Serializable), then we can serialize subclass object.

2.If a superclass is not serializable then subclass can still be serialized : Even though superclass doesn’t implements Serializable interface, we can serialize subclass object if subclass itself implements Serializable interface. So we can say that to serialize subclass object, superclass need not to be serializable. But what happens with the instances of superclass during serialization in this case.

 
3. Serialization: At the time of serialization, if any instance variable is inheriting from non-serializable superclass, then JVM ignores original value of that instance variable and save default value to the file.

4.   De- Serialization: At the time of de-serialization, if any non-serializable superclass is present, then JVM will execute instance control flow in the superclass. To execute instance control flow in a class, JVM will always invoke default(no-arg) constructor of that class. So every non-serializable superclass must necessarily contain default constructor, otherwise we will get runtime-exception.
5.  The no-arg contructor of every non-serializable superclass will run when an object is deserialized. However, the deserialized objects? constructor does not run when it is deserialized.

3.If the superclass is serializable but we don’t want the subclass to be serialized : There is no direct way to prevent subclass from serialization in java. One possible way by which a programmer can achieve this is by implementing the writeObject() and readObject() methods in the subclass and needs to throw NotSerializableException from these methods. These methods are executed during serialization and de-serialization respectively. By overriding these methods, we are just implementing our own custom serialization.
4. All primitive types are serializable.
5. Transient fields (with transient modifier) are NOT serialized, (i.e., not saved or restored). A class that implements Serializable must mark transient fields of classes that do not support serialization (e.g., a file stream).
6. Static fields (with static modifier) are Not serialized.