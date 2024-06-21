package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Google Home Page$")
    public void homePage() throws Throwable{
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://google.com");
    }
    @When("^User types in Cheese and hits ENTER$")
    public void userInput() throws Throwable{
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Cheese", Keys.RETURN);
    }
    @Then("^Show how many search results were shown$")
    public void searchResults() throws Throwable{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String resultStats=driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: "+resultStats);
    }
    @And("^Close the browser$")
    public void closeBrowser() throws Throwable{
        driver.close();
    }
}
