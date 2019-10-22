package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.product_prices;;

@Service(value="productManager")
@Transactional
public class DbProductManager implements ProductManager {
	private static final Logger logger = LoggerFactory.getLogger(DbProductManager.class);
	private SessionFactory sessionFactory;
//	private HttpServletRequest request;
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public List<product_prices> getProducts(String name) {
		logger.info("IN SERVICE" + name);
		/*
		 * return this.sessionFactory.getCurrentSession().createQuery(
		 * //"select pp.price_date as price_date ,pp.product_name as product_name,pp.product_id as product_id, rt.tag as tag,rt.name as name, pp.price as price,rt.location as location "
		 * " from product_prices pp, retailer as rt " +
		 * " where pp.price_date='2019-10-20' " + " and pp.retailer_id=rt.id " +
		 * " and rt.location='CBD'" + " order by pp.product_id").list();
		 */
		return this.sessionFactory.getCurrentSession().createQuery("from product_prices where product_name='"+name+"'").list();
	}
	
}
