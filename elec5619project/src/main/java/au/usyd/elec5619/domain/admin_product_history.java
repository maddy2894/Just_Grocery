package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="admin_product_history")
public class admin_product_history implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="serachID")
	private double searchID;
	@Column(name="product")
	private int product;
	@Column(name="retailer_tag")
	private String retailer_tag;
	@Column(name="searched_date")
	private Date searched_date;
	public double getSearchID() {
		return searchID;
	}
	public void setSearchID(double searchID) {
		this.searchID = searchID;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public String getRetailer_tag() {
		return retailer_tag;
	}
	public void setRetailer_tag(String retailer_tag) {
		this.retailer_tag = retailer_tag;
	}
	public Date getSearched_date() {
		return searched_date;
	}
	public void setSearched_date(Date searched_date) {
		this.searched_date = searched_date;
	}
	
		
}