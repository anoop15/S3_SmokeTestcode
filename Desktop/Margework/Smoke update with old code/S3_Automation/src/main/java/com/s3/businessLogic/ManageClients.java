package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.s3.objectRepository.Client_Object;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class ManageClients extends Utils {
	private static WebElement element = null;
	static Client_Object ClientObjects;
	static boolean ISAdminPresent;

	public static void ClkAdmin() {
		try {
			ClientObjects = PageFactory.initElements(driver,
					Client_Object.class);
			element = ClientObjects.getAdmin();
			ISAdminPresent = element.isDisplayed();
			if (ISAdminPresent) {
				element.click();
				Log.info("User Login With System Admin"
						+ "Admin Link is Present");
			} else {
				Log.info("User is not authorized for ADMIN operations"
						+ " User login with partner/client credentials");
				System.out
						.println("User is not authorized for ADMIN operations"
								+ " User login with partner/client credentials");
			}

		} catch (NoSuchElementException nse) {
			System.out.println(nse.getStackTrace());
		}
	}

	public static void CreateClient(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (ISAdminPresent) {
			ClientObjects = PageFactory.initElements(driver,
					Client_Object.class);
			Thread.sleep(4000);
			ClientObjects.getNewClient().click();
			Log.info("Client Has been Clicked");
			String NewClientName = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			ClientObjects.getClientName().sendKeys(NewClientName);
			String DisplayName = ExcelUtils.getCellData(1, 4, ExcelFile,
					ExcelSheetName);
			ClientObjects.getDisplayName().sendKeys(DisplayName);
			String PartnerName = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			Thread.sleep(2000);
			try {
				Select select = new Select(ClientObjects.getSelectPartner());
				select.selectByVisibleText(PartnerName);
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("PartnerName entered in Excel sheet not present in Dropdown");
			}
			String saveOrClose = ExcelUtils.getCellData(1, 7, ExcelFile,
					ExcelSheetName);

			if (saveOrClose.equalsIgnoreCase("Save")) {
				Client_Object.saveOrClose = "Save";
				driver.findElement(By.xpath(Client_Object.getSaveorClose()))
						.click();
				Log.info("Created Client Has been Saved");
			} else {
				Client_Object.saveOrClose = "Cancel";
				driver.findElement(By.xpath(Client_Object.getSaveorClose()))
						.click();
			}
		}
	}

	public static void VerifyClient(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (ISAdminPresent) {
			String newClientName = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			String displayName = ExcelUtils.getCellData(1, 4, ExcelFile,
					ExcelSheetName);
			String partnerName = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			try {
				Select select = new Select(driver.findElement(By
						.xpath(Client_Object.getSearchPartner())));
				select.selectByVisibleText(partnerName);
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("PartnerName entered in Excel sheet not present in Dropdown");
			}
			driver.findElement(By.xpath(Client_Object.getSearchClient()))
					.clear();
			Actions action = new Actions(driver);
			ClientObjects.getSearch().clear();
			driver.findElement(By.xpath(Client_Object.getSearchClient()))
					.sendKeys(newClientName);
			action.sendKeys(Keys.ENTER).perform();
			Client_Object.display_Name = displayName;
			Thread.sleep(2000);
			boolean variClient = driver.findElement(
					By.xpath(Client_Object.getVeriClientName())).isDisplayed();
			if (variClient) {
				String clientName = driver.findElement(
						By.xpath(Client_Object.getVeriClientName())).getText();
				System.out.println(clientName
						+ "client is succesfully varified ");
			} else
				System.out
						.println("client does not match/present in client list");
			Client_Object.partnerName = partnerName;
			Log.info("Client Has been Verifyed Succesfully");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			boolean variDisplayName = driver.findElement(
					By.xpath(Client_Object.getVeriDisplayName())).isDisplayed();
			if (variDisplayName) {
				String PreDisplayName = driver.findElement(
						By.xpath(Client_Object.getVeriDisplayName())).getText();
				System.out.println(PreDisplayName + "Display name is verified");
			} else
				System.out
						.println("Display name does not match/present in client list");
		}
	}

	public static void EditClient(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (ISAdminPresent) {
			String newClientName = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			String partnerName = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			String editDisplayName = ExcelUtils.getCellData(1, 6, ExcelFile,
					ExcelSheetName);
			try {
				Select select = new Select(driver.findElement(By
						.xpath(Client_Object.getSearchPartner())));
				select.selectByVisibleText(partnerName);
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("PartnerName entered in Excel sheet not present in Dropdown");
			}
			driver.findElement(By.xpath(Client_Object.getSearchClient()))
					.clear();
			Actions action = new Actions(driver);
			ClientObjects.getSearch().clear();
			ClientObjects.getSearch().sendKeys(newClientName);
			// driver.findElement(By.xpath(Client_Object.getSearchClient())).sendKeys(NewClientName);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			boolean variClient = driver.findElement(
					By.xpath(Client_Object.getVeriClientName())).isDisplayed();
			if (variClient == true) {
				System.out.println("client is succesfully varified ");
			} else
				System.out
						.println("client is not match/present in client list");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean variPartner = driver.findElement(
					By.xpath(Client_Object.getVeriDisplayName())).isDisplayed();
			if (variPartner == true) {
				System.out.println("partner name is verified");
			} else
				System.out
						.println("partner name is not match/present in client list");
			Thread.sleep(2000);
			boolean ClkEditClient = driver.findElement(
					By.xpath(Client_Object.getClientEditImg())).isDisplayed();
			if (ClkEditClient) {
				driver.findElement(By.xpath(Client_Object.getClientEditImg()))
						.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ClientObjects.getDisplayName().clear();
				ClientObjects.getDisplayName().sendKeys(editDisplayName);
				String saveOrClose = ExcelUtils.getCellData(1, 8, ExcelFile,
						ExcelSheetName);
				if (saveOrClose.equalsIgnoreCase("Save")) {
					Thread.sleep(2000);
					Client_Object.saveOrClose = "Save";
					driver.findElement(By.xpath(Client_Object.getSaveorClose()))
							.click();
					Log.info("Created Client Has been Saved");
				} else {
					Client_Object.saveOrClose = "Cancel";
					driver.findElement(By.xpath(Client_Object.getSaveorClose()))
							.click();
				}

			} else
				System.out.println("edit client is not clicked");
		}
	}

	public static void deleteClient(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		if (ISAdminPresent) {
			String newClientName = ExcelUtils.getCellData(1, 3, ExcelFile,
					ExcelSheetName);
			String partnerName = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			try {
				Select select = new Select(driver.findElement(By
						.xpath(Client_Object.getSearchPartner())));
				select.selectByVisibleText(partnerName);
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("PartnerName entered in Excel sheet not present in Dropdown");
			}
			driver.findElement(By.xpath(Client_Object.getSearchClient()))
					.clear();
			Actions action = new Actions(driver);
			ClientObjects.getSearch().clear();
			ClientObjects.getSearch().sendKeys(newClientName);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			boolean clkDeleteClient = driver.findElement(
					By.xpath(Client_Object.getClientDeleteImg())).isDisplayed();
			if (clkDeleteClient) {
				driver.findElement(By.xpath(Client_Object.getClientDeleteImg()))
						.click();
				String removeorCancel = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				if (removeorCancel.equalsIgnoreCase("Remove")) {
					Thread.sleep(2000);
					Client_Object.saveOrClose = "Remove";
					driver.findElement(By.xpath(Client_Object.getSaveorClose()))
							.click();
					Log.info("Created Client Has been Removed");
				} else {
					Client_Object.saveOrClose = "Cancel";
					driver.findElement(By.xpath(Client_Object.getSaveorClose()))
							.click();
				}

			} else {
				System.out.println("Delete button not clicked");
			}
			Thread.sleep(2000);
		}
	}
}
