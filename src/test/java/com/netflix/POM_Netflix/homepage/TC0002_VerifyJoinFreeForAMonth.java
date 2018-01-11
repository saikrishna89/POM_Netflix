package com.netflix.POM_Netflix.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.netflix.POM_Netflix.pages.EntryPage;
import com.netflix.POM_Netflix.pages.FirstStepChoosePlan;
import com.netflix.POM_Netflix.pages.SignInPage;
import com.netflix.POM_Netflix.testbase.TestBase;

@Listeners(com.netflix.POM_Netflix.listeners.Listener.class)

public class TC0002_VerifyJoinFreeForAMonth extends TestBase{
	
	@BeforeClass
	public void init() {
		initAndStart();
	}
	
	@Test
	public void verifyJoinFreeForAMonth() throws InterruptedException {
		EntryPage entryPage = new EntryPage(driver);
		FirstStepChoosePlan fisStepChoosePlan = new FirstStepChoosePlan(driver);
		entryPage.goToStepsForChoosingPlan();
		Assert.assertEquals(fisStepChoosePlan.getTextFirstStepChoosePlan(), "Choose from any of our three plans, and you won't be charged until after your free month ends.");
	}
	
	@AfterClass
	public void close() {
		closeBrowser();
	} 
}
