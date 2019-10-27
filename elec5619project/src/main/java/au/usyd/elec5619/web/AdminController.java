package au.usyd.elec5619.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.domain.user;
import au.usyd.elec5619.service.AdminManager;


@Controller
//@RequestMapping(value="/**")
public class AdminController {
	
	@Resource(name="adminManager")
	private AdminManager adminManager;
	
	
	@RequestMapping(value="/add_product")
	public String addProduct(Model uiModel) {
		System.out.println("I am at the addproduct");
		return "add_product";
	}
	
	@RequestMapping(value="/add_product", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest, Model uiModel) {
		System.out.println("I am at the addproduct");
		product_prices newproduct = new product_prices();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String now = simpleDateFormat.format(new Date());
		uiModel.addAttribute("date",now);
		
		newproduct.setProduct_id(httpServletRequest.getParameter("product_id"));
		newproduct.setRetailer_id(httpServletRequest.getParameter("retailer_id"));
			
		newproduct.setProduct_name(httpServletRequest.getParameter("product_name"));
	
		newproduct.setPrice(httpServletRequest.getParameter("price"));
		if(newproduct.getPrice()==null) {
			return "add_product";
		}
		else
		{
			this.adminManager.addProduct(newproduct);
			return "add_product";
		}
		
	}	

	@RequestMapping(value="/user_details")
	public ModelAndView updateUserProfile(HttpServletRequest httpServletRequest) {
		
		  System.out.println("In post method"); 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", this.adminManager.updateuserprofile());
		return new ModelAndView("user_details","model",myModel);
	}
	  @RequestMapping(value="/user_details", method=RequestMethod.POST)
	  public String updateUserProfiles(HttpServletRequest httpServletRequest)
	  { System.out.println("I am at the updateuserprofile");
	  
	  	user userdetails = new user();
	  	userdetails.setEmail_id(httpServletRequest.getParameter("email_id"));
	  	userdetails.setFirst_name(httpServletRequest.getParameter("first_name"));
	  	userdetails.setLast_name(httpServletRequest.getParameter("last_name"));
	  	userdetails.setMobile_no(httpServletRequest.getParameter("mobile_no"));
	  	userdetails.setPasswd(httpServletRequest.getParameter("passwd"));
	  	userdetails.setPost_code(Integer.valueOf(httpServletRequest.getParameter("post_code")));
	  	
	  	this.adminManager.modifiedUserProfile(userdetails);
	   
	  	return "success_profile";
	  }
	 
	
	@RequestMapping(value="/add_retailer")
	public String add_retailer(Model uiModel) {
		System.out.println("I am at the addretailer");
		
		return "add_retailer";
	}
	@RequestMapping(value="/add_retailer", method=RequestMethod.POST)
	public String addRetailer(HttpServletRequest httpServletRequest, Model uiModel) {
		
		System.out.println("I am at the addretailer2");
		retailer retailer = new retailer();
	
		retailer.setName(httpServletRequest.getParameter("name"));
		retailer.setContact(httpServletRequest.getParameter("contact"));
		retailer.setTag(httpServletRequest.getParameter("tag"));
		retailer.setLocation(httpServletRequest.getParameter("location"));
		
		System.out.println(retailer.getLocation());
		
		retailer.setPost_code(Integer.valueOf(httpServletRequest.getParameter("postcode")));
		int value = this.adminManager.addRetailer(retailer);
		System.out.println(value);
		
		return "add_retailer";
	}
	

	@RequestMapping(value="/userlogininfo" )
	public ModelAndView getUserInfo(HttpServletRequest httpServletRequest) {
		
		System.out.println("In post method of userlogininfo"); 
		Map<String, Object> myModel = new HashMap<String, Object>();
		Gson gsonObj = new Gson();
		
		  String dataPointsUser = gsonObj.toJson(this.adminManager.getUserInfo());
		  myModel.put("login_details_id",dataPointsUser );
		  
		  String dataPointProduct = gsonObj.toJson(this.adminManager.getProductInfo());
		  myModel.put("product_info",dataPointProduct);
		 
		String dataPointNoUserCount = gsonObj.toJson(this.adminManager.getNumberOfLogs());
		myModel.put("number_of_logs", dataPointNoUserCount);
		
		String dataPointerProductSearched = gsonObj.toJson(this.adminManager.getProductByDay());
		myModel.put("search_by_day", dataPointerProductSearched);
		
		return new ModelAndView("/userlogininfo","model",myModel);
	}
	@RequestMapping(value="/userloginfo", method=RequestMethod.POST) 
		public String addProducts(Model uiModel) {
			System.out.println("I am at the addproduct");
			return "add_product";
	}
	@RequestMapping(value="/userloginfo", method=RequestMethod.GET) 
	public String addRetailer(Model uiModel) {
		System.out.println("I am at the addproduct");
		return "add_retailer";
}
	
}