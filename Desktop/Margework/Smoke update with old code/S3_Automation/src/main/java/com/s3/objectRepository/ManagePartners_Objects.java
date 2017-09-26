package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagePartners_Objects {
	public static String partner_name;
	public static String removeOrCancel;
	@FindBy(how = How.CSS, using = "#adminBtn")
	private WebElement Admin;

	public WebElement getAdmin() {
		return Admin;
	}

	@FindBy(how = How.CSS, using = "#newPartner")
	private WebElement CreatePartnerButton;

	public WebElement getCreatePartnerButton() {
		return CreatePartnerButton;
	}

	@FindBy(how = How.CSS, using = "#Name")
	private WebElement CreatePartnerName;

	public WebElement getCreatePartnerName() {
		return CreatePartnerName;
	}

	@FindBy(how = How.XPATH, using = "//li[text()='Manage Partners']")
	private WebElement ManagePartnersSubModule;

	public WebElement getManagePartnersSubModule() {
		return ManagePartnersSubModule;
	}

	@FindBy(how = How.ID, using = "search")
	private WebElement SearchManagePartners;

	public WebElement getSearchManagePartners() {
		return SearchManagePartners;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement SaveManagePartners;

	public WebElement getSaveManagePartners() {
		return SaveManagePartners;
	}

	public static String getPartnerName() {
		return "//td[text()='" + partner_name + "']";
	}

	public static String getDeletePartnerImg() {
		return "//td[text()='" + partner_name
				+ "']//following-sibling::td[2]/img";
	}

	public static String getEditPartnerImg() {
		return "//td[text()='" + partner_name
				+ "']//following-sibling::td[1]/img";
	}

	public static String getRemoveManagePartners() {
		return "//button[text()='" + removeOrCancel + "']";
	}

}
