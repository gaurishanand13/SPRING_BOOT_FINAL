import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuestionOne {

    static class factorialClass extends Thread{
        int num;
        BigInteger result;
        public factorialClass(int x){
            this.num = x;
            this.result = BigInteger.valueOf(1);
        }

        @Override
        public void run() {
            this.result = factorial(num);
        }
    }

    public static BigInteger factorial(int x){
        BigInteger ans = BigInteger.valueOf(1);
        for(int i=1;i<=x;i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    private static void solveQuestionOne(List<Integer> array){
        BigInteger ans = array.stream().parallel().map(x-> BigInteger.valueOf(x)).reduce(BigInteger.valueOf(1),(x, y)-> x.multiply(y));
        try {
            FileWriter writer = new FileWriter("product.txt");
            writer.write(ans.toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void solveQuestionTwo(List<Integer> array){
        ArrayList<factorialClass> threadList = new ArrayList<>();
        array.stream().parallel().forEach(x-> {
            factorialClass obj = new factorialClass(x);
            threadList.add(obj);
            obj.start();
        });

        threadList.stream().parallel().forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        BigInteger ans = threadList.stream().parallel().map(x-> x.result).reduce(BigInteger.valueOf(1),(x, y)-> x.multiply(y));
        try {
            FileWriter writer = new FileWriter("sum.txt.txt");
            writer.write(ans.toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void solveQuestionThree(List<Integer> array){
        BigInteger ans = array.stream().parallel().filter(x-> {
            for(int i=2;i<x;i++){
                if((x%i)==0){
                    return false;
                }
            }
            return true;
        }).map(x-> BigInteger.valueOf(x)).reduce(BigInteger.valueOf(1),(x,y)-> x.multiply(y));

        try {
            FileWriter writer = new FileWriter("prime.txt");
            writer.write(ans.toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a list of 200 random numbers ranging from 10000 to 20000
        List<Integer> array = new Random().ints(200, 10000, 20001).boxed().collect(Collectors.toList());

        //QUESTION-1 - Calculate the product of all those and store it in a file named product.txt
        long start = System.currentTimeMillis();
        solveQuestionOne(array);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to execute 1st question : " + (end - start));

        // QUESTION-2 - Calculate the sum of factorial of all the numbers and store it in a file name sum.txt
        start = System.currentTimeMillis();
        solveQuestionTwo(array);
        end = System.currentTimeMillis();
        System.out.println("Time taken to execute 2nd question : " + (end - start));

        // QUESTION-3 - Calculate the product of all the numbers in the stream which are prime and store it in a file name prime.txt
        start = System.currentTimeMillis();
        solveQuestionThree(array);
        end = System.currentTimeMillis();
        System.out.println("Time taken to execute 3rd question : " + (end - start));
        /**
         * Output -
         * Time taken to execute 1st question : 26
         * Time taken to execute 2nd question : 107711
         * Time taken to execute 3rd question : 74
         */
    }
}
