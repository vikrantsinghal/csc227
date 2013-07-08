//Vikrant Singhal

/**Reads the departure time of two trains
 * and displays the time difference.*/

import java.util.Scanner;

public class TimeDifference {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Prompting and taking input for Train A.
		System.out.print("Train A? ");
		int timeTrainA = keyboard.nextInt();

		// Prompting and taking input for Train B.
		System.out.print("Train B? ");
		int timeTrainB = keyboard.nextInt();

		// Calculating time in minutes after midnight when each train departs.
		int timeMinutesA = (timeTrainA % 100) + ((timeTrainA / 100) * 60);
		int timeMinutesB = (timeTrainB % 100) + ((timeTrainB / 100) * 60);

		// Calculating time difference.
		int timeDifference = Math.abs(timeMinutesA - timeMinutesB);

		// Displaying the result.
		System.out.println("Train A leaves " + timeMinutesA
				+ " minutes after midnight");
		System.out.println("Train B leaves " + timeMinutesB
				+ " minutes after midnight");
		System.out.print("Difference " + (timeDifference / 60) + " hour(s) "
				+ (timeDifference % 60) + " minute(s)");

	}

}
