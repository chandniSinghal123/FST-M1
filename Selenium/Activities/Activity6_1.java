package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is:" +driver.getTitle());
        driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkbox= driver.findElement(By.xpath("//*[@type='checkbox']"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        driver.findElement(By.xpath("//*[text()='Add Checkbox']")).click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        driver.close();
    }
}
