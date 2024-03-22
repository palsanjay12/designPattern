package structuralDesignPattern;

public class DecoratorDesignPattern {
    public static void main(String[] args)
    {
        // Creating an object of Shape interface
        // inside the main() method
        Shape circle = new Circle();

        Shape redCircle
                = new RedShapeDecorator(new Circle());

        Shape redRectangle
                = new RedShapeDecorator(new Rectangle());

        // Display message
        System.out.println("Circle with normal border");

        // Calling the draw method over the
        // object calls as created in
        // above classes

        // Call 1
        circle.draw();

        // Display message
        System.out.println("\nCircle of red border");

        // Call 2
        redCircle.draw();

        // Display message
        System.out.println("\nRectangle of red border");

        // Call 3
        redRectangle.draw();
    }
}
interface Shape {

    // Method inside interface
    void draw();
}
class Circle implements Shape {

    @Override
    public void draw()
    {
        System.out.println("Shape: Circle");
    }
}
class Rectangle implements Shape {

    @Override
    public void draw()
    {
        System.out.println("Shape: Rectangle");
    }
}
abstract class ShapeDecorator implements Shape {

    // Protected variable
    protected Shape decoratedShape;

    // Method 1
    // Abstract class method
    public ShapeDecorator(Shape decoratedShape)
    {
        // This keywordd refers to current object itself
        this.decoratedShape = decoratedShape;
    }

    // Method 2 - draw()
    // Outside abstract class
    public void draw() { decoratedShape.draw(); }
}
 class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape)
    {
        super(decoratedShape);
    }

    @Override public void draw()
    {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape)
    {
        // Display message whenever function is called
        System.out.println("Border Color: Red");
    }
}