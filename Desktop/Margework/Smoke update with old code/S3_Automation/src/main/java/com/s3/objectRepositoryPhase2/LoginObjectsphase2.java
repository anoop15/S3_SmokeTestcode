package com.s3.objectRepositoryPhase2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginObjectsphase2 {

	@FindBy(how = How.CSS, using = ".login-header>img")
	private WebElement DubLabsLoginImage;

	public WebElement getImgDubLabs() {
		return DubLabsLoginImage;
	}
	

	@FindBy(how = How.CSS, using = ".dub-font-bold")
	private WebElement LoginImage;

	public WebElement getImgLogin() {
		return LoginImage;
	}
	
	@FindBy(how = How.CSS, using = ".site-footer>p")
	private WebElement LoginBottomHead;

	public WebElement getBottemHead() {
		return LoginBottomHead;
	}
	
	@FindBy(how = How.ID,using="S3_input_email")
	private WebElement getInputEmail;
	
	public WebElement getInputEmail(){
		return getInputEmail;
	}
	
	@FindBy(how = How.ID,using="S3_input_password")
	private WebElement getInputPassword;
	
	public WebElement getInputPassword(){
		return getInputPassword;
	}
	
	@FindBy(how = How.ID,using="input_login_button")
	private WebElement getButtonLogin;
	
	public WebElement getButtonLogin(){
		return getButtonLogin;
	}
	
	@FindBy(how = How.XPATH,using="//label[text()='Remember Me']//preceding-sibling::label")
	private WebElement getRememberMe;
	
	public WebElement getRememberMeCheckbox(){
		return getRememberMe;
	}
	
	@FindBy(how = How.XPATH,using="//h1[text()='Login Failed']")
	private WebElement HeaderTextOfError;
	
	public WebElement getHeaderTextOfError(){
		return HeaderTextOfError;
	}
	

	@FindBy(how = How.XPATH,using=".//div[@class = 'dub-font-regular']")
	private WebElement BodyText;
	
	public WebElement getBodyTextOfError(){
		return BodyText;
	}
	
	
			
	@FindBy(how = How.XPATH,using="//a[text()='Logout']")
	private WebElement LogoutOption;
	
	public WebElement Logoutbutton(){
		return LogoutOption;
	}
	
	@FindBy(how = How.XPATH,using="//a[text()='Forgot Password']")
	private WebElement ForgotPasswordText;
	
	public WebElement TextForgotpassword(){
		return ForgotPasswordText;
	}
	
	@FindBy(how = How.XPATH,using="//input[@id='Email']")
	private WebElement ForgotPasswordEmail;
	
	public WebElement GetForgotPasswordEmail(){
		return ForgotPasswordEmail;
	}
	
	
	@FindBy(how = How.XPATH,using="//button[text()='Cancel']")
	private WebElement ForgotPasswordCancel;
	
	public WebElement GetForgotPasswordCancelButton(){
		return ForgotPasswordCancel;
	}
	
	
	@FindBy(how = How.XPATH,using="//button[text()='Reset']")
	private WebElement ForgotPasswordReset;
	
	public WebElement GetForgotPasswordResetButton(){
		return ForgotPasswordReset;
	}
	
	
	@FindBy(how = How.XPATH,using=".//div[@class = 'floating-dialog']/div/span")
	private WebElement PopupMessage;
	
	public WebElement GetPopupMessage(){
		return PopupMessage;
	}
	
	
	
	@FindBy(how = How.XPATH,using=".//a[@id='appsBtn']")
	private WebElement MobileApps;
	
	public WebElement GetButtonMobileApps(){
		return MobileApps;
	}
	
	
	@FindBy(how = How.XPATH,using=".//a[@id='chatBtn']")
	private WebElement Chat;
	
	public WebElement GetButtonChat(){
		return Chat;
	}
	

	@FindBy(how = How.XPATH,using=".//a[@id='usersBtn']")
	private WebElement Users;
	
	public WebElement GetButtonUsers(){
		return Users;
	}
	
	@FindBy(how = How.XPATH,using=".//a[@id='reportsBtn']")
	private WebElement Reports;
	
	public WebElement GetButtonReports(){
		return Reports;
	}
	
	@FindBy(how = How.XPATH,using=".//a[@id='adminBtn']")
	private WebElement Admin;
	
	public WebElement GetButtonAdmin(){
		return Admin;
	}
	
	@FindBy(how = How.XPATH,using=".//a[@id='builderBtn']")
	private WebElement Pages;
	
	public WebElement GetButtonPages(){
		return Pages;
	}
	
	@FindBy(how = How.XPATH,using=".//a[text()='Help']")
	private WebElement Help;
	
	public WebElement GetButtonHelp(){
		return Help;
	}
	

	@FindBy(how = How.XPATH,using=".//a[@id='logoutBtn']")
	private WebElement Logout;
	
	public WebElement GetButtonLogout(){
		return Help;
	}
	
	
	
	
}
