package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void googleKeepNotes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("New text note"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title"))).sendKeys("Appium");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Appium Test");
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Tomorrow morning\"]"))).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/drawer_navigation_reminders")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")));
        String reminder = driver.findElement(AppiumBy.id("com.google.android.keep:id/reminder_chip_text")).getText();
        Assert.assertEquals("Tomorrow, 8:00 AM",reminder);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}