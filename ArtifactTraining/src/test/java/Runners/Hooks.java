package Runners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;

import ResuableMethods.PageUtility;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static AppiumDriver driver;
    PageUtility util = new PageUtility();
    String platform = util.readProperty("Platform");

    @Before
    public void setUp() {
        System.out.println("Setting up Appium driver...");

		
		DesiredCapabilities caps = new DesiredCapabilities();
		if(platform.equalsIgnoreCase("Android")) {
			caps.setCapability("appium:deviceName", util.readProperty("Device_Name"));
			caps.setCapability("appium:platformName", util.readProperty("Platform"));
			caps.setCapability("appium:platformVersion", util.readProperty("Platform_Version"));
			caps.setCapability("appium:app", util.readProperty("App"));
			caps.setCapability("appium:automationName", util.readProperty("Automation_Name"));
			caps.setCapability("noReset", true);
			caps.setCapability("autoGrantPermissions", true);
//			caps.setCapability("appium:appPackage", util.readProperty("AppPackage"));
		}else if(platform.equalsIgnoreCase("Ios")) {
			
		}
		
		try {
			
			driver = new AppiumDriver<>(new URL(util.readProperty("Appium_Url")), caps);
			System.out.println("Driver Initialized Successfully : " + platform);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}catch (Exception e) {
			System.out.println("Failed to Initialized Driver. Please check Appium url");
			e.printStackTrace();
		}
		
	
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down Appium driver...");
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure driver is reset between tests
            System.out.println("Appium driver quit successfully.");
        }
    }

    public static AppiumDriver getDriver() {
        System.out.println("Returning Appium driver instance...");
        return driver;
    }
}

