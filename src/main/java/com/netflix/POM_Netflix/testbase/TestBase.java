package com.netflix.POM_Netflix.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.netflix.POM_Netflix.excelReader.Excel_Reader;

public class TestBase {
	
	protected static WebDriver driver;
	public Excel_Reader excelReader; 
	
	public void initAndStart() {
		setUp("Chrome");
		getUrl("http://www.netflix.com");
	}
	/*
	static{
		setChromeDriver();
		//setFireFoxDriver();
	}
	*/
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/"+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	/*
	private static void setFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
*/
	private void setChromeDriver() {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/"+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}

	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public String[][] getData(String WorkbookName, String SheetName) {
		String path = System.getProperty("user.dir")+"//src/main/java/com/netflix/POM_Netflix/data/"+WorkbookName+".xlsx";
		excelReader = new Excel_Reader(path);
		return excelReader.getDataFromSheet(SheetName, WorkbookName);
	}
	
	public void getScreenShot(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/netflix/POM_Netflix/screenshot/";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goBackToPreviousPage() {
		driver.navigate().back();
	}
	
}
