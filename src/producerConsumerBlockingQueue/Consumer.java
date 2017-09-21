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
		while(true){
			try {
				System.out.println("consumer just consumed "+" "+bq.take());

				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
