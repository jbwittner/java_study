package fr.jbwittner.javastudy.pojo;

public class ModificateurAccess {

    public static void main(String[] args) {}
}

class Cercle {
    static float pi = 3.1416f;
    float rayon;

    public Cercle(float rayon) {
        this.rayon = rayon;
    }

    public float surface() {
        return rayon * rayon * pi;
    }
}

class Constante2 {

    public final int constante;

    public Constante2() {
        this.constante = 10;
    }
}
