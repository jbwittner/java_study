package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Demonstrates the usage of generics in Java.
public class Generic {

    public static void main(String[] args) {
        System.out.println("--- Without Generic ---");
        withoutGeneric();

        System.out.println("\n--- With Generic ---");
        withGeneric();

        System.out.println("\n--- Generic Example ---");
        genericExample();

        System.out.println("\n--- Interface Constraint Example ---");
        interfaceConstraintExample();

        System.out.println("\n--- Complex Generic Example ---");
        complexGeneric();
    }

    // Demonstrates a list without using generics.
    public static void withoutGeneric() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String value = Integer.toString(i);
            list.add(value);
        }

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String value = (String) iter.next();
            System.out.println(value.toUpperCase());
        }
    }

    // Demonstrates a list with generics for type safety.
    public static void withGeneric() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String value = Integer.toString(i);
            list.add(value);
        }

        for (String value : list) {
            System.out.println(value.toUpperCase());
        }
    }

    // Shows how to use generic classes.
    public static void genericExample() {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.add(10);
        System.out.println("Integer Value: " + integerBox.get());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.add("Hello Generics");
        System.out.println("String Value: " + stringBox.get());

        GenericPair<String, Integer> pair = new GenericPair<>("Age", 25);
        System.out.println("GenericPair: " + pair.getKey() + " = " + pair.getValue());

        boolean isEqual = GenericMethod.compare(pair, new GenericPair<>("Age", 25));
        System.out.println("GenericPair isEqual: " + isEqual);
    }

    // Demonstrates the use of interface constraints in generics.
    public static void interfaceConstraintExample() {
        DisplayBox<DisplayableString> box = new DisplayBox<>();
        box.add(new DisplayableString("Hello, Interface Constraint!"));
        box.displayItem();
    }

    // Demonstrates a more complex use of generics.
    public static void complexGeneric() {
        ComplexGeneric<String, Integer, String> example = new ComplexGeneric<>("Key", 42, "Value");
        System.out.println(example);

        ComplexGeneric<Integer, String, String> anotherExample = new ComplexGeneric<>(1, "Hello", "World");
        System.out.println(anotherExample);
    }
}

// A generic class to hold a single value of any type.
class GenericBox<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

// A generic class to hold a pair of values of any types.
class GenericPair<K, V> {
    private K key;
    private V value;

    public GenericPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// A generic method to compare two GenericPair objects for equality.
class GenericMethod {
    public static <K, V> boolean compare(GenericPair<K, V> p1, GenericPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

// An interface for objects that can be displayed.
interface Displayable {
    void display();
}

// A generic class that can hold and display any Displayable object.
class DisplayBox<T extends Displayable> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public void displayItem() {
        item.display();
    }
}

// Implementation of Displayable for strings.
class DisplayableString implements Displayable {
    private String content;

    public DisplayableString(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + content);
    }
}

// A generic class that associates a key with a pair of values.
class ComplexGeneric<K, V, T> {
    private K key;
    private GenericPair<V, T> pair;

    public ComplexGeneric(K key, V first, T second) {
        this.key = key;
        this.pair = new GenericPair<>(first, second);
    }

    public K getKey() {
        return key;
    }

    public GenericPair<V, T> getGenericPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + pair;
    }
}
