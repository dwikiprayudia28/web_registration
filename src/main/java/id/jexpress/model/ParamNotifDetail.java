package id.jexpress.model;

public class ParamNotifDetail {

	private String userSender;
	private String jtrId;
	private String msgNotif;
	private String typeNotif;

	public ParamNotifDetail() {}

	public ParamNotifDetail(String userSender, String jtrId, String msgNotif,
			String typeNotif) {
		this.userSender = userSender;
		this.jtrId = jtrId;
		this.msgNotif = msgNotif;
		this.typeNotif = typeNotif;
	}

	public String getUserSender() {
		return userSender;
	}

	public void setUserSender(String userSender) {
		this.userSender = userSender;
	}

	public String getJtrId() {
		return jtrId;
	}

	public void setJtrId(String jtrId) {
		this.jtrId = jtrId;
	}

	public String getMsgNotif() {
		return msgNotif;
	}

	public void setMsgNotif(String msgNotif) {
		this.msgNotif = msgNotif;
	}

	public String getTypeNotif() {
		return typeNotif;
	}

	public void setTypeNotif(String typeNotif) {
		this.typeNotif = typeNotif;
	}

}
