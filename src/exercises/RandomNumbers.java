package exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vagrant
 * Find all the unique numbers in the array and print them in sorted order
 * Find all the factors of all the numbers from 1-20
 * Find the sum of all the elements of the list
 */
public class RandomNumbers {
	
	List<Integer> list;
	
	public RandomNumbers(){
		list = new ArrayList<Integer>();
		for(int x = 0;x<1000;x++){
			list.add((int)(Math.random()*1000));
		}
	}
	
	public void solve(){
		//put your logic here
	}

	public static void main(String[] args) {
		new RandomNumbers().solve();
	}
}
