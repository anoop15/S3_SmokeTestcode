package com.s3.businessLogic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.s3.objectRepository.ManagePartners_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class ManagePartners extends Utils {
	Utils utils = new Utils();
	private static WebElement element = null;
	static ManagePartners_Objects ManagePartnerObject;
	public static String EditPartner;
	static Boolean iSAdminPresent;

	public static void ClkAdmin() {
		try {
			ManagePartnerObject = PageFactory.initElements(driver,
					ManagePartners_Objects.class);
			Utils.waitForElToBeRemove(driver,
					By.xpath("//div[@id='popup']/div"));
			element = ManagePartnerObject.getAdmin();
			iSAdminPresent = element.isDisplayed();
			if (iSAdminPresent) {
				element.click();
				Log.info("User Login With System Admin"
						+ "Admin Link is Present");
			} else {
				Log.info("User is not authorized for ADMIN operations"
						+ "user login with partner/client credentials");
				System.out
						.println("User is not authorized for ADMIN operations"
								+ " User login with partner/client credentials");
			}

		} catch (NoSuchElementException nse) {
			System.out.println(nse.getStackTrace());
		}

	}

	public static void ClkManagePartners() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		ManagePartnerObject.getManagePartnersSubModule().click();
		Utils.waitForElToBeRemove(driver,
				By.xpath("//div[@class='popupView dialog']"));
		Log.info("User has clicked on Manage Partner Sub-Module");

	}

	public static void CreatePartners(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (iSAdminPresent) {
			ManagePartnerObject.getCreatePartnerButton().click();
			String NewPartnerName = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			ManagePartnerObject.getCreatePartnerName().sendKeys(NewPartnerName);
			Log.info(NewPartnerName + "is a new partner");
			ManagePartnerObject.getSaveManagePartners().click();
			driver.navigate().refresh();
			ManagePartners_Objects.partner_name = NewPartnerName;
			// ManagePartnerObject.getManagePartnersSubModule().click();
			ClkManagePartners();
			Log.info("Manage Partner Sub-Module has been clicked");
			ManagePartnerObject.getSearchManagePartners().clear();
			Actions action = new Actions(driver);
			ManagePartnerObject.getSearchManagePartners().sendKeys(
					NewPartnerName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			action.sendKeys(Keys.ENTER).perform();
			element = driver.findElement(By.xpath(ManagePartners_Objects
					.getPartnerName()));
			Utils.waitForElementToBeVisible(element);
			boolean varification = element.isDisplayed();
			if (varification) {
				System.out.println("New partner is created succesfully");
			} else {
				System.out.println("partner not created");
			}
		}
	}

	public static void DeletePartners(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		if (iSAdminPresent) {

			String delete_Partner_Name = ExcelUtils.getCellData(1, 5,
					ExcelFile, ExcelSheetName);
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Log.info(delete_Partner_Name + " name is fetched from Excel Sheet");
			ManagePartnerObject.getSearchManagePartners().clear();
			Actions action = new Actions(driver);
			ManagePartnerObject.getSearchManagePartners().sendKeys(
					delete_Partner_Name);
			action.sendKeys(Keys.ENTER).perform();
			Log.info(delete_Partner_Name + " name entered into serch");
			Thread.sleep(2000);
			ManagePartners_Objects.partner_name = delete_Partner_Name;
			driver.findElement(
					By.xpath(ManagePartners_Objects.getDeletePartnerImg()))
					.click();
			String removeorCancel = ExcelUtils.getCellData(1, 6, ExcelFile,
					ExcelSheetName);
			ManagePartners_Objects.removeOrCancel = removeorCancel;
			driver.findElement(
					By.xpath(ManagePartners_Objects.getRemoveManagePartners()))
					.click();
			if (removeorCancel.equalsIgnoreCase("Remove")) {
				System.out.println("user has deleted partner");
				Log.info(delete_Partner_Name + "User has Deleted");
			} else if (removeorCancel.equalsIgnoreCase("Cancel")) {
				driver.navigate().refresh();
				// ManagePartnerObject.getManagePartnersSubModule().click();
				ClkManagePartners();
				ManagePartnerObject.getSearchManagePartners().clear();
				ManagePartnerObject.getSearchManagePartners().sendKeys(
						delete_Partner_Name);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();
				element = driver.findElement(By.xpath(ManagePartners_Objects
						.getPartnerName()));
				Utils.waitForElementToBeVisible(element);
				boolean varification = element.isDisplayed();
				if (varification) {
					System.out.println("partner is not removed ");
					Log.info(delete_Partner_Name + "User has not Deleted");
				} else {
					System.out.println("partner not removed");
				}

			}
			Thread.sleep(1000);
		}
	}

	public static void EditPartner(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (iSAdminPresent) {
			String partner_Name = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			ManagePartners_Objects.partner_name = partner_Name;
			ManagePartnerObject.getSearchManagePartners().clear();
			Actions action = new Actions(driver);
			ManagePartnerObject.getSearchManagePartners()
					.sendKeys(partner_Name);
			action.sendKeys(Keys.ENTER).perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
			driver.findElement(
					By.xpath(ManagePartners_Objects.getEditPartnerImg()))
					.click();
			String editPartner_Name = ExcelUtils.getCellData(1, 4, ExcelFile,
					ExcelSheetName);
			ManagePartnerObject.getCreatePartnerName().clear();
			ManagePartnerObject.getCreatePartnerName().sendKeys(
					editPartner_Name);
			ManagePartnerObject.getSaveManagePartners().click();
			driver.navigate().refresh();
			ClkManagePartners();
			// ManagePartnerObject.getManagePartnersSubModule().click();
			ManagePartnerObject.getSearchManagePartners().clear();
			ManagePartnerObject.getSearchManagePartners().sendKeys(
					editPartner_Name);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).perform();
			Log.info("PartnerName hasbeen Edited");
			ManagePartners_Objects.partner_name = editPartner_Name;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element = driver.findElement(By.xpath(ManagePartners_Objects
					.getPartnerName()));
			Utils.waitForElementToBeVisible(element);
			boolean varification = element.isDisplayed();
			if (varification) {
				System.out.println("partner is edited succesfully ");
			} else {
				System.out.println("Partner Not Edited");
			}

		}
	}
}
