package fr.jbwittner.javastudy;

// Interface for drawable shapes
interface Drawable {
    // Method to draw the shape
    void draw();

    // Default method in the interface to display the type of shape
    default void displayType() {
        System.out.println("This is a geometric shape.");
    }
}

// Abstract class representing a general form/shape
abstract class Shape implements Drawable {

    // Abstract method to calculate the area of the shape
    public abstract double area();

    // Abstract method to calculate the perimeter of the shape
    public abstract double perimeter();

    // Static method to demonstrate static behavior in inheritance
    public static void myMethod() {
        System.out.println("Shape");
    }

    // Static method calling another static method within the hierarchy
    public static void myOtherMethod() {
        myMethod();
    }

    // Method to display details of the shape including area and perimeter
    public void displayDetails() {
        System.out.println("Shape details:");
        System.out.println("Area: " + this.area());
        System.out.println("Perimeter: " + this.perimeter());
        this.draw(); // This method also draws the shape
    }
}

// Circle class extending the Shape abstract class
class Circle extends Shape {
    private double radius;
    private static final double CONST_PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Circle.CONST_PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Circle.CONST_PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    @Override
    public void displayType() {
        System.out.println("This is a circle.");
    }

    public static void myMethod() {
        System.out.println("Circle");
    }
}

// Rectangle class extending the Shape abstract class
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of length " + length + " and width " + width);
    }
}

// Interface representing additional geometric properties or methods
interface Geometric {
    // Example method for demonstration purposes
    void geometricDemo();
}

// Interface for comparing areas of shapes
interface ComparableShape {
    // Method to compare the area of this shape with another shape
    int compareAreaWith(Shape otherShape);
}

// Triangle class extending Shape and implementing Geometric and ComparableShape interfaces
class Triangle extends Shape implements Geometric, ComparableShape {
    private double sideA; // Length of side A
    private double sideB; // Length of side B
    private double sideC; // Length of side C

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Implementation of the area method using Heron's formula
    @Override
    public double area() {
        double semiPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    // Implementation of the perimeter method
    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    // Implementation of the draw method
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with sides of length " + sideA + ", " + sideB + ", and " + sideC);
    }

    // Overriding the displayType method to specify that it is a triangle
    @Override
    public void displayType() {
        System.out.println("This is a triangle.");
    }

    // Implementation of the geometricDemo method from the Geometric interface
    @Override
    public void geometricDemo() {
        System.out.println("Demonstrating specific geometric properties of a triangle.");
    }

    // Implementation of the compareAreaWith method from the ComparableShape interface
    @Override
    public int compareAreaWith(Shape otherShape) {
        double otherShapeArea = otherShape.area();
        double thisShapeArea = this.area();
        return Double.compare(thisShapeArea, otherShapeArea);
    }
}

// Main class for demonstrating the use of shapes
public class Inheritance {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 20);
        Triangle triangle = new Triangle(5, 13, 12);
        Shape hexagon = new Shape() {
            private double side = 6.0; // Length of a side of the hexagon

            @Override
            public double area() {
                // Formula for the area of a regular hexagon: (3 * sqrt(3) / 2) * (side * side)
                return (3 * Math.sqrt(3) / 2) * (side * side);
            }

            @Override
            public double perimeter() {
                // The perimeter of a regular hexagon is simply 6 times the length of a side
                return 6 * side;
            }

            @Override
            public void draw() {
                System.out.println("Drawing a hexagon with a side length of " + side);
            }
        };

        System.out.println("\n--- Shape Examples ---\n");

        System.out.println("Area of the circle: " + circle.area());
        System.out.println("Perimeter of the circle: " + circle.perimeter());
        System.out.println("Area of the rectangle: " + rectangle.area());
        System.out.println("Perimeter of the rectangle: " + rectangle.perimeter());
        System.out.println("Area of the triangle: " + triangle.area());
        System.out.println("Perimeter of the triangle: " + triangle.perimeter());
        System.out.println("Area of the hexagon: " + hexagon.area());
        System.out.println("Perimeter of the hexagon: " + hexagon.perimeter());

        // Display details and types of shapes
        System.out.println("\n--- Displaying Details and Types ---\n");

        rectangle.displayDetails();
        circle.displayDetails();
        triangle.displayDetails();
        hexagon.displayDetails();

        rectangle.displayType();
        circle.displayType();
        triangle.displayType();
        hexagon.displayType();

        // Geometric demonstration and area comparison
        System.out.println("\n--- Geometric Demonstration and Area Comparison ---\n");

        triangle.geometricDemo();
        System.out.println("Comparing area of triangle with circle: " + triangle.compareAreaWith(circle));

        // Static method demonstrations
        System.out.println("\n--- Static Method Demonstrations ---\n");

        Rectangle.myMethod();
        Rectangle.myOtherMethod();
        Circle.myMethod();
        Circle.myOtherMethod();
        Triangle.myMethod();
        Triangle.myOtherMethod();
    }
}
