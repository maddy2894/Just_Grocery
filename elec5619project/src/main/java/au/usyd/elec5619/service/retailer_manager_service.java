package au.usyd.elec5619.service;

import au.usyd.elec5619.domain.retailer;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class retailer_manager_service implements retailer_manager {
	private static final Logger logger = LoggerFactory.getLogger(retailer_manager_service.class);
	private List<retailer> retailers;
	
	public List<retailer> getRetailers() {
		//throw new IndexOutOfBoundsException("Index is out of bounds!");
		return retailers;
		//throw new UnsupportedOperationException();
	}

	public void setRetailers(List<retailer> retailers) {
		this.retailers = retailers;
	}
	
	

}
