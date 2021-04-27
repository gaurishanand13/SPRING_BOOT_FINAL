package Inheritence;

import Interfaces.myInterface;

import java.util.List;

public class parentClass extends childClass implements myInterface {

    public parentClass(int age, String name, Double marks, List<String> mobiles) {
        super(age, name, marks, mobiles);
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }


}
