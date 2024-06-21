package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {
    public static void main(String[] args){
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page is: "+driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("Rishabh");
        driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("Pant");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input")).sendKeys("Pant");
        driver.findElement(By.xpath("//input[starts-with(@class,'email')]")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
        String confirmationMsg=driver.findElement(By.xpath("@id='action-confirmation'")).getText();
        System.out.println("Confirmation MSG displayed is: "+confirmationMsg);
        driver.close();
    }
}
