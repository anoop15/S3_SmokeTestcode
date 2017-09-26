package com.s3.businessLogic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.s3.objectRepository.Login_Objects;
import com.s3.testCases.TCManagePartners;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class Login extends Utils {
	private static WebElement element = null;

	static Login_Objects loginObject;

	// Create an object of Utils class so it can extends the values here
	Utils utils = new Utils();

	// This method is to perform the login action
	public static void login_steps(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		loginObject = PageFactory.initElements(driver, Login_Objects.class);

		// This is to get the user name value from excel sheet and send it to
		// user name field
		// PlistParser.getInstance();
		String userName = ExcelUtils.getCellData(row, col++, ExcelFile,
				ExcelSheetName);
		loginObject.getUsername().clear();
		loginObject.getUsername().sendKeys(userName);
		Log.info("User name '" + userName + "' entered");

		// This is to get the password value from excel sheet and send it to
		// password field
		String password = ExcelUtils.getCellData(row, col++, ExcelFile,
				ExcelSheetName);
		loginObject.getpassword().clear();
		loginObject.getpassword().sendKeys(password);
		Log.info("password '" + password + "' entered");
		String rememberMe = ExcelUtils.getCellData(row, col++, ExcelFile,
				ExcelSheetName);
		if (rememberMe.equalsIgnoreCase("yes")) {
			loginObject.getRememberME().click();
		} else
			Log.info("user has not selected Remember me check-box");
		loginObject.getbtnlogin().click();
		Thread.sleep(4000);
		List<WebElement> listAllLinks = driver.findElements(By
				.cssSelector(".active-container>ul>li>a"));
		for (WebElement webElement : listAllLinks) {
			String list = webElement.getText();
			if (list != null) {
				if (list.contentEquals("Admin")) {
					System.out.println("User is a Dub System Admin");
				}
			}
		}
		Log.info("Clicked on login button");
		TCManagePartners.mCol = col;
		TCManagePartners.mRow = row;

	}

	public static void TestLoginValidation() {
		loginObject = PageFactory.initElements(driver, Login_Objects.class);

		try {
			if (loginObject.getImgDubLabs().isDisplayed())
				Log.info("DubLabs Image Present on Login Page");
			else
				Log.warn("DubLabs Image Not Present on Login Page");
			if (loginObject.getImgLogin().isDisplayed())
				Log.info("Login Image Present on Login Page");
			else
				Log.warn("Login Image Not Present on Login Page");
			if (loginObject.getBottemHead().isDisplayed())
				Log.info(loginObject.getBottemHead().getText() + " is present");
			else
				Log.warn("? DubLabs Version x.x.x is not present");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public static void TestDatavalidation() throws Exception {
		String currentUrl = driver.getCurrentUrl();
		String[] HomeUrl = currentUrl.split("=");
		if (HomeUrl[0]
				.equals("https://cloud-test.dublabs.com/s3/apps.html?_dub")) {
			element = loginObject.getbtnLogout();
			Utils.waitForElementToBeClickable(element);
			element.click();
		} else {
			//String PopUpMsg = driver.findElement(By.xpath(".//*[@id='popup']/div/div[2]/div/div")).getText();
			String PopUpMsg="Invalid Username or password";
			Log.info(PopUpMsg + "User Has Enter Wrong UserName/Password"+ "Or Both");

		}

	}

	public static void logout() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,-1000)");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginObject.getbtnLogout().click();
	}

}

/*
 * String UsernameWaterImage=
 * loginObject.getUsername().getAttribute("placeholder");
 * System.out.println(UsernameWaterImage);
 * if(UsernameWaterImage.equalsIgnoreCase("Email")) {
 * System.out.println("Username Text-Box Water Image is Email"); } String
 * PasswordWaterImage=loginObject.getpassword().getAttribute("placeholder");
 * if(PasswordWaterImage.equalsIgnoreCase("Password")) {
 * System.out.println("Password Text-Box Water Image is Password"); }
 * if(loginObject.getbtnlogin().isDisplayed()){
 * System.out.println("Login Button "); }
 */
