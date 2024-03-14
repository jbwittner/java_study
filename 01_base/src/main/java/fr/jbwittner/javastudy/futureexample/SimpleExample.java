package fr.jbwittner.javastudy.futureexample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleExample {

    public static void main(String[] args) throws Exception {
        // Crée un ExecutorService avec un seul thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Crée une tâche Callable qui retourne un résultat
        Callable<String> task = () -> {
            System.out.println("Exécution de la tâche");
            // Simule un traitement long avec Thread.sleep
            Thread.sleep(2000);
            return "Résultat de la tâche";
        };

        // Soumet la tâche au ExecutorService et obtient un Future
        Future<String> future = executor.submit(task);

        // Faites autre chose pendant que la tâche est en cours...

        // Obtient le résultat du Future, bloquant si nécessaire jusqu'à ce qu'il soit disponible
        String result = future.get();
        System.out.println("Résultat obtenu: " + result);

        // Arrête le ExecutorService
        executor.shutdown();
    }
}
