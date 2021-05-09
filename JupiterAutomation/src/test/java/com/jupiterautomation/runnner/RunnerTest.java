package com.jupiterautomation.runnner;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jupiterautomation.framework.DriverManager;
import com.jupiterautomation.test.Contacts;
import com.jupiterautomation.test.ShoppingCart;

public class RunnerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void validateMandatoryFieldsTest() {
		Contacts contacts = new Contacts();
		boolean status = contacts.mandatoryFieldCheck(DriverManager.getWebDriver());
		assertTrue(status);
	}

	@Test
	public void addContactFeedBackTest() {
		Contacts contacts = new Contacts();
		for (int i = 0; i < 5; i++) {
			boolean status = contacts.addContactFeedBack(DriverManager.getWebDriver());
			assertTrue(status);
		}
	}

	@Test
	public void verifyCartTest() throws InterruptedException {
		ShoppingCart shoppingCart = new ShoppingCart();
		boolean status = shoppingCart.verifyCart(DriverManager.getWebDriver());
		assertTrue(status);
	}

	@Test
	public void verifyCartItemsTest() throws InterruptedException {
		ShoppingCart shoppingCart = new ShoppingCart();
		boolean status = shoppingCart.verifyCartItems(DriverManager.getWebDriver());
		assertTrue(status);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DriverManager.quitWebDriver();
	}

}
