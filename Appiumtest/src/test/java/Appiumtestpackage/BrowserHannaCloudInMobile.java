package Appiumtestpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserHannaCloudInMobile
{
	
public WebDriver driver;
@BeforeMethod
public void Setup() throws MalformedURLException
{
	URL url = new URL("http://127.0.0.1:4723/");
	
	UiAutomator2Options options=new UiAutomator2Options();
	options.setPlatformName("Android");
	//options.setDeviceName("android16");
	options.setPlatformVersion("14");
	options.setUdid("emulator-5554");
	options.withBrowserName("Chrome");
	options.chromedriverUseSystemExecutable();
	
	driver=new AndroidDriver(url,options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void login() throws InterruptedException
{
	Thread.sleep(5000);
	driver.get("https://test.hinstdev.com/login");
	Thread.sleep(5000);
}

@AfterMethod
public void Teardown()
{
	driver.quit();

}
}
