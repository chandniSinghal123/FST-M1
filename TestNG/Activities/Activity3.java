package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    public void test() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        String welcomeMSG = driver.findElement(By.xpath("//*[contains(text(),'Welcome Back, admin')]")).getText();
        System.out.println("Page title is: " + welcomeMSG);
        Assert.assertEquals("Welcome Back, admin",welcomeMSG);
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
