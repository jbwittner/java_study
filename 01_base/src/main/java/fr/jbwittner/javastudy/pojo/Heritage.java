package fr.jbwittner.javastudy.pojo;

public class Heritage {

    public static void main(String[] args) {
        testFormes();
    }

    public static void testFormes() {
        Forme cercle = new Cercle(5);
        Forme rectangle = new Rectangle(10, 20);
        Triangle triangle = new Triangle(5, 13, 12);
        Forme hexagone = new Forme() {
            private double cote = 6.0; // Longueur d'un côté de l'hexagone

            @Override
            public double aire() {
                // Formule de l'aire d'un hexagone régulier : (3 * sqrt(3) / 2) * (cote * cote)
                return (3 * Math.sqrt(3) / 2) * (cote * cote);
            }

            @Override
            public double perimetre() {
                // Le périmètre d'un hexagone régulier est simplement 6 fois la longueur d'un côté
                return 6 * cote;
            }

            @Override
            public void dessiner() {
                System.out.println("Dessiner un hexagone avec un côté de longueur " + cote);
            }
        };

        System.out.println("Aire du cercle: " + cercle.aire());
        System.out.println("Périmètre du cercle: " + cercle.perimetre());
        System.out.println("Aire du rectangle: " + rectangle.aire());
        System.out.println("Périmètre du rectangle: " + rectangle.perimetre());
        System.out.println("Aire du triangle: " + triangle.aire());
        System.out.println("Périmètre du triangle: " + triangle.perimetre());
        System.out.println("Aire du hexagone: " + hexagone.aire());
        System.out.println("Périmètre du hexagone: " + hexagone.perimetre());

        rectangle.afficherDetails();
        cercle.afficherDetails();
        triangle.afficherDetails();
        hexagone.afficherDetails();

        rectangle.afficherType();
        cercle.afficherType();
        triangle.afficherType();
        hexagone.afficherType();

        triangle.demoGeometrique();
        triangle.comparerAireAvec(cercle);
        System.out.println("Comparaison aire triangle avec cercle: " + triangle.comparerAireAvec(cercle));
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

interface Geometrique {
    // Définition de nouvelles propriétés ou méthodes géométriques si nécessaire
    // Pour l'exemple, nous pouvons la laisser vide ou ajouter une méthode de démonstration :
    void demoGeometrique();
}

interface ComparableForme {
    // Méthode pour comparer l'aire de cette forme avec une autre forme
    int comparerAireAvec(Forme autreForme);
}

class Triangle extends Forme implements Geometrique, ComparableForme {
    private double a; // Longueur du côté a
    private double b; // Longueur du côté b
    private double c; // Longueur du côté c

    // Constructeur
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Implémentation de la méthode aire() utilisant la formule de Héron
    @Override
    public double aire() {
        double s = (a + b + c) / 2; // Demi-périmètre
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Formule de Héron
    }

    // Implémentation de la méthode perimetre()
    @Override
    public double perimetre() {
        return a + b + c;
    }

    // Implémentation de la méthode dessiner()
    @Override
    public void dessiner() {
        System.out.println("Dessiner un triangle avec les côtés de longueur " + a + ", " + b + ", et " + c);
    }

    // Surcharge de la méthode afficherType() pour spécifier qu'il s'agit d'un triangle
    @Override
    public void afficherType() {
        System.out.println("Ceci est un triangle.");
    }

    @Override
    public void demoGeometrique() {
        System.out.println("Démonstration de propriétés géométriques spécifiques au triangle.");
    }

    @Override
    public int comparerAireAvec(Forme autreForme) {
        double aireAutreForme = autreForme.aire();
        double aireCetteForme = this.aire();
        return Double.compare(aireCetteForme, aireAutreForme);
    }
}
