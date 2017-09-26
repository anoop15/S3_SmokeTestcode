package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class MyApplication extends Utils {

	static AddModule_Objects AddModuleObjects;
	static boolean b;

	public static void SearchApp(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		AddModuleObjects.getSearch().clear();
		String appName = ExcelUtils
				.getCellData(1, 3, ExcelFile, ExcelSheetName);
		AddModuleObjects.getSearch().sendKeys(appName);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			b = driver.findElement(By.cssSelector(".dub-font-bold"))
					.isDisplayed();
			Thread.sleep(2000);
			if (b) {
				System.out.println(driver.findElement(
						By.cssSelector(".dub-font-bold")).getText());
				System.out
						.println("Please Enter The Correct Data in Workbook Sheet");
			}
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		Thread.sleep(3000);
		if (b == false) {
			boolean isAppPresent = false;
			AddModule_Objects.appName = appName;
			try {
				isAppPresent = driver.findElement(
						By.xpath(AddModule_Objects.getClkMyApp()))
						.isDisplayed();
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("App Not Present,Please Enter Correct App Name In Workbook");
			}
			if (isAppPresent)
				action.moveToElement(
						driver.findElement(By.xpath(AddModule_Objects
								.getClkMyApp()))).perform();
		}
	}

	public static void EditMyApp(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (b == false) {
			MyApplication.SearchApp(row, col, ExcelFile, ExcelSheetName);
			boolean isPresent = false;
			try {
				isPresent = driver.findElement(
						By.xpath(AddModule_Objects.getEditApp())).isDisplayed();
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
			}
			if (isPresent) {
				System.out
						.println("User Login with Dub System Admin credetials");
				driver.findElement(By.xpath(AddModule_Objects.getEditApp()))
						.click();
				Thread.sleep(2000);
				String NewAppName = ExcelUtils.getCellData(1, 4, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getApplicationName().clear();
				AddModuleObjects.getApplicationName().sendKeys(NewAppName);
				boolean b = AddModuleObjects.getEditPartnerName().isEnabled();
				if (b)
					System.out.println("There is an issue in functionality");
				else
					System.out.println("Partner Select box is Disable");
				String newClientName = ExcelUtils.getCellData(1, 5, ExcelFile,
						ExcelSheetName);
				String newAppFigures = ExcelUtils.getCellData(1, 6, ExcelFile,
						ExcelSheetName);
				try {
					Thread.sleep(1000);
					Select selectclient = new Select(
							AddModuleObjects.getEditClientName());
					selectclient.selectByVisibleText(newClientName);
					Thread.sleep(2000);
					Select selectAppFigures = new Select(
							AddModuleObjects.getDisplayAppFigures());
					selectAppFigures.selectByVisibleText(newAppFigures);
				} catch (NoSuchElementException nse) {
					nse.getStackTrace();
				}
				String saveOrCancel = ExcelUtils.getCellData(1, 7, ExcelFile,
						ExcelSheetName);
				if (saveOrCancel.equalsIgnoreCase("Save")) {
					AddModule_Objects.saveOrCancel = "Save";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				} else {
					AddModule_Objects.saveOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				}
			} else {
				System.out
						.println("Edit App Funationality not for Partner/Client Users");
			}
		}
	}

	public static void CopyMyApp(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (b == false) {

			boolean isMultiCampus = false;
			MyApplication.SearchApp(row, col, ExcelFile, ExcelSheetName);
			boolean isPresent = false;
			try {
				isPresent = driver.findElement(
						By.xpath(AddModule_Objects.getCopyApp())).isDisplayed();
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
			}
			if (isPresent) {
				driver.findElement(By.xpath(AddModule_Objects.getCopyApp()))
						.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				String newAppName = ExcelUtils.getCellData(1, 4, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getApplicationName().clear();
				AddModuleObjects.getApplicationName().sendKeys(newAppName);
				String newPartnerName = ExcelUtils.getCellData(1, 5, ExcelFile,
						ExcelSheetName);
				String newClientName = ExcelUtils.getCellData(1, 6, ExcelFile,
						ExcelSheetName);
				try {
					isMultiCampus = driver.findElement(
							By.xpath("//select[@multiple='multiple']"))
							.isDisplayed();
				} catch (NoSuchElementException nse) {
					nse.getStackTrace();
				}
				if (isMultiCampus) {

					int lastCellNo = ExcelUtils.getLastRowNum(ExcelFile,
							ExcelSheetName);
					try {
						Select selectPartner = new Select(
								AddModuleObjects.getEditPartnerName());
						selectPartner.selectByVisibleText(newPartnerName);
						Thread.sleep(2000);
						Select selectClient = new Select(
								AddModuleObjects.getEditClientName());
						selectClient.deselectAll();
						for (int i = 1; i <= lastCellNo; i++) {
							String newClientName1 = ExcelUtils.getCellData(i,
									6, ExcelFile, ExcelSheetName);
							Actions action = new Actions(driver);
							action.sendKeys(Keys.CONTROL).perform();
							selectClient.selectByVisibleText(newClientName1);

						}
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
					}
				}
				if (!isMultiCampus) {
					try {
						Select selectPartner = new Select(
								AddModuleObjects.getEditPartnerName());
						selectPartner.selectByVisibleText(newPartnerName);
						Thread.sleep(2000);
						Select selectClient = new Select(
								AddModuleObjects.getEditClientName());
						selectClient.selectByVisibleText(newClientName);
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
					}
				}
				String saveOrCancel = ExcelUtils.getCellData(1, 7, ExcelFile,
						ExcelSheetName);
				if (saveOrCancel.equalsIgnoreCase("Save")) {
					AddModule_Objects.saveOrCancel = "Save";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				} else {
					AddModule_Objects.saveOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				}
			} else {
				System.out
						.println("Copy App Funationality not for Partner/Client Users");
			}
		}
	}

	public static void DeleteApp(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (b == false) {
			MyApplication.SearchApp(row, col, ExcelFile, ExcelSheetName);
			boolean isPresent = false;
			try {
				isPresent = driver.findElement(
						By.xpath(AddModule_Objects.getDeleteApp()))
						.isDisplayed();
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
			}
			if (isPresent) {
				driver.findElement(By.xpath(AddModule_Objects.getDeleteApp()))
						.click();
				Thread.sleep(2000);
				// driver.manage().timeouts().implicitlyWait(10,
				// TimeUnit.SECONDS);
				String deleteOrCancel = ExcelUtils.getCellData(1, 4, ExcelFile,
						ExcelSheetName);
				if (deleteOrCancel.equalsIgnoreCase("Delete")) {
					AddModule_Objects.deleteOrCancel = "Delete";
					driver.findElement(
							By.xpath(AddModule_Objects.getDeleteOrCancel()))
							.click();
					MyApplication
							.SearchApp(row, col, ExcelFile, ExcelSheetName);
					System.out
							.println(AddModuleObjects.getNoResult().getText());
				} else {
					AddModule_Objects.deleteOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AddModule_Objects.getDeleteOrCancel()))
							.click();
				}
			} else {
				System.out
						.println("Delete App Funationality not for Partner/Client Users");
			}
		}
	}

}
