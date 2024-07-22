package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjActivity2 {

    WebDriver driver;

    @BeforeClass

    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @Test
    public void method() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        String ImageURL = headerImage.getAttribute("src");
        System.out.println(ImageURL);
        //Get the copyright text


        //Logging into the site
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys(" pa$$w0rd");
        Thread.sleep(2000);
        driver.findElement(By.id("bigbutton")).click();

    }



    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
