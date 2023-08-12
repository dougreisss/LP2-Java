/**
 * @author Douglas Reis e Lucas Aquino
 */

public class Author {

	private String name;
	private String email;
	private char gender;

	// CONSTRUTOR
	public Author(String name, String email, char gender) {

		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	// METODO GET
	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public char getGender() {
		return this.gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		String authorFormat = String.format("Author[name=%s,email=%s,gender=%s]", this.name, this.email, this.gender);

		return authorFormat;
	}
}