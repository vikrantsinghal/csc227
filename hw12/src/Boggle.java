import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boggle {
	private BoggleTray boggleTray;
	List<String> listOfWords;
	int score;
	List<String> listOfPossibleWords;
	int possibleWords;
	
	public Boggle() {
		listOfWords = new LinkedList<String>();
		listOfPossibleWords = new LinkedList<String>();
		score = 0;
		boggleTray = new BoggleTray();
		setPossibleWords();
	}
	
	public void setBoggleTray(BoggleTray bt) {
		this.boggleTray = bt;
		setPossibleWords();
	}
	
	private void setPossibleWords() {
		int count = 0;
		Scanner wordScanner = null;
		try {
			wordScanner = new Scanner(new FileInputStream("WordList.txt"));
		} catch (FileNotFoundException e) {
		}
		while (wordScanner.hasNext()) {
			String str = wordScanner.next();
			if (boggleTray.foundInBoggleTray(str)) {
				listOfPossibleWords.add(count, str);
				count++;
			}
		}
		possibleWords = count;
	}
	
	public String getBoggleTrayAsString() {
		return boggleTray.toString();
	}
	
	public void addGuess(String oneGuess) {
		if (oneGuess.length() == 0)
			return;
		if (!listOfWords.contains(oneGuess.toLowerCase()))
			listOfWords.add(oneGuess.toLowerCase());
	}
	
	public List<String> getWordsFound() {
		LinkedList<String> result = new LinkedList<String>();
		String[] temp = new String[listOfWords.size()];
		int count = 0;
		for (int i = 0; i < listOfWords.size(); i++) {
			if (listOfPossibleWords.contains(listOfWords.get(i))) {
				temp[count] = listOfWords.get(i);
				count++;
			}
		}
		selectionSort(temp, count);
		for (int i = 0; i < count; i++) {
			result.add(i, temp[i]);
		}
		return result;
	}
	
	private void selectionSort(String[] str, int size) {
		int indexOfSmallest = 0;
		for (int top = 0; top < size - 1; top++) {
			indexOfSmallest = top;
			for (int index = top + 1; index < size; index++) {
				if (str[index].compareTo(str[indexOfSmallest]) < 0)
					indexOfSmallest = index;
			}
			String temp = str[top];
			str[top] = str[indexOfSmallest];
			str[indexOfSmallest] = temp;
		}
	}

	public List<String> getWordsIncorrect() {
		LinkedList<String> incorrectWords = new LinkedList<String>();
		String[] temp = new String[listOfWords.size()];
		int count = 0;
		for (int i = 0; i < listOfWords.size(); i++) {
			if (listOfWords.get(i).length() < 3 || !listOfPossibleWords.contains(listOfWords.get(i))) {
				temp[count] = listOfWords.get(i);
				count++;
			}
		}
		selectionSort(temp, count);
		for (int i = 0; i < count; i++) {
			incorrectWords.add(i, temp[i]);
		}
		return incorrectWords;
	}
	
	public List<String> getWordsNotGuessed() {
		LinkedList<String> result = new LinkedList<String>();
		String[] array = new String[possibleWords];
		int count = 0;
		for (int i = 0; i < possibleWords; i++) {
			String temp = listOfPossibleWords.get(i);
			if (listOfWords.contains(temp) == false) {
				array[count] = temp;
				count++;
			}
		}
		selectionSort(array, count);
		for (int i = 0; i < count; i++) {
			result.add(i, array[i]);
		}
		return result;
	}
	
	public int getScore() {
		int score = 0;
		List<String> correctWords = this.getWordsFound();
		for (int i = 0; i < this.wordsRightNumber(); i++) {
			String temp = correctWords.get(i);
			score = score + calcCorrectPoints(temp);
		}
		score = score - this.wordsWrongNumber();
		return score;
	}
	
	private int calcCorrectPoints(String str) {
		int length = str.length();
		if (length == 3 || length == 4)
			return 1;
		if (length == 5)
			return 2;
		if (length == 6)
			return 3;
		if (length == 7)
			return 5;
		return 11;
	}

	public int wordsRightNumber() {
		return getWordsFound().size();
	}
	
	public int wordsWrongNumber() {
		return getWordsIncorrect().size();
	}
	
	public int wordsMissedNumber() {
		return getWordsNotGuessed().size();
	}
}
