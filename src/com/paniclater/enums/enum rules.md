#Rules for enum type
1.An enum constant specifies an instance of the enum type.       

6.An enum type cannot be declared abstract or final.   
7.The Enum<E> is the direct superclass of an enum type.    
8.An enum type can be only declared inside class level, same as class level or in a separate source file. It cannot be declared inside a method or an inner class.   
9.An enum type can have constructors, methods and variables just like a regular Java class.

*  Classes can not extend Enums since they are labeled as final implicitly.
*  Enums are classes that return one instance for each enumeration constant declared by public static final field.
*  Enums are implicitly extend from java.lang.Enum, thus they can not extend from another classes.
*  Enums are implicitly implement Comparable and Serializable interfaces. Any sort operation on an Enum array/list will provide their natural order (the order in which constants are declared).
*  Enums can not created by new keyword since their constructor is private. You don’t need to declare its constuctor as private. Due to JLS
*  If no access modifier is specified for the constructor of an enum type, the constructor is private.
*  Enums can have and implement abstract methods.
*  Like other classes enums can have inner class and enums.
*  Since enums are immutable == operator could be used to check their equality.
*  If you override toString() method in an enum type than consider to write a fromString method to get enum constant related to its string representation.