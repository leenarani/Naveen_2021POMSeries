package com.qa.openCart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.openCart.factory.DriverFactory;
import com.qa.openCart.pages.AccountsPage;
import com.qa.openCart.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	AccountsPage accPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
       prop= df.init_prop();
		driver= df.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
