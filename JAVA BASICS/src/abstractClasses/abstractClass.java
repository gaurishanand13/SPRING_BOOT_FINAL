package abstractClasses;

public abstract class abstractClass {
    public int calculateSpeed(int milage, int cc){
        return milage * 100 + cc;
    }

    public abstract int durability(String type, int years);
}
