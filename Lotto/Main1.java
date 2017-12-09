package Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		happyLottery();

	}

	static void happyLottery() {

		int[] userNumb = getNumb();
		int[] lotteryNum = happyNumbers();
		winnerLoser(lotteryNum, userNumb);

	}

	static int[] happyNumbers() {
		Integer[] arr = new Integer[49];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		Collections.shuffle(Arrays.asList(arr));

		int[] intArray = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
		int[] intNumb = Arrays.copyOf(intArray, 6);
		Arrays.sort(intNumb);
		System.out.println(Arrays.toString(intNumb));

		return intNumb;

	}

	static int[] getNumb() {
		System.out.println("Put your numbers ");
		int[] numb = new int[6];
		boolean runLoop = true;
		int counter = 0;
		int tempNumb = 0;

		while (runLoop) {
			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println(
						"Please put the integer value, greater or equal 1 or lower or equal 49, numbers cannot repeat");
			}
			tempNumb = scan.nextInt();

			if ((tempNumb >= 1) && (tempNumb <= 49) && (Arrays.binarySearch(numb, tempNumb) < 0)) {

				numb[0] = tempNumb;
				Arrays.sort(numb);
				counter++;

				if (counter == 6) {
					runLoop = false;
				}
			} else {
				System.out.println(" Do not repeat your numbers, you nasty little worm. ");
			}

		}
		System.out.println(Arrays.toString(numb));

		return numb;

	}

	static void winnerLoser(int[] lotteryNumb, int[] userNumb) {

		int counter = 0;

		for (int i = 0; i < userNumb.length; i++) {
			if (Arrays.binarySearch(lotteryNumb, userNumb[i]) >= 0) {
				counter++;
			}
			if (counter >= 3) {
				System.out.println("Well done mate, you got at least 3 of 6");
				break;
			}
		}
		if (counter < 3) {
			System.out.println("Sorry buddy. Try next time. : )");
		}

	}
}
