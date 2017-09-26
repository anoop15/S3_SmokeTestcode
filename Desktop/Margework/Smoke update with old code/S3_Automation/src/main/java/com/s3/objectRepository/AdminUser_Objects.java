package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminUser_Objects {

	public static String saveOrClose;
	public static String userEmail;
	public static String removeOrCancel;

	@FindBy(how = How.XPATH, using = "//a[text()='Users']")
	private WebElement ClkUsers;

	public WebElement getClkUsers() {
		return ClkUsers;
	}

	@FindBy(how = How.ID, using = "newUser")
	private WebElement ClkCreateNewUser;

	public WebElement getClkCreateNewUser() {
		return ClkCreateNewUser;
	}

	@FindBy(how = How.ID, using = "FirstName")
	private WebElement FirstName;

	public WebElement getFirstName() {
		return FirstName;
	}

	@FindBy(how = How.ID, using = "LastName")
	private WebElement LastName;

	public WebElement getLastName() {
		return LastName;
	}

	@FindBy(how = How.ID, using = "Email")
	private WebElement Email;

	public WebElement getEmail() {
		return Email;
	}

	@FindBy(how = How.ID, using = "displayRole")
	private WebElement SelectUserType;

	public WebElement getSelectUserType() {
		return SelectUserType;
	}

	@FindBy(how = How.ID, using = "displayPartnerId")
	private WebElement SelectPartnerName;

	public WebElement getSelectPartnerName() {
		return SelectPartnerName;
	}

	@FindBy(how = How.ID, using = "displayClientId")
	private WebElement SelectClientName;

	public WebElement getSelectClientName() {
		return SelectClientName;
	}

	public static String getSaveorClose() {
		return "//button[text()='" + saveOrClose + "']";
	}

	public static String getVeriUserName() {
		return "//td[text()='" + userEmail + "']//preceding-sibling::td";
	}

	public static String getVeriUserType() {
		return "//td[text()='" + userEmail + "']//following-sibling::td[1]";
	}

	public static String getClkEditImg() {
		return "//td[text()='" + userEmail
				+ "']//following-sibling::td/img[@title='Edit user']";
	}

	public static String getClkDeleteImg() {
		return "//td[text()='" + userEmail
				+ "']//following-sibling::td/img[@title='Remove user']";
	}

	@FindBy(how = How.ID, using = "search")
	private WebElement Search;

	public WebElement getsearch() {
		return Search;
	}

	public static String getClkRemoveOrCancel() {
		return "//button[text()='" + removeOrCancel + "']";
	}
}
