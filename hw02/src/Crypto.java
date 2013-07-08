//Vikrant Singhal

 /**This program uses one of the characters from each of the five input
 * strings to spell out a new word. The single character is selected
 * using the associated integer in the second line of user input.*/

import java.util.Scanner;

public class Crypto {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Asking the user to enter five words.
		System.out.print("Enter five words: ");
		String word1 = keyboard.next();
		String word2 = keyboard.next();
		String word3 = keyboard.next();
		String word4 = keyboard.next();
		String word5 = keyboard.next();

		// Asking the user to enter five integers to extract letters.
		System.out.print("Enter five integers: ");
		int posWord1 = keyboard.nextInt();
		int posWord2 = keyboard.nextInt();
		int posWord3 = keyboard.nextInt();
		int posWord4 = keyboard.nextInt();
		int posWord5 = keyboard.nextInt();

		// Displaying the secret message.
		System.out.println("Secret message: " + word1.charAt(posWord1)
				+ word2.charAt(posWord2) + word3.charAt(posWord3)
				+ word4.charAt(posWord4) + word5.charAt(posWord5));

	}

}
