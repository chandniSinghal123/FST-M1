package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is:" +driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//input[@id='input-text'][@type='text']")).isEnabled());
        driver.findElement(By.xpath("//*[@id='toggleInput'][text()='Enable Input']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='dynamicText']")).isEnabled());
        driver.close();
    }
}
