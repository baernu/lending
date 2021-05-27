package data;



public class Book extends LendingItem {
	private Author author;
	private Description description;

	public Book(long id, String title, Author author) {
		super(id, title);
		this.author = author;
	}
	
	public Author getAuthor() {
		return author;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	private class Description {
		private String summery;
		private int pages;
		public Description(String summery, int pages) {
			super();
			this.summery = summery;
			this.pages = pages;
		}
		@Override
		public String toString() {
			return "Description [summery=" + summery + ", pages=" + pages + "]";
		}
		
		
	}
}
