package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test
    public void test1() {
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Assert.assertEquals(pageTitle,"Target Practice");
    }
    @Test
    public void test2(){
        String text = driver.findElement(By.xpath("//*[@class='ui black button']")).getText();
        System.out.println("Color Text is: "+text);
        Assert.assertEquals(text,"Blue");
    }
    @Test(enabled = false)
    public void test3(){
    }
    @Test
    public void test4() throws SkipException {

    }
    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
