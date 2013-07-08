// Unit test for a Simple Movie class that only has a title and a rating
import static org.junit.Assert.*;
import org.junit.Test;

public class MovieTest {

	@Test
	public void testGetters() {
		Movie m1 = new Movie("The Matrix Revolutions", 4);
		Movie m2 = new Movie("The Lord of the Rings, Return of the King", 5);
		Movie m3 = new Movie("Click", 2);

		assertEquals("The Matrix Revolutions", m1.getTitle());
		assertEquals("The Lord of the Rings, Return of the King", m2.getTitle());
		assertEquals("Click", m3.getTitle());

		assertEquals("The Matrix Revolutions ****", m1.toString());
		assertEquals("The Lord of the Rings, Return of the King *****",
				m2.toString());
		assertEquals("Click **", m3.toString());
	}
}