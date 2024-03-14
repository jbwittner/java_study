package fr.jbwittner.javastudy.pojo;

public class ModificateurAccess {

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
    }
}

class Constante {

    public final int cst;

    public Constante() {
        this.cst = 10;
    }
}

abstract class Forme {

    // Méthode abstraite pour calculer l'aire de la forme
    public abstract double aire();

    // Méthode abstraite pour calculer le périmètre de la forme
    public abstract double perimetre();
}

class Cercle extends Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double aire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double perimetre() {
        return 2 * Math.PI * rayon;
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
}
