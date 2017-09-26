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
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddDashboardModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void dashboardModuleLogic(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		if (moduleName.equalsIgnoreCase("Dashboard")) {

			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(
					By.xpath("//button[@value='" + moduleName + "Module']"))
					.isEnabled();
			if (b) {
				driver.manage().timeouts()
						.implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(
						By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Dashboard Button Clicked");
				element = driver
						.findElement(By
								.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Image Replaced");
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
					System.out.println("Dashboard Module Is Visible");
				String displayCoursesWidget = ExcelUtils.getCellData(1, 10,
						ExcelFile, ExcelSheetName);
				if (displayCoursesWidget.equalsIgnoreCase("No")) {
					AddModuleObjects.getdisplayCoursesWidget().click();
				} else {
					System.out.println("DisplayCoursesWidget is Selected");
				}
				String displayNotificationsWidget = ExcelUtils.getCellData(1,
						11, ExcelFile, ExcelSheetName);
				if (displayNotificationsWidget.equalsIgnoreCase("No")) {
					AddModuleObjects.getdisplayNotificationsWidget().click();
				} else {
					System.out
							.println("DisplayNotificationsWidget is Selected");
				}
				Log.info("Data From WorkBook Has Entered In Dashboard Module");
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
				System.out.println("User has already created Dashboard Module");
				Log.warn("User has already created Dashboard Module");
			}
		}
	}

	public static void PlistVerification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Log.info("PList Parsing Starts for Dashboard Module");
		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String PrivateOrPublic = dict.getValue("private");
			String homeScreen = dict.getValue("homeScreen");
			System.out.println("Type :-" + type);
			System.out.println("IsPrivate :-" + PrivateOrPublic);
			System.out.println("IsHomeScreen :-" + homeScreen);

		}

		Dictionary dictDashboard = PlistParser.getInstance().getModule(
				"DashboardModule");
		if (null == dictDashboard) {
			System.out.println("Dashboard Module not present in Plist");
		}
		if (null != dictDashboard) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictDashboard);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}

			if (null != specificVersion) {
				String iscoursesWidgetVisible = specificVersion
						.getValue("coursesWidgetVisible");
				if (!U.isEmpty(iscoursesWidgetVisible)) {
					System.out.println("SortType :" + iscoursesWidgetVisible);
					String coursesWidgetVisible = ExcelUtils.getCellData(1, 10,
							ExcelFile, ExcelSheetName);
					if (coursesWidgetVisible.equalsIgnoreCase("Yes")) {
						coursesWidgetVisible = "true";
					} else {
						coursesWidgetVisible = "false";
					}
					try {
						Assert.assertEquals(coursesWidgetVisible,
								iscoursesWidgetVisible,
								"coursesWidgetVisible Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				String isnotificationsWidgetVisible = specificVersion
						.getValue("notificationsWidgetVisible");
				if (!U.isEmpty(isnotificationsWidgetVisible)) {
					System.out.println("SortType :"
							+ isnotificationsWidgetVisible);
					String notificationsWidgetVisible = ExcelUtils.getCellData(
							1, 11, ExcelFile, ExcelSheetName);
					if (notificationsWidgetVisible.equalsIgnoreCase("Yes")) {
						notificationsWidgetVisible = "true";
					} else {
						notificationsWidgetVisible = "false";
					}
					try {
						Assert.assertEquals(notificationsWidgetVisible,
								isnotificationsWidgetVisible,
								"notificationsWidgetVisible Workbook Data Does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
		}
	}
}
