package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void driverInvoke() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }
    @When("^User clicks the Simple Alert button$")
    public void simpleAlertButton()
    {
        WebElement simple = driver.findElement(By.id("simple"));
        simple.click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void confirmAlertButton()
    {
        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
    }
    @When("^User clicks the Prompt Alert button$")
    public void promptAlertButton()
    {
        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();
    }
    @Then("^Alert opens$")
    public void alertOpen()
    {
        alert = driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void readText()
    {
        System.out.println(alert.getText());
    }
    @And("^Write a custom message in it$")
    public void writeToPrompt() {
        alert.sendKeys("Custom Message");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertWithCAncel() {
        alert.dismiss();
    }

    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }


}