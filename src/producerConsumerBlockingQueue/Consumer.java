package producerConsumerBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
BlockingQueue<Integer> bq;
	
	public Consumer(BlockingQueue<Integer> queue){
		bq = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
