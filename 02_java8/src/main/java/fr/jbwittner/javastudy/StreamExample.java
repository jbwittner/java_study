package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class StreamExample {

    // Main method demonstrating various examples of using streams and without using streams.
    public static void main(String[] args) {
        System.out.println("Calculating sum without Stream.");
        withoutStream();
        System.out.println("Calculating sum with forEach loop and LongAdder.");
        withStream();
        System.out.println("Calculating sum with Stream.");
        withAnotherStream();
        System.out.println("Calculating average weight without Stream.");
        collectionWithoutStream();
        System.out.println("Calculating average weight with Stream.");
        collectionWithStream();
    }

    // Method to calculate sum of integers less than 10 without using streams.
    public static void withoutStream() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        Iterator<Integer> iterator = integers.iterator();
        long sum = 0;
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value < 10) {
                sum += value;
            }
        }
        System.out.println("Sum without stream: " + sum);
    }

    // Method to calculate sum of integers less than 10 using forEach and LongAdder.
    public static void withStream() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        LongAdder sum = new LongAdder();
        integers.forEach(value -> {
            if (value < 10) {
                sum.add(value);
            }
        });
        System.out.println("Sum with forEach and LongAdder: " + sum);
    }

    // Method to calculate sum of integers less than 10 using stream.
    public static void withAnotherStream() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        long sum = integers.stream().filter(v -> v < 10).mapToInt(i -> i).sum();
        System.out.println("Sum with stream: " + sum);
    }

    // Method to calculate the average weight of females without using streams.
    public static void collectionWithoutStream() {

        class Person {
            private String point;
            private String gender;
            private Integer weight;

            public Person(String point, String gender, Integer weight) {
                this.point = point;
                this.gender = gender;
                this.weight = weight;
            }

            public Integer getWeight() {
                return weight;
            }

            public String getGender() {
                return gender;
            }
        }

        List<Person> people = new ArrayList<>(6);
        people.add(new Person("p1", "MALE", 176));
        people.add(new Person("p2", "MALE", 190));
        people.add(new Person("p3", "FEMALE", 172));
        people.add(new Person("p4", "FEMALE", 162));
        people.add(new Person("p5", "MALE", 176));
        people.add(new Person("p6", "FEMALE", 168));

        long total = 0;
        int count = 0;
        for (Person person : people) {
            if ("FEMALE".equals(person.getGender())) {
                count++;
                total += person.getWeight();
            }
        }
        double average = (double) total / count;
        System.out.println("Average weight of females without stream: " + average);
    }

    // Method to calculate the average weight of females using streams.
    public static void collectionWithStream() {

        class Person {
            private String point;
            private String gender;
            private Integer weight;

            public Person(String point, String gender, Integer weight) {
                this.point = point;
                this.gender = gender;
                this.weight = weight;
            }

            public Integer getWeight() {
                return weight;
            }

            public String getGender() {
                return gender;
            }
        }

        List<Person> people = new ArrayList<>(6);
        people.add(new Person("p1", "MALE", 176));
        people.add(new Person("p2", "MALE", 190));
        people.add(new Person("p3", "FEMALE", 172));
        people.add(new Person("p4", "FEMALE", 162));
        people.add(new Person("p5", "MALE", 176));
        people.add(new Person("p6", "FEMALE", 168));

        double average = people.stream()
                .filter(p -> "FEMALE".equals(p.getGender()))
                .mapToInt(Person::getWeight)
                .average()
                .orElse(Double.NaN);
        System.out.println("Average weight of females with stream: " + average);
    }
}
