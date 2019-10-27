package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.retailer;

@Service(value="retailerManager")
@Transactional
public class DbRetailerManager implements RetailerManager {
	private static final Logger logger = LoggerFactory.getLogger(DbRetailerManager.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public List<String> getRetailers() {
		logger.info("in get retailers DB one.");
		return this.sessionFactory.getCurrentSession().createQuery("select distinct product_name from product_prices where price_date='2019-10-20'").list();
	}
	
}
