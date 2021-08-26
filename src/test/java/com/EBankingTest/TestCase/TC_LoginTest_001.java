package com.EBankingTest.TestCase;

import java.io.IOException;

import org.junit.Assert;

import org.testng.annotations.Test;

import com.EBankingTest.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	
	public void LoginTest() throws IOException {
		
		Logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Entered User Name");
		
		lp.setPassword(password);
		Logger.info("Entered Password");
		
		lp.clickSubmit();
		
	 if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	 {
		 Assert.assertTrue(true);
		 Logger.info("Login Test Pass");
	 }
	 
	 else
	 {
		 captureScreen(driver,"loginTest");
		 Assert.assertTrue(false);
		 Logger.info("Login Test Failed");
	 }
	 
	 
	 
	}
}
