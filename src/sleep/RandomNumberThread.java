package sleep;

public class RandomNumberThread extends Thread{

	@Override
	public void run(){
		for(int x = 0; x< 10; x++){
			int number = (int)(Math.random()*10);
			System.out.println(Thread.currentThread().getName()+" -> "+number);
			try{
				
				Thread.sleep(number*100);
			}catch(Exception e){
				System.out.println("Interrupted Exception "+e.getMessage());
			}
		}
	}
}
