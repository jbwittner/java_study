package fr.jbwittner.javastudy.threadexample;

// Étape 1 : Création d'une classe qui implémente Runnable
class MaTache implements Runnable {
    public void run() {
        // Code à exécuter par le thread
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Message numéro " + i + " depuis " + Thread.currentThread().getName());
            try {
                // Faire une pause pour simuler une opération longue
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu.");
            }
        }
    }
}

public class BasicExample {
    public static void main(String[] args) {
        // Étape 2 : Créer une instance de Thread avec notre tâche
        Thread monThread = new Thread(new MaTache());

        // Démarrer le thread
        monThread.start();

        // Vous pouvez exécuter des actions dans le thread principal en parallèle
        System.out.println("Message depuis le thread principal");
    }
}
