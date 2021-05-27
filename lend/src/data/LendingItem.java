package data;

public class LendingItem {
	private long id;
	private String title;
	private State state;
	
	public LendingItem(long id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.state = State.AVAILABLE;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	

}
