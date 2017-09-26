package com.s3.businessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import com.s3.objectRepository.AddModule_Objects;
import com.s3.utility.ExcelUtils;
import com.s3.utility.Utils;

public class OpenMyApplication extends Utils {
	static AddModule_Objects AddModuleObjects;

	public static void openMyAppApplicaion(int row, int col, String ExcelFile,
			String ExcelSheetName) throws Exception {
		AddModuleObjects = PageFactory.initElements(driver,
				AddModule_Objects.class);
		AddModuleObjects.getSearch().clear();
		String appName = ExcelUtils
				.getCellData(1, 3, ExcelFile, ExcelSheetName);
		AddModuleObjects.getSearch().sendKeys(appName);
		Thread.sleep(5000);
		boolean isAdminUser = false;
		try {
			isAdminUser = driver.findElement(By.cssSelector("#adminBtn"))
					.isDisplayed();
		} catch (NoSuchElementException nse) {
			nse.getStackTrace();
		}
		AddModule_Objects.appName = appName;
		if (isAdminUser)
			driver.findElement(By.xpath(AddModule_Objects.getClkMyApp()))
					.click();
		if (!isAdminUser)
			driver.findElement(
					By.xpath(AddModule_Objects.getClkMyAppUserType())).click();

	}

}
