package fr.jbwittner.javastudy;

public class App {

    public record Personne(String nom, String prenom) {}

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
