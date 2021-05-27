package data;



public class Customer extends Person {

	private Email email;
	private String emailRegex = "[a-z0-9.]+@[a-z0-9]+.[a-z]{2,3}";

	public Customer(String firstName, String lastName) {
		super(firstName, lastName);

	}

	public Customer(String firstName, String lastName, String email) {
		this(firstName, lastName);
		try {
			this.email = new Email(email);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return super.toString() + ", Email:" + email;
	}

	public Email getEmail() {
		return email;
	}

	private class Email {
		private String email;

		public Email(String email) throws Exception {
			if (email.matches(emailRegex)) {
				this.email = email;
			} else {
				throw new Exception();
			}
		}

		@Override
		public String toString() {
			return "Email [email=" + email + "]";
		}

	}

}
