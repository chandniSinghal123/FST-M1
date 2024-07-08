package SeleniumProject_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void testMethod() {
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@title='Log In']")).click();
        String tab=driver.findElement(By.xpath("//*[@id='grouptab_3']")).getText();
        System.out.println("Fourth Menu item on the Navigation bar is: "+tab);
        Assert.assertEquals(tab,"ACTIVITIES");
    }
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
