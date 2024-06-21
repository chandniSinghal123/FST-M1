package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the Page is: "+driver.getTitle());
        driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//*[contains(@class,'ui button')][text()='Log in']")).click();
        String successMsg=driver.findElement(By.xpath("//*[@id='action-confirmation']")).getText();
        System.out.println("Confirmation Message displayed is: "+successMsg);
        driver.close();
    }
}
