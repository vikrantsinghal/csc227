import java.util.Random;

public class Dice {
	private char[] data;
	boolean selected;
	
	public Dice(char[] array) {
		data = new char[6];
		selected = false;
		for (int i = 0; i < 6; i++)
			data[i] = array[i];
	}
	
	public char get() {
		Random generator = new Random();
		int index = generator.nextInt(6);
		return data[index];
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < 6; i++)
			result = result + data[i] + " ";
		result = result.trim();
		return result;
	}
	
	public boolean isSelected() {
		if (this.selected == true)
			return true;
		return false;
	}
	
	public void select(boolean value) {
		this.selected = value;
	}
}
