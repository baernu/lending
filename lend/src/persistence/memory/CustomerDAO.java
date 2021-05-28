package persistence.memory;

import java.util.ArrayList;
import java.util.logging.Logger;

import data.Customer;
import persistence.ICustomerDAO;

public class CustomerDAO implements ICustomerDAO {
	private String[][] customerInput;
	private static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());

	public CustomerDAO() {
		customerInput = init();
	}

	@Override
	public ArrayList<Customer> loadCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		log("load customers");
		for (String[] input : customerInput) {
			String lastName = input[0];
			String firstName = input[1];
			String email = input[2];
			Customer customer = new Customer(lastName, firstName, email);
			customers.add(customer);
		}
		return customers;
	}

	private void log(String stmt) {
		LOGGER.info(stmt);
	}

	private String[][] init() {
		String[][] input = { { "Leser1", "Bruno", "bruno@leser1.com" }, { "Seher1", "Kurt", "kurt@seher1.com" },
				{ "Hoerer1", "Emma", "emma@hoerer1.com" }, { "Leser2", "Emma", "emma@leser2.com" },
				{ "Seher2", "Bruno", "bruno@seher2.ch" }, { "Hoerer2", "Kurt", "kurt@hoerer2.edu" },
				{ "Hoerer3", "Emma", "emma@hoerer3.ch" }, { "Leser4", "Emma", "emma@leser4.de" },
				{ "Seher4", "Bruno", "bruno@seher4.it" }, { "Hoerer2", "Bruno", "bruno@abc.com" } };
		return input;
	}
}
