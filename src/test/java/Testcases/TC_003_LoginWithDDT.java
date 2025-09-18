package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProvidersDemo;

public class TC_003_LoginWithDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProvidersDemo.class, groups = { "DataDriver" })
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage ap = new MyAccountPage(driver);
			boolean targetpage = ap.isMyAccountPageExist();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					Assert.assertTrue(true); // data is correct and login successfully
					ap.clickLogout();
				} else {
					Assert.assertTrue(false); // data is valid but still login is failed then this will handled here
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					ap.clickLogout();
					Assert.assertTrue(false); // data is invalid but login successfully
				} else {
					Assert.assertTrue(true); // data is invalid then login failed and test case passed
				}
			}
		} catch (Exception e) {
			Assert.fail();
			Thread.sleep(3000);
		}

	}
}
