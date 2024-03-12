package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForLoop {

    public static void main(String[] args) {
        simpleLoop();
        multipleTraitment();
        otherCondition();
        upgrade();
    }

    public static void simpleLoop() {
        for (int i = 1; i < 4; i++) {
            System.out.println("SimpleLoop : " + i);
        }
    }

    public static void multipleTraitment() {
        for (int i = 0, j = 0; i * j < 1000; i++, j += 2) {
            System.out.println("multipleTraitment - i : " + i + " - j :" + j);
        }
    }

    public static void otherCondition() {
        boolean finded = false;
        for (int i = 0; !finded; i++) {
            if (i >= 10) {
                finded = true;
            }
        }
        System.out.println("otherCondition - find");
    }

    public static void upgrade() {
        List<Integer> listData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listData.add(i);
        }

        for (Iterator<Integer> iter = listData.iterator(); iter.hasNext(); ) {
            System.out.println("before - upgrade : " + iter.next());
        }

        for (Object element : listData) {
            System.out.println("after - upgrade : " + element);
        }

        int[] arrayData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int element : arrayData) {
            System.out.println("arrayData : " + element);
        }
    }
}
