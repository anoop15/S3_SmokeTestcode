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

public class AddDirectoryModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void addDirectoryLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		// element = AddModuleObjects.getClkAddModule();
		// Utils.waitForElementToBeClickable(element);
		// element.click();
		Thread.sleep(4000);
		AddModuleObjects.getClkAddModule().click();
		Log.info("Add Button Clicked to Add Directory Module");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		System.out.println(moduleName);
		AddModule_Objects.moduleName = moduleName;
		if (moduleName.equalsIgnoreCase("Directory")) {
			boolean b = driver.findElement(
					By.xpath("//button[@value='DirectoryModule']")).isEnabled();
			System.out.println(b);
			if (b) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Add Directory Module Button Clicked");
				driver.findElement(
						By.xpath("//img[@id='module-icon']//following-sibling::div"))
						.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Directory Module Image Replaced");
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
					System.out.println("not private");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkIsVisible().click();
				} else
					System.out.println("visible");
				String directoryListURL = ExcelUtils.getCellData(1, 10,
						ExcelFile, ExcelSheetName);
				AddModuleObjects.getURLAdmittedly().sendKeys(directoryListURL);
				String showAvatar = ExcelUtils.getCellData(1, 11, ExcelFile,
						ExcelSheetName);
				if (showAvatar.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkShowAvatar().click();
				} else
					System.out.println("ShowAvatar is clicked ");
				String addScopingField = ExcelUtils.getCellData(1, 12,
						ExcelFile, ExcelSheetName);
				if (addScopingField.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkAddSearchField().click();
					String displayString = ExcelUtils.getCellData(1, 13,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getClkDisplayString().sendKeys(
							displayString);
					String key = ExcelUtils.getCellData(1, 14, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getkey().sendKeys(key);
					String saveOrCancel = ExcelUtils.getCellData(1, 15,
							ExcelFile, ExcelSheetName);
					if (saveOrCancel.equalsIgnoreCase("Save")) {
						AddModule_Objects.saveOrCancel = "Save";
						driver.findElement(
								By.xpath(AddModule_Objects.SaveOrCancel()))
								.click();
					} else {
						AddModule_Objects.saveOrCancel = "Cancel";
						driver.findElement(
								By.xpath(AddModule_Objects.SaveOrCancel()))
								.click();
					}
				} else {
					System.out.println("Add Scoping Field not clicked");
				}
				String windowsSettings = ExcelUtils.getCellData(1, 16,
						ExcelFile, ExcelSheetName);
				if (windowsSettings.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 17,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 20,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 21, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
					AddModule_Objects.saveOrDiscard = "Save";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrDiscard()))
							.click();
					Thread.sleep(2000);
					element = AddModuleObjects.getClkPublish();
					Utils.waitForElementToBeClickable(element);
					element.click();
					AddModuleObjects.getClkPublishPopUp().click();
					Actions action = new Actions(driver);
					action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
							Keys.PAGE_UP).perform();

				} else {
					System.out.println("Windows Setting s not clicked");

				}
			}

		} else {
			System.out.println("Directory Module Already Created");
			Log.info("Directory Module Already Created");
		}

	}

	public static void PlistVerifiaction(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("Directory Module Plist Verification Starts");
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
			if (type.equals("DatatelDirectoryRootVC")
					&& isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true",
							"PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("DatatelDirectoryRootVC")
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
			System.out.println("Home Screen Visible :" + homeScreen);

		}
		Dictionary dictDirectory = PlistParser.getInstance().getModule(
				"DirectoryModule");
		if (null == dictDirectory) {
			System.out.println("Directory Module not present");
		}
		if (null != dictDirectory) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictDirectory);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {

				String url = specificVersion.getValue("url");
				System.out.println("url :" + url);
				if (!U.isEmpty(url)) {
					String urlExl = ExcelUtils.getCellData(1, 10, ExcelFile,
							ExcelSheetName);
					try {
						Assert.assertEquals(urlExl, url,
								"url workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {

				String showAvatar = specificVersion.getValue("showAvatar");
				System.out.println("showAvatar :" + showAvatar);
				if (!U.isEmpty(showAvatar)) {
					String showAvatarExl = ExcelUtils.getCellData(1, 11,
							ExcelFile, ExcelSheetName);
					if (showAvatarExl.equalsIgnoreCase("Yes")) {
						showAvatarExl = "true";
					} else {
						showAvatarExl = "false";
					}
					try {
						Assert.assertEquals(showAvatarExl, showAvatar,
								"showAvatar workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			Dictionary scopingFields = PlistParser.getInstance().getModule(
					"DirectoryModule");
			Dictionary[] scopingFieldsItems = scopingFields
					.getChildArray("scopingFields");
			for (Dictionary dict1 : scopingFieldsItems) {
				if (null != scopingFieldsItems) {
					String displayString = dict1.getValue("displayString");
					if (!U.isEmpty(displayString)) {
						System.out.println("displayString :" + displayString);
						String displayStringExl = ExcelUtils.getCellData(1, 13,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(displayStringExl,
									displayString,
									"displayString Workbook Data Does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
				if (null != scopingFieldsItems) {
					String key = dict1.getValue("key");
					if (!U.isEmpty(key)) {
						System.out.println("key :" + key);
						String keyExl = ExcelUtils.getCellData(1, 14,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(keyExl, key,
									"key Workbook Data Does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}
			if (null != specificVersion) {
				String pinnedtiletitlesquare = specificVersion
						.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :"
							+ pinnedtiletitlesquare);
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 17,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedTitleSquare,
								pinnedtiletitlesquare,
								"Pinnedtiletitlesquare Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinnedTileTitleRectangle = specificVersion
						.getValue("displayName");
				if (!U.isEmpty(pinnedTileTitleRectangle)) {
					String pinnedTitleRectangle = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					System.out.println("PinnedTileTitleRectangle :"
							+ pinnedTileTitleRectangle);
					try {
						Assert.assertEquals(pinnedTitleRectangle,
								pinnedTileTitleRectangle,
								"PinnedTitleSquare Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlForSquareTileImage = specificVersion
						.getValue("smallLogoImageUrl");
				if (!U.isEmpty(urlForSquareTileImage)) {
					String pinnedTitleImage = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					System.out.println("URLForSquareTileImage :"
							+ urlForSquareTileImage);
					try {
						Assert.assertEquals(pinnedTitleImage,
								urlForSquareTileImage,
								"PinnedTitleImage Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlForRectangleTileImage = specificVersion
						.getValue("wideLogoImageUrl");
				if (!U.isEmpty(urlForRectangleTileImage)) {
					String urlRectangleTileImage = ExcelUtils.getCellData(1,
							20, ExcelFile, ExcelSheetName);
					System.out.println("URLForRectangleTileImage :"
							+ urlForRectangleTileImage);
					try {
						Assert.assertEquals(urlRectangleTileImage,
								urlForRectangleTileImage,
								"UrlRectangleTileImage Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinThisModuleToDeviceHomeScreen = specificVersion
						.getValue("secondaryTileAvailable");
				if (!U.isEmpty(pinThisModuleToDeviceHomeScreen)) {
					String pinThisToDeviceHomeScreen = ExcelUtils.getCellData(
							1, 21, ExcelFile, ExcelSheetName);
					System.out.println("PinThisModuleToDeviceHomeScreen :"
							+ pinThisModuleToDeviceHomeScreen);
					if (pinThisToDeviceHomeScreen.equalsIgnoreCase("Yes")) {
						try {
							Assert.assertEquals(
									pinThisModuleToDeviceHomeScreen, "true",
									"PinThisToDeviceHomeScreen  Workbook data does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					} else {
						try {
							Assert.assertEquals(
									pinThisModuleToDeviceHomeScreen, "false",
									"PinThisToDeviceHomeScreen  Workbook data does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}

			}
		}
		Log.info("Directory Module Plist Verification Ends");
	}
}
