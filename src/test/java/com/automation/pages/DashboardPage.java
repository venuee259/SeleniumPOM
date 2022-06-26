package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;

	@FindBy(xpath="//b[contains(.,'Dashboard')]") //Pagefactory
	WebElement dashboardTab;

	public DashboardPage(WebDriver driver){
		 this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDashboardTabDisplayed(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(dashboardTab)) != null;
		
		//return dashboardTab.isDisplayed();
	}
}
