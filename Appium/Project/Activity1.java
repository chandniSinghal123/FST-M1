package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options task = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.apps.tasks")
                .setAppActivity(".ui.TaskListsActivity")
                .noReset();

        //Set the server URL
        URL serverURL = new URL("http://localhost:4723/wb/hub");

        //Initialize the Android driver
        driver = new AndroidDriver(serverURL, task);
    }
    @Test
    public void TaskTest() throws InterruptedException {
        //Find the 7 and tap it
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        //find elements on the page
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.google.android.apps.tasks:id/add_task_title']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.google.android.apps.tasks:id/add_task_done']"));

        //Enter Tasks
        addTaskInput.sendKeys("Complete Activity with Google Tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Complete Activity with Google Keep");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Complete the second Activity Google Keep");
        addTaskButton.click();
        Thread.sleep(1000);

        //Assertions
        String Task1 = driver.findElement(AppiumBy.id("android:id/content")).getText();
        Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
        String Task2 = driver.findElement(AppiumBy.id("android:id/content")).getText();
        Assert.assertEquals(Task2, "Complete Activity with Google Keep");
        String Task3 = driver.findElement(AppiumBy.id("android:id/content")).getText();
        Assert.assertEquals(Task3, "Complete the second Activity Google Keep");
    }
}