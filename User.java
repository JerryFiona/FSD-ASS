
public class User {
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	
	
	public User(String initialName) {
		username = initialName;
	}
	public void setUsername(String newUsername) {
		this.username=newUsername;
	}
	public void setPassword(String newPassword) {
		this.password=newPassword;
	}
	public void setEmail(String newEmail) {
		this.email=newEmail;
	}
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber=newPhoneNumber;
	}
	
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}
	
}
