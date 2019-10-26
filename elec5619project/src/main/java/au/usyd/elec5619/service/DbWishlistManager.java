package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import au.usyd.elec5619.domain.wish_list;


import au.usyd.elec5619.domain.retailer;

@Service(value="wishlistManager")
@Transactional
public class DbWishlistManager implements WishListManager {
	private static final Logger logger = LoggerFactory.getLogger(DbRetailerManager.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public void saveWishlist(wish_list wishlist1) {
		logger.info("in get wishlist DB one.");
		/*
		 * return this.sessionFactory.getCurrentSession().createQuery(
		 * //"select pp.price_date as price_date ,pp.product_name as product_name,pp.product_id as product_id, rt.tag as tag,rt.name as name, pp.price as price,rt.location as location "
		 * " from product_prices pp, retailer as rt " +
		 * " where pp.price_date='2019-10-20' " + " and pp.retailer_id=rt.id " +
		 * " and rt.location='CBD'" + " order by pp.product_id").list();
		 */
         this.sessionFactory.getCurrentSession().save(wishlist1);
	}
	@Override
	public List<String> retrieveWishlist(){
		logger.info("in get wishlist DB one.");
		/*
		 * return this.sessionFactory.getCurrentSession().createQuery(
		 * //"select pp.price_date as price_date ,pp.product_name as product_name,pp.product_id as product_id, rt.tag as tag,rt.name as name, pp.price as price,rt.location as location "
		 * " from product_prices pp, retailer as rt " +
		 * " where pp.price_date='2019-10-20' " + " and pp.retailer_id=rt.id " +
		 * " and rt.location='CBD'" + " order by pp.product_id").list();
		 */
         return this.sessionFactory.getCurrentSession().createQuery("SELECT distinct wishlist_name FROM wish_list where is_active='true' ").list();
	}
	

	@Override
	public String getWishlistName(String wishlistname) {
		List<String> wishlist_name = retrieveWishlist();
		String message;
		if(wishlist_name.contains(wishlistname)) {
			message="Wishlist Name Already exists";
			return message;
		}
		
		else {
			message = "Successfull";
		return message;
		}
	}

	@Override
	public List getAllWishlists() {
		// TODO Auto-generated method stub
		//System.out.println("");
		logger.info("I am here");
		
		 return this.sessionFactory.getCurrentSession().createQuery("FROM wish_list where is_active='true'").list();
		
		
	}

	@Override
	public List getOneWishList(String wishlistname) {
		// TODO Auto-generated method stub
		// System.out.println("wishlistname	"+wishlistname);
		// System.out.println(this.sessionFactory.getCurrentSession().createQuery("FROM wish_list where wishlist_name='wishlistname'").list());
		 return this.sessionFactory.getCurrentSession().createQuery("FROM wish_list where wishlist_name='"+wishlistname+"'").list();
		 
	}

	@Override
	public void saveEditedWishList(wish_list wishlist1,String old_wishlistname) {
		// TODO Auto-generated method stub
		
		System.out.println("wishlist1"+wishlist1.wishlist_name);
		System.out.println("oldwishlist"+old_wishlistname);
		System.out.println();
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("UPDATE wish_list SET wishlist_name = :wishlistname , list_of_products = :listofproducts "+" WHERE wishlist_name = :oldwishlistname");
		query.setParameter("wishlistname", wishlist1.wishlist_name);
		query.setParameter("oldwishlistname",old_wishlistname);
		query.setParameter("listofproducts",wishlist1.list_of_products);
		query.executeUpdate();
		
		
	}

	@Override
	public void makeWishListInActive(wish_list wishlist1) {
		// TODO Auto-generated method stub
		
		//this.sessionFactory.getCurrentSession().save(wishlist1);
		
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("UPDATE wish_list SET is_active = :isActive "+" WHERE wishlist_name = :wishListName");
		query.setParameter("isActive",wishlist1.is_active);
		query.setParameter("wishListName",wishlist1.wishlist_name);
		query.executeUpdate();
	}
	
	
	


	
	
}
