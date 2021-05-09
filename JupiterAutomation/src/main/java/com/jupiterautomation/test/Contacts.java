package com.jupiterautomation.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jupiterautomation.pages.ContactPage;
import com.jupiterautomation.utils.Constants;

public class Contacts {

	private static final Logger LOGGER = LogManager.getLogger(Contacts.class);

	// Test case 1
	public boolean mandatoryFieldCheck(WebDriver webDriver) {
		LOGGER.info("mandatoryFieldCheck method begins");
		boolean contactStatus = false;
		ContactPage contactPage = new ContactPage();
		webDriver.get(Constants.APPLICATION_URL);
		if (isHomePageLoaded(webDriver)) {
			webDriver.get(Constants.CoNTACT_URL);
			if (isContactPageLoaded(webDriver, contactPage)) {
				contactPage.getSubmit().click();
				boolean status = contactSubmitStatus(contactPage);
				if (!status) {
					contactPage.getForeName().sendKeys("Nandini");
					contactPage.getSurName().sendKeys("aa");
					contactPage.getEmail().sendKeys("nandini@gmail.com");
					contactPage.getTelephone().sendKeys("123456789");
					contactPage.getMessage().sendKeys("contact created sucessfully !");
					contactStatus = contactSubmitStatus(contactPage);
					if (contactStatus) {
						LOGGER.info("mandatoryField entered sucessfully !");

					} else {
						LOGGER.info("Exception occured while creating the contact feedback");
					}
				}

			} else {
				LOGGER.info("Application is down unable to send feedback");
				return false;
			}
		} else {
			LOGGER.info("Application is down unable to load the home page");

		}
		LOGGER.info("mandatoryFieldCheck method ends");
		return contactStatus;
	}

	// Test case 2
	public boolean addContactFeedBack(WebDriver webDriver) {
		LOGGER.info("addContact feedback method begins");
		boolean contactStatus = false;
		ContactPage contactPage = new ContactPage();
		webDriver.get(Constants.APPLICATION_URL);
		if (isHomePageLoaded(webDriver)) {
			webDriver.get(Constants.CoNTACT_URL);
			if (isContactPageLoaded(webDriver, contactPage)) {
				contactPage.getSubmit().click();
				boolean status = contactSubmitStatus(contactPage);
				if (!status) {
					contactPage.getForeName().sendKeys("Nandini");
					contactPage.getSurName().sendKeys("aa");
					contactPage.getEmail().sendKeys("nandini@gmail.com");
					contactPage.getTelephone().sendKeys("123456789");
					contactPage.getMessage().sendKeys("contact created sucessfully !");
					contactPage.getSubmit().click();
					webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					contactStatus = contactSubmitStatus(contactPage);
					contactStatus = contactStatus(webDriver);
					if (contactStatus) {
						LOGGER.info("contact feedback created sucessfully !");

					} else {
						LOGGER.info("Exception occured while creating the contact feedback");
					}
				}

			} else {
				LOGGER.info("Application is down unable to create contacts");
				return false;
			}
		} else {
			LOGGER.info("Application is down unable to load the home page");

		}
		LOGGER.info("addContact feedBack method ends");
		return contactStatus;
	}

	private boolean isContactPageLoaded(WebDriver webDriver, ContactPage contactPage) {
		boolean status = false;
		try {
			WebElement element = (new WebDriverWait(webDriver, 2))
					.until(ExpectedConditions.visibilityOf(contactPage.getSurName()));
			status = element.isDisplayed();
		} catch (Exception e) {
			LOGGER.info("Expection occured while loading the contact feedback creation page : " + e.getMessage());

			return status;
		}
		return status;
	}

	private boolean isHomePageLoaded(WebDriver webDriver) {
		boolean status = false;
		try {
			WebElement element = (new WebDriverWait(webDriver, 2)).until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/h1")));
			status = element.isDisplayed();
		} catch (Exception e) {
			LOGGER.info("Expection occured while loading the contact creation page : " + e.getMessage());

			return status;
		}
		return status;
	}

	private boolean contactSubmitStatus(ContactPage contactPage) {
		if (foreNameStatus(contactPage) && emailIdStatus(contactPage) && messageStatus(contactPage)) {
			return true;
		}
		return false;
	}

	private boolean foreNameStatus(ContactPage contactPage) {
		try {
			String foreNameErrorcode = contactPage.getForNameErrorCode().getText();
			if (foreNameErrorcode != null && !foreNameErrorcode.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			return true;
		}
		return true;

	}

	private boolean emailIdStatus(ContactPage contactPage) {
		try {
			String emailErrorcode = contactPage.getEmailErrorCode().getText();
			if (emailErrorcode != null && !emailErrorcode.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			return true;
		}
		return true;

	}

	private boolean messageStatus(ContactPage contactPage) {
		try {
			String messageErrorCode = contactPage.getMessageErrorCode().getText();
			if (messageErrorCode != null && !messageErrorCode.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			return true;
		}
		return true;

	}

	private boolean contactStatus(WebDriver webDriver) {
		boolean status = false;
		try {
			Thread.sleep(10000);
			WebElement webElement = webDriver.findElement(By.xpath("/html/body/div[2]/div/div"));
			if (webElement.isDisplayed()) {
				String successMessage = webElement.getText();
				if (successMessage != null && !successMessage.isEmpty()) {
					status = true;
				}
			}
		} catch (Exception e) {
			return status;
		}
		return status;
	}

}
