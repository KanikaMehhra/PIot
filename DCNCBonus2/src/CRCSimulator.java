import java.util.Scanner;

import javax.swing.JOptionPane;

public class CRCSimulator {

	public static void main(String[] args) {

		int[] divident;
		int[] divisor;
		int[] newArray;

		Scanner sc = new Scanner(System.in);

		// Functioning for getting divident//
		System.out.println("Enter the length of the divident:");
		int dividentLength = sc.nextInt();
		divident = new int[dividentLength];

		System.out.println("Enter the value of the divident:");

		// Handle the error for divident not starting from 1 and adding values to the
		// array//
		for (int i = 0; i < dividentLength; i++) {
			divident[i] = sc.nextInt();
			while (divident[0] == 0) {
				System.out.println(
						"ERROR! The first digit of the number must be 1. Re-Enter the value of the first digit:");
				divident[0] = sc.nextInt();
			}
		}

		// Functioning for getting divisor//
		System.out.println("Enter the length of the divisor:");
		int divisorLength = sc.nextInt();

		// Handle the error for divisor being greater than the divident//
		while (divisorLength > dividentLength) {
			System.out.println(
					"ERROR! Length of dividor must be greater than that of divident. Re-Enter the length of the divisor:");
			divisorLength = sc.nextInt();
		}

		divisor = new int[divisorLength];
		newArray = new int[divisorLength];
		System.out.println("Enter the value of the divisor:");

		// Handle the error for divisor not starting from 1 and adding values to the
		// array//
		for (int i = 0; i < divisorLength; i++) {
			divisor[i] = sc.nextInt();
			while (divisor[0] == 0) {
				System.out.println(
						"ERROR! The first digit of the number must be 1. Re-Enter the value of the first digit:");
				divisor[0] = sc.nextInt();
			}
		}

		
		// *************************************** Client side *******************************************//
		
		// created newArray
		System.arraycopy(divident, 0, newArray, 0, divisorLength);	

		int initailTransmitFrameLength = dividentLength + divisorLength - 1;
		int[] initailTransmitFrame = new int[initailTransmitFrameLength];

		// Created transmitting array
		System.arraycopy(divident, 0, initailTransmitFrame, 0, dividentLength);

		int[] finalNewArray = performCalculation(divisor, initailTransmitFrame, newArray);

		System.arraycopy(finalNewArray, 1, initailTransmitFrame, dividentLength, divisorLength - 1);

		System.out.println("Transmitted Data");
		for (int i = 0; i < initailTransmitFrameLength; i++) {
			System.out.println(initailTransmitFrame[i]);
		}
		// ****************************************************Server side****************************************************//

		System.out.println("\n\nWelcome to the remote Server....enter the received data to the console >");

		int[] initialReceivedFrame = new int[initailTransmitFrameLength];
		for (int i = 0; i < initailTransmitFrameLength; i++) {
			initialReceivedFrame[i] = sc.nextInt();
		}
		int[] reminder = performCalculation(divisor, initialReceivedFrame, newArray);

		// checks for reminder
		boolean flag = true;
		for (int i = 0; i < divisor.length; i++) {
			if (reminder[i] == 1) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println("SUCCECCFUL Transmission....");
		else
			System.out.println("ERROR! Transmission contains error....");

	}

	//***************************************************************************************************
	
	// ************************************************** Common method **************************************************//
	public static int[] performCalculation(int[] divisor, int[] initailTransmitFrame, int[] newArray) {
		int index = 0;
		int currCount = 0;
		
		int checkLanding = 0;

		System.arraycopy(initailTransmitFrame, 0, newArray, 0, divisor.length);
		do {
			currCount = 0;
			for (int i = 0; i < divisor.length; i++) {
				if (currCount == 0) {
					if (divisor[i] != newArray[i])
						newArray[currCount++] = 1;
				} else {
					if (divisor[i] == newArray[i])
						newArray[currCount++] = 0;
					else
						newArray[currCount++] = 1;
				}
			}

			checkLanding++;

			if (checkLanding == 1)
				index += divisor.length;

			for (int i = currCount; i < divisor.length; i++) {
				if (index < initailTransmitFrame.length)
					newArray[currCount++] = initailTransmitFrame[index++];
			}

			if (index == initailTransmitFrame.length && currCount < divisor.length) {
				currCount--;
				for (int i = divisor.length - 1; i > 0; i--) {
					if (currCount >= 0)
						newArray[i] = newArray[currCount--];
					else
						newArray[i] = 0;
				}

			} else {

				if (index == initailTransmitFrame.length) {
					currCount = 0;
					for (int i = 0; i < divisor.length; i++) {
						if (divisor[i] == newArray[i])
							newArray[currCount++] = 0;
						else
							newArray[currCount++] = 1;
					}

				}
			}

		} while (index < initailTransmitFrame.length);
		return (newArray);
	}
}
