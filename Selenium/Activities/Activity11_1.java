package Demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        driver.findElement(By.cssSelector("button#simple")).click();

        Alert simpleAlert = driver.switchTo().alert();

        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert box
        simpleAlert.accept();
    }
}
