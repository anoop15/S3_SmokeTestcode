package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddWebModule_Objects {
	public static String appName;
	public static String moduleName;
	public static String saveOrDiscard;

	@FindBy(how = How.ID, using = "search")
	private WebElement Search;

	public WebElement getSearch() {
		return Search;
	}

	public static String getClkMyApp() {
		return "//ul[@id='apps-list']//li[@class='" + appName
				+ "']//preceding-sibling::a";
	}

	public static String getVariAppName() {
		return "//span[text()='" + appName + "']";
	}

	public static String VariAppanmeSam() {
		return "//div[text()='" + appName + "']";
	}

	@FindBy(how = How.ID, using = "app-new-module")
	private WebElement ClkAddModule;

	public WebElement getClkAddModule() {
		return ClkAddModule;
	}

	public static String getAddModuleName() {
		return "//div[@id='dub-modules-content']//p[text()='" + moduleName
				+ "']//preceding-sibling::div";
	}

	@FindBy(how = How.ID, using = "moduleName")
	private WebElement EditModule;

	public WebElement getEditModule() {
		return EditModule;
	}

	@FindBy(how = How.ID, using = "moduleCategory")
	private WebElement EditModuleCategory;

	public WebElement getEditModuleCategory() {
		return EditModuleCategory;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='moduleIsPrivate']")
	private WebElement ClkPrivate;

	public WebElement getClkPrivate() {
		return ClkPrivate;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='moduleIsVisible']")
	private WebElement ClkIsVisible;

	public WebElement getClkIsVisible() {
		return ClkIsVisible;
	}

	@FindBy(how = How.ID, using = "moduleDelete")
	private WebElement ClkModuleDelete;

	public WebElement getClkModuleDelete() {
		return ClkModuleDelete;
	}

	@FindBy(how = How.ID, using = "url")
	private WebElement URLAdmittedly;

	public WebElement getURLAdmittedly() {
		return URLAdmittedly;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='mobileready']")
	private WebElement ClkMobileReady;

	public WebElement getClkMobileReady() {
		return ClkMobileReady;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='mobileReadyNavigation']")
	private WebElement ClkMobileReadyNavigation;

	public WebElement getClkMobileReadyNavigation() {
		return ClkMobileReadyNavigation;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='mobileReadyHeader']")
	private WebElement ClkMobileReadyHeader;

	public WebElement getClkMobileReadyHeader() {
		return ClkMobileReadyHeader;
	}

	@FindBy(how = How.ID, using = "imageurl")
	private WebElement ClkImageUrl;

	public WebElement getClkImageUrl() {
		return ClkImageUrl;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='openInNativeBrowser']")
	private WebElement ClkOpenInNativeBrowser;

	public WebElement getOpenInNativeBrowser() {
		return ClkOpenInNativeBrowser;
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Windows 8 Settings']")
	private WebElement ClkWindowsSet;

	public WebElement getClkWindowsSet() {
		return ClkWindowsSet;
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Advanced']")
	private WebElement ClkAdvanced;

	public WebElement getClkAdvanced() {
		return ClkAdvanced;
	}

	@FindBy(how = How.ID, using = "shortName")
	private WebElement Pinnedtiletitlesquare;

	public WebElement getPinnedtiletitlesquare() {
		return Pinnedtiletitlesquare;
	}

	@FindBy(how = How.ID, using = "displayName")
	private WebElement Pinnedtiletitlerectangle;

	public WebElement getPinnedtiletitlerectangle() {
		return Pinnedtiletitlerectangle;
	}

	@FindBy(how = How.ID, using = "smallLogoImageUrl")
	private WebElement URLforsquaretileimage;

	public WebElement getURLforsquaretileimage() {
		return URLforsquaretileimage;
	}

	@FindBy(how = How.ID, using = "wideLogoImageUrl")
	private WebElement URLforrectangletileimage;

	public WebElement getURLforrectangletileimage() {
		return URLforrectangletileimage;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='secondaryTileAvailable']")
	private WebElement ClkCheckBox;

	public WebElement getClkCheckBox() {
		return ClkCheckBox;
	}

	public static String SaveOrDiscard() {
		return "//button[text()='" + saveOrDiscard + "']";
	}

	@FindBy(how = How.ID, using = "publishBtn")
	private WebElement ClkPublish;

	public WebElement getClkPublish() {
		return ClkPublish;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='popup']//button[text()='Publish']")
	private WebElement ClkPublishPopUp;

	public WebElement getClkPublishPopUp() {
		return ClkPublishPopUp;
	}

}
