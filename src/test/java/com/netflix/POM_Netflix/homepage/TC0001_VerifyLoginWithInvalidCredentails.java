  package com.netflix.POM_Netflix.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.netflix.POM_Netflix.pages.EntryPage;  
import com.netflix.POM_Netflix.pages.SignInPage;
import com.netflix.POM_Netflix.testbase.TestBase;

@Listeners(com.netflix.POM_Netflix.listeners.Listener.class)

public class TC0001_VerifyLoginWithInvalidCredentails extends TestBase{
		
	@DataProvider(name = "loginData")
	public String[][] getTestData(){
		return getData("TestData", "LoginWithInvalidCredentials");
	}
	
	@BeforeClass
	public void init() {
		initAndStart();
	}
	
	@Test(priority=1)
	public void signIn() {
		EntryPage entryPage = new EntryPage(driver);
		entryPage.goToSignInPage();
	}
	
	
	@Test(priority=2, dataProvider = "loginData")
	public void verifyLoginWithInvalidCredentails(String emailAddress, String password) throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.enterEmailAddress(emailAddress);
		signInPage.enterPassword(password);
		signInPage.loginWithCredentials();
		Assert.assertEquals(signInPage.inCorrectPasswordError(), "Incorrect password. Please try again or you can reset your password.");
		//getScreenShot("InvalidLoginCredentials");
	}
	
	@AfterClass
	public void close() {
		closeBrowser();
	} 
}
