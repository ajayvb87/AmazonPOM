package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SanyoPagePOM {
	private AndroidDriver<AndroidElement> driver; 
	private AndroidTouchAction t1;
		
		public SanyoPagePOM(AndroidDriver<AndroidElement> driver) {
			this.driver =  driver; 
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath="//android.widget.Button[@text = 'Use my current location']")
		private AndroidElement useCurrentLocationButton; 
		
		@AndroidFindBy(xpath="//android.widget.Button[@text = 'Allow']")
		private AndroidElement allowLocation; 
		
		@AndroidFindBy(xpath="//android.widget.Button[@text = 'Proceed to checkout']")
		private AndroidElement proceedCheckout; 
		
		
		public void TapCurrentLocationButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.useCurrentLocationButton))).perform();
			
		}
		
		public void TapAllowButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.allowLocation))).perform();
			
		}
		
		public void AndroidScrollingClick(String text) {
			//driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));").click();
			this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
		}
		
		public void TapProceedCheckoutButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.proceedCheckout))).perform();
			
		}
		
		public void androidOrientation() {
			this.driver.rotate(ScreenOrientation.LANDSCAPE);
		}

}
