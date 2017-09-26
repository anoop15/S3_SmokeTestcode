package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

import org.testng.Assert;

public class AddPeopleSoftEnrollment extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;

	public static void addPeopleSoft(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("PeopleSoft Enrollment")) {

			AddModule_Objects.moduleName = "PeopleSoft Enrollment";
			boolean b = driver.findElement(
					By.xpath("//button[@value='EnrollmentModule']"))
					.isEnabled();
			System.out.println(b);
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("PeopleSoft Enrollment Module Clicked");
				driver.findElement(
						By.xpath("//img[@id='module-icon']//following-sibling::div"))
						.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("PeopleSoft Enrollment Image Replace");
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
				String enrollmentURL = ExcelUtils.getCellData(1, 10, ExcelFile,
						ExcelSheetName);
				AddModuleObjects.getURLAdmittedly().clear();
				AddModuleObjects.getURLAdmittedly().sendKeys(enrollmentURL);
				String enablePlanner = ExcelUtils.getCellData(1, 11, ExcelFile,
						ExcelSheetName);
				if (enablePlanner.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkEnablePlanner().click();
				} else
					System.out.println("getClkEnablePlanner is not clicked");

				String shoppingCart = ExcelUtils.getCellData(1, 12, ExcelFile,
						ExcelSheetName);
				if (shoppingCart.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkShoppingCart().click();

				} else
					System.out.println("ClkShoppingCart is selected");
				String swapClass = ExcelUtils.getCellData(1, 13, ExcelFile,
						ExcelSheetName);
				if (swapClass.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkEnableSwapClass().click();
				} else
					System.out.println("SwapClass is not clicked");
				String clkEnablefulltimerangesearch = ExcelUtils.getCellData(1,
						14, ExcelFile, ExcelSheetName);
				if (clkEnablefulltimerangesearch.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkEnablefulltimerangesearch().click();
				} else
					System.out
							.println("ClkEnablefulltimerangesearch is clicked");
				String addSearchField = ExcelUtils.getCellData(1, 15,
						ExcelFile, ExcelSheetName);
				if (addSearchField.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkAddSearchField().click();
					String displayString = ExcelUtils.getCellData(1, 16,
							ExcelFile, ExcelSheetName);
					AddModuleObjects.getDisplayString().sendKeys(displayString);
					String keys = ExcelUtils.getCellData(1, 17, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getkey().sendKeys(keys);
					String isEnabled = ExcelUtils.getCellData(1, 18, ExcelFile,
							ExcelSheetName);
					if (isEnabled.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkEnabled().click();
					} else
						System.out.println("enabled not clicked");
					String type = ExcelUtils.getCellData(1, 19, ExcelFile,
							ExcelSheetName);
					try {
						Select select = new Select(
								AddModuleObjects.getSelType());
						select.selectByVisibleText(type);
					} catch (NoSuchElementException nse) {
						nse.getStackTrace();
						System.out
								.println("Please Enter The Right Data in Type DropDown");
					}
					String populated = ExcelUtils.getCellData(1, 20, ExcelFile,
							ExcelSheetName);
					if (populated.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkPopulated().click();
					} else
						System.out.println("Populated is not clicked ");
					String value = ExcelUtils.getCellData(1, 21, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getASFValue().sendKeys(value);
					// Coordinates cor=((Locatable)element).getCoordinates();
					// cor.inViewPort();
					String Boolean = ExcelUtils.getCellData(1, 22, ExcelFile,
							ExcelSheetName);
					if (Boolean.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkboolean().click();
					} else
						System.out.println("getClkboolean not clicked");
					String isDefault = ExcelUtils.getCellData(1, 23, ExcelFile,
							ExcelSheetName);
					AddModuleObjects.getDefaultSelection().sendKeys(isDefault);
					String searchable = ExcelUtils.getCellData(1, 24,
							ExcelFile, ExcelSheetName);
					if (searchable.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkSearchableField().click();
					} else
						System.out
								.println("getClkSearchableField is not clicked");
				}
				String saveOrCancel = ExcelUtils.getCellData(1, 25, ExcelFile,
						ExcelSheetName);
				if (saveOrCancel.equalsIgnoreCase("Save")) {
					AddModule_Objects.saveOrCancel = "Save";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				} else {
					AddModule_Objects.saveOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AddModule_Objects.SaveOrCancel())).click();
				}
				Log.info("Workbook Data Inserted in PeopleSoft Enrollment Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects
						.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
						Keys.PAGE_UP).perform();
			} else {
				System.out.println("PeopleSoft Module already created");
				Log.info("PeopleSoft Module already created");
			}
		}

	}

	public static void plistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("PList Parser Starts PeopleSoft Module");
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
			if (type.equals("EnrollmentRootVC")
					&& isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true",
							"PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("EnrollmentRootVC")
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
			System.out.println("homeScreen Visible : " + homeScreen);
		}
		Dictionary dictPSE = PlistParser.getInstance().getModule(
				"EnrollmentModule");
		if (null == dictPSE) {
			System.out.println("PeopleSoft Module not present");
		}
		if (null != dictPSE) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictPSE);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {

				String enablePlanner = specificVersion
						.getValue("enablePlanner");
				System.out.println("enablePlanner :" + enablePlanner);
				if (!U.isEmpty(enablePlanner)) {
					String enableplannerExl = ExcelUtils.getCellData(1, 11,
							ExcelFile, ExcelSheetName);
					if (enableplannerExl.equalsIgnoreCase("Yes")) {
						enableplannerExl = "true";
					} else {
						enableplannerExl = "false";
					}
					try {
						Assert.assertEquals(enableplannerExl, enablePlanner,
								"Enableplaner workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String shoppingCart = specificVersion.getValue("shoppingCart");
				System.out.println("ShoppingCart :" + shoppingCart);
				if (!U.isEmpty(shoppingCart)) {
					String shoppingCartExl = ExcelUtils.getCellData(1, 12,
							ExcelFile, ExcelSheetName);
					if (shoppingCartExl.equalsIgnoreCase("Yes")) {
						shoppingCartExl = "true";
					} else {
						shoppingCartExl = "false";
					}
					try {
						Assert.assertEquals(shoppingCartExl, shoppingCart,
								"ShoppingCart workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String enableSwapClass = specificVersion
						.getValue("enableSwapClass");
				System.out.println("enableSwapClass :" + enableSwapClass);
				if (!U.isEmpty(enableSwapClass)) {
					String enableShoppingCartExl = ExcelUtils.getCellData(1,
							13, ExcelFile, ExcelSheetName);
					if (enableShoppingCartExl.equalsIgnoreCase("Yes")) {
						enableShoppingCartExl = "true";
					} else {
						enableShoppingCartExl = "false";
					}
					try {
						Assert.assertEquals(enableShoppingCartExl,
								enableSwapClass,
								"EnableShoppingCart workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String enablefulltimerangesearch = specificVersion
						.getValue("enablefulltimerangesearch");
				System.out.println("enablefulltimerangesearch :"
						+ enablefulltimerangesearch);
				String enablefulltimerangesearchExl = ExcelUtils.getCellData(1,
						14, ExcelFile, ExcelSheetName);
				if (enablefulltimerangesearchExl.equalsIgnoreCase("Yes")) {
					enablefulltimerangesearchExl = "true";
				} else {
					enablefulltimerangesearchExl = "false";
				}
				if (!U.isEmpty(enablefulltimerangesearch)) {
					try {
						Assert.assertEquals(enablefulltimerangesearchExl,
								enablefulltimerangesearch,
								"EnableShoppingCart workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
		}
		Dictionary peopledict = PlistParser.getInstance().getModule(
				"EnrollmentModule");
		Dictionary[] addSearch = peopledict.getChildArray("scopingFields");
		for (Dictionary sf : addSearch) {
			if (null != addSearch) {
			}

			String displayString = sf.getValue("displayString");
			System.out.println("DisplayString :" + displayString);
			String key = sf.getValue("key");
			System.out.println("key :" + key);
			String visible = sf.getValue("visible");
			System.out.println("visible  :" + visible);
			String type = sf.getValue("type");
			System.out.println("type :" + type);
			String populated = sf.getValue("populated");
			System.out.println("populated :" + populated);
			String value = sf.getValue("value");
			System.out.println("value : " + value);
			String booleanValue = sf.getValue("boolean");
			System.out.println("booleanValue :" + booleanValue);
			String defaultselection = sf.getValue("defaultselection");
			System.out.println("defaultselection :" + defaultselection);
			String searchablefield = sf.getValue("searchablefield");
			System.out.println("searchablefield :" + searchablefield);
		}
		Log.info("PList Parser Ends PeopleSoft Module");
	}

}
