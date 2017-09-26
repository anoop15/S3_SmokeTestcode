package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Client_Object {
	public static String saveOrClose;
	public static String partnerName;
	public static String display_Name;
	@FindBy(how = How.XPATH, using = "//button[text()='Create Client']")
	private WebElement NewClient;

	public WebElement getNewClient() {
		return NewClient;
	}

	@FindBy(how = How.ID, using = "Name")
	private WebElement ClientName;

	public WebElement getClientName() {
		return ClientName;
	}

	@FindBy(how = How.CSS, using = "#adminBtn")
	private WebElement Admin;

	public WebElement getAdmin() {
		return Admin;
	}

	@FindBy(how = How.ID, using = "displayPartnerId")
	private WebElement SelectPartner;

	public WebElement getSelectPartner() {
		return SelectPartner;
	}

	public static String getSearchPartner() {
		return "//select[@id='search-partner']";
	}

	@FindBy(how = How.ID, using = "DisplayName")
	private WebElement DisplayName;

	public WebElement getDisplayName() {
		return DisplayName;
	}

	public static String getSaveorClose() {
		return "//button[text()='" + saveOrClose + "']";
	}

	@FindBy(how = How.ID, using = "search")
	private WebElement Search;

	public WebElement getSearch() {
		return Search;
	}

	public static String getSearchClient() {
		return "//input[@id='search']";
	}

	public static String getVeriClientName() {
		return "//td[text()='" + display_Name + "']//preceding-sibling::td[1]";
	}

	public static String getVeriDisplayName() {
		return "//td[text()='" + partnerName + "']//preceding-sibling::td[1]";
	}

	public static String getClientEditImg() {
		return "//td[text()='" + partnerName
				+ "']//following-sibling::td[1]/img";
	}

	public static String getClientDeleteImg() {
		return "//td[text()='" + partnerName
				+ "']//following-sibling::td[2]/img";
	}

}
