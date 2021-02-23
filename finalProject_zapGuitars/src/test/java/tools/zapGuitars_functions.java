package tools;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;


public class zapGuitars_functions extends setUp {
	
	static ArrayList<String> tabs;
	static List<String> falseStrings = new ArrayList<String>();
	static ArrayList<Boolean> booleanList = new ArrayList<Boolean>();

	public void printToReport(boolean testResult, String testName, boolean exception) throws AWTException, IOException {
		
		if (!exception) {
			if (testResult) {
				test.pass(testName + " passed");
			} else {
				test.fail(testName + " failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
		
		} else {
			test.fail(testName + " failed by exception, check code");
		}
}
	
	
	public void returnToMainPage() throws InterruptedException {
		
		String currentPageTitle = driver.getTitle();
		String mainPageTitle = "זאפ השוואת מחירים";
		
		if (!currentPageTitle.equalsIgnoreCase(mainPageTitle)) {
			driver.navigate().to("https://www.zap.co.il/");
			Thread.sleep(2000);
		}
		
	}

	public boolean linkTest(WebElement link, WebDriver driver, String expectedTitle) throws InterruptedException {
		
		String target = link.getAttribute("target");
		
		if (target.equalsIgnoreCase("_blank")) {
			clickOnElement(link);
			
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			String webPageTitle = driver.getTitle();
			webPageTitle.trim();
			
				if (webPageTitle.equalsIgnoreCase(expectedTitle)) {
					return true;
				} else {
					return false;
				}
			
		} else {
			clickOnElement(link);
			
			String webPageTitle = driver.getTitle();
			webPageTitle.trim();
			
				if (webPageTitle.equalsIgnoreCase(expectedTitle)) {
					return true;
				} else {
					return false;
				}
		}
	}
	
	public void closeTab() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);
	}
	
	public boolean visibleIframeTest(boolean clickLink, WebElement link, WebElement iframeDiv, String iframeId) throws InterruptedException {
		
		String displayValue = "";
		
		if (clickLink) {
			clickOnElement(link);
		}	

		displayValue = iframeDiv.getAttribute("style");

		// "style = display: block;" in iframe div means that iframe is visible, "style = display: none;" means it's not visible. 	
		if (displayValue.contains("block")) {
			driver.switchTo().frame(driver.findElement(By.id(iframeId)));
			return true;
		} else {
			return false;
		}
			
	}

	public void closeIframe(WebElement iframeCloseButton) throws InterruptedException {
		clickOnElement(iframeCloseButton);
		driver.switchTo().defaultContent();
	}
	
	
	public void searchBoxInput(WebElement searchBox, String searchString) throws InterruptedException {
	
		clickOnElement(searchBox);

		action.moveToElement(searchBox).sendKeys(searchString).build().perform();	
	}
	
