package Multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There are 4 types of terminal functions - forEach, collect , reduce
 */
public class Streams {

    public static void main(String[] args) {

        int[] array = {8,10,12,20,30,40};

        // Find sqaure of all numbers which are divisible by 10 and also find their sum
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if((array[i]%10)==0){
                System.out.print(array[i]*array[i] + " ");
                arrayList.add(array[i]*array[i]);
                sum += (array[i]*array[i]);
            }
        }

        //Output for above loop = 100 400 900 1600
        System.out.println(sum); // Output = 3000

        // Above for loop can be implemented in a more easy way using streams (lambda expressions)
        /**
         * filter is like an if condition in for loop, it helps in filtering and selecting only those which are reqd to be processed.
         * map helps in updating the value if needed for the streams
         * forEach is useful in performing some operation on each object of stream.
         */
        // Note filter and map function returns stream
        sum = 0;
        arrayList.clear();
        Arrays.stream(array).filter(x-> {
            System.out.print("X = " + x +" ,");
            return (x % 10) == 0;
        }).map(y-> y*y).forEach(obj -> {
            System.out.print(obj);
            System.out.print(" ");
        });
        // Output for above is -
        // X = 8 ,X = 10 ,100 X = 12 ,X = 20 ,400 X = 30 ,900 X = 40 ,1600
        // Output can be explained as follows - Therefore while filtering if something is selected, it first process it further then runs for the rest stream.


        // We can convert streams to a list , ArrayList , Set  etc. For that we need to use collector. Note - boxed() is used to convert IntStream to normal stream
        // as collector can convert only streams data type to our required data type.
        System.out.println("");
        List<Integer> collect = Arrays.stream(array).boxed().filter(x -> x % 10 == 0).map(x -> x*x).collect(Collectors.toList());
        collect.stream().forEach(x-> System.out.print(x + " ")); // Output = 100 400 900 1600


        // You are given an arr of integers, you have to calculate the sum of squares of even no.
        // Note here identity = 1 is the starting value while running the loop and after that it will be 1 + arr[0] + arr[1] + ...
        System.out.println(Arrays.stream(array).filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y)); // Output = 120


        System.out.println("");
        List<String> countries = Arrays.asList("Ind", "NZ", "Aus", "SA", "WI", "SL", "Pak", "Afg", "Austria", "USA");
        // Ques -  return the first country starting with A
        countries.stream().filter(x -> Streams.filterMyCountry(x)).findFirst();
        // Output for this stream is -
        /**
         * Filtering for country :Ind
         * Filtering for country :NZ
         * Filtering for country :Aus
         */

    }

    public static boolean filterMyCountry(String country){
        System.out.println("Filtering for country :" + country);
        return country.startsWith("A") || country.startsWith("a");
    }
}
