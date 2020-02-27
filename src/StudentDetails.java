
public class StudentDetails {

	private String name;
	private String emailAddress;
	private String sessionPassword;
	private boolean isPaused;

	StudentDetails(String name, String emailAddress, String sessionPassword, boolean isPaused) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.sessionPassword = sessionPassword;
		this.isPaused = isPaused;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setSessionPassword(String sessionPassword) {
		this.sessionPassword = sessionPassword;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getSessionPassword() {
		return sessionPassword;
	}

	public boolean isPaused() {
		return isPaused;
	}

	@Override
	public String toString() {
		return name;
	}

}
