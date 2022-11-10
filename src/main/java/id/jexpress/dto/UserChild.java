package id.jexpress.dto;

import id.jexpress.model.User;

import java.io.Serializable;
import java.util.List;

public class UserChild implements Serializable {

	private static final long serialVersionUID = 1875385169314766778L;

	private List<User> listUserChild;
	private String strIdChild;


	public List<User> getListUserChild() {
		return listUserChild;
	}

	public void setListUserChild(List<User> listUserChild) {
		this.listUserChild = listUserChild;
	}

	public String getStrIdChild() {
		return strIdChild;
	}

	public void setStrIdChild(String strIdChild) {
		this.strIdChild = strIdChild;
	}

}
