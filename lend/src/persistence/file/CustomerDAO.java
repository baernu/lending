package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import data.Customer;
import persistence.DAOFactory;
import persistence.ICustomerDAO;

public class CustomerDAO implements ICustomerDAO{
	private File customerFile;
	private String delimiter = DAOFactory.DELIMITER;
	private static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	
	public CustomerDAO() {
		ClassLoader classLoader = getClass().getClassLoader();
		this.customerFile = new File(classLoader.getResource(DAOFactory.CUSTOMER_FILE).getFile());
	}
	
	@Override
	public ArrayList<Customer> loadCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		log("Load customers from file");
		try (Scanner scanner = new Scanner(new FileReader(customerFile))) {
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				Customer customer = new Customer(tokens[0], tokens[1], tokens[2]);
				customers.add(customer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Customer Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Customer Datei ist korrupt");
		}
		return customers;
	}
	private void log(String stmt) {
		LOGGER.info(stmt);
	}
}
