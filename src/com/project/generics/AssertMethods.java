package com.project.generics;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

/**
 * 
 * @author Ajay
 * @see this class will help when you want to do custom business logic, since in
 *      POM we dont do dynamic elements available, when you want to iterate the
 *      table/accordion etc
 * @since 3-Feb-2020
 */
public class AssertMethods {
	WebDriver driver;
	SoftAssert s;

	public AssertMethods(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @param locator
	 * @param type
	 * @see type is id, name, xpath, text, partialtext
	 * @see locator will be the element to be found on DOM
	 * @return WebElement this method shall give provided it has single enty in the
	 *         DOM
	 */
	
	// AssertURl - getUrl()
	public void assertURL(String expectedURL) {
		String actualURL = driver.getCurrentUrl();
		System.out.println("The URL at runtime is " + actualURL);
		s = new SoftAssert();
		s.assertTrue(actualURL.equals(expectedURL),
				"The assertion failed as the expected URL did not match with actual URL");
		s.assertAll();
	}

	// AssertTEXT - getText
	public void assertText(String expectedText, String locator, String type, String msg) {
		type = type.toLowerCase();
		s = new SoftAssert();
		if (type.equals("id")) {
			String actualText = driver.findElement(By.id(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("class")) {
			String actualText = driver.findElement(By.className(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("name")) {
			String actualText = driver.findElement(By.name(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("xpath")) {
			String actualText = driver.findElement(By.xpath(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("css")) {
			String actualText = driver.findElement(By.cssSelector(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("tagname")) {
			String actualText = driver.findElement(By.tagName(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("linktext")) {
			String actualText = driver.findElement(By.linkText(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		} else if (type.equals("partiallinktext")) {
			String actualText = driver.findElement(By.partialLinkText(locator)).getText();
			s.assertTrue(actualText.equals(expectedText), msg);
			s.assertAll();
		}

	}
	
	// AssertAttributeValue = getAttribute()
	//Attribute type - value, id, class, name, title, 
	//type - xpath, name, class, xpath, css, tagname, partiallinktext,linktext
	public void assertAttributeValue(String expectedAttributeVal, String attributeType,String locator, String type, String msg) {
		type = type.toLowerCase();
		s = new SoftAssert();
		if (type.equals("id")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("class")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("name")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("xpath")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("css")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("tagname")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("linktext")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		} else if (type.equals("partiallinktext")) {
			String actualAttributeVal = driver.findElement(By.id(locator)).getAttribute(attributeType);
			s.assertTrue(actualAttributeVal.equals(expectedAttributeVal), msg);
			s.assertAll();
		}

	}
	
	// AssertTitle = getTitle();
	public void assertTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("The URL at runtime is " + actualTitle);
		s = new SoftAssert();
		s.assertTrue(actualTitle.equals(expectedTitle),
				"The assertion failed as the expected URL did not match with actual URL");
		s.assertAll();
	}

}