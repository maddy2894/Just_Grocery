package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import au.usyd.elec5619.service.ComparisonDAOInt;
import au.usyd.elec5619.service.ComparisonServiceInt;
import javax.annotation.*;


@Controller
public class WishlistComparisonController
{
	  private static final Logger logger = LoggerFactory.getLogger(WishlistComparisonController.class);
	
	  @Resource(name="comparisonDAO")
	  private ComparisonDAOInt comparisonDAO;
	
	  @Resource(name="comparisonServiceLayer")
  	  private ComparisonServiceInt comparisonServiceLayer;
	
	  @RequestMapping(value = "/wishListComparison", method = RequestMethod.GET)
	  public ModelAndView handleRequest_new_again(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	  Map<Object, Object> myModel = new HashMap<Object, Object>();
	  String email="pooja@gmail.com";
	  
	  List<String> Loc = this.comparisonDAO.getLocations();
	  List<String> wishlist_names=this.comparisonDAO.getWishLists(email);
	  String Location=Loc.get(0).toString();
	  String wishList_val=wishlist_names.get(0).toString();
	  String wishList = this.comparisonDAO.getProductsList(wishList_val, email) ;
	  Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataCharts(myModel, Location, wishList);
	  Map<Object,Object> myModel_ret_final=this.comparisonServiceLayer.formatDataTable(myModel_ret, Location, wishList);
	  myModel_ret_final.put("location", Loc); 
	  myModel_ret_final.put("WLnames", wishlist_names); 
	  myModel_ret_final.put("selected_wl", wishList_val);
	  myModel_ret_final.put("selected_loc", Location);
	  return new ModelAndView("fetchComparisonPage", "model", myModel_ret_final); 
	  }
	 
	
	@RequestMapping(value = "/wishListComparison", method = RequestMethod.POST)
	public ModelAndView handleRequest_new_again_post(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,IOException {
	Map<Object, Object> myModel = new HashMap<Object, Object>();
	String Location =request.getParameter("loc");
	String wishList_val =request.getParameter("wishlist");
	String email="pooja@gmail.com";
	String wishList = this.comparisonDAO.getProductsList(wishList_val, email) ;
	logger.info("Products from WishList are "+ wishList);
	//Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataChartsTable(myModel, Location, wishList);
	Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataCharts(myModel, Location, wishList);
	Map<Object,Object> myModel_ret_final=this.comparisonServiceLayer.formatDataTable(myModel_ret, Location, wishList);
	myModel_ret_final.put("selected_wl", wishList_val);
	myModel_ret_final.put("selected_loc", Location);
	List<String> Loc = this.comparisonDAO.getLocations();
	List<String> wishlist_names=this.comparisonDAO.getWishLists(email);
	myModel_ret_final.put("location", Loc); 
	myModel_ret_final.put("WLnames", wishlist_names); 
	return new ModelAndView("postComparison", "model", myModel_ret_final);
	}
	
	public void setComparisonDAO(ComparisonDAOInt comparisonDAO) {
		this.comparisonDAO = comparisonDAO;
	}
	
	public void setComparisonServiceLayer(ComparisonServiceInt comparisonServiceLayer) {
		this.comparisonServiceLayer = comparisonServiceLayer;
	}
}