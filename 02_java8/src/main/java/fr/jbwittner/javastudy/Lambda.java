package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lambda {

    // Functional interfaces to support lambda expressions in this example.
    interface Drawable {
        void draw();
    }

    interface Sayable {
        String say();
    }

    interface SayableParameter {
        String say(String name);
    }

    interface Addable {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println("Starting withoutLambda example.");
        withoutLambda();
        System.out.println("Starting withLambda example.");
        withLambda();
        System.out.println("Starting noParameter example.");
        noParameter();
        System.out.println("Starting singleParameter example.");
        singleParameter();
        System.out.println("Starting multipleParameters example.");
        multipleParameters();
        System.out.println("Starting comparator example.");
        comparator();
        System.out.println("Starting filter example.");
        filter();
    }

    // Demonstrates the use of an anonymous class instead of a lambda expression.
    public static void withoutLambda() {
        int width = 10;
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing " + width + " with anonymous class.");
            }
        };
        d.draw();
    }

    // Demonstrates the use of a lambda expression for a functional interface.
    public static void withLambda() {
        int width = 10;
        Drawable d2 = () -> System.out.println("Drawing " + width + " with lambda.");
        d2.draw();
    }

    // Demonstrates a lambda expression with no parameters.
    public static void noParameter() {
        Sayable s = () -> "I have nothing to say.";
        System.out.println(s.say());
    }

    // Demonstrates a lambda expression with a single parameter.
    public static void singleParameter() {
        SayableParameter s1 = (name) -> "Hello, " + name;
        System.out.println(s1.say("Sonoo"));
    }

    // Demonstrates lambda expressions with multiple parameters.
    public static void multipleParameters() {
        Addable ad1 = (a, b) -> a + b;
        System.out.println("Adding (10 + 20): " + ad1.add(10, 20));

        Addable ad2 = (a, b) -> (a + b);
        System.out.println("Adding (100 + 200): " + ad2.add(100, 200));
    }

    // Demonstrates sorting with a lambda expression.
    public static void comparator() {
        class Product {
            int id;
            String name;
            float price;

            public Product(int id, String name, float price) {
                this.id = id;
                this.name = name;
                this.price = price;
            }
        }

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "HP Laptop", 25000f));
        list.add(new Product(3, "Keyboard", 300f));
        list.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting on the basis of name...");
        Collections.sort(list, (p1, p2) -> p1.name.compareTo(p2.name));
        list.forEach(p -> System.out.println(p.id + " " + p.name + " " + p.price));
    }

    // Demonstrates filtering with a lambda expression.
    public static void filter() {
        class Product {
            int id;
            String name;
            float price;

            public Product(int id, String name, float price) {
                this.id = id;
                this.name = name;
                this.price = price;
            }
        }

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Samsung A5", 17000f));
        list.add(new Product(3, "Iphone 6S", 65000f));
        list.add(new Product(2, "Sony Xperia", 25000f));
        list.add(new Product(4, "Nokia Lumia", 15000f));
        list.add(new Product(5, "Redmi4 ", 26000f));
        list.add(new Product(6, "Lenovo Vibe", 19000f));

        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);
        filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));
    }
}
