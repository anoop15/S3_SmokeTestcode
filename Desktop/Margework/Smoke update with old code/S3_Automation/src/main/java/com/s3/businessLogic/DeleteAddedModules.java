package com.s3.businessLogic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class DeleteAddedModules extends Utils {
	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;
	static String deleteModuleName;

	public static void deleteModule(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		deleteModuleName = ExcelUtils.getCellData(1, 4, ExcelFile,
				ExcelSheetName);
		if (null != deleteModuleName) {
			Thread.sleep(5000);
			String selectedAppActiveMenu = driver.findElement(
					By.xpath("//li[@class='is-selected']/a")).getText();
			if (selectedAppActiveMenu != "Modules") {
				Log.warn("By-default Modules Is Not Selected In App-Config-Menu");
				driver.findElement(By.xpath("//a[@data-dub_section='pages']"))
						.click();
			}
			String nom = driver.findElement(By.id("app-modules-title"))
					.getText();
			System.out.println(nom);
			Thread.sleep(2000);
			boolean isModulePresent = driver
					.findElement(
							By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
									+ deleteModuleName + "')]")).isDisplayed();
			if (isModulePresent) {
				driver.findElement(
						By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
								+ deleteModuleName + "')]")).click();
				Thread.sleep(1000);
				element = driver.findElement(By.id("moduleDelete"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(1000);
				String removeOrcancel = ExcelUtils.getCellData(1, 5, ExcelFile,
						ExcelSheetName);
				if (removeOrcancel.equalsIgnoreCase("Yes")) {
					AddModule_Objects.deleteOrCancel = "Remove";
					driver.findElement(
							By.xpath(AddModule_Objects.getDeleteOrCancel()))
							.click();
				} else {
					AddModule_Objects.deleteOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AddModule_Objects.getDeleteOrCancel()))
							.click();
				}
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			/*	Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();*/
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(4000,0);");

			} else {
				isClickDone(1);
				isModulePresent = driver
						.findElement(
								By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
										+ deleteModuleName + "')]"))
						.isDisplayed();
				if (isModulePresent) {
					Thread.sleep(1000);
					driver.findElement(
							By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
									+ deleteModuleName + "')]")).click();
					element = driver.findElement(By.id("moduleDelete"));
					Utils.waitForElementToBeClickable(element);
					element.click();
					Thread.sleep(2000);
					String removeOrcancel = ExcelUtils.getCellData(1, 5,
							ExcelFile, ExcelSheetName);
					if (removeOrcancel.equalsIgnoreCase("Yes")) {
						AddModule_Objects.deleteOrCancel = "Remove";
						driver.findElement(
								By.xpath(AddModule_Objects.getDeleteOrCancel()))
								.click();
					} else {
						AddModule_Objects.deleteOrCancel = "Cancel";
						driver.findElement(
								By.xpath(AddModule_Objects.getDeleteOrCancel()))
								.click();
					}
				}
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				AddModuleObjects.getClkPublishPopUp().click();
			/*	Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();*/
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(4000,0);");
			}
		}
	}

	private static int startIndex = 0;

	private static void isClickDone(int rowIndex) {
		boolean isClickPerformed = false;

		try {

			List<WebElement> elementsList = driver.findElements(By
					.xpath("//div[@id='sortlist']"));
			WebElement completeData = elementsList.get(0);
			String myModuleName = completeData.getText();
			if (myModuleName != null) {
				String[] arr = myModuleName.split("\n");

				for (int k = 0; k < arr.length; k++) {
					if (arr[k].contains(deleteModuleName)) {
						String str = "//div[@id='sortlist']/div["
								+ (k + startIndex + 1) + "]/div/div[1]/button";
						driver.findElement(By.xpath(str)).click();
						isClickPerformed = true;
					}
				}
			}

			if (!isClickPerformed) {
				startIndex = startIndex + 2;
				boolean isRightScrollEnable = driver.findElement(
						By.cssSelector("#appModulesScrollRight")).isEnabled();
				if (isRightScrollEnable)
					driver.findElement(By.cssSelector("#appModulesScrollRight"))
							.click();
				else {
					System.out.println("Right Scroll is Disabled");

				}
				Thread.sleep(3000);
				isClickDone(rowIndex);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
