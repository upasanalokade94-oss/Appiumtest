package Appiumtestpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SimpleappiumbrowserProgram {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		URL url =new URL("http://127.0.0.1:4723/");
		
		UiAutomator2Options options=new UiAutomator2Options();
		
		options.setPlatformName("Android");
		options.setPlatformVersion("14");
		options.setUdid("emulator-5554");
		options.setCapability("browser", "chrome");
		//options.withBrowserName("chrome");
	
		options.setAutoGrantPermissions(true);
		AndroidDriver driver=new AndroidDriver(url,options);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://test.hinstdev.com/");
		
		Thread.sleep(5000);
		
		WebElement EmailID=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		EmailID.sendKeys("upasanalokade@gmail.com");
		
		WebElement passwordField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		passwordField.sendKeys("Hanna@2022");

		WebElement loginButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")"));
		loginButton.click();
		Thread.sleep(3000);
		
		WebElement Invalid_text= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Invalid email ID or password.\")"));
		if(Invalid_text.isDisplayed())
		{
		System.out.println("Test is passed");
		}
		
		WebElement Forgot_password= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Forgot Password?\")"));
		if (Forgot_password.isDisplayed())
		{
			Forgot_password.click();
			Thread.sleep(3000);
			WebElement Forgotpassword_text= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Forgot Password?\")"));
			if(Forgotpassword_text.isDisplayed())
			{
				System.out.println("Navigated to forgot password");
			}
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Navigate back to the login page");
		
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent (AndroidKey.HOME));
		System.out.println("Navigated to home page");
		
		Thread.sleep(5000);
		
		
		driver.quit();
	}

}
