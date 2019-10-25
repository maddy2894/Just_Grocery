package au.usyd.elec5619.web;

import java.io.Console;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.wish_list;
import au.usyd.elec5619.service.RetailerManager;
import javax.annotation.*;

@Controller
@RequestMapping(value = "/wishlist/**")
public class WishlistController {
	

	
	private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);
	@Resource(name="retailerManager")
	public RetailerManager retailerManager;
	
	@RequestMapping(value = "/")
	public String wishlist() {
		
		return "wishlist";
	}
	
	@RequestMapping(value = "/newWishlist")
	public ModelAndView createNewWishlist() {
		
		logger.info("create new wishlist is clicked	");
		Map<String, Object> myModel = new HashMap<String, Object>();
		logger.info("Retailers fetched is " + this.retailerManager.getRetailers());
		myModel.put("retailers", this.retailerManager.getRetailers());
		logger.info(" new wishlist created	");
	      //provide reservation object to the model   
	 
    	return new ModelAndView("createwishlist","model",myModel);
	}
	
	
	@RequestMapping(value = "/savedWishlist", method = RequestMethod.POST)
	public ModelAndView createNewWishlist(HttpServletRequest request, HttpServletResponse response) {
		
         
        String wishlistname=request.getParameter("wishlistName");
		System.out.println(wishlistname);
		System.out.println(request.getParameter("form-control"));
		String productList=request.getParameter("form-control");
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("productList", productList);
		myModel.put("wishlistname", wishlistname);
		
    	return new ModelAndView("savedWishlist","model",myModel);
	}


	

	
}


