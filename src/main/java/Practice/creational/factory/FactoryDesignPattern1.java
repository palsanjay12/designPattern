package Practice.creational.factory;

public class FactoryDesignPattern1 {
    public static void main(String[] args) {
        FactoryMethod factoryMethod= new FactoryMethod();
        Shape circle= factoryMethod.getShape("Circle");
        circle.draw();
        Shape rectangle= factoryMethod.getShape("Rectangle");
        rectangle.draw();
    }

}
class FactoryMethod{
    public Shape getShape(String type){
        if("Circle".equals(type))
            return new Circle();
        else  if("Rectangle".equals(type))
            return new Rectangle();
        else return null;
    }
}
interface Shape{
    void draw();
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing Circle");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing Rectangle");
    }
}

