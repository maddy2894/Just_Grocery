package au.usyd.elec5619.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.usyd.elec5619.domain.product_list;;

public class ProductManagerService implements ProductManager {
	
//	private static final Logger logger = LoggerFactory.getLogger(RetailerManagerService.class);
	private List<product_list> products;
	public List<product_list> getProducts() {
		return products;
	}

}
