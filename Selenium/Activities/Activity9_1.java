package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        WebElement chosen = driver.findElement(By.xpath("//*[contains(@class,'ui selection dropdown')]"));
        Select dropdown=new Select(driver.findElement(By.xpath("//*[//*[contains(@class,'ui selection dropdown')]]")));
        dropdown.selectByVisibleText("Option 2");
        dropdown.selectByIndex(3);
        dropdown.selectByValue("Option 4");

        List<WebElement> options=dropdown.getOptions();
        for(WebElement option:options){
            System.out.println("Options are: "+option.getText());
        }
    }
}
