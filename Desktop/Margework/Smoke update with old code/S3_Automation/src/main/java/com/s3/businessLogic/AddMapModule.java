package com.s3.businessLogic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.businessLogic.VCardParser.Values;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddMapModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;

	public static void addMapModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		if (moduleName.equalsIgnoreCase("Maps")) {
			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(By.xpath("//button[@value='" + moduleName + "Module']")).isEnabled();
			System.out.println(b);
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Map Module Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Image Replaced Map Module");
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile, ExcelSheetName);
				AddModuleObjects.getEditModule().clear();
				AddModuleObjects.getEditModule().sendKeys(moduleNewName);
				String moduleNewCat = ExcelUtils.getCellData(1, 7, ExcelFile, ExcelSheetName);
				AddModuleObjects.getEditModuleCategory().clear();
				AddModuleObjects.getEditModuleCategory().sendKeys(moduleNewCat);
				String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
				if (isPrivate.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkPrivate().click();
				} else
					System.out.println("not private");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkIsVisible().click();
				} else
					System.out.println(" visible");
				String mapUrl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getMapUrl().sendKeys(mapUrl);
				String showImage = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				if (showImage.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkShowImage().click();
				} else
					System.out.println("show image is not clicked");
				String manageLocation = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
				if (manageLocation.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkManageLocation().click();
					String capmusId = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
					AddModuleObjects.getCampusId().sendKeys(capmusId);
					String capmusName = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
					AddModuleObjects.getCampusName().sendKeys(capmusName);
					String buildingId = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingId().sendKeys(buildingId);
					String buildingName = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingName().sendKeys(buildingName);
					String buildingCategory = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsCategory().sendKeys(buildingCategory);
					String buildingsDescription = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsDescription().sendKeys(buildingsDescription);
					String buildingsAddress = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsAddress().sendKeys(buildingsAddress);
					String buildingsCity = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsCity().sendKeys(buildingsCity);
					String buildingsState = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsState().sendKeys(buildingsState);
					String buildingsZip = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsZip().sendKeys(buildingsZip);
					String buildingsLatitude = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsLatitude().sendKeys(buildingsLatitude);
					WebElement element = AddModuleObjects.getBuildingsImageUrl();
					Coordinates cor = ((Locatable) element).getCoordinates();
					cor.inViewPort();
					String buildingsLongitude = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsLongitude().sendKeys(buildingsLongitude);
					String buildingsImageUrl = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
					AddModuleObjects.getBuildingsImageUrl().sendKeys(buildingsImageUrl);
					String saveBuildings = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
					if (saveBuildings.equalsIgnoreCase("Save")) {
						driver.findElement(By.xpath(AddModule_Objects.SaveBuilding())).click();
					}
					// String CreateNewCampus = ExcelUtils.getCellData(1, 26,
					// ExcelFile, ExcelSheetName);
					// if (CreateNewCampus.equalsIgnoreCase("Yes")){
					//
					// driver.findElement(By.xpath(AddModule_Objects.CreateNewCampus())).click();
					//
					// }
					String generateVCF = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
					if (generateVCF.equalsIgnoreCase("Yes")) {

						AddModuleObjects.getGenerateVCF().click();
						Thread.sleep(3000);
						if (Pattern.compile(Pattern.quote(Constant.BROWSER_NAME), Pattern.CASE_INSENSITIVE)	.matcher("Firefox").find());
						AddDiningHallModule.generateVCF();
						
						Thread.sleep(3000);
						AddModule_Objects.genXmlOrClose = "Close";
						driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
					} else {
						AddModule_Objects.genXmlOrClose = "Close";
						driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
					}
					// String Close = ExcelUtils.getCellData(1, 27, ExcelFile,
					// ExcelSheetName);
					// if(Close.equalsIgnoreCase("Yes")){
					//
					// AddModuleObjects.getClose().click();
					// }
					// else
					// System.out.println("user has not clicked on Manage
					// Location");
				}

				String clkWindowSet = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
				if (clkWindowSet.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlesquare().sendKeys(pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforsquaretileimage().sendKeys(urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforrectangletileimage().sendKeys(urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");
				} else
					System.out.println("User does not wants to enter data in window settings");
				Log.info("Workbook Data Entered in Map Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			//	Actions action = new Actions(driver);
			//	action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			}
		} else {
			System.out.println("Map module already created");
			Log.info("Map module already created");
		}

	}

	@SuppressWarnings("unused")
	public static void vcfParser() {
		Log.info("VCF Parser Starts");
		String home = System.getProperty("user.home");
		String OS=Utils.getOS();
		System.out.println(OS);
		if(OS.contains("mac")){
		home = home + "/Downloads/maps.vcf";
		}
		else 
		home = home + "\\Download\\maps.vcf";
		VCardParser.getInstance().sendGet(home);
		ArrayList<Values> campuses = VCardParser.getInstance().getCampuses();
		String name = VCardParser.getInstance().getCampusData(0, "N");
		String fName = VCardParser.getInstance().getCampusData(0, "FN");
		String address = VCardParser.getInstance().getCampusData(1, "ADR");
		String label = VCardParser.getInstance().getCampusData(1, "LABEL");
		String geo = VCardParser.getInstance().getCampusData(1, "GEO");
		String photo = VCardParser.getInstance().getCampusData(1, "PHOTO");
		String note = VCardParser.getInstance().getCampusData(1, "NOTE");
		String categories = VCardParser.getInstance().getCampusData(1, "CATEGORIES");
		String xDBLDGID = VCardParser.getInstance().getCampusData(1, "X-D-BLDG-ID");
		String xDBLDGLOC = VCardParser.getInstance().getCampusData(1, "X-D-BLDG-LOC");
		String role = VCardParser.getInstance().getCampusData(0, "ROLE");
		String xDLoc = VCardParser.getInstance().getCampusData(0, "X-D-LOC");

		System.out.println("name :" + name);
		System.out.println("fName :" + fName);
		System.out.println("XDLOC :" + xDLoc);
		System.out.println("role :" + role);
		System.out.println("address :" + address);
		System.out.println("label :" + label);
		System.out.println("geo :" + geo);
		System.out.println("photo :" + photo);
		System.out.println("note :" + note);
		System.out.println("categories :" + categories);
		System.out.println("xDBLDGID :" + xDBLDGID);
		System.out.println("xDBLDGLOC :" + xDBLDGLOC);
		Log.info("VCF Parser Ends");
	}

	public static void plistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Map Module Plist Parser Starts");
		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
		String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String privateOrPublic = dict.getValue("private");
			String homeScreen = dict.getValue("homeScreen");
			if (type.equals("MapsRootVC") && isPrivate.equalsIgnoreCase("Yes") && isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("MapsRootVC") && isPrivate.equalsIgnoreCase("No")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "false", "PrivateOrPublic does not match sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (isVisible.equalsIgnoreCase("No")) {
				System.out.println("Module is not visible");
			}
			System.out.println("type : " + dict.getValue("type"));
			System.out.println("PrivateOrPublic  : " + dict.getValue("private"));
			System.out.println("homeScreen :" + homeScreen);

		}
		Dictionary dictMap = PlistParser.getInstance().getModule("MapsModule");
		if (null == dictMap) {
			System.out.println("Maps Module not present");
		}
		if (null != dictMap) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictMap);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {
				String url = specificVersion.getValue("buildingsUrl");
				System.out.println("Url :" + url);
				if (!U.isEmpty(url)) {
					try {
						String urlExl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlExl, url,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String showImage = specificVersion.getValue("showImage");
				System.out.println("showImage :" + showImage);
				if (!U.isEmpty(showImage)) {
					String showImageExl = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
					if (showImageExl.equalsIgnoreCase("yes")) {
						try {
							Assert.assertEquals("true", showImage,
									"Module main Title workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					} else {
						try {
							Assert.assertEquals("false", showImage,
									"Module main Title workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}
			if (null != specificVersion) {
				String shortName = specificVersion.getValue("shortName");
				System.out.println("shortName :" + shortName);
				if (!U.isEmpty(shortName)) {
					try {
						String pinnedtiletitlesquare = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedtiletitlesquare, shortName,
								"Pinnedtiletitlesquare Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String displayName = specificVersion.getValue("displayName");
				System.out.println("displayName :" + displayName);
				if (!U.isEmpty(displayName)) {
					try {
						String pinnedtiletitlerectangle = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedtiletitlerectangle, displayName,
								"Pinnedtiletitlerectangle workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String smallLogoImageUrl = specificVersion.getValue("smallLogoImageUrl");
				System.out.println("URLforsquaretileimage :" + smallLogoImageUrl);
				if (!U.isEmpty(smallLogoImageUrl)) {
					try {
						String urlforsquaretileimage = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlforsquaretileimage, smallLogoImageUrl,
								"Pinnedtiletitlerectangle workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String wideLogoImageUrl = specificVersion.getValue("wideLogoImageUrl");
				System.out.println("wideLogoImageUrl :" + wideLogoImageUrl);
				if (!U.isEmpty(wideLogoImageUrl)) {
					try {
						String urlforsquaretileimage = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlforsquaretileimage, wideLogoImageUrl,
								"Pinnedtiletitlerectangle workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String secondaryTileAvailable = specificVersion.getValue("secondaryTileAvailable");
				System.out.println("secondaryTileAvailable :" + secondaryTileAvailable);
				if (!U.isEmpty(secondaryTileAvailable)) {
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes"))
						try {
							Assert.assertEquals("true", secondaryTileAvailable,
									"Pinnedtiletitlerectangle workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					else {
						try {
							Assert.assertEquals("false", secondaryTileAvailable,
									"Pinnedtiletitlerectangle workbook data does not match with pList data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}
			}
		}
		Log.info("Map Module Plist Parser Ends");
	}
}
