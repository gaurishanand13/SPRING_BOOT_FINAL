package Multithreading;

import java.util.Arrays;
import java.util.List;

public class Basics {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi","Mumbai","Bangalore");
        cities.stream().filter(x-> {
            System.out.println("Thread = " + Thread.currentThread().getName() + " : filter :  " + x);
            return x.startsWith("D");
        }).map(x-> {
            System.out.println("Thread = " + Thread.currentThread().getName() + " : map : " + x);
            return x.toLowerCase();
        }).forEach(x->{
            System.out.println("Thread = " + Thread.currentThread().getName() + " : forEach : " + x);
            System.out.println(x);
        });

        /**
         * Output - By default all the code run is run in main thread
         * Thread = main : filter :  Delhi
         * Thread = main : map : Delhi
         * Thread = main : forEach : delhi
         * delhi
         * Thread = main : filter :  Mumbai
         * Thread = main : filter :  Bangalore
         */
    }

}
