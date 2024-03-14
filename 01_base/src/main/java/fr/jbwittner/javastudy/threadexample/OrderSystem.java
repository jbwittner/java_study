package fr.jbwittner.javastudy.threadexample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Order {
    private final String content;

    public Order(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Order> queue;

    public Producer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Order order = new Order("Order " + i);
                queue.put(order);
                System.out.println(Thread.currentThread().getName() + " produced " + order.getContent());
                // Simulate a delay for producing an order
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Order> queue;

    public Consumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = queue.take();
                System.out.println(Thread.currentThread().getName() + " consumed " + order.getContent());
                // Simulate a processing time for the order
                Thread.sleep((long) (Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class OrderSystem {
    public static void main(String[] args) {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

        // Create and start several producer and consumer threads
        Thread producer1 = new Thread(new Producer(queue), "Producer 1");
        Thread producer2 = new Thread(new Producer(queue), "Producer 2");
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer 1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer 2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
