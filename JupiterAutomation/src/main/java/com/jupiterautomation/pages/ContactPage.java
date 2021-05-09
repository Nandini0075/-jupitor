package com.jupiterautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jupiterautomation.framework.DriverManager;

public class ContactPage {

	@FindBy(xpath = "//*[@id=\"forename\"]")
	private WebElement foreName;

	@FindBy(xpath = "//*[@id=\"surname\"]")
	private WebElement surName;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"telephone\"]")
	private WebElement telephone;

	@FindBy(xpath = "//*[@id=\"message\"]")
	private WebElement message;

	@FindBy(xpath = "/html/body/div[2]/div/form/div/a")
	private WebElement submit;

	@FindBy(xpath = "//*[@id=\"forename-err\"]")
	private WebElement forNameErrorCode;

	@FindBy(xpath = "//*[@id=\"email-err\"]")
	private WebElement emailErrorCode;

	@FindBy(xpath = "//*[@id=\"message-err\"]")
	private WebElement messageErrorCode;

	public ContactPage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

	/**
	 * @return the foreName
	 */
	public WebElement getForeName() {
		return foreName;
	}

	/**
	 * @param foreName the foreName to set
	 */
	public void setForeName(WebElement foreName) {
		this.foreName = foreName;
	}

	/**
	 * @return the surName
	 */
	public WebElement getSurName() {
		return surName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(WebElement surName) {
		this.surName = surName;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(WebElement email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public WebElement getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(WebElement telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the message
	 */
	public WebElement getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(WebElement message) {
		this.message = message;
	}

	/**
	 * @return the submit
	 */
	public WebElement getSubmit() {
		return submit;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	/**
	 * @return the forNameErrorCode
	 */
	public WebElement getForNameErrorCode() {
		return forNameErrorCode;
	}

	/**
	 * @param forNameErrorCode the forNameErrorCode to set
	 */
	public void setForNameErrorCode(WebElement forNameErrorCode) {
		this.forNameErrorCode = forNameErrorCode;
	}

	/**
	 * @return the emailErrorCode
	 */
	public WebElement getEmailErrorCode() {
		return emailErrorCode;
	}

	/**
	 * @param emailErrorCode the emailErrorCode to set
	 */
	public void setEmailErrorCode(WebElement emailErrorCode) {
		this.emailErrorCode = emailErrorCode;
	}

	/**
	 * @return the messageErrorCode
	 */
	public WebElement getMessageErrorCode() {
		return messageErrorCode;
	}

	/**
	 * @param messageErrorCode the messageErrorCode to set
	 */
	public void setMessageErrorCode(WebElement messageErrorCode) {
		this.messageErrorCode = messageErrorCode;
	}

}
