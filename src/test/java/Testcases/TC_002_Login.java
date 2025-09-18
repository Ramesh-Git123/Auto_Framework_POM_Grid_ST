package Testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
public class TC_002_Login extends BaseClass{
        
        @Test(groups= {"Sanity" , "Master"})
        public void verifyLogin()
        {
                try
                {
                        HomePage hp=new HomePage(driver);
                        hp.clickOnMyAccount();
                        hp.clickOnLogin();
                        
                        LoginPage lp=new LoginPage(driver);
                        lp.setEmail(p.getProperty("email"));
                        lp.setPassword(p.getProperty("password"));
                        lp.clickLogin();
                        
                        MyAccountPage ap=new MyAccountPage(driver);
                        boolean targetpage=ap.isMyAccountPageExist();
                        Assert.assertTrue(targetpage);
                }
                catch(Exception e)
                {
                        Assert.fail();
                }
        }
}

