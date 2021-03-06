import Models.Person;
import Models.Student;

import java.util.*;

public class javaBasics {
    /**
     * In java we have many :-
     * Interfaces - Set, List, Queue , Deque
     * Classes - ArrayList , Vector , LinkedList, HashSet , TreeSet , LinkedHashSet , PriorityQueue
     */

    /**
     * Difference b/w int and integer in java -
     * int - A int is a data type that stores 32 bit signed integer
     * integer - Integer is a wrapper class which wraps an int into an object. Not much difference b/w these both
     * but integer class provides us some basic inbuilt methods through which we can convert integer to directly some other value.
     */
    public static void main(String[] args) {

        // Allocation array dynamically.
        ArrayList<Integer> m1 = new ArrayList<>();

        //Making a list of array
        List<Integer> ll = Arrays.asList(1, 3, 5, 2, 6, 8);

        /**
         * Difference b/w list and arrayList -
         * list - It is basically an interface which can implement arrayList , Vector , LL , HashSet etc.
         * List basically provides operations like search , update , insert , delete operations to be performed on these.
         */
        List<Integer> integer_arrayList = new ArrayList<>();
        List<Integer> integer_LinkedList = new LinkedList<>();
        List<Integer> integer_Vector = new Vector<>();

        //Making Hashmaps
        HashMap<Integer,Integer>  hashMap = new HashMap<>();

        // Making an array of objects.
        Student[] p = new Student[100];


        Person person = new Person(21,"Gaurish",100.0);
        // person.name = "Gaurish Anand"; ---> XXX - error as name is a private member.
        person.setName("Gaurish Anand");
        person.fathersName = "Pawan Anand";
        // person.mothersName = "Neetu Anand"; --> Error as variables having default access modifier can't be accessed outside the package.
        // But if the object have been made in Model package only
        // anywhere then that would have been not an error.


        List<Person> al = new ArrayList<>();
        al.add(new Person(12, "ABC", 12.0));
        al.add(new Person(13, "XYZ", 12.0));
        al.add(new Person(12, "DEF", 12.0));

        al.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println(al);


        Person[] personArray = new Person[3];
        personArray[0] = new Person(12, "ABC", 12.0);
        personArray[1] = new Person(12, "DEF", 12.0);
        personArray[2] = new Person(13, "XYZ", 12.0);
        Arrays.sort(personArray, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o2.getAge() - o1.getAge();
            }
        });


        System.out.println(personArray);

        int[] arr = {1, 3, 5, 16, 8, 12};
        System.out.println(Arrays.binarySearch(arr, 16)); // Output = -7 ==> if key not present, then random key will be given.


        /***
         * CHECKING SINGLETON CLASS
         */
        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        SingletonClass singletonClass3 = SingletonClass.getInstance();

        System.out.println(singletonClass2 + " " + singletonClass + " " + singletonClass3); // Output = SingletonClass@87aac27 SingletonClass@87aac27 SingletonClass@87aac27
        // Cleary all the objects have same address, therefore always only single instance of the object is being created. As we can't even create
        // an object of the class as the costructor of the class has been made private.
    }
}
