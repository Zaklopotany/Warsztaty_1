package zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		simpleGame();
		
		
	}
	
	static void simpleGame () {
		System.out.println("Zgadnij liczbę: Cześć");
		boolean runLoop = false;
		Random r = new Random();
		int randomInt = r.nextInt(99)+1;
		int check = 0;

		while(!runLoop) {
			check = inputNumInt();
			runLoop = validateInt(randomInt, check);
			
		}
		scan.close();
	}
	
	static int inputNumInt () {
		while (!scan.hasNextInt()) {
			System.out.println("To nie jest liczba!");
			scan.next();
		}
		
		int ret = scan.nextInt();
		return ret;
		
	}
	
	static boolean validateInt (int value, int checkValue) {
		
		if ( checkValue > value) {
			System.out.println("Za dużo!");
			return false;
		} else if (checkValue < value){
			System.out.println("Za mało!");
			return false;
		} else {
			System.out.println("Zgadłeś!");
			return true;
		}
		
	}
	
	
}

