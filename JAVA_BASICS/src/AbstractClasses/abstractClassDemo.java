package AbstractClasses;


public class abstractClassDemo extends myAbstractClass{

    @Override
    public int durability(String type, int years) {
        return 0;
    }

    // If we won't override this function, then also it won't be an error as it is already implemented in the parent class
    @Override
    public int calculateSpeed(int milage, int cc) {
        return super.calculateSpeed(milage, cc);
    }

    public static void main(String[] args) {

        // abstractClassDemo o1 = new myAbstractClass(); --> It is an error as we can't create the object of abstract class.
        abstractClassDemo o2 = new abstractClassDemo(); // Note - we can create the object of an this class as it not an abstract class
    }
}
