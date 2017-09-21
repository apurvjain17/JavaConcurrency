package threads;

public class RandomNumberThread extends Thread{

	@Override
	public void run(){
		for(int x = 0; x< 10; x++){
			System.out.println(Thread.currentThread().getName()+" -> "+(int)(Math.random()*10));
		}
	}
}
