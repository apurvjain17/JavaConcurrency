package threads;

public class RandomNumbers implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x< 10; x++){
			System.out.println(Thread.currentThread().getName()+" -> "+(int)(Math.random()*10));
		}
		
	}

}
