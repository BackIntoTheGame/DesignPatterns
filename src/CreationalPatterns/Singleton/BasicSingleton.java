package CreationalPatterns.Singleton;

public class BasicSingleton {
    private BasicSingleton(){}

    private static final BasicSingleton INSTANCE
            = new BasicSingleton();

    public static  BasicSingleton getInstance(){
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Demo{
    public static void main(String[] args) {
        BasicSingleton singleton = BasicSingleton.getInstance();

        singleton.setValue(123);
        System.out.println(singleton.getValue());
    }
}
