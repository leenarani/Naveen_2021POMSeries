package com.qa.openCart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openCart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void LoginPageTitleTest(){
		String title= loginPage.getPageTitle();
		System.out.println("page title is :"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
		
	}

	@Test(enabled = false)
	public void LoginPageURLTest(){
		String url =loginPage.getLoginPageUrl();
		System.out.println("LoginPage url is :"+ url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLink());
	}
	
	@Test
	public void LoginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	

}
