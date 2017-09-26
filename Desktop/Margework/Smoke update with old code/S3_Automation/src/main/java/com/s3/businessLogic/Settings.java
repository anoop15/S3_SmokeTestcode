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
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class Settings extends Utils {

	static AddModule_Objects AddModuleObjects;
	private static WebElement element = null;

	public static void appSettingsLogic(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		Thread.sleep(3000);
		AddModuleObjects.getClkSettings().click();
		Thread.sleep(5000);
		String main = ExcelUtils.getCellData(1, 4, ExcelFile, ExcelSheetName);
		if (main.equalsIgnoreCase("Yes")) {
			Settings.settingsMain(row, col, ExcelFile, ExcelSheetName);
		} else {
			System.out.println("User not wants to fill main data");
		}

		String login = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
		if (login.equalsIgnoreCase("Yes")) {
			Settings.login(row, col, ExcelFile, ExcelSheetName);
		} else {
			System.out.println("User Does not want to fill data in login settings");
		}
		String notifications = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
		if (notifications.equalsIgnoreCase("Yes")) {
			Settings.notifications(row, col, ExcelFile, ExcelSheetName);
		} else {
			System.out.println("User Does not want to fill Notification data");
		}
		String isVisible = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
		if (isVisible.equalsIgnoreCase("Yes")) {
			Settings.getNotificationJson();
		} else {
			System.out.println("Notification not clicked ");
		}
		String advanceSetting = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
		if (advanceSetting.equalsIgnoreCase("Yes")) {
			Settings.advanceSettings(row, col, ExcelFile, ExcelSheetName);
		} else {
			System.out.println("Advance settings not clicked");
		}

	}

	public static void settingsMain(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {

		String SettingDefaultModulePicker = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		try {
			Thread.sleep(2000);
			Select select = new Select(AddModuleObjects.getClkSettingDefaultModulePicker());
			select.selectByVisibleText(SettingDefaultModulePicker);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Default Landing Module :-"
					+ "Please Enter the corret data in excel sheet or loading dropdown time is more then expected");
		}
		String homeTextLabel = ExcelUtils.getCellData(1, 6, ExcelFile, ExcelSheetName);
		try {
			boolean isHomeTextLabel = AddModuleObjects.gethomeTextLabel().isDisplayed();
			// boolean isHomeTextLabel = false;
			if (isHomeTextLabel) {
				AddModuleObjects.gethomeTextLabel().sendKeys(homeTextLabel);
				System.out.println("Home Text Label Funcationlity Is Displayed.");
				System.out.println("User Must be Using Multi-Campus App");
			} else {
				System.out.println("Home Text Label Funcationlity Only For Multi-Campus App");
				System.out.println("User Is, In Single-Campus App");
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Home text Label is only display for Multicampus");
		}
		String settingUsersConfigureLayout = ExcelUtils.getCellData(1, 7, ExcelFile, ExcelSheetName);
		if (settingUsersConfigureLayout.equalsIgnoreCase("Yes")) {
			AddModuleObjects.getClkSettingUsersConfigureLayout().click();
		} else
			System.out.println("SettingUsersConfigureLayout not clicked");
		try {
			boolean isEnableSearch = AddModuleObjects.getenableSearchInMultiCampus().isDisplayed();
			if (isEnableSearch) {
				System.out.println("User Using MultiCampus Enable Search MultiCampus Funcationlity");
				String enableSearchInMultiCampus = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
				if (enableSearchInMultiCampus.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getenableSearchInMultiCampus().click();
				} else
					System.out.println("getenableSearchInMultiCampus not clicked");
			} else {
				System.out.println("Enable Search MultiCampus Funcationlity Only For Multi-Campus App");
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Enable Search MultiCampus Funcationlity Only For Multi-Campus App");

		}
		String settingRateAppAppleURL = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingRateAppAppleURL().clear();
		AddModuleObjects.getClkSettingRateAppAppleURL().sendKeys(settingRateAppAppleURL);
		String settingRateAppAndroidURL = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingRateAppAndroidURL().clear();
		AddModuleObjects.getClkSettingRateAppAndroidURL().sendKeys(settingRateAppAndroidURL);
		String settingRateAppWindowsURL = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingRateAppWindowsURL().clear();
		AddModuleObjects.getClkSettingRateAppWindowsURL().sendKeys(settingRateAppWindowsURL);

	}

	public static void login(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String settingLoginUrl = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
		AddModuleObjects.getURLAdmittedly().clear();
		AddModuleObjects.getURLAdmittedly().sendKeys(settingLoginUrl);
		String settingHelpText = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingHelpText().clear();
		AddModuleObjects.getClkSettingHelpText().sendKeys(settingHelpText);
		String settingInfoText = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingInfoText().clear();
		AddModuleObjects.getClkSettingInfoText().sendKeys(settingInfoText);
		String enableAutomaticLogout = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
		if (enableAutomaticLogout.equalsIgnoreCase("Yes")) {
			AddModuleObjects.getClkSettingEnableAutomaticLogout().click();
		} else
			System.out.println("EnableAutomaticLogout not clicked");
		String settingSSOUrl = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingSSOUrl().clear();
		AddModuleObjects.getClkSettingSSOUrl().sendKeys(settingSSOUrl);

	}

	public static void notifications(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {

		String clkSettingManageNotifications = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
		if (clkSettingManageNotifications.equalsIgnoreCase("Yes")) {
			AddModuleObjects.getClkSettingManageNotifications1().click();
			Thread.sleep(2000);
			manageNotificationLogic(row, col, ExcelFile, ExcelSheetName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else
			System.out.println("Manage Notifications not clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String clkPushNotificationsUrl = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
		boolean b = false;
		try {
			b = AddModuleObjects.getClkSettingNotificationsPushURL().isDisplayed();
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		if (b) {
			AddModuleObjects.getClkSettingNotificationsPushURL().clear();
			AddModuleObjects.getClkSettingNotificationsPushURL().sendKeys(clkPushNotificationsUrl);
		}
		if (!b) {
			System.out.println("PushNotificationsUrl Functinality not for Pratner/Client Users");
		}
		boolean isLoginreq = AddModuleObjects.getClkSettingLoginRequired().isSelected();
		System.out.println("isLoginreq :" + isLoginreq);
		String loginRequired = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
		if (loginRequired.equalsIgnoreCase("Yes")) {
			if (!isLoginreq) {
				AddModuleObjects.getClkSettingLoginRequired().click();
			}
		} else {
			if (isLoginreq) {
				AddModuleObjects.getClkSettingLoginRequired().click();
			}
		}
		boolean isSelectedShowNoti = AddModuleObjects.getClkVisible().isSelected();
		String showNotiModule = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
		System.out.println("isSelectedShowNoti :" + isSelectedShowNoti);
		if (showNotiModule.equalsIgnoreCase("Yes")) {
			if (!isSelectedShowNoti) {
				AddModuleObjects.getClkVisible().click();
			}
		} else {
			if (isSelectedShowNoti) {
				AddModuleObjects.getClkVisible().click();
			}
		}

	}

	public static void advanceSettings(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
	//	Actions action = new Actions(driver);
	//	action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
	//	AddModuleObjects.getClkAdvancedSettings1().click();
		String testPlist = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
		if (testPlist.equalsIgnoreCase("Yes")) {
			boolean isDisplayed = AddModuleObjects.getClkTestPlist().isDisplayed();
			if (isDisplayed){
				AddModuleObjects.getClkTestPlist().click();
				String winHandleBefore = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				System.out.println("Live PList URL :" + driver.getCurrentUrl());
				Thread.sleep(3000);
	            driver.close();
				driver.switchTo().window(winHandleBefore);
				
		} else {
			System.out.println("TestPlist not clicked");
		}
		String liveAppPlist = ExcelUtils.getCellData(1, 35, ExcelFile, ExcelSheetName);
		if (liveAppPlist.equalsIgnoreCase("Yes")) {
			AddModuleObjects.getClkLiveAppPlist().click();
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			System.out.println("Test PList URL :" + driver.getCurrentUrl());
			Thread.sleep(3000);
            driver.close();
			driver.switchTo().window(winHandleBefore);
		}
		} else {
			System.out.println("Live App Plist Not clicked");
		}
		String svnName = ExcelUtils.getCellData(1, 36, ExcelFile, ExcelSheetName);
		boolean svnDisplayed = false;
		try {
			svnDisplayed = AddModuleObjects.getSVNName().isDisplayed();
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		if (svnDisplayed) {
			AddModuleObjects.getSVNName().clear();
			AddModuleObjects.getSVNName().sendKeys(svnName);
		}
		if (!svnDisplayed) {
			System.out.println("User Login with Client/Partner Credetials");
		}
	}

	@SuppressWarnings("static-access")
	public static void getNotificationJson() throws Exception {
		Thread.sleep(2000);
		AddModule_Objects.saveOrDiscard = "Save";
		driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
		Thread.sleep(4000);
		element = AddModuleObjects.getClkPublish();
		Utils.waitForElementToBeClickable(element);
		element.click();
		AddModuleObjects.getClkPublishPopUp().click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
		GetLivePlist.generateLiveAppPlist();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dictionary module = PlistParser.getInstance().getModule("NotificationsModule");
		if (null != module) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", module);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {
				String url = specificVersion.getValue("url");
				NotificationParser.getInstance().sendGet(url);
				System.out.println(url);
			}
		}

	}

	private static void manageNotificationLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {

	/*	AddModuleObjects.getClkSettingNotificationsDate().click();
		String exlMonth = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
		String exlDate = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
		String exlYear = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
		String month = null;
		if (null != exlMonth) {

			month = monthNameByIndex(Integer.parseInt(exlMonth));

			String monthAndYear = month + " " + exlYear;
			String getMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String getYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String getMonthAndYear = getMonth + " " + getYear;
			boolean b = monthAndYear.equals(getMonthAndYear);
			// TODO : need to change code for recursive method
			while (b) {

				driver.findElement(By.xpath("//a[text()='" + exlDate + "']")).click();
				break;
			}
			while (!b) {
				element = driver.findElement(By.xpath("//a[@title='Next']"));
				element.click();
				String getMonths = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String getYears = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				String getMonthsAndYears = getMonths + " " + getYears;
				if (monthAndYear.equals(getMonthsAndYears)) {
					driver.findElement(By.xpath("//a[text()='" + exlDate + "']")).click();
					break;
				}
			}
		}*/
		String notiTime = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
		try {
			Select selectTime = new Select(AddModuleObjects.getClkSettingNotificationsTime());
			selectTime.selectByValue(notiTime);
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
			System.out.println("Notification Time : "
					+ "Please Insert the Data in According To 24 Hours Clock Like:- For 12:00 AM - 00:00");
		}

		String subject = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingNotificationsSubject().clear();
		AddModuleObjects.getClkSettingNotificationsSubject().sendKeys(subject);
		String content = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingNotificationsContent().clear();
		AddModuleObjects.getClkSettingNotificationsContent().sendKeys(content);
		String attachmentTitle = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingNotificationsAttachmentTitle().clear();
		AddModuleObjects.getClkSettingNotificationsAttachmentTitle().sendKeys(attachmentTitle);
		String attachmentLink = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkSettingNotificationsAttachmentLink().clear();
		AddModuleObjects.getClkSettingNotificationsAttachmentLink().sendKeys(attachmentLink);
		String saveOrCancel = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
		if (saveOrCancel.equalsIgnoreCase("Save")) {
			AddModuleObjects.getClkSettingNotificationsSave().click();
			AddModuleObjects.getCancel().click();
		} else {
			AddModuleObjects.getCancel().click();
		}

	}

	private static String monthNameByIndex(int index) {
		String name = "";
		switch (index) {
		case 1:
			name = "January";
			break;
		case 2:
			name = "February";
			break;
		case 3:
			name = "March";
			break;
		case 4:
			name = "April";
			break;
		case 5:
			name = "May";
			break;
		case 6:
			name = "June";
			break;
		case 7:
			name = "July";
			break;
		case 8:
			name = "August";
			break;
		case 9:
			name = "September";
			break;
		case 10:
			name = "October";
			break;
		case 11:
			name = "November";
			break;
		case 12:
			name = "December";
			break;

		default:
			break;
		}

		return name;

	}

}
