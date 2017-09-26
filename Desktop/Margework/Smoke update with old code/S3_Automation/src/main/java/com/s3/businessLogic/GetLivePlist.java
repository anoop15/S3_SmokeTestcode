package com.s3.businessLogic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Utils;

public class GetLivePlist extends Utils {

	static AddModule_Objects AddModuleObjects;
	public static String url;
	private static WebElement element = null;

	public static String generateLiveAppPlist() throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		try {
			AddModule_Objects.saveOrDiscard = "Save";
			boolean b = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).isDisplayed();
			if (b) {
				driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			}
			if (!b) {
				boolean isEnable = AddModuleObjects.getClkPublish().isEnabled();
				if (isEnable) {
					element = AddModuleObjects.getClkPublish();
					Utils.waitForElementToBeClickable(element);
					element.click();
					AddModuleObjects.getClkPublishPopUp().click();
				}
			}

		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0, -700);");
		AddModuleObjects.getClkSettings().click();
		Thread.sleep(2000);
		String OS = Utils.getOS();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		Thread.sleep(3000);
		AddModuleObjects.getClkAdvancedSettings().click();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		boolean isDisplayedLivePList = AddModuleObjects.getClkLiveAppPlist().isDisplayed();
		if (isDisplayedLivePList) {
			try {
				String winHandleBefore = driver.getWindowHandle();
				 AddModuleObjects.getClkLiveAppPlist().click();;
				/*for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					System.out.println(driver.getTitle());
				}*/
				System.out.println("----- "+ ModuleReplaceIcon.JavaAppOpen);
				Robot rb = new Robot();
				if (ModuleReplaceIcon.JavaAppOpen==false) {
				rb.keyPress(KeyEvent.VK_META);
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_META);
				rb.keyRelease(KeyEvent.VK_TAB);
				rb.delay(1000);
				}
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				rb.delay(100);
				rb.keyPress(KeyEvent.VK_META);
				rb.keyPress(KeyEvent.VK_C);
				rb.delay(100);
				rb.keyRelease(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_META);
				url = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
						.getData(DataFlavor.stringFlavor);
				System.out.println("-------------"+url);
				// List<String> winId = new
				// ArrayList<String>(driver.getWindowHandles());
				// driver.switchTo().window(winId.get(1));
				// // Thread.sleep(1000);
				ModuleReplaceIcon.JavaAppOpen=true;
				List<String> winId = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(winId.get(1));
			//	url = driver.getCurrentUrl();
				System.out.println("Live PList URL :" + url);
				Thread.sleep(3000);
				driver.close();
				driver.switchTo().window(winHandleBefore);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("pList Link not Displayed");
		}

		return url;
	}

	// Overload this mathod due to RSS module Advance button not clicked due to
	// change xpath
	public static String generateLiveAppPlist(String Modulename) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		try {
			AddModule_Objects.saveOrDiscard = "Save";
			boolean b = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).isDisplayed();
			if (b) {
				driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			}
			if (!b) {
				boolean isEnable = AddModuleObjects.getClkPublish().isEnabled();
				if (isEnable) {
					element = AddModuleObjects.getClkPublish();
					Utils.waitForElementToBeClickable(element);
					element.click();
					AddModuleObjects.getClkPublishPopUp().click();
				}
			}

		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0, -700);");
		AddModuleObjects.getClkSettings().click();
		Thread.sleep(2000);
		String OS = Utils.getOS();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		Thread.sleep(2000);
		AddModuleObjects.getClkAdvancedSettings1().click();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		boolean isDisplayedLivePList = AddModuleObjects.getClkLiveAppPlist().isDisplayed();
		if (isDisplayedLivePList) {
			try {
				String winHandleBefore = driver.getWindowHandle();
				AddModuleObjects.getClkLiveAppPlist().click();
				Thread.sleep(1000);
				System.out.println("Is java app opens"+ ModuleReplaceIcon.JavaAppOpen);
				/*for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					System.out.println(driver.getTitle());
				}*/
				Robot rb = new Robot();
				if (ModuleReplaceIcon.JavaAppOpen==false) {
				rb.keyPress(KeyEvent.VK_META);
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_META);
				rb.keyRelease(KeyEvent.VK_TAB);
				rb.delay(1000);
				}
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				rb.delay(100);
				rb.keyPress(KeyEvent.VK_META);
				rb.keyPress(KeyEvent.VK_C);
				rb.delay(100);
				rb.keyRelease(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_META);
				url = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
						.getData(DataFlavor.stringFlavor);
				System.out.println("-------------"+url);
				ModuleReplaceIcon.JavaAppOpen=true;
				List<String> winId = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(winId.get(1));
//			winHandleBefore = driver.getWindowHandle();
//			WebElement link = AddModuleObjects.getClkLiveAppPlist();
//			Actions newwin = new Actions(driver);
//			newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
//			
//			  for (String winHandle : driver.getWindowHandles()) {
//			  driver.switchTo().window(winHandle); }
//			 
//			List<String> winId = new ArrayList<String>(driver.getWindowHandles());
//			String child = winId.get(1);
//			String parent = winId.get(0);
//			driver.switchTo().window(child);
//			Thread.sleep(1000);
			//url = driver.getCurrentUrl();
			
			System.out.println("Live PList URL :" + url);
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(winHandleBefore);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("pList Link not Displayed");
		}

		return url;
	}

	public static String generateMultiCampusPlist() throws AWTException {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		AddModuleObjects.getClkSettings().click();
		String OS = Utils.getOS();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		AddModuleObjects.getClkAdvancedSettings().click();
		if (OS.contains("win")) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);
		} else if (OS.contains("mac")) {
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_F);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyPress(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_DOWN);
			 * robot.keyRelease(KeyEvent.VK_F);
			 */
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,4000);");
		}
		boolean isDisplayed = AddModuleObjects.ClkLiveAppPlistMulti().isDisplayed();
		if (isDisplayed) {
			AddModuleObjects.ClkLiveAppPlistMulti().click();
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			url = driver.getCurrentUrl();
			System.out.println("Single Campus PList URL :" + url);
			driver.switchTo().window(winHandleBefore);
		} else {
			System.out.println("Not a MultiCampus App / MutliCampus Plist Not Displayed");
		}
		return url;
	}

}
