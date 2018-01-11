package com.netflix.POM_Netflix.homepage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.netflix.POM_Netflix.pages.EntryPage;
import com.netflix.POM_Netflix.testbase.TestBase;

@Listeners(com.netflix.POM_Netflix.listeners.Listener.class)

public class TC0003_VerifyLinksOnTheHomePage extends TestBase{
	
	EntryPage entryPage;
	
	@DataProvider(name = "links")
	public String[][] getTestData(){
		return getData("TestData", "LinksOnHomePage");
	}
	
	@BeforeClass
	public void init() {
		initAndStart();
	}
	
	@Test(priority = 1, dataProvider = "links")
	public void clickLinksOnTheHomePage(String links, String keywordsForAssertions) {
		entryPage = new EntryPage(driver);
		String url = entryPage.getCurrentUrl();
		driver.findElement(By.xpath("//*[contains(text(),"+" '"+links+"')]")).click();
		Assert.assertEquals(entryPage.verifyText(keywordsForAssertions), true);
		getUrl(url);
	}

	@AfterClass
	public void close() {
		closeBrowser();
	} 
}
