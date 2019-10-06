package au.usyd.elec5619.domain;

import java.util.Date;

import junit.framework.TestCase;

public class admin_user_history_test extends TestCase {
	private admin_user_history admin_user_history;
	
	protected void setUp() throws Exception {
		admin_user_history = new admin_user_history();
	}
	public void testUserName() {
		String user = "grocery";
		assertNull(admin_user_history.getUserName());
		admin_user_history.setUserName(user);
		assertEquals(user, admin_user_history.getUserName());
	}
	public void testCount() {
		int count =5;
		assertEquals(0,0,0);
		admin_user_history.setCount(count);
		assertEquals(count,admin_user_history.getCount(),0);
	}
	public void testDate() {
		Date todays_date = new Date();
		assertNull(admin_user_history.getLogged_date());
		admin_user_history.setLogged_date(todays_date);
		assertEquals(todays_date,admin_user_history.getLogged_date());
	}
}