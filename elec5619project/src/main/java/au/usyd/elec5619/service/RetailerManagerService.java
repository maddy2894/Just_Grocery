package au.usyd.elec5619.service;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.domain.user;

public class RetailerManagerService implements AdminManager {
	private static final Logger logger = LoggerFactory.getLogger(RetailerManagerService.class);
	private List<retailer> retailers;
	public List<retailer> getRetailers() {
		logger.info("in service");
		return retailers;
	}
	public void setRetailers(List<retailer> retailers) {
		this.retailers = retailers;
	}
	@Override
	public void addProduct(product_prices newproduct) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<String> getProductsName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<user> updateuserprofile() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void modifiedUserProfile(user user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int addRetailer(retailer retailer) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Map<Object, Object>> getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<Object, Object>> getProductInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<Object, Object>> getNumberOfLogs() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<Object, Object>> getProductByDay() {
		// TODO Auto-generated method stub
		return null;
	}

}