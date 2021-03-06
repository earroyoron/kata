package kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testNewRelease() {
		Movie movie = new Movie("Heat",Movie.NEW_RELEASE);
		Rental r = new Rental(movie, 2);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tHeat\t6.0\n"+
				"Amount owed is 6.0\n"+
				"You earned 2 frequent renter points", st);	}
	
	@Test
	public void testChildrensMenosDe3Dias() {
		Movie movie = new Movie("Cars2",Movie.CHILDRENS);
		Rental r = new Rental(movie, 2);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tCars2\t1.5\n"+
				"Amount owed is 1.5\n"+
				"You earned 1 frequent renter points", st);	}
	
	@Test
	public void testChildrensMasDe3Dias() {
		Movie movie = new Movie("Cars2",Movie.CHILDRENS);
		Rental r = new Rental(movie, 7);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tCars2\t7.5\n"+
				"Amount owed is 7.5\n"+
				"You earned 1 frequent renter points", st);	}
	
	@Test
	public void testRegularMenosDe3Dias() {
		Movie movie = new Movie("Torero",Movie.REGULAR);
		Rental r = new Rental(movie, 2);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tTorero\t2.0\n"+
				"Amount owed is 2.0\n"+
				"You earned 1 frequent renter points", st);	}

	@Test
	public void testRegularMasDe3Dias() {
		Movie movie = new Movie("Torero",Movie.REGULAR);
		Rental r = new Rental(movie, 5);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tTorero\t6.5\n"+
				"Amount owed is 6.5\n"+
				"You earned 1 frequent renter points", st);	}
	
	@Test
	public void testDeTodoUnPoco() {
		Movie movie = new Movie("Torero",Movie.REGULAR);
		Movie movie2 = new Movie("Cars2",Movie.CHILDRENS);
		Rental r = new Rental(movie, 5);
		Rental r2 = new Rental(movie2, 2);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		c.addRental(r2);
		String st = c.statement();
		assertEquals("Rental Record for Ernesto Arroyo\n"+
				"\tTorero\t6.5\n"+
				"\tCars2\t1.5\n"+
				"Amount owed is 8.0\n"+
				"You earned 2 frequent renter points", st);	}
}
