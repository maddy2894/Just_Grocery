package au.usyd.elec5619.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.web.HomeController;

public class RetailerManagerService implements RetailerManager {
	private static final Logger logger = LoggerFactory.getLogger(RetailerManagerService.class);
	private List<retailer> retailers;
	public List<retailer> getRetailers() {
		logger.info("in service");
		return retailers;
	}
	public void setRetailers(List<retailer> retailers) {
		this.retailers = retailers;
	}

}
