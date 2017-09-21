package producerConsumerBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	BlockingQueue<Integer> bq;
	
	public Producer(BlockingQueue<Integer> queue){
		bq = queue;
	}
	public int produce(){
		return (int)(Math.random()*10);
	}
	public void run(){
		for(int x = 0;x<10;x++){
			bq.offer(produce());
			try{
				
				Thread.sleep((int)(Math.random()*100));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
