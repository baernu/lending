package data;

public class Author extends Person{
	private String origin;
	
	public Author(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	public Author(String firstName, String lastName, String origin) {
		this(firstName, lastName);
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Author [origin=" + origin + "]";
	}
	
	

}
