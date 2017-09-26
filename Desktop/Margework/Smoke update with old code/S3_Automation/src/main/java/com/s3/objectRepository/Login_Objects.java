package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Objects {

	@FindBy(how = How.NAME, using = "s3_email")
	private WebElement Username;

	public WebElement getUsername() {
		return Username;
	}

	@FindBy(how = How.NAME, using = "s3_password")
	private WebElement Password;

	public WebElement getpassword() {
		return Password;
	}

	@FindBy(how = How.ID, using = "input_login_button")
	private WebElement LoginBtn;

	public WebElement getbtnlogin() {
		return LoginBtn;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Remember Me']//preceding-sibling::label")
	private WebElement RememberMe;

	public WebElement getRememberME() {
		return RememberMe;
	}

	@FindBy(how = How.ID, using = "logoutBtn")
	private WebElement LogoutBtn;

	public WebElement getbtnLogout() {
		return LogoutBtn;
	}

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
}
