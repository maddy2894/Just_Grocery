package au.usyd.elec5619.web;
import java.util.Date; 

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.stereotype.Controller;
import au.usyd.elec5619.service.ProductService;
import javax.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.user;
import au.usyd.elec5619.domain.admin_product_history;

@Controller
@RequestMapping(value = "/product/**")
public class ProductController{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	
	@Resource(name = "productService")
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		
		Object test = session.getAttribute("user");
		logger.info(" "+ test.toString());
		product_prices search = new product_prices();

		return new ModelAndView("product", "search", search);
	}
	
	@RequestMapping(value = "/get_products", method = RequestMethod.GET, headers="Accept=*/*")
	public List<String> getProductList(@RequestParam("term") String query) {

		return productService.getProductsList(query);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	
	Date now = new Date();
	String searchedProduct = request.getParameter("search");
	admin_product_history searched_product = new admin_product_history();
	searched_product.setProduct(searchedProduct);
	searched_product.setSearched_date(now);
	logger.info("loggerInfo" + this.productService.getProducts(searchedProduct, searched_product));
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now",now);
	myModel.put("products", this.productService.getProducts(searchedProduct, searched_product));
	return new ModelAndView("search", "model", myModel);
	
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,IOException {
	logger.info("Products fetched is " + request.getParameter("add"));

	
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}