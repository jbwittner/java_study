package fr.jbwittner.javastudy;

public class Conditions {

    public static void main(String[] args) {
        ifCondition(); // Demonstration of if-else condition
        ternaryOperation(); // Demonstration of ternary operation
        switchTest(); // Demonstration of switch case and enhanced switch case
    }

    // Demonstrates the use of if-else to check if a number is even or odd
    public static void ifCondition() {
        isEven(2); // Checking if 2 is even
        isEven(3); // Checking if 3 is odd
    }

    // Checks if the given value is even or odd and prints the result
    public static void isEven(int value) {
        if (value % 2 == 0) {
            System.out.println(value + " is even");
        } else {
            System.out.println(value + " is odd");
        }
    }

    // Demonstrates the use of a ternary operation to assign values
    public static void ternaryOperation() {
        int level = 5;

        // Equivalent to int total = (level == 5) ? 10 : 5;
        int total;
        if (level == 5) total = 10;
        else total = 5;

        System.out.println("ternary - total: " + total);

        // Using ternary operator directly
        int total2 = (level == 5) ? 10 : 5;

        System.out.println("ternary - total2: " + total2);
    }

    // Demonstrates the use of switch case to return Boolean values based on string input
    public static void switchTest() {
        System.out.println("switchTest - getResponse('yes'): " + getResponse("yes"));
        System.out.println("switchTest - getResponse('no'): " + getResponse("no"));
        System.out.println("switchTest - getResponse('yEs'): " + getResponse("yEs"));
        System.out.println("switchTest - getEnhancedResponse('yEs'): " + getEnhancedResponse("yEs"));
    }

    // Returns true for "yes", false for "no", and null for any other input (case-sensitive)
    public static Boolean getResponse(String response) {
        Boolean result = null;
        switch (response) {
            case "yes":
            case "Yes":
                result = true;
                break;
            case "no":
            case "No":
                result = false;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    // Enhanced version of getResponse that is case-insensitive
    public static Boolean getEnhancedResponse(String response) {
        Boolean result = null;

        switch (response.toLowerCase()) {
            case "yes":
                result = true;
                break;
            case "no":
                result = false;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
}
