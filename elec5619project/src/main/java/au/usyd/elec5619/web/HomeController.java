package au.usyd.elec5619.web;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import au.usyd.elec5619.service.RetailerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private RetailerManager retailerManager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("again logger");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * @RequestMapping(value = "/hello", method = RequestMethod.GET) public
	 * ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException,IOException { String now = (new
	 * Date()).toString(); //String products_val
	 * =(this.productManager.getProducts()).toString();
	 * logger.info("Returning hello view with " + now);
	 * //logger.info("Returning hello view with " + products_val); //return new
	 * ModelAndView("hello", "now", now); Map<String, Object> myModel = new
	 * HashMap<String, Object>(); myModel.put("now",now);
	 * logger.info("getting to issue"); myModel.put("retailer",
	 * this.retailerManager.getRetailers());
	 * 
	 * //return new ModelAndView("WEB-INF/views/hello.jsp", "model", myModel);
	 * return new ModelAndView("hello", "model", myModel);
	 * 
	 * }
	 * 
	 * public void setRetailerManager(RetailerManager retailerManager) {
	 * logger.info("setting the retailer_manager"); this.retailerManager =
	 * retailerManager; }
	 */
}
