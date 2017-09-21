package atomicInt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main implements Runnable{
	static int  counter;
	
	public static void increment(){
		counter++;
	}
	public void run(){
		increment();
	}
	public static void testLock(){
		ExecutorService executor = Executors.newFixedThreadPool(5);
		IntStream.range(0, 10000).forEach(i -> executor.submit(Main::increment));
		executor.shutdown();
		try {
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}
	public static void main(String[] args) {
		testLock();
	}
}
