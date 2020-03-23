package singleton;

//Singleton design
//Class is responsible for lifecycle
//static in nature
//Needs to be thread safe
//Private instance
//Private constructor
//No parameters required for construction
public class DbSingleton {

    //volatile made it thread safe
    private static volatile DbSingleton instance =null;

    //Private constructor so no one can create a instance of this class
    //This return just one instance
    //avoid reflection to avoid an instance of this class
    //It is not a good idea to made this sincronize in this methdo for performance issue
    // it is better to do in getInstance
    private DbSingleton(){
        if(instance != null){
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    //Get an instance of the singleton created
    public static DbSingleton getInstance(){
        //lazy loading this is for substance performance in the application
        if(instance == null){
            // sincronize, and performance we need to be sure it will do only the first time
            //thread safe
            synchronized (DbSingleton.class){
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }

        }
        return  instance;
    }

}
