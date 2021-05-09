/**
 * 
 */
package com.jupiterautomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jupiterautomation.framework.DriverManager;

public class Cartpage {
	
	
	@FindBy( xpath = "/html/body/div[2]/div/form/table/tbody/tr")
	private List<WebElement> itemsList;

	public Cartpage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

	/**
	 * @return the itemsList
	 */
	public List<WebElement> getItemsList() {
		    
		
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<WebElement> itemsList) {
		this.itemsList = itemsList;
	}

}
