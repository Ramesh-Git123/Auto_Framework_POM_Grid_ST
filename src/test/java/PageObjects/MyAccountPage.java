package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MyAccountPage extends BasePage{
        public MyAccountPage(WebDriver driver) {
                super(driver);
        }
        
        //locator
        @FindBy(xpath = "//h2[text() ='My Account']")
   WebElement HeadingMsg;
        
        //logout
        @FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
   WebElement linkLogout;
        
        //method
        public boolean isMyAccountPageExist()
   {
                try
                {
                        return(HeadingMsg.isDisplayed());
                }
                catch(Exception e)
                {
                        return false;
                }
   }
        
        public void clickLogout() throws InterruptedException
        {
                Thread.sleep(2000);
                linkLogout.click();
        }
}

