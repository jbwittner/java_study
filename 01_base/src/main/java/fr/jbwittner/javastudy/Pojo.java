package fr.jbwittner.javastudy;

public class Pojo {

    public static void main(String[] args) {
        variableDeClasse();
        variableThis();
        testInstanceOf();
    }

    public static void variableDeClasse() {
        MaClasseUne m = new MaClasseUne();
        int c1 = m.compteur;
        int c2 = MaClasseUne.compteur;
        System.out.println(c1 == c2);
    }

    public static void variableThis() {
        MaClasseDeux m = new MaClasseDeux(10);
        m.printNombre();
    }

    public static void testInstanceOf() {
        MaClasseUne m1 = new MaClasseUne();
        testClasse(m1);

        MaClasseTrois m3 = new MaClasseTrois();
        testClasse(m3);
    }

    public static void testClasse(Object o) {
        if (o instanceof MaClasseTrois) System.out.println(" o est une instance de la classe MaClasseTrois ");
        else System.out.println(" o n'est pas un objet de la classe MaClasseTrois ");
    }
}

class MaClasseUne {
    static int compteur = 0;
}

class MaClasseDeux {
    private int nombre;

    public MaClasseDeux(int nombre) {
        this.nombre = nombre; // variable de classe = variable en paramètre du constructeur
    }

    public void printNombre() {
        System.out.println(this.nombre);
    }
}

class MaClasseTrois {
    String chaine = " test ";

    public String getChaine() {
        return chaine;
    }
    // est équivalent à public String getChaine() { return this.chaine; }
}
