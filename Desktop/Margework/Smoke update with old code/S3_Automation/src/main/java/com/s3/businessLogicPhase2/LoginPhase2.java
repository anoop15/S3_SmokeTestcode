package com.s3.businessLogicPhase2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.s3.objectRepositoryPhase2.LoginObjectsphase2;
import com.s3.utility.Constant;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class LoginPhase2 extends Utils {
	private static WebElement element = null;
	static LoginObjectsphase2 LoginObjects;
	static public int DataRow;
	public static final String SRC_FOLDER = "Temp/";
	// public static WebDriver driver = null;

	public static String Runable(int SuiteRowNum,int SuiteColNum,int TestcasesRowNum,int TestcaseColNum,String TestcasesSheetName) throws Exception
	{
		try{
		String RunModeSuite= ExcelUtils.getCellData(SuiteRowNum,SuiteColNum ,Constant.RUNMODEXLS,Constant.RUNMODESUITESHEET);
		String RunModeTestCase=ExcelUtils.getCellData(TestcasesRowNum,TestcaseColNum,Constant.RUNMODEXLS, TestcasesSheetName);
		System.out.println("Login RunMode :-"+RunModeSuite);
		System.out.println("URL Test case:- "+RunModeTestCase);
		if(RunModeSuite.equalsIgnoreCase("") || RunModeTestCase.equalsIgnoreCase(""))
			throw new Exception("Unable to read SuiteRunmode XLSX file or data is not available in XLSX file ");
		else
		if(RunModeSuite.equalsIgnoreCase("N") || RunModeTestCase.equalsIgnoreCase("N") )
		return "N";
		else
		return "Y";
		}catch(Exception e)
		{
			throw new Exception("Unable to read SuiteRunmode XLSX file");
		}
	}
	
	
	public static String LoginElements() {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			if (LoginObjects.getImgDubLabs().isDisplayed())
				Log.info("DubLabs Image Present on Login Page");
			if (LoginObjects.getImgLogin().isDisplayed())
				Log.info("Login image display");
			if (LoginObjects.getInputEmail().isDisplayed())
				Log.info("Email field display");
			if (LoginObjects.getInputPassword().isDisplayed())
				Log.info("Password field display");
			if (LoginObjects.getButtonLogin().isDisplayed())
				Log.info("Login button display");
			if (LoginObjects.getBottemHead().isDisplayed())
				Log.info("Bootom Head display");
		} catch (Exception e) {
			Log.info("Element not display");
			return "Fail";
		}
		return "Pass";
	}

	public static String TestImageDublabs() {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			if (LoginObjects.getImgDubLabs().isDisplayed()) {
				Log.info("DubLabs Image Present on Login Page");
			}
		} catch (Exception e) {
			Log.warn("DubLabs Image Not Present on Login Page");
			return "Fail";
		}
		return "Pass";
	}

	public static String TestImageLogin() {
		try {
			if (LoginObjects.getImgLogin().isDisplayed())
				Log.info("Login Image Present on Login Page");
		} catch (Exception e) {
			Log.info("Login Image Not Present on login Page");
			return "Fail";
		}
		return "Pass";
	}

	public static String TestEmailInput() {
		// LoginObjects= PageFactory.initElements(driver,
		// LoginObjectsphase2.class);
		try {
			if (LoginObjects.getInputEmail().isDisplayed())
				Log.info("Email input field Present on login Page");
		} catch (Exception e) {
			Log.info("Email input field Not Present on login Page");
			return "fail";
		}
		return "Pass";
	}

	public static String TestPasswordInput() {
		// LoginObjects= PageFactory.initElements(driver,
		// LoginObjectsphase2.class);

		try {
			if (LoginObjects.getInputPassword().isDisplayed())
				Log.info("Password input field Present on login Page");
		} catch (Exception e) {
			Log.info("Password input field Not Present on login Page");
			return "fail";
		}
		return "Pass";
	}

	public static String TestLoginButton() {
		// LoginObjects= PageFactory.initElements(driver,
		// LoginObjectsphase2.class);

		try {
			if (LoginObjects.getButtonLogin().isDisplayed())
				Log.info("Login button Present on login Page");
		} catch (Exception e) {
			Log.info("Login button Not Present on login Page");
			return "Fail";
		}
		return "Pass";
	}

	public static String TestBottomHead() {
		try {
			if (LoginObjects.getBottemHead().isDisplayed())
				Log.info(LoginObjects.getBottemHead().getText() + " is present");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.warn("? DubLabs Version x.x.x is not present");
			return "Fail";
		}
		return "Pass";
	}

	public static String TestURL(String Url) throws Exception {
		try {
			String currentUrl = driver.getCurrentUrl();
			// Assert.assertEquals(currentUrl, Url);

			if (currentUrl.equals(Url)) {
				// System.out.println("Correct URL opens");
				Log.info("Login button Not Present on login Page");
			} else
				return "Fail";
		} catch (Exception e) {
			Log.info("Wrong URL open in browser");
			return "Fail";
		}
		return "Pass";

	}

	public static String LoginErrorMessage(String username, String password, String ExpetedError) {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			LoginObjects.getInputEmail().sendKeys(username);
			LoginObjects.getInputPassword().sendKeys(password);
			LoginObjects.getButtonLogin().click();
			String currentMessage = LoginObjects.getHeaderTextOfError().getText();
			// LoginObjects.getBodyTextOfError().getText().equals("There was a
			// problem authenticating with the server. Please check your
			// credentials.");
			if (currentMessage.equalsIgnoreCase(ExpetedError))
				return "Pass";
			else
				return "Fail";
		} catch (Exception e) {
			Log.info("Wrong Error message display");
			return "Fail";
		}

	}

	public static String InvalidLoginErrorMessage(String Username, String Password, String Errormessage) {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			LoginObjects.getInputEmail().sendKeys(Username);
			LoginObjects.getInputPassword().sendKeys(Password);
			LoginObjects.getButtonLogin().click();
			Thread.sleep(2000);
			if (LoginObjects.getImgDubLabs().isDisplayed() && LoginObjects.getImgLogin().isDisplayed()
					&& LoginObjects.getInputEmail().isDisplayed() && LoginObjects.getInputPassword().isDisplayed()
					&& LoginObjects.getButtonLogin().isDisplayed()) {
				// if(LoginObjects.getHeaderTextOfError().getText().equals(Errormessage))
				System.out.println("Error message display and Login page display again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Error message not display");
			return "Fail";
		}
		return "Pass";
	}

	public static String ValidLogin(String username, String password) {
		try {
			LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
			LoginObjects.getInputEmail().sendKeys(username);
			LoginObjects.getInputPassword().sendKeys(password);
			LoginObjects.getButtonLogin().click();
			if (LoginObjects.Logoutbutton().isDisplayed()) {
				System.out.println("User Logged in successfully ");
				LoginObjects.Logoutbutton().click();
			} else
				return "Fail";
		} catch (Exception e) {
			Log.info("Not able to login with valid user hence FAIL");
			System.out.println(e.getMessage());
			return "Fail";
		}
		return "Pass";
	}

	public static void Login(String Username, String Password) {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			LoginObjects.getInputEmail().sendKeys(Username);
			LoginObjects.getInputPassword().sendKeys(Password);
			LoginObjects.getButtonLogin().click();
		} catch (Exception e) {
			Log.info("Not able to login with valid user hance FAIL");
		}
	}

	public static void Logout() throws Exception {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		LoginObjects.Logoutbutton().click();

	}

	public static String DisplayLoginPage() {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			if (LoginObjects.getImgDubLabs().isDisplayed() && LoginObjects.getImgLogin().isDisplayed()
					&& LoginObjects.getInputEmail().isDisplayed() && LoginObjects.getInputPassword().isDisplayed()
					&& LoginObjects.getButtonLogin().isDisplayed()) {
				System.out.println("Error message display and Login page display again");
			}
		} catch (Exception e) {
			Log.info("Login page not display hence FAIL");
			return "Fail";
		}
		return "Pass";
	}

	public static String ForgotpasswordUIVerification() {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			LoginObjects.TextForgotpassword().click();
			Thread.sleep(500);
			if (LoginObjects.GetForgotPasswordEmail().isDisplayed()
					&& LoginObjects.GetForgotPasswordCancelButton().isDisplayed()
					&& LoginObjects.GetForgotPasswordResetButton().isDisplayed()) {
				String placeholdertext = LoginObjects.GetForgotPasswordEmail().getAttribute("placeholder");
				if (placeholdertext.equals("Enter your email address"))
					System.out.println("Correct place holder text display");
				else {
					System.out.println("Placeholder text not display");
					throw new ElementNotVisibleException("Place Holder not display");
				}
			}
		} catch (Exception e) {
			Log.info("Forgot password UI is not correct");
			return "Fail";
		}
		return "Pass";
	}

	public static String ForgotPassword(String Username, String ExpectedMessage) {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			LoginObjects.TextForgotpassword().click();
			Thread.sleep(500);
			LoginObjects.GetForgotPasswordEmail().sendKeys(Username);
			LoginObjects.GetForgotPasswordResetButton().click();
			WebElement messagebar = LoginObjects.GetPopupMessage();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//div[@class = 'floating-dialog']/div/span")));
			System.out.println(messagebar.isDisplayed());
			String Actualresult = messagebar.getText();
			System.out.println("----Real show message " + Actualresult);
			if (Actualresult.equals(ExpectedMessage)) {
				Log.info("Email sent message display");
				return "Pass";
			} else
				return "Fail";
		} catch (Exception e) {
			Log.info("Message not display ");
			System.out.println("Error shows and message not display" + e.getMessage());
			return "Fail";
		}

	}

	public static String ForgotPassword_cancel() {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			LoginObjects.TextForgotpassword().click();
			LoginObjects.GetForgotPasswordCancelButton().click();
			try {
				if ((LoginObjects.GetForgotPasswordEmail().isDisplayed())) {
					Log.info("Forgot password window close");
					;
					System.out.println("Forgot password window close");
					return "Pass";
				}
			} catch (Exception a) {
				Log.info("Window not close");
			}
		} catch (Exception e) {
			Log.info("Forgot password window not close");
			return "Fail";
		}
		return "Pass";
	}

	public static String RememberMe(String username, String password, String rememberMe) {
		// String DataSheet = Constant.REMEMBERME;

		try {
			if (Constant.BROWSER_NAME.equalsIgnoreCase("Chrome")) {
				System.clearProperty("webdriver.chrome.driver");
				File chromeFile = new File(chromePath);
				System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				options.addArguments("user-data-dir=Temp/cookies");
				capabilities.setCapability("chrome.binary", "res/chromedriver.exe");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();
				driver.get(Constant.URL);
				LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
				Thread.sleep(3000);
				LoginObjects.getInputEmail().sendKeys(username);
				LoginObjects.getInputPassword().sendKeys(password);
				if (rememberMe.equalsIgnoreCase("Yes"))
					LoginObjects.getRememberMeCheckbox().click();

				LoginObjects.getButtonLogin().click();
				Thread.sleep(2000);
				driver.close();
				driver = new ChromeDriver(capabilities);
				driver.get(Constant.URL);
				Thread.sleep(5000);
				boolean result = driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
				// boolean result =LoginObjects.getButtonLogin().isDisplayed();
				if (result)
					System.out.println("App is auto login");
				else
					System.out.println("Not loged in");
			}

			if (Constant.BROWSER_NAME.equalsIgnoreCase("Firefox")) {

				ProfilesIni allProfiles = new ProfilesIni();
				FirefoxProfile profile = allProfiles.getProfile("selenium");
				driver = new FirefoxDriver(profile);
				// driver.manage().window().maximize();
				driver.get(Constant.URL);
				LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
				Thread.sleep(3000);
				LoginObjects.getInputEmail().sendKeys(username);
				LoginObjects.getInputPassword().sendKeys(password);
				if (rememberMe.equalsIgnoreCase("Yes"))
					LoginObjects.getRememberMeCheckbox().click();
				LoginObjects.getButtonLogin().click();
				Thread.sleep(2000);

				Set<Cookie> cookies = driver.manage().getCookies();
				driver.close();
				driver = new FirefoxDriver();

				for (Cookie getCookie : cookies) {
					if (getCookie.getDomain().equalsIgnoreCase(Constant.URL)) {
						driver.manage().addCookie(getCookie);
					}
					driver.navigate().to(Constant.URL);
				}
				Thread.sleep(4000);
				boolean result = driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
				if (result)
					System.out.println("logged in ");
				else
					System.out.println("Not logged in ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Remember me not working");
			return "Fail";
		}
		return "Pass";
	}

	public static void browserClose() {
		driver.close();
	}

	public static void browserQuit() {
		driver.quit();
	}

	public static void deleteSavedCookies(String SRC_FOLDER) {
		File directory = new File(SRC_FOLDER);
		// make sure directory exists
		if (!directory.exists()) {
			System.out.println("Directory does not exist.");
			System.exit(0);
		} else {
			try {
				delete(directory);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		System.out.println("Done");
	}

	public static void delete(File file) throws IOException {
		if (file.isDirectory()) {
			// directory is empty, then delete it
			if (file.list().length == 0) {
				file.delete();
				System.out.println("Directory is deleted : " + file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : " + file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	public static String RoleAuthentication(String userName, String password, String userType, String Role) {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		try {
			LoginObjects.getInputEmail().sendKeys(userName);
			LoginObjects.getInputPassword().sendKeys(password);
			LoginObjects.getButtonLogin().click();

			if (userType.equals("Dub admin")) {
				try {
					if (LoginObjects.GetButtonMobileApps().isDisplayed() 
							&& LoginObjects.GetButtonChat().isDisplayed()
							&& LoginObjects.GetButtonUsers().isDisplayed()
							&& LoginObjects.GetButtonReports().isDisplayed()
							&& LoginObjects.GetButtonAdmin().isDisplayed()
							&& LoginObjects.GetButtonPages().isDisplayed()
							&& LoginObjects.GetButtonHelp().isDisplayed()) {
						LoginObjects.GetButtonChat().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Chat screen");
						} else
							return "Fail";
						LoginObjects.GetButtonUsers().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Users screen");
						} else
							return "Fail";

						LoginObjects.GetButtonReports().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Reports screen");
						} else
							return "Fail";

						LoginObjects.GetButtonAdmin().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Admin screen");
						} else
							return "Fail";

						LoginObjects.GetButtonPages().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Pages screen");
						} else
							return "Fail";

						LoginObjects.GetButtonHelp().click();
						Thread.sleep(4000);
						if (LoginObjects.GetButtonLogout().isDisplayed()) {
							Log.info("Logout button display on Help screen");
						} else
							return "Fail";

					}

				} catch (Exception e) {
					System.out.println("Error in Dub admin user");
					return "Fail";

				}
			} else {
				switch (Role) {
				case "Branding":
					WebDriverWait wait1 = new WebDriverWait(driver, 5);
					WebElement element1 = wait1
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='logoutBtn']")));
					try {
						if (LoginObjects.GetButtonMobileApps().isDisplayed()
								&& LoginObjects.GetButtonChat().isDisplayed()
								&& LoginObjects.GetButtonUsers().isDisplayed()
								&& LoginObjects.GetButtonHelp().isDisplayed()) {
							LoginObjects.GetButtonChat().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Chat screen");
							} else
								return "Fail";
							LoginObjects.GetButtonUsers().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on User screen");
							} else
								return "Fail";
							LoginObjects.GetButtonHelp().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Help screen");
							} else
								return "Fail";
						}
						return "Pass";

					} catch (Exception e) {
						System.out.println("Error on Branding");
						return "Fail";
					}

				case "Reports":
					WebDriverWait wait2 = new WebDriverWait(driver, 5);
					WebElement element2 = wait2
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='logoutBtn']")));
					try {
						if (LoginObjects.GetButtonChat().isDisplayed() && LoginObjects.GetButtonUsers().isDisplayed()
								&& LoginObjects.GetButtonHelp().isDisplayed()) {
							LoginObjects.GetButtonChat().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Chat screen");
							} else
								return "Fail";
							LoginObjects.GetButtonUsers().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on User screen");
							} else
								return "Fail";

							LoginObjects.GetButtonHelp().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Help screen");
							}
							} else
								return "Fail";
						return "Pass";
					} catch (Exception e) {
						System.out.println("Error on Reports");
						return "Fail";
					}

				case "View-Only":
					WebDriverWait wait3 = new WebDriverWait(driver, 5);
					WebElement element3 = wait3
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='logoutBtn']")));
					try {
						if (LoginObjects.GetButtonMobileApps().isDisplayed()
								&& LoginObjects.GetButtonChat().isDisplayed()
								&& LoginObjects.GetButtonUsers().isDisplayed()
								&& LoginObjects.GetButtonReports().isDisplayed()
								&& LoginObjects.GetButtonPages().isDisplayed()
								&& LoginObjects.GetButtonHelp().isDisplayed()) {
							LoginObjects.GetButtonMobileApps().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Chat screen");
							} else
								return "Fail";

							LoginObjects.GetButtonChat().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Chat screen");
							} else
								return "Fail";

							LoginObjects.GetButtonUsers().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Users screen");
							} else
								return "Fail";

							LoginObjects.GetButtonReports().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Reports screen");
							} else
								return "Fail";

							LoginObjects.GetButtonPages().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Pages screen");
							} else
								return "Fail";

							LoginObjects.GetButtonHelp().click();
							Thread.sleep(4000);
							if (LoginObjects.GetButtonLogout().isDisplayed()) {
								Log.info("Logout button display on Help screen");
							} else
								return "Fail";
						} else {
							return "Fail";
						}
						return "Pass";
					} catch (Exception e) {
						System.out.println("Error on Branding");
						return "Fail";
					}

				}// switch
			} // else

		} catch (Exception e) {
			Log.info("Unable to login with given user");
			System.out.println("Unable to login with given user");
		}
		return "Pass";
	}

	public static String RememberMeUnchecked(String username, String password, String rememberme) {
		try {
			Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
			LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
			LoginObjects.getInputEmail().sendKeys(username);
			LoginObjects.getInputPassword().sendKeys(password);
			LoginObjects.getButtonLogin().click();
			Utils.driver.close();
			Utils.OpenBrowser(Constant.BROWSER_NAME, Constant.URL);
			String Loginpage = LoginElements();
			if (Loginpage.equalsIgnoreCase("Pass"))
				return "Pass";
			else
				return "Fail";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
	}

	public static String login_step(String username, String password, String rememberme) throws InterruptedException {
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		LoginObjects = PageFactory.initElements(driver, LoginObjectsphase2.class);
		LoginObjects.getInputEmail().clear();
		LoginObjects.getInputEmail().sendKeys(username);
		LoginObjects.getInputPassword().clear();
		LoginObjects.getInputPassword().sendKeys(password);
		if (rememberme.equalsIgnoreCase("Yes")) {
			LoginObjects.getRememberMeCheckbox().click();
		} else
			System.out.println("Remember me not checked");
		LoginObjects.getButtonLogin().click();
		Thread.sleep(4000);
		if (LoginObjects.Logoutbutton().isDisplayed()) {
			System.out.println("User Logged in successfully ");
		} else
			System.out.println("User not logged in");

		List<WebElement> listAllLinks = driver.findElements(By.cssSelector(".active-container>ul>li>a"));
		for (WebElement webElement : listAllLinks) {
			String list = webElement.getText();
			if (list != null) {
				if (list.contentEquals("Admin")) {
					System.out.println("User is a Dub System Admin");
					return "DUB System Admin";
				}
			}
		}
		return "Partner Admin";

	}

}