	public void clickOnElement(WebElement button) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		button.click();
		Thread.sleep(3000);
	}
	
	public void pressEnter( WebElement element) throws InterruptedException {
		action.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(2000);
	}
	
	public boolean checkPageTitle(String expectedPageTitle) {		
		String currentPageTitle = driver.getTitle();
		currentPageTitle.trim();
		
		boolean result = (currentPageTitle.contains(expectedPageTitle)) ? true : false;
		return result;		
	}
	
	public boolean checkPageURL(String expectedURL) {
		String currentPageURL = driver.getCurrentUrl();
		currentPageURL.trim();
		
		boolean result = (currentPageURL.contains(expectedURL)) ? true : false;
		return result;		
	}
	
	public boolean compareStringOrInt(String currentString, String expectedString, int currentCount, int expectedCount) {
		/*
		 Using one method for comparing strings or ints
		  */
				
		if (currentString == null) {
			boolean result = (currentCount == expectedCount) ? true : false;
			return result;
		} else {
			boolean result = (currentString.contains(expectedString)) ? true : false;
			return result;
		}
			
	}
	
	public List<String> isPriceUnder2000(List<String> pricesList) {
		
		List<String> under2000List = new ArrayList<String>();
		String result;
		
		for (String str : pricesList) {										// converting strings to ints
			String s = str.trim().replace(",", "");					
			String[] stringPrices = s.split(" ");
			int price = Integer.parseInt(stringPrices[0]); 
				
				if (price < 2000) {											// Validating that price is lower than 2000
					result = "true";
					under2000List.add(result);
				} else {
					result = "false";
					under2000List.add(result);
				}
			}
		return under2000List;
	}
	
	public int getNumOfSearchResultsInt() {
		int numOfResults;
		String resultsAmount;
		
		resultsAmount = pof.numOfResults.getText();
		numOfResults = Integer.parseInt(resultsAmount);
		
		return numOfResults;
	}
	
	public List<String> getResultsStringList(List<WebElement> elementsList) throws InterruptedException {
		
		List<String> resultsList = new ArrayList<String>();
		String forBtnAtt;
		do {
			try {
				forBtnAtt = pof.forwardButton.getAttribute("class"); 
			
			} catch (NoSuchElementException e) {
				forBtnAtt = "Disabled";
			}
				for (int i = 0; i < elementsList.size(); i++) {
					resultsList.add(elementsList.get(i).getText());
				}
			try {
				clickOnElement(pof.forwardButton);
			} catch (NoSuchElementException e) {
			}
		} while(!forBtnAtt.contains("Disabled"));
		
		return resultsList;
	}
	
	public boolean isListCorrectOneItem(List<String> list, String expected) {
		
		boolean result = true;
		
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.containsIgnoreCase(list.get(i), expected)) {
				booleanList.add(true);
			} else {
				booleanList.add(false);
			}
		}
		
		for (int j = 0; j < booleanList.size(); j++) {
			if (!booleanList.get(j)) {
				falseStrings.add(list.get(j));
			} 
		}
		booleanList.clear();
		
		if (!falseStrings.isEmpty()) {			// falseStrings list could be used later to analyze which list items are wrong
			result = false;
		}
		return result;
	}
	
	public boolean isListCorrectThreeItems(List<String> list, String expected1, String expected2, String expected3) {
		
		boolean result = true;
		
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.containsIgnoreCase(list.get(i), expected1) || 
					StringUtils.containsIgnoreCase(list.get(i), expected2) ||
					StringUtils.containsIgnoreCase(list.get(i), expected3)) {
				booleanList.add(true);
			} else {
				booleanList.add(false);
			}
		}
		
		for (int j = 0; j < booleanList.size(); j++) {
			if (!booleanList.get(j)) {
				falseStrings.add(list.get(j));
			} 
		}
		booleanList.clear();
		
		if (falseStrings != null) {			// falseStrings list could be used later to analyze which list items are wrong
			result = false;
		} 
		return result;
	}
	
	public boolean isMultiWindowOpen() throws InterruptedException  {
		
		String visibleOrNot = pof.multiChoiceWindow.getAttribute("style");
		
		if (visibleOrNot.contains("visible")) {
			Thread.sleep(1000);
			return true;
		} else {
			Thread.sleep(1000);
			return false;
		}
	}
	
	public void openMultiWindow() throws InterruptedException {
		
		try {
			clickOnElement(pof.multiSelectManufacturerButton);		// opening multiple choice by manufacturer window, if not already open
		} catch (NoSuchElementException e) {
		} catch (ElementClickInterceptedException e) {
		} 
	}
	
	public boolean multiWindowSingleChoiceDisplay() throws InterruptedException {
		
	/* validating single choice display by trying to click on one checkbox  */
		boolean bool;
		try {																	
			clickOnElement(pof.yamahaCheckbox);
			bool = false;
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			bool = true;
		}
		return bool;
	}
	
	public int listAlphabeticalOrderCount(List<String> listToCheck) {
		
		/*
		looping through the list to check that it is in alphabetic order, 
		using ASC2 character numbers (97 = lower case a, 122 = lower case z).
		if counter equals the expected characters number (number of different letters in list), then the list is in alphabetical order.
		In this project comparison is conducted in a different method.
		*/
			int counter = 1;
			int charASC2 = 97;
			for (int i = 0; i < listToCheck.size(); i++) {	
				char a = listToCheck.get(i).toLowerCase().charAt(0); //getting the lower case first character of each string in list 
				
				if (a != charASC2) {   			// if not equals to current ASC2 char,
					while(charASC2 <= 122) {	// runs a loop on all letters by alphabetical order, until it finds the next letter by order 
						if (a == charASC2) {	// when it find the letter by order, a counter adds 1, and loop breaks for next list item  
							counter++;
							break;
						} else {
							charASC2++;			// advancing to the next letter value
						}
					}
				}
			}
			return counter;			
	}
	
	public static boolean isListInNumericalOrder(List<Integer> numList, int expectedCount) {
		
		int firstInt, secondInt, counter = 0;	
			firstLoop:
				for (int i = 0; i < numList.size(); i++) {
					firstInt = numList.get(i);					// loop for getting item int value from the list
					
						for (int j = i+1; j <= i+1; j++) {
							if (j == numList.size()) {
								counter++;
								break firstLoop;
							} else {
							secondInt = numList.get(j);			// loop that runs one time, getting the next item int value from the list
							}
							
							if (firstInt >= secondInt) {		
								counter++;
							} else {
								break firstLoop;
							}
						}
				}
		
		boolean result = (counter == expectedCount) ? true : false;
		return result;
	}
	
	public void checkTheBox(boolean check, WebElement checkboxElement) throws InterruptedException {
		
		if (check) {
			if (!checkboxElement.isSelected()) {
				clickOnElement(checkboxElement);
			}
		} else {
			if (checkboxElement.isSelected()) {
				clickOnElement(checkboxElement);
			}
		}
	}
}
