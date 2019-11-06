package TestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class WebEmulator 
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
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"),capabilities);
	}
	
	@Test(description = "Try to login to facebook with random name")
	public void calculatorTest() {
		driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("your_email@gmail.com");
		driver.findElementByXPath("//*[@id='m_login_password']").sendKeys("your_password");
		driver.findElementByXPath("//*[@id=\"u_0_6\"]").click();
	}
	
	@AfterClass(description = "Close initialized driver")
	public void closeDriver() {
	    	driver.quit();
	}

}
