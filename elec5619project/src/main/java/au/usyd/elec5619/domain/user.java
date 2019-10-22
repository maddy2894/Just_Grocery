package au.usyd.elec5619.domain;
import java.io.Serializable;

public class user implements Serializable {
	private String username;
	private String password;
	private String email_id;
	private String first_name;
	private String last_name;
	private double postcode;
	private double mobile_no;
	
	public String getUsername()
	{	
		return username;
	}
	public void setUsername (String username)
	{
		this.username=username;
	}
	public String getPassword()
	{	
		return password;
	}
	public void setPassword (String password)
	{
		this.password=password;
	}
	public String getEmail_id()
	{	
		return email_id;
	}
	public void setEmail_id(String email_id)
	{
		this.email_id=email_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public double getPostcode() {
		return postcode;
	}
	public void setPostcode(double postcode) {
		this.postcode = postcode;
	}
	public double getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(double mobile_no) {
		this.mobile_no = mobile_no;
	}
}
