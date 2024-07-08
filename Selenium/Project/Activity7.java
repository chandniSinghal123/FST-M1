package SeleniumProject_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity7 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    @Test
    public void testMethod() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@title='Log In']")).click();
        driver.findElement(By.xpath("//*[@id='grouptab_0']")).click();
        driver.findElement(By.xpath("//*[@id='moduleTab_9_Leads'][1]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr"));
        for (int i=1;i<=rowcount.size();i++){
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr["+i+"]/td[10]/span/span")).click();
            if (driver.findElement(By.xpath("/html/body/div[4]/div/div["+(i+6)+"]")).getText().contains("Mobile")) {
                String text1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[" + (i + 6) + "]/div[2]/span")).getText();
                System.out.println("Mobile number displayed is: " + text1);
            }
            else{
                System.out.println("No Mobile Details Available");
            }

        }
    }
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
