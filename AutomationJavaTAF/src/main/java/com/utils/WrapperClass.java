package com.utils;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseLogger;

public class WrapperClass extends BaseLogger {
	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public WrapperClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
	}

	

//	// 🔥 Click method with wait & exception handling
//	public void clickElement(By locator) {
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//			System.out.println("Clicked on element: " + locator);
//		} catch (Exception e) {
//			System.out.println("Error clicking element: " + locator + " | Error: " + e.getMessage());
//		}
//	}
//
//	// 🔥 SendKeys method with logging
//	public void enterText(By locator, String text) {
//		try {
//			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//			element.clear();
//			element.sendKeys(text);
//			System.out.println("Entered text '" + text + "' in element: " + locator);
//		} catch (Exception e) {
//			System.out.println("Error entering text: " + locator + " | Error: " + e.getMessage());
//		}
//	}
//
//	// 🔥 Get text from element
//	public String getElementText(By locator) {
//		try {
//			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
//		} catch (Exception e) {
//			System.out.println("Error getting text: " + locator + " | Error: " + e.getMessage());
//			return null;
//		}
//	}
//
//	// 🔥 Check if element is present
//	public boolean isElementPresent(By locator) throws TimeoutException {
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		return true;
//	}
	

    // Click Element - Returns boolean
    public boolean clickElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            log.info("Clicked on element: " + locator);
            return true;
        } catch (Exception e) {
            log.error("Failed to click on element: " + locator, e);
            return false;
        }
    }

    // Enter Text - Returns boolean
    public boolean enterText(By locator, String text) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            log.info("Entered text: '" + text + "' into element: " + locator);
            return true;
        } catch (Exception e) {
            log.error("Failed to enter text into element: " + locator, e);
            return false;
        }
    }

    // Get Text - Returns String
    public String getText(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            String text = element.getText();
            log.info("Extracted text: '" + text + "' from element: " + locator);
            return text;
        } catch (Exception e) {
            log.error("Failed to get text from element: " + locator, e);
            return null;
        }
    }

    // Check Element Exists - Returns boolean
    public boolean isElementPresent(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            boolean isDisplayed = element.isDisplayed();
            log.info("Element found: " + locator);
            return isDisplayed;
        } catch (Exception e) {
            log.warn("Element not found: " + locator);
            return false;
        }
    }

    // Get Attribute Value - Returns String
    public String getAttributeValue(By locator, String attribute) {
        try {
            WebElement element = driver.findElement(locator);
            String value = element.getAttribute(attribute);
            log.info("Retrieved attribute '" + attribute + "' value: '" + value + "' from element: " + locator);
            return value;
        } catch (Exception e) {
            log.error("Failed to retrieve attribute '" + attribute + "' from element: " + locator, e);
            return null;
        }
    }

}
