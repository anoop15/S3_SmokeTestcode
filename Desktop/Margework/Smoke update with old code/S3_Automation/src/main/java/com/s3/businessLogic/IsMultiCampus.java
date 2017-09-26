package com.s3.businessLogic;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class IsMultiCampus extends Utils {
	public static ArrayList<String> list;
	static String campusNameExl;
	static String moduleNameExl;
	static boolean isCampusMatch = false;
	static String moduleNewNameExl;
	public static int mRow;
	public static int mCol;

	public static void appName(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		 isCampusMatch = false;
		campusNameExl = ExcelUtils.getCellData(1, 4, ExcelFile, ExcelSheetName);
		moduleNameExl = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		moduleNewNameExl = ExcelUtils.getCellData(1, 6, ExcelFile,ExcelSheetName);
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='app-name']/dt/a")).click();
		Thread.sleep(5000);
		List<WebElement> multiCampusList = driver.findElements(By
				.cssSelector("#app-name>dd>ul>li>a"));
		list = new ArrayList<String>();
		for (WebElement wb : multiCampusList) {
			String listElement = wb.getText();
			// System.out.println(listElement);

			if (listElement.equalsIgnoreCase(campusNameExl)) {
				isCampusMatch = driver
						.findElement(
								By.xpath("//dl[@id='app-name']/dd/ul/li/a[contains(text(),'"
										+ campusNameExl + "')]")).isDisplayed();
			}
			list.add(listElement);
		}
		if (isCampusMatch) {
			driver.findElement(
					By.xpath("//dl[@id='app-name']/dd/ul/li/a[contains(text(),'"
							+ campusNameExl + "')]")).click();
		}
		// System.out.println(list.size());
		// div[@id='sortlist']//div[contains(@data-dub_module_key,'AdmissionsModule')]
		// dl[@id='app-name']/dd

	}

	public static void multiPlist() throws Exception {

		GetLivePlist.generateMultiCampusPlist();
		PlistParser.getInstance();
		String displayName = PlistParser.getInstance().getValue(campusNameExl,
				"displayName");
		System.out.println(displayName);
		String fullName = PlistParser.getInstance().getValue(campusNameExl,
				"fullName");
		System.out.println(fullName);
		String configUrl = PlistParser.getInstance().getValue(campusNameExl,
				"configUrl");
		System.out.println(configUrl);

	}

	public static void isAdded(int row, int col, String ExcelFile,String ExcelSheetName) throws Exception {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (list.size() > 0) {
		for (int i = 0; i < list.size(); i++) {
				jse.executeScript("window.scrollBy(0,-5000)", "");
				driver.findElement(By.xpath("//a[text()='Modules']")).click();
				String campusName = list.get(i);
				driver.findElement(By.xpath(".//*[@id='app-name']/dt/a")).click();
				boolean isDisplayed = driver.findElement(By.xpath("//dl[@id='app-name']/dd/ul/li/a[contains(text(),'"+ campusName + "')]")).isDisplayed();
				if (campusName.equalsIgnoreCase(campusNameExl)) {
					if (isDisplayed) {
						String nom = driver.findElement(By.id("app-modules-title")).getText();
						driver.findElement(By.xpath("//dl[@id='app-name']/dd/ul/li/a[contains(text(),'"+ campusName + "')]")).click();
						Thread.sleep(2000);
						boolean isModulePresent = driver.findElement(By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"+ moduleNewNameExl +"')]")).isDisplayed();
						if (isModulePresent) { 									//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'testit')]
							System.out.println("Module Present In :"+ campusName+ "-- Number of Module in Campus :" + nom);
						} else {
							isClickDone(1);
							isModulePresent = driver.findElement(By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"+ moduleNewNameExl +"')]")).isDisplayed();
							if (isModulePresent) {
								System.out.println("Module Present In :"+ campusName+ "-- Number of Module in Campus :"	+ nom);
							}

						}
					}
				} else {
					if (isDisplayed) {
						String nom = driver.findElement(
								By.id("app-modules-title")).getText();
					driver.findElement(
								By.xpath("//dl[@id='app-name']/dd/ul/li/a[contains(text(),'"
										+ campusName + "')]")).click();
						Thread.sleep(2000);
						boolean isModulePresent = driver
								.findElement(
										By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
												+ moduleNameExl + "')]"))
								.isDisplayed();
						if (isModulePresent) {
							System.out.println("Module Present In :"
									+ campusName
									+ "-- Number of Module in Campus :" + nom);
						} else {
							isClickDone(1);
							isModulePresent = driver
									.findElement(
											By.xpath("//div[@id='sortlist']/div/div/div[1]/button/p[contains(text(),'"
													+ moduleNameExl + "')]"))
									.isDisplayed();
							if (isModulePresent) {
								System.out.println("Module Present In :"
										+ campusName
										+ "-- Number of Module in Campus :"
										+ nom);
							}

						}
					}
				}
			if (moduleNameExl.equalsIgnoreCase("Admissions"))
					AddAdmissionsModule.plistVerification(mRow, mCol,
							ExcelFile, ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Admittedly")
						|| moduleNameExl.equalsIgnoreCase("Banner Enrollment")
						|| moduleNameExl.equals("Bill Pay")
						|| moduleNameExl.equalsIgnoreCase("Bus Schedule")
						|| moduleNameExl.equalsIgnoreCase("Campus Job")
						|| moduleNameExl.equalsIgnoreCase("D2L")
						|| moduleNameExl.equalsIgnoreCase("Facebook")
						|| moduleNameExl.equalsIgnoreCase("Financial Aid")
						|| moduleNameExl.equalsIgnoreCase("Holds")
						|| moduleNameExl.equalsIgnoreCase("Library")
						|| moduleNameExl.equalsIgnoreCase("Twitter"))
					AddWebModules.pListVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("RSS"))
					AddRssModule.pListVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Courses"))
					AddCoursesModule.PlistVerification(mRow, mRow, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Maps"))
					AddMapModule.plistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("News"))
					AddNewsVideosSportsModule.plistVerification(mRow, mCol,
							ExcelFile, ExcelSheetName);
				else if (moduleNameExl
						.equalsIgnoreCase("PeopleSoft Enrollment"))
					AddPeopleSoftEnrollment.plistVerification(mRow, mCol,
							ExcelFile, ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Bursar"))
					AddBurserModule.plistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Emergency #")
						|| moduleNameExl.equalsIgnoreCase("Emergency")
						|| moduleNameExl.equalsIgnoreCase("Emergency#"))
					AddEmergencyModule.plistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Dining Hall"))
					AddDiningHallModule.plistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("App Module"))
					AddAppModule.PlistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("ImagesGallery"))
					AddImageGalleryModule.PlistVerification(mRow, mCol,
							ExcelFile, ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Directory"))
					AddDirectoryModule.PlistVerifiaction(mRow, mCol, ExcelFile,
							ExcelSheetName);
				else if (moduleNameExl.equalsIgnoreCase("Events"))
					AddEventsModule.plistVerification(mRow, mCol, ExcelFile,
							ExcelSheetName);

			}
		}
	}

	private static int startIndex = 0;

	private static void isClickDone(int rowIndex) {
		boolean isClickPerformed = false;

		try {

			List<WebElement> elementsList = driver.findElements(By
					.xpath("//div[@id='sortlist']"));
			WebElement completeData = elementsList.get(0);
			String myModuleName = completeData.getText();
			if (myModuleName != null) {
				String[] arr = myModuleName.split("\n");

				for (int k = 0; k < arr.length; k++) {
					if (arr[k].contains(moduleNameExl)) {
						String str = "//div[@id='sortlist']/div["
								+ (k + startIndex + 1) + "]/div/div[1]/button";
						driver.findElement(By.xpath(str)).click();
						isClickPerformed = true;
					}
				}
			}

			if (!isClickPerformed) {
				startIndex = startIndex + 2;
				boolean isRightScrollEnable = driver.findElement(
						By.cssSelector("#appModulesScrollRight")).isEnabled();
				if (isRightScrollEnable)
					driver.findElement(By.cssSelector("#appModulesScrollRight"))
							.click();
				else {
					System.out.println("Right Scroll is Disabled");

				}
				Thread.sleep(3000);
				isClickDone(rowIndex);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}

// div[@id='app-config-container']//button[@id='appModulesScrollRight']
