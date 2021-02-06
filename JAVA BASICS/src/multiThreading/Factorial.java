package multiThreading;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *  Q1 - Find the factorial of elements in the array
 *  int[] arr = {10000, 20000,30000,40000,12000,600000,5000000}
 */
public class Factorial {

    public static void nonThreadedWork(){
        int[] arr = {10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000};

        long start = System.currentTimeMillis();
        Arrays.stream(arr).forEach(x-> {
            Factorial.factorial(x);
            System.out.println(x);
        });
        long end = System.currentTimeMillis();
        System.out.println("Time taken to execute : " + (end - start)); // Output time = 15403
    }

    public static void threadedWork() throws InterruptedException {
        int[] arr = {10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000,10000, 20000 , 30000, 40000, 60000,50000,70000,90000};

        long start = System.currentTimeMillis();
        myThread[] thread_arr = new myThread[arr.length];

        for(int i = 0; i < thread_arr.length; i++){
            thread_arr[i] = new myThread(arr[i]);
            thread_arr[i].start();
        }

        for(int i=0;i<thread_arr.length;i++){
            /**
             * Note - join on a thread means, it will wait here till the thread executes whole code and comes back here, It means if another thread like thread 2
             * gets finished before this thread, then also thread_arr[2].join() will get executed after the previous 2 joins are executed. This code in a way blocks
             * main thread like if we wanted these thread to continue their work and some other work needs to be executed after this like some input output work.
             * but this input/output work will not start until all the work in these threads is finished. Hence this creates a problem for a long process as main thread gets
             * blocked untill all the threads finishes the tasks. thought multiprocessing is happening here, but .join on thread will block the main thread.
             *
             */
            thread_arr[i].join();
            System.out.println(arr[i]);
        }
        System.out.println("End");
        long end = System.currentTimeMillis();
        System.out.println("Time taken to execute : " + (end - start));

        // File input output work
        // 1. async programming in which my main thread instead of sitting idle can do something - this can be achieved using Completable Future.

    }

    /**
     * If you want to do some work on another thread using Thread class by extending to some child class
     */
    private static class myThread extends Thread{

        int num;
        BigInteger result;
        public myThread(int x){
            this.num = x;
            this.result = BigInteger.valueOf(1);
        }

        @Override
        public void run() {
            this.result = Factorial.factorial(num);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        nonThreadedWork();
        /**
         * Output of non-threaded work -
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * Time taken to execute : 23948
         */
        threadedWork();
        /**
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * 10000
         * 20000
         * 30000
         * 40000
         * 60000
         * 50000
         * 70000
         * 90000
         * End
         * Time taken to execute : 14366
         */
    }

    public static BigInteger factorial(int x){
        BigInteger ans = BigInteger.valueOf(1);
        for(int i=1;i<=x;i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }
}
