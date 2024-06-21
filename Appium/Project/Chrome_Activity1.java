package mobileProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Chrome_Activity1 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Mobile");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("noReset",true);

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.Button[@text = 'Get Started!']").click();
        Thread.sleep(1000);
        //scroll
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(
                MobileBy.AndroidUIAutomator(UiScrollable + ".scrollIntoView(text(\"To-Do List\"))")).click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.Button[@text = 'Add Task']").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.Button[@text = 'Add Task']").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.Button[@text = 'Add Task']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.View[@text = 'Add tasks to list']").click();
        driver.findElementByXPath("//android.view.View[@text = 'Get number of tasks']").click();
        driver.findElementByXPath("//android.view.View[@text = 'Clear the list']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
