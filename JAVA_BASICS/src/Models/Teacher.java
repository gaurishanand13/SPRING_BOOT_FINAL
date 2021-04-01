package Models;
import java.util.*;


public class Teacher {

    int age; // access modifier is default as not mentioned
    protected String name;
    private Double marks;
    List<String> mobiles; // access modifier is default as not mentioned

    // Constructor
    public Teacher(int age, String name, Double marks, List<String> mobiles) {
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

    // While comparing 2 objects of class Teacher whether they are equal or not
    // i am not considering marks as a parameter for that.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return
                age == teacher.getAge()
                        && Objects.equals(name, teacher.getName())
                        && Objects.equals(mobiles, teacher.getMobiles());
    }

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

        Teacher p1 = new Teacher(10, "ABC", 14.0, Arrays.asList("+91234", "+971234"));
        Teacher p2 = new Teacher(10, "ABC", 13.0, Arrays.asList("+91234", "+971234"));


        // Hash Code of both generated will be same as hashcode considers only fields - age, name and mobiles while generating hashcode
        // and for these fields both the objects have same value.
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
        System.out.println(h1 + " " + h2); // Output = -1914200765 -1914200765  ===> As expected hashcode value generated is same.

        System.out.println((p1 == p2)); // Output = false ===> as this '==' is overloaded to compare addresses and that are different, therefore it turns out to be false.
        System.out.println(p1.equals(p2)); // Output = true ===> as we have defined the equals function for this object such that all the fields except marks should be same, since they are equal, therfore
        // according to that p1 is equal to p2

        HashMap<Teacher, Boolean> hashMap = new HashMap<>();
        hashMap.put(p1, true); // h1
        hashMap.put(p2, false); // h2
        System.out.println(hashMap); // Output = {Person{age=10, name='ABC', marks=14.0, mobiles=[+91234, +971234]}=false}
        /**
         * it will have only 1 objects, since the hashCode generated are same, therfore hashmap will go to the index corresponding to that hashcode. Now it will check if any object is equal to this
         * object on the LL present at that hash index, since according to our "equal to" function, both are equal objects, therefore hashmap instead of inserting the object
         * again, it will replace it and insert it again. Hence only 1 object.
         */
    }
}
