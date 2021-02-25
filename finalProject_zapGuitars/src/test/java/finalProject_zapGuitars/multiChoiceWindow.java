package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.appSettings;
import tools.repeatedTests;
import tools.zapGuitars_POF;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class multiChoiceWindow extends appSettings {
	
	static boolean isConditionTrue;
	static List<String> multiChoiceItemsList;
	static List<Integer> multiChoiceQuantityList;
	static String filters;
	static int currentListCount;
	static int expectedListCount;
	static boolean isFilterOn;
	static List<String> resultsStringList;
	static boolean isListCorrectThreeItems;
	
	@Test (priority = 1)
	  public void MoreManufacturer() throws AWTException, IOException {
		  
		  testName = "Open multiple choice window in single choice mode";
		  
		  try {
			  isConditionTrue = func.isMultiWindowOpen(); 			// checking if multiple choice window is open, if open - close it
				if (isConditionTrue) {
					func.clickOnElement(pof.closeMultiWindow);
					Thread.sleep(1000);
					isConditionTrue = func.isMultiWindowOpen();
				}
			  
			  	if (!isConditionTrue) {
					func.clickOnElement(pof.moreManufacturer);
					Thread.sleep(1000);
				}
			isConditionTrue = func.multiWindowSingleChoiceDisplay();
				
			if (isConditionTrue) {
				func.printToReport(true, testName, false);				
				Assert.assertEquals(isConditionTrue, true, "Not single choice");			
			} else {
				func.printToReport(false, testName, false);
				Assert.assertEquals(true, false, "Not single choice");
			}		
				
		} catch (Exception e) {
			 func.printToReport(isConditionTrue, testName, true);
			 e.printStackTrace();
			 Assert.assertEquals(false, true, "An exception occured");
		}
	  }
	
	
  @Test (priority = 2, enabled = true)
  public void openMultiChoiceWindow() throws AWTException, IOException {
	  
	  testName = "Opening multiple choice manufacturer window";
	  
	 try {	  
		 isConditionTrue = func.isMultiWindowOpen(); 			// checking if multiple choice window is open, if open - close it
			if (isConditionTrue) {
				func.clickOnElement(pof.closeMultiWindow);
				Thread.sleep(1000);
				isConditionTrue = func.isMultiWindowOpen();
			}
		 
			if (!isConditionTrue) {
				func.openMultiWindow();
				Thread.sleep(1000);
				isConditionTrue = func.isMultiWindowOpen();
			}			
	  
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
  
  
  @Test (priority = 3, enabled = true)
  public void chooseOneFilter() throws AWTException, IOException {
	  
	  testName = "Switch to single choice in multiple choice window";
	  
	  try {
		isConditionTrue = func.isMultiWindowOpen();
			if (!isConditionTrue) {
				func.openMultiWindow();
				Thread.sleep(1000);
			}
			
		func.clickOnElement(pof.oneChoiceButtton);
		isConditionTrue = func.multiWindowSingleChoiceDisplay();	
		
		if (isConditionTrue) {
			func.printToReport(true, testName, false);				
			Assert.assertEquals(isConditionTrue, true, "Not single choice");			
		} else {
			func.printToReport(false, testName, false);
			Assert.assertEquals(true, false, "Not single choice");
		}		
		
	  } catch (Exception e) {
		  func.printToReport(isConditionTrue, testName, true);
		  e.printStackTrace();
		  Assert.assertEquals(false, true, "An exception occured");
	  }
  }
  @Test (priority = 4, dependsOnMethods = "chooseOneFilter", enabled = true)
  public void oneFilterOnly() {
	  
	  try {
		func.clickOnElement(pof.yamahaSingleChoice);
		
		repeatedTests.yamahaFilterTest();        // method that is used in more than one test class, also prints to report
		
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  @Test (priority = 5, enabled = true)
  public void alphabeticalOrder() throws AWTException, IOException {
	  
	  testName = "Alphabetical order test";
	  
	  try {  
		  filters = pof.filterButtonsBanner.getText();  							
		  if (filters != null) {
			func.clickOnElement(pof.closeFilter_1); 					// closing filter if one exist
		  }
		  
		isConditionTrue = func.isMultiWindowOpen();			// opening multi choice manufacturer window, if not already open
			if (!isConditionTrue) {
				func.openMultiWindow();
				Thread.sleep(2000);
			}
		 
		func.clickOnElement(pof.alphabetButton);			// sorting manufacturers list by alphabetical order		
			
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
  
  @Test (priority = 6, enabled = true)
  public void numericalOrder() throws AWTException, IOException {
	  
	  testName = "Quantities numerical order test";
	  
	  try {
		  isConditionTrue = func.isMultiWindowOpen();
			if (!isConditionTrue) {
				func.openMultiWindow();
				Thread.sleep(2000);
			}
		 func.clickOnElement(pof.quantityButton);
		
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
  
  @Test (priority = 7)
  public void checkingBoxes() throws AWTException, IOException {
	  
	  testName = "Checkboxes results test";
	  String expected1 = "Yamaha", expected2 = "Fender", expected3 = "Takamine";
	  
	  try {
		  isConditionTrue = func.isMultiWindowOpen();
			if (!isConditionTrue) {
				func.openMultiWindow();
				Thread.sleep(1000);
			}
					
		func.checkTheBox(true, pof.yamahaCheckbox);
		func.checkTheBox(true, pof.fenderCheckbox);
		func.checkTheBox(true, pof.takamineCheckbox);
		
		func.clickOnElement(pof.filterButton);
		
		int numOfResults = func.getNumOfSearchResultsInt();  
		filters = pof.filterButtonsBanner.getText();  							
		
		if (filters != null) {																					
			resultsStringList = func.getResultsStringList(pof.numOfResultsList);	
			isListCorrectThreeItems = func.isListCorrectThreeItems(resultsStringList, expected1, expected2, expected3);	
		
				if (isListCorrectThreeItems && numOfResults == resultsStringList.size()) {									
					func.printToReport(true, testName, false);				
					Assert.assertEquals(isListCorrectThreeItems, true, "Wrong filter");		
				} else {
					func.printToReport(false, testName, false);
					Assert.assertEquals(true, false, "Filter or List are incorrect");
				}					
		} else {
			func.printToReport(false, testName, false);
			Assert.assertEquals(true, false, "Null filter");
		}
		
	} catch (Exception e) {
		func.printToReport(isListCorrectThreeItems, testName, true);
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
