package multiThreading;

public class myThread {



    public static void main(String[] args) {
        /**
         * By default all the code run in main thread
         */
        System.out.println(Thread.currentThread()); // Output - Thread[main,5,main], here 5 is the priority of the main thread.

        System.out.println("Hello i am in thread = " + Thread.currentThread().getName() + " at line 9");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello i am in thread = " + Thread.currentThread().getName() + " at line 14");
            }
        });
        thread.start(); // if we don't write this, run function of thread won't get start to execute.
        System.out.println("Hello i am in thread = " + Thread.currentThread().getName() + " at line 19");
        /**
         * Output for above code -
         * Hello i am in thread = main at line 9
         * Hello i am in thread = Thread-0 at line 14
         * Hello i am in thread = main at line 19
         */
    }
}
