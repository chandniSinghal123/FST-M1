package SeleniumProject_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void testMethod() {
        String firstCopyrightText = driver.findElement(By.xpath("//*[@id='admin_options']")).getText();
        System.out.println("Url of the header image is: " + firstCopyrightText);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}