import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QuestionTwo {
    public static CompletableFuture<BigInteger> compute(int x){
        return CompletableFuture.supplyAsync(new Supplier<BigInteger>() {
            @Override
            public BigInteger get() {
                BigInteger result =  BigInteger.valueOf(1);
                for(int i = 2; i <= x; i++){
                    result = result.multiply(BigInteger.valueOf(i));
                }
                return result;
            }
        });
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
        ArrayList<CompletableFuture<BigInteger>> completableFutureList = new ArrayList<>();
        List<BigInteger> ansList = new ArrayList<>(completableFutureList.size());

        for(int i=0;i<array.size();i++){
            int element = array.get(i);
            int index = i;
            CompletableFuture<BigInteger> future = compute(element);
            completableFutureList.add(future);
            /**
             * These functions, then apply , then accept and then run will run automatically when the result is fetched
             */
            future.thenRun((x) -> {
                ansList. = x;
            });

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
