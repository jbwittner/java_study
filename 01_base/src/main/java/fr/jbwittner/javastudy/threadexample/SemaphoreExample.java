package fr.jbwittner.javastudy.threadexample;

import java.util.concurrent.Semaphore;

// Printer class represents the shared resource
class Printer {
    // Print method to simulate printing
    void printDocument(String documentName) {
        System.out.println("Printing document: " + documentName);
        // Simulating time taken to print
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Printed: " + documentName);
    }
}

// Thread class representing a printing job
class PrintingJob implements Runnable {
    private Printer printer;
    private String documentName;
    private Semaphore semaphore;

    public PrintingJob(Printer printer, String documentName, Semaphore semaphore) {
        this.printer = printer;
        this.documentName = documentName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // Acquiring the semaphore
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is printing document: " + documentName);
            printer.printDocument(documentName);
            // Releasing the semaphore
            semaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Semaphore semaphore = new Semaphore(1); // Only one permit

        // Creating and starting three printing jobs
        Thread job1 = new Thread(new PrintingJob(printer, "Document 1", semaphore), "Job 1");
        Thread job2 = new Thread(new PrintingJob(printer, "Document 2", semaphore), "Job 2");
        Thread job3 = new Thread(new PrintingJob(printer, "Document 3", semaphore), "Job 3");

        job1.start();
        job2.start();
        job3.start();
    }
}
