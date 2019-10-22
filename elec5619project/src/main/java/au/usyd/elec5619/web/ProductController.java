package au.usyd.elec5619.web;
import java.util.Date; 

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.stereotype.Controller;
import au.usyd.elec5619.service.ProductManager;
import javax.annotation.*;


@Controller
@RequestMapping(value = "/product/**")
public class ProductController{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Resource(name="productManager")
	private ProductManager productManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String product() {
		return "product";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,IOException {
	String now = (new Date()).toString();
	String testName = request.getParameter("search");
	logger.info("Returning product view with " + testName);
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now",now);
	logger.info("Products fetched is " + this.productManager.getProducts(testName));
	
	myModel.put("products", this.productManager.getProducts(testName));
	return new ModelAndView("search", "model", myModel);
	
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}