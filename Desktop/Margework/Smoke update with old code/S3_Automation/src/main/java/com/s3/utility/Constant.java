package com.s3.utility;

public class Constant {

	// Use System.getProperty("user.dir") or other custom folder path when local
	// testing
	// Keep "browser_key" so Jenkins can override it
	// public ArrayList<String> receipients;
	public static final String MAIL_TO = "anoops@astegic.com,prakash.chand@astegic.com";
	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/Reports/Screenshot/";
	// Use chrome, firefox, safari, ie when local testing
	// Keep "browser_key" so Jenkins can override it
	public static final String BROWSER_NAME = "browser_key";

	// public static final String BROWSER_NAME = "chrome";
	// public ArrayList<String> getReceipients() {
	// return receipients;
	// }
	// public void setReceipients(ArrayList<String> receipients) {
	// this.receipients = receipients;
	// }
	// public static final String GECKO_PATH = "./Browsersdriver/geckodriver";
	public static final String CHROME_PATH = "Browsersdriver/chromedriver";
	public static final String URL = "https://cloud-test.dublabs.com/s3/";
	public static final String EXCEL_FILE_NAME = "./src/main/java/testdata/DublabsData.xlsx";
	public static final String STATUS_EXCEL_FILE = "./Reports/S3AutomationTestStatus.xlsx";
	public static final String STATUS_SHEET = "Sheet1";
	public static final String LOGIN_SHEET = "Sheet1";
	public static final String ADD_WEBMODULE_SHEET = "Sheet3";
	public static final String PARTNER_Sheet = "Sheet4";
	public static final String CLIENT_SHEET = "Sheet5";
	public static final String USER_SHEET = "Sheet6";
	public static final String ADD_ADMISSIONSMODULE_SHEET = "Sheet7";
	public static final String ADD_ADMITTEDLYMODULE_SHEET = "Sheet8";
	public static final String ADD_RSSMODULE_SHEET = "Sheet9";
	public static final String Add_NEWSMODULE_SHEET = "Sheet12";
	public static final String ADD_PEOPLESOFT_SHEET = "Sheet13";
	public static final String ADD_BURSERMODULE_SHEET = "Sheet14";
	public static final String ADD_EMERGENCYMODULE_SHEET = "Sheet15";
	public static final String ADD_DININGHALLMODULE_SHEET = "Sheet16";
	public static final String ADD_APPMODULE_SHEET = "Sheet17";
	public static final String INFO_SHEET = "Sheet18";
	public static final String STYLE_SHEET = "Sheet19";
	public static final String SETTINGS_SHEET = "Sheet20";
	public static final String COURSESSHEET = "Sheet10";
	public static final String ADD_EVENTSMODULE_SHEET = "Sheet26";
	public static final String EDIT_MYAPPLICATION_SHEET = "Sheet22";
	public static final String COPY_MYAPPLICATION_SHEET = "Sheet23";
	public static final String DELETE_MYAPPLICATION_SHEET = "Sheet24";
	public static final String ADD_DIRECTORYMODULE_SHEET = "Sheet25";
	public static final String ADD_IMAGEGALLERYMODULE_SHEET = "Sheet21";
	public static final String ADD_MAPSMODULE_SHEET = "Sheet11";
	public static final String ADD_BILLPAYMODULE_SHEET = "Sheet27";
	public static final String ADD_BUSSCHEDULEMODULE_SHEET = "Sheet28";
	public static final String ADD_CAMPUSJOBMODULE_SHEET = "Sheet29";
	public static final String ADD_D2LMODULE_SHEET = "Sheet30";
	public static final String ADD_FACEBOOKMODULE_SHEET = "Sheet31";
	public static final String ADD_FINANCIALAIDMODULE_SHEET = "Sheet32";
	public static final String ADD_HOLDSMODULE_SHEET = "Sheet33";
	public static final String ADD_LIBRARYMODULE_SHEET = "Sheet34";
	public static final String ADD_TWITTERMODULE_SHEET = "Sheet35";
	public static final String ADD_BANNERENROLLMENT_SHEET = "Sheet36";
	public static final String DELETE_ADDEDMODULE_SHEET = "Sheet38";
	public static final String ADD_DASHBOARDMODULE_SHEET = "Sheet39";
	public static final String ADD_VIDEOSMODULE_SHEET = "Sheet40";
	public static final String ADD_SPORTSMODULE_SHEET = "Sheet41";
	public static final String GENERATE_XML = "./AutoItData/GenerateXml.exe";
	// public static final String REPLACE_IMAGE = "./Images/admission.png";
	// //PATH NEED TO BE CHANGE WHILE RUNING ON DIFFRENT MACHINE AND PLEASE ADD
	// ABSOLUTE PATH.
	public static final String REPLACE_IMAGE = System.getProperty("user.dir") + "/Images/admission.png";
	public static final String GENERATE_VCF = "./AutoItData/GenerateXml.exe";
	public static final String NAVIGATION_HEADER_REPLACE_IMAGE = System.getProperty("user.dir") + "/Images/Header.png";
	// PATH NEED TO BE CHANGE HERE WHILE RUNNING ON DIFFRENT MACHINE AND PLEASE
	// ADD ABSOLUTE PATH.
	public static final String APP_ICON_REPLACE_IMAGE = System.getProperty("user.dir")+ "/Images/appIcon@2x270x270.png"; 
	public static final String MODULE_BACKGROUND_REPLACE_IMAGE = System.getProperty("user.dir")+ "/Images/BGDefault@2x200x190.png"; 
	public static final String LAUNCH_IMAGE_REPLACE_IMAGE = System.getProperty("user.dir")+ "/Images/Default-Portrait@2x~ipad.png"; 
	public static final String HOME_BACKGROUND_REPLACEIMAGE = System.getProperty("user.dir")+ "/Images/BG_fill320x480.png";
	public static final String INFO_ICON_REPLACE_IMAGE = System.getProperty("user.dir") + "/Images/info.png";
	public static final String REPORTS_FILE_PATH_LOGIN = "./Reports/login.html";
	public static final String REPORTS_MANAGEPARTNER_FILE = "./Reports/ManagePartner.html";
	public static final String REPORTS_CLIENT_FILE = "./Reports/Client.html";
	public static final String REPORTS_APPMODULE_FILE = "./Reports/AppModule.html";
	public static final String REPORTS_BARSERMODULE_FILE = "./Reports/BurserModule.html";
	public static final String REPORTS_COURSESMODULE_FILE = "./Reports/Courses.html";
	public static final String REPORTS_DINNINFHALL_FILE = "./Reports/DiningHall.html";
	public static final String REPORTS_EMERGENCY_FILE = "./Reports/Emergency.html";
	public static final String REPORTS_IMAGEGALLERYMODULE_FILE = "./Reports/ImagesGallery.html";
	public static final String REPORTS_ADMISSIONSMODULE_FILE = "./Reports/Admissions.html";
	public static final String REPORTS_MAPMODULE_FILE = "./Reports/Map.html";
	public static final String REPORTS_ADMITTEDLY_FILE = "./Reports/ AdmittedlyModule.html";
	public static final String REPORTS_BANNERENROLLMENT_FILE = "./Reports/BannerEnrollmentModules.html";
	public static final String REPORTS_BILLPAYMODULEFILE = "./Reports/BillPayModules.html";
	public static final String REPORTS_BUSSEDULEMODULE_FILE = "./Reports/BusScheduleModules.html";
	public static final String REPORTS_CAMPUSJOBMODULE_FILE = "./Reports/CampusJobModules.html";
	public static final String REPORTS_D2LMODULE_FILE = "./Reports/D2LModules.html";
	public static final String REPORTS_FACKBOOKMODULE_FILE = "./Reports/FacebookModules.html";
	public static final String REPORTS_FINANCIALAIDMODULE_FILE = "./Reports/FinancialAidModules.html";
	public static final String REPORTS_HOLDSMODULE_FILE = "./Reports/HoldsModules.html";
	public static final String REPORTS_LIBRARYMODULE_FILE = "./Reports/LibraryModules.html";
	public static final String REPORTS_TWITTERMODULE_FILE = "./Reports/TwitterModules.html";
	public static final String REPORTS_NEWSMODULE_FILE = "./Reports/NewsVideoSports.html";
	public static final String REPORTS_PEOPLESOFTMODULE_FILE = "./Reports/PeopleSoftModule.html";
	public static final String REPORTS_RSSMODULE_FILE = "./Reports/Rss.html";
	public static final String REPORTS_WEBMODULE_FILE = "./Reports/WebModules.html";
	public static final String REPORTS_USER_FILE = "./Reports/User.html";
	public static final String REPORTS_CREATEPARTNER_FILE = "./Reports/CreateManagePartner.html";
	public static final String REPORTS_DELETEPARTNER_FILE = "./Reports/DeleteManagePartner.html";
	public static final String REPORTS_EDITPARTNER_FILE = "./Reports/EditManagePartner.html";
	public static final String REPORTS_INFO_FILE = "./Reports/Info.html";
	public static final String REPORTS_SETTINGS_FILE = "./Reports/Settings.html";
	public static final String REPORTS_STYLE_FILE = "./Reports/Style.html";
	public static final String REPORTS_EDITMYAPPLICATION_FILE = "./Reports/EditMyApplications.html";
	public static final String REPORTS_COPYMYAPPLICATION_FILE = "./Reports/CopyMyApplications.html";
	public static final String REPORTS_DELETEMYAPPLICATION_FILE = "./Reports/DeleteMyApplications.html";
	public static final String REPORTS_DASHBOARDMODULE_FILE = "./Reports/Deshboard.html";
	public static final String REPORTS_DIRECTORYMODULE_FILE = "./Reports/AddDirectory.html";
	public static final String REPORTS_EVENTSMODULE_FILE = "./Reports/AddEvents.html";
	public static final String REPORTS_DELETE_MODULE_FILE = "./Reports/DeleteModule.html";
	public static final String REPORTS_SPORTSMODULE_FILE = "./Reports/SportsModule.html";
	public static final String REPORTS_VIDEOSMODULE_FILE = "./Reports/VideosModule.html";
	public static final String DINNING_VCF_FILE_PATH = System.getProperty("user.dir") + "/Downloads/dining.vcf"; 
	public static final String MAPS_VCF_FILE_PATH = System.getProperty("user.dir") + "/Downloads/maps.vcf"; 
	public static final String ADMISSIONS_XML_FILE_PATH = System.getProperty("user.dir")+ "/Downloads/admissions-rss.xml"; 
	public static final String IMAGEGALLERY_XML_FILE_PATH = System.getProperty("user.dir") + "/imagesGallery.xml"; 

