package fr.jbwittner.javastudy.threadexample;

import java.util.concurrent.Semaphore;

// Represents the print queue
class PrintQueue {
    private final Semaphore queueSemaphore;
    private final Semaphore jobAdditionSemaphore;

    public PrintQueue() {
        // Assume we limit to 3 concurrent print jobs
        this.queueSemaphore = new Semaphore(3);
        // Binary semaphore for job addition critical section
        this.jobAdditionSemaphore = new Semaphore(1);
    }

    public void addPrintJob(String job) {
        try {
            // Acquire job addition semaphore to ensure thread-safe job addition
            jobAdditionSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " adding a job to the queue: " + job);
            // Simulate time taken to add job to the queue
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Release job addition semaphore
            jobAdditionSemaphore.release();
        }

        try {
            // Acquire queue semaphore to start printing
            queueSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " started printing job: " + job);
            // Simulate printing time
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Job done, release semaphore
            System.out.println(Thread.currentThread().getName() + " finished printing job: " + job);
            queueSemaphore.release();
        }
    }
}

// Represents users submitting print jobs
class PrinterUser extends Thread {
    private final PrintQueue printQueue;
    private final String job;

    public PrinterUser(PrintQueue printQueue, String job) {
        this.printQueue = printQueue;
        this.job = job;
    }

    public void run() {
        printQueue.addPrintJob(job);
    }
}

public class ComplexSemaphoreExample {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        // Simulate multiple users submitting print jobs
        for (int i = 1; i <= 10; i++) {
            PrinterUser user = new PrinterUser(printQueue, "Job-" + i);
            user.start();
        }
    }
}
