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
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/ul/li[1]/a/span")
	WebElement faq;
	/*
	@FindBy()
	WebElement investorRelations;
	
	@FindBy()
	WebElement termsOfUse;
	
	@FindBy()
	WebElement contactUs;
	
	@FindBy()
	WebElement helpCenter;
	
	@FindBy()
	WebElement jobs;
	
	@FindBy()
	WebElement privacy;
	
	@FindBy()
	WebElement speedTest;
	
	@FindBy()
	WebElement account;
	
	@FindBy()
	WebElement giftCards;
	
	@FindBy()
	WebElement cookiePreferences;
	
	@FindBy()
	WebElement netflixOriginals;
	
	@FindBy()
	WebElement mediaCenter;
	
	@FindBy()
	WebElement waysToWatch;
	
	@FindBy()
	WebElement corporateInformation;
	*/
/*	
	@FindBy(xpath = "//*[@id=\"kbArticle\"]/h1")
	WebElement howDoesNetflixWork;
*/	
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
	
	public void verifyLinksOnThePage() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/ul/li[1]/a/span")).click();
	}
	
	public boolean verifyText(String xpath) {
		if(driver.findElement(By.xpath(xpath)).isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
