package com.s3.businessLogic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Utils;

public class ModuleReplaceIcon extends Utils {
	public static boolean JavaAppOpen;

	// private static WebElement element = null;

	public static void ReplaceImage(String image) throws IOException,
			InterruptedException, AWTException {
		System.out.println(driver.findElement(
						By.xpath("//div[@class='popupBars popupHeader']/h1"))
						.getText());
		driver.findElement(By.xpath("//div[@class='file-drop-area']"))
				.click();
		Thread.sleep(3000);
		StringSelection ss = new StringSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		String OS = System.getProperty("os.name").toLowerCase();
		System.out.println(OS);
		File file = new File(image);
		StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
		Robot robot = new Robot();
		if(OS.contains("win"))
		{
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
		}
		else if (OS.contains("mac")){
			// Cmd + Tab is needed since it launches a Java app and the browser looses focus
			//StyleTab styletab = new StyleTab();
			if (JavaAppOpen==false) {
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(5000);
			}
			//Open Goto window
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_G);
			//Paste the clipboard value
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(3000);
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(5000);
			
		}
			
		try {
			if (driver.switchTo().alert() != null) {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				AddModule_Objects.saveOrCancel = "Cancel";
				driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel()))
						.click();
			
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			if (driver.findElement(
					By.xpath("//div[@class='popupBars popupFooter']"))
					.isDisplayed()) {
				AddModule_Objects.saveOrCancel = "Save";
				driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel()))
						.click();
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Please enter a valid formate file");
		}
		try {
			boolean b = driver.findElement(
					By.cssSelector(".upload-status-label.dub-font-bold"))
					.isDisplayed();
			if (b == true) {
				String ErrorMsg = driver.findElement(
						By.cssSelector(".upload-status-label.dub-font-bold"))
						.getText();
				System.out.println(ErrorMsg);
				AddModule_Objects.saveOrCancel = "Cancel";
				driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel()))
						.click();
			} else if (b = false) {
				System.out
						.println("please enter Correct Path in autoit script");
			}
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}

	}
}
