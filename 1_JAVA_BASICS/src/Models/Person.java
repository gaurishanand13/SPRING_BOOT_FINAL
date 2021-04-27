package Models;
import java.util.HashMap;

/**
 * Java code is always gets converted to byte code which is then executed.
 * E.g Person.java is converted to Person.class which has the code converted to Byte Format which is the code executed by JVM (Java Virtual Machine).
 */

/***
 * Access modifiers -
 * private - can't be accessed outside the class.
 * Default access modifier - It means it can be accessed directly in the same package but not outside the package.
 * Protected - can be accessed anywhere in the same package and for another packages to access it, that class should be a child class of the current class.
 * Public - can be accessed anywhere
 */

/**
 * Java doesn't support multiple inheritence in terms of classes. But we can implement it using interfaces. Default access modifier (if access modifier is not
 * mentioned) for a class is Default i.e its children can be made inside same package only.
 */

/**
 * abstract classes - Contains atleast one abstract function (abstract function are those whose body is not defined). If a class extends this abstract class,
 * then it needs to implement these abstract functions of parent class. We can't create an object of an abstract class.
 */

/**
 * DIfference b/w abstract classes and interface - interface can't have functions with complete body but an abstract class can.
 */

/**
 * Final variable can't be re-assigned i.e it acts as a constant
 * Final class can't have a child class and
 * Final functions can't be overridden in child class.
 */
public class Person {

    private int age;
    private String name;
    private  Double marks;
    public String fathersName; // Since it is a public field, it can be accessed outside the class directly. Therefore we don't need getter setter for it.
    String mothersName; // Modifier to it is Default.

    public Person(int age, String name, Double marks) {
        this.age = age;
        this.name = name;
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }


    public static void main(String[] args) {
        Person p1 = new Person(10,"ABC",100.00);
        Person p2 = new Person(10,"ABC",100.00);

        System.out.println(p1==p2); // Output = false ====> as default '==' operator is overloaded to compare memory addresses.

        // An object Person will be key and Integer will be its value. (Key will be calculated using hashCode function).
        HashMap<Person,Integer> myMap = new HashMap<>();
        myMap.put(p1,1);
        myMap.put(p2,1);

        System.out.println(myMap); // Output - myMap is {models.Person@23fc625e=1, models.Person@f6f4d33=1}

    }
}
