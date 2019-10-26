package au.usyd.elec5619.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.*;
import au.usyd.elec5619.web.*;

@Service(value = "loginManager")
@Transactional
public class DbLoginManager implements LoginManager {

	private static final Logger logger = LoggerFactory.getLogger(DbLoginManager.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	/*
	 * @Override public String LoginValid() { logger.info("in get login DB one.");
	 * return this.sessionFactory.getCurrentSession().
	 * createQuery("from user where username='maddy'").toString(); }
	 */

	@Override
	public String addUserDetails(login_details_ad login_details_ad) {
		logger.info("in login DB.");

		// this.sessionFactory.getCurrentSession();

		System.out.println("hi user is added into audit");
		System.out.println(login_details_ad.getEmail_id());
		System.out.println(login_details_ad.getLogin_time());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory.getCurrentSession().save(login_details_ad);
		//commitTransaction(tx, session);
		return this.sessionFactory.getCurrentSession().toString();
	}

	@Override
	public String addRegDetails(user user) {

		logger.info("in reg DB.");

		// this.sessionFactory.getCurrentSession();
		System.out.println("hi user is registered");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory.getCurrentSession().save(user);
		commitTransaction(tx, session);
		return this.sessionFactory.getCurrentSession().toString();
	}

	public void commitTransaction(Transaction tx, Session session) {
		// TODO Auto-generated method stub
		try {
			System.out.println("I came into commit transaction");
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
	
	public List<user> fetchPassword(String email) {
		return this.sessionFactory.getCurrentSession().createQuery("from user where email_id='"+ email + "'").list();
	}

	/*
	 * public Boolean loginValid(user user) {
	 * 
	 * System.out.println("login valid");
	 * 
	 * String checkus,checkpas; checkus=user.getEmail_id();
	 * checkpas=user.getPasswd();
	 * 
	 * 
	 * ArrayList<String> users= new ArrayList<String>();
	 * users.addAll(sessionFactory.openSession().
	 * createQuery("select email_id from user").list()); System.out.println(users);
	 * 
	 * ArrayList<String> passes= new ArrayList<String>();
	 * passes.addAll(sessionFactory.openSession().
	 * createQuery("select passwd from user").list()); System.out.println(passes);
	 * 
	 * for(int i=0;i<users.size();i++) {
	 * 
	 * 
	 * if(users.get(i).equals(checkus) || passes.get(i).equals(checkpas)) {
	 * 
	 * System.out.println("true user"+ users.get(i) + checkus);
	 * 
	 * } else { System.out.println("false user"+ users.get(i) + checkus +
	 * passes.get(i) +checkpas); }
	 * 
	 * 
	 * System.out.println(users.get(i) + " " + checkus);
	 * if(users.get(i).equals(checkus)) { System.out.println("true user"+
	 * users.get(i));
	 * 
	 * if(passes.get(i)== checkpas) { System.out.println("true pass"+
	 * passes.get(i)); } else { System.out.println("false pass"+ passes.get(i)); } }
	 * else { System.out.println("false user"+ users.get(i)); }
	 * 
	 * } return true; }
	 * 
	 */
}
