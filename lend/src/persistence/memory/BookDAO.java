package persistence.memory;

import java.util.ArrayList;
import java.util.logging.Logger;

import data.Author;
import data.Book;
import persistence.IBookDAO;

public class BookDAO implements IBookDAO {
	private static final Logger LOGGER = Logger.getLogger(BookDAO.class.getName());

	private void log(String stmt) {
		LOGGER.info(stmt);
	}

	@Override
	public ArrayList<Book> loadBooks() {
		ArrayList<Book> books = new ArrayList<>();
		log("load books");
		books.add(new Book(593, "The Letter", new Author("Woolf", "Virinia", "Great Britain")));
		books.add(new Book(559, "Monday", new Author("Kerr", "Judith", "Germany")));
		books.add(new Book(491, "Behind the Moon", new Author("Smith", "Zadie", "Great Britain")));
		books.add(new Book(815, "The Outsider", new Author("Kerr", "Judith", "Germany")));
		books.add(new Book(457, "On the Road", new Author("Handke", "Peter", "Austria")));
		books.add(new Book(695, "Black", new Author("Handke", "Peter", "Austria")));
		books.add(new Book(542, "Kings Field", new Author("Handke", "Peter", "Austria")));
		books.add(new Book(474, "Monday", new Author("Orwell", "George", "India")));
		books.add(new Book(712, "The Last Day", new Author("Orwell", "George", "India")));
		books.add(new Book(644, "Six of Crows", new Author("Orwell", "George", "India")));
		books.add(new Book(525, "The Hour", new Author("Woolf", "Virinia", "Great Britain")));
		books.add(new Book(661, "Tombland", new Author("Woolf", "Virinia", "Great Britain")));
		books.add(new Book(627, "The Hill House", new Author("Smith", "Zadie", "Great Britain")));
		books.add(new Book(576, "Lucky Men", new Author("Smith", "Zadie", "Great Britain")));
		books.add(new Book(508, "The Day After", new Author("James", "Peter", "Great Britain")));
		books.add(new Book(610, "Player One", new Author("James", "Peter", "Great Britain")));
		books.add(new Book(678, "The Lost Man", new Author("Kerr", "Judith", "Germany")));

		return books;
	}

}
