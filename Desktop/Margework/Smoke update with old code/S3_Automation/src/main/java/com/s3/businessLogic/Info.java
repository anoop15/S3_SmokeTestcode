package com.s3.businessLogic;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.s3.utility.Utils;

public class Info extends Utils {
	static AddModule_Objects AddModuleObjects;

	public static void infoTab(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		Thread.sleep(2000);
		AddModuleObjects.getClkInfo().click();
		Thread.sleep(2000);
		String InfoAnalytic = ExcelUtils.getCellData(1, 4, ExcelFile,
				ExcelSheetName);
		boolean isPresent = false;
		try {
			isPresent = AddModuleObjects.getClkInfoAnalytic().isDisplayed();
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		if (isPresent) {
			try {
				Select select = new Select(
						AddModuleObjects.getClkInfoAnalytic());
				select.selectByVisibleText(InfoAnalytic);
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Please Fill Right Data in Excel Sheet/Data not present in InfoAnalytic");
			}
		}
		if (!isPresent) {
			System.out
					.println("Analytic Funcationality Not For Partner/Client Users");
		}
		String infoOrganization = ExcelUtils.getCellData(1, 5, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoOrganization().clear();
		AddModuleObjects.getClkInfoOrganization().sendKeys(infoOrganization);
		String infoServiceTag = ExcelUtils.getCellData(1, 6, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoServiceTag().clear();
		AddModuleObjects.getClkInfoServiceTag().sendKeys(infoServiceTag);
		String infoIconReplace = ExcelUtils.getCellData(1, 7, ExcelFile,
				ExcelSheetName);
		if (infoIconReplace.equalsIgnoreCase("Yes")) {
			String imageType = null;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddModuleObjects.getClkImage().click();
			AddModuleObjects.ClkNavigationBarImageList();
			List<WebElement> lst1 = driver.findElements(By
					.xpath("//ul[@class='image-center-list']/li"));
			for (int i = 0; i <= lst1.size(); i++) {
				String infoDisplayAboutDubLabsType = ExcelUtils.getCellData(1,
						8, ExcelFile, ExcelSheetName);
				if (infoDisplayAboutDubLabsType
						.equalsIgnoreCase("Android 220px by 64px")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='220px by 64px']";
				} else if (infoDisplayAboutDubLabsType
						.equalsIgnoreCase("Android 450px by 131px")) {
					imageType = "//label[text()='Android']//following-sibling::label[text()='450px by 131px']";
				} else if (infoDisplayAboutDubLabsType
						.equalsIgnoreCase("iPhone 221px by 64px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='221px by 64px']";
				} else if (infoDisplayAboutDubLabsType
						.equalsIgnoreCase("iPhone 442px by 128px")) {
					imageType = "//label[text()='iPhone']//following-sibling::label[text()='442px by 128px']";
				} else if (infoDisplayAboutDubLabsType
						.equalsIgnoreCase("Windows 75px by 75px")) {
					imageType = "//label[text()='Windows']//following-sibling::label[text()='75px by 75px']";
				}
				if (driver.findElement(By.xpath(imageType)).isDisplayed()) {
					driver.findElement(By.xpath(imageType)).click();
				} else
					System.out.println("List Present not present");
			}
			try {
				String image = Constant.INFO_ICON_REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		} else
			System.out.println("Info Icon Not Replace");
		String infoAbout = ExcelUtils.getCellData(1, 9, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkModuleAbout().clear();
		AddModuleObjects.getClkModuleAbout().sendKeys(infoAbout);
		String infoShareThisAppContent = ExcelUtils.getCellData(1, 10,
				ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkInfoShareThisAppContent().clear();
		AddModuleObjects.getClkInfoShareThisAppContent().sendKeys(
				infoShareThisAppContent);
		String infoDisplayAboutDubLabs = ExcelUtils.getCellData(1, 11,
				ExcelFile, ExcelSheetName);
		if (infoDisplayAboutDubLabs.equalsIgnoreCase("Yes")) {
			boolean b = AddModuleObjects.getClkInfoDisplayAboutDubLabs()
					.isSelected();
			if (b == false)
				AddModuleObjects.getClkInfoDisplayAboutDubLabs().click();
		} else
			System.out.println("DisplayAboutDubLabs not clicked");

		String infoAppDownloadPagetitle = ExcelUtils.getCellData(1, 12,
				ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkInfoAppDownloadPagetitle().clear();
		AddModuleObjects.getClkInfoAppDownloadPagetitle().sendKeys(
				infoAppDownloadPagetitle);
		String infoAppDownloadPageUr = ExcelUtils.getCellData(1, 13, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoAppDownloadPageUrl().clear();
		AddModuleObjects.getClkInfoAppDownloadPageUrl().sendKeys(
				infoAppDownloadPageUr);
		String infoAndroidDownloadURL = ExcelUtils.getCellData(1, 14,
				ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkInfoAndroidDownloadURL().clear();
		AddModuleObjects.getClkInfoAndroidDownloadURL().sendKeys(
				infoAndroidDownloadURL);
	//	String infoBlackberryDownloadURL = ExcelUtils.getCellData(1, 15,ExcelFile, ExcelSheetName);
	//	AddModuleObjects.getClkInfoBlackberryDownloadURL().clear();
	//	AddModuleObjects.getClkInfoBlackberryDownloadURL().sendKeys(infoBlackberryDownloadURL);
		String infoiPhoneDownloadURL = ExcelUtils.getCellData(1, 16, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoiPhoneDownloadURL().clear();
		AddModuleObjects.getClkInfoiPhoneDownloadURL().sendKeys(
				infoiPhoneDownloadURL);
		String infoPhoneNumberTitle = ExcelUtils.getCellData(1, 17, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoPhoneNumberTitle().clear();
		AddModuleObjects.getClkInfoPhoneNumberTitle().sendKeys(
				infoPhoneNumberTitle);
		String infoPhoneNumberValue = ExcelUtils.getCellData(1, 18, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoPhoneNumberValue().clear();
		AddModuleObjects.getClkInfoPhoneNumberValue().sendKeys(
				infoPhoneNumberValue);
		String infoEmailTitle = ExcelUtils.getCellData(1, 19, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoEmailTitle().clear();
		AddModuleObjects.getClkInfoEmailTitle().sendKeys(infoEmailTitle);
		String infoEmailValue = ExcelUtils.getCellData(1, 20, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoEmailValue().clear();
		AddModuleObjects.getClkInfoEmailValue().sendKeys(infoEmailValue);
		String infoSupportURLTitle = ExcelUtils.getCellData(1, 21, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoSupportURLTitle().clear();
		AddModuleObjects.getClkInfoSupportURLTitle().sendKeys(
				infoSupportURLTitle);
		String infoSupportURLValue = ExcelUtils.getCellData(1, 22, ExcelFile,
				ExcelSheetName);
		AddModuleObjects.getClkInfoSupportURLValue().clear();
		AddModuleObjects.getClkInfoSupportURLValue().sendKeys(
				infoSupportURLValue);
		String infoFullWebsiteURLTitle = ExcelUtils.getCellData(1, 23,
				ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkInfoFullWebsiteURLTitle().clear();
		AddModuleObjects.getClkInfoFullWebsiteURLTitle().sendKeys(
				infoFullWebsiteURLTitle);
		String infoFullWebsiteURLValue = ExcelUtils.getCellData(1, 24,
				ExcelFile, ExcelSheetName);
		AddModuleObjects.getClkInfoFullWebsiteURLValue().clear();
		AddModuleObjects.getClkInfoFullWebsiteURLValue().sendKeys(
				infoFullWebsiteURLValue);
		AddModule_Objects.saveOrDiscard = "Save";
		driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
		Thread.sleep(2000);
		AddModuleObjects.getClkPublish().click();
		Thread.sleep(2000);
		AddModuleObjects.getClkPublishPopUp().click();
		System.out.println("Click on publish ");
		Actions action = new Actions(driver);
		//action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP)
		//		.perform();
		//Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(40000,0);");
		
	}

	public static void pListverification(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		Dictionary dictInfo = PlistParser.getInstance().getModule("InfoModule");
		if (null == dictInfo) {
			System.out.println("Info Module not present");
		}
		if (null != dictInfo) {
			Dictionary versions = PlistParser.getInstance().getDictionary(
					"versions", dictInfo);
			Dictionary specificVersion = PlistParser.getInstance()
					.getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary(
						"1.0", versions);
			}
			if (null != specificVersion) {
				String organization = specificVersion.getValue("organization");
				String[] organizationPList = organization.split("~");
				String organizationName = organizationPList[0];
				System.out.println("organization :" + organizationName);
				if (!U.isEmpty(organizationName)) {
					String infoOrganization = ExcelUtils.getCellData(1, 5,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(infoOrganization, organizationName,
								"organization workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				String serviceTag = specificVersion.getValue("serviceTag");
				System.out.println("serviceTag " + serviceTag);
				if (!U.isEmpty("serviceTag")) {
					String InfoServiceTag = ExcelUtils.getCellData(1, 6,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(InfoServiceTag, serviceTag,
								"serviceTag workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String aboutText = specificVersion.getValue("aboutText");
				System.out.println("aboutText " + aboutText);
				if (!U.isEmpty("aboutText")) {
					String aboutTextExl = ExcelUtils.getCellData(1, 9,
							ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(aboutTextExl, aboutText,
								"aboutText workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String shareThisAppContent = specificVersion
						.getValue("shareThisAppContent");
				System.out
						.println("shareThisAppContent " + shareThisAppContent);
				if (!U.isEmpty("shareThisAppContent")) {
					String shareThisAppContentExl = ExcelUtils.getCellData(1,
							10, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(shareThisAppContentExl,
								shareThisAppContent,
								"shareThisAppContent workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String displayAboutDubLabs = specificVersion
						.getValue("displayAboutDubLabs");
				System.out
						.println("displayAboutDubLabs " + displayAboutDubLabs);
				if (!U.isEmpty("displayAboutDubLabs")) {
					String displayAboutDubLabsExl = ExcelUtils.getCellData(1,
							11, ExcelFile, ExcelSheetName);
					if (displayAboutDubLabsExl.equalsIgnoreCase("Yes")) {
						displayAboutDubLabsExl = "true";
					} else {
						displayAboutDubLabsExl = "false";
					}
					try {
						Assert.assertEquals(displayAboutDubLabsExl,
								displayAboutDubLabs,
								"displayAboutDubLabs workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				Dictionary appShareUrl = dictInfo.getChild("appShareUrl");
				if (null != appShareUrl) {
					String title = appShareUrl.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("title :" + title);
						String appDownloadPagetitle = ExcelUtils.getCellData(1,
								12, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(appDownloadPagetitle, title,
									"AppDownloadPagetitle Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
					String value = appShareUrl.getValue("value");
					if (!U.isEmpty(value)) {
						System.out.println("value :" + value);
						String infoAppDownloadPageUr = ExcelUtils.getCellData(
								1, 13, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoAppDownloadPageUr, value,
									"InfoAppDownloadPageUr Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
					String valueAndroid = appShareUrl.getValue("valueAndroid");
					if (!U.isEmpty(valueAndroid)) {
						System.out.println("valueAndroid :" + valueAndroid);
						String infoAndroidDownloadURL = ExcelUtils.getCellData(
								1, 14, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoAndroidDownloadURL,
									valueAndroid,
									"InfoAndroidDownloadURL Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				/*	String valueBB = appShareUrl.getValue("valueBB");
					if (!U.isEmpty(valueBB)) {
						System.out.println("valueBB :" + valueBB);
						String infoBlackberryDownloadURL = ExcelUtils
								.getCellData(1, 15, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoBlackberryDownloadURL,
									valueBB,
									"InfoBlackberryDownloadURL Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}*/
					String valueiPhone = appShareUrl.getValue("valueiPhone");
					if (!U.isEmpty(valueiPhone)) {
						System.out.println("valueiPhone :" + valueiPhone);
						String infoiPhoneDownloadURL = ExcelUtils.getCellData(
								1, 16, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoiPhoneDownloadURL,
									valueiPhone,
									"InfoiPhoneDownloadURL Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}

				Dictionary contactPhone = dictInfo.getChild("contactPhone");
				if (null != contactPhone) {
					String title = contactPhone.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("title :" + title);
						String infoPhoneNumberTitle = ExcelUtils.getCellData(1,
								17, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoPhoneNumberTitle, title,
									" Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
						String value = contactPhone.getValue("value");
						if (!U.isEmpty(value)) {
							System.out.println("value :" + value);
							String infoPhoneNumberValue = ExcelUtils
									.getCellData(1, 18, ExcelFile,
											ExcelSheetName);
							try {
								Assert.assertEquals(infoPhoneNumberValue,
										value,
										"InfoPhoneNumberValue Workbook data does not match with plist data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}
				}
				Dictionary supportEmail = dictInfo.getChild("supportEmail");
				if (null != supportEmail) {
					String title = supportEmail.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("title :" + title);
						String infoEmailTitle = ExcelUtils.getCellData(1, 19,
								ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoEmailTitle, title,
									"InfoEmailTitle Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
						String value = supportEmail.getValue("value");
						if (!U.isEmpty(value)) {
							System.out.println("value :" + value);
							String infoEmailValue = ExcelUtils.getCellData(1,
									20, ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(infoEmailValue, value,
										"InfoEmailValue Workbook data does not match with plist data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}

						}
					}
				}

				Dictionary supportUrl = dictInfo.getChild("supportUrl");
				if (null != supportUrl) {
					String title = supportUrl.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("title :" + title);
						String infoSupportURLTitle = ExcelUtils.getCellData(1,
								21, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoSupportURLTitle, title,
									"InfoSupportURLTitle Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
						String value = supportUrl.getValue("value");
						if (!U.isEmpty(value)) {
							System.out.println("value :" + value);
							String InfoSupportURLValue = ExcelUtils
									.getCellData(1, 22, ExcelFile,
											ExcelSheetName);
							try {
								Assert.assertEquals(InfoSupportURLValue, value,
										"InfoSupportURLValue Workbook data does not match with plist data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}

						}
					}
				}

				Dictionary fullWebsiteUrl = dictInfo.getChild("fullWebsiteUrl");
				if (null != fullWebsiteUrl) {
					String title = fullWebsiteUrl.getValue("title");
					if (!U.isEmpty(title)) {
						System.out.println("title :" + title);
						String infoFullWebsiteURLTitle = ExcelUtils
								.getCellData(1, 23, ExcelFile, ExcelSheetName);
						try {
							Assert.assertEquals(infoFullWebsiteURLTitle, title,
									"InfoFullWebsiteURLTitle Workbook data does not match with plist data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
						String value = fullWebsiteUrl.getValue("value");
						if (!U.isEmpty(value)) {
							System.out.println("value :" + value);
							String infoFullWebsiteURLValue = ExcelUtils
									.getCellData(1, 24, ExcelFile,
											ExcelSheetName);
							try {
								Assert.assertEquals(infoFullWebsiteURLValue,
										value,
										"InfoFullWebsiteURLValue Workbook data does not match with plist data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}

						}
					}
				}
			}
		}

	}
}