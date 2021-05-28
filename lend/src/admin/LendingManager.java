package admin;

import java.util.ArrayList;
import java.util.List;

import data.Customer;
import data.Lending;
import data.LendingItem;
import data.State;

public class LendingManager {
	List <Lending> lendings;
	
	public LendingManager( ) {
		lendings = new ArrayList<Lending>();
	}
	
	public void addLending(Customer customer, LendingItem item) {
		if (item.getState() == State.AVAILABLE) {
			lendings.add(new Lending(customer, item));
			item.setState(State.LENT);
		}
		else {
			throw new IllegalArgumentException(); //Runtime Exception
		}
		
	}
	public  void returnItem(LendingItem item) {
		if (item.getState() == State.LENT) {
			lendings.remove(findLending(item));
			item.setState(State.AVAILABLE);
		}
		else {
			throw new IllegalArgumentException(); //Runtime Exception
		}
	}
	private Lending findLending(LendingItem item) {
		for (Lending lending: lendings) {
			if (lending.getItem().equals(item)) {
				return lending;
			}
			throw new IllegalArgumentException();
		}
		return null;
	}
	public List<Lending> getLendings() {
		return lendings;
	}
}
