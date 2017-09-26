package com.s3.businessLogic;

import java.util.ArrayList;
import java.util.List;
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

public class AddAppModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void addAppModuleLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		AddModuleObjects.getClkAddModule().click();
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		Log.info("Add Button Clicked");
		if (moduleName.equalsIgnoreCase("App Module")) {
			AddModule_Objects.moduleName = "App Module";
			boolean b = driver.findElement(
					By.xpath("//button[@data-dub_home_group_key='AppModule']"))
					.isEnabled();
			System.out.println(b);

			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(2000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("App Module Button Clicked");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				System.out.println("------Java Application is "+ ModuleReplaceIcon.JavaAppOpen);
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("App Module Image Replaced");
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
					System.out.println("App Module Is Visible");
				String appleAppName = ExcelUtils.getCellData(1, 10, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getAppleappName().sendKeys(appleAppName);
				String appleAppUrl = ExcelUtils.getCellData(1, 11, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getappUrl().sendKeys(appleAppUrl);
				String googleAppName = ExcelUtils.getCellData(1, 12, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getgooglePlayappName().sendKeys(googleAppName);
				String googleAppUrl = ExcelUtils.getCellData(1, 13, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getgooglePlayappUrl().sendKeys(googleAppUrl);
				String windowsAppId = ExcelUtils.getCellData(1, 14, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getwindowsStorepackageId().sendKeys(
						windowsAppId);
				String windowsAppName = ExcelUtils.getCellData(1, 15,
						ExcelFile, ExcelSheetName);
				AddModuleObjects.getwindowsStorepackageName().sendKeys(
						windowsAppName);
				String windowsAppUri = ExcelUtils.getCellData(1, 16, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getwindowsStoreuriSchema().sendKeys(
						windowsAppUri);
				String clkAdvanced = ExcelUtils.getCellData(1, 17, ExcelFile,
						ExcelSheetName);
				if (clkAdvanced.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkAdvanced().click();
					String clkMobileReady = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					if (clkMobileReady.equalsIgnoreCase("Yes"))
						AddModuleObjects.getClkMobileReady().click();
					else
						System.out.println("User Has Not Clicked:-"
								+ "Skip ClkMobileReady");
					String imageURL = ExcelUtils.getCellData(1, 19, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getClkImageUrl().sendKeys(imageURL);

				}
				String window8Settings = ExcelUtils.getCellData(1, 20,
						ExcelFile, ExcelSheetName);
				if (window8Settings.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 21,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 22,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 23,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 24,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 25, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				}
				Log.info("Data has Entered in App Module from Workbook");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Utils.waitForElToBeRemove(driver, By.xpath("//div[@id='popup']/div"));
//				Thread.sleep(3000);
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				AddModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();

			} else {
				System.out
						.println("User has already created App Module/Creating App Module Limit Is Over");
				Log.warn("User has already created App Module/Creating App Module Limit Is Over");
			}

		}
	}

	public static void PlistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("Plist Verification Starts for App Module");
		GetLivePlist.generateLiveAppPlist("AppModule");
		PlistParser.getInstance();
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		List<String> list = new ArrayList<String>();
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			String moduleKey = dict.getValue("moduleKey");
			String isVisible = dict.getValue("homeScreen");
			System.out.println("type : " + type);
			System.out.println("PrivateOrPublic  : " + privateOrPublic);
			System.out.println("moduleKey : " + moduleKey);
			System.out.println("Visible : " + isVisible);
			list.add(moduleKey);
		}
		int listsize = list.size() - 1;
		String newAppModule = list.get(listsize);
		Dictionary dictApp = PlistParser.getInstance().getModule(newAppModule);
		if (null == dictApp) {
			System.out.println("Web Module not present");
		}
		if (null != dictApp) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictApp);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {
				Dictionary isAppleStorePresent = specificVersion
						.getChild("appleStore");
				if (null != isAppleStorePresent) {
					String appName = specificVersion.getChild("appleStore")
							.getValue("appName");
					System.out.println("appName :" + appName);
					if (!U.isEmpty(appName)) {
						String appNameExl = ExcelUtils.getCellData(1, 10,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(appNameExl, appName,
									"appleStore appName workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}

					String appUrl = specificVersion.getChild("appleStore")
							.getValue("appUrl");
					System.out.println("appUrl :" + appUrl);
					if (!U.isEmpty(appUrl)) {
						String appUrlExl = ExcelUtils.getCellData(1, 11,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(appUrlExl, appUrl,
									"appleStore appUrl workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}
			if (null != specificVersion) {
				Dictionary isGooglePlay = specificVersion
						.getChild("googlePlay");
				if (null != isGooglePlay) {
					String appName = specificVersion.getChild("googlePlay")
							.getValue("appName");
					System.out.println("appName :" + appName);
					if (!U.isEmpty(appName)) {
						String appNameExl = ExcelUtils.getCellData(1, 12,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(appNameExl, appName,
									"googlePlay appName workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}

					String appUrl = specificVersion.getChild("googlePlay")
							.getValue("appUrl");
					System.out.println("appUrl :" + appUrl);
					if (!U.isEmpty(appUrl)) {
						String appUrlExl = ExcelUtils.getCellData(1, 13,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(appUrlExl, appUrl,
									"googlePlay appUrl workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}
			if (null != specificVersion) {
				Dictionary iswindowsStore = specificVersion
						.getChild("windowsStore");
				if (null != iswindowsStore) {
					String packageId = specificVersion.getChild("windowsStore")
							.getValue("packageId");
					System.out.println("packageId :" + packageId);
					if (!U.isEmpty(packageId)) {
						String packageIdExl = ExcelUtils.getCellData(1, 14,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(packageIdExl, packageId,
									"windowsStore packageId workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}

					String packageName = specificVersion.getChild(
							"windowsStore").getValue("packageName");
					System.out.println("packageName :" + packageName);
					if (!U.isEmpty(packageName)) {
						String packageNameExl = ExcelUtils.getCellData(1, 15,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(packageNameExl, packageName,
									"windowsStore packageName workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}

					String uriSchema = specificVersion.getChild("windowsStore")
							.getValue("uriSchema");
					System.out.println("uriSchema :" + uriSchema);
					if (!U.isEmpty(uriSchema)) {
						String uriSchemaExl = ExcelUtils.getCellData(1, 16,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(uriSchemaExl, uriSchema,
									"windowsStore uriSchema workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}

			if (null != specificVersion) {
				String mobileReady = specificVersion.getValue("mobileready");
				System.out.println("MobileReady :" + mobileReady);
				if (!U.isEmpty(mobileReady)) {
					String mobileReadyExl = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					if (mobileReadyExl.equalsIgnoreCase("Yes")) {
						mobileReadyExl = "true";
					} else {
						mobileReadyExl = "false";
					}
					try {
						Assert.assertEquals(mobileReadyExl, mobileReady,
								"MobileReady workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String imageurl = specificVersion.getValue("imageurl");
				System.out.println("imageurl :" + imageurl);
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
			if (null != specificVersion) {
				String pinnedtiletitlesquare = specificVersion
						.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :"
							+ pinnedtiletitlesquare);
					String pinnedtiletitlesquareExl = ExcelUtils.getCellData(1,
							21, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedtiletitlesquareExl,
								pinnedtiletitlesquare,
								"Pinnedtiletitlesquare Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinnedtiletitlerectangle = specificVersion
						.getValue("displayName");
				if (!U.isEmpty(pinnedtiletitlerectangle)) {
					System.out.println("Pinnedtiletitlerectangle :"
							+ pinnedtiletitlerectangle);
					String pinnedtiletitlerectangleExl = ExcelUtils
							.getCellData(1, 22, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedtiletitlerectangleExl,
								pinnedtiletitlerectangle,
								"Pinnedtiletitlerectangle Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlforsquaretileimage = specificVersion
						.getValue("smallLogoImageUrl");
				if (!U.isEmpty(urlforsquaretileimage)) {
					System.out.println("URLforsquaretileimage :"
							+ urlforsquaretileimage);
					String urlforsquaretileimageExl = ExcelUtils.getCellData(1,
							23, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforsquaretileimageExl,
								urlforsquaretileimage,
								"URLforsquaretileimage Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlforrectangletileimage = specificVersion
						.getValue("wideLogoImageUrl");
				if (!U.isEmpty(urlforrectangletileimage)) {
					System.out.println("URLforrectangletileimage : "
							+ urlforrectangletileimage);
					String urlforrectangletileimageExl = ExcelUtils
							.getCellData(1, 24, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforrectangletileimageExl,
								urlforrectangletileimage,
								"URLforrectangletileimage Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String secondaryTileAvailable = specificVersion
						.getValue("secondaryTileAvailable");
				if (!U.isEmpty(secondaryTileAvailable)) {
					System.out.println("secondaryTileAvailable :"
							+ secondaryTileAvailable);
					String secondaryTileAvailableExl = ExcelUtils.getCellData(
							1, 25, ExcelFile, ExcelSheetName);
					if (secondaryTileAvailableExl.equalsIgnoreCase("Yes")) {
						secondaryTileAvailableExl = "true";
					} else {
						secondaryTileAvailableExl = "false";
					}
					try {
						Assert.assertEquals(secondaryTileAvailableExl,
								secondaryTileAvailable,
								"secondaryTileAvailable Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
		}
		Log.info("Plist Verification Ends for App Module");
	}
}