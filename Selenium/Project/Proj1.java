package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Proj1 {
WebDriver driver;

    @BeforeClass
    public void OpenBrowser() {
        WebDriverManager.firefoxdriver().setup();
         driver= new FirefoxDriver();

    }

@Test
public void OpeningPge(){

    driver.get("http://alchemy.hguy.co/crm");
    String PageTitle= driver.getTitle();
    System.out.println(PageTitle);
    Assert.assertEquals(PageTitle,"SuiteCRM");


}
    @AfterClass
    public void closeBrowser() {

    driver.quit();
    }

}
