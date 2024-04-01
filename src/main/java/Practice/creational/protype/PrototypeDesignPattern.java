package Practice.creational.protype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        PrototypeMethod prototypeMethod= new PrototypeMethod();
        Map<String,GameObject> cache= prototypeMethod.getCache();
        GameObject gameObject1= cache.get("Person");
        System.out.println(gameObject1.hashCode());
        System.out.println("cloned:"+ gameObject1.clone().hashCode());
        GameObject gameObject2= cache.get("Vehicle");
        System.out.println(gameObject2.hashCode());
        System.out.println("cloned:"+ gameObject2.clone().hashCode());


    }
}
class PrototypeMethod{
    Map<String,GameObject> cache= new HashMap<>();
    public  Map<String,GameObject> getCache(){
        return cache;
    }
    public PrototypeMethod(){
        GameObject per= new Person("This is Person");
        GameObject veh= new Person("This is Vehicle");
        cache.put("Person",per);
        cache.put("Vehicle",veh);
    }
}
interface GameObject {
    GameObject clone();
}
class Person implements GameObject{
    String property;
    public Person(String property){
        this.property=property;
    }

    @Override
    public GameObject clone() {
        Person cloned= new Person(this.property);
        return cloned;
    }
}
class Vehicle implements GameObject{
    String property;
    public Vehicle(String property){
        this.property=property;
    }

    @Override
    public GameObject clone() {
        Vehicle cloned= new Vehicle(this.property);
        return cloned;
    }
}
