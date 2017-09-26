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
import com.s3.objectRepository.AddWebModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddWebModules extends Utils {
	private static WebElement element = null;
	static AddWebModule_Objects AddWebModuleObjects;
	
	public static void addWebModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		AddWebModuleObjects = PageFactory.initElements(driver, AddWebModule_Objects.class);
		element = AddWebModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		Thread.sleep(3000);
		element.click();
		AddWebModuleObjects.getClkAddModule().click();
		Log.info("Add Button Clicked");
		String ModuleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		if (ModuleName.equalsIgnoreCase("WebModule")) {
			AddWebModule_Objects.moduleName = "Web Module";
			boolean b = driver.findElement(By.xpath("//button[@data-dub_home_group_key ='WebModule']")).isDisplayed();
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddWebModule_Objects.getAddModuleName())).click();
				Log.info("Web Module Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Web Module Image Replaced");
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile, ExcelSheetName);
				AddWebModuleObjects.getEditModule().clear();
				AddWebModuleObjects.getEditModule().sendKeys(moduleNewName);
				String ModuleNewCat = ExcelUtils.getCellData(1, 7, ExcelFile, ExcelSheetName);
				AddWebModuleObjects.getEditModuleCategory().clear();
				AddWebModuleObjects.getEditModuleCategory().sendKeys(ModuleNewCat);
				String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
				if (isPrivate.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkPrivate().click();
				} else
					System.out.println("not private");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddWebModuleObjects.getClkIsVisible().click();
				} else
					System.out.println("visible");
				String urlAdmittedly = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddWebModuleObjects.getURLAdmittedly().clear();
				AddWebModuleObjects.getURLAdmittedly().sendKeys(urlAdmittedly);
				AddWebModuleObjects.getClkAdvanced().click();
				String mobileReady = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				if (mobileReady.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReady().click();
				} else
					System.out.println("Mobile ready is not clicked");
				String backForwardControls = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
				if (backForwardControls.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReadyNavigation().click();
				} else
					System.out.println("Mobile ready navigation is not clicked");
				String mobileReadyHeader = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
				if (mobileReadyHeader.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReadyHeader().click();
				} else
					System.out.println("MobileReadyHeader is not clicked");

				String imageURL = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
				AddWebModuleObjects.getClkImageUrl().sendKeys(imageURL);
				String nativeBrowser = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
				if (nativeBrowser.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getOpenInNativeBrowser().click();
				} else
					System.out.println("open in native browser is not clicked");
				String clickWindow8Set = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
				if (clickWindow8Set.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getPinnedtiletitlesquare().sendKeys(pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getPinnedtiletitlerectangle().sendKeys(pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getURLforsquaretileimage().sendKeys(urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getURLforrectangletileimage().sendKeys(urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddWebModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				} else
					System.out.println("window 8 not click");
				Log.info("Workbook Data Inserted in Web Module");
				AddWebModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddWebModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				element = AddWebModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddWebModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
				Thread.sleep(3000);
			} else {
				System.out.println("Web Module already created / Limit to create Web Module is over");
				Log.info("Web Module already created / Limit to create Web Module is over");
			}
		}

	}

	public static void pListVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Web Module Plist Parser Starts");
		GetLivePlist.generateLiveAppPlist("WebModule");
		PlistParser.getInstance();
		// String ModuleName=ExcelUtils.getCellData(1, 4, ExcelFile,
		// ExcelSheetName);
		// String Private=ExcelUtils.getCellData(1, 7, ExcelFile,
		// ExcelSheetName);
		// String Visible=ExcelUtils.getCellData(1, 8, ExcelFile,
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
		String newwebModule = list.get(listsize);
		Dictionary dictWeb = PlistParser.getInstance().getModule(newwebModule);
		if (null == dictWeb) {
			System.out.println("Web Module not present");
		}
		if (null != dictWeb) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictWeb);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}

			if (null != specificVersion) {
				String url = specificVersion.getChild("WebSpec").getValue("url");
				System.out.println("url :" + url);
				if (!U.isEmpty(url)) {
					try {
						String urlExl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlExl, url, "url workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {
				String mobileready = specificVersion.getChild("WebSpec").getValue("mobileready");
				System.out.println("mobileready :" + mobileready);
				if (!U.isEmpty(mobileready)) {
					try {
						String mobilereadyEXl = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
						if (mobilereadyEXl.equalsIgnoreCase("Yes")) {
							mobilereadyEXl = "true";
						} else {
							mobilereadyEXl = "false";
						}
						Assert.assertEquals(mobilereadyEXl, mobileready,
								"mobileready workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String showBackForwardControls = specificVersion.getChild("WebSpec").getValue("mobileReadyNavigation");
				System.out.println("showBackForwardControls :" + showBackForwardControls);
				if (!U.isEmpty(showBackForwardControls)) {
					try {
						String showBackForwardControlsExl = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
						if (showBackForwardControlsExl.equalsIgnoreCase("Yes")) {
							showBackForwardControlsExl = "true";
						} else {
							showBackForwardControlsExl = "false";
						}
						Assert.assertEquals(showBackForwardControlsExl, showBackForwardControls,
								"showBackForwardControls workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String hideNativeHeader = specificVersion.getChild("WebSpec").getValue("mobileReadyHeader");
				System.out.println("hideNativeHeader :" + hideNativeHeader);
				if (!U.isEmpty(hideNativeHeader)) {
					try {
						String hideNativeHeaderExl = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
						if (hideNativeHeaderExl.equalsIgnoreCase("Yes")) {
							hideNativeHeaderExl = "true";
						} else {
							hideNativeHeaderExl = "false";
						}
						Assert.assertEquals(hideNativeHeaderExl, hideNativeHeader,
								"hideNativeHeader workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String imageurl = specificVersion.getChild("WebSpec").getValue("imageurl");
				System.out.println("imageurl :" + imageurl);
				if (!U.isEmpty(imageurl)) {
					try {
						String imageurlExl = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
						Assert.assertEquals(imageurlExl, imageurl,
								"imageurl workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String openInNativeBrowser = specificVersion.getChild("WebSpec").getValue("openInNativeBrowser");
				System.out.println("openInNativeBrowser :" + openInNativeBrowser);
				if (!U.isEmpty(openInNativeBrowser)) {
					try {
						String openInNativeBrowserExl = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
						if (openInNativeBrowserExl.equalsIgnoreCase("Yes")) {
							openInNativeBrowserExl = "true";
						} else {
							openInNativeBrowserExl = "false";
						}
						Assert.assertEquals(openInNativeBrowserExl, openInNativeBrowser,
								"openInNativeBrowser workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			String pinnedtiletitlesquare = specificVersion.getChild("WebSpec").getValue("shortName");
			if (!U.isEmpty(pinnedtiletitlesquare)) {
				System.out.println("Pinnedtiletitlesquare :" + pinnedtiletitlesquare);
				String pinnedtiletitlesquareExl = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(pinnedtiletitlesquareExl, pinnedtiletitlesquare,
							"Pinnedtiletitlesquare Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String pinnedtiletitlerectangle = specificVersion.getChild("WebSpec").getValue("displayName");
			if (!U.isEmpty(pinnedtiletitlerectangle)) {
				System.out.println("Pinnedtiletitlerectangle :" + pinnedtiletitlerectangle);
				String pinnedtiletitlerectangleExl = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(pinnedtiletitlerectangleExl, pinnedtiletitlerectangle,
							"Pinnedtiletitlerectangle Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String urlForsquaretileimage = specificVersion.getChild("WebSpec").getValue("smallLogoImageUrl");
			if (!U.isEmpty(urlForsquaretileimage)) {
				System.out.println("URLforsquaretileimage :" + urlForsquaretileimage);
				String urlForsquaretileimageExl = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(urlForsquaretileimageExl, urlForsquaretileimage,
							"URLforsquaretileimage Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String urlForrectangletileimage = specificVersion.getChild("WebSpec").getValue("wideLogoImageUrl");
			if (!U.isEmpty(urlForrectangletileimage)) {
				System.out.println("URLforrectangletileimage : " + urlForrectangletileimage);
				String urlForrectangletileimageExl = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(urlForrectangletileimageExl, urlForrectangletileimage,
							"URLforrectangletileimage Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}

			}
			String secondaryTileAvailable = specificVersion.getChild("WebSpec").getValue("secondaryTileAvailable");
			if (!U.isEmpty(secondaryTileAvailable)) {
				System.out.println("secondaryTileAvailable :" + secondaryTileAvailable);
				String secondaryTileAvailableExl = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
				if (secondaryTileAvailableExl.equalsIgnoreCase("Yes")) {
					secondaryTileAvailableExl = "true";
				} else {
					secondaryTileAvailableExl = "false";
				}
				try {
					Assert.assertEquals(secondaryTileAvailableExl, secondaryTileAvailable,
							"secondaryTileAvailable Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}

		}
		Log.info("Web Module Plist Parser Ends");
	}

}
