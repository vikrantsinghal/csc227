//Vikrant Singhal

/**This program asks for the number of credits and grades
 * for three courses from the user and prints the GPA.*/

import java.util.Scanner;

public class GPA {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Prompting and taking inputs for course 1.
		System.out.print("Credits for course 1 (between 0.5 and 15.0): ");
		double creditsCourse1 = keyboard.nextDouble();
		System.out.print("Grade for course 1 (0.0, 1.0, 2.0, 3.0 or 4.0): ");
		double gradeCourse1 = keyboard.nextDouble();
		System.out.println();

		// Prompting and taking inputs for course 2.
		System.out.print("Credits for course 2 (between 0.5 and 15.0): ");
		double creditsCourse2 = keyboard.nextDouble();
		System.out.print("Grade for course 2 (0.0, 1.0, 2.0, 3.0 or 4.0): ");
		double gradeCourse2 = keyboard.nextDouble();
		System.out.println();

		// Prompting and taking inputs for course 3.
		System.out.print("Credits for course 3 (between 0.5 and 15.0): ");
		double creditsCourse3 = keyboard.nextDouble();
		System.out.print("Grade for course 3 (0.0, 1.0, 2.0, 3.0 or 4.0): ");
		double gradeCourse3 = keyboard.nextDouble();
		System.out.println();

		// Computing GPA.
		double totalPoints = (creditsCourse1 * gradeCourse1)
				+ (creditsCourse2 * gradeCourse2)
				+ (creditsCourse3 * gradeCourse3);
		double GPA = totalPoints
				/ (creditsCourse1 + creditsCourse2 + creditsCourse3);

		// Showing the GPA.
		System.out.print("GPA: " + GPA);

	}

}
