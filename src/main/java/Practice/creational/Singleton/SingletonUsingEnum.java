package Practice.creational.Singleton;

public class SingletonUsingEnum {
    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        singleton.setName("sanjay");
        System.out.println(singleton.getValue());
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());


    }
}
 enum SingletonEnum {
    INSTANCE;

    int value;
    String name;

    public int getValue() {
        return value;
    }
    public void setName(String name){
        this.name=name;
    }
     public String getName(){
        return name;
     }

    public void setValue(int value) {
        this.value = value;
    }
}