package Appiumtestpackage;

import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumHannaPooltest 
{
public AndroidDriver driver;

@BeforeTest
public void setup() throws MalformedURLException {
    String appiumServerURL = "http://127.0.0.1:4723";

    DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability("platformName", "Android");
    dc.setCapability("appium:automationName", "UiAutomator2");
    dc.setCapability("appium:udid", "emulator-5554");
    dc.setCapability("appium:deviceName", "emulator-5554");
    dc.setCapability("appium:platformVersion", "17");
    dc.setCapability("appium:app", System.getProperty("user.dir") + "/src/test/resources/HannaPool.apk");
    dc.setCapability("appium:autoGrantPermissions", true);

    // ✅ Fix: handle MalformedURLException properly
    driver = new AndroidDriver(new URL(appiumServerURL), dc);
}

@Test
public void test_Login() throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	WebElement EmailID= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
	WebElement Password= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
	WebElement Login_Button= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")"));
	EmailID.sendKeys("upasanahanna2@gmail.com");
	Password.sendKeys("Hanna@2022");
	Login_Button.click();
	 Thread.sleep(3000);
	boolean status= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Header Avatar\")")).isDisplayed();
	Assert.assertTrue(status, "Login failed: Header Avatar not displayed");
     Thread.sleep(3000);
}

@AfterTest
public void teardown()
{
	driver.quit();
}

}
