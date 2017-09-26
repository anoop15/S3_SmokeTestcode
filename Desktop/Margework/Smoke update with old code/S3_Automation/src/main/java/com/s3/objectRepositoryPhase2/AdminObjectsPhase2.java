package com.s3.objectRepositoryPhase2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminObjectsPhase2 {
	
	public static int rowno;
	
	@FindBy(how = How.XPATH,using=".//a[@id='adminBtn']")
	private WebElement Admin;
	public WebElement GetButtonAdmin(){
		return Admin;
	}
	
	
	@FindBy(how = How.XPATH,using=".//li[text()='Manage Partners']")
	private WebElement ManagePartnerMenu;
	
	public WebElement GetManagePartnerMenu(){
		return ManagePartnerMenu;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@id='manage-page-body']")
	private WebElement Partnertable;
	
	public WebElement GetPartnertable(){
		return Partnertable;
	}
	
	@FindBy(how = How.ID,using="newPartner")
	private WebElement BtnCreatePartner;
	
	public WebElement GetBtnCreatePartner(){
		return BtnCreatePartner;
	}
	

	@FindBy(how = How.XPATH,using=".//input[@id='search']")
	private WebElement TxtSearch;
	
	public WebElement GetTxtSearch(){
		return TxtSearch;
	}
	
	
	@FindBy(how = How.XPATH,using=".//span[@class='title dub-font-regular']")
	private WebElement LblHeader;
	
	public WebElement GetLblHeader(){
		return LblHeader;
	}

	@FindBy(how = How.XPATH,using=".//div[@class='popupView']//div/h1[text()='Create New Partner']")
	private WebElement CreatepartnerPopup;
	
	public WebElement GetCreatepartnerPopup(){
		return CreatepartnerPopup;
	}
	
	@FindBy(how = How.XPATH,using=".//input[@id='Name']")
	private WebElement InputCreatepartnerPopupName;
	
	public WebElement GetInputCreatepartnerPopupName(){
		return InputCreatepartnerPopupName;
	}
	
	@FindBy(how = How.XPATH,using=".//form[@id='CreateNewPartnerPopup']/ul/li/span[text()='Name']")
	private WebElement LabelCreatepartnerPopupName;
	
	public WebElement GetlabelCreatepartnerPopupName(){
		return LabelCreatepartnerPopupName;
	}
	
	@FindBy(how = How.XPATH,using=".//button[@id='undefined' and text()='Save']")
	private WebElement BtnCreatepartnerPopupSave;
	public WebElement GetBtnCreatepartnerPopupSave(){
		return BtnCreatepartnerPopupSave;
	}
	
	@FindBy(how = How.XPATH,using=".//button[@id='undefined' and text()='Close']")
	private WebElement BtnCreatepartnerPopupClose;
	public WebElement GetBtnCreatepartnerPopupClose(){
		return BtnCreatepartnerPopupClose;
	}
	
	
	
	@FindBy(how = How.XPATH,using=".//a[@class='close']//img")
	private WebElement ImgCreatepartnerPopupClose;
	public WebElement GetImgCreatepartnerPopupClose(){
		return ImgCreatepartnerPopupClose;
	}
	
	@FindBy(how = How.XPATH,using=".//input[@id='Name' and @class='required']")
	private WebElement TxtCreatepartnerNameRequired;
	public WebElement GetTxtCreatepartnerNameRequired(){
		return TxtCreatepartnerNameRequired;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@class = 'floating-dialog']/div/span")
	private WebElement PopupMessage;
	
	public WebElement GetPopupMessage(){
		return PopupMessage;
	}
	
	public static String getTblAllrows() {
		return "//div[@id='manage-page-body']/table/tbody/tr";
	}
	
	
	@FindBy(how = How.XPATH,using=".//button[@class='danger-btn dub-font-bold' and text()='Remove']")
	private WebElement BtnpopupRemove;
	
	public WebElement GetBtnpopupRemove(){
		return BtnpopupRemove;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@id='manage-page-body']//tbody//tr[1]/td[1]")
	private WebElement TxtUserNameintable;
	
	public WebElement GetTxtUserNameintable(){
		return TxtUserNameintable;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@id='manage-page-body']//tbody//tr[1]/td[2]")
	private WebElement BtnUserEditintable;
	
	public WebElement GetBtnUserEditintable(){
		return BtnUserEditintable;
	}
	
	@FindBy(how = How.XPATH,using=".//div[@id='manage-page-body']//tbody//tr[1]/td[3]")
	private WebElement BtnUserDeleteintable;
	
	public WebElement GetBtnUserDeleteintable(){
		return BtnUserDeleteintable;
	}
	
	@FindBy(how = How.XPATH, using = ".//input[@id='page-next']")
	private WebElement PageNext;

	public WebElement getPageNext() {
		return PageNext;
	}
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'no-records dub-font-regular')]")
	private WebElement Deleteusermessage;

	public WebElement getdeleteUserMessage() {
		return Deleteusermessage;
	}
	
	
	@FindBy(how = How.XPATH,using=".//div[@class='popupView']//div/h1[text()='Edit Partner']")
	private WebElement EditpartnerPopup;
	
	public WebElement GetEditpartnerPopup(){
		return EditpartnerPopup;
	}
	
	
	public static String getNamefromTable()
	{
		return ".//div[@id='manage-page-body']//tbody//tr["+ rowno+"]/td[1]";
	}
	
	public static String getEditbuttonofPartner(){
	
		return ".//div[@id='manage-page-body']//table/tbody/tr["+rowno+"]/td[2]";
	}
	
	public static String getDeletebuttonofPartner(){
		
		return ".//div[@id='manage-page-body']//table/tbody/tr["+rowno+"]/td[3]";
	}
}


