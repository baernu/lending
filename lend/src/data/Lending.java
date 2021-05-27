package data;

import java.time.LocalDate;

public class Lending {
	private Customer customer;
	private LendingItem item;
	private LocalDate startDate;
	private LocalDate returnDate;
	
	public Lending(Customer customer, LendingItem item) {
		super();
		this.customer = customer;
		this.item = item;
		this.startDate = LocalDate.now();
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public LendingItem getItem() {
		return item;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	
}
