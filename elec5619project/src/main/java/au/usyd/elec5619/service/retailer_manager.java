package au.usyd.elec5619.service;
import java.io.Serializable; 
import java.util.List;

import au.usyd.elec5619.domain.retailer;

public interface retailer_manager extends Serializable {

	public List<retailer> getRetailers();
	
}
