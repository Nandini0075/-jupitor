package com.jupiterautomation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jupiterautomation.pages.ShopPage;
import com.jupiterautomation.utils.Constants;

public class ShoppingCart {

	private static final Logger LOGGER = LogManager.getLogger(ShoppingCart.class);

	public boolean verifyCart(WebDriver webDriver) throws InterruptedException {
		LOGGER.info("verifyCart method begins");
		boolean status = false;
		ShopPage shopPage = new ShopPage();
		webDriver.get(Constants.SHOP_URL);
		Thread.sleep(10000);
		if (isShopPageLoaded(webDriver, shopPage)) {
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			shopPage.getFunnyCow().click();
			shopPage.getFunnyCow().click();
			shopPage.getFluffyBunny().click();
			Thread.sleep(10000);
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			shopPage.getCart().click();
			Thread.sleep(10000);
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			status = itemsVerify(webDriver);
		} else {
			LOGGER.info("unable to load the shop page : ");
			return status;
		}
		LOGGER.info("verifyCart method ends");
		return status;
	}

	public boolean verifyCartItems(WebDriver webDriver) throws InterruptedException {
		LOGGER.info("verifyCartItems method begins");
		boolean status = false;
		ShopPage shopPage = new ShopPage();
		webDriver.get(Constants.SHOP_URL);
		Thread.sleep(10000);
		if (isShopPageLoaded(webDriver, shopPage)) {
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			shopPage.getStuffedFrog().click();
			shopPage.getStuffedFrog().click();
			shopPage.getFluffyBunny().click();
			shopPage.getFluffyBunny().click();
			shopPage.getFluffyBunny().click();
			shopPage.getFluffyBunny().click();
			shopPage.getFluffyBunny().click();
			shopPage.getValentineBear().click();
			shopPage.getValentineBear().click();
			shopPage.getValentineBear().click();

			Thread.sleep(10000);
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			shopPage.getCart().click();
			Thread.sleep(10000);
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			status = cartTotalVerify(webDriver);
		} else {
			LOGGER.info("unable to load the shop page");
			return status;
		}
		LOGGER.info("verifyCartItems method ends");
		return status;
	}

	private boolean isShopPageLoaded(WebDriver webDriver, ShopPage shopPage) {
		LOGGER.info("isShopPageLoaded method begins");
		boolean status = false;
		try {
			WebElement element = (new WebDriverWait(webDriver, 2))
					.until(ExpectedConditions.visibilityOf(shopPage.getFunnyCow()));
			status = element.isDisplayed();
		} catch (Exception e) {
			LOGGER.info("Expection occured while loading the shop page : " + e.getMessage());

			return status;
		}
		LOGGER.info("isShopPageLoaded method ends");
		return status;
	}

	private boolean itemsVerify(WebDriver webDriver) {
		LOGGER.info("cart items verify method begins");
		boolean status = false;
		try {
			List<WebElement> itemsList = webDriver.findElements(By.xpath("/html/body/div[2]/div/form/table/tbody/tr"));
			for (int i = 1; i <= itemsList.size(); i++) {
				List<WebElement> itemDetails = webDriver
						.findElements(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td"));
				if (itemDetails != null && !itemDetails.isEmpty()) {
					String item = itemDetails.get(0).getText().trim();
					Integer count = Integer.parseInt(webDriver
							.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td[3]/input"))
							.getAttribute("value"));
					if (item != null && !item.isEmpty() && item.equalsIgnoreCase("Funny Cow") && count == 2) {
						status = true;
					} else if (item != null && !item.isEmpty() && item.equalsIgnoreCase("Fluffy Bunny") && count == 1) {
						status = true;
					} else {
						status = false;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.info("Exception occured while verifying the cart items : " + e.getMessage());
			return status;
		}
		LOGGER.info("cart items verify method ends");
		return status;
	}

	private boolean cartTotalVerify(WebDriver webDriver) {
		LOGGER.info("cartTotalVerify method begins");
		boolean status = false;
		Double total = Double.MIN_VALUE;
		Double cartTotal = Double.MIN_VALUE;
		try {
			String[] cartTotalValue = webDriver
					.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")).getText()
					.split(":");
			cartTotal = Double.parseDouble(cartTotalValue[1].trim());
			List<WebElement> itemsList = webDriver.findElements(By.xpath("/html/body/div[2]/div/form/table/tbody/tr"));
			for (int i = 1; i <= itemsList.size(); i++) {
				List<WebElement> itemDetails = webDriver
						.findElements(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td"));
				if (itemDetails != null && !itemDetails.isEmpty()) {
					String item = itemDetails.get(0).getText().trim();
					Integer count = Integer.parseInt(webDriver
							.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td[3]/input"))
							.getAttribute("value"));
					String priceValue = webDriver
							.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td[2]"))
							.getText();
					System.out.println("priceValue :" + priceValue);
					Double price = Double.parseDouble(priceValue.substring(1, priceValue.length()));
					String subTotalValue = webDriver
							.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td[4]"))
							.getText();
					Double subTotal = Double.parseDouble(subTotalValue.substring(1, subTotalValue.length()));
					if (item != null && !item.isEmpty() && item.equalsIgnoreCase("Stuffed Frog") && count == 2) {
						Double sum = count * price;
						if (!subTotal.equals(sum)) {
							return false;
						}
						total += sum;
						status = true;
					} else if (item != null && !item.isEmpty() && item.equalsIgnoreCase("Fluffy Bunny") && count == 5) {
						Double sum = count * price;
						if (!subTotal.equals(sum)) {
							return false;
						}
						total += sum;
						status = true;
					} else if (item != null && !item.isEmpty() && item.equalsIgnoreCase("Valentine Bear")
							&& count == 3) {
						Double sum = count * price;
						if (!subTotal.equals(sum)) {
							return false;
						}
						total += sum;
						status = true;
					} else {
						return false;
					}
				}
			}
			if (status) {
				// total = new BigDecimal(total).setScale(1,
				// RoundingMode.CEILING).doubleValue();
				if (!(total.equals(cartTotal))) {
					status = false;
				}
			}
		} catch (Exception e) {
			LOGGER.info("Exception occured while verifying the cart toal : " + e.getMessage());
			return status;
		}
		LOGGER.info("cartTotalVerify method ends");
		return status;
	}

	public void clearCart(WebDriver webDriver) {
		LOGGER.info("clearcart method begins");
		try {
			WebElement webElement = webDriver
					.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[2]/td/ng-confirm/a"));
			webElement.click();
			Thread.sleep(10000);
			WebElement popupAccept = webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/a[1]"));
			popupAccept.click();
			// webDriver.switchTo().alert().accept();
		} catch (Exception e) {
			LOGGER.error("Exception occured while clearing the cart : " + e.getMessage());

		}
		LOGGER.info("clearcart method ends");
	}

}
