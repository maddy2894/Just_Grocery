package au.usyd.elec5619.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.usyd.elec5619.service.ComparisonDAOInt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.*;
import au.usyd.elec5619.service.LoginManager;
import au.usyd.elec5619.service.LoginService;
import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.Controller;
import javax.annotation.*;

@Controller
@RequestMapping(value = "/home/**")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Resource(name="loginManager")
	private LoginManager loginManager;

	@Resource(name="loginService")
	private LoginService loginService;

	  @RequestMapping(value = "/")
	  public String addUserDetails(Model uiModel)
	  { System.out.println("im in get login");
	  return "home"; }
	 
	  @RequestMapping(value = "/login", method = RequestMethod.POST) 
	  public String addUserDetails(HttpServletRequest httpServletRequest, HttpSession session) {
		  System.out.println("im in post login");
		  
		  String email;
		  email=httpServletRequest.getParameter("email_id");
		  String password=httpServletRequest.getParameter("passwd");
		  String logged_in=this.loginService.LoginValidator(email,password);
		  System.out.println(logged_in);
		  
		  Map<String,Object> myModel=new HashMap<String,Object>();
		  myModel.put("logged", logged_in);
		  if(logged_in.equals("success"))
		  {
			  session.setAttribute("user", email);
			  return "redirect:/wishListComparison";  //new ModelAndView("logsuccess");
		  }
		  else {
			  return  "redirect:/home/login";     //new ModelAndView("login","model",myModel);
		  }
	  }
	/*
	 * public ModelAndView addUserDetails(HttpServletRequest httpServletRequest) {
	 * 
	 * System.out.println("im in post login");
	 * 
	 * String email; email=httpServletRequest.getParameter("email_id"); String
	 * password=httpServletRequest.getParameter("passwd"); String
	 * logged_in=this.loginService.LoginValidator(email,password);
	 * System.out.println(logged_in);
	 * 
	 * Map<String,Object> myModel=new HashMap<String,Object>();
	 * myModel.put("logged", logged_in); if(logged_in.equals("success")) { return
	 * new ModelAndView("logsuccess"); } else { return new
	 * ModelAndView("home","model",myModel); } }
	 */
	 
	 
	 // @RequestMapping(value="/register", method= RequestMethod.POST)
	
	  
	

	  @RequestMapping(value="/register", method= RequestMethod.GET) public String
	  register(Locale locale,Model model) {
	  logger.info("Welcome register! {}. ",locale); return "register"; }
	 

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST)
	 * 
	 * public ModelAndView handleRequest(HttpServletRequest
	 * request,HttpServletResponse response) { String
	 * username=request.getParameter("username"); String
	 * password=request.getParameter("password"); // String message;
	 * 
	 * logger.info(this.loginManager.LoginValid());
	 * 
	 * user user1= new user(); user1.setUsername(username);
	 * user1.setPassword(password); if(username != null && !username.equals("") &&
	 * username.equals("giridhar") && password !=null && !password.equals("") &&
	 * password.equals("123")) { System.out.println("Username= " +
	 * user1.getUsername()); //message = "Welcome " +username + "."; return "login";
	 * } else { System.out.println("Password= " + user1.getPassword()); return
	 * "login"; }
	 * 
	 * 
	 * //System.out.println("Username= " + user1.getUsername());
	 * //System.out.println("Password= " + user1.getPassword());
	 * 
	 * return new ModelAndView("login","user_det",this.loginManager.LoginValid()); }
	 */

	
	  public void setLoginManager(LoginManager loginManager) { this.loginManager =
	  loginManager; }
	 
	  public void setLoginService(LoginService loginService) { this.loginService =
			  loginService; }
	 	  

}
