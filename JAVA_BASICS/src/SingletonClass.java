public class SingletonClass {

    private static SingletonClass singletonClassObject = null;

    // We have made the constructor private, so that no body can create a new object of this singleton class
    private SingletonClass(){}

    public static SingletonClass getInstance(){
        if(singletonClassObject == null){
            singletonClassObject = new SingletonClass();
        }
        return singletonClassObject;
    }

    public static void main(String[] args) {

    }

}