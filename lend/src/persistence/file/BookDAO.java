package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import data.Author;
import data.Book;
import persistence.DAOFactory;
import persistence.IBookDAO;

public class BookDAO implements IBookDAO {
	private File bookFile;
	private String delimiter = DAOFactory.DELIMITER;
	private static final Logger LOGGER = Logger.getLogger(BookDAO.class.getName());

	public BookDAO() {
		ClassLoader classLoader = getClass().getClassLoader();
		this.bookFile = new File(classLoader.getResource(DAOFactory.BOOK_FILE).getFile());
	}

	@Override
	public ArrayList<Book> loadBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		log("Load books from file");
		try (Scanner scanner = new Scanner(new FileReader(bookFile))) {
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				long id = Long.parseLong(tokens[0]);
				String title = tokens[1];
				Author author = new Author(tokens[2], tokens[3]);
				Book book = new Book(id, title, author);
				books.add(book);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Book Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Book Datei ist korrupt");
		}
		return books;

	}

	private void log(String stmt) {
		LOGGER.info(stmt);
	}

}
