package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import com.automation.utilies.DataProviders;
import com.automation.utilies.Utils;

public class LoginTests extends BaseTest{
	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	
	@BeforeMethod(alwaysRun = true)
	void setUpPages(){
		driver = openApplication();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	} 
	
	
	@Parameters({"uid","pwd"})
	//@Test(groups ={"Regression"}, priority = 1)
	public void loginTest1(String uid, String pwd){
//		loginPage.setDataOnUserName(uid);
//		loginPage.setDataOnPassword(pwd);
		loginPage.setDataOnUserName(Utils.getDatafromPropertiesFile("UID"));
		loginPage.setDataOnPassword(Utils.getDatafromPropertiesFile("PASSWORD"));
		
		loginPage.setDataOnUserName(Utils.getDatafromJSONFile("uid"));
		loginPage.setDataOnPassword(Utils.getDatafromJSONFile("pwd"));
		
		loginPage.clickOnLoginBtn();
		
		Assert.assertTrue(dashboardPage.isDashboardTabDisplayed(), "login is failed");
	}
	
	
	@Parameters({"uid","pwd"})
	@Test(groups ={"Somke","Regression"} , enabled = false, priority=0, dependsOnMethods="loginTest1")
	public void loginTest2(String uid, String pwd){
//		loginPage.setDataOnUserName(uid);
//		loginPage.setDataOnPassword(pwd);
		loginPage.setDataOnUserName(Utils.getDatafromPropertiesFile("UID"));
		loginPage.setDataOnPassword(Utils.getDatafromPropertiesFile("PASSWORD"));
		
		loginPage.setDataOnUserName(Utils.getDatafromJSONFile("uid"));
		loginPage.setDataOnPassword(Utils.getDatafromJSONFile("pwd"));
		
		loginPage.clickOnLoginBtn();
		
		Assert.assertTrue(dashboardPage.isDashboardTabDisplayed(), "login is failed");
	}
	
	
	@Test(dataProvider = "getUIDAndPWD", dataProviderClass=DataProviders.class, groups = "Smoke")
	public void loginTest3(String uid, String pwd){
//		loginPage.setDataOnUserName(uid);
//		loginPage.setDataOnPassword(pwd);
		loginPage.setDataOnUserName(uid);
		loginPage.setDataOnPassword(pwd);
		
		
		loginPage.clickOnLoginBtn();
		
		Assert.assertTrue(dashboardPage.isDashboardTabDisplayed(), "login is failed");
	}
	
//	@DataProvider(name="abcdata")
//	public  Object[][] getUIDAndPWD(){
//		Object data[][] = new Object[][]{
//			{"Admin","admin123"},
//			{"Admin","admin1234"}
//		};
//		
//		return data;
//		
//	}

}
