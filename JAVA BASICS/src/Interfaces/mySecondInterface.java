package Interfaces;

public interface mySecondInterface {
    default String getGreetingMsg(String name){
        return "Hello " + name;
    }
}
