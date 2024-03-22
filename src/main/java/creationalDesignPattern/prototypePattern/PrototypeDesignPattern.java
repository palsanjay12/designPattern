package creationalDesignPattern.prototypePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        SheepCache sheepRegistory= new SheepCache();
        Map<String,Sheep> cache= sheepRegistory.getSheepCache();
        ArrayList<Sheep> list= new ArrayList<>();
        for(Map.Entry<String,Sheep> entry: cache.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue().getName()+" "+ entry.getValue().hashCode());

           list.add(entry.getValue().clone());

        }
        list.forEach(l->{
            System.out.println(l.getName()+" "+ l.hashCode());
        });

    }
}
class SheepCache{
    private Map<String,Sheep> cache= new HashMap<>();
    public Map<String,Sheep> getSheepCache(){
        return cache;
    }
    public SheepCache(){
        Sheep sheep1= new BlackSheep("black sheep");
        Sheep sheep2= new WhiteSheep("white sheep");

        cache.put("sheep1",sheep1);
        cache.put("sheep2",sheep2);

    }
}
 interface Sheep {
    Sheep clone();
    String getName();
    void setName(String name);
}
 class BlackSheep implements Sheep {
    private String name;

    public BlackSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
 class WhiteSheep implements Sheep {
    private String name;

    public WhiteSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new WhiteSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
