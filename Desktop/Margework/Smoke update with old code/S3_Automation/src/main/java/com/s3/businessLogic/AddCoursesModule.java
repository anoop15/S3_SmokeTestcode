package com.s3.businessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

public class AddCoursesModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void AddCoursesModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		System.out.println(moduleName);
		if (moduleName.equalsIgnoreCase("Courses")) {
			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(By.xpath("//button[@value='CoursesModule']")).isEnabled();
			System.out.println(b);
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Courses Module Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(3000);
				Log.info("Courses Module Image Replaced.");
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
					System.out.println("User Has Not Clicked:-" + " Private Button");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkIsVisible().click();
					System.out.println("User Has Clicked On:-" + "Visible Button" + "Module Not Visible");
				} else
					System.out.println("Courses Module is visible");
				String coursesURL = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getURLAdmittedly().sendKeys(coursesURL);
				String showRoster = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				if (showRoster.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowRoster().click();
				} else
					System.out.println("ShowRoster is seleted");
				String showGrades = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
				if (showGrades.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowGrades().click();
				} else
					System.out.println("ShowGrades is selected");
				String showAssignments = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
				if (showAssignments.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowAssignments().click();
				} else
					System.out.println("ShowAssignments is selected");
				String showDiscussions = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
				if (showDiscussions.equalsIgnoreCase("No")) {

					AddModuleObjects.getShowDiscussions().click();
				} else
					System.out.println("ShowDiscussions is selected");
				String showAnnouncements = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
				if (showAnnouncements.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowAnnouncements().click();
				} else
					System.out.println("ShowAnnouncements is seleted");

				String showAssignmentsButton = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
				if (showAssignmentsButton.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowAssignmentsButton().click();
				} else
					System.out.println("ShowAssignmentsButton is selected");
				String showDefaultGradeValue = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
				if (showDefaultGradeValue.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowDefaultGradeValue().click();
				} else
					System.out.println("ShowDefaultGradeValue is selected");
				String showAnnouncementsButton = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
				if (showAnnouncementsButton.equalsIgnoreCase("No")) {
					AddModuleObjects.getShowAnnouncementsButton().click();
				} else
					System.out.println("ShowAnnouncementsButton is selected");
				String showPurchasedTextbooksButton = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
				if (showPurchasedTextbooksButton.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getShowPurchasedTextbooksButton().click();
				} else
					System.out.println("ShowPurchasedTextbooksButton is selected");
				String showAvatar = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
				if (showAvatar.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkShowAvatar().click();
				} else
					System.out.println("ShowAvatar is selected");
				String bookStore = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
				if (bookStore.equalsIgnoreCase("yes")) {
					AddModuleObjects.getClkBookstore().click();
					String bookStoreUrl = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
					AddModuleObjects.getClkBookstoreUrl().sendKeys(bookStoreUrl);
					String useCRN = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
					if (useCRN.equalsIgnoreCase("No")) {
						AddModuleObjects.getShowGrades().click();
					} else
						System.out.println("Use CRN Clicked");
					String manageBookStore = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
					if (manageBookStore.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkManageBookStore().click();
						String campus = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
						String booKStoreMemberId = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
						String activeTermIDBookstore = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
						String saveOrCancel = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
						try {
							Thread.sleep(2000);
							Select select = new Select(AddModuleObjects.getCampusName());
							select.selectByVisibleText(campus);
							AddModuleObjects.getBookstoreMemberId().sendKeys(booKStoreMemberId);
							AddModuleObjects.getActiveTermIDBookstore().sendKeys(activeTermIDBookstore);

							if (saveOrCancel.equalsIgnoreCase("Save")) {
								AddModule_Objects.saveOrCancel = "Save";
								driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel())).click();
							} else {
								AddModule_Objects.saveOrCancel = "Cancel";
								driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel())).click();
							}
						} catch (NoSuchElementException | StaleElementReferenceException ns) {
							ns.getStackTrace();
							System.out.println(
									"Please Fill the Campus details in Map Module/Campus Name entered is not correct");
							AddModule_Objects.saveOrCancel = "Cancel";
							driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel())).click();
						}
					} else
						System.out.println("ManageBookStore not clicked");
				} else {
					System.out.println("User Does not wants to fill the data in bookStore");
				}
				String windowsSetting = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
				if (windowsSetting.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlesquare().sendKeys(pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforsquaretileimage().sendKeys(urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforrectangletileimage().sendKeys(urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
					Log.info("Data has Entered in Courses Module");
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("user has not selected checkbox");

				} else
					System.out.println("Windows Settings not clicked");
				Log.info("Data has Entered In Courses Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddModuleObjects.getClkPublish();
				Thread.sleep(2000);
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
				//Thread.sleep(2000);
			//	Actions action = new Actions(driver);
			//	action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			} else {
				System.out.println("User Have already Created Courses Module");
				Log.info("User Have already Created Courses Module");
			}
		}
	}

	public static void PlistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Courses Module Plist Verification Starts");
		GetLivePlist.generateLiveAppPlist();
		PlistParser.getInstance();
		String isPrivate = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
		String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
		Dictionary module = PlistParser.getInstance().getModule("HomeModule");
		Dictionary[] modules = module.getChildArray("moduleList");
		for (Dictionary dict : modules) {
			String type = dict.getValue("type");
			String PrivateOrPublic = dict.getValue("private");
			String homeScreen = dict.getValue("homeScreen");
			if (type.equals("CoursesRootVC") && isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(PrivateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("CoursesRootVC") && isPrivate.equalsIgnoreCase("No")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(PrivateOrPublic, "false", "PrivateOrPublic does not match sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (isVisible.equalsIgnoreCase("No")) {
				System.out.println("Module is not visible");
			}
			System.out.println("type : " + dict.getValue("type"));
			System.out.println("PrivateOrPublic  : " + dict.getValue("private"));
			System.out.println("Home Screen Visible :" + homeScreen);

		}
		Dictionary dictCourses = PlistParser.getInstance().getModule("CoursesModule");
		if (null == dictCourses) {
			System.out.println("Courses Module not present");
		}
		if (null != dictCourses) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictCourses);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {

				String url = specificVersion.getValue("url");
				System.out.println("url :" + url);
				if (!U.isEmpty(url)) {
					String coursesURL = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(coursesURL, url, "CoursesURL workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String showroster = specificVersion.getValue("rostervisible");
				System.out.println("show roster " + showroster);
				if (!U.isEmpty(showroster)) {
					String showrosterExl = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
					if (showrosterExl.equalsIgnoreCase("Yes")) {
						showrosterExl = "true";
					} else {
						showrosterExl = "false";
					}
					try {
						Assert.assertEquals(showrosterExl, showroster,
								"showroster workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String gradesvisible = specificVersion.getValue("gradesvisible");
				System.out.println("show grades " + gradesvisible);
				if (!U.isEmpty(gradesvisible)) {
					String showgradesExl = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
					if (showgradesExl.equalsIgnoreCase("Yes")) {
						showgradesExl = "true";
					} else {
						showgradesExl = "false";
					}
					try {
						Assert.assertEquals(showgradesExl, gradesvisible,
								"gradesvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String assignmentsvisible = specificVersion.getValue("assignmentsvisible");
				System.out.println("show assignments " + assignmentsvisible);
				if (!U.isEmpty(assignmentsvisible)) {
					String showassignmentsExl = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
					if (showassignmentsExl.equalsIgnoreCase("Yes")) {
						showassignmentsExl = "true";
					} else {
						showassignmentsExl = "false";
					}
					try {
						Assert.assertEquals(showassignmentsExl, assignmentsvisible,
								"assignmentsvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String discussionsvisible = specificVersion.getValue("discussionsvisible");
				System.out.println("show discussions " + discussionsvisible);
				if (!U.isEmpty(discussionsvisible)) {
					String showdiscussionsExl = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
					if (showdiscussionsExl.equalsIgnoreCase("Yes")) {
						showdiscussionsExl = "true";
					} else {
						showdiscussionsExl = "false";
					}
					try {
						Assert.assertEquals(showdiscussionsExl, discussionsvisible,
								"discussionsvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String announcementsvisible = specificVersion.getValue("announcementsvisible");
				System.out.println("show announcements " + announcementsvisible);
				if (!U.isEmpty(announcementsvisible)) {
					String showannouncementsExl = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
					if (showannouncementsExl.equalsIgnoreCase("Yes")) {
						showannouncementsExl = "true";
					} else {
						showannouncementsExl = "false";
					}
					try {
						Assert.assertEquals(showannouncementsExl, announcementsvisible,
								"announcementsvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String assignmentsbuttonvisible = specificVersion.getValue("assignmentsbuttonvisible");
				System.out.println("show assignmentsbutton " + assignmentsbuttonvisible);
				if (!U.isEmpty(assignmentsbuttonvisible)) {
					String showassignmentsbuttonExl = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
					if (showassignmentsbuttonExl.equalsIgnoreCase("Yes")) {
						showassignmentsbuttonExl = "true";
					} else {
						showassignmentsbuttonExl = "false";
					}
					try {
						Assert.assertEquals(showassignmentsbuttonExl, assignmentsbuttonvisible,
								"assignmentsbuttonvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String showDefaultGradeValue = specificVersion.getValue("showDefaultGradeValue");
				System.out.println("show DefaultGradeValue " + showDefaultGradeValue);
				if (!U.isEmpty(showDefaultGradeValue)) {
					String showDefaultGradeValueExl = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
					if (showDefaultGradeValueExl.equalsIgnoreCase("Yes")) {
						showDefaultGradeValueExl = "true";
					} else {
						showDefaultGradeValueExl = "false";
					}
					try {
						Assert.assertEquals(showDefaultGradeValueExl, showDefaultGradeValue,
								"showDefaultGradeValue workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String announcementsbuttonvisible = specificVersion.getValue("announcementsbuttonvisible");
				System.out.println("show announcementsbutton " + announcementsbuttonvisible);
				if (!U.isEmpty(announcementsbuttonvisible)) {
					String showannouncementsbuttonExl = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
					if (showannouncementsbuttonExl.equalsIgnoreCase("Yes")) {
						showannouncementsbuttonExl = "true";
					} else {
						showannouncementsbuttonExl = "false";
					}
					try {
						Assert.assertEquals(showannouncementsbuttonExl, announcementsbuttonvisible,
								"announcementsbuttonvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String purchasedTextbooksvisible = specificVersion.getValue("purchasedTextbooksVisible");
				System.out.println("show announcementsbutton " + purchasedTextbooksvisible);
				if (!U.isEmpty(purchasedTextbooksvisible)) {
					String showpurchasedTextbookExl = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
					if (showpurchasedTextbookExl.equalsIgnoreCase("Yes")) {
						showpurchasedTextbookExl = "true";
					} else {
						showpurchasedTextbookExl = "false";
					}
					try {
						Assert.assertEquals(showpurchasedTextbookExl, purchasedTextbooksvisible,
								"purchasedTextbooksvisible workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String showAvatar = specificVersion.getValue("showAvatar");
				System.out.println("show Avatar " + showAvatar);
				if (!U.isEmpty(showAvatar)) {
					String showAvatarExl = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
					if (showAvatarExl.equalsIgnoreCase("Yes")) {
						showAvatarExl = "true";
					} else {
						showAvatarExl = "false";
					}
					try {
						Assert.assertEquals(showAvatarExl, showAvatar,
								"showAvatar workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {
				String bookstoreURL = specificVersion.getValue("bookstoreURL");
				System.out.println("use CRN " + bookstoreURL);
				if (!U.isEmpty(bookstoreURL)) {
					String bookstoreURLExl = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(bookstoreURLExl, bookstoreURL,
								"bookstoreURL workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String bookstoreActiveTermId = specificVersion.getValue("bookstoreActiveTermId");
				System.out.println("bookstoreActiveTermId " + bookstoreActiveTermId);
				if (!U.isEmpty(bookstoreActiveTermId)) {
					String bookstoreActiveTermIdExl = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(bookstoreActiveTermIdExl, bookstoreActiveTermId,
								"bookstoreActiveTermId workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			if (null != specificVersion) {
				String useCRN = specificVersion.getValue("useCRN");
				System.out.println("use CRN " + useCRN);
				if (!U.isEmpty(useCRN)) {
					String useCRNExl = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
					if (useCRNExl.equalsIgnoreCase("Yes")) {
						useCRNExl = "true";
					} else {
						useCRNExl = "false";
					}
					try {
						Assert.assertEquals(useCRNExl, useCRN, "useCRN workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinnedtiletitlesquare = specificVersion.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :" + pinnedtiletitlesquare);
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(pinnedTitleSquare, pinnedtiletitlesquare,
								"Pinnedtiletitlesquare Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinnedTileTitleRectangle = specificVersion.getValue("displayName");
				if (!U.isEmpty(pinnedTileTitleRectangle)) {
					String pinnedTitleRectangle = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
					System.out.println("PinnedTileTitleRectangle :" + pinnedTileTitleRectangle);
					try {
						Assert.assertEquals(pinnedTitleRectangle, pinnedTileTitleRectangle,
								"PinnedTitleSquare Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlForSquareTileImage = specificVersion.getValue("smallLogoImageUrl");
				if (!U.isEmpty(urlForSquareTileImage)) {
					String pinnedTitleImage = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
					System.out.println("URLForSquareTileImage :" + urlForSquareTileImage);
					try {
						Assert.assertEquals(pinnedTitleImage, urlForSquareTileImage,
								"PinnedTitleImage Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String urlForRectangleTileImage = specificVersion.getValue("wideLogoImageUrl");
				if (!U.isEmpty(urlForRectangleTileImage)) {
					String urlRectangleTileImage = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
					System.out.println("URLForRectangleTileImage :" + urlForRectangleTileImage);
					try {
						Assert.assertEquals(urlRectangleTileImage, urlForRectangleTileImage,
								"UrlRectangleTileImage Workbook data does not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {
				String pinThisModuleToDeviceHomeScreen = specificVersion.getValue("secondaryTileAvailable");
				if (!U.isEmpty(pinThisModuleToDeviceHomeScreen)) {
					String pinThisToDeviceHomeScreen = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
					System.out.println("PinThisModuleToDeviceHomeScreen :" + pinThisModuleToDeviceHomeScreen);
					if (pinThisToDeviceHomeScreen.equalsIgnoreCase("Yes")) {
						try {
							Assert.assertEquals(pinThisModuleToDeviceHomeScreen, "true",
									"PinThisToDeviceHomeScreen  Workbook data does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					} else {
						try {
							Assert.assertEquals(pinThisModuleToDeviceHomeScreen, "false",
									"PinThisToDeviceHomeScreen  Workbook data does not match with pList Data");
						} catch (AssertionError ae) {
							System.out.println(ae.getMessage());
						}
					}
				}

			}

		}
		Log.info("Courses Module Plist Verification Ends");
	}

}
