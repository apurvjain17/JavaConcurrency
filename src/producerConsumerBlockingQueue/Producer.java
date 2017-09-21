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
			int number = produce();
			try{
				bq.put(number);
				System.out.println("Producer just Produced:- "+number);
				
				Thread.sleep((int)(Math.random()*10));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
