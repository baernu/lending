package persistence;



public class DAOFactory {
	private DataSource dataSource;
	public static final String DELIMITER = ";";
	public static final String CUSTOMER_FILE = "customers.csv";
	public static final String BOOK_FILE = "books.csv";
	public static final String FILM_FILE = "movies.csv";
	
	public DAOFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ICustomerDAO createCustomerDAO() {
		if (dataSource == DataSource.FILE) {
			return new persistence.file.CustomerDAO();
		} else if (dataSource == DataSource.MEMORY) {
			return new persistence.memory.CustomerDAO();
		} else {
			return null;
		}
	}
	
	public IBookDAO createBookDAO() {
		if (dataSource == DataSource.FILE) {
			return new persistence.file.BookDAO();
		} else if (dataSource == DataSource.MEMORY) {
			return new persistence.memory.BookDAO();
		} else {
			return null;
		}
	}
	
	public IMovieDAO createMovieDAO() {
		if (dataSource == DataSource.FILE) {
			return new persistence.file.MovieDAO();
		} else if (dataSource == DataSource.MEMORY) {
			return new persistence.memory.MovieDAO();
		} else {
			return null;
		}
	}
}
