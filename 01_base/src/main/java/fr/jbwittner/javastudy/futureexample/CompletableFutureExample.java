package fr.jbwittner.javastudy.futureexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Exécute une tâche asynchrone et retourne immédiatement
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // Simule un long traitement
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Résultat de la tâche asynchrone";
        });

        // Enchaîne une autre opération à effectuer une fois la première tâche complétée
        CompletableFuture<String> futureResult = completableFuture.thenApply(result -> {
            // Effectue une transformation sur le résultat de la première tâche
            return result.toUpperCase();
        });

        // Ajoute un callback qui sera appelé une fois que le futur est complété
        futureResult.thenAccept(result -> System.out.println("Résultat final: " + result));

        // Attendre de manière non bloquante que toutes les tâches soient complétées
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureResult);
        allFutures.join(); // Attend sans bloquer que le CompletableFuture soit terminé

        // Le programme principal peut continuer à exécuter d'autres tâches en parallèle
        System.out.println("Le programme principal continue pendant que la tâche asynchrone est traitée");
    }
}
