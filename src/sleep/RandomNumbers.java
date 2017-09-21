package sleep;

public class RandomNumbers implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
