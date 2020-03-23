package singleton;

public class DbSingletonDemo {

    public static void main(String[] args) {
        DbSingleton instance = DbSingleton.getInstance();
        System.out.println(instance);

        //if you try to create another instance, it will return the same one always
        DbSingleton anotherInstance = DbSingleton.getInstance();
        System.out.println(anotherInstance);
    }

}
