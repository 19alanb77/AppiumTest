package TestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorEmulator 
{
	private static AndroidDriver driver;
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"),capabilities);
	}
	
	@Test(description = "Add two digits and check result")
	public void calculatorTest() {
	    WebElement six = driver.findElementById("com.android.calculator2:id/digit_6");
	    WebElement two = driver.findElementById("com.android.calculator2:id/digit_2");
	    WebElement plus = driver.findElementById("com.android.calculator2:id/op_add");
            WebElement equalTo = driver.findElementById("com.android.calculator2:id/eq");
	    WebElement results = driver.findElementById("com.android.calculator2:id/formula");
	        
	    six.click();
	    plus.click();
	    two.click();
	    equalTo.click();
	    Assert.assertTrue(results.getText().equals("8"));
	}
	
	@AfterClass(description = "Close initialized driver")
	public void closeDriver() {
	    driver.quit();
	}
}
