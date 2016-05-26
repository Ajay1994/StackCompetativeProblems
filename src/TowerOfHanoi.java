import java.util.*;
/*
 * n = # of disks , Source , Dest , Auxilliary
 * if(n == 1) move simply from source to dest
 * else{
 * 		first move n-1 from source to auxillairy
 * 		move nth disk from source to Dest
 * 		move remainning n-1 from auxillary to destination
 * }
 */
public class TowerOfHanoi {
	
	private static void printSequence(int n, String source, String destination, String aux){
		if(n == 1){
			System.out.println("Move "+ source + " to "+ destination);
			return;
		}
		printSequence(n-1, source, aux, destination);
		System.out.println("Move "+ source + " to "+ destination);
		printSequence(n-1, aux, destination, source);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSequence(3, "A", "C", "B");
	}

}
