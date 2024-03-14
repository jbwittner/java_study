package fr.jbwittner.javastudy;

public class ObjectExample {

    public static void main(String[] args) {
        classVariable();
        thisKeyword();
        instanceOfTest();
        equalityTest();
    }

    // Demonstrates the use of class (static) variables
    public static void classVariable() {
        MyClassOne m = new MyClassOne();
        int counter1 = m.counter;
        int counter2 = MyClassOne.counter;
        System.out.println(counter1 == counter2); // should always print true because counter is static
    }

    // Demonstrates the use of 'this' keyword
    public static void thisKeyword() {
        MyClassTwo m = new MyClassTwo(10);
        m.printNumber();
    }

    // Demonstrates the use of instanceof to check object types
    public static void instanceOfTest() {
        MyClassOne m1 = new MyClassOne();
        checkClass(m1);

        MyClassThree m3 = new MyClassThree();
        checkClass(m3);
    }

    // Helper method to check if an object is an instance of MyClassThree
    public static void checkClass(Object o) {
        if (o instanceof MyClassThree) System.out.println("o is an instance of MyClassThree");
        else System.out.println("o is not an object of MyClassThree");
    }

    // Demonstrates object equality
    public static void equalityTest() {
        MyClassTwo m1 = new MyClassTwo(10);
        MyClassTwo m2 = new MyClassTwo(10);
        System.out.println(m1 == m2); // false, because == compares references
        System.out.println(m1.equals(m2)); // true, because equals is overridden to compare values
    }
}

// Class demonstrating a static class variable
class MyClassOne {
    static int counter = 0;
}

// Class demonstrating use of 'this' and object equality
class MyClassTwo {
    private int number;

    public MyClassTwo(int number) {
        this.number = number; // Assigning the class variable with the constructor parameter
    }

    public void printNumber() {
        System.out.println(this.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyClassTwo other = (MyClassTwo) obj;
        return number == other.number;
    }
}

// Class demonstrating simple use of a class variable
class MyClassThree {
    String string = "test";

    public String getString() {
        return string;
        // Equivalent to: return this.string;
    }
}
