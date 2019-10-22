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
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.stereotype.Controller;
import au.usyd.elec5619.service.RetailerManager;
import javax.annotation.*;


@Controller
public class RetailerController{
//	protected final Log logger = LogFactory.getLog(getClass());
	private static final Logger logger = LoggerFactory.getLogger(RetailerController.class);
	
	@Resource(name="retailerManager")
	private RetailerManager retailerManager;
	//System.out.print('____________________________________________')
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,IOException {
	String now = (new Date()).toString();
	//String products_val =(this.productManager.getProducts()).toString();
	logger.info("Returning hello view with " + now);
	//logger.info("Returning hello view with " + products_val);
	//return new ModelAndView("hello", "now", now);
	Map<String, Object> myModel = new HashMap<String, Object>();
	myModel.put("now",now);
	logger.info("Retailers fetched is " + this.retailerManager.getRetailers());
	myModel.put("retailers", this.retailerManager.getRetailers());
	
	//return new ModelAndView("WEB-INF/views/hello.jsp", "model", myModel);
	return new ModelAndView("hello", "model", myModel);
	
	}
	
	public void setRetailerManager(RetailerManager retailerManager) {
		this.retailerManager = retailerManager;
	}
}