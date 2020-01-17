package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) throws SQLException {
		try {
			System.out.println("\n---- Admin List ---");
			testGetMenuItemListAdmin();
			System.out.println("\n--- Customer List ---");
			testGetMenuItemListCustomer();
			System.out.println("\n--- Modified ---");
			testModifyMenuItem();
			testGetMenuItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	private static void testModifyMenuItem() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem mn = new MenuItem(1, "Vegsandwich", 92.0f, true, DateUtil.convertToDate("12/02/2017"), "Dessert",
				true);
		menuItemDao.modifyMenuItem(mn);
	}

	public static void testGetMenuItemListAdmin() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		menuItemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.getMenuItemListCustomer();
		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem x : customerList) {
			System.out.println(x);
		}

	}

}
