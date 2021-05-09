package com.jupiterautomation.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Runner {
	

	public void intit()
	{
		
	}

	public static void main(String[] args) throws InterruptedException {

		//DriverManager driverManager = new DriverManager("chrome");
		// Contacts contact = new Contacts();
		// Test case 1
		// boolean status = contact.mandatoryFieldCheck(DriverManager.getWebDriver());

		// System.out.println("status : " + status);

		/*
		 * DriverManager.getWebDriver().get(Constants.APPLICATION_URL);
		 * DriverManager.getWebDriver().manage().timeouts().setScriptTimeout(10,
		 * TimeUnit.SECONDS); ShoppingCart shoppingCart = new ShoppingCart(); boolean
		 * cartStatus = shoppingCart.verifyCart(DriverManager.getWebDriver());
		 * System.out.println("carttatus :" + cartStatus);
		 * shoppingCart.clearCart(DriverManager.getWebDriver());
		 * DriverManager.getWebDriver().manage().timeouts().setScriptTimeout(10,
		 * TimeUnit.SECONDS); Thread.sleep(10000); boolean cartStatus1 =
		 * shoppingCart.verifyCartItems(DriverManager.getWebDriver());
		 * 
		 * System.out.println("carttatus :" + cartStatus1); Thread.sleep(10000);
		 * DriverManager.quitWebDriver();
		 */

		Double total = new BigDecimal(116.87).setScale(1, RoundingMode.CEILING).doubleValue();
		System.out.println("total : "+total);
}
}