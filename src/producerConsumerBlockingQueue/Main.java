package producerConsumerBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
//		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(5);
		Thread producerThread = new Thread(new Producer(bq));
		Thread consumerThread = new Thread(new Consumer(bq));
		producerThread.start();
		consumerThread.start();
	}
}
