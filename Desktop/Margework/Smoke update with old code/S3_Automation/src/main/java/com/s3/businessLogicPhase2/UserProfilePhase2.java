package com.s3.businessLogicPhase2;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.bcel.generic.IfInstruction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.s3.objectRepositoryPhase2.UserProfileObjectsPhase2;
import com.s3.utility.Log;
import com.s3.utility.Utils;
import com.sun.jna.platform.win32.Netapi32Util.User;

public class UserProfilePhase2 extends Utils {

	static UserProfileObjectsPhase2 UserProfileObjects;
	static public int DataRow;
	static WebElement element;
	static public String loggedusertype;

	// static{
	// UserProfileObjects = PageFactory.initElements(driver,
	// UserProfileObjectsPhase2.class);
	// }
	public UserProfilePhase2() {
		// TODO Auto-generated constructor stub
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
	}

	public static void clkUsers() throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		element = UserProfileObjects.getClkUsers();
		Utils.waitForElementToBeClickable(element);
		element.click();
	}

	public static String UserProfileElements(String username, String usertype) {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.getButtonCreateUser().isDisplayed())
				Log.info("Create User Button Present on Manage Your Users Page");
			if (UserProfileObjects.getTextboxSearch().isDisplayed())
				Log.info("Search Textbox Present on Manage Your Users Page");
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (usertype.equalsIgnoreCase("Admin") && TotalRows.size() > 0) {
				boolean[] array = new boolean[TotalRows.size()];
				for (int i = 1; i <= TotalRows.size(); i++) {
					WebElement element1 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[1]"));
					WebElement element2 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
					WebElement element3 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[3]"));
					WebElement element4 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[4]"));
					WebElement element5 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[5]"));
					WebElement element6 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[6]/img"));
					WebElement element7 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[7]/img"));
					if (!username.equalsIgnoreCase(element2.getText())) {
						WebElement element8 = driver.findElement(
								By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[8]/img"));
						if (element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed()
								&& element4.isDisplayed() && element5.isDisplayed() && element6.isDisplayed()
								&& element7.isDisplayed() && element8.isDisplayed())
							array[i - 1] = true;
						else
							array[i - 1] = false;
					} else {
						if (element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed()
								&& element4.isDisplayed() && element5.isDisplayed() && element6.isDisplayed()
								&& element7.isDisplayed())
							array[i - 1] = true;
						else
							array[i - 1] = false;
					}
				}
				for (int k = 0; k < TotalRows.size(); k++) {
					if (array[k])
						// System.out.println(array[k]);
						Log.info("Element present" + array[k]);
					else
						throw new Exception("Icon not present");
				}
			} else if (usertype.equalsIgnoreCase("Partner") && TotalRows.size() > 0) {
				boolean[] array = new boolean[TotalRows.size()];
				for (int i = 1; i <= TotalRows.size(); i++) {
					WebElement element1 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[1]"));
					WebElement element2 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
					WebElement element3 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[3]"));
					WebElement element4 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[4]"));
					WebElement element5 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[5]"));
					WebElement element6 = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[6]/img"));
					// WebElement element7
					// =driver.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr["+i+"]/td[7]/img"));
					if (!username.equalsIgnoreCase(element2.getText())) {
						WebElement element7 = driver.findElement(
								By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[7]/img"));
						if (element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed()
								&& element4.isDisplayed() && element5.isDisplayed() && element6.isDisplayed()
								&& element7.isDisplayed())
							array[i - 1] = true;
						else
							array[i - 1] = false;
					} else {
						if (element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed()
								&& element4.isDisplayed() && element5.isDisplayed() && element6.isDisplayed())
							array[i - 1] = true;
						else
							array[i - 1] = false;
					}
				}
				for (int k = 0; k < TotalRows.size(); k++) {
					if (array[k])
						// System.out.println(array[k]);
						Log.info("Element present" + array[k]);
					else
						throw new Exception("Icon not present");
				}

			} else {
				System.out.println("User data not available");
				Log.info("User data not available");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Element not display");
			return "Fail";
		}
		return "Pass";
	}

	// This method verifies appearance of Create New user Popup
	public static String Popup_CreateNewUser() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			WebElement messagebar = UserProfileObjects.getButtonCreateUser();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='manage-page-body']/table ")));
			// Thread.sleep(2000);
			messagebar.click();
			;
			if (UserProfileObjects.GetPopupNewuser().isDisplayed())
				return "Pass";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Dialog not display");
			return "Fail";
		}
		return "Pass";
	}

	// This method for UI Verification of create new user popup
	public static String UI_Verification_CreateNewUser(String loggedinusertype, String selectusertype, String partner) {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			WebElement messagebar = UserProfileObjects.getButtonCreateUser();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='manage-page-body']/table ")));
			// Thread.sleep(2000);
			messagebar.click();
			;
			if (UserProfileObjects.FirstNameTextbox().isDisplayed()
					&& UserProfileObjects.LastNameTextbox().isDisplayed()
					&& UserProfileObjects.EmailTextbox().isDisplayed()
					&& UserProfileObjects.UserTypeDropdown().isDisplayed()
					&& UserProfileObjects.PartnerDropdown().isDisplayed()
					&& UserProfileObjects.ClientDropdown().isDisplayed()
					&& UserProfileObjects.RolesDropdown().isDisplayed()
					&& UserProfileObjects.GetEmailFrequency().isDisplayed()
					&& UserProfileObjects.ButtonSave().isDisplayed()
					&& UserProfileObjects.getButtonclose().isDisplayed()
					&& UserProfileObjects.getTopButtonclose().isDisplayed()) {
				Thread.sleep(2000);
				switch (loggedinusertype) {
				case "DUB System Admin":
					// This is verification for User Type according to Logged in
					// user is DUB System Admin
					String[] expected = { "DUB System Admin", "Partner Admin", "Client Admin" };
					WebElement dropdown = driver.findElement(By.id("displayRole"));
					Select select = new Select(dropdown);
					List<WebElement> options = select.getOptions();
					if (options.size() == expected.length) {
						for (int i = 0; i < expected.length; i++) {
							boolean match = false;
							for (WebElement we : options) {
								System.out.println(expected[i] + "-------" + we.getText());
								if (we.getText().equals(expected[i])) {
									match = true;
								}
							}
							Assert.assertTrue(match);
						}

					} else
						Assert.assertTrue(false);

					break;
				case "Partner Admin":
					// This is verification for User Type according to Logged in
					// user is Partner Admin
					String[] expected1 = { "Partner Admin", "Client Admin" };
					WebElement dropdown1 = driver.findElement(By.id("displayRole"));
					Select select1 = new Select(dropdown1);
					List<WebElement> options1 = select1.getOptions();
					if (options1.size() == expected1.length) {

						for (int i = 0; i < expected1.length; i++) {
							boolean match = false;
							for (WebElement we : options1) {
								System.out.println(expected1[i] + "-------" + we.getText());
								if (we.getText().equals(expected1[i])) {
									match = true;
								}
							}
							Assert.assertTrue(match);
						}
					} else
						Assert.assertTrue(false);
					break;

				case "Client Admin":
					// This is verification for User Type according to Logged in
					// user is Client Admin
					String[] expected2 = { "Client Admin" };
					WebElement dropdown2 = driver.findElement(By.id("displayRole"));
					Select select2 = new Select(dropdown2);
					List<WebElement> options2 = select2.getOptions();
					if (options2.size() == expected2.length) {
						for (int i = 0; i < expected2.length; i++) {
							boolean match = false;
							for (WebElement we : options2) {
								System.out.println(expected2[i] + "-------" + we.getText());

								if (we.getText().equals(expected2[i])) {
									match = true;
								}
							}
							Assert.assertTrue(match);
						}
					} else
						Assert.assertTrue(false);
					break;

				}

				// Select dropdown = new
				// Select(driver.findElement(By.id("displayRole")));
				// dropdown.selectByVisibleText("Partner Admin");
				driver.findElement(By.id("displayRole")).sendKeys(selectusertype);
			//	driver.findElement(By.id("displayPartnerId")).
				Thread.sleep(5000);
				System.out.println("------ Partner List load-------");
				WebElement partnerlist = driver.findElement(By.id("displayPartnerId"));
				Select select2 = new Select(partnerlist);
				List<WebElement> partneroptions = select2.getOptions();
				for (WebElement we : partneroptions) {
					System.out.println(we.getText());
				}
				if (partneroptions.size() > 0)
					Assert.assertTrue(true);
				else
					Assert.assertTrue(false);

				driver.findElement(By.id("displayPartnerId")).sendKeys(partner);
				Thread.sleep(5000);
				System.out.println("------------client list load----------");
				WebElement clientlist = driver.findElement(By.id("displayClientId"));
				Select clients = new Select(clientlist);
				List<WebElement> clientsoptions = clients.getOptions();
				for(WebElement we : clientsoptions)
					System.out.println(we.getText());
				if (clientsoptions.size() > 0)
					Assert.assertTrue(true);
				else
					Assert.assertTrue(false);

				System.out.println("------------Roles----------");
				List<WebElement> Roles = driver.findElements(
						By.xpath("//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all']"));
				for (WebElement suggestion : Roles) {
					System.out.println(suggestion.getText());
				}

				System.out.println("------------Email frequency----------");

				String[] expectedEmailfrequency = { "Never", "Daily", "Weekly", "Monthly" };
				WebElement Emailfrequncy = driver.findElement(By.id("emailFrequency"));
				Select Emailfrequncylist = new Select(Emailfrequncy);
				List<WebElement> EmailFrequncyoptions = Emailfrequncylist.getOptions();
				if (EmailFrequncyoptions.size() == expectedEmailfrequency.length) {
					for (int i = 0; i < expectedEmailfrequency.length; i++) {
						boolean match = false;
						for (WebElement we : EmailFrequncyoptions) {
							System.out.println(expectedEmailfrequency[i] + "-------" + we.getText());
							if (we.getText().equals(expectedEmailfrequency[i])) {
								match = true;
							}
						}
						Assert.assertTrue(match);
					}
				} else
					Assert.assertTrue(false);
				return "Pass";

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Dialog not display");
			return "Fail";
		}
		return "Pass";

	}

	public static String TestButtonCreateUser() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.getButtonCreateUser().isDisplayed()) {
				Log.info("Create User Button Present on Manage Your Users Page");
			}
		} catch (Exception e) {
			Log.warn("Create User Button Not Present on Manage Your Users Page");
			return "Fail";
		}
		return "Pass";

	}

	public static String TestTextboxSearch() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.getTextboxSearch().isDisplayed()) {
				Log.info("Search Textbox Present on Manage Your Users Page");
			}
		} catch (Exception e) {
			Log.warn("Search Textbox Not Present on Manage Your Users Page");
			return "Fail";
		}

		return "Pass";

	}

	public static String TestImageChangePassword() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.ChangePassImage().isDisplayed()) {
				Log.info("Change Password Image Present on Manage Your Users Page");
			}
		} catch (Exception e) {
			Log.warn("Change Password Image Not Present on Manage Your Users Page");
			return "Fail";
		}
		return "Pass";

	}

	public static String TestImageEditUser() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.EditUserImage().isDisplayed()) {
				Log.info("Edit User Image Present on Manage Your Users Page");
			}

		} catch (Exception e) {
			Log.warn("Edit User Image Not Present on Manage Your Users Page");
			return "Fail";

		}
		return "Pass";
	}

	public static String TestImageRemoveUser() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.RemoveUserImage().isDisplayed()) {
				Log.info("Remove User Image Present on Manage Your Users Page");
			}

		} catch (Exception e) {
			Log.warn("Remove User Image Not Present on Manage Your Users Page");
			return "Fail";

		}
		return "Pass";
	}

	public static String TestFirstNameTextbox() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.FirstNameTextbox().isDisplayed()) {
				Log.info("First Name Textbox Present on Create New User Page");
			}

		} catch (Exception e) {
			Log.warn("First Name Textbox Not Present on Create New User Page");
			return "Fail";

		}
		return "Pass";
	}

	public static String TestLastNameTextbox() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.LastNameTextbox().isDisplayed()) {
				Log.info("Last Name Textbox Present on Create New User Page");
			}

		} catch (Exception e) {
			Log.warn("Last Name Textbox Not Present on Create New User Page");
			return "Fail";

		}
		return "Pass";
	}

	public static String TestEmailTextbox() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			if (UserProfileObjects.EmailTextbox().isDisplayed()) {
				Log.info("Email Textbox Present on Create New User Page");
			}

		} catch (Exception e) {
			Log.warn("Email Textbox Not Present on Create New User Page");
			return "Fail";

		}
		return "Pass";
	}

	public static void VerifyDropdownValue(WebElement element, String value) {
		try {

			Select select = new Select(element);
			List<WebElement> dropdown = select.getOptions();
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText();
				if (drop_down_values.equalsIgnoreCase(value)) {
					Log.info(value + " match from Dropdown value");
				}
			}

		} catch (Exception e) {
			Log.warn(value + " does not match from Dropdown value");

		}

	}

	public void selectFromDropDown(WebElement wb, String Text) {
		try {
			Select sel = new Select(wb);
			sel.selectByVisibleText(Text);
			Log.info("value " + Text + "selected from the drop down");
		} catch (WebDriverException e) {
			System.out.println(e.getLocalizedMessage());
			Log.error("unable to select " + Text + "from dropdown");
		}

	}

	public void selectFromDropDownbyindex(WebElement wb, int index) {
		try {
			Select sel = new Select(wb);
			sel.selectByIndex(index);
			Log.info("value at index" + index + "selected from the drop down");
		} catch (WebDriverException e) {
			System.out.println(e.getLocalizedMessage());
			Log.error("unable to select value from index " + index + "from dropdown");
		}

	}

	public void selectFromDropDownbyvalue(WebElement wb, String value) {
		try {
			Select sel = new Select(wb);
			sel.selectByValue(value);
			Log.info("value " + value + "selected from the drop down");
		} catch (WebDriverException e) {
			System.out.println(e.getLocalizedMessage());
			Log.error("unable to select " + value + "from dropdown");
		}

	}

	public static void VerifyColumnName(WebElement element, String value) {

		try {
			List<WebElement> rows_table = element.findElements(By.tagName("tr"));

			// To calculate no of rows In table.
			int rows_count = rows_table.size();
			// Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) {
				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns(cells) In that specific row.
				int columns_count = Columns_row.size();
				for (int column = 0; column < columns_count; column++) {
					String celtext = Columns_row.get(column).getText();
					if (celtext.equalsIgnoreCase(value)) {
						Log.info("Column name found");
					}

				}
			}
		} catch (Exception e) {

			Log.warn("Dropdwon Value does not match");
		}
	}

	// This method verifies Mandatory fields Create New user Popup
	public static String requiredFields_CreateNewUser() {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			WebElement messagebar = UserProfileObjects.getButtonCreateUser();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='manage-page-body']/table ")));
			// Thread.sleep(2000);
			messagebar.click();
			if (UserProfileObjects.GetPopupNewuser().isDisplayed()) {
				UserProfileObjects.ButtonSave().click();
				List<WebElement> elementlist = driver.findElements(By.xpath(".//input[@class='required']"));
				if (elementlist.size() > 0) {
					if (UserProfileObjects.GetPopupNewuser().isDisplayed())
					return "Pass";
				} else
					return "fail";
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Dialog not display");
			return "Fail";
		}
		return "Pass";
	}

	
	//This method create new user
	public static String createNew_User(String firstName, String lastName, String email, String selectUsertype,
			String partner, String client, String roles, String emailfrequncey, String action) {
		// UserProfileObjects = PageFactory.initElements(driver,
		// UserProfileObjectsPhase2.class);
		try {
			WebElement messagebar = UserProfileObjects.getButtonCreateUser();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='manage-page-body']/table ")));
			messagebar.click();
			if (UserProfileObjects.GetPopupNewuser().isDisplayed()) {
				Select userRole = new Select(UserProfileObjects.UserTypeDropdown());
				String loggedusertype = userRole.getFirstSelectedOption().getText();
				System.out.println(loggedusertype);
				if (null != loggedusertype) {
					if (loggedusertype.equalsIgnoreCase("DUB System Admin")) {
						System.out.println("User Is DUB System Admin");
					} else if (loggedusertype.equalsIgnoreCase("Partner Admin")) {
						System.out.println("User Is Partner Admin");
					} else if (loggedusertype.equalsIgnoreCase("Client Admin")) {
						System.out.println("User Is Client Admin");
					} else {// System.out.println("Not a valid data from
							// Drop-Down");
					}
				}
				UserProfileObjects.FirstNameTextbox().sendKeys(firstName);
				UserProfileObjects.LastNameTextbox().sendKeys(lastName);
				UserProfileObjects.EmailTextbox().sendKeys(email);
				Select selectUserType = new Select(UserProfileObjects.UserTypeDropdown());
				selectUserType.selectByVisibleText(selectUsertype);
				Thread.sleep(3000);
				Select selectPartner = new Select(UserProfileObjects.PartnerDropdown());
				selectPartner.selectByVisibleText(partner);
				Thread.sleep(3000);
				Select selectClient = new Select(UserProfileObjects.ClientDropdown());
				selectClient.selectByVisibleText(client);
				Select selectemailfrequncy = new Select(UserProfileObjects.GetEmailFrequency());
				selectemailfrequncy.selectByVisibleText(emailfrequncey);
				Thread.sleep(1000);
				if (action.equalsIgnoreCase("Save"))
					UserProfileObjects.ButtonSave().click();
				if (action.equalsIgnoreCase("Cancel"))
					UserProfileObjects.getButtonclose().click();
				Thread.sleep(2000);
				WebElement element1 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//div[@id='manage-page-body']/table ")));
				List<WebElement> TotalRows = driver
						.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
				if (TotalRows.size() > 0) {
					for (int i = 1; i <= TotalRows.size(); i++) {
						WebElement emailelement = driver
								.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
						if (emailelement.getText().equals(email)) {
							Assert.assertTrue(true);
							return "Pass";
						} else {
							Assert.assertTrue(false);
							return "Fail";
						}
					}
				}

			}

		} catch (Exception e) {
			System.out.println("New user not created ");
			Log.info("Admin user not created");
			return "Fail";
		}
		return "Pass";

	}

	//This method foe edit information of any existing user
		public static String editUser(String searchText,String newfirstName, String newlastName,String newUsertype,String newPartner,String newClient,String newRoles,String newEmailfrequency) throws Exception{
			UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
			try{
				UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
				UserProfileObjects.getTextboxSearch().clear();
				UserProfileObjects.getTextboxSearch().sendKeys(searchText);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
				if (TotalRows.size() > 0) {
					// Only email is unique so it gives only 1 result
						for (int i = 1; i <= TotalRows.size(); i++) {
							WebElement emailelement = driver
									.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
							if (emailelement.getText().equals(searchText)) {
								UserProfileObjects.EditUserImage().click();
								UserProfileObjects.FirstNameTextbox().clear();
								UserProfileObjects.FirstNameTextbox().sendKeys(newfirstName);
								UserProfileObjects.LastNameTextbox().clear();
								UserProfileObjects.LastNameTextbox().sendKeys(newlastName);
								Select selectUserType = new Select(UserProfileObjects.UserTypeDropdown());
								selectUserType.selectByVisibleText(newUsertype);
								Thread.sleep(3000);
								Select selectPartner = new Select(UserProfileObjects.PartnerDropdown());
								selectPartner.selectByVisibleText(newPartner);
								Thread.sleep(3000);
								Select selectClient = new Select(UserProfileObjects.ClientDropdown());
								selectClient.selectByVisibleText(newClient);
								Select selectemailfrequncy = new Select(UserProfileObjects.GetEmailFrequency());
								selectemailfrequncy.selectByVisibleText(newEmailfrequency);
								UserProfileObjects.ButtonSave().click();
								Thread.sleep(1000);
								UserProfileObjects.EditUserImage().click();
								Thread.sleep(2000);
								String ufirstname= UserProfileObjects.FirstNameTextbox().getAttribute("value");
								String ulastname= UserProfileObjects.LastNameTextbox().getAttribute("value");
								String uusertype= selectUserType.getFirstSelectedOption().getText();
								String upartenrtype= selectPartner.getFirstSelectedOption().getText();
								String uclienttype= selectClient.getFirstSelectedOption().getText();
								String uemailfrequncy=selectemailfrequncy.getFirstSelectedOption().getText();
								System.out.println( ufirstname);
								System.out.println(ulastname);
								System.out.println(uusertype);
								System.out.println(upartenrtype);
								System.out.println(uclienttype);
								System.out.println(uemailfrequncy);
								
								if(ufirstname.trim().equals(newfirstName) && ulastname.trim().equals(newlastName) && uusertype.trim().equals(newUsertype) && upartenrtype.trim().equals(newPartner) && uclienttype.trim().equals(newClient) && uemailfrequncy.trim().equals(newEmailfrequency)){
									System.out.println("---All updated values display and information update successfully --");
									return "Pass";
								}
								else 
									throw new Exception("information not update");
							}
							else
								throw new Exception("Search user not found");
							}
								
					}else
						throw new Exception("Search user not found");
				}catch(Exception e)
					{
					System.out.println(e.getMessage());
					System.out.println(e.getStackTrace());
					//throw new Exception("Edit user funtionality is not working");
					}
			return "Fail";
		}
	
	
	//This method for search any specified user 
		public static String searchUser(String searchBy, String searchText) throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		UserProfileObjects.getTextboxSearch().clear();
		UserProfileObjects.getTextboxSearch().sendKeys(searchText);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
		if (TotalRows.size() > 0) {
			// Only email is unique so it gives only 1 result
			if (searchBy.equalsIgnoreCase("Email")) {
				for (int i = 1; i <= TotalRows.size(); i++) {
					WebElement emailelement = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
					if (emailelement.getText().equals(searchText)) {
						Assert.assertTrue(true);
						return "Pass";
					}
				}
			}
			// Name is not unique it gives multiple results so need to check
			// pagination
			if (searchBy.equalsIgnoreCase("Name")) {
				boolean recordfind = CheckRecordpresent(TotalRows, searchText);
				if (recordfind)
					return "Pass";
			}

		} else {
			Log.info("Entered User not found");
			throw new Exception("User has Removed or Deleted /Please Enter Existing User Name in Workbook");
			// return "Fail";
		}

		return "Fail";
	}

	public static boolean CheckRecordpresent(List TotalRows, String searchText) throws InterruptedException {
		boolean result = false;
		for (int i = 1; i <= TotalRows.size(); i++) {
			WebElement emailelement = driver
					.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[1]"));
			if (emailelement.getText().equals(searchText)) {
				Assert.assertTrue(true);
				return true;
			}
		}
		if ((UserProfileObjects.getPageNext().isEnabled())) {
			UserProfileObjects.getPageNext().click();
			Thread.sleep(2000);
			result = CheckRecordpresent(TotalRows, searchText);
		}

		if (result) {
			return true;
		}
		return false;
	}

	
	/**
	 * This method rewrite just below method // add some exception handling in below code custom exception shows.
	 * if something fail on Invalid search user functionality use this method  
	*/
	// Invalid user search
	public static String InvalidsearchUser(String searchtext) throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchtext);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			if (UserProfileObjects.getdeleteUserMessage().getText()
					.equals("User does not exist for the search criteria.")) {
				Assert.assertTrue(true);
				System.out.println("Correct message display on invalid user search");
			return "Pass";
			} else
				throw new Exception("Wrong message display");
				//return "Fail";
		} catch (Exception e) {
			throw new Exception("Unable to locate element or Message not display");
			//System.out.println(e.getMessage());
			//return "Fail";
		}
	}
	
	/**
	 * This method for verification of message on invalid user @Anoop modified this in above method when writing Test cases for Manage partner 
	 * if something fail on Invalid search user functionlity use this method  
	*/
	//Copy of invalid search previous code
