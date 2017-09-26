package com.s3.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyApp_Objects {

	public static String appName;

	@FindBy(how = How.ID, using = "search")
	private WebElement Search;

	public WebElement getSearch() {
		return Search;
	}

	public static String getClkEditMyApp() {
		return "//ul[@id='apps-list']//li[@class='" + appName
				+ "']//following-sibling::div/img[@title='Edit App']";
	}

	@FindBy(how = How.ID, using = "AppName")
	private WebElement EditAppName;

	public WebElement getEditAppName() {
		return EditAppName;
	}

	@FindBy(how = How.ID, using = "displayClientId")
	private WebElement EditClient;

	public WebElement getEditClient() {
		return EditClient;
	}

	@FindBy(how = How.ID, using = "displayAppFigures")
	private WebElement EditAppFigures;

	public WebElement getEditAppFigures() {
		return EditAppFigures;
	}

}
