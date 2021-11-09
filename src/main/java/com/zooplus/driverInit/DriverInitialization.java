package com.zooplus.driverInit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.zooplus.pageObjects.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverInitialization {
	public static AppiumDriver driver;
	
	public static BasePage Base = null;
	@Before
	public static void driverInit() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("useNewWDA", true);
		capabilities.setCapability("app", System.getProperty("user.dir")+"app-mock-debug.apk");
// 		capabilities.setCapability("appPackage", "com.example.android.architecture.blueprints.master.mock");
// 		capabilities.setCapability("appActivity", "com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Base = new BasePage(driver);
		
	}
	
	
	@After
	public static void teardown() {
		driver.quit();
		
	}
	
	
	
}
