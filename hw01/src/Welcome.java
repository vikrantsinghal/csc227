import java.util.Scanner;

//Programmer: Vikrant Singhal
//This program prompts for your name and prints a nice message
public class Welcome {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Welcome, what is your name? ");
		String name = keyboard.nextLine();
		
		System.out.print("Hello " + name + ". I hope you are feeling well :-)");
	}
}
