package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForLoop {

    public static void main(String[] args) {
        demonstrateSimpleLoop();
        demonstrateComplexCondition();
        demonstrateBooleanControl();
        demonstrateEnhancements();
    }

    // Demonstrates a simple for-loop with a single variable
    public static void demonstrateSimpleLoop() {
        System.out.println("Simple Loop Example:");
        for (int i = 1; i < 4; i++) {
            System.out.println("Iteration: " + i);
        }
        System.out.println(); // Adding a line break for readability
    }

    // Demonstrates a for-loop with multiple variables and a complex condition
    public static void demonstrateComplexCondition() {
        System.out.println("Complex Condition Example:");
        for (int i = 0, j = 0; i * j < 1000; i++, j += 2) {
            System.out.println("i: " + i + " - j: " + j);
        }
        System.out.println(); // Adding a line break for readability
    }

    // Demonstrates a for-loop controlled by a boolean flag
    public static void demonstrateBooleanControl() {
        System.out.println("Boolean Control Example:");
        boolean found = false;
        for (int i = 0; !found; i++) {
            if (i >= 10) {
                found = true;
                System.out.println("Reached i >= 10, setting found to true.");
            }
        }
        System.out.println("Condition met, exiting loop.");
        System.out.println(); // Adding a line break for readability
    }

    // Demonstrates various enhancements and iterations over collections and arrays
    public static void demonstrateEnhancements() {
        System.out.println("Enhancements Example:");

        // Demonstrating iteration over a List with an Iterator
        List<Integer> listData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listData.add(i);
        }

        System.out.println("Iterating over List with an Iterator:");
        for (Iterator<Integer> iter = listData.iterator(); iter.hasNext(); ) {
            System.out.println("List element: " + iter.next());
        }

        // Demonstrating iteration with an enhanced for-loop over a List
        System.out.println("Iterating over List with an enhanced for-loop:");
        for (Integer element : listData) {
            System.out.println("List element: " + element);
        }

        // Demonstrating iteration over an array with an enhanced for-loop
        int[] arrayData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Iterating over array with an enhanced for-loop:");
        for (int element : arrayData) {
            System.out.println("Array element: " + element);
        }
    }
}
