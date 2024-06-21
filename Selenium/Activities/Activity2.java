package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title=driver.getTitle();
        System.out.println("Tile of the page is: "+title);
        String LinkedText1=driver.findElement(By.id("about-link")).getText();
        System.out.println("LinkedText1: "+LinkedText1);
        String LinkedText2=driver.findElement(By.className("green")).getText();
        System.out.println("LinkedText2: "+LinkedText2);
        String LinkedText3=driver.findElement(By.linkText("About Us")).getText();
        System.out.println("LinkedText3: "+LinkedText3);
        String LinkedText4=driver.findElement(By.cssSelector(".green")).getText();
        System.out.println("LinkedText4: "+LinkedText4);
        driver.close();
    }
}
