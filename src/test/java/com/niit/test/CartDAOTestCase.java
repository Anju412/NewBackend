package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTestCase {

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
		if (cartDAO==null){
			System.out.println("cart null");
		}
		
	}
	
	/*@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(328);
		cartItem.setProductName("sample");
		cartItem.setQuantity(20);
		cartItem.setUserName("abc");
		cartItem.setPrice(1000);
		cartItem.setStatus("NA");
		
		System.out.println(cartItem.getProductId());
		System.out.println(cartItem.getProductName());
		System.out.println(cartItem.getQuantity());
		System.out.println(cartItem.getUserName());
		System.out.println(cartItem.getPrice());
		System.out.println(cartItem.getStatus());
		assertTrue("Problem in adding CartItem", cartDAO.addCartItem(cartItem));
	}*/
	
	
	@Test
	public void showCartItems()
	{
		List<CartItem> cartItems=cartDAO.showCartItems("abc");
		assertTrue("Problem in Showing CartItem:", cartItems.size()>0);
		for(CartItem cartItem:cartItems)
		{
			System.out.println(cartItem.getProductName()+"::");
			System.out.println(cartItem.getQuantity()+"::");
			System.out.println(cartItem.getPrice()+"::");
			System.out.println(cartItem.getStatus()+"::");
		}
	}
}
	
	
	/*@Test
	public void getCartItemTestCase()
	{
		CartItem cartItem=cartDAO.getCartItem(331);
		
		assertNotNull("Problem in getting CartItem",cartItem);
		System.out.println("=====Getting a CartItem=====");
		System.out.println(cartItem.getProductName()+"::");
		System.out.println(cartItem.getQuantity()+"::");
		System.out.print(cartItem.getPrice()+"::");
		System.out.println(cartItem.getStatus()+"");
	}*/
	
	
/*	@Test
	public void deleteCartItemTestCase()
	{
		CartItem cartItem=cartDAO.getCartItem(331);
		assertTrue("Problem in deleting CartItem",cartDAO.deleteCartItem(cartItem));
	}
	
}*/
/*	@Test
	public void updateCartItemTestCase()
	{
		CartItem cartItem=cartDAO.getCartItem(331);
		cartItem.setQuantity(40);
		assertTrue("Problem in updating CartItem",cartDAO.updateCartItem(cartItem));
		System.out.println(cartItem.getQuantity());
	}
}*/
