package com.s3.businessLogic;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.openqa.selenium.By;
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

public class AddImageGalleryModule extends Utils {

	private static WebElement element = null;
	static AddModule_Objects AddModuleObjects;
	public static String url;

	public static void AddImagesGalleryModuleLogic(int row, int col, String ExcelFile, String ExcelSheetName)
			throws Exception {
		AddModuleObjects = PageFactory.initElements(driver, AddModule_Objects.class);
		element = AddModuleObjects.getClkAddModule();
		Utils.waitForElementToBeClickable(element);
		element.click();
		Log.info("Add Button Clicked for Image Gallery module");
		String moduleName = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		System.out.println(moduleName);
		if (moduleName.equalsIgnoreCase("ImagesGallery") || moduleName.equalsIgnoreCase("Image Gallery")) {

			AddModule_Objects.moduleName = "Image Gallery";
			boolean b = driver.findElement(By.xpath("//button[@value='ImagesGalleryModule']")).isEnabled();
			if (b) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath(AddModule_Objects.getAddModuleName())).click();
				Log.info("Image Gallery module Button Clicked");
				element = driver.findElement(By.xpath("//img[@id='module-icon']//following-sibling::div"));
				Utils.waitForElementToBeClickable(element);
				element.click();
				String image = Constant.REPLACE_IMAGE;
				ModuleReplaceIcon.ReplaceImage(image);
				ModuleReplaceIcon.JavaAppOpen = true;
				Thread.sleep(2000);
				Log.info("Image Replace For Image Gallery module Done");
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
					System.out.println("visible");
				String imageUrl = ExcelUtils.getCellData(1, 10, ExcelFile, ExcelSheetName);
				AddModuleObjects.getImageUrl().sendKeys(imageUrl);
				String manageImages = ExcelUtils.getCellData(1, 11, ExcelFile, ExcelSheetName);
				if (manageImages.equalsIgnoreCase("Yes")) {
					AddModuleObjects.getClkManageImages().click();
					String imageTitle = ExcelUtils.getCellData(1, 12, ExcelFile, ExcelSheetName);
					AddModuleObjects.getClkImageTitle().sendKeys(imageTitle);
					String imageURL = ExcelUtils.getCellData(1, 13, ExcelFile, ExcelSheetName);
					AddModuleObjects.getClkPopUpImageUrl().sendKeys(imageURL);
					String saveImage = ExcelUtils.getCellData(1, 14, ExcelFile, ExcelSheetName);
					if (saveImage.equalsIgnoreCase("Save")) {
						AddModuleObjects.getClkSaveImage().click();
						String genXmlOrClose = ExcelUtils.getCellData(1, 15, ExcelFile, ExcelSheetName);
						if (genXmlOrClose.equalsIgnoreCase("Yes")) {

							AddModule_Objects.genXmlOrClose = "Generate XML";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
							Thread.sleep(3000);
							if(Pattern.compile(Pattern.quote(Constant.BROWSER_NAME), Pattern.CASE_INSENSITIVE).matcher("Firefox").find());
							AddDiningHallModule.generateVCF();
							//Runtime.getRuntime().exec(Constant.GENERATE_XML);
							Thread.sleep(3000);
							AddModule_Objects.genXmlOrClose = "Cancel";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();

						} else {
							AddModule_Objects.genXmlOrClose = "Cancel";
							driver.findElement(By.xpath(AddModule_Objects.getGenXmlOrClose())).click();
						}
					} else {
						AddModule_Objects.saveOrClear = "Clear";
						driver.findElement(By.xpath(AddModule_Objects.getSaveOrClear())).click();
					}
				}

				AddModule_Objects.saveOrDiscard = "Save";
				driver.findElement(By.xpath(AddModule_Objects.SaveOrDiscard())).click();
				Thread.sleep(3000);
				element = AddModuleObjects.getClkPublish();
				Utils.waitForElementToBeClickable(element);
				element.click();
				AddModuleObjects.getClkPublishPopUp().click();
			//	Actions action = new Actions(driver);
			//	action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
			} else {
				System.out.println("Images Gallery Module Already created");
				Log.info("Image Gallery module Already Created");

			}
		}
	}

	public static void PlistVerification(int row, int col, String ExcelFile, String ExcelSheetName) throws Exception {
		Log.info("Image Gallery module Plist Verification Starts");
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
			if (type.equals("ImagesGalleryRootVC") && isPrivate.equalsIgnoreCase("Yes")
					&& isVisible.equalsIgnoreCase("Yes")) {
				try {
					Assert.assertEquals(privateOrPublic, "true", "PrivateOrPublic does not match with sheet data");
				} catch (AssertionError ae) {
					System.out.println(ae.getMessage());
				}
			} else if (type.equals("ImagesGalleryRootVC") && isPrivate.equalsIgnoreCase("No")
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
			System.out.println("Home Screen Visible :" + homeScreen);

		}
		Dictionary dictImageGallery = PlistParser.getInstance().getModule("ImagesGalleryModule");
		if (null == dictImageGallery) {
			System.out.println("ImagesGalleryModule not present");
		}
		if (null != dictImageGallery) {
			Dictionary versions = PlistParser.getInstance().getDictionary("versions", dictImageGallery);
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
						Assert.assertEquals(urlExl, url, "url workbook data does not match with pList data");
					} catch (AssertionError ae) {
						System.out.println(ae.getMessage());
					}
				}
			}
		}
		Log.info("Image Gallery module Plist Verification Ends");
	}

	public static void xmlParser(int row, int col, String ExcelFile, String ExcelSheetName) {
		String title = null;
		String url = null;

		try {
			File file = new File(Constant.IMAGEGALLERY_XML_FILE_PATH);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			System.out.println("Debug: Root element" + document.getDocumentElement().getNodeName());
			NodeList node = document.getElementsByTagName("gallery");
			System.out.println("gallery Details");
			System.out.println("________________________________________________");
			// Read XML to get test data
			// int j=node.getLength();
			// System.out.println(j);
			System.out.println(Node.ELEMENT_NODE);
			for (int i = 0; i < node.getLength(); i++) {
				Node currentNode = node.item(i);
				Log.info("Image Gallery module XML Parser Starts");
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) currentNode;
					try {
						NodeList titleLst = element.getElementsByTagName("title");
						Element elename = (Element) titleLst.item(0);
						NodeList nodename = elename.getChildNodes();
						title = ((Node) nodename.item(0)).getNodeValue();
						System.out.println("title:" + title);
					} catch (NullPointerException npe) {
						System.out.println("User has not entered Title");
					}
					try {
						NodeList imageurl = element.getElementsByTagName("url");
						Element urlElement = (Element) imageurl.item(0);
						NodeList listurl = urlElement.getChildNodes();
						url = ((Node) listurl.item(0)).getNodeValue();
						System.out.println("URL :" + url);
					} catch (NullPointerException npe) {
						System.out.println("User has not entered Url");
					}

				}
				Log.info("Image Gallery module XML Parser Ends");
			}

		} catch (Exception e) {
			e.getStackTrace();
			Log.info("Image Gallery module XML Parser Exception Found");
		}
	}

}
