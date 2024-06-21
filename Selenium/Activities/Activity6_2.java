package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/ajax");
        System.out.println("Title of the Page is: "+driver.getTitle());
        driver.findElement(By.xpath("//button[contains(text(),'Change Content')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO"));
        String text1=driver.findElement(By.xpath("//*[@id='ajax-content']")).getText();
        System.out.println("Text displayed is: "+text1);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late!"));
        String text2=driver.findElement(By.xpath("//*[@id='ajax-content']")).getText();
        System.out.println("New Text displayed is: "+text2);
        driver.close();
    }
}
