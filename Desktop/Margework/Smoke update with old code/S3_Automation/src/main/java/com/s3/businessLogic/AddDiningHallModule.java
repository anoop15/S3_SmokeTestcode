package com.s3.businessLogic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
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
import com.s3.businessLogic.VCardParser.Values;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddDiningHallModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void addDiningHallModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {

		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Thread.sleep(2000);
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		if (moduleName.equalsIgnoreCase("Dining Hall")) {
			AddModule_Objects.moduleName = "Dining Hall";
			boolean b = driver.findElement(By.xpath("//button[@value='DiningHallModule']")).isEnabled();
			Log.info("Dinning Hall Button Clicked");
			System.out.println(b);
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div")).click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Dinning Hall Image Replaced");
				element = AddModuleObjects.getEditModule();
				Utils.waitForElementToBeClickable(element);
				element.clear();
				String moduleNewName = ExcelUtils.getCellData(1, 6, ExcelFile, ExcelSheetName);
				// AddModuleObjects.getEditModule().clear();
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
					System.out.println("visible");
				String vCardUrl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getvCardUrl().clear();
				AddModuleObjects.getvCardUrl().sendKeys(vCardUrl);
				String menuDays = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				AddModuleObjects.getMenuDays().clear();
				AddModuleObjects.getMenuDays().sendKeys(menuDays);
				String manageDiningHall = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
				if (manageDiningHall.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkManageDinningHall().click();
					boolean popUp;
					try {
						popUp = driver
								.findElement(By
										.xpath("//div[@class='popupBars popupFooter dialogFooter']//button[text()='Close']"))
								.isDisplayed();
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
						popUp = false;
					}
					if (popUp) {
						driver.findElement(
								By.xpath("//div[@class='popupBars popupFooter dialogFooter']//button[text()='Close']"))
								.click();
						AddModule_Objects.genXmlOrClose = "Close";
						driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
					} else if (!popUp) {
						String name = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
						AddModuleObjects.getManageAdmTeamName().sendKeys(name);
						String Address = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
						AddModuleObjects.getAddress().sendKeys(Address);
						String state = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
						AddModuleObjects.getState().sendKeys(state);
						String city = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
						AddModuleObjects.getCity().sendKeys(city);
						String zip = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
						AddModuleObjects.getZip().sendKeys(zip);
						String email = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
						AddModuleObjects.getManageAdmTeamEmail().sendKeys(email);
						String telephone = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
						AddModuleObjects.getManageAdmTeamPhone().sendKeys(telephone);
						String mainUrl = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
						AddModuleObjects.getMainUrl().sendKeys(mainUrl);
						String addDateUrl = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
						if (addDateUrl.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getAddDateUrl().click();
						} else
							System.out.println("AddDateUrl not click");
						String note = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
						AddModuleObjects.getNote().sendKeys(note);
						try {
							String campusName = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
							Select selCampusName = new Select(AddModuleObjects.getCampusName());
							selCampusName.selectByVisibleText(campusName);
							String buildName = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
							Select selBuildName = new Select(AddModuleObjects.getEmeBuildingName());
							selBuildName.selectByVisibleText(buildName);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println(
									"Please Fill the Campus details in Map Module/Campus Name entered is not correct");
						}
						String breakFastUrl = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
						AddModuleObjects.getBreakFastUrl().sendKeys(breakFastUrl);
						String breakfastLabel = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
						AddModuleObjects.getBreakfastLabel().sendKeys(breakfastLabel);
						String breakfastSummary = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
						AddModuleObjects.getBreakfastSummary().sendKeys(breakfastSummary);
						String lunchUrl = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
						AddModuleObjects.getLunchUrl().sendKeys(lunchUrl);
						String lunchLabel = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
						AddModuleObjects.getLunchLabel().sendKeys(lunchLabel);
						String lunchSummary = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
						AddModuleObjects.getLunchSummary().sendKeys(lunchSummary);
						String dinnerUrl = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
						AddModuleObjects.getDinnerUrl().sendKeys(dinnerUrl);
						String dinnerLabel = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
						AddModuleObjects.getDinnerLabel().sendKeys(dinnerLabel);
						String dinnerSummary = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
						AddModuleObjects.getDinnerSummary().sendKeys(dinnerSummary);
						String sunday = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
						if (sunday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getSunday().click();
						} else
							System.out.println("sunday not selected");
						String monday = ExcelUtils.getCellData(1, 35, ExcelFile, ExcelSheetName);
						if (monday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getMonday().click();
						} else
							System.out.println("Monday not selected");
						String tuesday = ExcelUtils.getCellData(1, 36, ExcelFile, ExcelSheetName);
						if (tuesday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getTuesday().click();
						} else
							System.out.println("Tuesday not selected");
						String wednesday = ExcelUtils.getCellData(1, 37, ExcelFile, ExcelSheetName);
						if (wednesday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getWednesday().click();
						} else
							System.out.println("Wednesday not selected");
						String thursday = ExcelUtils.getCellData(1, 38, ExcelFile, ExcelSheetName);
						if (thursday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getThursday().click();
						} else
							System.out.println("Thursday not selected");
						String friday = ExcelUtils.getCellData(1, 39, ExcelFile, ExcelSheetName);
						if (friday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getFriday().click();
						} else
							System.out.println("friday not selected");
						String saturday = ExcelUtils.getCellData(1, 40, ExcelFile, ExcelSheetName);
						if (saturday.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getSaturday().click();
						} else
							System.out.println("saturday not selected");
						String breakfastTimeFrom = ExcelUtils.getCellData(1, 41, ExcelFile, ExcelSheetName);
						try {
							Select breakfastFrom = new Select(AddModuleObjects.getBreakfastFrom());
							breakfastFrom.selectByValue(breakfastTimeFrom);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println("Breakfast Time From "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String breakfastTimeTo = ExcelUtils.getCellData(1, 42, ExcelFile, ExcelSheetName);
						try {
							Select breakfastTo = new Select(AddModuleObjects.getBreakfastTo());
							breakfastTo.selectByValue(breakfastTimeTo);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println("Breakfast Time To "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String breakfastRestriction = ExcelUtils.getCellData(1, 43, ExcelFile, ExcelSheetName);
						AddModuleObjects.getBreakfastRestriction().sendKeys(breakfastRestriction);
						String lunchFromTime = ExcelUtils.getCellData(1, 44, ExcelFile, ExcelSheetName);
						try {
							Select lunchFrom = new Select(AddModuleObjects.getLunchFrom());
							lunchFrom.selectByValue(lunchFromTime);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println(" Lunch From Time "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String lunchToTime = ExcelUtils.getCellData(1, 45, ExcelFile, ExcelSheetName);
						try {
							Select lunchTo = new Select(AddModuleObjects.getLunchTo());
							lunchTo.selectByValue(lunchToTime);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println(" Lunch To Time "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String lunchRestriction = ExcelUtils.getCellData(1, 46, ExcelFile, ExcelSheetName);
						AddModuleObjects.getLunchRestriction().sendKeys(lunchRestriction);
						String DinnerFromTime = ExcelUtils.getCellData(1, 47, ExcelFile, ExcelSheetName);
						try {
							Select dinnerFrom = new Select(AddModuleObjects.getDinnerFrom());
							dinnerFrom.selectByValue(DinnerFromTime);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println(" Dinner From Time "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String DinnerToTime = ExcelUtils.getCellData(1, 48, ExcelFile, ExcelSheetName);
						try {
							Select dinnerTo = new Select(AddModuleObjects.getDinnerTo());
							dinnerTo.selectByValue(DinnerToTime);
						} catch (NoSuchElementException nse) {
							nse.getStackTrace();
							System.out.println(" Dinner To Time "
									+ " Please Insert the Correct Value in Workbook(Ex:-If 7:00 AM Then '07:00 or If 10:00 PM Then '22:00)");
						}
						String dinnerRestriction = ExcelUtils.getCellData(1, 49, ExcelFile, ExcelSheetName);
						AddModuleObjects.getDinnerRestriction().sendKeys(dinnerRestriction);
						// button[text()='Save Meal']
						String save = ExcelUtils.getCellData(1, 50, ExcelFile, ExcelSheetName);
						if (save.equalsIgnoreCase("Save")) {
							AddModuleObjects.getSaveMeal().click();
							String generateVcf = ExcelUtils.getCellData(1, 51, ExcelFile, ExcelSheetName);
							if (generateVcf.equalsIgnoreCase("Yes")) {

								AddModuleObjects.getGenerateVCF().click();
								Thread.sleep(2000);
								//Need to add robot class for gerate VCF
								if(Pattern.compile(Pattern.quote(Constant.BROWSER_NAME), Pattern.CASE_INSENSITIVE).matcher("Firefox").find());
								generateVCF();
								Thread.sleep(3000);
								AddModule_Objects.genXmlOrClose = "Close";
								driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
							} else {
								AddModule_Objects.genXmlOrClose = "Close";
								driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
							}
						} else {
							AddModule_Objects.genXmlOrClose = "Close";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
						}

					}
					String window8Settings = ExcelUtils.getCellData(1, 52, ExcelFile, ExcelSheetName);
					if (window8Settings.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkWindowsSet().click();
						String pinnedTitleSquare = ExcelUtils.getCellData(1, 53, ExcelFile, ExcelSheetName);
						AddModuleObjects.getPinnedtiletitlesquare().sendKeys(pinnedTitleSquare);
						String pinnedTitleRec = ExcelUtils.getCellData(1, 54, ExcelFile, ExcelSheetName);
						AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(pinnedTitleRec);
						String urlForSquImg = ExcelUtils.getCellData(1, 55, ExcelFile, ExcelSheetName);
						AddModuleObjects.getURLforsquaretileimage().sendKeys(urlForSquImg);
						String urlForRecImg = ExcelUtils.getCellData(1, 56, ExcelFile, ExcelSheetName);
						AddModuleObjects.getURLforrectangletileimage().sendKeys(urlForRecImg);
						String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 57, ExcelFile,
								ExcelSheetName);
						if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
							AddModuleObjects.getClkCheckBox().click();
						} else
							System.out.println("user has not selected checkbox");
					}
				} else
				System.out.println("Window 8 settings not clicked");
				Log.info("Workbook Data has entered in Dinning Hall Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddModuleObjects.getClkPublish();
				Thread.sleep(3000);
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			//Actions action = new Actions(driver);
				//action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			} else {
				System.out.println("User has Already Created Dinning Hall Module");
				Log.info("User has Already Created Dinning Hall Module");
			}
		}
	}

	
	public static void generateVCF() throws IOException, AWTException, InterruptedException
	{
		String OS=Utils.getOS();
		if(OS.contains("win"))
		Runtime.getRuntime().exec(Constant.GENERATE_VCF);
		if(OS.contains("mac"))
		{
			System.out.println(OS);
			Robot robot = new Robot();
			Thread.sleep(3000);
			//robot.keyPress(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			System.out.println("Save selected");
			//robot.keyRelease(KeyEvent.VK_F);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("hit enter");
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			System.out.println("Hit escape");
		}
	}
	
	
	@SuppressWarnings("unused")
	public static void verifyVCF() {
		Log.info("VCF File Parser Starts For Dinning Hall Module");
		String home = System.getProperty("user.home");
		String OS=Utils.getOS();
		System.out.println(OS);
		if(OS.contains("mac")){
		home = home + "/Downloads/dining.vcf";
		}
		else 
		home = home + "\\Download\\dining.vcf";
				
		VCardParser.getInstance().sendGet(home);
		ArrayList<Values> campuses = VCardParser.getInstance().getCampuses();
		String name = VCardParser.getInstance().getCampusData(0, "N");
		String fullName = VCardParser.getInstance().getCampusData(0, "FN");
		String add = VCardParser.getInstance().getCampusData(0, "ADR");
		String xDLOC = VCardParser.getInstance().getCampusData(0, "X-D-BLDG-LOC");
		String label = VCardParser.getInstance().getCampusData(0, "LABEL");
		String eMail = VCardParser.getInstance().getCampusData(0, "EMAIL");
		String url = VCardParser.getInstance().getCampusData(0, "URL");
		String note = VCardParser.getInstance().getCampusData(0, "NOTE");
		String tel = VCardParser.getInstance().getCampusData(0, "TEL");
		String xURLADDDATE = VCardParser.getInstance().getCampusData(0, "X-URL-ADD-DATE");
		String xDHBREAKFASTLABEL = VCardParser.getInstance().getCampusData(0, "X-DH-BREAKFAST-LABEL");
		String xDHLUNCHLABEL = VCardParser.getInstance().getCampusData(0, "X-DH-LUNCH-LABEL");
		String xDHDINNERLABEL = VCardParser.getInstance().getCampusData(0, "X-DH-DINNER-LABEL");
		String xDHBREAKFASTSUMMARY = VCardParser.getInstance().getCampusData(0, "X-DH-BREAKFAST-SUMMARY");
		String xDHLUNCHSUMMARY = VCardParser.getInstance().getCampusData(0, "X-DH-LUNCH-SUMMARY");
		String xDHDINNERSUMMARY = VCardParser.getInstance().getCampusData(0, "X-DH-DINNER-SUMMARY");
		String xDHBREAKFASTURL = VCardParser.getInstance().getCampusData(0, "X-DH-BREAKFAST-URL");
		String xDHLUNCHURL = VCardParser.getInstance().getCampusData(0, "X-DH-LUNCH-URL");
		String xDHDINNERURL = VCardParser.getInstance().getCampusData(0, "X-DH-DINNER-URL");
		String xDHBREAKFAST = VCardParser.getInstance().getCampusData(0, "X-DH-BREAKFAST;OPTION=1");
		String xDHLUNCH = VCardParser.getInstance().getCampusData(0, "X-DH-LUNCH;OPTION=1");
		String xDHDINNER = VCardParser.getInstance().getCampusData(0, "X-DH-DINNER;OPTION=1");
		String xDBLDGID = VCardParser.getInstance().getCampusData(0, "X-D-BLDG-ID");
		String xDBLDGLOC = VCardParser.getInstance().getCampusData(0, "X-D-BLDG-LOC");
		System.out.println("XDLOC : " + xDLOC);
		System.out.println("LABEL : " + label);
		System.out.println("Name : " + name);
		System.out.println("FullName : " + fullName);
		System.out.println("Add : " + add);
		System.out.println("eMail :" + eMail);
		System.out.println("url  : " + url);
		System.out.println("note  : " + note);
		System.out.println("tel  : " + tel);
		System.out.println("xURLADDDATE : " + xURLADDDATE);
		System.out.println("xDHBREAKFASTLABEL : " + xDHBREAKFASTLABEL);
		System.out.println("xDHLUNCHLABEL : " + xDHLUNCHLABEL);
		System.out.println("xDHDINNERLABEL : " + xDHDINNERLABEL);
		System.out.println("xDHBREAKFASTSUMMARY : " + xDHBREAKFASTSUMMARY);
		System.out.println("xDHLUNCHSUMMARY : " + xDHLUNCHSUMMARY);
		System.out.println("xDHDINNERSUMMARY : " + xDHDINNERSUMMARY);
		System.out.println("xDHBREAKFASTURL : " + xDHBREAKFASTURL);
		System.out.println("xDHLUNCHURL : " + xDHLUNCHURL);
		System.out.println("xDHDINNERURL : " + xDHDINNERURL);
		System.out.println("xDHBREAKFAST : " + xDHBREAKFAST);
		System.out.println("xDHLUNCH : " + xDHLUNCH);
		System.out.println("xDHDINNER : " + xDHDINNER);
		System.out.println("xDBLDGID : " + xDBLDGID);
		System.out.println("xDBLDGLOC : " + xDBLDGLOC);
		Log.info("VCF File Parser Ends For Dinning Hall Module");
		/*
		 * if(null != campuses && !campuses.isEmpty()){ int count = 0;
		 * for(Values v : campuses){ System.out.println("index : " + count++
		 * +" =============== " +v.values.get("FN")); } }
		 * VCardParser.getInstance().sendGet(); ArrayList<Values> values =
		 * VCardParser.getInstance().getCampuses(); String address =
		 * VCardParser.getInstance().getCampusData(1,"ADR"); String eMAIL =
		 * VCardParser.getInstance().getCampusData(1,"EMAIL"); String Name =
		 * VCardParser.getInstance().getCampusData(1,"N"); String FullName =
		 * VCardParser.getInstance().getCampusData(1,"FN"); String URL =
		 * VCardParser.getInstance().getCampusData(1,"URL");
		 * System.out.println("Add : "+address);
		 * System.out.println("Name : "+Name);
		 * System.out.println("FullName : "+FullName);
		 * System.out.println("URL : "+URL);
		 * System.out.println("eMAIL : "+eMAIL);
		 */
	}

	public static void plistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Plist Parser Starts For Dinning Hall Module");
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
			if (type.equals("DiningHallRootVC") && isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("DiningHallRootVC") && isPrivate.equalsIgnoreCase("No")
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
			System.out.println("homeScreen Visible : " + homeScreen);
		}
		Dictionary dictDining = PlistParser.getInstance().getModule("DiningHallModule");
		if (null == dictDining) {
			System.out.println("DiningHall Module not present");
		}
		if (null != dictDining) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictDining);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {

				String url = specificVersion.getValue("url");
				System.out.println("url :" + url);
				if (!U.isEmpty(url)) {
					try {
						String vCardUrl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
						Assert.assertEquals(vCardUrl, url, "menudays workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {

				String menudays = specificVersion.getValue("menudays");
				System.out.println("menudays :" + menudays);
				if (!U.isEmpty(menudays)) {
					try {
						String menudaysExl = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
						Assert.assertEquals(menudaysExl, menudays,
								"menudays workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String shortName = specificVersion.getValue("shortName");
				System.out.println("shortName :" + shortName);
				if (!U.isEmpty(shortName)) {
					try {
						String pinnedtiletitlesquareExl = ExcelUtils.getCellData(1, 53, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedtiletitlesquareExl, shortName,
								"Pinnedtiletitlesquare workbook data does not match with pList data");
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
						String pinnedtiletitlerectangle = ExcelUtils.getCellData(1, 54, ExcelFile, ExcelSheetName);
						Assert.assertEquals(pinnedtiletitlerectangle, displayName,
								"Pinnedtiletitlerectangle workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String smallLogoImageUrl = specificVersion.getValue("testrecdinning");
				System.out.println("smallLogoImageUrl :" + smallLogoImageUrl);
				if (!U.isEmpty(smallLogoImageUrl)) {
					try {
						String urlforsquaretileimage = ExcelUtils.getCellData(1, 55, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlforsquaretileimage, smallLogoImageUrl,
								"URLforsquaretileimage workbook data does not match with pList data");
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
						String urlforrectangletileimage = ExcelUtils.getCellData(1, 56, ExcelFile, ExcelSheetName);
						Assert.assertEquals(urlforrectangletileimage, wideLogoImageUrl,
								"URLforrectangletileimage workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String secondaryTileAvailable = specificVersion.getValue("secondaryTileAvailable");
				System.out.println("secondaryTileAvailable :" + secondaryTileAvailable);
				if (!U.isEmpty(secondaryTileAvailable)) {
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 57, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						pinthismoduletodevicehomescreen = "true";
					} else {
						pinthismoduletodevicehomescreen = "false";
					}
					try {
						Assert.assertEquals(pinthismoduletodevicehomescreen, secondaryTileAvailable,
								"URLforrectangletileimage workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

		}
		Log.info("Plist Parser Ends For Dinning Hall Module");
	}
}
