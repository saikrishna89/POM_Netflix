package com.netflix.POM_Netflix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.netflix.POM_Netflix.testbase.TestBase;

public class SignInPage extends TestBase{
	
	WebDriver driver;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(className = "login-remember-me-label-text")
	WebElement rememberMeCheckbox;
	
	@FindBy(xpath = "//*[@id='appMountPoint']/div/div[2]/div/div/form[1]/button")
	WebElement signInButton;
	
	@FindBy(xpath= "//*[@id='appMountPoint']/div/div[2]/div/div/div[1]/div[2]")
	WebElement incorrectPassword;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithCredentials() {
		rememberMeCheckbox.click();
		signInButton.click();
	}
	
	public String inCorrectPasswordError() {
		return incorrectPassword.getText();
	}
	
	public void enterEmailAddress(String emailAddress) {
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		pass.clear();
		pass.sendKeys(password);
	}
	
}
