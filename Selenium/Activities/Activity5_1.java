package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is:" +driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed());
        driver.findElement(By.xpath("//*[@id='toggleCheckbox'][text()='Remove checkbox']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed());
        driver.close();
    }
}
