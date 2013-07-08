/**
 * This class has a bunch of methods that use loops to process
 * string and numeric data and others that do array processing
 * 
 * Programmer: Vikrant Singhal
 */

import java.util.Scanner;

public class LoopsAndArrays {

	// Given a String, it returns a reference to a new String that has str
	// characters in reverse order.
	public String reverseString(String str) {
		String result = "";

		if (str.length() > 0) {
			for (int index = 0; index < str.length(); index++) {
				result = result + str.charAt(str.length() - 1 - index);
			}

			return result;
		}

		result = str;
		return result;
	}

	// Given an integer argument that represents the number of integers to sum,
	// it returns the sum of the first n integers.
	public int firstNints(int n) {
		int result = 0;

		for (int index = 0; index <= n; index++) {
			result += index;
		}

		return result;
	}

	// Given an integer argument n, it returns n factorial.
	public int factorial(int n) {
		int result = 1;

		if (n == 0)
			return 1;

		for (int index = 1; index <= n; index++) {
			result *= index;
		}

		return result;
	}

	// It returns the number of times two consecutive characters occur in the
	// given string.
	public int charPairs(String str) {
		int numberOfPairs = 0;

		if (str.length() > 1) {
			for (int index = 0; index < str.length() - 1; index++) {
				if (str.charAt(index) == str.charAt(index + 1))
					numberOfPairs += 1;
			}

			return numberOfPairs;
		}

		return numberOfPairs;
	}

	// It returns true if str is a palindrome.
	public boolean isPalindrome(String str) {

		if (str.length() > 0) {
			for (int index = 0; index < str.length() / 2; index++) {
				if (str.charAt(index) != str.charAt(str.length() - 1 - index))
					return false;
			}
		}
		return true;
	}

	// Given a Scanner constructed with a String of valid integers, it returns
	// the sum of all integers.
	public int sumInScanner(Scanner stream) {
		int sum = 0;

		while (stream.hasNextInt())
			sum += stream.nextInt();

		return sum;
	}

	// Given a Scanner constructed with a String of floating point numbers, it
	// returns the largest number found. If the scanner is empty (has no valid
	// integers), it returns 0.0.
	public double maximumInScanner(Scanner stream) {
		double max = 0.0;
		double temp;

		if (stream.hasNextDouble()) {
			max = stream.nextDouble();

			while (stream.hasNextDouble()) {
				temp = stream.nextDouble();

				if (temp > max)
					max = temp;
			}
		}

		return max;
	}

	// It returns the number of times a pair occurs in array. A pair is any two
	// String values that are equal (case sensitive) in consecutive array
	// elements.
	public int numberOfPairs(String[] array) {
		int numberOfPairs = 0;

		for (int index = 0; index < array.length - 1; index++) {
			if (array[index].equals(array[index + 1]))
				numberOfPairs += 1;
		}

		return numberOfPairs;
	}

	// Given a filled array of char array elements, it returns the number of
	// vowels.
	public int numberOfVowels(char[] array) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		int numberOfVowels = 0;

		for (int index = 0; index < array.length; index++) {
			for (int index1 = 0; index1 < 10; index1++) {
				if (array[index] == vowels[index1]) {
					numberOfVowels += 1;
					break;
				}
			}
		}
		return numberOfVowels;
	}

	// Given a filled array of double array elements, it returns true if the sum
	// of all array elements is greater than sum.
	public boolean sumGreaterThan(double[] array, double sum) {
		double sumOfArrayElements = 0.0;

		if (array.length > 0) {
			for (int index = 0; index < array.length; index++)
				sumOfArrayElements += array[index];

			if (sumOfArrayElements > sum)
				return true;
		}
		return false;
	}

	// Given a Scanner of double values, it returns an array of capacity three
	// that has the maximum value in the Scanner as the value in result[0], the
	// minimum value as the second value in result[1], and the average as the
	// third value in result[2].
	public double[] stats(Scanner scanner) {
		double max = 0.0;
		double min = 0.0;
		double sum = 0.0;
		int totalNumbers = 0;
		double temp;

		if (scanner.hasNextDouble()) {
			max = min = temp = sum = scanner.nextDouble();
			totalNumbers++;

			while (scanner.hasNextDouble()) {
				temp = scanner.nextDouble();

				if (temp > max)
					max = temp;

				if (temp < min)
					min = temp;

				sum += temp;
				totalNumbers++;
			}
		}
		return new double[] { max, min, sum / totalNumbers };
	}

	// Given a Scanner constructed with a String containing a stream of integers
	// in the range of 0..10 (like quiz scores), it returns an array of 11
	// integers where the first value (at index 0) is the number of 0s in the
	// Scanner, the second value (at index 1) is the number of ones on the
	// Scanner, and the 11th value (at index 10) is the number of tens in the
	// Scanner.
	public int[] frequency(Scanner scanner) {
		int temp = 0;
		int[] result = new int[11];

		while (scanner.hasNextInt()) {
			temp = scanner.nextInt();

			for (int index = 0; index < 11; index++) {
				if (temp == index)
					result[index] += 1;
			}
		}

		return result;
	}

	// It modifies the parameter array to place the largest integer at index n-1
	// and the smallest integer at array[0]. The others elements are still in
	// the array, but not in any particular order.
	public void sortOfSort(int[] array) {
		int max = array[0];
		int min = array[0];
		int maxPos = 0;
		int minPos = 0;

		for (int index = 0; index < array.length; index++) {
			if (min >= array[index]) {
				min = array[index];
				minPos = index;
			}
		}
		for (int index = minPos; index >= 1; index--) {
			array[index] = array[index - 1];
		}
		array[0] = min;

		for (int index = 0; index < array.length; index++) {
			if (max <= array[index]) {
				max = array[index];
				maxPos = index;
			}
		}
		for (int index = maxPos; index <= array.length - 2; index++) {
			array[index] = array[index + 1];
		}
		array[array.length - 1] = max;
	}

	// Modify the parameter array so it still contains the exact same numbers as
	// the given array, but rearranged so that all the even numbers come before
	// all the odd numbers. Other than that, the numbers can be in any order.
	public void evensLeft(int[] array) {
		int numberOfEvens = 0;
		int temp = 0;

		if (array.length > 1) {
			for (int index = 0; index < array.length; index++) {
				if (array[index] % 2 == 0)
					numberOfEvens++;
			}

			for (int index = 0; index < numberOfEvens; index++) {
				if (array[index] % 2 != 0) {
					temp = array[index];
					for (int j = index; j < array.length - 1; j++) {
						array[j] = array[j + 1];
					}
				}
				array[array.length - 1] = temp;
				if (array[index] % 2 != 0)
					index--;
			}
		}
	}

	// It modifies array so it is "left shifted" n times.
	public void shiftNTimes(int[] array, int numShifts) {
		int temp;

		if (array.length > 0) {
			for (int index = 1; index <= numShifts; index++) {
				temp = array[0];
				for (int j = 0; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 1] = temp;
			}
		}
	}

	// It returns a new char[] that is a copy of array with all occurrences of
	// oldChar replaced by newChar.
	public char[] replaced(char[] array, char oldChar, char newChar) {
		char[] result = new char[array.length];
		if (array.length > 0) {
			for (int index = 0; index < array.length; index++) {
				result[index] = array[index];
				if (result[index] == oldChar)
					result[index] = newChar;
			}
			return result;
		}
		return result;
	}
}
