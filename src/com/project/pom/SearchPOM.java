package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPOM {
	private AndroidDriver<AndroidElement> driver; 
	private AndroidTouchAction t1;
		
		public SearchPOM(AndroidDriver<AndroidElement> driver) {
			this.driver =  driver; 
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath="//android.widget.EditText[@text = 'Search']")
		private AndroidElement searchEditBox; 
		
		
		public void TapSearchEditBox() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.searchEditBox))).perform();
			
		}
		
		public void TypeSearchEditBox(String value) {
			this.searchEditBox.setValue(value);
		}
		
		public void AndroidKeyPress(int i) {
			this.driver.pressKeyCode(i);
		}
		
		public void AndroidScrollingClick(String text) {
			//driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));").click();
			this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
		}

}
