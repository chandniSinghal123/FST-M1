package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity4_3 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Title of the Page is: "+driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@id='third-header']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[contains(@class,'ui green header')]")).getCssValue("color"));
        System.out.println(driver.findElement(By.xpath("//button[contains(@class,'ui violet button')]")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());
        driver.close();
    }
}
