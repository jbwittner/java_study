package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generic {

    public static void main(String[] args) {
        whitoutGeneric();
        whithGeneric();
    }

    public static void whitoutGeneric() {
        List liste = new ArrayList<>();
        String valeur = null;
        for (int i = 0; i < 10; i++) {
            valeur = "" + i;
            liste.add(valeur);
        }

        for (Iterator iter = liste.iterator(); iter.hasNext(); ) {
            valeur = (String) iter.next();
            System.out.println(valeur.toUpperCase());
        }
    }

    public static void whithGeneric() {
        List<String> liste = new ArrayList<>();
        String valeur = null;
        for (int i = 0; i < 10; i++) {
            valeur = "" + i;
            liste.add(valeur);
        }

        for (Iterator<String> iter = liste.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next().toUpperCase());
        }
    }
}
