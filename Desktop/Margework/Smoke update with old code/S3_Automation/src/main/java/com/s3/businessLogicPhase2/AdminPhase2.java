package com.s3.businessLogicPhase2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.s3.objectRepositoryPhase2.AdminObjectsPhase2;
import com.s3.utility.Log;
import com.s3.utility.Utils;

public class AdminPhase2 extends Utils{
	static AdminObjectsPhase2 AdminObjects;
	static ArrayList<String> obtainedList = new ArrayList<>(); 
	static WebElement element;

	
	/**
	 * This method for verify visibility of Manage Partner Page
	*/

	public static String ManagePartnerPageVisibility() throws Exception
	{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);

		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
				{
//				WebElement Submenu = AdminObjects.GetManagePartnerMenu();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[text()='Manage Partners']")));
				AdminObjects.GetManagePartnerMenu().click();
				Thread.sleep(2000);
				boolean header= AdminObjects.GetLblHeader().getText().equals("Manage Partners");
				if(AdminObjects.GetBtnCreatePartner().isDisplayed() && AdminObjects.GetTxtSearch().isDisplayed() && header &&AdminObjects.GetPartnertable().isDisplayed() )
				{
					return "Pass";
				}
				}
			else 
				throw new Exception("Manage partner option not display or Create partner, Search partner Manage Partner fields not display ");
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception("Manage Partner page not display");
			
		}
		return "Fail";
	}
	
	
	/**
	 * This method for UI verification of  Manage Partner Page
	*/
	
	public static String ManagePartnerPageUICheck() throws Exception
	{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);

		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(3000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
				{
				AdminObjects.GetManagePartnerMenu().click();
				Thread.sleep(3000);
				boolean btnCreatepartner=AdminObjects.GetBtnCreatePartner().isDisplayed();
				boolean headerlabel= AdminObjects.GetLblHeader().getText().equals("Manage Partners");
				boolean txtSearch = AdminObjects.GetTxtSearch().isDisplayed();
				boolean tblPartner = AdminObjects.GetPartnertable().isDisplayed();
				boolean tblElement = true;
				List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
				if(TotalRows.size()>0)
				{
					List<WebElement> Totalcol = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr[1]/td"));
					for (int i = 1; i <= TotalRows.size(); i++) {
						for(int j=1;j<=Totalcol.size();j++)
						{
							if(!driver.findElement(By.xpath("//div[@id='manage-page-body']/table/tbody/tr["+i+"]/td["+j+"]")).isDisplayed())
								tblElement=false;
						}
					}
				}
				else
				{
					System.out.println("Partner list is empty");
					throw new Exception("Data not display in Partner table");
				}
				if(btnCreatepartner && headerlabel && txtSearch && tblPartner && tblElement)
				{
					return "Pass";
				}
				else
					throw new Exception("Required fields (Manage Partner/ Create partner button/ Manage partner header/ Search box ) not display");
				}
			else 
				throw new Exception("Required fields (Manage Partner/ Create partner button/ Manage partner header/ Search box ) not display");
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());	
		}
	}
	
	
	/**
	 * This method for verification of Create new partner popup visiblity verification 
	 * if popup visible it returns Pass otherwise it thorw exception
	*/
	public static String ManagePartner_CreateNewPartner_PopupVisiblity() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
				return "Pass";
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	
	/**
	 * This method for verification of Create new partner popup UI verification 
	 * if popup visible with all required element it returns Pass otherwise it throws exception
	*/
	public static String ManagePartner_CreateNewPartner_PopupUIVerification() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				if(AdminObjects.GetInputCreatepartnerPopupName().isDisplayed() && AdminObjects.GetlabelCreatepartnerPopupName().isDisplayed()
						&& AdminObjects.GetBtnCreatepartnerPopupSave().isDisplayed() && AdminObjects.GetBtnCreatepartnerPopupClose().isDisplayed() && AdminObjects.GetImgCreatepartnerPopupClose().isDisplayed())
					return "Pass";
				else
					throw new Exception("Name text field / Name label / Save button /Close Button , X button is not display");
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * This method for verification of Create new partner popup required fields verification 
	 * if Mandatory fields visible with all required element it returns Pass otherwise it throws exception
	 * TC_Admin_05
	 * @throws Exception 
	*/
	
	public static String ManagePartner_CreateNewPartner_RequiredFieldsVerification() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetBtnCreatepartnerPopupSave().click();
				if(AdminObjects.GetTxtCreatepartnerNameRequired().isDisplayed())
					return "Pass";
				else
					throw new Exception("Name textbox not shows as mendetory field");
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

	}
	
	/**
	 * This method for verification of input functionality of Name text field 
	 * if given text entered in Name field it returns Pass otherwise it throws exception
	 * TC_Admin_06
	 * @throws Exception 
	*/
	
	public static String ManagePartner_CreateNewPartner_InputtextVerification(String inputText) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetInputCreatepartnerPopupName().sendKeys(inputText);
				if(AdminObjects.GetInputCreatepartnerPopupName().getAttribute("value").equals(inputText))
					return "Pass";
				else
					throw new Exception("Unable to input in Name field");
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

	}
	
	/**
	 * This method for verification of creating duplicate partner 
	 * if shows expected message then it returns Pass otherwise it throws exception
	 * TC_Admin_07
	 * @throws Exception 
	*/
	
	public static String ManagePartner_CreateDuplicatePartner(String partnerName, String expectedmsg) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetInputCreatepartnerPopupName().sendKeys(partnerName);
				AdminObjects.GetBtnCreatepartnerPopupSave().click();
				WebElement messagebar = AdminObjects.GetPopupMessage();
				WebDriverWait wait = new WebDriverWait(driver, 5);
				WebElement element = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//div[@class = 'floating-dialog']/div/span")));
				String Actualresult = messagebar.getText();
				if (Actualresult.equals(expectedmsg)) {
					Log.info("Expected message display");
					return "Pass";
				} else
					throw new Exception("Expected message not display");
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	/**
	 * This method for verification of creating New partner 
	 * if New partner created successfully  then it returns Pass otherwise it throws exception
	 * TC_Admin_08
	 * @throws Exception 
	*/
	
	public static String ManagePartner_CreateNewPartner(String NewPartnerName) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetInputCreatepartnerPopupName().sendKeys(NewPartnerName);
				AdminObjects.GetBtnCreatepartnerPopupSave().click();
				Thread.sleep(2000);
				List<WebElement> TotalRows = driver.findElements(By.xpath(AdminObjects.getTblAllrows()));
				if(TotalRows.size()>0)
				{
					for(int i=1;i<=TotalRows.size();i++){
						if(driver.findElement(By.xpath(".//div[@id='manage-page-body']/table/tbody/tr/td["+i+"]")).getText().equals(NewPartnerName)){
						//	DeletePartner(NewPartnerName, i);
							return "Pass";
						}
					}
				}
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return "Fail";

	}
	
	
	/**
	 * This method for verification of creating New partner and verify elements in list of corresponding user 
	 * if New partner created and all element shows successfully then it returns Pass otherwise it throws exception
	 * TC_Admin_09
	 * @throws Exception 
	*/
	
	public static String ElementVerificationofTable(String Username) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetInputCreatepartnerPopupName().sendKeys(Username);
				AdminObjects.GetBtnCreatepartnerPopupSave().click();
				Thread.sleep(2000);
				List<WebElement> TotalRows = driver.findElements(By.xpath(AdminObjects.getTblAllrows()));
				if(TotalRows.size()>0)
				{
					for(int i=1;i<=TotalRows.size();i++){
						if(driver.findElement(By.xpath(".//div[@id='manage-page-body']/table/tbody/tr/td["+i+"]")).getText().equals(Username)){
							if(AdminObjects.GetTxtUserNameintable().isDisplayed() && AdminObjects.GetBtnUserEditintable().isDisplayed() && AdminObjects.GetBtnUserDeleteintable().isDisplayed() )
							{
							return "Pass";
							}else
								throw new Exception("Name,Edit or Delete option not available");
							}else
							throw new Exception("Created Partner User not found");
					}
				}
			}
			else
				throw new Exception("Create new partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return "Fail";

	}
	
	/**
	 * This method for verification sorting order of partner list  
	 * if sorting ofer is alphabetical then it returns Pass otherwise it throws exception
	 * TC_Admin_11
	 * @throws Exception 
	*/
	public static String SortingPartnerList() throws Exception
	{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			List<WebElement> TotalRows = driver.findElements(By.xpath(".//div[@id='manage-page-body']/table/tbody/tr"));
			if (TotalRows.size() > 0) {
				ArrayList<String> myList= savelist();
				ArrayList<String> sortedList = new ArrayList<>();   
				for(String s:myList){
				sortedList.add(s);
				}
				Collections.sort(sortedList);
//				for(String s: sortedList)
//					System.out.println(s);
				if(sortedList.equals(myList))
					return "Pass";
				else
					return "Fail";
			}
			else
				throw new Exception("Partner not available in partner list");
			}
			else 
				throw new Exception("Manage Partner menu not display or unable to click");
		}
		catch(Exception e)
		{
		throw new Exception(e.getMessage());
		}
	}
	
	
	public static ArrayList<String> savelist() throws InterruptedException
	{

		List<WebElement> elementList= driver.findElements(By.xpath(".//div[@id='manage-page-body']/table/tbody/tr/td[1]"));
		for(WebElement we:elementList){
		   obtainedList.add(we.getText());
		   System.out.println(we.getText());
		}
		if(AdminObjects.getPageNext().isEnabled())
		{
			AdminObjects.getPageNext().click();
			Thread.sleep(1000);
		savelist();	
		}
		return obtainedList;
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
		if ((AdminObjects.getPageNext().isEnabled())) {
			AdminObjects.getPageNext().click();
			Thread.sleep(2000);
			result = CheckRecordpresent(TotalRows, searchText);
		}

		if (result) {
			return true;
		}
		return false;
	}

	/**
	 * This method for verify Search partner functionality and result should contains searched screen   
	 * if search string contains in search result it return pass other then it throw exception
	 * TC_Admin_13
	 * @throws Exception 
	*/
	public static String SearchPartner(String SearchPartner) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		boolean iscontain=true;
		try{
			AdminObjects.GetTxtSearch().clear();
			AdminObjects.GetTxtSearch().sendKeys(SearchPartner);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if(TotalRows.size() ==1 ){
				if(AdminObjects.GetTxtUserNameintable().equals(SearchPartner))
					return "Pass";
			}
			if(TotalRows.size()>1)
			{
				for(int i=1;i<=TotalRows.size();i++)
				{
					AdminObjects.rowno=i;
					String partnername= driver.findElement(By.xpath(AdminObjectsPhase2.getNamefromTable())).getText();
					if(!(partnername.toLowerCase()).contains(SearchPartner.toLowerCase()))
					{	
					iscontain=false;
						throw new Exception("Search result not contain searched string ");
					}
				}
				if(iscontain==true)
					return "Pass";
			}
			else 
				throw new Exception("Partner not found or Enter valid partner name Admin.xlsx file");
			
		}catch(Exception e){
			throw e;
		}
	return "Fail";
	}
	
	
	
	/**
	 * This method Verify Edit and delete button of each partner in the list.
	 * if Each partner has Edit and delete button then it return pass otherwise it throw exception
	 * TC_Admin_14
	 * @throws Exception 
	*/
	
	public static String ElementVerificationOnList() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if(TotalRows.size() > 0 ){
			//	boolean isPresent=true;
				for(int rowno=1; rowno<=TotalRows.size();rowno++)
				{
					AdminObjects.rowno=rowno;
					WebElement editButton = driver.findElement(By.xpath(AdminObjects.getEditbuttonofPartner()));
					WebElement deleteButton=driver.findElement(By.xpath(AdminObjects.getDeletebuttonofPartner()));
					String currentPartner= driver.findElement(By.xpath(AdminObjects.getNamefromTable())).getText();
					//System.out.println("button verification for "+currentPartner);
					if(!editButton.isDisplayed() && deleteButton.isDisplayed())
					{
						throw new Exception(currentPartner +" Not displaying Edit/Delete button");
					}
					
				}
				if(AdminObjects.getPageNext().isEnabled()){
					AdminObjects.getPageNext().click();
					ElementVerificationOnList();
				}
			}
			else
				throw new Exception("Partner list not shows any data in list");
			
		}catch(Exception e){
			throw new Exception(e);
		}
	return "Pass";
	}
	
	

	/**
	 * This method for verification of Edit partner popup visibility verification 
	 * if Edit partner popup visible it returns Pass otherwise it throw exception
	 * TC_Admin_15
	*/
	public static String ManagePartner_EditPartnerPopupVisiblity() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnUserEditintable().click();
			if(AdminObjects.GetEditpartnerPopup().isDisplayed())
				return "Pass";
			else
				throw new Exception("Edit partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	

	/**
	 * This method for verify corresponding Name should be prefilled on Edit partner popup  
	 * if Edit partner popup visible it returns Pass otherwise it throw exception
	 * TC_Admin_16
	*/
	public static String ManagePartner_PrefilledNameOnEditPartnerPopup() throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			String actualName;
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnUserEditintable().click();
			if(AdminObjects.GetEditpartnerPopup().isDisplayed())
			{	
				actualName=AdminObjects.GetTxtUserNameintable().getText();
				if((AdminObjects.GetInputCreatepartnerPopupName().getAttribute("value").equals(actualName))){
					return "Pass";
				}
				else
					throw new Exception("Required name not display in Name field");
				
			}
			else
				throw new Exception("Edit partner popup not display");
			}
			else
				throw new Exception("Manage Partner not display");
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	

	/**
	 * This method for verify Edit partner Name functionality
	 * if Edited partner shows in the list just after edit returns Pass otherwise it throw exception
	 * TC_Admin_17
	*/
	public static String ManagePartner_EditPartnerName(String oldName, String newName) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetTxtSearch().clear();
			AdminObjects.GetTxtSearch().sendKeys(oldName);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			List<WebElement> TotalRows = driver.findElements(By.xpath("//div[@id='manage-page-body']/table/tbody/tr"));
			if(TotalRows.size() > 0 ){
				if(AdminObjects.GetTxtUserNameintable().getText().equals(oldName))
				{
					AdminObjects.GetBtnUserEditintable().click();
					AdminObjects.GetInputCreatepartnerPopupName().clear();
					AdminObjects.GetInputCreatepartnerPopupName().sendKeys(newName);
					AdminObjects.GetBtnCreatepartnerPopupSave().click();
					Thread.sleep(1000);
					if(TotalRows.size() >0 ){
						if(AdminObjects.GetTxtUserNameintable().getText().equals(newName))
						return "Pass";
					}
					else
						throw new Exception("Updated partner not shows in list after edit");
					
				}
				else
					throw new Exception("User not found, please enter valid user in test data workbook");
			}
			else
				throw new Exception("User not found, please enter valid user in test data workbook");

			}
			else 
				throw new Exception("Partner menu not display or clickable");
		}catch(Exception e)
		{
		throw new Exception(e);
		}
	return "Fail";	
	}
	
	
	/**
	 * This method for Click on Admin option from menu  
	*/
	
	public static void clkAdmin() throws Exception {
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		element = AdminObjects.GetButtonAdmin();
		Utils.waitForElementToBeClickable(element);
		element.click();
	}
	
	
	/**
	 * This method for Click on Manage partner option under Admin option   
	*/
	
	public static void clkManagePartner() throws Exception {
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		element = AdminObjects.GetManagePartnerMenu();
		Utils.waitForElementToBeClickable(element);
		element.click();
	}
	
	
	
	public static void DeletePartner(String User) throws Exception{
		try{
			AdminObjects.GetTxtSearch().clear();
			AdminObjects.GetTxtSearch().sendKeys(User);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			AdminObjects.GetBtnUserDeleteintable().click();
			AdminObjects.GetBtnpopupRemove().click();
			Thread.sleep(2000); 
		}catch(Exception e)
		{
		throw new Exception("Unable to delete new created user");
		}
		
	}
	
	public static void CreatePartner(String username) throws Exception{
		AdminObjects = PageFactory.initElements(driver, AdminObjectsPhase2.class);
		try{
			Thread.sleep(2000);
			AdminObjects.GetButtonAdmin().click();
			Thread.sleep(4000);
			if(AdminObjects.GetManagePartnerMenu().isDisplayed())
			{
			AdminObjects.GetManagePartnerMenu().click();
			Thread.sleep(4000);
			AdminObjects.GetBtnCreatePartner().click();
			if(AdminObjects.GetCreatepartnerPopup().isDisplayed())
			{
				AdminObjects.GetInputCreatepartnerPopupName().sendKeys(username);
				AdminObjects.GetBtnCreatepartnerPopupSave().click();
			}
			}
		}catch(Exception e)
		{
			throw new Exception("Error on create new partner");
		}
		}
	
}
