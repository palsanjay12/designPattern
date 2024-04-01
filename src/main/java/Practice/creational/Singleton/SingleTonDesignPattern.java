package Practice.creational.Singleton;

import java.lang.reflect.Constructor;

public class SingleTonDesignPattern {
    public static void main(String[] args) {
        SingleTonClass1 ins1= SingleTonClass1.getInstnace();
        SingleTonClass1 ins2= SingleTonClass1.getInstnace();
        SingleTonClass1 ins3= SingleTonClass1.getInstnace();
        SingleTonClass1 ins4= null;
        System.out.println(ins1.hashCode());
        System.out.println(ins2.hashCode());
        System.out.println(ins3.hashCode());

        try {
            Constructor[] constructors = SingleTonClass1.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // This code will destroy the singleton pattern
                constructor.setAccessible(true);
                ins4 = (SingleTonClass1) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ins4.hashCode());
    }
}
class SingleTonClass1{
   static SingleTonClass1 singleTonClass = null;
   int counter=0;
    private SingleTonClass1(){

    }
    public static SingleTonClass1 getInstnace() {
        if (singleTonClass == null) {
            System.out.println("creating single object");
            singleTonClass = new SingleTonClass1();
        }
        return singleTonClass;
    }
    public static SingleTonClass1 getInstanceUsingDoubleLocking() {
        if (singleTonClass == null) {
            synchronized (SingleTonClass1.class) {
                if (singleTonClass == null) {
                    singleTonClass = new SingleTonClass1();
                }
            }
        }
        return singleTonClass;
    }

}
