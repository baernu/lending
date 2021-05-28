package persistence;

import java.util.ArrayList;
import java.util.List;

import data.Book;
import data.Customer;
import data.Movie;

public class DataManager {
	private List<Customer> customers;
	private List<Book> books;
	private List<Movie> movies;

	
	public DataManager() {
		books = new ArrayList<Book>();
		movies = new ArrayList<Movie>();
		customers = new ArrayList<Customer>();
	}
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books2) {
		this.books = books2;
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies2) {
		this.movies = movies2;
	}
}
