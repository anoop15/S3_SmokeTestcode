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
import com.s3.objectRepository.AddRssModule_Object;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddEventsModule extends Utils {

	private static WebElement element = null;
	static AddRssModule_Object AddRssModuleObjects;
	public static String NewAddedorOld;
	public static void addEventsNoduleLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		AddRssModuleObjects = PageFactory.initElements(driver,
				AddRssModule_Object.class);
		element = AddRssModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked For Events Module");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);

		if (moduleName.equalsIgnoreCase("Events")) {

			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(
					By.xpath("//button[@value='EventsModule']")).isEnabled();
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Events Module Butoon Clicked");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Image Replaced For Events Module");
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile,
						ExcelSheetName);
				AddRssModuleObjects.getEditModule().clear();
				AddRssModuleObjects.getEditModule().sendKeys(moduleNewName);
				String moduleNewCat = ExcelUtils.getCellData(1, 7, ExcelFile,
						ExcelSheetName);
				AddRssModuleObjects.getEditModuleCategory().clear();
				AddRssModuleObjects.getEditModuleCategory().sendKeys(
						moduleNewCat);
				String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile,
						ExcelSheetName);
				if (isPrivate.equalsIgnoreCase("Yes")) {
					AddRssModuleObjects.getClkPrivate().click();
				} else
					System.out.println("not private");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddRssModuleObjects.getClkIsVisible().click();
				} else
					System.out.println("visible");
				String addFeed = ExcelUtils.getCellData(1, 10, ExcelFile,
						ExcelSheetName);
				if (addFeed.equalsIgnoreCase("Yes")) {
					AddRssModuleObjects.getClkAddFeed().click();
					String feedTitle = ExcelUtils.getCellData(1, 11, ExcelFile,
							ExcelSheetName);
					AddRssModuleObjects.getClkFeedTitle().sendKeys(feedTitle);
					String atomUrl = ExcelUtils.getCellData(1, 12, ExcelFile,
							ExcelSheetName);
					AddRssModuleObjects.getClkATOMUrl().sendKeys(atomUrl);
					String loginReq = ExcelUtils.getCellData(1, 13, ExcelFile,
							ExcelSheetName);
					if (loginReq.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkLoginReq().click();
					} else
						System.out.println("Login req not clicked");
					String enabled = ExcelUtils.getCellData(1, 14, ExcelFile,
							ExcelSheetName);
					if (enabled.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkEnabled().click();
					} else
						System.out.println("Enabled is not clicked");
					String saveOrCancel = ExcelUtils.getCellData(1, 15,
							ExcelFile, ExcelSheetName);
					if (saveOrCancel.equalsIgnoreCase("Save")) {
						AddRssModule_Object.saveOrCancel = "Save";
						driver.findElement(
								By.xpath(AddRssModule_Object.SaveOrCancel()))
								.click();
					} else {
						AddRssModule_Object.saveOrCancel = "Cancel";
						driver.findElement(
								By.xpath(AddRssModule_Object.SaveOrCancel()))
								.click();
					}
				} else
					System.out.println("Add Feed Not Ckicked");
				AddRssModuleObjects.getClkAdvanced().click();
				String histWinDays = ExcelUtils.getCellData(1, 16, ExcelFile,
						ExcelSheetName);
				AddRssModuleObjects.geteventsWindowDays().clear();
				AddRssModuleObjects.geteventsWindowDays().sendKeys(histWinDays);
				String clkWindows8Setting = ExcelUtils.getCellData(1, 17,
						ExcelFile, ExcelSheetName);
				if (clkWindows8Setting.equalsIgnoreCase("Yes")) {

					AddRssModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 20,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 21,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 22, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				} else
					System.out.println("windows 8 settings not clicked");
				AddRssModule_Object.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddRssModule_Object
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddRssModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddRssModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();
				NewAddedorOld= "NewAdded";
			} else
				System.out.println("user has already created Events module");
			Log.info("user has already created Events module");
			NewAddedorOld= "AlreadyAdded";
		}

	}

	public static void plistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("Plist Verifivation Starts for Events module");
		if(NewAddedorOld.equals("NewAdded"))
			GetLivePlist.generateLiveAppPlist("RSS");
		else
			GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();

		// String Private=ExcelUtils.getCellData(1,7, ExcelFile,
		// ExcelSheetName);
		// String Visible=ExcelUtils.getCellData(1,8, ExcelFile,
		// ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			String moduleKey = dict.getValue("moduleKey");
			String isVisible = dict.getValue("homeScreen");
			System.out.println("type : " + type);
			System.out.println("PrivateOrPublic  : " + privateOrPublic);
			System.out.println("moduleKey : " + moduleKey);
			System.out.println("Visible : " + isVisible);

		}
		Dictionary items = PlistParser.getInstance().getModule("EventsModule");
		if (null != items) {
			Dictionary[] addFeedItems = items.getChildArray("Items");
			if (null != addFeedItems) {
				for (Dictionary dict1 : addFeedItems) {
					if (null != addFeedItems) {
						String title = dict1.getValue("title");
						if (!U.isEmpty(title)) {
							System.out.println("FeedTitle :" + title);
							String FeedTitleExl = ExcelUtils.getCellData(1, 11,
									ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(FeedTitleExl, title,
										"Feed Title Workbook Data Does not match with pList Data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}
					if (null != addFeedItems) {
						String rssUrl = dict1.getValue("url");
						if (!U.isEmpty(rssUrl)) {
							System.out.println("RssUrl :" + rssUrl);
							String rssUrlExl = ExcelUtils.getCellData(1, 12,
									ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(rssUrlExl, rssUrl,
										"RssUrl Workbook Data Does not match with pList Data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}
					if (null != addFeedItems) {
						String loginRequired = dict1.getValue("private");
						System.out.println("LoginRequired : " + loginRequired);
					}
					if (null != addFeedItems) {
						String isEnabled = dict1.getValue("visible");
						System.out.println("Enabled : " + isEnabled);
					}

				}
			}
		}
		Dictionary dictEvent = PlistParser.getInstance().getModule(
				"EventsModule");
		if (null == dictEvent) {
			System.out.println("Web Module not present");
		}
		if (null != dictEvent) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictEvent);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {

				String secondaryTileAvailable = specificVersion
						.getValue("secondaryTileAvailable");
				if (!U.isEmpty(secondaryTileAvailable)) {
					System.out.println("secondaryTileAvailable :"
							+ secondaryTileAvailable);
					String secondaryTileAvailableExl = ExcelUtils.getCellData(
							1, 22, ExcelFile, ExcelSheetName);
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
				String pinnedtiletitlesquare = specificVersion
						.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :"
							+ pinnedtiletitlesquare);
					String pinnedtiletitlesquareExl = ExcelUtils.getCellData(1,
							18, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedtiletitlesquareExl,
								pinnedtiletitlesquare,
								"Pinnedtiletitlesquare Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String pinnedtiletitlerectangle = specificVersion
						.getValue("displayName");
				if (!U.isEmpty(pinnedtiletitlerectangle)) {
					System.out.println("Pinnedtiletitlerectangle :"
							+ pinnedtiletitlerectangle);
					String pinnedtiletitlerectangleExl = ExcelUtils
							.getCellData(1, 19, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedtiletitlerectangleExl,
								pinnedtiletitlerectangle,
								"Pinnedtiletitlerectangle Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String urlforsquaretileimage = specificVersion
						.getValue("smallLogoImageUrl");
				if (!U.isEmpty(urlforsquaretileimage)) {
					System.out.println("URLforsquaretileimage :"
							+ urlforsquaretileimage);
					String urlforsquaretileimageExl = ExcelUtils.getCellData(1,
							20, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforsquaretileimageExl,
								urlforsquaretileimage,
								"URLforsquaretileimage Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String urlforrectangletileimage = specificVersion
						.getValue("wideLogoImageUrl");
				if (!U.isEmpty(urlforrectangletileimage)) {
					System.out.println("URLforrectangletileimage : "
							+ urlforrectangletileimage);
					String urlforrectangletileimageExl = ExcelUtils
							.getCellData(1, 21, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforrectangletileimageExl,
								urlforrectangletileimage,
								"URLforrectangletileimage Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}

				}
				int historicalWindow = Integer.parseInt((specificVersion
						.getValue("eventsWindowDays")));
				System.out.println("HistoricalWindow: " + historicalWindow);
				if (0 != historicalWindow) {
					String HistoricalWindowExl = ExcelUtils.getCellData(1, 16,
							ExcelFile, ExcelSheetName);
					int historicalDays = Integer.parseInt(HistoricalWindowExl);
					if (historicalWindow == historicalDays) {
						System.out
								.println("Historical windows Days  excel and Plist are same");
					} else {
						System.out
								.println("Historical windows Days excel and Plist are not same");
					}
				}

			}
		}
		Log.info("Plist Verifivation Ends for Events module");
	}

}
