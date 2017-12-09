package Exce4;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		try {
			calculateThrow();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Wpisz poprawny format rzutu np: 2D6+1");
		}
	}

	static int[] changeIndextoInt(String str) {
		int[] arr = new int[3];

		arr[0] = str.indexOf('D');
		arr[1] = str.indexOf('-');
		if (arr[1] < 0) {
			arr[1] = str.indexOf('+');
			arr[2] = 1;
		}

		return arr;
	}

	static int[] textToIntArr(int[] arr, String str) {

		int[] wynik = new int[4];

		if (arr[0] == 0) {
			wynik[0] = 1;
			if (arr[1] > 0) {
				wynik[1] = Integer.parseInt(str.substring(1, arr[1]));
				wynik[2] = Integer.parseInt(str.substring(arr[1] + 1, str.length()));
			} else {
				wynik[1] = Integer.parseInt(str.substring(1, str.length()));
				wynik[2] = 0;
			}
		} else {
			wynik[0] = Integer.parseInt(str.substring(0, arr[0]));
			if (arr[1] > 0) {
				wynik[1] = Integer.parseInt(str.substring(arr[0] + 1, arr[1]));
				wynik[2] = Integer.parseInt(str.substring(arr[1] + 1, str.length()));
			} else {
				wynik[1] = Integer.parseInt(str.substring(arr[0] + 1, str.length()));
				wynik[2] = 0;
			}
		}

		if (arr[2] != 1) {
			wynik[2] *= (-1);
		}

		return wynik;
	}

	// obliczenie sumy kości
	static void calculateThrow() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		Random r = new Random();
		int sum = 0;

		int[] arrIndex = changeIndextoInt(str);
		int[] arr = textToIntArr(arrIndex, str);

		for (int i = 0; i < arr[0]; i++) {
			sum += r.nextInt(arr[1]) + 1;
		}

		sum += arr[2];

		scan.close();
		System.out.println(sum);

	}

}
