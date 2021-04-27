package Interfaces;

/**
 * Though multiple inheritence of classes is not possible in java but we can implement multiple inheritence of interfaces.
 * More general syntax is public class myClass extends child_class_name implements interface1, interface2 , interface3 .. {}
 */
public class myClass implements myInterface{
    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    /**
     * We can also override and change the functions of interfaces too.
     */
    @Override
    public String getGreetingMsg(String name) {
        return "Hi" + name;
    }

    public static void main(String[] args) {
        System.out.println(myInterface.sum(5,6));
    }
}