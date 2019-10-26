package au.usyd.elec5619.web;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;
import au.usyd.elec5619.service.RetailerManagerService;

public class RetailerControllerTest extends TestCase
{
	public void testHandleRequestView() throws Exception{
		
		WishlistComparisonController controller= new WishlistComparisonController();
		controller.setRetailerManager(new RetailerManagerService());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map modelMap= (Map) modelAndView.getModel().get("model");
		String nowValue= (String) modelMap.get("now");
		assertNotNull(nowValue);
		
	}
}