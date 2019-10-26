package au.usyd.elec5619.domain;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_prices_new")
public class product_prices implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="uniqueid")
	private String id;
	@Column(name="price_date")
	private Date price_date;
	@Column(name="product_id")
	private String product_id;
	@Column(name="retailer_id")
	private String retailer_id;
	@Column(name="product_name")
	private String product_name;
	@Column(name="price")
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPrice_date() {
		return price_date;
	}
	public void setPrice_date(Date price_date) {
		this.price_date = price_date;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getRetailer_id() {
		return retailer_id;
	}
	public void setRetailer_id(String retailer_id) {
		this.retailer_id = retailer_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

	
}
