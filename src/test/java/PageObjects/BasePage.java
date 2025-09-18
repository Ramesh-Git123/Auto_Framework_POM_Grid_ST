package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

         WebDriver driver;
         
        //Constructor(main)
        public BasePage(WebDriver driver) 
        {
                this.driver=driver;
                PageFactory.initElements(driver, this); //for using Pagefactory without "driver"
        }        
}