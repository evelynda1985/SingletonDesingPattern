public class Main {

    public static void main(String[] args) {

        //Singleton design
        //Class is responsible for lifecycle
        //static in nature
        //Needs to be thread safe
        //Private instance
        //Private constructor
        //No parameters required for construction
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc();
        System.out.println(singletonRuntime);
        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance);

        if(singletonRuntime == anotherInstance){
            System.out.println("They are the same instance");
        }
    }

    //Pitfalls
    //Ofter overused
    // difficult to unit test
    // if not careful, it is not thread safe
    // sometimes confused for Factory
    //java.util.Calendar is not a singletorn is a prototype

}
