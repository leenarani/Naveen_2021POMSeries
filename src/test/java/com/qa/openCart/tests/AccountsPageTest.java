package com.qa.openCart.tests;
import org.testng.annotations.BeforeClass;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetUp() {
		accPage =loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		
	}
	
	

}
