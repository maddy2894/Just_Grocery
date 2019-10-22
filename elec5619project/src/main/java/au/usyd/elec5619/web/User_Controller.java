package au.usyd.elec5619.web;

import java.util.ArrayList;
import java.util.List;

import au.usyd.elec5619.domain.user;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class User_Controller implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
			String now = "hello";
			List user_data = new ArrayList();
			user_data.add("Shashank");
			user_data.add("Jain");
			user_data.add("1509sj@gmail.com");
			user_data.add("asdfghjk");
			user_data.add("U39 Hilts Road Strathfield");
			user_data.add("2135");
			user_data.add("9490263247");
			logger.info("User-profile linked with controller" + user_data);
			//System.out.println(user_data.get(4));
			return new ModelAndView("user_profile", "user_data", user_data);
			
			}
	@RequestMapping(value="/elec5619/user_profile",  method=RequestMethod.POST)
	public void user_profile(user user) {
		System.out.println("O am here!");
		System.out.println(user.getFirst_name());
		System.out.println(user.getLast_name());
		
	}
	
}