/*
 * Test class
 */

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import admin.Administration;
import admin.LendingManager;
import data.Actor;
import data.Author;
import data.Book;
import data.Customer;
import data.LendingItem;
import data.Movie;
import persistence.DataManager;




public class LibraryTest {
	private static Administration admin;
	private static DataManager dataManager;

	@BeforeAll
	public static void setUp() {
		admin = new Administration();
		dataManager = admin.getDataManager();
	}

	@Test
	public void test1() {
		List<Book> books = dataManager.getBooks();
		assertEquals(17, books.size());
	}

	@Test
	public void test2() {
		List<Movie> movies = dataManager.getMovies();
		assertEquals(5, movies.size());
	}

	@Test
	public void test3() {
		List<Customer> customers = dataManager.getCustomers();
		assertEquals(10, customers.size());
	}

	@Test
	public void test4() {
		List<LendingItem> items = admin.findItems("Black");
		assertEquals(1, items.size());
	}

	@Test
	public void test5() {
		List<LendingItem> items = admin.findItems("Kings Field");
		assertEquals(1, items.size());
	}

	@Test
	public void test6() {
		Author author = new Author("Handke", "Peter");
		List<Book> items = admin.findItems(author);
		assertEquals(3, items.size());
	}

	@Test
	public void test7() {
		Actor actor = new Actor("Portman", "Natalie");
		List<Movie> items = admin.findItems(actor);
		assertEquals(1, items.size());
		assertEquals("Shapes", items.get(0).getTitle());
	}

	@Test
	public void test8() {
		Actor actor = new Actor("Delon", "Alain");
		List<Movie> items = admin.findItems(actor);
		assertEquals(3, items.size());
	}

	@Test
	public void test9() {
		Author author = new Author("Orwell", "George");
		List<Book> items = admin.findItems(author);
		assertEquals("Monday", items.get(0).getTitle());
	}

	@Test
	public void test10() {
		Author author = new Author("Handke", "Peter");
		List<Book> items = admin.findItems(author);
		assertEquals("Black", items.get(1).getTitle());
	}

	@Test
	public void test11() {
		Customer c = (Customer) admin.findPerson("Leser1", "Bruno");
		Assertions.assertNotNull(c.getEmail());
	}

//	@Test
//	public void test12() {
//		Customer c = (Customer) admin.findPerson("Hoerer5", "Kurt");
//		Assertions.assertNull(c.getEmail());
//	}
	 @Test
		public void test13() {
			LendingManager lendingManager = admin.getLendingManager();
			Movie movie = dataManager.getMovies().get(0);
			lendingManager.addLending(dataManager.getCustomers().get(0), movie);
			assertThrows(IllegalArgumentException.class,
				() -> lendingManager.addLending(dataManager.getCustomers().get(1), movie));
			lendingManager.returnItem(movie);
			assertEquals(0, lendingManager.getLendings().size());
		}

		@Test
		public void test14() {
			LendingManager lendingManager = admin.getLendingManager();
			Book book = dataManager.getBooks().get(0);
			lendingManager.addLending(dataManager.getCustomers().get(0), book);
			assertThrows(IllegalArgumentException.class,
				() -> lendingManager.addLending(dataManager.getCustomers().get(1), book));
			assertEquals(1, lendingManager.getLendings().size());
			lendingManager.returnItem(book);
			assertEquals(0, lendingManager.getLendings().size());
		}

		@Test
		public void test15() {
			LendingManager lendingManager = admin.getLendingManager();
			Book book = dataManager.getBooks().get(0);
			lendingManager.addLending(dataManager.getCustomers().get(0), book);
			assertEquals(1, lendingManager.getLendings().size());
			lendingManager.returnItem(book);
			assertThrows(IllegalArgumentException.class, () -> lendingManager.returnItem(book));
			assertEquals(0, lendingManager.getLendings().size());
		}

		@Test
		public void test16() {
			LendingManager lendingManager = admin.getLendingManager();
			Movie movie = dataManager.getMovies().get(0);
			lendingManager.addLending(dataManager.getCustomers().get(0), movie);
			lendingManager.returnItem(movie);
			assertThrows(IllegalArgumentException.class, () -> lendingManager.returnItem(movie));
			assertEquals(0, lendingManager.getLendings().size());
		}

		@Test
		public void test17() {
			Author author = new Author("Handke", "Hans");
			assertThrows(IllegalArgumentException.class, () -> admin.findItems(author));
		}

		@Test
		public void test18() {
			Actor actor = new Actor("Weiss", "Bruno");
			assertThrows(IllegalArgumentException.class, () -> admin.findItems(actor));
		}

		@Test
		public void test19() {
			assertThrows(IllegalArgumentException.class, () -> admin.findItem(17));
		}
		
		@Test
		public void test20() {
			assertThrows(IllegalArgumentException.class, () -> admin.findItem(17));
		}
}
