package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println("Title of the Page is: "+driver.getTitle());
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Rishabh");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Pant");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Rishabh@gmail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9876543210");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[5]/textarea")).submit();
        driver.close();
    }
}
