package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.objectRepository.AddRssModule_Object;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddNewsVideosSportsModule extends Utils {

	private static WebElement element = null;
	static AddRssModule_Object AddRssModuleObjects;
	public static String NewAddedorOld;
	public static void addNewsVideosSportsLogic(int row, int col,
			String ExcelFile, String ExcelSheetName) throws Exception {

		AddRssModuleObjects = PageFactory.initElements(driver,
				AddRssModule_Object.class);

		element = AddRssModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);

		if (moduleName.equalsIgnoreCase("News")
				|| moduleName.equalsIgnoreCase("Sports")
				|| moduleName.equalsIgnoreCase("Videos")) {

			AddModule_Objects.moduleName = moduleName;
			boolean b = false;
			if (moduleName.equalsIgnoreCase("News")) {
				b = driver.findElement(
						By.xpath("//button[@value='NewsModule']")).isEnabled();
			} else if (moduleName.equalsIgnoreCase("Sports")) {
				b = driver.findElement(
						By.xpath("//button[@value='SportsNewsModule']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Videos")) {
				b = driver.findElement(
						By.xpath("//button[@value='VideosNewsModule']"))
						.isEnabled();
			}
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("News/Videos/Sports Module Button Clicked");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(3000);
				Log.info("News/Videos/Sports Module Image Replaced");
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
				String clkAdvanced = ExcelUtils.getCellData(1, 16, ExcelFile,
						ExcelSheetName);
				if (clkAdvanced.equalsIgnoreCase("Yes")) {
					AddRssModuleObjects.getClkAdvanced().click();
				} else
					System.out.println("Clk Advanced not clicked");

				String sortType = ExcelUtils.getCellData(1, 17, ExcelFile,
						ExcelSheetName);
				try {
					Select select = new Select(
							AddRssModuleObjects.getSelSortType());
					select.selectByVisibleText(sortType);
				} catch (NoSuchElementException nse) {
					nse.getStackTrace();
					System.out
							.println("Please Enter Right Data in For Sort Type");
				}
				String clkDisRSSDetails = ExcelUtils.getCellData(1, 18,
						ExcelFile, ExcelSheetName);
				if (clkDisRSSDetails.equalsIgnoreCase("No")) {

					AddRssModuleObjects.getClkDisRSSDetails().click();
				} else
					System.out.println("ClkDisRSSDetails is selected");
				String histWinDays = ExcelUtils.getCellData(1, 19, ExcelFile,
						ExcelSheetName);
				AddRssModuleObjects.getrssWindowDays().clear();
				AddRssModuleObjects.getrssWindowDays().sendKeys(histWinDays);
				String clkWindows8Setting = ExcelUtils.getCellData(1, 20,
						ExcelFile, ExcelSheetName);
				if (clkWindows8Setting.equalsIgnoreCase("Yes")) {

					AddRssModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 21,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 22,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 23,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 24,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String clkNotiAvail = ExcelUtils.getCellData(1, 25,
							ExcelFile, ExcelSheetName);
					if (clkNotiAvail.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkNotiAvail().click();
					} else
						System.out.println("ClkNotiAvail is not selected");
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 26, ExcelFile, ExcelSheetName);
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
				Thread.sleep(5000);
				element = AddRssModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddRssModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();
				NewAddedorOld= "NewAdded";
			} else {
				System.out
						.println("user has already created module News/Videos/Sports");
				Log.info("user has already created module News/Videos/Sports");
				NewAddedorOld= "AlreadyAdded";
			}
		}

	}

	public static void plistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("PList Parser Starts For News/Videos/Sports");
		if(NewAddedorOld.equals("NewAdded"))
			GetLivePlist.generateLiveAppPlist("News/Video/Sports");
			else
			GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		Thread.sleep(500);
		String modulePlistName = null;
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("News")) {
			modulePlistName = "NewsModule";
		} else if (moduleName.equalsIgnoreCase("Sports")) {
			modulePlistName = "SportsNewsModule";
		} else if (moduleName.equalsIgnoreCase("Videos")) {
			modulePlistName = "VideosNewsModule";
		}
		// String Private=ExcelUtils.getCellData(1,7, ExcelFile,
		// ExcelSheetName);
		// String Visible=ExcelUtils.getCellData(1,8, ExcelFile,
		// ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			if (type.equals("NewsRootVC") || type.equals("SportsRootVC")
					|| type.equals("VideosRootVC")) {
				System.out.println("type : " + type);
				String privateOrPublic = dict.getValue("private");
				if (privateOrPublic.equals("true")
						|| privateOrPublic.equals("false")) {
					System.out.println("PrivateOrPublic  : " + privateOrPublic);
				} else {
					System.out.println("Please save and publish");
				}
				String isVisible = dict.getValue("homeScreen");
				if (isVisible.equals("true") || isVisible.equals("false")) {
					System.out.println("Visible :" + isVisible);
				} else {
					System.out.println("Please save and publish");
				}
			} else {

			}

		}
		Dictionary items = PlistParser.getInstance().getModule(modulePlistName);
		if (null != items) {
			Dictionary[] addFeedItems = items.getChildArray("Items");
			for (Dictionary dict1 : addFeedItems) {
				if (null != addFeedItems) {
					String Title = dict1.getValue("title");
					if (!U.isEmpty(Title)) {
						System.out.println("FeedTitle :" + Title);
						String feedTitleExl = ExcelUtils.getCellData(1, 11,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(feedTitleExl, Title,
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
		Dictionary dictNews = PlistParser.getInstance().getModule(
				modulePlistName);
		if (null == dictNews) {
			System.out.println("Web Module not present");
		}
		if (null != dictNews) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictNews);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {
				String sortType = specificVersion.getValue("sortType");
				if (!U.isEmpty(sortType)) {
					System.out.println("SortType :" + sortType);
					String sortTypeExl = ExcelUtils.getCellData(1, 17,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(sortTypeExl, sortType,
								"SortType Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String displayRSSDetailsPage = specificVersion
						.getValue("displayRSSDetailsPage");
				if (!U.isEmpty(displayRSSDetailsPage)) {
					System.out.println("displayRSSDetailsPage :"
							+ displayRSSDetailsPage);
					String displayRSSDetailsPageExl = ExcelUtils.getCellData(1,
							18, ExcelFile, ExcelSheetName);
					if (displayRSSDetailsPageExl.equalsIgnoreCase("Yes")) {
						displayRSSDetailsPageExl = "true";
					} else {
						displayRSSDetailsPageExl = "false";
					}
					try {
						Assert.assertEquals(displayRSSDetailsPageExl,
								displayRSSDetailsPage,
								"displayRSSDetailsPageExl Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String notificationAvailable = specificVersion
						.getValue("notificationAvailable");
				if (!U.isEmpty(notificationAvailable)) {
					System.out.println("notificationAvailable :"
							+ notificationAvailable);
					String notificationAvailableExl = ExcelUtils.getCellData(1,
							25, ExcelFile, ExcelSheetName);
					if (notificationAvailableExl.equalsIgnoreCase("Yes")) {
						notificationAvailableExl = "true";
					} else {
						notificationAvailableExl = "false";
					}
					try {
						Assert.assertEquals(notificationAvailableExl,
								notificationAvailable,
								"notificationAvailable Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String secondaryTileAvailable = specificVersion
						.getValue("secondaryTileAvailable");
				if (!U.isEmpty(secondaryTileAvailable)) {
					System.out.println("secondaryTileAvailable :"
							+ secondaryTileAvailable);
					String secondaryTileAvailableExl = ExcelUtils.getCellData(
							1, 26, ExcelFile, ExcelSheetName);
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
				String Pinnedtiletitlesquare = specificVersion
						.getValue("shortName");
				if (!U.isEmpty(Pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :"
							+ Pinnedtiletitlesquare);
					String PinnedtiletitlesquareExl = ExcelUtils.getCellData(1,
							21, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(PinnedtiletitlesquareExl,
								Pinnedtiletitlesquare,
								"Pinnedtiletitlesquare Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String Pinnedtiletitlerectangle = specificVersion
						.getValue("displayName");
				if (!U.isEmpty(Pinnedtiletitlerectangle)) {
					System.out.println("Pinnedtiletitlerectangle :"
							+ Pinnedtiletitlerectangle);
					String PinnedtiletitlerectangleExl = ExcelUtils
							.getCellData(1, 22, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(PinnedtiletitlerectangleExl,
								Pinnedtiletitlerectangle,
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
							23, ExcelFile, ExcelSheetName);
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
							.getCellData(1, 24, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforrectangletileimageExl,
								urlforrectangletileimage,
								"URLforrectangletileimage Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}

				}
				int historicalWindow = Integer.parseInt((specificVersion
						.getValue("rssWindowDays")));
				System.out.println("HistoricalWindow: " + historicalWindow);
				if (0 != historicalWindow) {
					String historicalWindowExl = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					int HistoricalDays = Integer.parseInt(historicalWindowExl);
					if (historicalWindow == HistoricalDays) {
						System.out
								.println("Historical windows Days  excel and Plist are same");
					} else {
						System.out
								.println("Historical windows Days excel and Plist are not same");
					}
				}

			}
		}
		Log.info("PList Parser Ends For News/Videos/Sports");
	}

}
