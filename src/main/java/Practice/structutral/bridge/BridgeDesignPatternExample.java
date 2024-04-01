package Practice.structutral.bridge;

public class BridgeDesignPatternExample {
    public static void main(String[] args) {
        LivingThings fish= new Fish(new WaterBreatheImpl());
        fish.breatheProcess();
    }
}
interface Breathe{
    public void breathe();
}
class WaterBreatheImpl implements Breathe{

    @Override
    public void breathe() {
        System.out.print("breathing in water.");
    }
}
class SoilBreatheImpl implements Breathe{

    @Override
    public void breathe() {
        System.out.print("breathing on Soil.");
    }
}
abstract class LivingThings {
    Breathe breathe;
    public LivingThings(Breathe breathe){
        this.breathe=breathe;
    }
     abstract void breatheProcess();
}

class Dog extends LivingThings{
    public Dog(Breathe breathe){
        super(breathe);
    }

    @Override
    void breatheProcess() {
        System.out.println("DOG ");

        breathe.breathe();
    }
}
class Fish extends LivingThings{
    public Fish(Breathe breathe){
        super(breathe);
    }

    @Override
    void breatheProcess() {
        System.out.print("Fish ");
        breathe.breathe();
    }
}