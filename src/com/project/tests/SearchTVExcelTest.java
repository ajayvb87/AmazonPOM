package com.project.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.dataproviders.LoginDataProviders;
import com.project.generics.AssertMethods;
import com.project.generics.ScreenShot;
import com.project.pom.LandingPagePOM;

import com.project.pom.SanyoPagePOM;
import com.project.pom.SearchPOM;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchTVExcelTest {
	private AndroidDriver<AndroidElement> driver;
	private LandingPagePOM landingpagePOM;
	private SearchPOM searchPOM;
	private SanyoPagePOM sanyoPagePOM;
	private ScreenShot screenShot;
	private AssertMethods assertmeth;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\AmazonProject\\resources\\Assert.properties");
		properties.load(inStream);
	}



	@BeforeMethod
	public void setUp() throws Exception {
		// The package and activity capability is called
		driver = DriverFactory.getDriverPac(DriverNames.ANDROID);
		// The landing page is instantiated
		landingpagePOM = new LandingPagePOM(driver);
		// The search page is instantiated
		searchPOM = new SearchPOM(driver);
		// The Sanyo page is instantiated
		sanyoPagePOM = new SanyoPagePOM(driver);
		// The Screenshot class is instantiated
		screenShot = new ScreenShot(driver);
		// The assert method class is instantiated
		assertmeth = new AssertMethods(driver);
	}

	

	@Test(dataProvider = "xls-inputs", dataProviderClass = LoginDataProviders.class)
	public void SearchTVDBTest(String searchData, String text) throws InterruptedException {
		Thread.sleep(10000);
		// Validation for Skip sign in text in the button - using Assert properties file
		assertmeth.assertText(properties.getProperty("skiptext"), properties.getProperty("skipxpath"), properties.getProperty("skiplocator"),
				properties.getProperty("skipmessage"));
		// Screenshot of Landing page
		screenShot.captureScreenShot("LandingPage");
		// Tap on Skip Sign in button
		landingpagePOM.TapskipSignIn();

		Thread.sleep(5000L);

		// Validation for Search text in the edit box- using Assert properties file
		assertmeth.assertText(properties.getProperty("searchtext"), properties.getProperty("searchxpath"), properties.getProperty("searchlocator"),
				properties.getProperty("searchmessage"));
		// Tap on Edit box
		searchPOM.TapSearchEditBox();
		// Screenshot of Search page before typing on edit box
		screenShot.captureScreenShot("SearchPage");
		// Typing 65 inch TV on Search Edit box
		searchPOM.TypeSearchEditBox(searchData);
		// Initiate the pressing of Enter button
		searchPOM.AndroidKeyPress(66);
		// Screenshot of page containing 65 inch tv
		screenShot.captureScreenShot("65inchTVPage");
		// Scrolling and clicking on Sanyo 165 cm (65 inches)
		searchPOM.AndroidScrollingClick(text);

		Thread.sleep(5000L);

		// Screenshot of page containing Current location pop up
		screenShot.captureScreenShot("CurrentLocationPage");
		// Validation for Use my current location text in the button- using Assert properties file
		assertmeth.assertText(properties.getProperty("uselocationtext"), properties.getProperty("uselocationxpath"), properties.getProperty("uselocationlocator"),
				properties.getProperty("usalocationmessage"));
		// Tap on Use my current location text button
		sanyoPagePOM.TapCurrentLocationButton();
		// Screenshot of page containing Allowing for Location
		screenShot.captureScreenShot("AllowLocation");
		// Tap on Allow location button
		sanyoPagePOM.TapAllowButton();
		// Scroll to click on Add to cart button
		sanyoPagePOM.AndroidScrollingClick("Add to Cart");
		// Validation for Proceed to Checkout text in the button- using Assert properties file
		assertmeth.assertText(properties.getProperty("checkouttext"), properties.getProperty("checkoutxpath"), properties.getProperty("checkoutlocator"),
				properties.getProperty("checkoutmessage"));
		// Tap on Proceed to Checkout button
		sanyoPagePOM.TapProceedCheckoutButton();
		// Screenshot of the login page asking for credentials
		screenShot.captureScreenShot("LoginPage");
		// Changing the orientation from portrait to Landscape
		sanyoPagePOM.androidOrientation();
		// Screenshot for orientation change
		screenShot.captureScreenShot("OrientationChanged");

		Thread.sleep(10000L);

	}
	
	@AfterMethod
	public void tearDown(ITestResult t) throws Exception {
		// Screenshot on Validation failure
		if (t.getStatus() == t.FAILURE) {
			screenShot.captureScreenShotFailure(t.getName());
		}

		Thread.sleep(1000);
		driver.quit();
	}

}