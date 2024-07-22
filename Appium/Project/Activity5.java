package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Activities.ActionsBase.doSwipe;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver  =new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("https://v1.training-support.net/selenium");

    }
    @Test(priority = 1)
    public void successfullLoginForm(){
        //get the width of the phone
        Dimension dimension = driver.manage().window().getSize();
        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        //scroll to find login form option
        Point start = new Point((int) (dimension.getWidth()*0.5) ,(int)(dimension.getHeight()*0.8));
        Point end = new Point((int)(dimension.getWidth()*0.5),(int)(dimension.getHeight()*0.4));
        doSwipe(driver,start,end,150);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, admin']")));
        String loginMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, admin']")).getText();
        Assert.assertEquals(loginMsg,"Welcome Back, admin");
    }
    @Test(priority = 2)
    public void invalidCredentials(){
        WebElement userName = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        WebElement passWord = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        userName.clear();
        passWord.clear();
        userName.sendKeys("admin");
        passWord.sendKeys("password123");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Invalid Credentials']")));
        String invalidMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Invalid Credentials']")).getText();
        Assert.assertEquals(invalidMsg,"Invalid Credentials");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}