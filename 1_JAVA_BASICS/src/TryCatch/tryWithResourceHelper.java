package TryCatch;

/**
 * If a class has its parent class as autoclosable, then it will be useful when we declare the objects of this class in try with resouce parameter.
 * Whenever the try/catch function ends where its object was declared in the prototype, always the close function for that object will be called.
 * we can always de-allocate the memory allocated to that object in try/catch using this and will not have to allocate it explicitly there only.
 */
public class tryWithResourceHelper implements AutoCloseable{

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        throw new ArithmeticException();
    }

    // This function will be called everytime automatically after the try/catch block ends if the object of this class is declared in try catch paramter.
    @Override
    public void close() throws Exception {
        System.out.println("Making object null here!!");
    }
}