/*	public static String InvalidsearchUser(String searchtext) {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchtext);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			if (UserProfileObjects.getdeleteUserMessage().getText()
					.equals("User does not exist for the search criteria.")) {
				Assert.assertTrue(true);
				System.out.println("Correct message display on invalid user search");
			return "Pass";
			} else
				return "Fail";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
	}*/


	// Change password Popup Visiblity verification

	public static String changePasswordPopupVisiblity(String searchtext) throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchtext);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				WebElement emailelement = driver
						.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]"));
				emailelement.click();
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed()) {
					System.out.println("Change password popup display");
					return "Pass";
				} else
					throw new Exception("change password popup not display");
			} else
				throw new Exception("Record not found/ User is not available");

		} catch (Exception e) {
			throw e;
			// System.out.println(e.getMessage());
			// Log.info("Change password popup not shows"+ e.getMessage());
			// return "Fail";
		}

	}

	// Change password popup UI verification

	public static String changePasswordPopupUI(String searchText) throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchText);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				WebElement emailelement = driver
						.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]"));
				emailelement.click();
				Thread.sleep(1000);
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed()
						&& UserProfileObjects.getchangepasswordEmail().isDisplayed()
						&& UserProfileObjects.getchangepasswordPassword().isDisplayed()
						&& UserProfileObjects.getchangepasswordConfirmPassword().isDisplayed()
						&& UserProfileObjects.getchangepasswordBtnSave().isDisplayed()
						&& UserProfileObjects.getchangepasswordBtnClose().isDisplayed()
						&& UserProfileObjects.getTopButtonclose().isDisplayed()) {
						if(UserProfileObjects.getchangepasswordEmail().getAttribute("value").equals(searchText)){
							System.out.println("Change password popup and all required fields display with autopopulated email id");
							return "Pass";
						}
						else
							throw new Exception("Email id is not displays on change password popup");
				} else
					throw new Exception("Either change password popup not display or any field is missing");
			} else
				throw new Exception("Record not found/ User is not available");
		} catch (Exception e) {
			throw e;
		}
	}

	//Change password required fields verification
	
	public static String changePasswordRequiredFields(String searchText) throws Exception{
	UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
	try{
		UserProfileObjects.getTextboxSearch().clear();
		UserProfileObjects.getTextboxSearch().sendKeys(searchText);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
		if (TotalRows.size() > 0) {
			WebElement emailelement = driver
					.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]"));
			emailelement.click();
			//Thread.sleep(1000);
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed()) {
					UserProfileObjects.getchangepasswordBtnSave().click();
					List<WebElement> elementlist = driver.findElements(By.xpath(".//input[@class='required']"));
					if (elementlist.size() > 0) {
						if (UserProfileObjects.getchangepasswordPopuop().isDisplayed())
						return "Pass";
					} else
						throw new Exception("Mendetory fileds not display");
				}
				else 
					throw new Exception("Change password popup not display");
		}
		else
			throw new Exception("Search result not found/ may be search user is deleted");
		
	}catch(Exception e){
		throw e;
	}
		return  "Fail";
	
	}
	
	
	// This method verify error message when password and confirmation password is not same
	public static String mismatchchangePassword(String searchtext, String newPassword, String confirmPassword) throws Exception{
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try{
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchtext);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				WebElement emailelement = driver
						.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]"));
				emailelement.click();
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed()) {
				UserProfileObjects.getchangepasswordPassword().sendKeys(newPassword);
				UserProfileObjects.getchangepasswordConfirmPassword().sendKeys(confirmPassword);
				UserProfileObjects.getchangepasswordBtnSave().click();
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed() )
					{
						if(UserProfileObjects.getChangepasswordRedboxOnConfirmPassword().isDisplayed()){
						System.out.println("Redbox shows on confirm password input box");
						return "Pass";
						}
						else 
							throw new Exception("Redbox not display on confirmation password");
					}
					else
						throw new Exception("Change password Popup close ");
						
				}
				else 
					throw new Exception("Change password Popup not display");
			}
			
		}catch(Exception e){
			throw e;
		}
		return "Fail";
	}
	
	
	//This method verifies change password functionality with valid inputs
	
	public static String changePassword(String searchtext, String newPassword, String confirmPassword) throws Exception{
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try{
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(searchtext);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				WebElement emailelement = driver
						.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]"));
				emailelement.click();
				if (UserProfileObjects.getchangepasswordPopuop().isDisplayed()) {
					UserProfileObjects.getchangepasswordPassword().sendKeys(newPassword);
					UserProfileObjects.getchangepasswordConfirmPassword().sendKeys(confirmPassword);
					UserProfileObjects.getchangepasswordBtnSave().click();
					WebElement messagebar = UserProfileObjects.GetPopupMessage();
						WebDriverWait wait = new WebDriverWait(driver, 5);
						WebElement element = wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath(".//div[@class = 'floating-dialog']/div/span")));
						System.out.println(messagebar.isDisplayed());
						String Actualresult = messagebar.getText();
						System.out.println("----Real show message " + Actualresult);
						if (Actualresult.equals("Password changed successfully for "+searchtext+"!")) {
							Log.info("Password change successfully message display");
							return "Pass";
						} else
							throw new Exception("Message not display");
					}
				else 
					throw new Exception("Change password dialog box not display");
			}
			else 
				throw new Exception("Search record not found ");
		}catch(Exception e){
		throw e;
		}
	}
	
	
	
	//This method is used for verification of delete user confirmation message
	
	public static String deleteUserConfirmationMessage(String logintype, String email) throws Exception {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		String Name = null;
		List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
		if (TotalRows.size() > 0) {
			for (int i = 1; i <= TotalRows.size(); i++) {
				WebElement emailelement = driver
						.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
				// System.out.println(logintype);
				if (emailelement.getText().equals(email) && logintype.equalsIgnoreCase("DUB System Admin")) {
					WebElement deleteicon = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[8]"));
					Name = driver.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[1]"))
							.getText();
					deleteicon.click();
				} else {
					WebElement deleteicon = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[7]"));
					Name = driver.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[1]"))
							.getText();
					deleteicon.click();
				}
				if (UserProfileObjects.getDeleteConfirmationMessage().isDisplayed()
						&& UserProfileObjects.getButtonRemove_deletemessage().isDisplayed()
						&& UserProfileObjects.getButtonCancel_deletemessage().isDisplayed()) {
					String ActualResult = UserProfileObjects.getDeleteConfirmationMessage().getText();
					// Assert.assertEquals(ActualResult, "Are you sure you want
					// to delete? "+Name+"?");
					if (ActualResult.equals("Are you sure you want to delete " + Name + "?")) {
						Assert.assertTrue(true);
						System.out.println("Correct message display");
						return "Pass";
					} else
						Assert.assertTrue(false);
				}
				throw new Exception("Confirmation Message not display");
			}

		} else {
			System.out.println("User not exits");
			Assert.assertTrue(false);
		}
		return "Fail";
	}

	
	//This function for verification of delete user
	
	public static String deleteuser(String email, String logintype) {
		UserProfileObjects = PageFactory.initElements(driver, UserProfileObjectsPhase2.class);
		try {
			UserProfileObjects.getTextboxSearch().clear();
			UserProfileObjects.getTextboxSearch().sendKeys(email);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				for (int i = 1; i <= TotalRows.size(); i++) {
					WebElement emailelement = driver
							.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[2]"));
					System.out.println(logintype);
					if (emailelement.getText().equals(email) && logintype.equalsIgnoreCase("DUB System Admin")) {
						WebElement deleteicon = driver
								.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[8]"));
						deleteicon.click();
					} else {
						WebElement deleteicon = driver
								.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[" + i + "]/td[7]"));
						deleteicon.click();
					}
					UserProfileObjects.getRemovebutton().click();
					Thread.sleep(2000);
					if (UserProfileObjects.getdeleteUserMessage().getText()
							.equals("User does not exist for the search criteria.")) {
						System.out.println("User delete successfully ");
						Assert.assertTrue(true);
						return "Pass";
					} else
						Assert.assertTrue(false);
				}

			} else {
				Log.info("User not exits / not available in the profile list");
				System.out.println("User not exits / not available in the profile list");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("User Not delete successfully ");
			return "Fail";
		}
		return "Pass";
	}
	
	
	
	
}