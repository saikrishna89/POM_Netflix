package com.netflix.POM_Netflix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.netflix.POM_Netflix.testbase.TestBase;

public class EntryPage extends TestBase{
	
	//WebDriver driver;
	
	@FindBy(linkText = "Sign In")
	WebElement signInButton;
	
	@FindBy(xpath = "//*[@id='formstart']/button")
	WebElement joinFreeForAMonth;
	
	public EntryPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToSignInPage() {
		signInButton.click();
	}
	
	public void goToStepsForChoosingPlan() {
		joinFreeForAMonth.click();
	}
}
