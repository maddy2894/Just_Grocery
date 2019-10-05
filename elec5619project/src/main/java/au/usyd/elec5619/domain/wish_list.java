package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;

public class wish_list implements Serializable {
	
	String username;
	String wishlist_name;
	String [] list_of_products;
	Date updated_time;
	String is_active;
	
	public String getUsername() {
		return username;
	}
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWishlist_name() {
		return wishlist_name;
	}
	public void setWishlist_name(String wishlist_name) {
		this.wishlist_name = wishlist_name;
	}
	public String[] getList_of_products() {
		return list_of_products;
	}
	public void setList_of_products(String[] test_listofproducts) {
		this.list_of_products = test_listofproducts;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
}
