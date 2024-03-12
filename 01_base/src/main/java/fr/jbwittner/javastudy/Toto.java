package fr.jbwittner.javastudy;

public class Toto {

    public static void main(String[] args) {
        System.out.println("Hello Toto!");
        test();
        testEntierBinaire();
    }

    public static void test() {
        float pi = 3.141f;
        double valeur = 3d;
        float flottant1 = +.1f, flottant2 = 1e10f;
        System.out.println("pi = " + pi);
        System.out.println("valeur = " + valeur);
        System.out.println("flottant1 = " + flottant1);
        System.out.println("flottant2 = " + flottant2);
    }

    public static void testEntierBinaire() {
        byte valeurByte = (byte) 0b00010001;
        System.out.println("valeurByte = " + valeurByte);
        valeurByte = (byte) 0B10001;
        System.out.println("valeurByte = " + valeurByte);
        valeurByte = (byte) 0B11101111;
        System.out.println("valeurByte = " + valeurByte);
        short valeurShort = (short) 0b1001110111101;
        System.out.println("valeurShort = " + valeurShort);
        int valeurInt = 0b1000;
        System.out.println("valeurInt = " + valeurInt);
        valeurInt = 0b1001110100010110100110101000101;
        System.out.println("valeurInt = " + valeurInt);
        long valeurLong = 0b010000101000101101000010100010110100001010001011010000101000101L;
        System.out.println("valeurLong = " + valeurLong);
    }
}
