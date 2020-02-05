package com.project.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 * @author Ajay
 * @see This class will load the given driver, and follows factory pattern
 * @since 03-Feb-2020
 */
public class DriverFactory {
	// it only a reference
	private static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> getDriver(String driverName) throws MalformedURLException {

		if (driverName.equals(DriverNames.ANDROID)) {
			InstallInvokeApk(Devicespec.DEVICENAME, Devicespec.UDID);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static AndroidDriver<AndroidElement> getDriverPac(String driverName) throws MalformedURLException {

		if (driverName.equals(DriverNames.ANDROID)) {
			PackageActivity(Devicespec.DEVICENAME, Devicespec.UDID, Devicespec.PACKAGE, Devicespec.ACTIVITY);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	// Function for Android Real Time Device or Emulator Device
	public static AndroidDriver<AndroidElement> InstallInvokeApk(String deName, String UID)
			throws MalformedURLException {
		// Install and Invoke APIDemo in Emulator/Real Time Android
		File f1 = new File("src");

		// Define the absolute path of APK file - Give the APK file name
		File f2 = new File(f1, "Amazon_shopping.apk");

		// Define the setting like device name, UDID, Automation name, command timeout
		// and Absolute path of APK
		// Use the Desired Capabilities class of Selenium
		DesiredCapabilities cap = new DesiredCapabilities();

		// Define the platform
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		// Device Name
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deName);

		// Set the UDID number
		cap.setCapability(MobileCapabilityType.UDID, UID);// Not needed for IOS Simulator

		// Set the Automation name - Android - UiAutomator2, IOS - XCUITest
		// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		// Set the command timeout
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);

		// Set the absolute path - dynamically
		cap.setCapability(MobileCapabilityType.APP, f2.getAbsolutePath());

		// Set the Android Driver
		// AndroidDriver driver = new AndroidDriver(URl where appium server is working,
		// capability);
		// 127.0.0.1:4723 - URL class
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	// Function is applicable for only Android - Not IOS
	public static AndroidDriver<AndroidElement> PackageActivity(String deName, String UID, String pac, String act)
			throws MalformedURLException {

		// Install and Invoke APIDemo in Emulator/Real Time Android
		File f1 = new File("src");

		// Define the absolute path of APK file - Give the APK file name
		File f2 = new File(f1, "Amazon_shopping.apk");

		// Define the setting like device name, UDID, Automation name, command timeout
		// and Absolute path of APK
		// Use the Desired Capabilities class of Selenium
		DesiredCapabilities cap = new DesiredCapabilities();

		// Define the platform
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		// Device Name
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deName);

		// Set the UDID number
		cap.setCapability(MobileCapabilityType.UDID, UID);// Not needed for IOS Simulator

		// Set the Automation name - Android - UiAutomator2, IOS - XCUITest
		// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		// Set the command timeout
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);

		// Set up the package
		cap.setCapability("appPackage", pac);

		// Set up the activity
		cap.setCapability("appActivity", act);

		// Set the absolute path - dynamically
		cap.setCapability(MobileCapabilityType.APP, f2.getAbsolutePath());

		// Set the Android Driver
		// AndroidDriver driver = new AndroidDriver(URl where appium server is working,
		// capability);
		// 127.0.0.1:4723 - URL class
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
	}

}