	// Phase2 Constants
	// For Maintain RunMode by XLSX file

	public static final String RUNMODEXLS = "./TestData/SuiteRunmode.xlsx";
	public static final String RUNMODESUITESHEET = "Test Suite";
	public static final String RUNMODELOGIN = "Login";
	public static final String RUNMODEUSER = "Users";
	public static final String RUNMODEADMIN = "Admin";

	// This is use for Login module
	public static final int RESULT_COL = 3;
	public static final int RESONE_COL = 8;
	public static final String RESULT_EXCEL_FILE_PHASE2 = "./Reports/S3Test_Results.xlsx";
	public static final String RESULT_SHEET_LOGIN = "Login";
	public static final String RESULT_SHEET_USERS = "Users";
	public static final String LOGIN_TEST_DATA = "./TestData/Login.xlsx";
	public static final String USER_TYPE_SHEET = "UserType";
	public static final String URL_SHEET = "TC_Login_01";
	public static final String BLANKLOGIN = "TC_Login_03";
	public static final String INVALIDLOGIN_SHEET = "TC_Login_04";
	public static final String VALIDLOGIN_SHEET = "TC_Login_05";
	public static final String LOGOUT = "TC_Login_06";
	public static final String REMEMBERME = "TC_Login_07";
	public static final String REMEMBERMEUNCHECK = "TC_Login_08";
	public static final String FORGOTPASSWORD_SHEET = "TC_Login_12";
	public static final String USERROLE = "TC_Login_16";

