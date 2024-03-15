package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda {

    interface Drawable {
        public void draw();
    }

    interface Sayable {
        public String say();
    }

    interface SayableParmeter {
        public String say(String name);
    }

    interface Addable {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        withoutLambda();
        withLambda();
        noParamater();
        singleParameter();
        mulitpleParameters();
        comparator();
    }

    public static void withoutLambda() {
        int width = 10;

        // without lambda, Drawable implementation using anonymous class
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing " + width);
            }
        };
        d.draw();
    }

    public static void withLambda() {
        int width = 10;

        // with lambda
        Drawable d2 = () -> {
            System.out.println("Drawing " + width);
        };
        d2.draw();
    }

    public static void noParamater() {
        Sayable s = () -> {
            return "I have nothing to say.";
        };
        System.out.println(s.say());
    }

    public static void singleParameter() {
        // Lambda expression with single parameter.
        SayableParmeter s1 = (name) -> {
            return "Hello, " + name;
        };
        System.out.println(s1.say("Sonoo"));

        // You can omit function parentheses
        SayableParmeter s2 = name -> {
            return "Hello, " + name;
        };
        System.out.println(s2.say("Sonoo"));
    }

    public static void mulitpleParameters() {

        // Lambda expression without return keyword.
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        // Lambda expression with return keyword.
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(ad2.add(100, 200));
    }

    public static void forEachLoop() {

        List<String> list = new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach((n) -> System.out.println(n));
    }

    public static void comparator() {

        class Product {
            int id;
            String name;
            float price;

            public Product(int id, String name, float price) {
                super();
                this.id = id;
                this.name = name;
                this.price = price;
            }
        }

        List<Product> list = new ArrayList<Product>();

        // Adding Products
        list.add(new Product(1, "HP Laptop", 25000f));
        list.add(new Product(3, "Keyboard", 300f));
        list.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(list, (p1, p2) -> {
            return p1.name.compareTo(p2.name);
        });
        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " " + p.price);
        }
    }
}
