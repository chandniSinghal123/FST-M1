package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args){
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title=driver.getTitle();
        System.out.println("Tile of the page is: "+title);
        driver.findElement(By.xpath("//*[@id='about-link']")).click();
        String title1=driver.getTitle();
        System.out.println("Tile of the new page is: "+title1);
        driver.close();
    }
}
