package synchronizedExample;

public class Main {

	public static void main(String[] args) {
		Table t = new Table();
		Thread1 th1 = new Thread1(t);
		Thread2 th2 = new Thread2(t);
		th1.start();
		th2.start();
	}
}

//Comment this out and uncomment the lower section and see the magic for yourself :p 
class Table {
	int n;
	void printTable(int num) {
		this.n = num;
		System.out.println("Called by :-"+Thread.currentThread().getName()+" setting n ->"+n);
		for (int i = 1; i <= 5; i++) {
			System.out.println(n+" * "+i+" = "+n * i +" "+ Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
//class Table {
//	int n;
//	void printTable(int num) {
//		synchronized (this) {
//			this.n = num;
//			System.out.println("Called by :-"+Thread.currentThread().getName()+" setting n ->"+n);
//			for (int i = 1; i <= 5; i++) {
//				System.out.println(n+" * "+i+" = "+n * i +" "+ Thread.currentThread().getName());
//				try {
//					Thread.sleep(400);
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		}
//	}
//}

class Thread1 extends Thread{
	Table t;
	public Thread1(Table table){
		this.t = table;
	}
	public void run(){
		t.printTable(10);
	}
}

class Thread2 extends Thread{
	Table t;
	public Thread2(Table table){
		this.t = table;
	}
	public void run(){
		t.printTable(5);
	}
}