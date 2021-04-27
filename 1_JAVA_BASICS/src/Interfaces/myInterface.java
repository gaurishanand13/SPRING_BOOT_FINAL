package Interfaces;

/**
 * All the member functions in an interface should be always public as java doesn't support any other modifier for the functions in an interface.
 * Therefore default access modifier for an interface is public.
 * Other than public, you can also have default and static access modifier too --> For these modifiers we can even define the body of the function
 * inside the interface
 */
public interface myInterface {

    static int sum(int a, int b){
        return a + b;
    }

    default String getGreetingMsg(String name){
        return "Hello " + name;
    }

    int subtract(int a, int b);
}
