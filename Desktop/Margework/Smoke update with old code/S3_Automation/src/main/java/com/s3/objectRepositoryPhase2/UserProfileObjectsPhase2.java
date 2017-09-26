package com.s3.objectRepositoryPhase2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfileObjectsPhase2 {

	@FindBy(how = How.XPATH, using = "//a[text()='Users']")
	private WebElement ClkUsers;

	public WebElement getClkUsers() {
		return ClkUsers;
	}

	@FindBy(how = How.ID, using = "newUser")
	private WebElement getButtonCreateUser;

	public WebElement getButtonCreateUser() {
		return getButtonCreateUser;
	}

	@FindBy(how = How.ID, using = "search")
	private WebElement getTextboxSearch;

	public WebElement getTextboxSearch() {
		return getTextboxSearch;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='manage-page-body']/table/tbody/tr[1]/td[6]/img")
	private WebElement ChangePassImage;

	public WebElement ChangePassImage() {
		return ChangePassImage;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='manage-page-body']/table/tbody/tr[1]/td[7]/img")
	private WebElement EditUserImage;

	public WebElement EditUserImage() {
		return EditUserImage;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='manage-page-body']/table/tbody/tr[1]/td[8]/img")
	private WebElement RemoveUserImage;

	public WebElement RemoveUserImage() {
		return RemoveUserImage;
	}

	

	@FindBy(how = How.ID, using = "FirstName")
	private WebElement FirstNameTextbox;

	public WebElement FirstNameTextbox() {
		return FirstNameTextbox;
	}

	@FindBy(how = How.ID, using = "LastName")
	private WebElement LastNameTextbox;

	public WebElement LastNameTextbox() {
		return LastNameTextbox;
	}

	@FindBy(how = How.ID, using = "Email")
	private WebElement EmailTextbox;

	public WebElement EmailTextbox() {
		return EmailTextbox;
	}

	@FindBy(how = How.ID, using = "displayRole")
	private WebElement UserTypeDropdown;

	public WebElement UserTypeDropdown() {
		return UserTypeDropdown;
	}
	
	@FindBy(how = How.ID, using = "displayPartnerId")
	private  WebElement PartnerDropdown;
	public  WebElement  PartnerDropdown(){
		return PartnerDropdown;
		
	}
	@FindBy(how = How.ID, using = "displayClientId")
	private WebElement ClientDropdown;

	public WebElement ClientDropdown() {
		return ClientDropdown;
	}

	@FindBy(how = How.XPATH, using = "//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all']")
	private WebElement RolesDropdown;

	public WebElement RolesDropdown() {
		return RolesDropdown;
	}

	@FindBy(how = How.ID, using = "emailFrequency")
	private WebElement EmailFrequency;

	public WebElement GetEmailFrequency() {
		return EmailFrequency;
	}
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")
	private WebElement ButtonSave;

	public WebElement ButtonSave() {
		return ButtonSave;
	}

	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close')]")
	private WebElement Buttonclose;

	public WebElement getButtonclose() {
		return Buttonclose;
	}

	
	@FindBy(how = How.XPATH, using = "	.//a[@class='close']/img")
	private WebElement TopButtonclose;

	public WebElement getTopButtonclose() {
		return TopButtonclose;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='popupView']/div/h1[text()='Create New User']")
	private WebElement PopupNewUser;
	public WebElement GetPopupNewuser() {
		return PopupNewUser;
	}
	
	

	@FindBy(how = How.XPATH, using = ".//button[text()='Remove']")
	private WebElement PopupRemovebutton;

	public WebElement getRemovebutton() {
		return PopupRemovebutton;
	}
	
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'no-records dub-font-regular')]")
	private WebElement Deleteusermessage;

	public WebElement getdeleteUserMessage() {
		return Deleteusermessage;
	}
	
	
	@FindBy(how = How.XPATH, using = ".//input[@id='page-next']")
	private WebElement PageNext;

	public WebElement getPageNext() {
		return PageNext;
	}
	
	
	
	@FindBy(how = How.XPATH, using = ".//div[contains(@class, 'popupContent')]/label")
	private WebElement DeleteConfirmationMessage;

	public WebElement getDeleteConfirmationMessage() {
		return DeleteConfirmationMessage;
	}
	
	@FindBy(how = How.XPATH, using = ".//div[contains(@class, 'popupBars popupFooter dialogFooter')]/button[text()='Remove']")
	private WebElement ButtonRemove_deletemessage;

	public WebElement getButtonRemove_deletemessage() {
		return ButtonRemove_deletemessage;
	}
	
	@FindBy(how = How.XPATH, using = ".//div[contains(@class, 'popupBars popupFooter dialogFooter')]/button[text()='Cancel']")
	private WebElement ButtonCancel_deletemessage;

	public WebElement getButtonCancel_deletemessage() {
		return ButtonCancel_deletemessage;
	}


	
	@FindBy(how = How.XPATH, using = "	//*[contains(@class, 'popupView')]")
	private WebElement ChangepasswordPopup;

	public WebElement getchangepasswordPopuop() {
		return ChangepasswordPopup;
	}

	@FindBy(how = How.XPATH, using = ".//input[@id='Email']")
	private WebElement ChangepasswordEmail;

	public WebElement getchangepasswordEmail() {
		return ChangepasswordEmail;
	}
	
	@FindBy(how = How.ID, using = "newPassword")
	private WebElement ChangepasswordPassword;

	public WebElement getchangepasswordPassword() {
		return ChangepasswordPassword;
	}
	
	@FindBy(how = How.ID, using = "confirmPassword")
	private WebElement ChangepasswordConfirmPassword;

	public WebElement getchangepasswordConfirmPassword() {
		return ChangepasswordConfirmPassword;
	}

	@FindBy(how = How.XPATH, using = ".//button[text()='Save']")
	private WebElement ChangepasswordBtnSave;

	public WebElement getchangepasswordBtnSave() {
		return ChangepasswordBtnSave;
	}
	
	@FindBy(how = How.XPATH, using = ".//button[text()='Close']")
	private WebElement ChangepasswordBtnClose;

	public WebElement getchangepasswordBtnClose() {
		return ChangepasswordBtnClose;
	}
	
	@FindBy(how = How.XPATH, using = "	.//input[@id='confirmPassword' and @class='required']")
	private WebElement ChangepasswordRedboxOnConfirmpassword;

	public WebElement getChangepasswordRedboxOnConfirmPassword() {
		return ChangepasswordRedboxOnConfirmpassword;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@class = 'floating-dialog']/div/span")
	private WebElement PopupMessage;
	
	public WebElement GetPopupMessage(){
		return PopupMessage;
	}
	
	
	
}
