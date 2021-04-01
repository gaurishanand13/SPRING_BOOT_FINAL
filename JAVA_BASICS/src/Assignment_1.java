import java.util.*;
import java.util.stream.Collectors;

public class Assignment_1 {

    public static void main(String[] args) {

        class Person {

            private int age;
            private String name;
            private String country;

            public String getCountry() {
                return country;
            }

            public int getAge() {
                return age;
            }

            public Person(int age, String name, String country) {
                this.age = age;
                this.name = name;
                this.country = country;
            }

            @Override
            public String toString() {
                return "name: " + name + ",age: " + age +" ,country: " + country + "\n" ;
            }
        }

        List<Person> people = Arrays.asList(
                new Person(20, "John", "USA"),
                new Person(35, "Sam", "Italy"),
                new Person(15, "Jamie", "England"),
                new Person(30, "Robert", "Italy"),
                new Person(20, "James", "Ireland"),
                new Person(25, "Peter", "USA"),
                new Person(5, "Jessica", "Norway"),
                new Person(40, "Roger", "Netherlands"),
                new Person(50, "Jim", "USA")
        );

        // Question - 1 ==> Print the avg age of all the people , Output = 26
        // Both will generate the same and correct answer.
        System.out.println(people.stream().map(x -> x.age).mapToInt(x-> x).average().getAsDouble());
        System.out.println(people.stream().map(x -> x.age).reduce(0, (x, y) -> x + y)/people.stream().map(x -> x.age).count());



        // Question 2 ===> Create a list of all the people who are either greater than 20 or contain any vowel in their
        // name (uppercase or lowercase)
        List<Person> objects = people.stream().filter(x-> x.age>20
                && (x.name.toLowerCase().contains("a") || x.name.toLowerCase().contains("e") || x.name.toLowerCase().contains("i") || x.name.toLowerCase().contains("o") || x.name.toLowerCase().contains("u"))
        ).collect(Collectors.toList());
        System.out.println(objects);
        /**
         * Output -
         * [name: Sam,age: 35 ,country: Italy
         * , name: Robert,age: 30 ,country: Italy
         * , name: Peter,age: 25 ,country: USA
         * , name: Roger,age: 40 ,country: Netherlands
         * , name: Jim,age: 50 ,country: USA
         * ]
         */


        // Question 3 ===> Create a list of people, sorted in the ascending order on the basis of age, if age is same
        // then sort in descending order of name
        Collections.sort(people,new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age==o2.age){
                    return o2.name.compareTo(o1.name);
                }
                return o1.age - o2.age;
            }
        });
        System.out.println(people);
        /**
         * Output -
         * [name: Jessica,age: 5 ,country: Norway
         * , name: Jamie,age: 15 ,country: England
         * , name: John,age: 20 ,country: USA
         * , name: James,age: 20 ,country: Ireland
         * , name: Peter,age: 25 ,country: USA
         * , name: Robert,age: 30 ,country: Italy
         * , name: Sam,age: 35 ,country: Italy
         * , name: Roger,age: 40 ,country: Netherlands
         * , name: Jim,age: 50 ,country: USA
         * ]
         */


        // Question 4 ====> Create a map from this people list where the key is country name and value is count which
        //  means a map will tell how many people live in a particular country
        System.out.println(people.stream().collect(
                Collectors.groupingBy(
                        Person::getCountry,
                        Collectors.counting()
                )));
        /**
         * Output -
         * {Netherlands=1, USA=3, Norway=1, Ireland=1, England=1, Italy=2}
         */


        // Question 5 ====> Create a map which stores avg age of people per country (key should be country and value should be average age i.e, double)
        System.out.println(
                people.stream().collect(
                        Collectors.groupingBy(
                                Person::getCountry,
                                Collectors.averagingDouble(Person::getAge)
                        ))
        );
        /**
         * Output -
         * {Netherlands=40.0, USA=31.666666666666668, Norway=5.0, Ireland=20.0, England=15.0, Italy=32.5}
         */

        // Question 6 ====> Print the oldest person in every country
        System.out.println(people.stream().collect(
                Collectors.groupingBy(
                        Person::getCountry,
                        Collectors.maxBy(Comparator.comparingInt(Person::getAge))
                )));
        /**
         * Output -
         * {Netherlands=Optional[name: Roger,age: 40 ,country: Netherlands
         * ], USA=Optional[name: Jim,age: 50 ,country: USA
         * ], Norway=Optional[name: Jessica,age: 5 ,country: Norway
         * ], Ireland=Optional[name: James,age: 20 ,country: Ireland
         * ], England=Optional[name: Jamie,age: 15 ,country: England
         * ], Italy=Optional[name: Sam,age: 35 ,country: Italy
         * ]}
         */


        // Question 7 ====> Print the country with most people
        Map<String, Long> countryMap = people.stream().collect(
                Collectors.groupingBy(
                        Person::getCountry,
                        Collectors.counting()
                ));
        String ans = countryMap.entrySet().stream().filter(x-> x.getValue().equals(Collections.max(countryMap.values()))).map(Map.Entry::getKey).findFirst().get();
        System.out.println(ans); //Output - Ans
    }

}
