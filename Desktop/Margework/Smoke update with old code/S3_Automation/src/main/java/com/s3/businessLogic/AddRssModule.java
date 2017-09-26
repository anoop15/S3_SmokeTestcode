package com.s3.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.objectRepository.AddRssModule_Object;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddRssModule extends Utils {

	private static WebElement element = null;
	static AddRssModule_Object AddRssModuleObjects;
	public static String NewAddedorOld;
	public static void addRssModuleLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddRssModuleObjects = PageFactory.initElements(driver,
				AddRssModule_Object.class);
		element = AddRssModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		AddRssModuleObjects.getClkAddModule().click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("RSS")) {
			boolean b = driver
					.findElement(
							By.xpath("//button[@data-dub_home_group_key='RSSFeedModule']"))
					.isEnabled();
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddRssModule_Object.ClkRss()))
						.click();
				Log.info("Rss Module Button Clicked");
				driver.findElement(
						By.xpath("//img[@id='module-icon']//following-sibling::div"))
						.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(3000);
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
					String isEnabled = ExcelUtils.getCellData(1, 14, ExcelFile,
							ExcelSheetName);
					if (isEnabled.equalsIgnoreCase("Yes")) {
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
				if (moduleName.equalsIgnoreCase("RSS")) {
					String collapseAll = ExcelUtils.getCellData(1, 17,
							ExcelFile, ExcelSheetName);
					if (collapseAll.equalsIgnoreCase("No")) {
						AddRssModuleObjects.getClkCollapseall().click();
					} else
						System.out.println("Collapse all in selected");
					String mobileReady = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					if (mobileReady.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkMobileReady().click();
					} else
						System.out.println("Mobile ready is not selected");
					String imageURL = ExcelUtils.getCellData(1, 19, ExcelFile,
							ExcelSheetName);
					AddRssModuleObjects.getImageUrl().sendKeys(imageURL);
					element = driver.findElement(By.id("imageurl"));
					Coordinates cor = ((Locatable) element).getCoordinates();
					cor.inViewPort();
				} else
					System.out.println("not an rss module");
				String sortType = ExcelUtils.getCellData(1, 20, ExcelFile,
						ExcelSheetName);
				try {
					Select select = new Select(
							AddRssModuleObjects.getSelSortType());
					select.selectByVisibleText(sortType);
				} catch (NoSuchElementException nse) {
					nse.getStackTrace();
					System.out
							.println("Please fill right data in excel sheet for SortType");
				}
				String clkDisRSSDetails = ExcelUtils.getCellData(1, 21,
						ExcelFile, ExcelSheetName);
				if (clkDisRSSDetails.equalsIgnoreCase("No")) {

					AddRssModuleObjects.getClkDisRSSDetails().click();
				} else
					System.out.println("ClkDisRSSDetails is selected");
				String histWinDays = ExcelUtils.getCellData(1, 22, ExcelFile,
						ExcelSheetName);
				AddRssModuleObjects.getrssWindowDays().clear();
				AddRssModuleObjects.getrssWindowDays().sendKeys(histWinDays);
				String clkWindows8Setting = ExcelUtils.getCellData(1, 23,
						ExcelFile, ExcelSheetName);
				if (clkWindows8Setting.equalsIgnoreCase("Yes")) {

					AddRssModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 24,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 25,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 26,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 27,
							ExcelFile, ExcelSheetName);
					AddRssModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 28, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddRssModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				} else
					System.out.println("windows 8 settings not clicked");
				Log.info("Data Entered in Rss Module");
				AddRssModule_Object.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddRssModule_Object
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(2000);
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
						.println("user has already created RSS module/Limit To Create Rss Modules is Over");
				Log.info("user has already created RSS module/Limit To Create Rss Modules is Over");
				NewAddedorOld= "AlreadyAdded";
			}
		}
	}

	public static void pListVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("Plist Parser Starts for RSS  module");
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
		List<String> list = new ArrayList<String>();
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			String moduleKey = dict.getValue("moduleKey");
			String visible = dict.getValue("homeScreen");
			System.out.println("type : " + type);
			System.out.println("PrivateOrPublic  : " + privateOrPublic);
			System.out.println("moduleKey : " + moduleKey);
			System.out.println("Visible : " + visible);
			list.add(moduleKey);

		}
		int listsize = list.size() - 1;
		String newrssModule = list.get(listsize);
		// System.out.println("newrssModule : "+newrssModule);
		Dictionary items = PlistParser.getInstance().getModule(newrssModule);
		if (null != items) {
			Dictionary[] addFeedItems = items.getChildArray("Items");
			for (Dictionary dict1 : addFeedItems) {
				if (null != addFeedItems) {
					String title = dict1.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("FeedTitle :" + title);
						String feedTitleExl = ExcelUtils.getCellData(1, 11,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(feedTitleExl, title,
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

			}
		}
		Dictionary dictNews = PlistParser.getInstance().getModule(newrssModule);
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
				String collapseall = specificVersion.getValue("collapseall");
				if (!U.isEmpty(collapseall)) {
					System.out.println("collapseall :" + collapseall);
					String collapseallExl = ExcelUtils.getCellData(1, 17,
							ExcelFile, ExcelSheetName);
					if (collapseallExl.equalsIgnoreCase("Yes")) {
						collapseallExl = "true";
					} else {
						collapseallExl = "false";
					}
					try {
						Assert.assertEquals(collapseallExl, collapseall,
								"collapseall Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String mobileready = specificVersion.getValue("mobileready");
				if (!U.isEmpty(collapseall)) {
					System.out.println("mobileready :" + mobileready);
					String mobilereadyExl = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					if (mobilereadyExl.equalsIgnoreCase("Yes")) {
						mobilereadyExl = "true";
					} else {
						mobilereadyExl = "false";
					}
					try {
						Assert.assertEquals(mobilereadyExl, mobileready,
								"mobileready Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				String imageurl = specificVersion.getValue("imageurl");
				if (!U.isEmpty(imageurl)) {
					System.out.println("imageurl :" + imageurl);
					String imageurlExl = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(imageurlExl, imageurl,
								"imageurl Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				String sortType = specificVersion.getValue("sortType");
				if (!U.isEmpty(sortType)) {
					System.out.println("SortType :" + sortType);
					String sortTypeExl = ExcelUtils.getCellData(1, 20,
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
							21, ExcelFile, ExcelSheetName);
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

				String pinnedtiletitlesquare = specificVersion
						.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :"
							+ pinnedtiletitlesquare);
					String pinnedtiletitlesquareExl = ExcelUtils.getCellData(1,
							24, ExcelFile, ExcelSheetName);
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
							.getCellData(1, 25, ExcelFile, ExcelSheetName);
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
							26, ExcelFile, ExcelSheetName);
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
							.getCellData(1, 27, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(urlforrectangletileimageExl,
								urlforrectangletileimage,
								"URLforrectangletileimage Workbook Data Does not match with pList Data");
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
							1, 28, ExcelFile, ExcelSheetName);
					if (secondaryTileAvailableExl.equalsIgnoreCase("Yes")) {
						secondaryTileAvailableExl = "true";
					} else {
						secondaryTileAvailableExl = "false";
					}
					try {
						Assert.assertEquals(secondaryTileAvailableExl,
								secondaryTileAvailable,
								"Pinthismoduletodevicehomescreen Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				int historicalWindow = Integer.parseInt((specificVersion
						.getValue("rssWindowDays")));
				System.out.println("HistoricalWindow: " + historicalWindow);
				if (0 != historicalWindow) {
					String historicalWindowExl = ExcelUtils.getCellData(1, 22,
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
		Log.info("Rss Plist Parser Ends");
	}
}
