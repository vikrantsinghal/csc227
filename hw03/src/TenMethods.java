/* 
 * This class has ten unrelated methods to provide practice for implementing 
 * methods that process primitives, Strings and selection control.  
 * 
 * Programmer: VIKRANT SINGHAL
 */
public class TenMethods {

	// This method returns the String argument matter preceded by "anti-".
	public String antiMatter(String matter) {
		return "anti-" + matter;
	}

	// The input is a five letter word. If its letters are indexed as 0-1-2-3-4,
	// this method jumbles up the letters in the form 0-3-1-2-4.
	public String csLatin(String aWord) {
		if (aWord.length() == 5)
			return aWord.substring(0, 1) + aWord.substring(3, 4)
					+ aWord.substring(1, 2) + aWord.substring(2, 3)
					+ aWord.substring(4, 5);
		return "";
	}

	// Input is a string whose length is at least two. It prints the last half
	// of the string in lower case first and the the first half in upper case in
	// the end. If the length of string is an odd number, the output has more
	// letter in the first half in lower case.
	public String halfAndHalf(String str) {
		if (str.length() >= 2)
			return str.substring(str.length() / 2).toLowerCase()
					+ str.substring(0, str.length() / 2).toUpperCase();
		return "";
	}

	// Takes a string argument(fullName) in the format: "Word1, Word2 Letter",
	// and returns it in the form: "Word2 Letter. Word1".
	public String lastNameLast(String fullName) {
		if ((fullName.indexOf(",") != (fullName.length() - 1) || fullName
				.indexOf(",") != 0)
				&& (fullName.indexOf(" ") == (fullName.indexOf(",") + 1))
				&& (fullName.lastIndexOf(" ") != (fullName.length() - 1))
				&& (fullName.indexOf(" ") != fullName.lastIndexOf(" ")))
			return fullName.substring(fullName.indexOf(",") + 2,
					fullName.lastIndexOf(" "))
					+ " "
					+ fullName.substring(fullName.lastIndexOf(" ") + 1)
					+ ". " + fullName.substring(0, fullName.indexOf(","));
		return "";
	}

	// It takes two different military times and returns a string with the
	// difference in hours and minutes, separated by ":".
	public String timeDifference(int earlyTime, int laterTime) {
		if ((earlyTime / 100 >= 0 && earlyTime / 100 <= 23)
				&& (earlyTime % 100 >= 0 && earlyTime % 100 <= 59)
				&& (laterTime / 100 >= 0 && laterTime / 100 <= 23)
				&& (laterTime % 100 >= 0 && laterTime % 100 <= 59)) {
			int totalMinuteTimeEarly = ((earlyTime / 100) * 60)
					+ (earlyTime % 100);
			int totalMinuteTimeLater = ((laterTime / 100) * 60)
					+ (laterTime % 100);
			int timeDiff = totalMinuteTimeLater - totalMinuteTimeEarly;

			int hourDiff = timeDiff / 60;
			int minutesDiff = timeDiff % 60;
			String diff = hourDiff + ":" + minutesDiff;
			return diff;
		}
		return "";
	}

	// Uses the formula C=(5/9)(F-32) to return the Celsius equivalent of
	// Fahrenheit argument.
	public double fToC(double fahrenheit) {
		return (5.0 / 9.0) * (fahrenheit - 32);
	}

	// Checks if the year entered is a leap year or not.
	public boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0)
				return true;
			return false;
		}
		if (year % 4 == 0)
			return true;
		return false;
	}

	// It takes two strings and returns reference to the string that is not less
	// than the other.
	public String max(String a, String b) {
		if (a.compareTo(b) >= 0)
			return a;
		return b;
	}

	// Takes three strings and returns reference to the string that is not
	// greater than the other two.
	public String firstOf3Strings(String a, String b, String c) {
		String first = a;

		if (b.compareTo(a) < 0)
			first = b;

		if (c.compareTo(first) < 0)
			first = c;

		return first;
	}

	// Takes an integer to identify the month and boolean value to check which
	// hemisphere is the user talking about, and returns the season in that
	// hemisphere for that month.
	public String season(int month, boolean inNorthernHemisphere) {
		if (inNorthernHemisphere == true) {
			if (month == 1 || month == 2 || month == 12)
				return "Winter";
			else if (month >= 3 && month <= 5)
				return "Spring";
			else if (month >= 6 && month <= 8)
				return "Summer";
			else if (month >= 9 && month <= 11)
				return "Fall";
		}

		if (inNorthernHemisphere == false) {
			if (month == 1 || month == 2 || month == 12)
				return "Summer";
			else if (month >= 3 && month <= 5)
				return "Fall";
			else if (month >= 6 && month <= 8)
				return "Winter";
			else if (month >= 9 && month <= 11)
				return "Spring";
		}

		return "";
	}

}
