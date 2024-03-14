package fr.jbwittner.javastudy.pojo;

public class ObjectExample {

    public static void main(String[] args) {
        variableDeClasse();
        variableThis();
        testInstanceOf();
        equality();
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

    public static void equality() {
        MaClasseDeux m1 = new MaClasseDeux(10);
        MaClasseDeux m2 = new MaClasseDeux(10);
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nombre;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MaClasseDeux other = (MaClasseDeux) obj;
        if (nombre != other.nombre) return false;
        return true;
    }
}

class MaClasseTrois {
    String chaine = " test ";

    public String getChaine() {
        return chaine;
    }
    // est équivalent à public String getChaine() { return this.chaine; }
}
