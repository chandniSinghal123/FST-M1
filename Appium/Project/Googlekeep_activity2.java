package mobileProject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Googlekeep_activity2 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void test() {
        driver.findElementByXPath("//android.widget.ImageButton[contains(@content-desc,'note')]").click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("New Note");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Creating a new note");
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Tomorrow morning']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();

        String title=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        String desc=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
        String reminder=driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();

        Assert.assertEquals(title,"New Note");
        Assert.assertEquals(desc,"Creating a new note");
        Assert.assertEquals(reminder,"Tomorrow, 8:00 AM");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
