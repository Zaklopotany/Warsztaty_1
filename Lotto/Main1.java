package Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
	}
	static void happyLottery () {
		
	}
	
	static int[] happyNumbers () {
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		Collections.shuffle(Arrays.asList(arr));
		int[] intArray = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
		int[] intNumb = Arrays.copyOf(intArray, 6);
		
		return intNumb;
		
	}
	
	static int[] getNumb () {
		System.out.println("Put your numbers ");
		int[] numb = new int[6];
		boolean runLoop = true;
		int counter = 0;
		int tempNumb = 0;
		
		
		while(runLoop) {
			while (!scan.hasNextInt()) {
				System.out.println("Please put the integer value, greater or equal 1 or lower or equal 49, numbers cannot repeat");
			}
			tempNumb = scan.nextInt();
			
			if ((numb[counter] >= 1) && (numb[counter] <= 49) && (Arrays.binarySearch(numb, tempNumb) < 0)) {
				numb[counter] = tempNumb;
				Arrays.sort(numb);
				counter++;
				if (counter == 6) {
					runLoop = false;
				}
			}
			
		}
		System.out.println(Arrays.toString(numb));
		
		return numb;
		
	}
	
	static void winnerLoser (int[]lotteryNumb, int[] userNumb) {
		
	}
}
