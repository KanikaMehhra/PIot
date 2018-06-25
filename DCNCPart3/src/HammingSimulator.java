import java.util.Scanner;

import javax.swing.JOptionPane;

public class HammingSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ....making and displaying student number array....
		
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of digits in your student number:");

		int numOfBits = console.nextInt();

		int[] studentNoArray = new int[numOfBits + 1];

		studentNoArray[0] = -1;
		System.out.println("Enter your stuent number:");

		for (int i = numOfBits; i > 0; i--) {
			studentNoArray[i] = console.nextInt();
		}

		System.out.println();
		System.out.println("stuent number:");
		for (int i = numOfBits; i > 0; i--) {
			System.out.print(studentNoArray[i]);
		}

		// ....making and displaying data array....

		int[] dataArray = new int[numOfBits + 1];
		dataArray[0] = -1;

		for (int i = numOfBits; i > 0; i--) {
			if (studentNoArray[i] % 2 == 0)
				dataArray[i] = 0;
			else
				dataArray[i] = 1;
		}

		System.out.println("\n");
		System.out.println("Generated data in binary:");
		for (int i = numOfBits; i > 0; i--) {
			System.out.print(dataArray[i]);
		}

		System.out.println();
		
		// ....calculating parity bits....

		int numOfParity = 0;

		while (!(Math.pow(2, numOfParity) >= numOfParity + numOfBits + 1)) {
			++numOfParity;
		}

		// ....generating codeword array with default values of parity digits and copying data array to codeword array....	
		int lenOfCodeword = numOfBits + numOfParity;
		int[] codewordArray = new int[lenOfCodeword + 1];

		codewordArray[0] = -1;

		for (int i = 1; i <= lenOfCodeword; i = i * 2)
			codewordArray[i] = 1;

		for (int i = lenOfCodeword, j = numOfBits; i > 0 && j > 0; i--) {
			if (codewordArray[i] != 1) {
				codewordArray[i] = dataArray[j--];
			}
		}

		for (int i = 1; i <= lenOfCodeword; i = i * 2)
			codewordArray[i] = 0;

		// ....Calculating value of parity bits and assigning then in the codeword array....
		
		int midSum = 0, sum = 0;
		for (int i = 1; i <= lenOfCodeword; i = i * 2) {
			for (int j = i; j <= lenOfCodeword; j = j + (2 * i)) {
				for (int k = j; k < (j + i) && k <= lenOfCodeword; k++) {
					midSum += codewordArray[k];
				}
				sum += midSum;
				midSum = 0;
			}

			if (sum % 2 == 0)
				codewordArray[i] = 0;
			else
				codewordArray[i] = 1;
			sum = 0;
		}

		// .... displaying the proper codeword array i.e. Hamming code....
		
		System.out.println();
		System.out.println("Generated Codeword:");
		for (int i = lenOfCodeword; i > 0; i--) {
			System.out.print(codewordArray[i]);
		}

		System.out.println();

	}

}
