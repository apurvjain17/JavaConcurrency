package sleep;

public class Main {

	public static void main(String[] args) {
		RandomNumbers rn = new RandomNumbers();
		RandomNumberThread rnth = new RandomNumberThread();
		Thread th = new Thread(rn);
		rnth.setName("threadClass");
		th.setName("RunnableInterfaceThread");
		th.start();
		rnth.start();
		System.out.println("Exiting main thread!");
	}
}
