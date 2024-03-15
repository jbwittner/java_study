package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class StreamExample {

    public static void main(String[] args) {
        wihtoutStream();
        withStream();
        withAnotherStream();
        collectionWithoutStream();
        collectionWithStream();
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

    public static void withAnotherStream() {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        long somme = entiers.stream().filter(v -> v < 10).mapToInt(i -> i).sum();
        System.out.println(somme);
    }

    public static void parallelStream() {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        long somme =
                entiers.parallelStream().filter(v -> v < 10).mapToInt(i -> i).sum();
        System.out.println(somme);
    }

    public static void collectionWithoutStream() {

        class Personne {
            private String point;
            private String genre;
            private Integer weight;

            public Personne(String point, String genre, Integer weight) {
                this.point = point;
                this.genre = genre;
                this.weight = weight;
            }

            public Integer getWeight() {
                return weight;
            }

            public String getGenre() {
                return genre;
            }
        }

        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "HOMME", 176));
        personnes.add(new Personne("p2", "HOMME", 190));
        personnes.add(new Personne("p3", "FEMME", 172));
        personnes.add(new Personne("p4", "FEMME", 162));
        personnes.add(new Personne("p5", "HOMME", 176));
        personnes.add(new Personne("p6", "FEMME", 168));

        long total = 0;
        int nbPers = 0;
        for (Personne personne : personnes) {
            if (personne.getGenre() == "FEMME") {
                nbPers++;
                total += personne.getWeight();
            }
        }
        double resultat = (double) total / nbPers;
        System.out.println("Poids moyenne des femmes = " + resultat);
    }

    public static void collectionWithStream() {

        class Personne {
            private String point;
            private String genre;
            private Integer weight;

            public Personne(String point, String genre, Integer weight) {
                this.point = point;
                this.genre = genre;
                this.weight = weight;
            }

            public Integer getWeight() {
                return weight;
            }

            public String getGenre() {
                return genre;
            }
        }

        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "HOMME", 176));
        personnes.add(new Personne("p2", "HOMME", 190));
        personnes.add(new Personne("p3", "FEMME", 172));
        personnes.add(new Personne("p4", "FEMME", 162));
        personnes.add(new Personne("p5", "HOMME", 176));
        personnes.add(new Personne("p6", "FEMME", 168));

        double resultat = personnes.stream()
                .filter(p -> p.getGenre() == "FEMME")
                .mapToInt(p -> p.getWeight())
                .average()
                .getAsDouble();
        System.out.println("Poids moyenne des femmes = " + resultat);
    }
}
