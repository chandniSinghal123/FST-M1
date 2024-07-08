package SeleniumProject_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void testMethod(){
        String headerImageUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src");
        System.out.println("Url of the header image is: "+headerImageUrl);
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
