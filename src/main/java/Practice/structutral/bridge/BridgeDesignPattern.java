package Practice.structutral.bridge;

public class BridgeDesignPattern {

    public static void main(String[] args) {
        Color redColor= new RedColor();
        Color greenColor= new GreenColor();
        Shape shape1= new Circle(redColor);
        shape1.applyColor();
        Shape shape2= new Circle(greenColor);
        shape2.applyColor();

    }
}
interface Color{
    void applyColor();
}
abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape(Color c){
        this.color=c;
    }

    abstract public void applyColor();
}
class RedColor implements Color{

    @Override
    public void applyColor() {
        System.out.println("Red. ");
    }
}
class GreenColor implements Color{

    @Override
    public void applyColor() {
        System.out.println("Green. ");
    }
}
class Circle extends Shape{
    public Circle(Color c){
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle with Color ");
        color.applyColor();
    }

}
class Rectangle extends Shape{
    public Rectangle(Color c){
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Rectangle with Color ");
        color.applyColor();
    }

}