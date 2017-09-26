package com.s3.businessLogic;

import java.io.IOException;
import java.util.List;
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
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class StyleTab extends Utils {

	static AddModule_Objects AddModuleObjects;
	static boolean JavaAppOpen= false;
	private static WebElement element = null;

	// private static WebElement element = null;
	// static String colorCode = null;
	public static void selectNavigationLayout(int row, int col,
			String ExcelFile, String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		Thread.sleep(3000);
		AddModuleObjects.getClkStyle().click();
		String navigationLayoutType = ExcelUtils.getCellData(1, 4, ExcelFile,
				ExcelSheetName);
		// String NavigationLayoutType = "SideBar";
		if (navigationLayoutType.equalsIgnoreCase("Grid View")) {
			AddModuleObjects.getClkgridViewLayout().click();
			AddModuleObjects.getClkgridViewLayout().click();
			String appInfo = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			if (appInfo.equalsIgnoreCase("Yes")) {
				driver.findElement(By.xpath("//label[@for='hideHomeHeader']"))
						.click();
				driver.findElement(
						By.xpath("//label[@for='disableHomeFooterBackground']"))
						.click();
				Select select = new Select(driver.findElement(By
						.id("iconGridLayout")));
				select.selectByIndex(1);
				try {
					boolean b = AddModuleObjects
							.getChangeCampusFromHomeScreen().isDisplayed();
					if (b) {
						AddModuleObjects.getChangeCampusFromHomeScreen()
								.click();
					}
				} catch (NoSuchElementException nse) {
					nse.getStackTrace();
					System.out
							.println("ChangeCampusFromHomeScreen :-"
									+ "Functionality For Multi-Campus Apps User Not Performing Actions on Multi-Campus App");
				}
				StyleTab.appInfo(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("App info not selected by the user");
			}
			String style = ExcelUtils.getCellData(1, 22, ExcelFile,
					ExcelSheetName);
			if (style.equalsIgnoreCase("Yes")) {
				StyleTab.Style(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("Style not selected by user");
			}

		} else if (navigationLayoutType.equalsIgnoreCase("List")) {
			AddModuleObjects.getClklistViewLayout().click();
			AddModuleObjects.getClklistViewLayout().click();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String appInfo = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			if (appInfo.equalsIgnoreCase("Yes")) {
				StyleTab.appInfo(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("App info not selected by the user");
			}
			String style = ExcelUtils.getCellData(1, 22, ExcelFile,
					ExcelSheetName);
			if (style.equalsIgnoreCase("Yes")) {
				StyleTab.Style(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("Style not selected by user");
			}
		} else if (navigationLayoutType.equalsIgnoreCase("SideBar")) {

			AddModuleObjects.getClksideBarLayout().click();
			AddModuleObjects.getClksideBarLayout().click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String appInfo = ExcelUtils.getCellData(1, 5, ExcelFile,
					ExcelSheetName);
			if (appInfo.equalsIgnoreCase("Yes")) {
				StyleTab.appInfo(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("App info not selected by the user");
			}
			String style = ExcelUtils.getCellData(1, 22, ExcelFile,
					ExcelSheetName);
			if (style.equalsIgnoreCase("Yes")) {
				StyleTab.Style(row, col, ExcelFile, ExcelSheetName);
			} else {
				System.out.println("Style not selected by user");
			}
			Thread.sleep(2000);
			AddModule_Objects.saveOrDiscard = "Save";
			driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()))
					.click();
			Thread.sleep(3000);
			element = AddModuleObjects.getClkPublish();
			Utils.waitForElementToBeClickable(element);
			element.click();
			AddModuleObjects.getClkPublishPopUp().click();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,
					Keys.PAGE_UP).perform();

		}
	}

	public static void appInfo(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		String r = null;
		String g = null;
		String b = null;
		String imageType = null;
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		String navigationHeaderBarImage = ExcelUtils.getCellData(1, 6,
				ExcelFile, ExcelSheetName);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.DOWN).perform();
		if (navigationHeaderBarImage.equalsIgnoreCase("Yes")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkNavigationHeaderBarImage().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst.size(); i++) {

				String NavigationHeaderBarImageType = ExcelUtils.getCellData(1,
						7, ExcelFile, ExcelSheetName);
				if (NavigationHeaderBarImageType
						.equalsIgnoreCase("Android 324px by 84px")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='324px by 84px']";
				} else if (NavigationHeaderBarImageType
						.equalsIgnoreCase("Windows 420px by 50px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='420px by 50px']";
				} else if (NavigationHeaderBarImageType
						.equalsIgnoreCase("All 270px by 70px")) {
					imageType = "//label[text()='All']//following-sibling::label[text()='270px by 70px']";
				}
				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else {
					Actions action1 = new Actions(driver);
					action1.sendKeys(Keys.PAGE_DOWN).perform();
				}
			}
			try {
				String image = Constant.NAVIGATION_HEADER_REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
			} catch (IOException | InterruptedException e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("NavigationHeaderBarImage not clicked by user");
		}
		String navigationHeaderBarColor = ExcelUtils.getCellData(1, 8,
				ExcelFile, ExcelSheetName);
		if (navigationHeaderBarColor.equalsIgnoreCase("Yes")) {
			Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Actions action1 = new Actions(driver);
			action1.sendKeys(Keys.UP).perform();
			action1.sendKeys(Keys.UP).perform();
			Thread.sleep(1000);
			AddModuleObjects.NavigationHeaderBarColorBackground().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkColorPicker().clear();
			AddModuleObjects.ClkColorPickerTop().click();
			String NavigationHeaderBarColorDataTop = ExcelUtils.getCellData(1,
					9, ExcelFile, ExcelSheetName);
			String[] colorrgb = NavigationHeaderBarColorDataTop.split("-");
			r = colorrgb[0];
			g = colorrgb[1];
			b = colorrgb[2];
			colorPicker(r, g, b);
			String NavigationHeaderBarColorDataBottom = ExcelUtils.getCellData(
					1, 10, ExcelFile, ExcelSheetName);
			String[] colorrgb1 = NavigationHeaderBarColorDataBottom.split("-");
			AddModuleObjects.ClkColorPickerBottom().click();
			r = colorrgb1[0];
			g = colorrgb1[1];
			b = colorrgb1[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("NavigationHeaderBarColor is not clicked");
		}
		String brandIdentityAppIcon = ExcelUtils.getCellData(1, 11, ExcelFile,
				ExcelSheetName);
		if (brandIdentityAppIcon.equalsIgnoreCase("Yes")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkBrandIdentityAppIcon().click();
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst1 = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst1.size(); i++) {
				String brandIdentityAppIconType = ExcelUtils.getCellData(1, 12,
						ExcelFile, ExcelSheetName);
				if (brandIdentityAppIconType
						.equalsIgnoreCase("All 270px by 270px")) {
					imageType = "//label[text()='All']//following-sibling::label[text()='270px by 270px']";
				} else if (brandIdentityAppIconType
						.equalsIgnoreCase("Windows 558px by 270px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='558px by 270px']";
				} else if (brandIdentityAppIconType
						.equalsIgnoreCase("Windows 248px by 120px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='248px by 120px']";
				} else if (brandIdentityAppIconType
						.equalsIgnoreCase("Windows 310px by 150px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='310px by 150px']";
				} else if (brandIdentityAppIconType
						.equalsIgnoreCase("Windows 434px by 210px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='434px by 210px']";
				}

				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else {
					Actions action1 = new Actions(driver);
					action1.sendKeys(Keys.PAGE_DOWN).perform();
				}
			}
			try {
				String image = Constant.APP_ICON_REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				
			} catch (IOException | InterruptedException e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("BrandIdentityAppIcon not clicked");
		}

		String brandIdentityLunchImage = ExcelUtils.getCellData(1, 13,
				ExcelFile, ExcelSheetName);
		if (brandIdentityLunchImage.equalsIgnoreCase("Yes")) {
			Actions action1 = new Actions(driver);
			action1.sendKeys(Keys.UP).perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkBrandIdentityLaunchImage().click();
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst1 = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst1.size(); i++) {
				String brandIdentityLunchIconType = ExcelUtils.getCellData(1,
						14, ExcelFile, ExcelSheetName);
				if (brandIdentityLunchIconType
						.equalsIgnoreCase("Android 480px by 800px")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='480px by 800px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Android 854pxby1280px")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='854px by 1280px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("iPhone 640pxby960px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='640px by 960px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("iPhone 640pxby1136px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='640px by 1136px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Windows 1116pxby540px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1116px by 540px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Windows 620pxby300px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='620px by 300px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Windows 868pxby420px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='868px by 420px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Windows 1080pxby1920px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1080px by 1920px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("Windows 1920pxby1080px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1920px by 1080px']";
				} else if (brandIdentityLunchIconType
						.equalsIgnoreCase("iPad Landscape 2048pxby1496px")) {
					imageType = "//label[text()='iPad Landscape']//following-sibling::label[text()='2048px by 1496px']";
				} else if (brandIdentityLunchIconType.equalsIgnoreCase("ATL")) {
					imageType = "//label[text()='Android Tablet Landscape']//following-sibling::label[text()='1920px by 1080px']";
				} else if (brandIdentityLunchIconType.equalsIgnoreCase("ATP")) {
					imageType = "//label[text()='All Tablet Portrait']//following-sibling::label[text()='1536px by 2008px']";
				}
				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else {
					Actions action2 = new Actions(driver);
					action2.sendKeys(Keys.PAGE_DOWN).perform();
				}
			}
			try {
				String image = Constant.LAUNCH_IMAGE_REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("BrandIdentityLunchImage not clicked");
		}

		String moduleBackground = ExcelUtils.getCellData(1, 15, ExcelFile,
				ExcelSheetName);
		if (moduleBackground.equalsIgnoreCase("Yes")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkBrandIdentityModuleBackground().click();
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst1 = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst1.size(); i++) {
				String moduleBackgroundType = ExcelUtils.getCellData(1, 16,
						ExcelFile, ExcelSheetName);
				if (moduleBackgroundType.equalsIgnoreCase("All 200px by 190px")) {
					imageType = "//label[contains(text(),'All')]//following-sibling::label[text()='200px by 190px']";
				}
				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else {
					Actions action1 = new Actions(driver);
					action1.sendKeys(Keys.PAGE_DOWN).perform();
				}
			}
			try {
				String image = Constant.MODULE_BACKGROUND_REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
			} catch (IOException | InterruptedException e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("ModuleBackground not clicked");
		}

		String homeBackground = ExcelUtils.getCellData(1, 17, ExcelFile,
				ExcelSheetName);
		if (homeBackground.equalsIgnoreCase("Yes")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.ClkBrandIdentityHomeBackground().click();
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst1 = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst1.size(); i++) {
				// String
				// str1="//label[contains(text(),'All')]//following-sibling::label[text()='320px by 480px']";
				String homeBackgroundType = ExcelUtils.getCellData(1, 18,
						ExcelFile, ExcelSheetName);
				if (homeBackgroundType.equalsIgnoreCase("All")) {
					imageType = "//label[text()='All']//following-sibling::label[text()='320px by 480px']";
				} else if (homeBackgroundType.equalsIgnoreCase("Android")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='480px by 800px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("iPhone640px920px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='640px by 920px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("iPhone640px1096px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='640px by 1096px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("iPhone640px960px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='640px by 960px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows1093px614px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1093px by 614px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows320px768px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='320px by 768px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows1046px768px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1046px by 768px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows1366px768px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1366px by 768px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows320px1080px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='320px by 1080px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows1600px1080")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1600px by 1080px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows320px1440")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='320px by 1440px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows2240px1440")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='2240px by 1440px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows2560px1440")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='2560px by 1440px']";
				} else if (homeBackgroundType
						.equalsIgnoreCase("Windows1920px1080")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='1920px by 1080px']";
				}

				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else {
					Actions action1 = new Actions(driver);
					action1.sendKeys(Keys.PAGE_DOWN).perform();
				}
			}
			try {
				String image = Constant.HOME_BACKGROUND_REPLACEIMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				JavaAppOpen= false;
				Thread.sleep(1000);
			} catch (IOException | InterruptedException e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("HomeBackground not clicked");
		}

		String showBGImageAndroid = ExcelUtils.getCellData(1, 19, ExcelFile,
				ExcelSheetName);
		if (showBGImageAndroid.equalsIgnoreCase("Yes")) {
			if(!driver.findElement(By.xpath("//label[@for='showBGImageAndroid']")).isSelected()){
			driver.findElement(By.xpath("//label[@for='showBGImageAndroid']"))
					.click();
			}
		} else {
			System.out.println("showBGImageAndroid not clicked");
		}
		String showBGImageIos = ExcelUtils.getCellData(1, 20, ExcelFile,
				ExcelSheetName);
		if (showBGImageIos.equalsIgnoreCase("Yes")) {
			if(!driver.findElement(By.xpath("//label[@for='showBGImageiOS']")).isSelected())
			{
				driver.findElement(By.xpath("//label[@for='showBGImageiOS']"))
					.click();
			}
		} else {
			System.out.println("showBGImageiOS is not clicked");
		}
		String showBGImageWindows = ExcelUtils.getCellData(1, 21, ExcelFile,
				ExcelSheetName);
		if (showBGImageWindows.equalsIgnoreCase("Yes")) {
			if(!driver.findElement(By.xpath("//label[@for='showBGImageWindows']")).isSelected())
			{
			driver.findElement(By.xpath("//label[@for='showBGImageWindows']"))
					.click();
			}
		} else {
			System.out.println("showBGImageWindows is not clicked");
		}

	}

	public static void Style(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		String r = null;
		String g = null;
		String b = null;
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		String moduleIconText = ExcelUtils.getCellData(1, 23, ExcelFile,
				ExcelSheetName);
		if (moduleIconText.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkModuleIconText().click();
			String ModuleIconTextData = ExcelUtils.getCellData(1, 24,
					ExcelFile, ExcelSheetName);
			String[] textrgb = ModuleIconTextData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ModuleIconText is not clicked");
		}
		String moduleIconShadow = ExcelUtils.getCellData(1, 25, ExcelFile,
				ExcelSheetName);
		if (moduleIconShadow.equalsIgnoreCase("yes")) {
			AddModuleObjects.ClkModuleIconShadow().click();
			String ModuleIconShadowData = ExcelUtils.getCellData(1, 26,
					ExcelFile, ExcelSheetName);
			String[] textrgb = ModuleIconShadowData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ModuleIconShadow is not clicked");
		}
		String buttonTextColorNormal = ExcelUtils.getCellData(1, 27, ExcelFile,
				ExcelSheetName);
		if (buttonTextColorNormal.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkButtonTextColorNormal().click();
			String ButtonTextColorNormalData = ExcelUtils.getCellData(1, 28,
					ExcelFile, ExcelSheetName);
			String[] textrgb = ButtonTextColorNormalData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonTextColorNormal is not clicked");
		}
		String buttonTextColorFocus = ExcelUtils.getCellData(1, 29, ExcelFile,
				ExcelSheetName);
		if (buttonTextColorFocus.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkButtonTextColorFocus().click();
			String ButtonTextColorFocusData = ExcelUtils.getCellData(1, 30,
					ExcelFile, ExcelSheetName);
			String[] textrgb = ButtonTextColorFocusData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonTextColorFocusData is not clicked");
		}
		String buttonTextColorDisabled = ExcelUtils.getCellData(1, 31,
				ExcelFile, ExcelSheetName);
		if (buttonTextColorDisabled.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkButtonTextColorDisable().click();
			String ButtonTextColorDisabledData = ExcelUtils.getCellData(1, 32,
					ExcelFile, ExcelSheetName);
			String[] textrgb = ButtonTextColorDisabledData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonTextColorDisabled is not clicked");
		}
		String buttonBackgroundNormal = ExcelUtils.getCellData(1, 33,
				ExcelFile, ExcelSheetName);
		if (buttonBackgroundNormal.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkBackgroundButtonNormal().click();
			String ButtonBackgroundNormalTop = ExcelUtils.getCellData(1, 34,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkColorPickerTop().click();
			String[] textrgb = ButtonBackgroundNormalTop.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			String buttonBackgroundNormalBottomuttonBackgroundNormalBottom = ExcelUtils
					.getCellData(1, 35, ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkColorPickerBottom().click();
			String[] textrgb1 = buttonBackgroundNormalBottomuttonBackgroundNormalBottom
					.split("-");
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonBackgroundNormal");
		}
		String buttonBackgroundFocus = ExcelUtils.getCellData(1, 36, ExcelFile,
				ExcelSheetName);
		if (buttonBackgroundFocus.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkBackgroundButtonFocus().click();
			String buttonBackgroundFocusTop = ExcelUtils.getCellData(1, 37,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkColorPickerTop().click();
			String[] textrgb = buttonBackgroundFocusTop.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			String buttonBackgroundFocusBottom = ExcelUtils.getCellData(1, 38,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkColorPickerBottom().click();
			String[] textrgb1 = buttonBackgroundFocusBottom.split("-");
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonBackgroundFocus is not clicked");
		}
		String buttonBackgroundDisabled = ExcelUtils.getCellData(1, 39,
				ExcelFile, ExcelSheetName);
		if (buttonBackgroundDisabled.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkBackgroundButtonDisabled().click();
			String buttonBackgroundDisabledTop = ExcelUtils.getCellData(1, 40,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkColorPickerTop().click();
			String[] textrgb = buttonBackgroundDisabledTop.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerBottom().click();
			String ButtonBackgroundDisabledBottom = ExcelUtils.getCellData(1,
					41, ExcelFile, ExcelSheetName);
			String[] textrgb1 = ButtonBackgroundDisabledBottom.split("-");
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonBackgroundDisabled not clicked");
		}
		String buttonBackgroundPressed = ExcelUtils.getCellData(1, 42,
				ExcelFile, ExcelSheetName);
		if (buttonBackgroundPressed.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkBackgroundButtonPressed().click();
			AddModuleObjects.ClkColorPickerTop().click();
			String buttonBackgroundPressedTop = ExcelUtils.getCellData(1, 43,
					ExcelFile, ExcelSheetName);
			String[] textrgb = buttonBackgroundPressedTop.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerBottom().click();
			String buttonBackgroundPressedBottom = ExcelUtils.getCellData(1,
					44, ExcelFile, ExcelSheetName);
			String[] textrgb1 = buttonBackgroundPressedBottom.split("-");
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ButtonBackgroundPressed is not clicked");
		}
		String textLink = ExcelUtils.getCellData(1, 45, ExcelFile,
				ExcelSheetName);
		if (textLink.equalsIgnoreCase("Yes")) {
			String TextLinkData = ExcelUtils.getCellData(1, 46, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.ClkTextLink().click();
			String[] textrgb = TextLinkData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("TextLink not clicked");
		}
		String homeScreenNormal = ExcelUtils.getCellData(1, 47, ExcelFile,
				ExcelSheetName);
		if (homeScreenNormal.equalsIgnoreCase("Yes")) {
			AddModuleObjects.ClkHomeScreenNormal().click();
			String homeScreenNormalTop = ExcelUtils.getCellData(1, 48,
					ExcelFile, ExcelSheetName);
			String[] textrgb = homeScreenNormalTop.split("-");
			AddModuleObjects.ClkColorPickerTop().click();
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			String homeScreenNormalMiddle = ExcelUtils.getCellData(1, 49,
					ExcelFile, ExcelSheetName);
			String[] textrgb1 = homeScreenNormalMiddle.split("-");
			AddModuleObjects.ClkColorPickerMiddle().click();
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			String homeScreenNormalBottom = ExcelUtils.getCellData(1, 50,
					ExcelFile, ExcelSheetName);
			String[] textrgb2 = homeScreenNormalBottom.split("-");
			AddModuleObjects.ClkColorPickerBottom().click();
			r = textrgb2[0];
			g = textrgb2[1];
			b = textrgb2[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("HomeScreenNormal not clicked");
		}
		String listItemFocus = ExcelUtils.getCellData(1, 51, ExcelFile,
				ExcelSheetName);
		if (listItemFocus.equalsIgnoreCase("Yes")) {
			String ListItemFocusTop = ExcelUtils.getCellData(1, 52, ExcelFile,
					ExcelSheetName);
			String[] textrgb = ListItemFocusTop.split("-");
			AddModuleObjects.ClkListItemFocus().click();
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			String listItemFocusMiddle = ExcelUtils.getCellData(1, 53,
					ExcelFile, ExcelSheetName);
			String[] textrgb1 = listItemFocusMiddle.split("-");
			r = textrgb1[0];
			g = textrgb1[1];
			b = textrgb1[2];
			colorPicker(r, g, b);
			String listItemFocusBottom = ExcelUtils.getCellData(1, 54,
					ExcelFile, ExcelSheetName);
			String[] textrgb2 = listItemFocusBottom.split("-");
			r = textrgb2[0];
			g = textrgb2[1];
			b = textrgb2[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ListItemFocus not clicked");
		}
		String sideBarModule = ExcelUtils.getCellData(1, 55, ExcelFile,
				ExcelSheetName);
		if (sideBarModule.equalsIgnoreCase("Yes")) {
			String sideBarModuleData = ExcelUtils.getCellData(1, 56, ExcelFile,
					ExcelSheetName);
			String[] textrgb = sideBarModuleData.split("-");
			AddModuleObjects.ClkSideBarModule().click();
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("SideBarModule not clicked");
		}
		String sideBarCategoryBackground = ExcelUtils.getCellData(1, 57,
				ExcelFile, ExcelSheetName);
		if (sideBarCategoryBackground.equalsIgnoreCase("Yes")) {
			String SideBarCategoryBackgroundData = ExcelUtils.getCellData(1,
					58, ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkSideBarCategoryBackground().click();
			String[] textrgb = SideBarCategoryBackgroundData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("SideBarCategoryBackground not clicked");
		}
		String sideBarCategoryText = ExcelUtils.getCellData(1, 59, ExcelFile,
				ExcelSheetName);
		if (sideBarCategoryText.equalsIgnoreCase("Yes")) {
			String SideBarCategoryTextData = ExcelUtils.getCellData(1, 60,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkSideBarCategoryText().click();
			String[] textrgb = SideBarCategoryTextData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("SideBarCategoryText not clicked");
		}
		String sideBarCategoryTextShadow = ExcelUtils.getCellData(1, 61,
				ExcelFile, ExcelSheetName);
		if (sideBarCategoryTextShadow.equalsIgnoreCase("Yes")) {
			String SideBarCategoryTextShadowData = ExcelUtils.getCellData(1,
					62, ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkSideBarCategoryTextShadow().click();
			String[] textrgb = SideBarCategoryTextShadowData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("SideBarCategoryTextShadow not clicked");
		}
		String navigationHeaderBarText = ExcelUtils.getCellData(1, 63,
				ExcelFile, ExcelSheetName);
		if (navigationHeaderBarText.equalsIgnoreCase("Yes")) {
			String NavigationHeaderBarTextData = ExcelUtils.getCellData(1, 64,
					ExcelFile, ExcelSheetName);
			AddModuleObjects.ClkNavigationHeaderBarText().click();
			String[] textrgb = NavigationHeaderBarTextData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("NavigationHeaderBarText not clicked");
		}
		String moduleBadge = ExcelUtils.getCellData(1, 65, ExcelFile,
				ExcelSheetName);
		if (moduleBadge.equalsIgnoreCase("Yes")) {
			String moduleBadgeData = ExcelUtils.getCellData(1, 66, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.ClkModuleBadge().click();
			String[] textrgb = moduleBadgeData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("ModuleBadgeData not clicked");
		}
		
		String HomePagingButtonColorNormal =ExcelUtils.getCellData(1,72, ExcelFile,ExcelSheetName);
		if (HomePagingButtonColorNormal.equalsIgnoreCase("Yes")) {
			String HomePagingButtonColorNormalData = ExcelUtils.getCellData(1, 73, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.ClkHomePagingButtonColorNormal().click();
			String[] textrgb = HomePagingButtonColorNormalData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("HomePagingButtonColorNormalData not clicked");
		}
		
		String HomePagingButtonColorFocus =ExcelUtils.getCellData(1,74, ExcelFile,ExcelSheetName);
		if (HomePagingButtonColorFocus.equalsIgnoreCase("Yes")) {
			String HomePagingButtonColorFocusData = ExcelUtils.getCellData(1, 75, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.ClkHomePagingButtonColorFocus().click();
			String[] textrgb = HomePagingButtonColorFocusData.split("-");
			r = textrgb[0];
			g = textrgb[1];
			b = textrgb[2];
			colorPicker(r, g, b);
			AddModuleObjects.ClkColorPickerOK().click();
		} else {
			System.out.println("HomePagingButtonColorFocusData not clicked");
		}

	}

	public static void Advance(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		String advanced = ExcelUtils.getCellData(1, 67, ExcelFile,
				ExcelSheetName);
		if (advanced.equalsIgnoreCase("Yes")) {
			AddModuleObjects.getClkAdvanced().click();
			String plistUrl = ExcelUtils.getCellData(1, 68, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.getClkPlistUrl().sendKeys(plistUrl);
			String sponsorText = ExcelUtils.getCellData(1, 69, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.getClkSponsorText().sendKeys(sponsorText);
			String sponsorLink = ExcelUtils.getCellData(1, 70, ExcelFile,
					ExcelSheetName);
			AddModuleObjects.getClkSponsorLink().sendKeys(sponsorLink);
		} else {
			System.out.println("Advanced not clicked");
		}
	}

	public static void VerificationStyle() {

		String str = driver.findElement(By.xpath(".//*[@id='navigation-bar']"))
				.getAttribute("style");
		String[] Str = str.split("rgb");
		System.out.println(str);
		System.out.println(Str[1]);
		String[] sp = Str[2].split("repeat");
		System.out.println(sp[0]);
		String[] replace = Str[1].replace("(", "").replace(")", "").split(",");
		System.out.println(replace[0].trim());
		System.out.println(replace[1].trim());
		System.out.println(replace[2].trim());

	}

	public static void colorPicker(String r, String g, String b) {
		AddModuleObjects.ClkColorPicker().clear();
		AddModuleObjects.ClkColorPickerR().clear();
		AddModuleObjects.ClkColorPickerR().sendKeys(r);
		AddModuleObjects.ClkColorPickerG().clear();
		AddModuleObjects.ClkColorPickerG().sendKeys(g);
		AddModuleObjects.ClkColorPickerB().clear();
		AddModuleObjects.ClkColorPickerB().sendKeys(b);

	}

	public static void pListStyleVarification() throws Exception {
		AddModule_Objects.saveOrDiscard = "Save";
		driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
		Thread.sleep(2000);
		AddModuleObjects.getClkPublish().click();
		AddModuleObjects.getClkPublishPopUp().click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP)
				.perform();
		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		Dictionary dictStyleTab = PlistParser.getInstance().getModule(
				"HomeModule");
		if (null == dictStyleTab) {
			System.out.println("Home Module not present");
		}
		if (null != dictStyleTab) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictStyleTab);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {
				String LayoutType = specificVersion.getValue("designLayout");
				System.out.println("LayoutType : " + LayoutType);
			}
			Dictionary dictStyle = PlistParser.getInstance().getModule(
					"Stylesheet");
			if (null != dictStyle) {
				System.out.println(dictStyle
						.getValue("background_banner_bottom"));
				System.out.println(dictStyle
						.getValue("background_banner_center"));
				System.out.println(dictStyle.getValue("background_banner_top"));
				System.out.println(dictStyle.getValue("background_bottom"));
				System.out.println(dictStyle.getValue("background_center"));
				System.out.println(dictStyle
						.getValue("background_sidebar_category_bottom"));
				System.out.println(dictStyle
						.getValue("background_sidebar_category_top"));
				System.out.println(dictStyle
						.getValue("background_sidebar_subcategory"));
				System.out.println(dictStyle.getValue("background_top"));
				System.out
						.println(dictStyle.getValue("button_disabled_bottom"));
				System.out
						.println(dictStyle.getValue("button_disabled_center"));
				System.out.println(dictStyle.getValue("button_disabled_top"));
				System.out.println(dictStyle.getValue("button_focus_bottom"));
				System.out.println(dictStyle.getValue("button_focus_center"));
				System.out.println(dictStyle.getValue("button_focus_top"));
				System.out.println(dictStyle.getValue("button_normal_bottom"));
				System.out.println(dictStyle.getValue("button_normal_center"));
				System.out.println(dictStyle.getValue("button_normal_top"));
				System.out.println(dictStyle.getValue("button_pressed_bottom"));
				System.out.println(dictStyle.getValue("button_pressed_center"));
				System.out.println(dictStyle.getValue("button_pressed_top"));
				System.out.println(dictStyle
						.getValue("expandable_list_selector"));
				System.out
						.println(dictStyle.getValue("list_item_focus_bottom"));
				System.out
						.println(dictStyle.getValue("list_item_focus_center"));
				System.out.println(dictStyle.getValue("list_item_focus_top"));
				System.out.println(dictStyle
						.getValue("sidebar_category_header_text"));
				System.out.println(dictStyle
						.getValue("sidebar_category_header_text_shadow"));
				System.out.println(dictStyle.getValue("text_banner"));
				System.out.println(dictStyle.getValue("text_button_disabled"));
				System.out.println(dictStyle.getValue("text_button_normal"));
				System.out.println(dictStyle.getValue("text_button_focus"));
				System.out.println(dictStyle.getValue("text_link"));
				System.out.println(dictStyle.getValue("text_module_icon"));
				System.out.println(dictStyle
						.getValue("text_module_icon_shadow"));
				System.out.println(dictStyle
						.getValue("moduleBadgeBackgroundColor"));

			}
		}

	}
}

// String NavigationLayoutType = ExcelUtils.getCellData(1,0, ExcelFile,
// ExcelSheetName);
// if(NavigationLayoutType.equalsIgnoreCase("List")){
// driver.findElement(By.xpath("//label[@for='hideHomeHeader']")).click();
// driver.findElement(By.xpath("//label[@for='disableHomeFooterBackground']")).click();
// Select select = new Select(driver.findElement(By.id("iconGridLayout")));
// select.selectByIndex(1);
// }else{System.out.println("Not a List View");}
