package multiThreading;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

    /**
     * Note in parallel streams, work happens in different threads, so we can also use parallel streams to do work in different threads and get our work executed faster.
     */
    public static void parallelStreams(){
        List<Integer> numbers = Arrays.asList(1,1,5, 4, 2, 3, 6, 5, 8, 10, 9, 2);
        numbers.parallelStream().filter(x-> {
            System.out.println("Filtering x " + x  + " in thread " + Thread.currentThread().getName());
            return ((x%2)==0);
        }).map(x-> {
            System.out.println("Mapping x " + x  + " in thread " + Thread.currentThread().getName());
            return x * x;
        }).findFirst();
    }

    public static void normalStreams(){
        List<Integer> numbers = Arrays.asList(1,1,5, 4, 2, 3, 6, 5, 8, 10, 9, 2);
        numbers.stream().filter(x-> {
            System.out.println("Filtering x " + x  + " in thread " + Thread.currentThread().getName());
            return ((x%2)==0);
        }).map(x-> {
            System.out.println("Mapping x " + x  + " in thread " + Thread.currentThread().getName());
            return x * x;
        }).findFirst();
    }


    public static void main(String[] args) {
        normalStreams();
        System.out.println("------------------------------");
        parallelStreams();
        /**
         * Output -
         * Filtering x 1 in thread main
         * Filtering x 1 in thread main
         * Filtering x 5 in thread main
         * Filtering x 4 in thread main
         * Mapping x 4 in thread main
         * ------------------------------
         * Filtering x 4 in thread ForkJoinPool.commonPool-worker-3
         * Filtering x 1 in thread ForkJoinPool.commonPool-worker-5
         * Filtering x 3 in thread ForkJoinPool.commonPool-worker-7
         * Mapping x 4 in thread ForkJoinPool.commonPool-worker-3
         * Filtering x 1 in thread ForkJoinPool.commonPool-worker-3
         * Filtering x 5 in thread ForkJoinPool.commonPool-worker-5
         */
    }
}
