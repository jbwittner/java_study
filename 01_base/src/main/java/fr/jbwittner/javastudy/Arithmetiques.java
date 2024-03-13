package fr.jbwittner.javastudy;

public class Arithmetiques {

    public static void main(String args[]) {
        operationArithmetique();
        incrementation();
        decrementation();
        incrementationPrefixeesPosfixees();
    }

    public static void operationArithmetique() {
        short x = 5, y = 15;
        x = (short) (x + y);
        System.out.println("x = (short) (x + y) : " + x);
    }

    public static void incrementation() {
        short x = 5;

        System.out.println("x++ (before) : " + x);
        System.out.println("x++ : " + x++);
        System.out.println("x++ (after) : " + x);
        // est équivalent à
        // System.out.println(x); x = x + 1;

        x = 5;

        System.out.println("++x (before) : " + x);
        System.out.println("++x : " + ++x);
        System.out.println("++x (before) : " + x);
        // est équivalent à
        // x = x + 1; System.out.println(x);

    }

    public static void decrementation() {
        short x = 5;

        System.out.println("x-- (before) : " + x);
        System.out.println("x-- : " + x--);
        System.out.println("x-- (after) : " + x);
        // est équivalent à
        // System.out.println(x); x = x - 1;

        x = 5;

        System.out.println("--x (before) : " + x);
        System.out.println("--x : " + --x);
        System.out.println("--x (before) : " + x);
        // est équivalent à
        // x = x - 1; System.out.println(x);
    }

    public static void incrementationPrefixeesPosfixees() {
        int n1 = 0;
        int n2 = 0;
        System.out.println("n1 = " + n1 + " n2 = " + n2);
        n1 = n2++;
        System.out.println("n1 = " + n1 + " n2 = " + n2);
        n1 = ++n2;
        System.out.println("n1 = " + n1 + " n2 = " + n2);
        n1 = n1++; // attention
        System.out.println("n1 = " + n1 + " n2 = " + n2);
    }
}
