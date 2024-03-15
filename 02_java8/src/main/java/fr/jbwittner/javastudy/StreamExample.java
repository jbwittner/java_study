package fr.jbwittner.javastudy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class StreamExample {

    public static void main(String[] args) {
        wihtoutStream();
        withStream();
    }

    public static void wihtoutStream() {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        Iterator<Integer> it = entiers.iterator();
        long somme = 0;
        while (it.hasNext()) {
            int valeur = it.next();
            if (valeur < 10) {
                somme += valeur;
            }
        }
        System.out.println(somme);
    }

    public static void withStream() {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        LongAdder somme = new LongAdder();
        entiers.forEach(valeur -> {
            if (valeur < 10) {
                somme.add(valeur);
            }
        });
        System.out.println(somme);
    }
}
