package au.usyd.elec5619;

import java.io.Console;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WishlistController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/wishlist")
	public String wishlist() {
		
		return "wishlist";
	}
	
	@RequestMapping(value = "/wishlist/newWishlist")
	public String createNewWishlist() {
		
		logger.info("create new wishlist is clicked	");
    	return "createwishlist";
	}
	
	@RequestMapping(value = "/wishlist/newWishlist",method = RequestMethod.POST)
	public String createNewWishlist(HttpServletRequest request, HttpServletResponse response) {
		
//		String wishlistname=request.getParameter("wishlistName");
//		System.out.println(wishlistname);
	     logger.info(" new wishlist created	");
    	return "redirect:/home.htm";
	}
	
	
}


