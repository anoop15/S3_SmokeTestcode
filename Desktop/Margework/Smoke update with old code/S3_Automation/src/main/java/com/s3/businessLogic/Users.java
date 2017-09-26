package com.s3.businessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.s3.objectRepository.AdminUser_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class Users extends Utils {
	Utils utils = new Utils();
	private static WebElement element = null;
	static AdminUser_Objects AdminUserObject;

	public static void clkUsers() throws Exception {
		AdminUserObject = PageFactory.initElements(driver,
				AdminUser_Objects.class);
		element = AdminUserObject.getClkUsers();
		Utils.waitForElementToBeClickable(element);
		element.click();

	}

	public static void createNewUser(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		Thread.sleep(4000);
		// boolean isUserRolePresent;
		//AdminUserObject.getClkCreateNewUser().click();
		element=AdminUserObject.getClkCreateNewUser();
		Utils.waitForElementToBeClickable(element);
		element.click();
		String firstName = ExcelUtils.getCellData(1, 3, ExcelFile,
				ExcelSheetName);
		AdminUserObject.getFirstName().sendKeys(firstName);
		String lastName = ExcelUtils.getCellData(1, 4, ExcelFile,
				ExcelSheetName);
		AdminUserObject.getLastName().sendKeys(lastName);
		String email = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		AdminUserObject.getEmail().sendKeys(email);
		String userType = ExcelUtils.getCellData(1, 6, ExcelFile,
				ExcelSheetName);
		String partner = ExcelUtils
				.getCellData(1, 7, ExcelFile, ExcelSheetName);
		String client = ExcelUtils.getCellData(1, 8, ExcelFile, ExcelSheetName);
		Select userRole = new Select(AdminUserObject.getSelectUserType());
		String userTypeName = userRole.getFirstSelectedOption().getText();
		System.out.println(userTypeName);
		if (null != userTypeName) {
			if (userTypeName.equalsIgnoreCase("DUB System Admin")) {
				System.out.println("User Is DUB System Admin");
			} else if (userTypeName.equalsIgnoreCase("Partner Admin")) {
				System.out.println("User Is Partner Admin");
			} else if (userTypeName.equalsIgnoreCase("Client Admin")) {
				System.out.println("User Is Client Admin");
			} else {// System.out.println("Not a valid data from Drop-Down");
			}
		}

		if ((userType.equalsIgnoreCase("DUB System Admin")
				|| userType.equalsIgnoreCase("Partner Admin") || userType
					.equalsIgnoreCase("Client Admin"))
				&& userTypeName.equalsIgnoreCase("DUB System Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(client);

				String saveOrClose = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}

			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();

			}

		} else if ((userType.equalsIgnoreCase("Partner Admin") || userType
				.equalsIgnoreCase("Client Admin"))
				&& userTypeName.equalsIgnoreCase("Partner Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(client);

				String saveOrClose = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();
			}

		} else if (userType.equalsIgnoreCase("Client Admin")
				&& userTypeName.equalsIgnoreCase("Client Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(client);

				String saveOrClose = ExcelUtils.getCellData(1, 9, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();
			}

		} else {
			AdminUser_Objects.saveOrClose = "Close";
			driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
					.click();
		}

	}

	public static void veriCreatedUser(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		boolean isSearched = false;
		// String FirstName= ExcelUtils.getCellData(1,3, ExcelFile,
		// ExcelSheetName);
		// String LastName= ExcelUtils.getCellData(1,4, ExcelFile,
		// ExcelSheetName);
		String email = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		// String Name= FirstName+" "+LastName;
		Thread.sleep(1000);
		AdminUserObject.getsearch().clear();
		AdminUserObject.getsearch().sendKeys(email);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		AdminUser_Objects.userEmail = email;
		Thread.sleep(1000);
		try {
			isSearched = driver.findElement(
					By.cssSelector(".no-records.dub-font-regular"))
					.isDisplayed();
			System.out.println(driver.findElement(
					By.cssSelector(".no-records.dub-font-regular")).getText());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			e.getStackTrace();
		}
		if (isSearched) {
			System.out
					.println("User has Removed or Deleted /Please Enter Existing User Name in Workbook");
		}
		if (isSearched == false) {
			boolean veriUserName = driver.findElement(
					By.xpath(AdminUser_Objects.getVeriUserName()))
					.isDisplayed();
			if (veriUserName == true) {
				String userName = driver.findElement(
						By.xpath(AdminUser_Objects.getVeriUserName()))
						.getText();
				System.out.println(userName + "UserName is verifyed");
			} else {
				System.out.println("UserName does not Present/Match");
			}
			boolean veriUserType = driver.findElement(
					By.xpath(AdminUser_Objects.getVeriUserType()))
					.isDisplayed();
			if (veriUserType == true) {
				String userType = driver.findElement(
						By.xpath(AdminUser_Objects.getVeriUserType()))
						.getText();
				System.out.println(userType + "UserType is Verifyed");
			} else {
				System.out.println("UserType is not Match/Displayed");
			}
		}
	}

	public static void editUser(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		// String firstName = ExcelUtils.getCellData(1, 3, ExcelFile,
		// ExcelSheetName);
		// String lastName = ExcelUtils.getCellData(1, 4, ExcelFile,
		// ExcelSheetName);
		String email = ExcelUtils.getCellData(1, 5, ExcelFile, ExcelSheetName);
		// String name = firstName + " " + lastName;
		AdminUserObject.getsearch().clear();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		AdminUserObject.getsearch().sendKeys(email);
		action.sendKeys(Keys.ENTER).perform();
		AdminUser_Objects.userEmail = email;
		Thread.sleep(2000);
		driver.findElement(By.xpath(AdminUser_Objects.getClkEditImg())).click();
		String newFirstName = ExcelUtils.getCellData(1, 10, ExcelFile,
				ExcelSheetName);
		AdminUserObject.getFirstName().clear();
		AdminUserObject.getFirstName().sendKeys(newFirstName);
		String newLastName = ExcelUtils.getCellData(1, 11, ExcelFile,
				ExcelSheetName);
		AdminUserObject.getLastName().clear();
		AdminUserObject.getLastName().sendKeys(newLastName);
		String userType = ExcelUtils.getCellData(1, 12, ExcelFile,
				ExcelSheetName);
		String Partner = ExcelUtils.getCellData(1, 13, ExcelFile,
				ExcelSheetName);
		String Client = ExcelUtils
				.getCellData(1, 14, ExcelFile, ExcelSheetName);
		Thread.sleep(1000);
		Select userRole = new Select(AdminUserObject.getSelectUserType());
		String userTypeName = userRole.getFirstSelectedOption().getText();
		System.out.println(userTypeName);
		if (null != userTypeName) {
			if (userTypeName.equalsIgnoreCase("DUB System Admin")) {
				System.out.println("User Is DUB System Admin");
			} else if (userTypeName.equalsIgnoreCase("Partner Admin")) {
				System.out.println("User Is Partner Admin");
			} else if (userTypeName.equalsIgnoreCase("Client Admin")) {
				System.out.println("User Is Client Admin");
			} else {// System.out.println("Not a valid data from Drop-Down");
			}
		}
		if ((userType.equalsIgnoreCase("DUB System Admin")
				|| userType.equalsIgnoreCase("Partner Admin") || userType
					.equalsIgnoreCase("Client Admin"))
				&& userTypeName.equalsIgnoreCase("DUB System Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(Partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(Client);
				String saveOrClose = ExcelUtils.getCellData(1, 15, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}
				String newName = newFirstName + " " + newLastName;
				AdminUserObject.getsearch().clear();
				AdminUserObject.getsearch().sendKeys(email);
				action.sendKeys(Keys.ENTER).perform();

				boolean variNewName = driver.findElement(
						By.xpath(AdminUser_Objects.getVeriUserName()))
						.isDisplayed();
				if (variNewName) {
					String newUserName = driver.findElement(
							By.xpath(AdminUser_Objects.getVeriUserName()))
							.getText();
					if (newName.equals(newUserName))
						System.out.println(newUserName + "is New UserName");
				} else
					System.out.println("UserName Does not Match/Displayed");
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();
			}
		} else if ((userType.equalsIgnoreCase("Partner Admin") || userType
				.equalsIgnoreCase("Client Admin"))
				&& userTypeName.equalsIgnoreCase("Partner Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(Partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(Client);
				String saveOrClose = ExcelUtils.getCellData(1, 15, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}
				String newName = newFirstName + " " + newLastName;
				AdminUserObject.getsearch().clear();
				AdminUserObject.getsearch().sendKeys(email);
				action.sendKeys(Keys.ENTER).perform();

				boolean variNewName = driver.findElement(
						By.xpath(AdminUser_Objects.getVeriUserName()))
						.isDisplayed();
				if (variNewName) {
					String newUserName = driver.findElement(
							By.xpath(AdminUser_Objects.getVeriUserName()))
							.getText();
					if (newName.equals(newUserName))
						System.out.println(newUserName + "is New UserName");
				} else
					System.out.println("UserName Does not Match/Displayed");
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();
			}

		} else if (userType.equalsIgnoreCase("Client Admin")
				&& userTypeName.equalsIgnoreCase("Client Admin")) {
			try {
				Select selectUserType = new Select(
						AdminUserObject.getSelectUserType());
				selectUserType.selectByVisibleText(userType);
				Thread.sleep(3000);
				Select selectPartner = new Select(
						AdminUserObject.getSelectPartnerName());
				selectPartner.selectByVisibleText(Partner);
				Thread.sleep(3000);
				Select selectClient = new Select(
						AdminUserObject.getSelectClientName());
				selectClient.selectByVisibleText(Client);
				String saveOrClose = ExcelUtils.getCellData(1, 15, ExcelFile,
						ExcelSheetName);
				AdminUser_Objects.saveOrClose = saveOrClose;
				if (saveOrClose.equalsIgnoreCase("Save")) {

					AdminUser_Objects.saveOrClose = "Save";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();

				} else {

					AdminUser_Objects.saveOrClose = "Close";
					driver.findElement(
							By.xpath(AdminUser_Objects.getSaveorClose()))
							.click();
				}
				String newName = newFirstName + " " + newLastName;
				AdminUserObject.getsearch().clear();
				AdminUserObject.getsearch().sendKeys(email);
				action.sendKeys(Keys.ENTER).perform();

				boolean variNewName = driver.findElement(
						By.xpath(AdminUser_Objects.getVeriUserName()))
						.isDisplayed();
				if (variNewName) {
					String newUserName = driver.findElement(
							By.xpath(AdminUser_Objects.getVeriUserName()))
							.getText();
					if (newName.equals(newUserName))
						System.out.println(newUserName + "is New UserName");
				} else
					System.out.println("UserName Does not Match/Displayed");
			} catch (NoSuchElementException nse) {
				nse.getStackTrace();
				System.out
						.println("Check excel data or element not loaded on webpage");
				AdminUser_Objects.saveOrClose = "Close";
				driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
						.click();
			}

		} else {
			AdminUser_Objects.saveOrClose = "Close";
			driver.findElement(By.xpath(AdminUser_Objects.getSaveorClose()))
					.click();
		}

	}

	public static void deleteUser(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {

		// String deleteUserName = ExcelUtils.getCellData(1, 16, ExcelFile,
		// ExcelSheetName);
		String deleteEmail = ExcelUtils.getCellData(1, 17, ExcelFile,
				ExcelSheetName);
		AdminUserObject.getsearch().clear();
		Actions action = new Actions(driver);
		AdminUserObject.getsearch().sendKeys(deleteEmail);
		action.sendKeys(Keys.ENTER).perform();
		AdminUser_Objects.userEmail = deleteEmail;
		// boolean Search =
		// driver.findElement(By.xpath(AdminUserObject.getClkDeleteImg())).isDisplayed();
		try {
			if (driver.findElement(By.xpath(AdminUser_Objects.getClkDeleteImg())) != null) {
				Thread.sleep(3000);
				driver.findElement(By.xpath(AdminUser_Objects.getClkDeleteImg())).click();
				String removeOrCancel = ExcelUtils.getCellData(1, 18,
						ExcelFile, ExcelSheetName);
				AdminUser_Objects.removeOrCancel = removeOrCancel;
				if (removeOrCancel.equalsIgnoreCase("Remove")) {
					AdminUser_Objects.removeOrCancel = "Remove";
					driver.findElement(
							By.xpath(AdminUser_Objects.getClkRemoveOrCancel()))
							.click();
					AdminUserObject.getsearch().clear();
					AdminUserObject.getsearch().sendKeys(deleteEmail);
					action.sendKeys(Keys.ENTER).perform();
					String massage = driver
							.findElement(
									By.xpath("//span[text()='User does not exist for the search criteria.']"))
							.getText();
					System.out.println(massage);

				} else {

					AdminUser_Objects.removeOrCancel = "Cancel";
					driver.findElement(
							By.xpath(AdminUser_Objects.getClkRemoveOrCancel()))
							.click();
					String variUserName = driver.findElement(
							By.xpath(AdminUser_Objects.getVeriUserName()))
							.getText();
					System.out.println(variUserName);
				}
			}
		} catch (NoSuchElementException Nse) {
			Nse.getMessage();
			System.out.println("User does not exist for the search criteria.");

		}
		// String
		// Massage=driver.findElement(By.xpath("//span[text()='User does not exist for the search criteria.']")).getText();
		// System.out.println(Massage);
	}
}
