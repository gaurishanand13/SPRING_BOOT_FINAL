package AbstractClasses;

// This is an abstract class as it has an abstract function. Therefore if a class extends
public abstract class myAbstractClass {
    public int calculateSpeed(int milage, int cc){
        return milage * 100 + cc;
    }

    public abstract int durability(String type, int years);
}

