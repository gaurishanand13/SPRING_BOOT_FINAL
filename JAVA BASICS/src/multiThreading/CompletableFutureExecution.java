package multiThreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExecution {

    public static CompletableFuture<BigInteger> compute(int x){
//        System.out.println("Computing factorial of " + x + " in thread :" + Thread.currentThread().getName()); -> Main Thread

        // Till here it is main thread. But inside this supplyAsync function, another thread gets started
        return CompletableFuture.supplyAsync(new Supplier<BigInteger>() {
            @Override
            public BigInteger get() {
//                System.out.println("Calculating factorial of " + x + " in thread :" + Thread.currentThread().getName()); -> New Thread
                BigInteger result =  BigInteger.valueOf(1);
                for(int i = 2; i <= x; i++){
                    result = result.multiply(BigInteger.valueOf(i));
                }

                return result;
            }
        });
    }

    public static void main(String[] args) {
        int[] arr = {10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000};
        ArrayList<CompletableFuture<BigInteger>> completableFutureList = new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i=0;i<arr.length;i++){
            int element = arr[i];

            CompletableFuture<BigInteger> future = compute(element);

            completableFutureList.add(future);
            /**
             * These functions, then apply , then accept and then run will run automatically when the result is fetched
             */
            future.thenApply(x -> x.add(BigInteger.ONE))
                    .thenAccept(x -> System.out.println("the result of ele " + element + " is in x"))
                    .thenRun(() -> System.out.println("Printed the result finally for ele " + element));

        }


        completableFutureList.stream().forEach(x -> {
            try {
                x.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Ending here!!");
        System.out.println(System.currentTimeMillis() - start);
        // Clearly we can see in output that ending here and timeMillis gets executed even before all the thread gets executed, hence
        //main thread is not blocked and we are able to do tasks parallely.
        /**
         * the result of ele 10000 is in x
         * Printed the result finally for ele 10000
         * the result of ele 20000 is in x
         * Printed the result finally for ele 20000
         * the result of ele 30000 is in x
         * Printed the result finally for ele 30000
         * the result of ele 40000 is in x
         * Printed the result finally for ele 40000
         * the result of ele 50000 is in x
         * Printed the result finally for ele 50000
         * the result of ele 60000 is in x
         * Printed the result finally for ele 60000
         * the result of ele 10000 is in x
         * Printed the result finally for ele 10000
         * the result of ele 20000 is in x
         * Printed the result finally for ele 20000
         * the result of ele 30000 is in x
         * Printed the result finally for ele 30000
         * the result of ele 70000 is in x
         * Printed the result finally for ele 70000
         * the result of ele 40000 is in x
         * Printed the result finally for ele 40000
         * the result of ele 50000 is in x
         * Printed the result finally for ele 50000
         * the result of ele 60000 is in x
         * Printed the result finally for ele 60000
         * the result of ele 90000 is in x
         * Printed the result finally for ele 90000
         * the result of ele 10000 is in x
         * Printed the result finally for ele 10000
         * the result of ele 20000 is in x
         * Printed the result finally for ele 20000
         * the result of ele 30000 is in x
         * Printed the result finally for ele 30000
         * the result of ele 70000 is in x
         * Printed the result finally for ele 70000
         * the result of ele 40000 is in x
         * Printed the result finally for ele 40000
         * the result of ele 50000 is in x
         * Printed the result finally for ele 50000
         * the result of ele 60000 is in x
         * Printed the result finally for ele 60000
         * the result of ele 90000 is in x
         * Printed the result finally for ele 90000
         * the result of ele 70000 is in x
         * Printed the result finally for ele 70000
         * Ending here!!
         * 15567
         * the result of ele 90000 is in x
         * Printed the result finally for ele 90000
         */


    }
}
