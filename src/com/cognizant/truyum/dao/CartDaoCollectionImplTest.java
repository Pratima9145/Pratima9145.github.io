package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItems(1, 2L);
		cartDao.addCartItems(1, 5L);

		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1l);
		System.out.println("List of items added to the cart by user for checkout");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1L);
		System.out.println("\nUser List All Cart Items");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("\nList of items of the user after removal");
		try {
			cartDao.removeCartItems(1, 2L);
			cartDao.removeCartItems(1, 5L);

			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1l);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
