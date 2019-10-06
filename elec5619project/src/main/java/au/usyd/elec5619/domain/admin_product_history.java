package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;

public class admin_product_history implements Serializable{
	
	private int product_list_id;
	private String retailer_tag;
	private String location;
	private int count;
	private Date searched_date;
	
	public int getProduct_list_id() {
		return product_list_id;
	}
	public void setProduct_list_id(int product_list_id) {
		this.product_list_id = product_list_id;
	}
	public String getRetailer_tag() {
		return retailer_tag;
	}
	public void setRetailer_tag(String retailer_tag) {
		this.retailer_tag = retailer_tag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getSearched_date() {
		return searched_date;
	}
	public void setSearched_date(Date searched_date) {
		this.searched_date = searched_date;
	}
	
	
}