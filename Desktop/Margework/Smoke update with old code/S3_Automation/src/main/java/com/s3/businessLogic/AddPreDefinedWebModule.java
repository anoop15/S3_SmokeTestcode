package com.s3.businessLogic;

import java.awt.Robot;
import java.awt.event.KeyEvent;

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

public class AddPreDefinedWebModule extends Utils {
	private static WebElement element = null;
	static AddWebModule_Objects AddWebModuleObjects;
	public static String NewAddedorOld;
	public static void addPredefinedWebModuleLogic(int row, int col,
			String ExcelFile, String ExcelSheetName) throws Exception {

		// element = AddWebModuleObjects.getClkAddModule();
		// Utils.waitForElementToBeClickable(element);
		// element.click();
		AddWebModuleObjects = PageFactory.initElements(driver,
				AddWebModule_Objects.class);
		Thread.sleep(5000);
		AddWebModuleObjects.getClkAddModule().click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);

		if (moduleName.equalsIgnoreCase("Admittedly")
				|| moduleName.equalsIgnoreCase("Banner Enrollment")
				|| moduleName.equalsIgnoreCase("Bill Pay")
				|| moduleName.equalsIgnoreCase("Bus Schedule")
				|| moduleName.equalsIgnoreCase("Campus Job")
				|| moduleName.equalsIgnoreCase("D2L")
				|| moduleName.equalsIgnoreCase("Facebook")
				|| moduleName.equalsIgnoreCase("Financial Aid")
				|| moduleName.equalsIgnoreCase("Holds")
				|| moduleName.equalsIgnoreCase("Library")
				|| moduleName.equalsIgnoreCase("Twitter")) {

			AddWebModule_Objects.moduleName = moduleName;
			boolean b = false;
			if (moduleName.equalsIgnoreCase("Admittedly")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule109']"))
						.isEnabled();			
			} else if (moduleName.equalsIgnoreCase("Banner Enrollment")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule108']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Bill Pay")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule105']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Bus Schedule")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule104']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Campus Job")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule111']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("D2L")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule110']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Facebook")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule101']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Financial Aid")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule106']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Holds")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule107']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Library")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule103']"))
						.isEnabled();
			} else if (moduleName.equalsIgnoreCase("Twitter")) {
				b = driver.findElement(
						By.xpath("//button[@value='WebModule102']"))
						.isEnabled();
			}
			if (b) {
				Thread.sleep(3000);
				driver.findElement(
						By.xpath(AddWebModule_Objects.getAddModuleName()))
						.click();
				Log.info(moduleName + " Module Button Clicked");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(1000);
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile,
						ExcelSheetName);
				AddWebModuleObjects.getEditModule().clear();
				AddWebModuleObjects.getEditModule().sendKeys(moduleNewName);
				String moduleNewCat = ExcelUtils.getCellData(1, 7, ExcelFile,
						ExcelSheetName);
				AddWebModuleObjects.getEditModuleCategory().clear();
				AddWebModuleObjects.getEditModuleCategory().sendKeys(
						moduleNewCat);
				String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile,
						ExcelSheetName);
				if (isPrivate.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkPrivate().click();
				} else
					System.out.println("not private");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddWebModuleObjects.getClkIsVisible().click();
				} else
					System.out.println("visible");
				String urlAdmittedly = ExcelUtils.getCellData(1, 10, ExcelFile,
						ExcelSheetName);
				AddWebModuleObjects.getURLAdmittedly().clear();
				AddWebModuleObjects.getURLAdmittedly().sendKeys(urlAdmittedly);
				AddWebModuleObjects.getClkAdvanced().click();
				String mobileReady = ExcelUtils.getCellData(1, 11, ExcelFile,
						ExcelSheetName);
				if (mobileReady.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReady().click();
				} else
					System.out.println("Mobile ready is not clicked");
				String backForwardControls = ExcelUtils.getCellData(1, 12,
						ExcelFile, ExcelSheetName);
				if (backForwardControls.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReadyNavigation().click();
				} else
					System.out
							.println("Mobile ready navigation is not clicked");
				String mobileReadyHeader = ExcelUtils.getCellData(1, 13,
						ExcelFile, ExcelSheetName);
				if (mobileReadyHeader.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkMobileReadyHeader().click();
				} else
					System.out.println("MobileReadyHeader is not clicked");

				String imageURL = ExcelUtils.getCellData(1, 15, ExcelFile,
						ExcelSheetName);
				AddWebModuleObjects.getClkImageUrl().sendKeys(imageURL);
				String nativeBrowser = ExcelUtils.getCellData(1, 16, ExcelFile,
						ExcelSheetName);
				if (nativeBrowser.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getOpenInNativeBrowser().click();
				} else
					System.out.println("open in native browser is not clicked");
				String clickWindow8Set = ExcelUtils.getCellData(1, 17,
						ExcelFile, ExcelSheetName);
				if (clickWindow8Set.equalsIgnoreCase("Yes")) {
					AddWebModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 18,
							ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getPinnedtiletitlesquare().sendKeys(
							pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 19,
							ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getPinnedtiletitlerectangle().sendKeys(
							pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 20,
							ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getURLforsquaretileimage().sendKeys(
							urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 21,
							ExcelFile, ExcelSheetName);
					AddWebModuleObjects.getURLforrectangletileimage().sendKeys(
							urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils
							.getCellData(1, 22, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddWebModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				} else
					System.out.println("window 8 not click");
				Log.info(moduleName + " Module Data has Entered");
				AddWebModule_Objects.saveOrDiscard = "Save";
				driver.findElement(
						By.xpath(AddWebModule_Objects.SaveOrDiscard())).click();
				Thread.sleep(3000);
				element = AddWebModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddWebModuleObjects.getClkPublishPopUp().click();
				Thread.sleep(2000);		
				String OS=Utils.getOS();
				if(OS.contains("win")){
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();
				}
				else if (OS.contains("mac")){
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_F);
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_F);
				}
				NewAddedorOld= "NewAdded";
				
			} else {
				System.out.println(moduleName + " Module Already Created");
				Log.info(moduleName + " Module Already Created");
				NewAddedorOld= "AlreadyAdded";
			}
		}

	}

	public static void pListVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("PList Verification Starts");
		if(NewAddedorOld.equals("NewAdded"))
			GetLivePlist.generateLiveAppPlist("Twitter");
			else
			GetLivePlist.generateLiveAppPlist();
		
		PlistParser.getInstance();
		String modulePlistName = null;
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("Admittedly")) {
			modulePlistName = "WebModule109";
		} else if (moduleName.equalsIgnoreCase("Banner Enrollment")) {
			modulePlistName = "WebModule108";
		} else if (moduleName.equalsIgnoreCase("Bill Pay")) {
			modulePlistName = "WebModule105";
		} else if (moduleName.equalsIgnoreCase("Bus Schedule")) {
			modulePlistName = "WebModule104";
		} else if (moduleName.equalsIgnoreCase("Campus Job")) {
			modulePlistName = "WebModule111";
		} else if (moduleName.equalsIgnoreCase("D2L")) {
			modulePlistName = "WebModule110";
		} else if (moduleName.equalsIgnoreCase("Facebook")) {
			modulePlistName = "WebModule101";
		} else if (moduleName.equalsIgnoreCase("Financial Aid")) {
			modulePlistName = "WebModule106";
		} else if (moduleName.equalsIgnoreCase("Holds")) {
			modulePlistName = "WebModule107";
		} else if (moduleName.equalsIgnoreCase("Library")) {
			modulePlistName = "WebModule103";
		} else if (moduleName.equalsIgnoreCase("Twitter")) {
			modulePlistName = "WebModule102";
		}
		String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile,
				ExcelSheetName);
		String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile,
				ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			if (type.equals(modulePlistName)
					&& isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true",
							"PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals(modulePlistName)
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

		}
		Dictionary dictPreDefinedWeb = PlistParser.getInstance().getModule(
				modulePlistName);
		if (null == dictPreDefinedWeb) {
			System.out.println("Web Module not present");
		}
		if (null != dictPreDefinedWeb) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictPreDefinedWeb);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}

			if (null != specificVersion) {
				String url = specificVersion.getChild("WebSpec")
						.getValue("url");
				System.out.println("url :" + url);
				if (!U.isEmpty(url)) {
					try {
						String urlExl = ExcelUtils.getCellData(1, 10,
								ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlExl, url,
								"url workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {
				String mobileready = specificVersion.getChild("WebSpec")
						.getValue("mobileready");
				System.out.println("mobileready :" + mobileready);
				if (!U.isEmpty(mobileready)) {
					try {
						String mobilereadyEXl = ExcelUtils.getCellData(1, 11,
								ExcelFile, ExcelSheetName);
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
				String showBackForwardControls = specificVersion.getChild(
						"WebSpec").getValue("mobileReadyNavigation");
				System.out.println("showBackForwardControls :"
						+ showBackForwardControls);
				if (!U.isEmpty(showBackForwardControls)) {
					try {
						String showBackForwardControlsExl = ExcelUtils
								.getCellData(1, 12, ExcelFile, ExcelSheetName);
						if (showBackForwardControlsExl.equalsIgnoreCase("Yes")) {
							showBackForwardControlsExl = "true";
						} else {
							showBackForwardControlsExl = "false";
						}
						Assert.assertEquals(showBackForwardControlsExl,
								showBackForwardControls,
								"showBackForwardControls workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String hideNativeHeader = specificVersion.getChild("WebSpec")
						.getValue("mobileReadyHeader");
				System.out.println("hideNativeHeader :" + hideNativeHeader);
				if (!U.isEmpty(hideNativeHeader)) {
					try {
						String hideNativeHeaderExl = ExcelUtils.getCellData(1,
								13, ExcelFile, ExcelSheetName);
						if (hideNativeHeaderExl.equalsIgnoreCase("Yes")) {
							hideNativeHeaderExl = "true";
						} else {
							hideNativeHeaderExl = "false";
						}
						Assert.assertEquals(hideNativeHeaderExl,
								hideNativeHeader,
								"hideNativeHeader workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String imageurl = specificVersion.getChild("WebSpec").getValue(
						"imageurl");
				System.out.println("imageurl :" + imageurl);
				if (!U.isEmpty(imageurl)) {
					try {
						String imageurlExl = ExcelUtils.getCellData(1, 15,
								ExcelFile, ExcelSheetName);
						Assert.assertEquals(imageurlExl, imageurl,
								"imageurl workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String openInNativeBrowser = specificVersion
						.getChild("WebSpec").getValue("openInNativeBrowser");
				System.out.println("openInNativeBrowser :"
						+ openInNativeBrowser);
				if (!U.isEmpty(openInNativeBrowser)) {
					try {
						String openInNativeBrowserExl = ExcelUtils.getCellData(
								1, 16, ExcelFile, ExcelSheetName);
						if (openInNativeBrowserExl.equalsIgnoreCase("Yes")) {
							openInNativeBrowserExl = "true";
						} else {
							openInNativeBrowserExl = "false";
						}
						Assert.assertEquals(openInNativeBrowserExl,
								openInNativeBrowser,
								"openInNativeBrowser workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			String Pinnedtiletitlesquare = specificVersion.getChild("WebSpec")
					.getValue("shortName");
			if (!U.isEmpty(Pinnedtiletitlesquare)) {
				System.out.println("Pinnedtiletitlesquare :"
						+ Pinnedtiletitlesquare);
				String PinnedtiletitlesquareExl = ExcelUtils.getCellData(1, 18,
						ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(PinnedtiletitlesquareExl,
							Pinnedtiletitlesquare,
							"Pinnedtiletitlesquare Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String pinnedtiletitlerectangle = specificVersion.getChild(
					"WebSpec").getValue("displayName");
			if (!U.isEmpty(pinnedtiletitlerectangle)) {
				System.out.println("Pinnedtiletitlerectangle :"
						+ pinnedtiletitlerectangle);
				String pinnedtiletitlerectangleExl = ExcelUtils.getCellData(1,
						19, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(pinnedtiletitlerectangleExl,
							pinnedtiletitlerectangle,
							"Pinnedtiletitlerectangle Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String urlforsquaretileimage = specificVersion.getChild("WebSpec")
					.getValue("smallLogoImageUrl");
			if (!U.isEmpty(urlforsquaretileimage)) {
				System.out.println("URLforsquaretileimage :"
						+ urlforsquaretileimage);
				String urlforsquaretileimageExl = ExcelUtils.getCellData(1, 20,
						ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(urlforsquaretileimageExl,
							urlforsquaretileimage,
							"URLforsquaretileimage Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			}
			String urlforrectangletileimage = specificVersion.getChild(
					"WebSpec").getValue("wideLogoImageUrl");
			if (!U.isEmpty(urlforrectangletileimage)) {
				System.out.println("URLforrectangletileimage : "
						+ urlforrectangletileimage);
				String URLforrectangletileimageExl = ExcelUtils.getCellData(1,
						21, ExcelFile, ExcelSheetName);
				try {
					Assert.assertEquals(URLforrectangletileimageExl,
							urlforrectangletileimage,
							"URLforrectangletileimage Workbook Data Does not match with pList Data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}

			}
			String secondaryTileAvailable = specificVersion.getChild("WebSpec")
					.getValue("secondaryTileAvailable");
			if (!U.isEmpty(secondaryTileAvailable)) {
				System.out.println("secondaryTileAvailable :"
						+ secondaryTileAvailable);
				String secondaryTileAvailableExl = ExcelUtils.getCellData(1,
						22, ExcelFile, ExcelSheetName);
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
		Log.info("Plist Verification Ends");
	}
}
