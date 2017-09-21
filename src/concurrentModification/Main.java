package concurrentModification;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author vagrant
 *	Check out the difference between iterator and listIterator
 */
public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int x =0;x<100;x++)
			list.add(x);
		Iterator<Integer> it = list.iterator();
		int counter = 0;
		//this will throw concurrent modification exception
//		while(it.hasNext()){
//			System.out.println(it.next());
//			if(counter == 3)
//				list.remove(3);
//			counter++;
//		}
		//this will not throw concurrent modification exception
		while(it.hasNext()){
			System.out.println(it.next());
			if(counter == 3)
				it.remove();
			counter++;
		}
	}
}
