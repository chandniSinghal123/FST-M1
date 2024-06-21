package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title = driver.getTitle();
        System.out.println("Tile of the page is: " + title);
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Rishabh");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Pant");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abc@gmail.com");
        WebElement contactNo=driver.findElement(By.id("number"));
        contactNo.sendKeys("9876543210");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.close();
    }
}