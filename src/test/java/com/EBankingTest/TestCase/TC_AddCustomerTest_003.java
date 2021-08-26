package com.EBankingTest.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EBankingTest.PageObjects.AddCustomerPage;
import com.EBankingTest.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name is provided");
		lp.setPassword(password);
		Logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		Logger.info("providing customer details....");

		addcust.custName("Asqar");
		addcust.custgender("male");
		addcust.custdob("07", "06", "1997");
		Thread.sleep(5000);
		addcust.custaddress("Pakistan");
		addcust.custcity("KHI");
		addcust.custstate("SINDH");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);

		Logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			Logger.info("test case passed....");

		} else {
			Logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
