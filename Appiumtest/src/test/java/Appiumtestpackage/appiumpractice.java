package Appiumtestpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class appiumpractice 

{
	public AndroidDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		URL url = new URL("http://127.0.0.1:4723/");
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformVersion("14");
		options.setAutomationName("Android");
		options.setAutoGrantPermissions(true);
		options.setUdid("emulator-5556");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.hannainst.hannapool");
		options.setAppActivity("com.hannainst.hannapool.MainActivity");
		
		driver=new AndroidDriver(url,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void LoginPage() throws InterruptedException
	{
		WebElement EmailID=	driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		if(EmailID.isDisplayed())
		{
			EmailID.sendKeys("upasanahanna2@gmail.com");
			System.out.println("Entered EmailID");
		}
		else
		{
			System.out.println("EmailID is not displayed and emailId is not entered");
		}
		
		WebElement Password= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		if(Password.isDisplayed())
		{
			Password.sendKeys("Hanna@2022");
			System.out.println("Passwored Entered");
		}
		else
		{
			System.out.println("Passwored is not displayed and Passwored is not entered");
			
		}
		WebElement Login_Button= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")"));
			if(Login_Button.isDisplayed() && Login_Button.isEnabled())
			{
				Login_Button.click();
				System.out.println("Login successfully");
				Thread.sleep(5000);
			}
			
			else
			{
				System.out.println("Loing is unsuccesssful");
			}
		
	}

	@AfterMethod
	public void teardown()
	{
	driver.quit();
	}

}
