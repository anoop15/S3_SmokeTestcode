package com.s3.businessLogic;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;
import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AddAdmissionsModule extends Utils {
	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void addAdmissionModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		System.out.println(moduleName);
		if (moduleName.equalsIgnoreCase("Admissions")) {

			AddModule_Objects.moduleName = moduleName;
			boolean b = driver.findElement(By.xpath("//button[@value='" + moduleName + "Module']")).isEnabled();
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Admissions Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen=true;
				Thread.sleep(2000);
				Log.info("Image Replaced");
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
					System.out.println("User Has Not Clicked:-" + "Private Button");
				String isVisible = ExcelUtils.getCellData(1, 9, ExcelFile, ExcelSheetName);
				if (isVisible.equalsIgnoreCase("No")) {
					AddModuleObjects.getClkIsVisible().click();
					System.out.println("User Has Clicked On:-" + "Visible Button" + "Module Not Visible");
				} else
					System.out.println("Admissions Module Is Visible");
				String moduleMainTitle = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getModuleMainTitle().sendKeys(moduleMainTitle);
				String moduleNewLogo = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				AddModuleObjects.getClkModuleLogo().sendKeys(moduleNewLogo);
				String moduleNewAbout = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
				AddModuleObjects.getClkModuleAbout().sendKeys(moduleNewAbout);
				String teamShareUrlTitle = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
				AddModuleObjects.getTeamShareUrlTitle().sendKeys(teamShareUrlTitle);
				String teamShareUrl = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
				AddModuleObjects.getteamShareUrlvalue().sendKeys(teamShareUrl);
				String manageAdmissionTeam = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
				if (manageAdmissionTeam.equalsIgnoreCase("Yes")) {
					//WebElement element = driver.findElement(By("element_path"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView()", AddModuleObjects.getModuleMainTitle()); 
					AddModuleObjects.getManageAdmissionTeam().click();
					Thread.sleep(2000);
					String manageAdmissionTeamName = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamName().sendKeys(manageAdmissionTeamName);
					String manageAdmissionTeamTitle = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamTitle().sendKeys(manageAdmissionTeamTitle);
					String manageAdmissionTeamEmail = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamEmail().sendKeys(manageAdmissionTeamEmail);
					String manageAdmissionTeamPhone = ExcelUtils.getCellData(1, 19, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamPhone().sendKeys(manageAdmissionTeamPhone);
					String manageAdmissionTeamPicUrl = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamPictureUrl().sendKeys(manageAdmissionTeamPicUrl);
					String manageAdmissionTeamAbout = ExcelUtils.getCellData(1, 21, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamAbout().sendKeys(manageAdmissionTeamAbout);
					String saveOrclear = ExcelUtils.getCellData(1, 22, ExcelFile, ExcelSheetName);
					if (saveOrclear.equalsIgnoreCase("Save")) {
						AddModule_Objects.saveOrClear = "Save Team Member";
						driver.findElement(By.xpath(AddModule_Objects.getSaveOrClear())).click();
						String GenXmlOrClose = ExcelUtils.getCellData(1, 23, ExcelFile, ExcelSheetName);
						if (GenXmlOrClose.equalsIgnoreCase("Yes")) {

							AddModule_Objects.genXmlOrClose = "Generate XML";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
							Runtime.getRuntime().exec(Constant.GENERATE_XML);
							Thread.sleep(10000);
							AddModule_Objects.genXmlOrClose = "Close";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();

						} else {
							AddModule_Objects.genXmlOrClose = "Close";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
						}
					} else {
						AddModule_Objects.saveOrClear = "Clear";
						driver.findElement(By.xpath(AddModule_Objects.getSaveOrClear())).click();
					}
				}
				String requestInfoTitle = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
				AddModuleObjects.getRequestInfoTitle().sendKeys(requestInfoTitle);
				String requestInfoEmail = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
				AddModuleObjects.getRequestInfoEmail().sendKeys(requestInfoEmail);
				String requestInfoSub = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
				AddModuleObjects.getRequestInfoSubject().sendKeys(requestInfoSub);
				String secOneAdmTitle = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionOneAdmContenTitle().sendKeys(secOneAdmTitle);
				String secOneAdmCon = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionOneAdmissionContentsectioncontent().sendKeys(secOneAdmCon);
				String secTwoAdmTitle = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionTwoAdmContenTitle().sendKeys(secTwoAdmTitle);
				String secTwoAdmCon = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionTwoAdmissionContentsectioncontent().sendKeys(secTwoAdmCon);
				String secThreeAdmTitle = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionThreeAdmContenTitle().sendKeys(secThreeAdmTitle);
				String secThreeAdmCon = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
				AddModuleObjects.getsectionThreeAdmissionContentsectioncontent().sendKeys(secThreeAdmCon);
				String reqInfoItemAdd = ExcelUtils.getCellData(1, 33, ExcelFile, ExcelSheetName);
				if (reqInfoItemAdd.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkRequestInfoItemsAdd().click();
					String question = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
					AddModuleObjects.getManageAdmTeamTitle().sendKeys(question);
					String requestQuestion = ExcelUtils.getCellData(1, 35, ExcelFile, ExcelSheetName);
					if (requestQuestion.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkRequirdQuestion().click();
					} else
						System.out.println("User Has Not Clicked On :-" + " Request Question");
					String visible = ExcelUtils.getCellData(1, 36, ExcelFile, ExcelSheetName);
					if (visible.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkVisible().click();
					} else
						System.out.println("User Has Not Clicked On :-" + " Visible");
					String prePopulateAnswers = ExcelUtils.getCellData(1, 37, ExcelFile, ExcelSheetName);
					if (prePopulateAnswers.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkPopulated().click();
					} else
						System.out.println("User Has Not Clicked On :-" + " populated");

					String answers = ExcelUtils.getCellData(1, 38, ExcelFile, ExcelSheetName);
					AddModuleObjects.getASFValue().sendKeys(answers);
					String hint = ExcelUtils.getCellData(1, 39, ExcelFile, ExcelSheetName);
					AddModuleObjects.getHint().sendKeys(hint);
					String saveOrcancel = ExcelUtils.getCellData(1, 40, ExcelFile, ExcelSheetName);
					if (saveOrcancel.equalsIgnoreCase("Save")) {
						AddModule_Objects.saveOrCancel = "Save";
						driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel())).click();
					} else {
						AddModule_Objects.saveOrCancel = "Cancel";
						driver.findElement(By.xpath(AddModule_Objects.SaveOrCancel())).click();
					}
				} else
					System.out.println("no Add request");
				String clickWindow8Set = ExcelUtils.getCellData(1, 41, ExcelFile, ExcelSheetName);
				if (clickWindow8Set.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkWindowsSet().click();
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 42, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlesquare().sendKeys(pinnedTitleSquare);
					String pinnedTitleRec = ExcelUtils.getCellData(1, 43, ExcelFile, ExcelSheetName);
					AddModuleObjects.getPinnedtiletitlerectangle().sendKeys(pinnedTitleRec);
					String urlForSquImg = ExcelUtils.getCellData(1, 44, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforsquaretileimage().sendKeys(urlForSquImg);
					String urlForRecImg = ExcelUtils.getCellData(1, 45, ExcelFile, ExcelSheetName);
					AddModuleObjects.getURLforrectangletileimage().sendKeys(urlForRecImg);
					String pinthismoduletodevicehomescreen = ExcelUtils.getCellData(1, 46, ExcelFile, ExcelSheetName);
					if (pinthismoduletodevicehomescreen.equalsIgnoreCase("Yes")) {
						AddModuleObjects.getClkCheckBox().click();
					} else
						System.out.println("User Has Not Selected :-" + "PinThisModuleToDeviceHomescreen");
				} else
					System.out.println("Window8 not clicked");
				Log.info("Data From WorkBook Has Entered In Admissions Module");
				AddModule_Objects.saveOrDiscard = "Save";
				element = driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard()));
				Utils.waitForElementToBeClickable(element);
				element.click();
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			} else {
				System.out.println("User has already created Admission Module");
				Log.warn("User has already created Admission Module");
			}

		}

	}

	public static void parsing(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Xml file Parsing Started for Admissions Module");
		String name = null;
		String title = null;
		String email = null;
		String phone_number = null;
		String enclosureUrl = null;
		String xmlAbout = null;
		String manageAdmissionTeamName = ExcelUtils.getCellData(1, 16, ExcelFile, ExcelSheetName);
		String manageAdmissionTeamTitle = ExcelUtils.getCellData(1, 17, ExcelFile, ExcelSheetName);
		String manageAdmissionTeamEmail = ExcelUtils.getCellData(1, 18, ExcelFile, ExcelSheetName);
		// String manageAdmissionTeamPhone = ExcelUtils.getCellData(1, 19,
		// ExcelFile, ExcelSheetName);
		String manageAdmissionTeamPicUrl = ExcelUtils.getCellData(1, 20, ExcelFile, ExcelSheetName);
		// String manageAdmissionTeamAbout = ExcelUtils.getCellData(1, 21,
		// ExcelFile, ExcelSheetName);

		try {
			File file = new File(Constant.ADMISSIONS_XML_FILE_PATH);
			// Prepare XML
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			System.out.println("Debug: Root element" + document.getDocumentElement().getNodeName());
			NodeList node = document.getElementsByTagName("item");
			System.out.println("item Details");
			System.out.println("________________________________________________");

			// Read XML to get test data
			int j = node.getLength();
			System.out.println(j);
			System.out.println(Node.ELEMENT_NODE);

			for (int i = 0; i < node.getLength(); i++) {
				Node currentNode = node.item(i);

				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) currentNode;
					NodeList nameList = element.getElementsByTagName("name");
					Element elename = (Element) nameList.item(0);
					NodeList nodename = elename.getChildNodes();
					name = ((Node) nodename.item(0)).getNodeValue();
					System.out.println("name:" + name);
					try {
						NodeList titleList = element.getElementsByTagName("title");
						Element titleElement = (Element) titleList.item(0);
						NodeList title1 = titleElement.getChildNodes();
						title = ((Node) title1.item(0)).getNodeValue();
						System.out.println("titleList :" + title);
					} catch (NullPointerException npe) {
						System.out.println("User has not entered title");
					}
					try {
						NodeList emailElementList = element.getElementsByTagName("email");
						Element emailNodeElement = (Element) emailElementList.item(0);
						NodeList nodeemail = emailNodeElement.getChildNodes();
						email = ((Node) nodeemail.item(0)).getNodeValue();
						System.out.println("email : " + email);
					} catch (NullPointerException npe) {
						System.out.println("User has not entered email");
					}
					try {
						NodeList phone_numberList = element.getElementsByTagName("phone_number");
						Element phone_numberElement = (Element) phone_numberList.item(0);
						NodeList phone_numberElement1 = phone_numberElement.getChildNodes();
						phone_number = ((Node) phone_numberElement1.item(0)).getNodeValue();
						System.out.println("phone_number : " + phone_number);
					} catch (NullPointerException npe) {
						System.out.println("User has not entered phone number");
					}

					NodeList enclosure = element.getElementsByTagName("enclosure");
					enclosureUrl = enclosure.item(0).getAttributes().getNamedItem("url").getNodeValue();
					System.out.println(enclosureUrl);

					NodeList about = element.getElementsByTagName("description");
					xmlAbout = about.item(0).getTextContent();
					xmlAbout = xmlAbout.replaceAll("<[^>]+>|&nbsp;", "").trim().replace("[", "").replace("]", "");
					System.out.println("xmlAbout" + xmlAbout);

					if (name.equals(manageAdmissionTeamName)) {
						System.out.println("name is present");
					} else
						System.out.println("not present");
					if (title.equals(manageAdmissionTeamTitle)) {
						System.out.println("title is present");
					} else
						System.out.println("title not present");

					if (email.equals(manageAdmissionTeamEmail)) {
						System.out.println("email is present");
					} else
						System.out.println("email not present");
				}
				if (phone_number.equals(manageAdmissionTeamEmail)) {
					System.out.println("phone_number is present");
				} else
					System.out.println("phone_number not present");
				if (enclosureUrl.equals(manageAdmissionTeamPicUrl)) {
					System.out.println("enclosureUrl is present");
				} else
					System.out.println("enclosureUrl not present");

				if (xmlAbout.equals(manageAdmissionTeamPicUrl)) {
					System.out.println("xmlAbout is present");
				} else
					System.out.println("xmlAbout not present");
				Log.info("Xml file Parsing Ends for Admissions Module");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void layoutSimulatorVarification() {
		String Layout = AddModuleObjects.getVariLayout().getAttribute("class");
		System.out.println("Layout :" + Layout);

	}

	public static void layoutPlistVerification() throws Exception {
		Dictionary dictAdmission = PlistParser.getInstance().getModule("HomeModule");
		Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictAdmission);
		Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
		if (null == specificVersion) {
			specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
		}
		System.out.println("designLayout : " + specificVersion.getValue("designLayout"));
		System.out.println("logo : " + specificVersion.getValue("logo"));
	}

	public static void plistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("PList Parsing Starts for Admissions Module");
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
			if (type.equals("AdmissionsRootVC") && isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(PrivateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("AdmissionsRootVC") && isPrivate.equalsIgnoreCase("No")
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
		Dictionary dictAdmission = PlistParser.getInstance().getModule("AdmissionsModule");
		if (null == dictAdmission) {
			System.out.println("Admission Module not present");
		}
		if (null != dictAdmission) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictAdmission);
			Dictionary specificVersion = PlistParser.getInstance().getDictionary("2.0", versions);
			if (null == specificVersion) {
				specificVersion = PlistParser.getInstance().getDictionary("1.0", versions);
			}
			if (null != specificVersion) {

				String mainTitle = specificVersion.getValue("mainTitle");
				System.out.println("MainTitle :" + mainTitle);
				if (!U.isEmpty(mainTitle)) {
					try {
						String moduleMainTitle = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
						Assert.assertEquals(moduleMainTitle, mainTitle,
								"Module main Title workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
			if (null != specificVersion) {

				String logo = specificVersion.getValue("logo");
				System.out.println("Logo : " + logo);
				if (!U.isEmpty(logo)) {
					try {
						String moduleMainLogo = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
						Assert.assertEquals(moduleMainLogo, logo,
								"Module Main Logo Workbook Data Does Not Match With pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}

				}
			}

			if (null != specificVersion) {

				String aboutText = specificVersion.getValue("aboutText");
				System.out.println("aboutText:" + aboutText);
				if (!U.isEmpty(aboutText)) {
					try {
						String moduleMainAbout = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
						Assert.assertEquals(moduleMainAbout, aboutText,
								"ModuleMainAbout workbook data does not match with pList Data ");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

			}

			Dictionary dictTeamShare = dictAdmission.getChild("teamShareUrl");
			if (null != dictTeamShare) {
				String teamShareUrlTitle = dictTeamShare.getValue("title");
				if (!U.isEmpty(teamShareUrlTitle)) {
					System.out.println("TeamShareUrlTitle : " + teamShareUrlTitle);
					try {
						String MainTeamShareTitle = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
						Assert.assertEquals(MainTeamShareTitle, teamShareUrlTitle,
								"MainTeamShareTitle Workbook Dqta Does Not match With pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String teamShareUrlValue = dictTeamShare.getValue("value");
				if (!U.isEmpty(teamShareUrlValue)) {
					System.out.println(" TeamShareUrlValue:" + teamShareUrlValue);
					try {
						String MainTeamShareUrl = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
						Assert.assertEquals(MainTeamShareUrl, teamShareUrlValue,
								"MainTeamShareUrl Workbook data doed not match with pList Data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			Dictionary dictRequestInfo = dictAdmission.getChild("RequestInfo");
			if (null != dictRequestInfo) {
				String requestInfomationTitle = dictRequestInfo.getValue("title");
				if (!U.isEmpty(requestInfomationTitle)) {
					System.out.println("RequestInfomationTitle :" + requestInfomationTitle);
					String requestInfoTitle = ExcelUtils.getCellData(1, 24, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(requestInfoTitle, requestInfomationTitle,
								"RequestInfoTitle Workbook data does not match with plist data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String requestInfomationEmail = dictRequestInfo.getValue("email");
				if (!U.isEmpty(requestInfomationEmail)) {
					System.out.println("RequestInfomationEmail :" + requestInfomationEmail);
					String requestInfoEmail = ExcelUtils.getCellData(1, 25, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(requestInfoEmail, requestInfomationEmail,
								"RequestInfoEmail Workbook data does not match with plist data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

				String requestInfomationSubject = dictRequestInfo.getValue("subject");
				if (!U.isEmpty(requestInfomationSubject)) {
					System.out.println("RequestInfomationSubject :" + requestInfomationSubject);
					String requestInfoSubject = ExcelUtils.getCellData(1, 26, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(requestInfoSubject, requestInfomationSubject,
								"RequestInfoSubject Workbook data does not match with plist data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			Dictionary dictSectionOne = dictAdmission.getChild("sectionOneAdmissionContent");
			if (null != dictSectionOne) {
				String admissionContentTitle = dictSectionOne.getValue("title");
				if (!U.isEmpty(admissionContentTitle)) {
					System.out.println("SectionOneAdmissionContentTitle :" + admissionContentTitle);
					String secOneAdmCon = ExcelUtils.getCellData(1, 27, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(secOneAdmCon, admissionContentTitle,
								"SectionOneAdmissionContentTitle Workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String admissionContentSectionContent = dictSectionOne.getValue("sectioncontent");
				if (!U.isEmpty(admissionContentSectionContent)) {
					System.out.println("SectionOneAdmissionContentSectionContent :" + admissionContentSectionContent);
					String secOneAdmConContent = ExcelUtils.getCellData(1, 28, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(secOneAdmConContent, admissionContentSectionContent,
								"SectionOneAdmissionContentSectionContent Workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}

			Dictionary dictSectionTwo = dictAdmission.getChild("sectionTwoAdmissionContent");
			if (null != dictSectionTwo) {
				String admissionContentTitle = dictSectionTwo.getValue("title");
				if (!U.isEmpty(admissionContentTitle)) {
					System.out.println("SectionTwoAdmissionContentTitle :" + admissionContentTitle);
					String secTwoAdmConTitle = ExcelUtils.getCellData(1, 29, ExcelFile, ExcelSheetName);
					Assert.assertEquals(secTwoAdmConTitle, admissionContentTitle,
							"SectionTwoAdmissionContentTitle Workbook data does not match with pList data");
				}
				String admissionContentSectionContent = dictSectionTwo.getValue("sectioncontent");
				if (!U.isEmpty(admissionContentSectionContent)) {
					System.out.println("SectionTwoAdmissionContentSectionContent :" + admissionContentSectionContent);
					String secTwoAdmConContent = ExcelUtils.getCellData(1, 30, ExcelFile, ExcelSheetName);
					Assert.assertEquals(secTwoAdmConContent, admissionContentSectionContent,
							"SectionTwoAdmissionContentSectionContent Workbook data does not match with pList data");
				}

			}

			Dictionary dictSectionThree = dictAdmission.getChild("sectionThreeAdmissionContent");
			if (null != dictSectionThree) {
				String admissionContentTitle = dictSectionThree.getValue("title");
				if (!U.isEmpty(admissionContentTitle)) {
					System.out.println("SectionThreeAdmissionContentTitle :" + admissionContentTitle);
					String secThreeAdmConTitle = ExcelUtils.getCellData(1, 31, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(secThreeAdmConTitle, admissionContentTitle,
								"SectionThreeAdmissionContentTitle Workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
				String admissionContentSectionContent = dictSectionThree.getValue("sectioncontent");
				if (!U.isEmpty(admissionContentSectionContent)) {

					System.out.println("SectionThreeAdmissionContentSectionContent :" + admissionContentSectionContent);
					String secThreeAdmConContent = ExcelUtils.getCellData(1, 32, ExcelFile, ExcelSheetName);
					try {
						Assert.assertEquals(secThreeAdmConContent, admissionContentSectionContent,
								"SectionThreeAdmissionContentSectionContent Workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}

			}

			Dictionary requetInfoItems = PlistParser.getInstance().getModule("AdmissionsModule");
			Dictionary[] requestInformationItems = requetInfoItems.getChildArray("RequestInfoItems");
			if (null != requestInformationItems) {
				for (Dictionary dict1 : requestInformationItems) {
					if (null != requestInformationItems) {
						String title = dict1.getValue("title");
						if (!U.isEmpty(title)) {
							System.out.println("Title :" + title);
							String question = ExcelUtils.getCellData(1, 34, ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(question, title,
										"RequestInformationItemsQuestion Workbook Data Does not match with pList Data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}
					if (null != requestInformationItems) {
						String require = dict1.getValue("require");
						if (!U.isEmpty(require)) {
							System.out.println("Require :" + require);
							String requireQuestion = ExcelUtils.getCellData(1, 35, ExcelFile, ExcelSheetName);
							if (requireQuestion.equalsIgnoreCase("Yes")) {
								try {
									Assert.assertEquals(require, "true",
											"RequireQuestion Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							} else {
								try {
									Assert.assertEquals(require, "false",
											"RequireQuestion Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							}
						}
					}
					if (null != requestInformationItems) {
						String isvisible = dict1.getValue("visible");
						if (!U.isEmpty(isvisible)) {
							System.out.println("Visible1 :" + isvisible);
							String requireVisible = ExcelUtils.getCellData(1, 36, ExcelFile, ExcelSheetName);
							if (requireVisible.equalsIgnoreCase("Yes")) {
								try {
									Assert.assertEquals(isvisible, "true",
											"RequireVisible Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							} else {
								try {
									Assert.assertEquals(isvisible, "false",
											"RequireVisible Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							}
						}
					}
					if (null != requestInformationItems) {
						String populated = dict1.getValue("populated");
						if (!U.isEmpty(populated)) {
							System.out.println("Populated :" + populated);
							String requirePopulated = ExcelUtils.getCellData(1, 37, ExcelFile, ExcelSheetName);
							if (requirePopulated.equalsIgnoreCase("Yes")) {
								try {
									Assert.assertEquals(populated, "true",
											"RequirePopulated Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							} else {
								try {
									Assert.assertEquals(populated, "false",
											"RequirePopulated Workbook data does not match with pList Data");
								} catch (AssertionError ae) {
									System.out.println(ae.getMessage());
								}
							}
						}
					}
					if (null != requestInformationItems) {
						String answers = dict1.getValue("value");
						if (!U.isEmpty(answers)) {
							System.out.println("Answers :" + answers);
							String requireAnswers = ExcelUtils.getCellData(1, 38, ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(requireAnswers, answers,
										"RequireAnswers Workbook data does not match with pList Data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}

					if (null != requestInformationItems) {
						String hint = dict1.getValue("hint");
						if (!U.isEmpty(hint)) {
							System.out.println("Hint :" + hint);
							String requireHint = ExcelUtils.getCellData(1, 39, ExcelFile, ExcelSheetName);
							try {
								Assert.assertEquals(requireHint, hint,
										"RequireHint Workbook data does not match with pList Data");
							} catch (AssertionError ae) {
								System.out.println(ae.getMessage());
							}
						}
					}

				}
			}
			if (null != specificVersion) {
				String pinnedtiletitlesquare = specificVersion.getValue("shortName");
				if (!U.isEmpty(pinnedtiletitlesquare)) {
					System.out.println("Pinnedtiletitlesquare :" + pinnedtiletitlesquare);
					String pinnedTitleSquare = ExcelUtils.getCellData(1, 42, ExcelFile, ExcelSheetName);
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
					String pinnedTitleRectangle = ExcelUtils.getCellData(1, 43, ExcelFile, ExcelSheetName);
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
					String pinnedTitleImage = ExcelUtils.getCellData(1, 44, ExcelFile, ExcelSheetName);
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
					String urlRectangleTileImage = ExcelUtils.getCellData(1, 45, ExcelFile, ExcelSheetName);
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
					String pinThisToDeviceHomeScreen = ExcelUtils.getCellData(1, 46, ExcelFile, ExcelSheetName);
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
		Log.info("PList Parsing Ends for Admissions Module");
	}
}
