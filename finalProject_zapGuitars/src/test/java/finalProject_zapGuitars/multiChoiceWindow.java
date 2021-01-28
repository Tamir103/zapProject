package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapGuitars_POF;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class multiChoiceWindow extends setUp {
	
	static boolean isConditionTrue;
	static List<String> multiChoiceItemsList;
	static List<Integer> multiChoiceQuantityList;
	static String filters;
	static int currentListCount;
	static int expectedListCount;
	
  @Test (priority = 1)
  public void openMultiChoiceWindow() throws AWTException, IOException {
	  
	  testName = "Opening multiple choice manufacturer window";
	  
	  try {
	  pof.multiSelectManufacturerButton.click(); 			//opening multiple choice window by manufacturer 
	  Thread.sleep(2000);
	  
	  isConditionTrue = func.isMultiWindowOpen();			// checking if multiple choice window is open
	  
	  if (isConditionTrue) {
			func.printToReport(true, testName, false);				
			Assert.assertEquals(isConditionTrue, true, "Not multiple choice");			
		} else {
			func.printToReport(false, testName, false);
			Assert.assertEquals(true, false, "Not multiple choice");
		}		
	  
	  } catch (Exception e) {
		  func.printToReport(isConditionTrue, testName, true);
		  e.printStackTrace();
		  Assert.assertEquals(false, true, "An exception occured");
	}
  }
  
  @Test (priority = 2)
  public void chooseOneFilter() throws AWTException, IOException {
	  
	  testName = "Single choice in multiple choice window";
	  
	  try {
		pof.oneChoiceButtton.click();
		Thread.sleep(1000);
		
		isConditionTrue = func.isMultiChoice();
		
		if (isConditionTrue) {
			func.printToReport(true, testName, false);				
			Assert.assertEquals(isConditionTrue, true, "Not multiple choice");			
		} else {
			func.printToReport(false, testName, false);
			Assert.assertEquals(true, false, "Not multiple choice");
		}		
		
	  } catch (Exception e) {
		  func.printToReport(isConditionTrue, testName, true);
		  e.printStackTrace();
		  Assert.assertEquals(false, true, "An exception occured");
	  }
  }
  @Test (priority = 3, dependsOnMethods = "chooseOneFilter")
  public void oneFilterOnly() {
	  
	  try {
		pof.yamahaSingleChoice.click();
		Thread.sleep(2000);
		
		elements.yamahaFilterTest();        // method that is used in more than one test class, also prints to report
		
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  @Test (priority = 4)
  public void alphabeticalOrder() throws AWTException, IOException {
	  
	  testName = "Alphabetical order test";
	  
	  try {
		  
		  filters = pof.filterButtonsBanner.getText();  							
		  if (filters != null) {
			 pof.closeFilter_1.click(); 			// closing filter if one exist
		  }
		  
		  try {
			pof.multiSelectManufacturerButton.click();		// opening multiple choice by manufacturer window, if not already open
			Thread.sleep(1000);
		  } catch (NoSuchElementException e) {
		  }
		  
		 pof.alphabetButton.click();						// sorting manufacturers list by alphabetical order
		 Thread.sleep(1000);		
			
		 	for (WebElement w : pof.multiChoiceItemsList) { // converting list from web elements to strings
		 		multiChoiceItemsList.add(w.getText());
		 	}
		 Collections.sort(multiChoiceItemsList);										// sorting list to alphabetical order
		 expectedListCount = func.listAlphabeticalOrderCount(multiChoiceItemsList);  	// counting how many consecutive different letters are in list
		 multiChoiceItemsList.clear();												// clearing list so it can be reused
		 
			for (int i = 1; i <= pof.multiChoiceItemsList.size(); i++) {				// adding to the list in the exact order as it appears in the web page, using loop index
				multiChoiceItemsList.add(driver.findElement
						(By.xpath("//label[@for='db2835807_"+i+"']/div[@class='txtLtr']")).getText());
			}
			
		currentListCount = func.listAlphabeticalOrderCount(multiChoiceItemsList);		// counting how many consecutive different letters are in list
		multiChoiceItemsList.clear();
		
		isConditionTrue = func.compareStringOrInt(null, null, currentListCount, expectedListCount);		// comparing current and expected, if equal returns true
		
		func.printToReport(isConditionTrue, testName, false);
		
		Assert.assertEquals(isConditionTrue, true, "Not in alphabetical order");
		
	} catch (Exception e) {
		 func.printToReport(isConditionTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true, "An exception occured");
	}
	  
  }
  
  @Test (priority = 5)
  public void numericalOrder() throws AWTException, IOException {
	  
	  testName = "Quantities numerical order test";
	  
	  try {
		  try {
			pof.multiSelectManufacturerButton.click();		// opening multiple choice by manufacturer window, if not already open
			Thread.sleep(1000);
		  } catch (NoSuchElementException e) {
		  } catch (ElementClickInterceptedException e) {
		  }
		  
		pof.quantityButton.click();
		Thread.sleep(1000);
		
		for (WebElement w : pof.multiChoiceItemsQuantityList) { 			// converting list from web elements to int
	 		String s = w.getText().replace("(", "").replace(")", "");
	 		int a = Integer.parseInt(s);
			multiChoiceQuantityList.add(a);
	 	}
		
		isConditionTrue = func.isListInNumericalOrder(multiChoiceQuantityList, multiChoiceQuantityList.size());
		
		func.printToReport(isConditionTrue, testName, false);
		
		Assert.assertEquals(isConditionTrue, true, "Not in numerical order");
	} catch (Exception e) {
		func.printToReport(isConditionTrue, testName, true);
		e.printStackTrace();
		Assert.assertEquals(false, true, "An exception occured");
	}
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.zap.co.il/models.aspx?sog=g-guitar");
	  driver.manage().window().maximize();
	  
	  pof = PageFactory.initElements(driver, zapGuitars_POF.class);
	  
	  extent = exm.getExtentReports();
	  test = exm.createTest("Multiple choice filter window test", "Multiple choice filter window test");
	  
	  multiChoiceItemsList = new ArrayList<String>();
	  multiChoiceQuantityList = new ArrayList<Integer>();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
