package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.product_prices;

public interface ProductManager extends Serializable {

	public List<product_prices> getProducts(String name);
}
