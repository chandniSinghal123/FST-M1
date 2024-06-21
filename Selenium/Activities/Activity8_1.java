package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("Number of column is: "+columns.size());
        System.out.println("Number of row is: "+rows.size());
        List<WebElement> thirdRow=driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        for (WebElement thirdRowValue:thirdRow){
            System.out.println("value in 3rd row are: "+thirdRowValue.getText());
        }
        WebElement cellValue=driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Cell value is: "+cellValue.getText());
        driver.close();

    }
}
