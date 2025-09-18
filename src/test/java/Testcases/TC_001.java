package Testcases;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.AccountResgistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;
public class TC_001 extends BaseClass{
                
        @Test(groups= {"Regression", "Master"})
        public void verifyAccountRegistration() throws InterruptedException
        {
                HomePage hp=new HomePage(driver);
                hp.clickOnMyAccount();
                hp.clickOnRegister();
                
                AccountResgistrationPage rp=new AccountResgistrationPage(driver);
                rp.setFirstName(randomString().toUpperCase());
                rp.setLastName(randomString().toUpperCase());
                rp.setEmail(randomAlphaNumeric()+"@gmail.com");
                rp.setTelephone(randomNumber());
                
                String password=randomAlphaNumeric();
                rp.setPassword(password);
                rp.setConfirmPassword(password);
                rp.setPrivacyPolicy();
                rp.clickContinueBtn();
       System.out.println(rp.getConfirmationMsg());
                
        }
}