	// This is use for Users module
	public static final String USERS_TEST_DATA = "./TestData/Users.xlsx";
	public static final String UI_USERS = "TC_User_01";
	public static final String UI_NEWUSER = "TC_User_02";
	public static final String UI_NEWUSERPOPUP = "TC_USER_03";
	public static final String NEWADMINUSER = "TC_USER_05";
	public static final String NEWUSERONPROFILEPAGE = "TC_USER_06";
	public static final String SEARCHUSER = "TC_USER_08";
	public static final String EDITUSER = "TC_USER_09";
	public static final String DELETEUSERMESSAGE = "TC_USER_10";
	public static final String DELETEUSER = "TC_USER_11";
	public static final String SEARCHINVALIDUSER = "TC_USER_12";
	public static final String CHANGEPASSWORDPOPUP = "TC_USER_13";
	public static final String CHANGEPASSWORDPOPUPUI = "TC_USER_14";
	public static final String CHANGEPASSWORDINVALIDINPUT = "TC_USER_16";
	public static final String CHANGEPASSWORDVALIDINPUT = "TC_USER_17";

	// This is use for Admin module
	public static final String ADMIN_TEST_DATA = "./TestData/Admin.xlsx";
	public static final String RESULT_SHEET_ADMIN = "Admin";
	public static final String MANAGEPARTNERPAGEVISIBLITY = "Login";
	public static final String MANAGEPARTNERPAGEUIVERIFICATION = "Login";
	public static final String MANPARTNERCREATENEWPARTNERPOPUP = "Login";
	public static final String MANPARTNERCREATENEWPARTNERPOPUPUI = "Login";
	public static final String MANPARTNERCREATENEWPARTNERREQUIREDFIELDS = "Login";
	public static final String MANPARTNERCREATENEWPARTNERNAMEINPUT = "TC_Admin_06";
	public static final String MANPARTNERCREATEDUPLICATEPARTNER = "TC_Admin_07";
	public static final String MANPARTNERCREATENEWPARTNER = "TC_Admin_08";
	public static final String MANPARTNERELEMENTCHECKONPROFILE = "TC_Admin_09";
	public static final String MANPARTNERLISTSORTING = "Login";
	public static final String MANPARTNERINVALIDSEARCH = "TC_Admin_12";
	public static final String MANPARTNERVALIDSEARCH = "TC_Admin_13";
	public static final String MANPARTNERELEMENTOFALLPARTNER = "Login";
	public static final String MANPARTNEREDITPARTNERPOPUP = "Login";
	public static final String MANPARTNERPREFILLNAME = "Login";
	public static final String MANPARTNEREDITPARTNERNAME = "TC_Admin_17";

