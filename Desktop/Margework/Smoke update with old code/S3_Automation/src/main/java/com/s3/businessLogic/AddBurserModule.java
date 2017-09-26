package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddBurserModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;
	public static String NewAddedorOld;

	public static void addBurserModuleLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Thread.sleep(3000);
		Utils.waitForElementToBeClickable(element);
		Utils.waitForElementToBeclick(element);
		element.click();
		AddModuleObjects.getClkAddModule().click();
		Log.info("Add Button Clicked.");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("Bursar")) {
			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(
					By.xpath("//button[@value='" + moduleName + "Module']"))
					.isEnabled();
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Add Burser Module Button Clicked.");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen=true;
				Log.info(" Burser Module Image Replaced.");
				element = AddModuleObjects.getEditModule();
				Utils.waitForElementToBeVisible(element);
				element.clear();
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getEditModule().clear();
				AddModuleObjects.getEditModule().sendKeys(moduleNewName);
				String moduleNewCat = ExcelUtils.getCellData(1, 7, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getEditModuleCategory().clear();
				AddModuleObjects.getEditModuleCategory().sendKeys(moduleNewCat);
				String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile,
						ExcelSheetName);
				if (isPrivate.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkPrivate().click();
				} else
					System.out.println("User Has Not Clicked:-"
							+ "Private Button");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkIsVisible().click();
					System.out.println("User Has Clicked On:-"
							+ "Visible Button" + "Module Not Visible");
				} else
					System.out.println("Burser Module is visible");
				String bursarUrl = ExcelUtils.getCellData(1, 10, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getBursarUrl().sendKeys(bursarUrl);
				String paymentUrl = ExcelUtils.getCellData(1, 11, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getPaymentUrl().sendKeys(paymentUrl);
				String paymentOption = ExcelUtils.getCellData(1, 12, ExcelFile,
						ExcelSheetName);
				if (paymentOption.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkDisplayPaymentOption().click();
				} else
					System.out.println("display Payment option is clicked ");
				String email = ExcelUtils.getCellData(1, 13, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getClkContactFinalSupportEmail().sendKeys(
						email);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).perform();
				String subject = ExcelUtils.getCellData(1, 14, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getClkContactFinalSupportSubject().sendKeys(
						subject);
				String clickAdvance = ExcelUtils.getCellData(1, 15, ExcelFile,
						ExcelSheetName);
				if (clickAdvance.equalsIgnoreCase("Yes")) {
					action.sendKeys(Keys.PAGE_DOWN).perform();
					AddModuleObjects.getClkAdvanced().click();
					String isMobileReady = ExcelUtils.getCellData(1, 16,
							ExcelFile, ExcelSheetName);
					if (isMobileReady.equalsIgnoreCase("Yes"))
						AddModuleObjects.getClkMobileReady().click();
					else {
						System.out.println("User Has Not Clicked:-"
								+ " Mobile Ready");
					}
					String isMobileReadyNavigation = ExcelUtils.getCellData(1,
							17, ExcelFile, ExcelSheetName);
					if (isMobileReadyNavigation.equalsIgnoreCase("Yes"))
						AddModuleObjects.getClkMobileReadyNavigation().click();
					else {
						System.out.println("User Has Not Clicked:-"
								+ "Mobile Ready - Show Back/Forward Controls");
					}
					String isdisplayPaymentOption = ExcelUtils.getCellData(1,
							18, ExcelFile, ExcelSheetName);
					if (isdisplayPaymentOption.equalsIgnoreCase("Yes"))
						driver.findElement(
								By.xpath("//span[contains(text(),'Mobile Ready - Hide Native Header')]//following-sibling::span/label"))
								.click();
					else {
						System.out.println("User Has Not Clicked:-"
								+ "Mobile Ready - Hide Native Header");
					}
					String imageUrl = ExcelUtils.getCellData(1, 19, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getClkImageUrl().sendKeys(imageUrl);
					String isOpeninNativeBrowser = ExcelUtils.getCellData(1,
							20, ExcelFile, ExcelSheetName);
					if (isOpeninNativeBrowser.equalsIgnoreCase("Yes"))
						AddModuleObjects.getOpenInNativeBrowser().click();
					else {
						System.out.println("User Has Not Clicked:-"
								+ " Open in Native Browser");
					}
				} else {
					System.out.println("User Has Not Clicked:-" + " Advance");
				}
				Log.info("Data has filled in Burser Module Clicked.");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Utils.waitForElToBeRemove(driver,
						By.xpath("//div[@id='popup']/div"));
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
				
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();
				AddBurserModule.NewAddedorOld= "NewAdded";
			} else {
				System.out.println("User has already created Burser Module.");
				Log.warn("User has already created Burser Module.");
				//return "AlreadyAdded";
				AddBurserModule.NewAddedorOld= "AlreadyAdded";
			}
		}
	//	return "NewAdded";
	}

	public static void plistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("Burser module Plist Verification Starts");
		if(NewAddedorOld.equals("NewAdded"))
		GetLivePlist.generateLiveAppPlist("Bursar");
		else
		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile,
				ExcelSheetName);
		String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
				ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			String homeScreen = dict.getValue("homeScreen");
			if (type.equals("BursarRootVC")
					&& isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true",
							"PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("BursarRootVC")
					&& isPrivate.equalsIgnoreCase("No")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "false",
							"PrivateOrPublic does not match sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (isVisible.equalsIgnoreCase("No")) {
				System.out.println("Module is not visible");
			}
			System.out.println("type : " + dict.getValue("type"));
			System.out
					.println("PrivateOrPublic  : " + dict.getValue("private"));
			System.out.println("homeScreen visible :" + homeScreen);

		}

		Dictionary dictBurser = PlistParser.getInstance().getModule(
				"BursarModule");
		if (null == dictBurser) {
			System.out.println("Bursar Module not present");
		}
		if (null != dictBurser) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictBurser);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {

				String paymentUrl = specificVersion.getValue("paymentUrl");
				System.out.println("paymentUrl :" + paymentUrl);
				if (!U.isEmpty(paymentUrl)) {
					try {
						String paymentUrlExl = ExcelUtils.getCellData(1, 11,
								ExcelFile, ExcelSheetName);
						Assert.assertEquals(paymentUrlExl, paymentUrl,
								"PaymentUrl workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String bursarUrl = specificVersion.getValue("bursarUrl");
				System.out.println("bursarUrl :" + bursarUrl);
				if (!U.isEmpty(bursarUrl)) {
					try {
						String bursarUrlExl = ExcelUtils.getCellData(1, 10,
								ExcelFile, ExcelSheetName);
						Assert.assertEquals(bursarUrlExl, bursarUrl,
								"bursarUrl workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {

				String displayPaymentOption = specificVersion
						.getValue("displayPaymentOption");
				if (!U.isEmpty(displayPaymentOption)) {
					String paymentOption = ExcelUtils.getCellData(1, 12,
							ExcelFile, ExcelSheetName);
					System.out.println("displayPaymentOption :"
							+ displayPaymentOption);
					if (paymentOption.equalsIgnoreCase("Yes")) {
						paymentOption = "true";
					} else {
						paymentOption = "false";
					}
					try {
						Assert.assertEquals(paymentOption,
								displayPaymentOption,
								"isMobileReady workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}

				}
			}

			if (null != specificVersion) {
				String isMobileReady = specificVersion.getValue("mobileready");
				if (!U.isEmpty(isMobileReady)) {
					String isMobileReadyExl = ExcelUtils.getCellData(1, 16,
							ExcelFile, ExcelSheetName);
					if (isMobileReadyExl.equalsIgnoreCase("Yes")) {
						isMobileReadyExl = "true";
					} else {
						isMobileReadyExl = "false";
					}
					try {
						Assert.assertEquals(isMobileReadyExl, isMobileReady,
								"isMobileReady workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String isMobileReadyNavigation = specificVersion
						.getValue("mobileReadyNavigation");
				if (!U.isEmpty(isMobileReadyNavigation)) {
					String isMobileReadyNavigationExl = ExcelUtils.getCellData(
							1, 17, ExcelFile, ExcelSheetName);
					if (isMobileReadyNavigationExl.equalsIgnoreCase("Yes")) {
						isMobileReadyNavigationExl = "true";
					} else {
						isMobileReadyNavigationExl = "false";
					}
					try {
						Assert.assertEquals(isMobileReadyNavigationExl,
								isMobileReadyNavigation,
								"mobileReadyNavigation workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String isMobileReadyHeader = specificVersion
						.getValue("mobileReadyHeader");
				if (!U.isEmpty(isMobileReadyHeader)) {
					String isMobileReadyHeaderExl = ExcelUtils.getCellData(1,
							18, ExcelFile, ExcelSheetName);
					if (isMobileReadyHeaderExl.equalsIgnoreCase("Yes")) {
						isMobileReadyHeaderExl = "true";
					} else {
						isMobileReadyHeaderExl = "false";
					}
					try {
						Assert.assertEquals(isMobileReadyHeaderExl,
								isMobileReadyHeader,
								"MobileReadyHeader workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {
				String isopenInNativeBrowser = specificVersion
						.getValue("openInNativeBrowser");
				if (!U.isEmpty(isopenInNativeBrowser)) {
					String isopenInNativeBrowserExl = ExcelUtils.getCellData(1,
							20, ExcelFile, ExcelSheetName);
					if (isopenInNativeBrowserExl.equalsIgnoreCase("Yes")) {
						isopenInNativeBrowserExl = "true";
					} else {
						isopenInNativeBrowserExl = "false";
					}
					try {
						Assert.assertEquals(isopenInNativeBrowserExl,
								isopenInNativeBrowser,
								"openInNativeBrowser workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String imageurl = specificVersion.getValue("imageurl");
				if (!U.isEmpty(imageurl)) {
					String imageurlExl = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(imageurlExl, imageurl,
								"imageurl workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			Dictionary dictSupport = dictBurser.getChild("contactFinalSupport");
			if (null != dictSupport) {
				String dictSupportEmail = dictSupport.getValue("email");
				if (!U.isEmpty(dictSupportEmail)) {
					System.out
							.println("dictSupportEmail : " + dictSupportEmail);
					try {
						String email = ExcelUtils.getCellData(1, 13, ExcelFile,
								ExcelSheetName);
						Assert.assertEquals(email, dictSupportEmail,
								"dictSupportEmail Workbook Dqta Does Not match With pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != dictSupport) {
				String subject = dictSupport.getValue("subject");
				if (!U.isEmpty(subject)) {
					System.out.println("subject : " + subject);
					try {
						String subjectExl = ExcelUtils.getCellData(1, 14,
								ExcelFile, ExcelSheetName);
						Assert.assertEquals(subjectExl, subject,
								"dictSupportEmail Workbook Dqta Does Not match With pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

		}
		Log.info("Burser module Plist Verification Ends");
	}

}
