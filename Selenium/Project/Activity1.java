package SeleniumProject_CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void testMethod(){
        String title = driver.getTitle();
        System.out.println("Title of the page is: "+title);
        Assert.assertEquals(title,"SuiteCRM");
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}