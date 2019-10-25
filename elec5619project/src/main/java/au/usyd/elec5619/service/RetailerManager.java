package au.usyd.elec5619.service;
import java.io.Serializable; 
import java.util.List;

import au.usyd.elec5619.domain.retailer;

public interface RetailerManager extends Serializable {
	
	public List<String> getRetailers(); 

}
