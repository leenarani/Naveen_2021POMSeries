package com.qa.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	//1. private By Locator
	private By email = By.id("input-email");
	private By passWord = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	//2. page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	//3. public pageActions/Methods
	public String getPageTitle(){
		//return driver.getTitle();
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.TIME_OUT);
	}
	
	//4.LoginPage url
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.TIME_OUT);
	}
	
	//5.ForgotPassword link is displayed or not
	public Boolean isForgotPasswordLink() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
		
		
	}
	
	//6.login to application.
	public AccountsPage doLogin(String userName, String pwd) {
		eleUtil.doSendKeys(email, userName);
		eleUtil.doSendKeys(passWord, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	

}
