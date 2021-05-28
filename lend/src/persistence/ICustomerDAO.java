package persistence;

import java.util.ArrayList;

import data.Customer;

public interface ICustomerDAO {
	ArrayList<Customer> loadCustomers();
}
