package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

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
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddEmergencyModule extends Utils {
	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void addEmergencyModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked for Emergency Module");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);

		if (moduleName.equalsIgnoreCase("Emergency #") || moduleName.equalsIgnoreCase("Emergency")
				|| moduleName.equalsIgnoreCase("Emergency#")) {
			AddModule_Objects.moduleName = "Emergency #";
			boolean b = driver.findElement(By.xpath("//button[@value='ImportantNumbersModule']")).isEnabled();
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Emergency Module Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
			    Thread.sleep(1000);
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Emergency Module Image Replaced");
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
					System.out.println("not visible");
				String vCardUrl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getVCardUrl().clear();
				AddModuleObjects.getVCardUrl().sendKeys(vCardUrl);
				String manageNumber = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				if (manageNumber.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getManageNumbers().click();
					String name = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamName().sendKeys(name);
					String title = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamTitle().sendKeys(title);
					String address = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
					AddModuleObjects.getAddress().sendKeys(address);
					String addressType = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
					AddModuleObjects.getAddressType().sendKeys(addressType);
					String city = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
					AddModuleObjects.getCity().sendKeys(city);
					String state = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
					AddModuleObjects.getState().sendKeys(state);
					String zip = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
					AddModuleObjects.getZip().sendKeys(zip);
					String email = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamEmail().sendKeys(email);
					String emailType = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
					AddModuleObjects.getEmailType().sendKeys(emailType);
					String telephone = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamPhone().sendKeys(telephone);
					String telephoneType = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPhoneType().sendKeys(telephoneType);
					String pictureUrl = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamPictureUrl().sendKeys(pictureUrl);
					String campusName = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
					String buildingName = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
					try {
						Select campus = new Select(AddModuleObjects.getCampusName());
						campus.selectByVisibleText(campusName);
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
						System.out.println("TCEmergency" + "Please fill right campus name Or fill data in map module");
					}
					try {
						Select building = new Select(AddModuleObjects.getEmeBuildingName());
						building.selectByVisibleText(buildingName);
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
						System.out
								.println("TCEmergency" + "Please fill right building name Or fill data in map module");
					}
					String saveOrCancel = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
					if (saveOrCancel.equalsIgnoreCase("Save")) {
						AddModuleObjects.getSaveNumber().click();
						String generateVCF = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
						if (generateVCF.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getGenerateVCF().click();
							Thread.sleep(5000);
							if (Pattern.compile(Pattern.quote(Constant.BROWSER_NAME), Pattern.CASE_INSENSITIVE)
									.matcher("Firefox").find());
							AddDiningHallModule.generateVCF();
							// Runtime.getRuntime().exec(Constant.GENERATE_VCF);
							Thread.sleep(3000);
							AddModuleObjects.getCancel().click();
						} else {
							System.out.println("GenerateVCF not genrated");
							AddModuleObjects.getCancel().click();
						}
					} else {
						System.out.println("number not save");
						AddModuleObjects.getClear().click();
						AddModuleObjects.getCancel().click();
					}
				} else
					System.out.println("Manage number not clicked");
				String window8Settings = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
				if (window8Settings.equalsIgnoreCase("Yes")) {
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
					System.out.println("Window 8 settings not clicked");
				Log.info("Data has Entered in Emergency Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				Thread.sleep(3000);
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
				//Actions action = new Actions(driver);
				//action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			}

			else {
				System.out.println("Emergency Module already created");
				Log.info("Emergency Module already created");
			}

		}

	}

	public static void plistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Emergency Module Plist Verification Starts");
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
			if (type.equals("DirectoryRootVC") && isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("DirectoryRootVC") && isPrivate.equalsIgnoreCase("No")
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
			System.out.println("homeScreen visible:" + homeScreen);

		}
		Dictionary dictEmergency = PlistParser.getInstance().getModule("ImportantNumbersModule");
		if (null == dictEmergency) {
			System.out.println("Emergency Module not present");
		}
		if (null != dictEmergency) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictEmergency);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {

				String url = specificVersion.getValue("url");
				System.out.println("url :" + url);
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

				String shortName = specificVersion.getValue("shortName");
				System.out.println("PinnedTitleSquare :" + shortName);
				if (!U.isEmpty(shortName)) {
					try {
						String pinnedTitleSquare = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedTitleSquare, shortName,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String displayName = specificVersion.getValue("displayName");
				System.out.println("PinnedTitleRec :" + displayName);
				if (!U.isEmpty(displayName)) {
					try {
						String pinnedTitleRec = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedTitleRec, displayName,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {

				String smallLogoImageUrl = specificVersion.getValue("smallLogoImageUrl");
				System.out.println("smallLogoImageUrl :" + smallLogoImageUrl);
				if (!U.isEmpty(smallLogoImageUrl)) {
					try {
						String urlForSquImg = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlForSquImg, smallLogoImageUrl,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {

				String wideLogoImageUrl = specificVersion.getValue("wideLogoImageUrl");
				System.out.println("UrlForRecImg :" + wideLogoImageUrl);
				if (!U.isEmpty(wideLogoImageUrl)) {
					try {
						String urlForRecImg = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlForRecImg, wideLogoImageUrl,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

		}
		Log.info("Emergency Module Plist Verification Ends");
	}
}