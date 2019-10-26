package au.usyd.elec5619.web;

import java.io.Console;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import au.usyd.elec5619.service.WishListManager;


import javax.annotation.*;
import au.usyd.elec5619.domain.wish_list;


@Controller
@RequestMapping(value = "/wishlist/**")
public class WishlistController {
	

	private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);
	@Resource(name="wishlistManager")
	public WishListManager wishlistManager;
	@Resource(name="retailerManager")
	public RetailerManager retailerManager;
	
	@RequestMapping(value = "/")
	public ModelAndView wishlist() {
		
		List wishlists= wishlistManager.getAllWishlists();
		System.out.println(wishlists);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("wishlists",wishlists);
		return new ModelAndView("wishlist","model",myModel);
	}
	
	@RequestMapping(value = "/newWishlist")
	public ModelAndView createNewWishlist() {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("retailers", this.retailerManager.getRetailers());
    	return new ModelAndView("createwishlist","model",myModel);
	}
	
	
	@RequestMapping(value = "/saveWishlist", method = RequestMethod.POST)
	public ModelAndView createNewWishlist(HttpServletRequest request, HttpServletResponse response) {
		
         
        String wishlistname=request.getParameter("wishlistName");
		String productList=request.getParameter("form-control");
		
		System.out.println("wishlistname"+wishlistname);
		System.out.println("productList"+productList);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("productList", productList);
		myModel.put("wishlistname", wishlistname);
		
        wish_list wishlist1=new wish_list();
        wishlist1.setWishlist_name(wishlistname);
        wishlist1.setList_of_products(productList);
        wishlist1.setEmail_id("pooja@gmail.com");
        
        Date updated_time=(new Date());
        wishlist1.setUpdated_time(updated_time);
        
        String is_active="true";
        wishlist1.setIs_active(is_active);
        
        
   
        String message= wishlistManager.getWishlistName(wishlistname);
       
       if(message=="Wishlist Name Already exists")
       {
       myModel.put("message",message);
       }
        
      else{
    	   wishlistManager.saveWishlist(wishlist1);
       }		
    	return new ModelAndView("savedWishlist","model",myModel);
	}
	
	@RequestMapping(value = "/editWishList", method=RequestMethod.POST)
	public ModelAndView editWishlist(HttpServletRequest httpServletRequest) {
		
		System.out.println(	httpServletRequest.getParameter("wishlist_name"));
		System.out.println("Old Wishlist Name"+httpServletRequest.getParameter("oldwishlist_name"));
		
		List details = wishlistManager.getOneWishList(httpServletRequest.getParameter("wishlist_name"));
		System.out.println(details);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("wishlistdetails", details);
		myModel.put("retailers", this.retailerManager.getRetailers());
		
		return new ModelAndView("editWishList","model",myModel);
	}
	
	@RequestMapping(value = "/saveEditedWishList", method=RequestMethod.POST)
	public String saveEditedWishList(HttpServletRequest httpServletRequest) {	
		
		String oldwishlist_name= httpServletRequest.getParameter("oldwishlist_name");
		   String is_Active;
		String isActive = httpServletRequest.getParameter("isActive");
		System.out.println("isActive"+isActive);
		
		wish_list wishlist1=new wish_list();
        wishlist1.setWishlist_name(httpServletRequest.getParameter("wishlistName"));
        wishlist1.setList_of_products(httpServletRequest.getParameter("form-control"));
        wishlist1.setEmail_id("pooja@gmail.com");
        
        Date updated_time=(new Date());
        wishlist1.setUpdated_time(updated_time);
        
        if(isActive.equals("inactive")) {
           is_Active="false";
           wishlist1.setIs_active(is_Active);
           wishlistManager.makeWishListInActive(wishlist1);
        }
        else {
        	is_Active="true";
        }
        wishlist1.setIs_active(is_Active);
		
        wishlistManager.saveEditedWishList(wishlist1,oldwishlist_name);
		return "redirect:/wishlist/";
		
		
	}
	
	
}





