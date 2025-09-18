package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
                super(driver);
        }
        
        //locators
         @FindBy(xpath = "//input[@id='input-email']")
            WebElement emailaddress;
        
         @FindBy(xpath = "//input[@id='input-password']")
            WebElement password;
         @FindBy(xpath = "//input[@value = 'Login']")
            WebElement loginbutton;
        
         //method
          public void setEmail(String email)
            {
                  emailaddress.sendKeys(email);
            }
          public void setPassword(String pass)
            {
                  password.sendKeys(pass);
            }
         
          public void clickLogin()
            {
                  loginbutton.click();
            }
}
