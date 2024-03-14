package fr.jbwittner.javastudy.pojo;

public class Heritage {

    public static void main(String[] args) {
        testFormes();
    }

    public static void testFormes() {
        Forme cercle = new Cercle(5);
        Forme rectangle = new Rectangle(10, 20);

        System.out.println("Aire du cercle: " + cercle.aire());
        System.out.println("Périmètre du cercle: " + cercle.perimetre());
        System.out.println("Aire du rectangle: " + rectangle.aire());
        System.out.println("Périmètre du rectangle: " + rectangle.perimetre());

        rectangle.afficherDetails();
        cercle.afficherDetails();

        rectangle.afficherType();
        cercle.afficherType();
    }
}

class Constante {

    public final int cst;

    public Constante() {
        this.cst = 10;
    }
}

interface Dessinable {
    // Méthode pour dessiner la forme
    void dessiner();

    // Méthode default dans l'interface
    default void afficherType() {
        System.out.println("Ceci est une forme géométrique.");
    }
}

abstract class Forme implements Dessinable {

    // Méthode abstraite pour calculer l'aire de la forme
    public abstract double aire();

    // Méthode abstraite pour calculer le périmètre de la forme
    public abstract double perimetre();

    // Méthode non abstraite pour afficher les détails de la forme
    public void afficherDetails() {
        System.out.println("Détails de la forme :");
        System.out.println("Aire : " + this.aire());
        System.out.println("Périmètre : " + this.perimetre());
        this.dessiner(); // Cette méthode dessine également la forme
    }
}

class Cercle extends Forme {
    private double rayon;
    private static final double CST_PI = Math.PI;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double aire() {
        return Cercle.CST_PI * rayon * rayon;
    }

    @Override
    public double perimetre() {
        return 2 * Cercle.CST_PI * rayon;
    }

    @Override
    public void dessiner() {
        System.out.println("Dessiner un cercle de rayon " + rayon);
    }

    @Override
    public void afficherType() {
        System.out.println("Ceci est un cercle.");
    }
}

class Rectangle extends Forme {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double aire() {
        return longueur * largeur;
    }

    @Override
    public double perimetre() {
        return 2 * (longueur + largeur);
    }

    @Override
    public void dessiner() {
        System.out.println("Dessiner un rectangle de longueur " + longueur + " et de largeur " + largeur);
    }
}
