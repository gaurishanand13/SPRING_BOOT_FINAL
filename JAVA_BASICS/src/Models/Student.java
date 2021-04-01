package Models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Student {

    int age; // access modifier is default as not mentioned
    protected String name;
    private Double marks;
    List<String> mobiles; // access modifier is default as not mentioned

    // Constructor
    public Student(int age, String name, Double marks, List<String> mobiles) {
        this.age = age;
        this.name = name;
        this.marks = marks;
        this.mobiles = mobiles;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            return;
        }
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

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }


    // Overiding equals and hashCode function

    // By default if this function is not overriden, then this compares memory address of the object to check if the object is equal or not.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.getAge() && Objects.equals(name, student.getName()) && Objects.equals(marks, student.getMarks()
        )&& Objects.equals(mobiles, student.getMobiles());
    }

    // If this function is not overriden, then by default java generates the hashcode based upon the memory address of the object.
    @Override
    public int hashCode() {
        // Whenever hashCode for an object of type Student is generated ,it will be generated only on the basis of these 3 fields. Marks will not be considered.
        return Objects.hash(age, name, mobiles);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", mobiles=" + mobiles +
                '}';
    }

    public static void main(String[] args) {

        Student p1 = new Student(10, "ABC", 14.0, Arrays.asList("+91234", "+971234"));
        Student p2 = new Student(10, "ABC", 13.0, Arrays.asList("+91234", "+971234"));


        // Hash Code of both generated will be same as hashcode considers only fields - age, name and mobiles while generating hashcode
        // and for these fields both the objects have same value.
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
        System.out.println(h1 + " " + h2); // Output = -1914200765 -1914200765  ===> As expected hashcode value generated is same.

        System.out.println((p1 == p2)); // Output = false ===> as this == is overloaded to compare addresses and that are different, therefore it turns out to be false.
        System.out.println(p1.equals(p2)); // Output = false ===> as we have defined the equals function for this object such that all the fields should be same, therefore they are not equal according to that

        HashMap<Student, Boolean> hashMap = new HashMap<>();
        hashMap.put(p1, true); // h1
        hashMap.put(p2, false); // h2
        System.out.println(hashMap); // Output = {Person{age=10, name='ABC', marks=14.0, mobiles=[+91234, +971234]}=true, Person{age=10, name='ABC', marks=13.0, mobiles=[+91234, +971234]}=false}
        /**
         * it will have 2 objects though the hashCode generated are same, but since the objects are not equal as according to our definition therefore hashmaps will form a linked list
         * at that hashcode location index/
         */
    }
}