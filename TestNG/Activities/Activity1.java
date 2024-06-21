package TestNG;

import org.openqa.selenium.By;
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
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }
    @Test
    public void test(){
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: "+pageTitle);
        Assert.assertEquals(pageTitle,"Training Support");
        driver.findElement(By.xpath("//*[@id='about-link']")).click();
        String newPageTitle = driver.getTitle();
        System.out.println("Page title is: "+newPageTitle);
        Assert.assertEquals(newPageTitle,"About Training Support");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
