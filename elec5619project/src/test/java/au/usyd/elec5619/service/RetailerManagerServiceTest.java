package au.usyd.elec5619.service;

import static org.junit.Assert.assertNotNull;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;


import au.usyd.elec5619.domain.retailer;

public class RetailerManagerServiceTest extends TestCase {

		private RetailerManagerService rms;
		
		private List<retailer> retailers;
		//private static int PRODUCT_COUNT=2;
		
		private static Double id = new Double(1);
		private static String name  = "Woolworths";
		//private static String CHAIR_DESCRIPTION = 'Chair'; 
		private static String tag = "wow";
		private static String location = "CBD";
		private static String contact = "0478757655";
		private static Integer post_code = new Integer(2008);
		
			
		protected void setUp() throws Exception {
			rms = new RetailerManagerService();
			retailers = new ArrayList<retailer>();
			
			retailer retailer_val=new retailer();
			retailer_val.setName(name);
			retailer_val.setTag(tag);
			retailer_val.setLocation(location);
			retailer_val.setContact(contact);
			retailer_val.setPost_code(post_code);
			retailers.add(retailer_val);
			
			rms.setRetailers(retailers);
		}
		
		public void testGetProducts() {
			
			retailers = rms.getRetailers();
			
			assertNotNull(retailers);
			//retailer retail_val = retailers.get(0);

		}
}
