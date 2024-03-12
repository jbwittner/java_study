package fr.jbwittner.javastudy;

public class Conditions {

    public static void main(String[] args) {
        ifCondition();
        ternaire();
        switchTest();
    }

    public static void ifCondition() {
        estPaire(2);
        estPaire(3);
    }

    public static void estPaire(int val) {
        if (val % 2 == 0) {
            System.out.println(val + " est paire");
        } else {
            System.out.println(val + " est impaire");
        }
    }

    public static void ternaire() {
        int niveau = 5;

        int total;
        if (niveau == 5) // équivalent à total = (niveau == 5) ? 10 : 5;
        total = 10;
        else total = 5;

        System.out.println("ternaire - total : " + total);

        int total2 = (niveau == 5) ? 10 : 5;

        System.out.println("ternaire - total2 : " + total2);
    }

    public static void switchTest() {
        System.out.println("switchTest - getReponse('oui') : " + getReponse("oui"));
        System.out.println("switchTest - getReponse('non') : " + getReponse("non"));
        System.out.println("switchTest - getReponse('oUI') : " + getReponse("oUI"));
        System.out.println("switchTest - getReponseUpgrade('oUI') : " + getReponseUpgrade("oUI"));
    }

    public static Boolean getReponse(String reponse) {
        Boolean resultat = null;
        switch (reponse) {
            case "oui":
            case "Oui":
                resultat = true;
                break;
            case "non":
            case "Non":
                resultat = false;
                break;
            default:
                resultat = null;
                break;
        }
        return resultat;
    }

    public static Boolean getReponseUpgrade(String reponse) {
        Boolean resultat = null;

        switch (reponse.toLowerCase()) {
            case "oui":
                resultat = true;
                break;
            case "non":
                resultat = false;
                break;
            default:
                resultat = null;
                break;
        }
        return resultat;
    }
}
