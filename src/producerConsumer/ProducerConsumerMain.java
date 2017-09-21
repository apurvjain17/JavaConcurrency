package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		Queue<Integer> buffer = new LinkedList<>(); 
		int maxSize = 10; 
		Thread producer = new Producer(buffer, maxSize, "PRODUCER"); 
		Thread consumer = new Consumer(buffer, maxSize, "CONSUMER"); 
		producer.start(); 
		consumer.start();

	}
}

class Producer extends Thread {

	Queue<Integer> queue;
	int maxSize;
	public Producer(Queue<Integer> queue, int maxSize, String name){ 
		super(name); 
		this.queue = queue; 
		this.maxSize = maxSize; 
	}
	
	public void run() {
		while(true){
			synchronized (queue) {
				while (queue.size() == maxSize) { 
					try { 
						System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
//						Thread.sleep((int)(Math.random()*100));
						queue.wait(); 
					} catch (Exception ex) { 
						ex.printStackTrace(); 
					} 
				} 
				Random random = new Random(); 
				int i = random.nextInt(); 
				System.out.println("Producing value : " + i); 
				queue.add(i); 
				queue.notifyAll();
			}
		}
		
	}
}
class Consumer extends Thread{

	Queue<Integer> queue;
	int maxSize;
	public Consumer(Queue<Integer> queue, int maxSize, String name){ 
		super(name); 
		this.queue = queue; 
		this.maxSize = maxSize; 
	}
	public void run() {
		while(true){
			synchronized (queue) {
				while (queue.isEmpty()) { 
					System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue"); 
					try {
//						Thread.sleep((int)(Math.random()*100));
						queue.wait(); 
					} catch (Exception ex) { 
						ex.printStackTrace(); 
					} 
				} 
				System.out.println("Consuming value : " + queue.remove()); 
				queue.notifyAll();
			}
		}
	}
	
}