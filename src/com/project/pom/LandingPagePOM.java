package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LandingPagePOM {
private AndroidDriver<AndroidElement> driver; 
private AndroidTouchAction t1;
	
	public LandingPagePOM(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text = 'Skip sign in']")
	private AndroidElement skipSignIn; 
	
	@AndroidFindBy(xpath="//android.widget.Button[@text = 'New to Amazon.in? Create an account']")
	private AndroidElement newAmazon;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text = 'Already a customer? Sign in']")
	private AndroidElement alreadyCustomer; 
	
	
	public void TapskipSignIn() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.skipSignIn))).perform();
		
	}
	
	
	
}
