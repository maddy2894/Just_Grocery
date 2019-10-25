package au.usyd.elec5619.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.usyd.elec5619.domain.retailer;

public class RetailerManagerService implements RetailerManager {
	private static final Logger logger = LoggerFactory.getLogger(RetailerManagerService.class);
	private List<String> retailers;
	public List<String> getRetailers() {
		logger.info("in service");
		return retailers;
	}
	public void setRetailers(List<String> retailers) {
		this.retailers = retailers;
	}

}
