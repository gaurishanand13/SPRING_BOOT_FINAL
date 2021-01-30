package Inheritence;

import java.util.List;

public class parentClass extends childClass implements myInheritence {

    public parentClass(int age, String name, Double marks, List<String> mobiles) {
        super(age, name, marks, mobiles);
    }

    @Override
    public void sum(int a, int b) {
        int c = a+b;
    }
}
