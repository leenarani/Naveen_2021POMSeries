package com.qa.openCart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By header = By.cssSelector("div#logo a");
	private By sections = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By Search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String getAccountsPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.ACCOUNTS_PAGE_TITLE, Constants.TIME_OUT);
	}

	public String getAccountsPageUrl() {
		return eleUtil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION, Constants.TIME_OUT);
	}

	public String getAccPageHeader() {
		return eleUtil.doGetText(header);

	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean logOut() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
			return true;
			}
		return false;
	}
	
	public List<String> getAccPageSections() {
		List<WebElement> sectionList= eleUtil.waitForElementsVisible(sections,Constants.TIME_OUT);
		List<String> secValList = new ArrayList<String>();
		for(WebElement e :sectionList) {
			String val = e.getText();
			secValList.add(val);
		}
		return secValList;
	}
	
	public boolean searchExist() {
		return eleUtil.doIsDisplayed(Search);
	}
	
	public void doSearch(String productName) {
		if(searchExist()) {
			eleUtil.doSendKeys(Search,productName);
			eleUtil.doClick(searchIcon);
			}
		
	}
}
