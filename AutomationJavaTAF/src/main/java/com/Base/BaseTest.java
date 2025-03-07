package com.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 protected static WebDriver driver;

	    @BeforeSuite
	    public void setup() {
	        try {
	            if (driver == null) {
	                System.out.println("Starting Chrome Driver...");

	                WebDriverManager.chromedriver().clearDriverCache().setup();
	                WebDriverManager.chromedriver().avoidBrowserDetection().setup();

	                ChromeOptions options = new ChromeOptions();
	                options.addArguments("--remote-allow-origins=*");
	                options.addArguments("--disable-extensions");
	                options.addArguments("--disable-gpu");
	                options.addArguments("--no-sandbox");
	                options.addArguments("--disable-dev-shm-usage");

	                driver = new ChromeDriver(options);
	                driver.manage().window().maximize();
	            } else {
	                System.out.println("WebDriver is already initialized!");
	            }
	        } catch (Exception e) {
	            System.out.println("WebDriver Initialization Failed: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @AfterSuite
	    public void teardown() {
	        if (driver != null) {
	            System.out.println("Closing Chrome Driver...");
	            driver.quit();
	            driver = null; // 🔥 Reset driver after quitting
	        }
	    }
	    
	    public WebDriver getDriver() {
			return driver;
		}
	}

