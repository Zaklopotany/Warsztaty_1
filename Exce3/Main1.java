package Exce3;

import java.util.Scanner;

public class Main1 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		simple_game_2(1000,0);
		
	}

	static void simple_game_2(int max, int min) {
		int guess = (((max - min) / 2) + min);
		boolean runLoop = true;
		
		System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach");
		
		while (runLoop) {
			System.out.println("Zgaduję " + guess);

			switch (getAns()) {
			case 1:
				min = guess;
				guess = (((max - min) / 2) + min);
				break;
			case 2:
				max = guess;
				guess = (((max - min) / 2) + min);
				break;
			case 3:
				System.out.println("Wygrałem!");
				runLoop = false;
				break;
			case 4:
				System.out.println("Nie oszukuj ");
				break;
			}
		}
	}

	static int getAns() {
		String str = new String();
		scan.reset();
		str = scan.nextLine();

		if (str.equalsIgnoreCase("za mało")) {
			return 1;
		} else if (str.equalsIgnoreCase("za dużo")) {
			return 2;
		} else if (str.equalsIgnoreCase("zgadłeś")) {
			return 3;
		} else {
			return 4;

		}
	}

	static void guessNum(int guess) {

	}

}
