package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="login_details_ad")

public class login_details_ad implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="login_number")
	private int login_number;
	
	@Column(name="email_id")
	private String  email_id;
	
	@Column(name="login_time")
	private Date login_time;
	
	@Column(name ="logout_time")
	private Date logout_time;
	
	@Column(name ="elapsed_minutes")
	private double elapsed_minutes;
	
	public int getLogin_number() {
		return login_number;
	}
	public void setLogin_number(int login_number) {
		this.login_number = login_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Date getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Date logout_time) {
		this.logout_time = logout_time;
	}
	public double getElapsed_minutes() {
		return elapsed_minutes;
	}
	public void setElapsed_minutes(double number) {
		this.elapsed_minutes = number;
	}
	
}