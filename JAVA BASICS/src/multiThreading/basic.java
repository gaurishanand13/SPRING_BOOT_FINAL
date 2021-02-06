package multiThreading;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class basic {

    // These are many types of functional interfaces, some of these are -
    /**
     * Function(T) -  R // T can be equal to R
     * Consumer(T) -
     * Predicate(T) -boolean
     * Supply(T) - T
     * Runnable(T) -
     */
    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Delhi","Mumbai","Bangalore");
        cities.stream().filter(x-> {
            System.out.println("Thread = " + Thread.currentThread().getName());
            return x.startsWith("D");
        }).map(x-> {
            System.out.println("Thread = " + Thread.currentThread().getName());
            return x.toLowerCase();
        }).forEach(x->{
            System.out.println("Thread = " + Thread.currentThread().getName());
            System.out.println(x);
        });

        /**
         * Output - By default all the code run is run in main thread
         * Thread = main
         * Thread = main
         * Thread = main
         * delhi
         * Thread = main
         * Thread = main
         */
    }
}
