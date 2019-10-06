package au.usyd.elec5619.domain;

import java.util.Date;
import au.usyd.elec5619.domain.admin_product_history;

import junit.framework.TestCase;

public class admin_product_history_test extends TestCase {
	private admin_product_history admin_product_history;
	
	protected void setUp() throws Exception {
		admin_product_history = new admin_product_history();
	}
	
	public void testProduct_list_id() {
		int product_list_id = 100;
		assertEquals(0,0,0);
		admin_product_history.setProduct_list_id(product_list_id);
		assertEquals(product_list_id,admin_product_history.getProduct_list_id(),0);
	}
	public void testRetailer_tag() {
		String tag ="WOW";
		assertNull(admin_product_history.getRetailer_tag());
		admin_product_history.setRetailer_tag(tag);
		assertEquals(tag,admin_product_history.getRetailer_tag());
	}
	public void testLocation() {
		String loc ="Strathfield";
		assertNull(admin_product_history.getLocation());
		admin_product_history.setLocation(loc);
		assertEquals(loc,admin_product_history.getLocation());
	}
	public void testCount() {
		int count =5;
		assertEquals(0,0,0);
		admin_product_history.setCount(count);
		assertEquals(count,admin_product_history.getCount(),0);
		
	}
	public void testDate() {
		Date todays_date = new Date();
		assertNull(admin_product_history.getSearched_date());
		admin_product_history.setSearched_date(todays_date);
		assertEquals(todays_date,admin_product_history.getSearched_date());
	}
}