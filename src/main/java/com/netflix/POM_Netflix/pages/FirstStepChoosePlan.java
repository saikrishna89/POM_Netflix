package com.netflix.POM_Netflix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstStepChoosePlan {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='appMountPoint']/div/div[2]/div/div[1]/div[3]")
	WebElement firstStepChoosePlanText;
	
	public FirstStepChoosePlan(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTextFirstStepChoosePlan() {
		return firstStepChoosePlanText.getText();
	}
}
