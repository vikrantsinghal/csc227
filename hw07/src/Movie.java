// A simple class to all the enclosed GUI to represent a movie queue.
//
public class Movie {

	private String title;
	private int rating;

	public Movie(String title, int rating) {
		this.title = title;
		this.rating = rating;
	}

	@Override
	public String toString() {
		String result = title + " ";
		for (int j = 1; j <= rating; j++)
			result += "*";

		return result;
	}

	public String getTitle() {
		return title;
	}

}
