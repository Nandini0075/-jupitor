package com.jupiterautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jupiterautomation.framework.DriverManager;

public class ShopPage {

	@FindBy(xpath = "//*[@id=\"product-6\"]/div/p/a")
	private WebElement funnyCow;

	@FindBy(xpath = "//*[@id=\"product-4\"]/div/p/a")
	private WebElement FluffyBunny;

	@FindBy(xpath = "//*[@id=\"nav-cart\"]/a")
	private WebElement cart;
	
	@FindBy(xpath = "//*[@id=\"product-2\"]/div/p/a")
	private WebElement stuffedFrog;
	
	@FindBy(xpath = "//*[@id=\"product-7\"]/div/p/a")
	private WebElement ValentineBear;

	public ShopPage() {
		PageFactory.initElements(DriverManager.getWebDriver(), this);

	}

	/**
	 * @return the funnyCow
	 */
	public WebElement getFunnyCow() {
		return funnyCow;
	}

	/**
	 * @param funnyCow the funnyCow to set
	 */
	public void setFunnyCow(WebElement funnyCow) {
		this.funnyCow = funnyCow;
	}

	/**
	 * @return the fluffyBunny
	 */
	public WebElement getFluffyBunny() {
		return FluffyBunny;
	}

	/**
	 * @param fluffyBunny the fluffyBunny to set
	 */
	public void setFluffyBunny(WebElement fluffyBunny) {
		FluffyBunny = fluffyBunny;
	}

	/**
	 * @return the cart
	 */
	public WebElement getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(WebElement cart) {
		this.cart = cart;
	}

	/**
	 * @return the stuffedFrog
	 */
	public WebElement getStuffedFrog() {
		return stuffedFrog;
	}

	/**
	 * @param stuffedFrog the stuffedFrog to set
	 */
	public void setStuffedFrog(WebElement stuffedFrog) {
		this.stuffedFrog = stuffedFrog;
	}

	/**
	 * @return the valentineBear
	 */
	public WebElement getValentineBear() {
		return ValentineBear;
	}

	/**
	 * @param valentineBear the valentineBear to set
	 */
	public void setValentineBear(WebElement valentineBear) {
		ValentineBear = valentineBear;
	}

}
