package abstractClasses;

public class abstractClassDemo extends abstractClass {

    @Override
    public int durability(String type, int years) {
        return 0;
    }

    @Override
    public int calculateSpeed(int milage, int cc) {
        return super.calculateSpeed(milage, cc);
    }

    public static void main(String[] args) {

        abstractClassDemo o = new abstractClassDemo(); // Note - we can't create the object of an abstract class

    }
}
