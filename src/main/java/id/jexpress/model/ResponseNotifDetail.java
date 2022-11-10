package id.jexpress.model;

public class ResponseNotifDetail {

	private String username;
	private String decision;

	public ResponseNotifDetail() {
	}

	public ResponseNotifDetail(String username, String decision) {
		this.username = username;
		this.decision = decision;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

}
