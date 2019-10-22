package au.usyd.elec5619.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.usyd.elec5619.domain.product_prices;;

public class ProductManagerService implements ProductManager {
	
	private static final Logger logger = LoggerFactory.getLogger(RetailerManagerService.class);
	private List<product_prices> products;
	public List<product_prices> getProducts(String name) {
		logger.info("in Service DB one.");
		return products;
	}

}
