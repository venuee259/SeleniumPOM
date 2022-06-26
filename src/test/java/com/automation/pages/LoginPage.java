package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="txtUsername") //Pagefactory
	WebElement userName;
	// By UserName = By.xpath("//input[@id='txtUsername']");

	@FindBy(name="txtPassword") //Pagefactory
	WebElement password;
	// By PassWord = By.xpath("//input[@id='txtPassword']");
	
	@FindBy(xpath="//input[@id='btnLogin']") //Pagefactory
	WebElement LoginBtn;
	// By LoginBtn = By.xpath("btnLogin");

	//By loginBtn = By.id("btnLogin"); 

	public LoginPage(WebDriver driver){
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setDataOnUserName(String uid){
		userName.sendKeys(uid);
		// driver.findElement(UserName).sendKeys(uid);
	}

	public void setDataOnPassword(String pwd){
		password.sendKeys(pwd);
		//driver.findElement(PassWord).sendKeys(pwd);
	}

	public void clickOnLoginBtn(){
		LoginBtn.click();
		//driver.findelement(LoginBtn).click;
	}
}
