package com.project.generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * 
 * @author Ajay
 * @see in this class the path for screenshot is hard coded, please refer to
 *      others.properties file the entry is kept, and this path shall be able to
 *      change from properties file
 */
public class ScreenShot {

	private WebDriver driver;

	// the driver information will be given by selenium test case
	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenShot() {

		// to be changed
		String path = System.getProperty("user.dir") + "\\StepwiseScreenshot\\";
		String fileName = "";

		GregorianCalendar calendar = new GregorianCalendar();

		int date = calendar.get(Calendar.DATE);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		fileName = new Integer(date).toString() + "-" + new Integer(minute).toString() + "-"
				+ new Integer(second).toString() + ".png";

		// 1. create file
		// 2. capture screenshot from selenium
		// 3. store it in physical driver

		try {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(path + fileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void captureScreenShot(String fileName) {

		String dateFormat;
		String path = System.getProperty("user.dir") + "\\StepwiseScreenshot\\";

		GregorianCalendar calendar = new GregorianCalendar();

		int date = calendar.get(Calendar.DATE);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		dateFormat = new Integer(date).toString() + "-" + new Integer(minute).toString() + "-"
				+ new Integer(second).toString() + ".png";

		// 1. create file
		// 2. capture screenshot from selenium
		// 3. store it in physical driver

		try {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File f1 = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File f2 = new File(path + fileName + dateFormat);
			FileUtils.copyFile(f1, f2);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void captureScreenShotFailure(String fileName) {

		String dateFormat;
		String path = System.getProperty("user.dir") + "\\FailScreenshot\\";

		GregorianCalendar calendar = new GregorianCalendar();

		int date = calendar.get(Calendar.DATE);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		dateFormat = new Integer(date).toString() + "-" + new Integer(minute).toString() + "-"
				+ new Integer(second).toString() + ".png";

		// 1. create file
		// 2. capture screenshot from selenium
		// 3. store it in physical driver

		try {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File f1 = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File f2 = new File(path + fileName + dateFormat);
			FileUtils.copyFile(f1, f2);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
