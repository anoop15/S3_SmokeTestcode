package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRssModule_Object {

	public static String appName;
	public static String moduleName;
	public static String saveOrDiscard;
	public static String saveOrCancel;

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

	public static String SaveOrDiscard() {
		return "//button[text()='" + saveOrDiscard + "']";
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

	public static String ClkRss() {
		return "//button[@data-dub_home_group_key='RSSFeedModule']//preceding-sibling::div";
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

	@FindBy(how = How.ID, using = "imageurl")
	private WebElement ImageUrl;

	public WebElement getImageUrl() {
		return ImageUrl;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='mobileready']")
	private WebElement ClkMobileReady;

	public WebElement getClkMobileReady() {
		return ClkMobileReady;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='collapseall']")
	private WebElement ClkCollapseall;

	public WebElement getClkCollapseall() {
		return ClkCollapseall;
	}

	@FindBy(how = How.ID, using = "moduleDelete")
	private WebElement ClkModuleDelete;

	public WebElement getClkModuleDelete() {
		return ClkModuleDelete;
	}

	@FindBy(how = How.ID, using = "Items")
	private WebElement ClkAddFeed;

	public WebElement getClkAddFeed() {
		return ClkAddFeed;
	}

	@FindBy(how = How.ID, using = "title")
	private WebElement ClkFeedTitle;

	public WebElement getClkFeedTitle() {
		return ClkFeedTitle;
	}

	@FindBy(how = How.ID, using = "url")
	private WebElement ClkATOMUrl;

	public WebElement getClkATOMUrl() {
		return ClkATOMUrl;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Login Required']//following-sibling::div/label")
	private WebElement ClkLoginReq;

	public WebElement getClkLoginReq() {
		return ClkLoginReq;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Enabled']//following-sibling::div/label")
	private WebElement ClkEnabled;

	public WebElement getClkEnabled() {
		return ClkEnabled;
	}

	public static String SaveOrCancel() {
		return "//div[@class='popupBars popupFooter']//button[text()='"
				+ saveOrCancel + "']";
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Advanced']")
	private WebElement ClkAdvanced;

	public WebElement getClkAdvanced() {
		return ClkAdvanced;
	}

	@FindBy(how = How.ID, using = "sortType")
	private WebElement SelSortType;

	public WebElement getSelSortType() {
		return SelSortType;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='displayRSSDetailsPage']")
	private WebElement ClkDisRSSDetails;

	public WebElement getClkDisRSSDetails() {
		return ClkDisRSSDetails;
	}

	@FindBy(how = How.ID, using = "rssWindowDays")
	private WebElement rssWindowDays;

	public WebElement getrssWindowDays() {
		return rssWindowDays;
	}

	@FindBy(how = How.ID, using = "eventsWindowDays")
	private WebElement eventsWindowDays;

	public WebElement geteventsWindowDays() {
		return eventsWindowDays;
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Windows 8 Settings']")
	private WebElement ClkWindowsSet;

	public WebElement getClkWindowsSet() {
		return ClkWindowsSet;
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

	@FindBy(how = How.XPATH, using = "//label[@for='notificationAvailable']")
	private WebElement ClkNotiAvail;

	public WebElement getClkNotiAvail() {
		return ClkNotiAvail;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='secondaryTileAvailable']")
	private WebElement ClkCheckBox;

	public WebElement getClkCheckBox() {
		return ClkCheckBox;
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
