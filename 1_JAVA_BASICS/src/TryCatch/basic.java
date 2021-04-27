package TryCatch;

import Models.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class basic {

    private static void testFunction() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(); // A method to input some integer
            // int ans = n/0; --> This will give arithmetic expression.
            FileInputStream fs = new FileInputStream("/Users/gaurishanand/sample.txt");// Since this file doesn't exist, therefore it will give file not found error.
        }
        catch (FileNotFoundException f){
            System.out.println("File not found error");
            f.printStackTrace();
            throw new FileNotFoundException("There is some file issue");
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic Exception like division by zero");
            e.printStackTrace();
            throw new ArithmeticException();
        }
        catch (Exception e){
            System.out.println("Some unkown error has occured");
            e.printStackTrace();
        }finally {
            // This block will always be executed even if the exception is thrown or not after try/catch block
            System.out.println("End of tests function");
        }
    }


    public static void tryWithResources() throws FileNotFoundException {
        // Note - in the definition class of the scanner, it is extending auto-closable therefore we can declare this object in try with resources parameter function.
        try(
                tryWithResourceHelper helper = new tryWithResourceHelper();
                Scanner scn = new Scanner(System.in);
        ){
            //Person person = new Person(); // instead of declaring it here, if we declare in try catch prototype, then if the object declared implements close function. it will be executed automatically.
            //otherwise we have to specifically mention it.
            helper.setName("ABC");
            helper.setId(3);
            // int ans = 10 / 0;
        }catch (Exception e){
            System.out.print("In the catch block");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            //testFunction();
            tryWithResources();
        }catch (Exception e){
            System.out.println("End of main function");
            e.printStackTrace();
        }
//        Output for above try/catch when test function is executed
        /**
         * File not found error
         * End of tests function     ====> // it is from the finally block
         * End of main function
         */


//        Output for above try/catch when tryWithResources function is executed, here catch of main function will not be executed as no throw statement in this function.
        /**
         * tryCatch.tryWithResourceHelper@776ec8df
         * Making object null here!!
         */



        // Do try with resources too.
    }

}
