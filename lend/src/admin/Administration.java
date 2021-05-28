package admin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import data.Actor;
import data.Author;
import data.Book;
import data.Customer;
import data.LendingItem;
import data.Movie;
import data.Person;
import persistence.DAOFactory;
import persistence.DataManager;
import persistence.DataSource;

public class Administration {
	private static final Logger LOGGER = Logger.getLogger(Administration.class.getName());
	private DataManager dataManager;
	private DAOFactory daoFactory;
	private LendingManager lendingManager;

	public Administration() {
		// create all managers
		log("create data manager");
		daoFactory = new DAOFactory(DataSource.MEMORY); // FILE
		dataManager = new DataManager();
		lendingManager = new LendingManager();

		// add some customers
		List<Customer> customers = daoFactory.createCustomerDAO().loadCustomers();
		dataManager.setCustomers(customers);
		for (Customer customer : dataManager.getCustomers()) {
			System.out.println(customer);
		}
		// add some books
		List<Book> books = daoFactory.createBookDAO().loadBooks();
		dataManager.setBooks(books);
		for (LendingItem book : dataManager.getBooks()) {
			System.out.println(book);
		}
		// add some movies
		List<Movie> movies = daoFactory.createMovieDAO().loadMovies();
		dataManager.setMovies(movies);
		for (LendingItem movie : dataManager.getMovies()) {
			System.out.println(movie);
		}
	}

	public LendingManager getLendingManager() {
		return lendingManager;
	}

	public DataManager getDataManager() {
		return dataManager;
	}
	
	public ArrayList<Book> findItems(Author author) {
		List<Book> books = dataManager.getBooks();
		ArrayList<Book> filteredList = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				filteredList.add(book);
			}
		}
		if (filteredList.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return filteredList;
	}
	
	public ArrayList<Movie> findItems(Actor actor) {
		List<Movie> movies = dataManager.getMovies();
		ArrayList<Movie> filteredList = new ArrayList<>();
		for (Movie movie : movies) {
			if (movie.getActors().contains(actor)) {
				filteredList.add(movie);
			}
		}
		if (filteredList.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return filteredList;
	}
	
	public LendingItem findItem(int id) {
		for (Movie movie : dataManager.getMovies()) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		for (Book book : dataManager.getBooks()) {
			if (book.getId() == id) {
				return book;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public List<LendingItem> findItems(String title) {
		List<Book> books = dataManager.getBooks();
		List<LendingItem> filteredList = new ArrayList<>();
		
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				filteredList.add(book);
			}
		}
		if (filteredList.isEmpty()) {
			throw new IllegalArgumentException();
		}
		List<Movie> movies = dataManager.getMovies();
		for (Movie movie : movies) {
			if (movie.getTitle().contains(title)) {
				filteredList.add(movie);
			}
		}
		return filteredList;
	}
	public Person findPerson(String lastName, String firstName) {
		for (Person person : dataManager.getCustomers()) {
			if (person.getLastName().equals(lastName)
					&& person.getFirstName().equals(firstName)) {
				return person;
			}
		}
		throw new IllegalArgumentException();
	}

	private void log(String stmt) {
		LOGGER.info(stmt);
	}

	public static void main(String[] args) {
		Administration admin = new Administration();
		//Customer c = new Customer("", "hans");
		//Customer c1 = new Customer("meier", "");
		Customer c2 = new Customer("meier", "hans");
	}

}
