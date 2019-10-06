package au.usyd.elec5619.domain;

import java.util.Date;
import java.io.Serializable;

public class admin_user_history implements Serializable {
	
	private String username;
	private Date logged_date;
	private int count;
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		username = userName;
	}
	public Date getLogged_date() {
		return logged_date;
	}
	public void setLogged_date(Date logged_date) {
		this.logged_date = logged_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}