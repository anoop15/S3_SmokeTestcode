package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddModule_Objects {

	public static String appName;
	public static String moduleName;
	public static String saveOrClear;
	public static String genXmlOrClose;
	public static String saveOrDiscard;
	public static String saveOrCancel;
	public static String publishOrPreview;
	public static String deleteOrCancel;

	@FindBy(how = How.ID, using = "search")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	public static String getClkMyApp() {
		return "//ul[@id='apps-list']//li[@class='" + appName
				+ "']//preceding-sibling::a";
	}

	public static String getClkMyAppUserType() {
		return "//ul[@id='apps-list']//li[@class='" + appName
				+ "']//preceding-sibling::h3";
	}

	public static String getVariAppName() {
		return "//span[text()='" + appName + "']";
	}

	public static String variAppanmeSam() {
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

	@FindBy(how = How.XPATH, using = "//nav[@id='app-floating-header']//following::button[@id='publishBtn']")
	private WebElement ClkPublish;
	public WebElement getClkPublish() {
		return ClkPublish;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='popup']//button[text()='Publish']")
	private WebElement ClkPublishPopUp;

	public WebElement getClkPublishPopUp() {
		return ClkPublishPopUp;
	}
	
	@FindBy(how = How.ID, using = "moduleName")
	private WebElement EditModule;

	public WebElement getEditModule() {
		return EditModule;
	}

	public static String getCopyApp() {
		return "//ul[@id='apps-list']//li[contains(@class,'" + appName
				+ "')]//div[@class='app-actions']/img[@title='Copy App']";
	}

	public static String getDeleteApp() {
		return "//ul[@id='apps-list']//li[contains(@class,'" + appName
				+ "')]//div[@class='app-actions']/img[@title='Delete App']";
	}

	public static String getDeleteOrCancel() {
		return "//div[@id='popup']//button[text()='" + deleteOrCancel + "']";
	}

	@FindBy(how = How.CLASS_NAME, using = "dub-font-bold")
	private WebElement NoResult;

	public WebElement getNoResult() {
		return NoResult;
	}

	@FindBy(how = How.ID, using = "AppName")
	private WebElement ApplicationName;

	public WebElement getApplicationName() {
		return ApplicationName;
	}

	@FindBy(how = How.ID, using = "displayPartnerId")
	private WebElement EditPartnerName;

	public WebElement getEditPartnerName() {
		return EditPartnerName;
	}

	@FindBy(how = How.ID, using = "displayClientId")
	private WebElement EditClientName;

	public WebElement getEditClientName() {
		return EditClientName;
	}

	@FindBy(how = How.ID, using = "displayAppFigures")
	private WebElement DisplayAppFigures;

	public WebElement getDisplayAppFigures() {
		return DisplayAppFigures;
	}

	public static String getEditApp() {
		return "//ul[@id='apps-list']//li[contains(@class,'" + appName
				+ "')]//div[@class='app-actions']/img[@title='Edit App']";
	}

	@FindBy(how = How.ID, using = "moduleCategory")
	private WebElement EditModuleCategory;

	public WebElement getEditModuleCategory() {
		return EditModuleCategory;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Style']")
	private WebElement ClkStyle;

	public WebElement getClkStyle() {
		return ClkStyle;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Modules']")
	private WebElement ClkModules;

	public WebElement getClkModules() {
		return ClkModules;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='moduleIsPrivate']")
	private WebElement ClkPrivate;

	public WebElement getClkPrivate() {
		return ClkPrivate;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='gridViewLayout']")
	private WebElement ClkgridViewLayout;

	public WebElement getClkgridViewLayout() {
		return ClkgridViewLayout;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='listViewLayout']")
	private WebElement ClklistViewLayout;

	public WebElement getClklistViewLayout() {
		return ClklistViewLayout;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='sideBarLayout']")
	private WebElement ClksideBarLayout;

	public WebElement getClksideBarLayout() {
		return ClksideBarLayout;
	}

	@FindBy(how = How.ID, using = "menu-container")
	private WebElement VariLayout;

	public WebElement getVariLayout() {
		return VariLayout;
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

	@FindBy(how = How.ID, using = "mainTitle")
	private WebElement ModuleMainTitle;

	public WebElement getModuleMainTitle() {
		return ModuleMainTitle;
	}

	@FindBy(how = How.CLASS_NAME, using = "image-input-overlay")
	private WebElement ClkImage;

	public WebElement getClkImage() {
		return ClkImage;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='module-icon']")
	private WebElement ClkModuleIcon;

	public WebElement getClkModuleIcon() {
		return ClkModuleIcon;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Live App Plist']//following-sibling::a[1]")
	private WebElement ClkLiveAppPlist;

	public WebElement getClkLiveAppPlist() {
		return ClkLiveAppPlist;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Live App Plist']//following-sibling::a[2]")
	private WebElement ClkLiveAppPlistMulti;

	public WebElement ClkLiveAppPlistMulti() {
		return ClkLiveAppPlistMulti;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Test Plist']//following-sibling::a[1]")
	private WebElement ClkTestPlist;

	public WebElement getClkTestPlist() {
		return ClkTestPlist;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='style-navbar-image']//following-sibling::div")
	private WebElement ClkNavigationHeaderBarImage;

	public WebElement ClkNavigationHeaderBarImage() {
		return ClkNavigationHeaderBarImage;
	}

	@FindBy(how = How.ID, using = "svn-name")
	private WebElement SVNName;

	public WebElement getSVNName() {
		return SVNName;
	}

	@FindBy(how = How.CLASS_NAME, using = "image-center-list")
	private WebElement ClkNavigationBarImageList;

	public WebElement ClkNavigationBarImageList() {
		return ClkNavigationBarImageList;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='style-app-icon']//following-sibling::div")
	private WebElement ClkBrandIdentityAppIcon;

	public WebElement ClkBrandIdentityAppIcon() {
		return ClkBrandIdentityAppIcon;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='style-splash-image']//following-sibling::div")
	private WebElement ClkBrandIdentityLaunchImage;

	public WebElement ClkBrandIdentityLaunchImage() {
		return ClkBrandIdentityLaunchImage;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='style-module-background']//following-sibling::div")
	private WebElement ClkBrandIdentityModuleBackground;

	public WebElement ClkBrandIdentityModuleBackground() {
		return ClkBrandIdentityModuleBackground;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='style-home-background']//following-sibling::div")
	private WebElement ClkBrandIdentityHomeBackground;

	public WebElement ClkBrandIdentityHomeBackground() {
		return ClkBrandIdentityHomeBackground;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='file-drop-area']")
	private WebElement ClkReplaceImage;

	public WebElement getClkReplaceImage() {
		return ClkReplaceImage;
	}

	@FindBy(how = How.ID, using = "dubAnalytic")
	private WebElement ClkInfoAnalytic;

	public WebElement getClkInfoAnalytic() {
		return ClkInfoAnalytic;
	}

	@FindBy(how = How.ID, using = "organization")
	private WebElement ClkInfoOrganization;

	public WebElement getClkInfoOrganization() {
		return ClkInfoOrganization;
	}

	@FindBy(how = How.ID, using = "serviceTag")
	private WebElement ClkInfoServiceTag;

	public WebElement getClkInfoServiceTag() {
		return ClkInfoServiceTag;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='displayAboutDubLabs']")
	private WebElement ClkInfoDisplayAboutDubLabs;

	public WebElement getClkInfoDisplayAboutDubLabs() {
		return ClkInfoDisplayAboutDubLabs;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='url']")
	private WebElement ImageUrl;

	public WebElement getImageUrl() {
		return ImageUrl;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Manage Images']")
	private WebElement ClkManageImages;

	public WebElement getClkManageImages() {
		return ClkManageImages;
	}

	@FindBy(how = How.ID, using = "imageTitle")
	private WebElement ClkImageTitle;

	public WebElement getClkImageTitle() {
		return ClkImageTitle;
	}

	@FindBy(how = How.ID, using = "appShareUrl.title")
	private WebElement ClkInfoAppDownloadPagetitle;

	public WebElement getClkInfoAppDownloadPagetitle() {
		return ClkInfoAppDownloadPagetitle;
	}

	@FindBy(how = How.ID, using = "appShareUrl.value")
	private WebElement ClkInfoAppDownloadPageUrl;

	public WebElement getClkInfoAppDownloadPageUrl() {
		return ClkInfoAppDownloadPageUrl;
	}

	@FindBy(how = How.ID, using = "appShareUrl.valueAndroid")
	private WebElement ClkInfoAndroidDownloadURL;

	public WebElement getClkInfoAndroidDownloadURL() {
		return ClkInfoAndroidDownloadURL;
	}

	@FindBy(how = How.ID, using = "appShareUrl.valueBB")
	private WebElement ClkInfoBlackberryDownloadURL;

	public WebElement getClkInfoBlackberryDownloadURL() {
		return ClkInfoBlackberryDownloadURL;
	}

	@FindBy(how = How.ID, using = "appShareUrl.valueiPhone")
	private WebElement ClkInfoiPhoneDownloadURL;

	public WebElement getClkInfoiPhoneDownloadURL() {
		return ClkInfoiPhoneDownloadURL;
	}

	@FindBy(how = How.ID, using = "shareThisAppContent")
	private WebElement ClkInfoShareThisAppContent;

	public WebElement getClkInfoShareThisAppContent() {
		return ClkInfoShareThisAppContent;
	}

	@FindBy(how = How.ID, using = "contactPhone.title")
	private WebElement ClkInfoPhoneNumberTitle;

	public WebElement getClkInfoPhoneNumberTitle() {
		return ClkInfoPhoneNumberTitle;
	}

	@FindBy(how = How.ID, using = "contactPhone.value")
	private WebElement ClkInfoPhoneNumberValue;

	public WebElement getClkInfoPhoneNumberValue() {
		return ClkInfoPhoneNumberValue;
	}

	@FindBy(how = How.ID, using = "supportEmail.title")
	private WebElement ClkInfoEmailTitle;

	public WebElement getClkInfoEmailTitle() {
		return ClkInfoEmailTitle;
	}

	@FindBy(how = How.ID, using = "supportEmail.value")
	private WebElement ClkInfoEmailValue;

	public WebElement getClkInfoEmailValue() {
		return ClkInfoEmailValue;
	}

	@FindBy(how = How.ID, using = "supportUrl.title")
	private WebElement ClkInfoSupportURLTitle;

	public WebElement getClkInfoSupportURLTitle() {
		return ClkInfoSupportURLTitle;
	}

	@FindBy(how = How.ID, using = "sidebarDefaultModulePicker")
	private WebElement ClkSettingDefaultModulePicker;

	public WebElement getClkSettingDefaultModulePicker() {
		return ClkSettingDefaultModulePicker;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='UserLayoutOverride']")
	private WebElement ClkSettingUsersConfigureLayout;

	public WebElement getClkSettingUsersConfigureLayout() {
		return ClkSettingUsersConfigureLayout;
	}

	@FindBy(how = How.ID, using = "appleStoreUrl")
	private WebElement ClkSettingRateAppAppleURL;

	public WebElement getClkSettingRateAppAppleURL() {
		return ClkSettingRateAppAppleURL;
	}

	@FindBy(how = How.ID, using = "androidStoreUrl")
	private WebElement ClkSettingRateAppAndroidURL;

	public WebElement getClkSettingRateAppAndroidURL() {
		return ClkSettingRateAppAndroidURL;
	}

	@FindBy(how = How.ID, using = "windowsStoreUrl")
	private WebElement ClkSettingRateAppWindowsURL;

	public WebElement getClkSettingRateAppWindowsURL() {
		return ClkSettingRateAppWindowsURL;
	}

	@FindBy(how = How.ID, using = "help")
	private WebElement ClkSettingHelpText;

	public WebElement getClkSettingHelpText() {
		return ClkSettingHelpText;
	}

	@FindBy(how = How.ID, using = "info")
	private WebElement ClkSettingInfoText;

	public WebElement getClkSettingInfoText() {
		return ClkSettingInfoText;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Save Image']")
	private WebElement ClkSaveImage;

	public WebElement getClkSaveImage() {
		return ClkSaveImage;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='autologout']")
	private WebElement ClkSettingEnableAutomaticLogout;

	public WebElement getClkSettingEnableAutomaticLogout() {
		return ClkSettingEnableAutomaticLogout;
	}

	@FindBy(how = How.ID, using = "ssoUrl")
	private WebElement ClkSettingSSOUrl;

	public WebElement getClkSettingSSOUrl() {
		return ClkSettingSSOUrl;
	}

	@FindBy(how = How.ID, using = "notif-url")
	private WebElement ClkSettingNotificationsURL;

	public WebElement getClkSettingNotificationsURL() {
		return ClkSettingNotificationsURL;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='NotificationsModule']")
	private WebElement ClkSettingManageNotifications;

	public WebElement getClkSettingManageNotifications() {
		return ClkSettingManageNotifications;
	}
	
	@FindBy(how = How.XPATH, using = "//button[@id='url']")
	private WebElement ClkSettingManageNotifications1;

	public WebElement getClkSettingManageNotifications1() {
		return ClkSettingManageNotifications1;
	}

	@FindBy(how = How.ID, using = "pushregisterurl")
	private WebElement ClkSettingNotificationsPushURL;

	public WebElement getClkSettingNotificationsPushURL() {
		return ClkSettingNotificationsPushURL;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='private']")
	private WebElement ClkSettingLoginRequired;

	public WebElement getClkSettingLoginRequired() {
		return ClkSettingLoginRequired;
	}

	@FindBy(how = How.ID, using = "notifDate")
	private WebElement ClkSettingNotificationsDate;

	public WebElement getClkSettingNotificationsDate() {
		return ClkSettingNotificationsDate;
	}

	@FindBy(how = How.ID, using = "notifTime")
	private WebElement ClkSettingNotificationsTime;

	public WebElement getClkSettingNotificationsTime() {
		return ClkSettingNotificationsTime;
	}

	@FindBy(how = How.ID, using = "supportUrl.value")
	private WebElement ClkInfoSupportURLValue;

	public WebElement getClkInfoSupportURLValue() {
		return ClkInfoSupportURLValue;
	}

	@FindBy(how = How.ID, using = "notifSubject")
	private WebElement ClkSettingNotificationsSubject;

	public WebElement getClkSettingNotificationsSubject() {
		return ClkSettingNotificationsSubject;
	}

	@FindBy(how = How.ID, using = "notifContent")
	private WebElement ClkSettingNotificationsContent;

	public WebElement getClkSettingNotificationsContent() {
		return ClkSettingNotificationsContent;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Save Notification']")
	private WebElement ClkSettingNotificationsSave;

	public WebElement getClkSettingNotificationsSave() {
		return ClkSettingNotificationsSave;
	}

	@FindBy(how = How.ID, using = "notifLinkTitle")
	private WebElement ClkSettingNotificationsAttachmentTitle;

	public WebElement getClkSettingNotificationsAttachmentTitle() {
		return ClkSettingNotificationsAttachmentTitle;
	}

	@FindBy(how = How.ID, using = "notifLink")
	private WebElement ClkSettingNotificationsAttachmentLink;

	public WebElement getClkSettingNotificationsAttachmentLink() {
		return ClkSettingNotificationsAttachmentLink;
	}

	@FindBy(how = How.ID, using = "fullWebsiteUrl.title")
	private WebElement ClkInfoFullWebsiteURLTitle;

	public WebElement getClkInfoFullWebsiteURLTitle() {
		return ClkInfoFullWebsiteURLTitle;
	}

	@FindBy(how = How.ID, using = "fullWebsiteUrl.value")
	private WebElement ClkInfoFullWebsiteURLValue;

	public WebElement getClkInfoFullWebsiteURLValue() {
		return ClkInfoFullWebsiteURLValue;
	}

	@FindBy(how = How.ID, using = "appleStore.appName")
	private WebElement AppleappName;

	public WebElement getAppleappName() {
		return AppleappName;
	}

	@FindBy(how = How.ID, using = "appleStore.appUrl")
	private WebElement appUrl;

	public WebElement getappUrl() {
		return appUrl;
	}

	@FindBy(how = How.ID, using = "windowsStore.packageId")
	private WebElement windowsStorepackageId;

	public WebElement getwindowsStorepackageId() {
		return windowsStorepackageId;
	}

	@FindBy(how = How.ID, using = "windowsStore.packageName")
	private WebElement windowsStorepackageName;

	public WebElement getwindowsStorepackageName() {
		return windowsStorepackageName;
	}

	@FindBy(how = How.ID, using = "windowsStore.uriSchema")
	private WebElement windowsStoreuriSchema;

	public WebElement getwindowsStoreuriSchema() {
		return windowsStoreuriSchema;
	}

	@FindBy(how = How.ID, using = "googlePlay.appUrl")
	private WebElement googlePlayappUrl;

	public WebElement getgooglePlayappUrl() {
		return googlePlayappUrl;
	}

	@FindBy(how = How.ID, using = "googlePlay.appName")
	private WebElement googlePlayappName;

	public WebElement getgooglePlayappName() {
		return googlePlayappName;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Shadow']//preceding-sibling::div[2]//descendant::div")
    @FindBy(how = How.XPATH, using = "(//span[text()='Text'])[1]//preceding-sibling::div/div")
	private WebElement ModuleIconText;

	public WebElement ClkModuleIconText() {
		return ModuleIconText;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Shadow']//preceding-sibling::div[1]")
	@FindBy(how= How.XPATH, using= "//span[text()='Shadow']//preceding-sibling::div[1]/div")
	private WebElement ModuleIconShadow;

	public WebElement ClkModuleIconShadow() {
		return ModuleIconShadow;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Button Text color']//following-sibling::div/div[1]")
	@FindBy(how = How.XPATH, using = "(//span[text()='Normal'])[1]/../div/div")
	private WebElement ButtonTextColorNormal;

	public WebElement ClkButtonTextColorNormal() {
		return ButtonTextColorNormal;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Button Text color']//following-sibling::div/div[2]")
	@FindBy(how = How.XPATH, using = "(//span[text()='Focus'])[1]/../div/div")
	private WebElement ButtonTextColorFocus;

	public WebElement ClkButtonTextColorFocus() {
		return ButtonTextColorFocus;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Button Text color']//following-sibling::div/div[3]")
	@FindBy(how = How.XPATH, using = "(//span[text()='Disabled'])[1]/../div/div")

	private WebElement ButtonTextColorDisable;

	public WebElement ClkButtonTextColorDisable() {
		return ButtonTextColorDisable;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Pressed']//preceding-sibling::div[4]")
	@FindBy(how = How.XPATH, using = "(//span[text()='Normal'])[2]/..//div/div")
	private WebElement BackgroundButtonNormal;

	public WebElement ClkBackgroundButtonNormal() {
		return BackgroundButtonNormal;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Pressed']//preceding-sibling::div[3]")
	@FindBy(how = How.XPATH, using = "(//span[text()='Focus'])[2]/../div/div")
	private WebElement BackgroundButtonFocus;

	public WebElement ClkBackgroundButtonFocus() {
		return BackgroundButtonFocus;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Pressed']//preceding-sibling::div[1]")
	@FindBy(how = How.XPATH, using = "//span[text()='Pressed']/../div/div")
	private WebElement BackgroundButtonPressed;

	public WebElement ClkBackgroundButtonPressed() {
		return BackgroundButtonPressed;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Pressed']//preceding-sibling::div[2]")
	@FindBy(how= How.XPATH, using = "(//span[text()='Disabled'])[2]/../div/div" )
	private WebElement BackgroundButtonDisabled;

	public WebElement ClkBackgroundButtonDisabled() {
		return BackgroundButtonDisabled;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Text Link']//following-sibling::div/div")
	@FindBy(how = How.XPATH, using = "//label[text()='Text Link']/../div[13]/div/div/div")
	private WebElement TextLink;

	public WebElement ClkTextLink() {
		return TextLink;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Home Screen']//following-sibling::div/div")
	@FindBy(how = How.XPATH, using = "(//span[text()='Normal'])[3]/../div/div")
	private WebElement HomeScreenNormal;

	public WebElement ClkHomeScreenNormal() {
		return HomeScreenNormal;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='List Item Focus']//following-sibling::div/div")
	@FindBy(how = How.XPATH, using = "//label[text()='List Item Focus']/../div[17]/div/div/div")
	private WebElement ListItemFocus;

	public WebElement ClkListItemFocus() {
		return ListItemFocus;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Sidebar Module']//following-sibling::div/div")
	@FindBy(how = How.XPATH, using = "//label[text()='Sidebar Category']/following::div[4]")
	private WebElement SideBarModule;

	public WebElement ClkSideBarModule() {
		return SideBarModule;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Text Shadow']//preceding-sibling::div[3]")
	@FindBy(how = How.XPATH, using = "//label[text()='Sidebar Category']/following::div[12]")
	private WebElement SideBarCategoryBackground;

	public WebElement ClkSideBarCategoryBackground() {
		return SideBarCategoryBackground;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Text Shadow']//preceding-sibling::div[2]")
	@FindBy(how = How.XPATH, using = "//label[text()='Sidebar Category']/following::div[8]")
	private WebElement SideBarCategoryText;

	public WebElement ClkSideBarCategoryText() {
		return SideBarCategoryText;
	}

	//@FindBy(how = How.XPATH, using = "//label[text()='Text Shadow']//preceding-sibling::div[1]")
	@FindBy(how = How.XPATH, using = "//label[text()='Sidebar Category']/following::div[12]")
	private WebElement SideBarCategoryTextShadow;

	public WebElement ClkSideBarCategoryTextShadow() {
		return SideBarCategoryTextShadow;
	}

	
		
 	@FindBy(how = How.XPATH, using = "//div[@data-keys='home_paging_normal']")

		private WebElement HomePagingButtonColorNormal;

		public WebElement ClkHomePagingButtonColorNormal() {
			return HomePagingButtonColorNormal;
		}
		
		
		
	@FindBy(how = How.XPATH, using = "//div[@data-keys='home_paging_focus']")

			private WebElement HomePagingButtonColorFocus;

			public WebElement ClkHomePagingButtonColorFocus() {
				return HomePagingButtonColorFocus;
			}
		
	@FindBy(how = How.XPATH, using = "//label[text()='Module Badge']/following::div[4]")

	private WebElement ModuleBadge;

	public WebElement ClkModuleBadge() {
		return ModuleBadge;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='#']//following-sibling::input")
	private WebElement ColorPicker;

	public WebElement ClkColorPicker() {
		return ColorPicker;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='R']//following-sibling::input")
	private WebElement ColorPickerR;

	public WebElement ClkColorPickerR() {
		return ColorPickerR;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Top']//following-sibling::button")
	private WebElement ColorPickerTop;

	public WebElement ClkColorPickerTop() {
		return ColorPickerTop;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Bottom']//following-sibling::button")
	private WebElement ColorPickerBottom;

	public WebElement ClkColorPickerBottom() {
		return ColorPickerBottom;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Middle']//following-sibling::button")
	private WebElement ColorPickerMiddle;

	public WebElement ClkColorPickerMiddle() {
		return ColorPickerMiddle;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='G']//following-sibling::input")
	private WebElement ColorPickerG;

	public WebElement ClkColorPickerG() {
		return ColorPickerG;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='B']//following-sibling::input")
	private WebElement ColorPickerB;

	public WebElement ClkColorPickerB() {
		return ColorPickerB;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Color']//following-sibling::div/div")
	private WebElement NavigationHeaderBarColorBackground;

	public WebElement NavigationHeaderBarColorBackground() {
		return NavigationHeaderBarColorBackground;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Info')]")
	private WebElement ClkInfo;

	public WebElement getClkInfo() {
		return ClkInfo;
	}

	@FindBy(how = How.XPATH, using = "//div[text()='OK']")
	private WebElement ColorPickerOK;

	public WebElement ClkColorPickerOK() {
		return ColorPickerOK;
	}

	@FindBy(how = How.XPATH, using = "//div[@data-keys='text_banner']")
	private WebElement NavigationHeaderBarText;

	public WebElement ClkNavigationHeaderBarText() {
		return NavigationHeaderBarText;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Settings']")
	private WebElement ClkSettings;

	public WebElement getClkSettings() {
		return ClkSettings;
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Advanced']")
	private WebElement ClkAdvancedSettings;

	public WebElement getClkAdvancedSettings() {
		return ClkAdvancedSettings;
	}
	
	
		@FindBy(how = How.XPATH, using = "(//h4[text()='Advanced'])[2]")
		private WebElement ClkAdvancedSettings1;

		public WebElement getClkAdvancedSettings1() {
			return ClkAdvancedSettings1;
		}

	@FindBy(how = How.XPATH, using = "//div[@id='menu-container']//div[@data-dub_module_key='AdmissionsModule']")
	private WebElement AdmissionsSamulatorVari;

	public WebElement getAdmissionsSamulatorVari() {
		return AdmissionsSamulatorVari;
	}

	@FindBy(how = How.ID, using = "teamShareUrl.value")
	private WebElement teamShareUrlvalue;

	public WebElement getteamShareUrlvalue() {
		return teamShareUrlvalue;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='teamShareUrl']")
	private WebElement ManageAdmissionTeam;

	public WebElement getManageAdmissionTeam() {
		return ManageAdmissionTeam;
	}

	@FindBy(how = How.ID, using = "logo")
	private WebElement ClkModuleLogo;

	public WebElement getClkModuleLogo() {
		return ClkModuleLogo;
	}

	@FindBy(how = How.ID, using = "aboutText")
	private WebElement ClkModuleAbout;

	public WebElement getClkModuleAbout() {
		return ClkModuleAbout;
	}

	@FindBy(how = How.ID, using = "teamShareUrl.title")
	private WebElement TeamShareUrlTitle;

	public WebElement getTeamShareUrlTitle() {
		return TeamShareUrlTitle;
	}

	@FindBy(how = How.ID, using = "name")
	private WebElement ManageAdmTeamName;

	public WebElement getManageAdmTeamName() {
		return ManageAdmTeamName;
	}

	@FindBy(how = How.ID, using = "title")
	private WebElement ManageAdmTeamTitle;

	public WebElement getManageAdmTeamTitle() {
		return ManageAdmTeamTitle;
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement ManageAdmTeamEmail;

	public WebElement getManageAdmTeamEmail() {
		return ManageAdmTeamEmail;
	}

	@FindBy(how = How.ID, using = "phone")
	private WebElement ManageAdmTeamPhone;

	public WebElement getManageAdmTeamPhone() {
		return ManageAdmTeamPhone;
	}

	@FindBy(how = How.ID, using = "pictureUrl")
	private WebElement ManageAdmTeamPictureUrl;

	public WebElement getManageAdmTeamPictureUrl() {
		return ManageAdmTeamPictureUrl;
	}

	@FindBy(how = How.ID, using = "about")
	private WebElement ManageAdmTeamAbout;

	public WebElement getManageAdmTeamAbout() {
		return ManageAdmTeamAbout;
	}

	public static String getSaveOrClear() {

		return "//button[text()='" + saveOrClear + "']";
	}

	public static String getGenXmlOrClose() {

		return "//button[text()='" + genXmlOrClose + "']";
	}

	@FindBy(how = How.ID, using = "RequestInfo.title")
	private WebElement RequestInfoTitle;

	public WebElement getRequestInfoTitle() {
		return RequestInfoTitle;
	}

	@FindBy(how = How.ID, using = "RequestInfo.email")
	private WebElement RequestInfoEmail;

	public WebElement getRequestInfoEmail() {
		return RequestInfoEmail;
	}

	@FindBy(how = How.ID, using = "RequestInfo.subject")
	private WebElement RequestInfoSubject;

	public WebElement getRequestInfoSubject() {
		return RequestInfoSubject;
	}

	@FindBy(how = How.ID, using = "sectionOneAdmissionContent.title")
	private WebElement sectionOneAdmContenTitle;

	public WebElement getsectionOneAdmContenTitle() {
		return sectionOneAdmContenTitle;
	}

	@FindBy(how = How.ID, using = "sectionOneAdmissionContent.sectioncontent")
	private WebElement sectionOneAdmContentSectioncontent;

	public WebElement getsectionOneAdmissionContentsectioncontent() {
		return sectionOneAdmContentSectioncontent;
	}

	@FindBy(how = How.ID, using = "sectionTwoAdmissionContent.title")
	private WebElement sectionTwoAdmContenTitle;

	public WebElement getsectionTwoAdmContenTitle() {
		return sectionTwoAdmContenTitle;
	}

	@FindBy(how = How.ID, using = "sectionTwoAdmissionContent.sectioncontent")
	private WebElement sectionTwoAdmContentSectioncontent;

	public WebElement getsectionTwoAdmissionContentsectioncontent() {
		return sectionTwoAdmContentSectioncontent;
	}

	@FindBy(how = How.ID, using = "sectionThreeAdmissionContent.title")
	private WebElement sectionThreeAdmContenTitle;

	public WebElement getsectionThreeAdmContenTitle() {
		return sectionThreeAdmContenTitle;
	}

	@FindBy(how = How.ID, using = "sectionThreeAdmissionContent.sectioncontent")
	private WebElement sectionThreeAdmContentSectioncontent;

	public WebElement getsectionThreeAdmissionContentsectioncontent() {
		return sectionThreeAdmContentSectioncontent;
	}

	@FindBy(how = How.ID, using = "RequestInfoItems")
	private WebElement ClkRequestInfoItemsAdd;

	public WebElement getClkRequestInfoItemsAdd() {
		return ClkRequestInfoItemsAdd;
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

	@FindBy(how = How.XPATH, using = "//label[@for='require']")
	private WebElement ClkRequirdQuestion;

	public WebElement getClkRequirdQuestion() {
		return ClkRequirdQuestion;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='visible']")
	private WebElement ClkVisible;

	public WebElement getClkVisible() {
		return ClkVisible;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='populated']")
	private WebElement ClkPopulated;

	public WebElement getClkPopulated() {
		return ClkPopulated;
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

	@FindBy(how = How.ID, using = "stylesheet_tablet_url")
	private WebElement ClkPlistUrl;

	public WebElement getClkPlistUrl() {
		return ClkPlistUrl;
	}

	@FindBy(how = How.ID, using = "sponsorText")
	private WebElement ClkSponsorText;

	public WebElement getClkSponsorText() {
		return ClkSponsorText;
	}

	@FindBy(how = How.ID, using = "sponsorLink")
	private WebElement ClkSponsorLink;

	public WebElement getClkSponsorLink() {
		return ClkSponsorLink;
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

	@FindBy(how = How.ID, using = "imageUrl")
	private WebElement ClkPopUpImageUrl;

	public WebElement getClkPopUpImageUrl() {
		return ClkPopUpImageUrl;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='openInNativeBrowser']")
	private WebElement ClkOpenInNativeBrowser;

	public WebElement getOpenInNativeBrowser() {
		return ClkOpenInNativeBrowser;
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

	@FindBy(how = How.XPATH, using = "//label[@for='notificationAvailable']")
	private WebElement ClkNotiAvail;

	public WebElement getClkNotiAvail() {
		return ClkNotiAvail;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='enablePlanner']")
	private WebElement ClkEnablePlanner;

	public WebElement getClkEnablePlanner() {
		return ClkEnablePlanner;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='shoppingCart']")
	private WebElement ClkShoppingCart;

	public WebElement getClkShoppingCart() {
		return ClkShoppingCart;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='enableSwapClass']")
	private WebElement ClkEnableSwapClass;

	public WebElement getClkEnableSwapClass() {
		return ClkEnableSwapClass;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='enablefulltimerangesearch']")
	private WebElement ClkEnablefulltimerangesearch;

	public WebElement getClkEnablefulltimerangesearch() {
		return ClkEnablefulltimerangesearch;
	}

	@FindBy(how = How.ID, using = "scopingFields")
	private WebElement ClkAddSearchField;

	public WebElement getClkAddSearchField() {
		return ClkAddSearchField;
	}

	@FindBy(how = How.ID, using = "displayString")
	private WebElement DisplayString;

	public WebElement getDisplayString() {
		return DisplayString;
	}

	@FindBy(how = How.ID, using = "key")
	private WebElement key;

	public WebElement getkey() {
		return key;
	}

	@FindBy(how = How.ID, using = "type")
	private WebElement SelType;

	public WebElement getSelType() {
		return SelType;
	}

	@FindBy(how = How.ID, using = "value")
	private WebElement ASFValue;

	public WebElement getASFValue() {
		return ASFValue;
	}

	@FindBy(how = How.ID, using = "hint")
	private WebElement Hint;

	public WebElement getHint() {
		return Hint;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='boolean']")
	private WebElement Clkboolean;

	public WebElement getClkboolean() {
		return Clkboolean;
	}

	@FindBy(how = How.ID, using = "defaultselection")
	private WebElement DefaultSelection;

	public WebElement getDefaultSelection() {
		return DefaultSelection;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='searchablefield']")
	private WebElement ClkSearchableField;

	public WebElement getClkSearchableField() {
		return ClkSearchableField;
	}

	@FindBy(how = How.ID, using = "bursarUrl")
	private WebElement BursarUrl;

	public WebElement getBursarUrl() {
		return BursarUrl;
	}

	@FindBy(how = How.ID, using = "paymentUrl")
	private WebElement PaymentUrl;

	public WebElement getPaymentUrl() {
		return PaymentUrl;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='displayPaymentOption']")
	private WebElement ClkDisplayPaymentOption;

	public WebElement getClkDisplayPaymentOption() {
		return ClkDisplayPaymentOption;
	}

	@FindBy(how = How.ID, using = "contactFinalSupport.email")
	private WebElement ClkContactFinalSupportEmail;

	public WebElement getClkContactFinalSupportEmail() {
		return ClkContactFinalSupportEmail;
	}

	@FindBy(how = How.ID, using = "contactFinalSupport.subject")
	private WebElement ClkContactFinalSupportSubject;

	public WebElement getClkContactFinalSupportSubject() {
		return ClkContactFinalSupportSubject;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='showAvatar']")
	private WebElement ClkShowAvatar;

	public WebElement getClkShowAvatar() {
		return ClkShowAvatar;
	}

	@FindBy(how = How.ID, using = "displayString")
	private WebElement ClkDisplayString;

	public WebElement getClkDisplayString() {
		return ClkDisplayString;
	}

	@FindBy(how = How.ID, using = "eventsWindowDays")
	private WebElement EventsWindowDays;

	public WebElement getEventsWindowDays() {
		return EventsWindowDays;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='buildingsUrl']")
	private WebElement MapUrl;

	public WebElement getMapUrl() {
		return MapUrl;
	}

	@FindBy(how = How.XPATH, using = "//Button[@id='buildingsUrl']")
	private WebElement ClkManageLocation;

	public WebElement getClkManageLocation() {
		return ClkManageLocation;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='showImage']")
	private WebElement ClkShowImage;

	public WebElement getClkShowImage() {
		return ClkShowImage;
	}

	@FindBy(how = How.ID, using = "campusId")
	private WebElement CampusId;

	public WebElement getCampusId() {
		return CampusId;
	}

	@FindBy(how = How.ID, using = "campusName")
	private WebElement CampusName;

	public WebElement getCampusName() {
		return CampusName;
	}

	@FindBy(how = How.ID, using = "buildings.buildingId")
	private WebElement BuildingId;

	public WebElement getBuildingId() {
		return BuildingId;
	}

	@FindBy(how = How.ID, using = "buildings.buildingName")
	private WebElement BuildingName;

	public WebElement getBuildingName() {
		return BuildingName;
	}

	@FindBy(how = How.ID, using = "buildings.category")
	private WebElement BuildingsCategory;

	public WebElement getBuildingsCategory() {
		return BuildingsCategory;
	}

	@FindBy(how = How.ID, using = "buildings.description")
	private WebElement BuildingsDescription;

	public WebElement getBuildingsDescription() {
		return BuildingsDescription;
	}

	@FindBy(how = How.ID, using = "buildings.address")
	private WebElement BuildingsAddress;

	public WebElement getBuildingsAddress() {
		return BuildingsAddress;
	}

	@FindBy(how = How.ID, using = "buildings.city")
	private WebElement BuildingsCity;

	public WebElement getBuildingsCity() {
		return BuildingsCity;
	}

	@FindBy(how = How.ID, using = "buildings.state")
	private WebElement BuildingsState;

	public WebElement getBuildingsState() {
		return BuildingsState;
	}

	@FindBy(how = How.ID, using = "buildings.zip")
	private WebElement BuildingsZip;

	public WebElement getBuildingsZip() {
		return BuildingsZip;
	}

	@FindBy(how = How.ID, using = "buildings.latitude")
	private WebElement BuildingsLatitude;

	public WebElement getBuildingsLatitude() {
		return BuildingsLatitude;
	}

	@FindBy(how = How.ID, using = "buildings.longitude")
	private WebElement BuildingsLongitude;

	public WebElement getBuildingsLongitude() {
		return BuildingsLongitude;
	}

	@FindBy(how = How.ID, using = "buildings.imageUrl")
	private WebElement BuildingsImageUrl;

	public WebElement getBuildingsImageUrl() {
		return BuildingsImageUrl;
	}

	public static String SaveBuilding() {
		return "//button[text()='Save Building']";
	}

	public static String CreateNewCampus() {
		return "//button[text()='Create New Campus']";
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Generate VCF']")
	private WebElement GenerateVCF;

	public WebElement getGenerateVCF() {
		return GenerateVCF;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	private WebElement Close;

	public WebElement getClose() {
		return Close;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='rostervisible']")
	private WebElement ShowRoster;

	public WebElement getShowRoster() {
		return ShowRoster;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='gradesvisible']")
	private WebElement ShowGrades;

	public WebElement getShowGrades() {
		return ShowGrades;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='assignmentsvisible']")
	private WebElement ShowAssignments;

	public WebElement getShowAssignments() {
		return ShowAssignments;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='discussionsvisible']")
	private WebElement ShowDiscussions;

	public WebElement getShowDiscussions() {
		return ShowDiscussions;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='announcementsvisible']")
	private WebElement ShowAnnouncements;

	public WebElement getShowAnnouncements() {
		return ShowAnnouncements;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='assignmentsbuttonvisible']")
	private WebElement ShowAssignmentsButton;

	public WebElement getShowAssignmentsButton() {
		return ShowAssignmentsButton;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='showDefaultGradeValue']")
	private WebElement ShowDefaultGradeValue;

	public WebElement getShowDefaultGradeValue() {
		return ShowDefaultGradeValue;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='announcementsbuttonvisible']")
	private WebElement ShowAnnouncementsButton;

	public WebElement getShowAnnouncementsButton() {
		return ShowAnnouncementsButton;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='purchasedTextbooksVisible']")
	private WebElement ShowPurchasedTextbooksButton;

	public WebElement getShowPurchasedTextbooksButton() {
		return ShowPurchasedTextbooksButton;
	}

	@FindBy(how = How.XPATH, using = "//h4[text()='Bookstore']")
	private WebElement ClkBookstore;

	public WebElement getClkBookstore() {
		return ClkBookstore;
	}

	@FindBy(how = How.ID, using = "bookstoreURL")
	private WebElement BookstoreUrl;

	public WebElement getClkBookstoreUrl() {
		return BookstoreUrl;
	}

	@FindBy(how = How.ID, using = "termId")
	private WebElement ActiveTermIDBookstore;

	public WebElement getActiveTermIDBookstore() {
		return ActiveTermIDBookstore;
	}

	@FindBy(how = How.ID, using = "bookstoreMemberIds")
	private WebElement ClkManageBookStore;

	public WebElement getClkManageBookStore() {
		return ClkManageBookStore;
	}

	@FindBy(how = How.ID, using = "bookstoreMemberId")
	private WebElement BookstoreMemberId;

	public WebElement getBookstoreMemberId() {
		return BookstoreMemberId;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='VCard URL']//following-sibling::span/input")
	private WebElement VCardUrl;

	public WebElement getVCardUrl() {
		return VCardUrl;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='vCard URL']//following-sibling::span/input")
	private WebElement vCardUrl;

	public WebElement getvCardUrl() {
		return vCardUrl;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Manage Numbers']")
	private WebElement ManageNumbers;

	public WebElement getManageNumbers() {
		return ManageNumbers;
	}

	@FindBy(how = How.ID, using = "address")
	private WebElement Address;

	public WebElement getAddress() {
		return Address;
	}

	@FindBy(how = How.ID, using = "addressType")
	private WebElement AddressType;

	public WebElement getAddressType() {
		return AddressType;
	}

	@FindBy(how = How.ID, using = "city")
	private WebElement City;

	public WebElement getCity() {
		return City;
	}

	@FindBy(how = How.ID, using = "state")
	private WebElement State;

	public WebElement getState() {
		return State;
	}

	@FindBy(how = How.ID, using = "zip")
	private WebElement Zip;

	public WebElement getZip() {
		return Zip;
	}

	@FindBy(how = How.ID, using = "emailType")
	private WebElement EmailType;

	public WebElement getEmailType() {
		return EmailType;
	}

	@FindBy(how = How.ID, using = "phoneType")
	private WebElement PhoneType;

	public WebElement getPhoneType() {
		return PhoneType;
	}

	@FindBy(how = How.ID, using = "buildingName")
	private WebElement EmeBuildingName;

	public WebElement getEmeBuildingName() {
		return EmeBuildingName;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Save Number']")
	private WebElement SaveNumber;

	public WebElement getSaveNumber() {
		return SaveNumber;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Clear']")
	private WebElement Clear;

	public WebElement getClear() {
		return Clear;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement Cancel;

	public WebElement getCancel() {
		return Cancel;
	}

	@FindBy(how = How.ID, using = "menudays")
	private WebElement MenuDays;

	public WebElement getMenuDays() {
		return MenuDays;
	}

	@FindBy(how = How.ID, using = "mainUrl")
	private WebElement MainUrl;

	public WebElement getMainUrl() {
		return MainUrl;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='addDate']")
	private WebElement AddDateUrl;

	public WebElement getAddDateUrl() {
		return AddDateUrl;
	}

	@FindBy(how = How.ID, using = "note")
	private WebElement Note;

	public WebElement getNote() {
		return Note;
	}

	@FindBy(how = How.ID, using = "breakfastUrl")
	private WebElement BreakFastUrl;

	public WebElement getBreakFastUrl() {
		return BreakFastUrl;
	}

	@FindBy(how = How.ID, using = "breakfastLabel")
	private WebElement BreakfastLabel;

	public WebElement getBreakfastLabel() {
		return BreakfastLabel;
	}

	@FindBy(how = How.ID, using = "breakfastSummary")
	private WebElement BreakfastSummary;

	public WebElement getBreakfastSummary() {
		return BreakfastSummary;
	}

	@FindBy(how = How.ID, using = "lunchUrl")
	private WebElement LunchUrl;

	public WebElement getLunchUrl() {
		return LunchUrl;
	}

	@FindBy(how = How.ID, using = "lunchLabel")
	private WebElement LunchLabel;

	public WebElement getLunchLabel() {
		return LunchLabel;
	}

	@FindBy(how = How.ID, using = "lunchSummary")
	private WebElement LunchSummary;

	public WebElement getLunchSummary() {
		return LunchSummary;
	}

	@FindBy(how = How.ID, using = "dinnerUrl")
	private WebElement DinnerUrl;

	public WebElement getDinnerUrl() {
		return DinnerUrl;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='url']")
	private WebElement ClkManageDinningHall;

	public WebElement getClkManageDinningHall() {
		return ClkManageDinningHall;
	}

	@FindBy(how = How.ID, using = "dinnerLabel")
	private WebElement DinnerLabel;

	public WebElement getDinnerLabel() {
		return DinnerLabel;
	}

	@FindBy(how = How.ID, using = "dinnerSummary")
	private WebElement DinnerSummary;

	public WebElement getDinnerSummary() {
		return DinnerSummary;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.SU']")
	private WebElement Sunday;

	public WebElement getSunday() {
		return Sunday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.MO']")
	private WebElement Monday;

	public WebElement getMonday() {
		return Monday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.TU']")
	private WebElement Tuesday;

	public WebElement getTuesday() {
		return Tuesday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.WE']")
	private WebElement Wednesday;

	public WebElement getWednesday() {
		return Wednesday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.TH']")
	private WebElement Thursday;

	public WebElement getThursday() {
		return Thursday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.FR']")
	private WebElement Friday;

	public WebElement getFriday() {
		return Friday;
	}

	@FindBy(how = How.XPATH, using = "//label[2][@for='meals.SA']")
	private WebElement Saturday;

	public WebElement getSaturday() {
		return Saturday;
	}

	@FindBy(how = How.ID, using = "meals.breakfastFrom")
	private WebElement BreakfastFrom;

	public WebElement getBreakfastFrom() {
		return BreakfastFrom;
	}

	@FindBy(how = How.ID, using = "meals.breakfastTo")
	private WebElement BreakfastTo;

	public WebElement getBreakfastTo() {
		return BreakfastTo;
	}

	@FindBy(how = How.ID, using = "meals.breakfastRestriction")
	private WebElement BreakfastRestriction;

	public WebElement getBreakfastRestriction() {
		return BreakfastRestriction;
	}

	@FindBy(how = How.ID, using = "meals.lunchFrom")
	private WebElement LunchFrom;

	public WebElement getLunchFrom() {
		return LunchFrom;
	}

	@FindBy(how = How.ID, using = "meals.lunchTo")
	private WebElement LunchTo;

	public WebElement getLunchTo() {
		return LunchTo;
	}

	@FindBy(how = How.ID, using = "meals.lunchRestriction")
	private WebElement LunchRestriction;

	public WebElement getLunchRestriction() {
		return LunchRestriction;
	}

	@FindBy(how = How.ID, using = "meals.dinnerFrom")
	private WebElement DinnerFrom;

	public WebElement getDinnerFrom() {
		return DinnerFrom;
	}

	@FindBy(how = How.ID, using = "meals.dinnerTo")
	private WebElement DinnerTo;

	public WebElement getDinnerTo() {
		return DinnerTo;
	}

	@FindBy(how = How.ID, using = "meals.dinnerRestriction")
	private WebElement DinnerRestriction;

	public WebElement getDinnerRestriction() {
		return DinnerRestriction;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Save Meal']")
	private WebElement SaveMeal;

	public WebElement getSaveMeal() {
		return SaveMeal;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Create New Dining Hall']")
	private WebElement CreateNewDiningHall;

	public WebElement getCreateNewDiningHall() {
		return CreateNewDiningHall;
	}

	@FindBy(how = How.ID, using = "apps-picker")
	private WebElement reportsAppName;

	public WebElement getreportsAppName() {
		return reportsAppName;
	}

	@FindBy(how = How.XPATH, using = "//li[@data-dub_section='app-usage']")
	private WebElement reportsAppUsage;

	public WebElement getreportsAppUsage() {
		return reportsAppUsage;
	}

	@FindBy(how = How.XPATH, using = "//li[@data-dub_section='module-usage']")
	private WebElement reportsModuleUsage;

	public WebElement getreportsModuleUsage() {
		return reportsModuleUsage;
	}

	@FindBy(how = How.XPATH, using = "//li[@data-dub_section='app-downloads']")
	private WebElement reportsAppDownloads;

	public WebElement getreportsAppDownloads() {
		return reportsAppDownloads;
	}

	@FindBy(how = How.XPATH, using = "//li[@data-dub_section='app-reviews']")
	private WebElement reportsAppReviews;

	public WebElement getreportsAppReviews() {
		return reportsAppReviews;
	}

	@FindBy(how = How.CLASS_NAME, using = "title")
	private WebElement reportstitle;

	public WebElement getreportstitle() {
		return reportstitle;
	}

	@FindBy(how = How.ID, using = "module-usage-list")
	private WebElement reportsSubMenu;

	public WebElement getreportsSubMenu() {
		return reportsSubMenu;
	}

	@FindBy(how = How.CLASS_NAME, using = "module-meta")
	private WebElement reportsModuleMeta;

	public WebElement getreportsModuleMeta() {
		return reportsModuleMeta;
	}

	@FindBy(how = How.CLASS_NAME, using = "chart-legend")
	private WebElement reportsModuleMetaDetails;

	public WebElement getreportsModuleMetaDetails() {
		return reportsModuleMetaDetails;
	}

	@FindBy(how = How.ID, using = "fromDate")
	private WebElement reportsFromDate;

	public WebElement getreportsFromDate() {
		return reportsFromDate;
	}

	@FindBy(how = How.ID, using = "toDate")
	private WebElement reportsToDate;

	public WebElement getreportsToDate() {
		return reportsToDate;
	}

	@FindBy(how = How.CLASS_NAME, using = "normal-btn")
	private WebElement reportsExportButton;

	public WebElement getreportsExportButton() {
		return reportsExportButton;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Reports']")
	private WebElement reports;

	public WebElement getreports() {
		return reports;
	}

	@FindBy(how = How.CLASS_NAME, using = "ui-datepicker-month")
	private WebElement datePickerMonth;

	public WebElement getdatePickerMonth() {
		return datePickerMonth;
	}

	@FindBy(how = How.CLASS_NAME, using = "ui-datepicker-year")
	private WebElement datePickerYear;

	public WebElement getdatePickerYear() {
		return datePickerYear;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='coursesWidgetVisible']")
	private WebElement displayCoursesWidget;

	public WebElement getdisplayCoursesWidget() {
		return displayCoursesWidget;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='notificationsWidgetVisible']")
	private WebElement displayNotificationsWidget;

	public WebElement getdisplayNotificationsWidget() {
		return displayNotificationsWidget;
	}

	@FindBy(how = How.CSS, using = "#changeHomeTextLabel")
	private WebElement homeTextLabel;

	public WebElement gethomeTextLabel() {
		return homeTextLabel;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='enabledSearch']")
	private WebElement enableSearchInMultiCampus;

	public WebElement getenableSearchInMultiCampus() {
		return enableSearchInMultiCampus;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='changeCampusFromHomeScreen']")
	private WebElement changeCampusFromHomeScreen;

	public WebElement getChangeCampusFromHomeScreen() {
		return changeCampusFromHomeScreen;
	}

}
