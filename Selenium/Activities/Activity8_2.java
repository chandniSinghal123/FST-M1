package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Number of column is: "+columns.size());
        System.out.println("Number of row is: "+rows.size());
        WebElement cellValue=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value is: "+cellValue.getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
        WebElement cellValue1=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Sorted Cell value is: "+cellValue1.getText());
        List<WebElement> footerValue=driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        for (WebElement footer:footerValue) {
            System.out.println("footer value is: " +footer.getText());
        }
        driver.close();
    }
}
