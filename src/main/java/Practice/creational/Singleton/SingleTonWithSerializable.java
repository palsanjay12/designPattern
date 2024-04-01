package Practice.creational.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingleTonWithSerializable {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
//        singleton.setValue(1);

        // Serialize
        try {
            FileOutputStream fileOut = new FileOutputStream("out.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        singleton.setValue(2);

        // Deserialize
        Singleton singleton2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("out.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton2 = (Singleton) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

//        System.out.println(singleton.getValue());
//        System.out.println(singleton2.getValue());

    }

}
class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.INSTANCE;

        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Singleton singleton2 = (Singleton) constructor.newInstance();

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

//        singleton.setValue(1);
//        singleton2.setValue(2);

//        System.out.println(singleton.getValue());
//        System.out.println(singleton2.getValue());

    }
}
class Singleton implements Serializable {

    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    protected Object readResolve() {
        return INSTANCE;
    }

}