	// For Phase2 reports
	public static final String REPORTS_FILE_PATH_USERS = "./Reports/Users.html";
	public static final String REPORTS_UI_NEWUSER = "./Reports/CreateUsers.html";
	public static final String REPORTS_UI_NEWUSERPOPUP = "./Reports/CreateUsersUI.html";

	// This constants are for ReportUtil.java

	public static String TEST_SUITE_SHEET = "Test Suite";
	public static String Test_Suite_ID = "TSID";
	public static String RUNMODE_YES = "Y";
	public static String TEST_CASES_SHEET = "Test Cases";// Test sheet into
															// Login Page
	public static String RUNMODE = "Runmode";
	public static String TCID = "TCID";
	public static String TEST_STEPS_SHEET = "Test Steps";
	public static String KEYWORD = "Keyword";
	public static String KEYWORD_PASS = "PASS";
	public static String KEYWORD_FAIL = "FAIL";
	public static String RESULT = "Result";
	public static String KEYWORD_SKIP = "SKIP";
	public static String DATA = "Data";
	public static String OBJECT = "Object";
	public static String DATA_START_COL = "col";
	public static String DATA_SPLIT = "\\|";
	public static Object POSITIVE_DATA = "Y";
	public static Object RANDOM_VALUE = "Random_Value";
	public static String CONFIG = "config";

	public static final String SUITE_ID = "TSID";
	public static final String DESCRIPTION = "Description";
}
