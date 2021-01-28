/*
 * TestNG class for testing 3 different filters and validating results
 * */

package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapGuitars_POF;
import tools.Elements;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class filtersTest extends setUp {
  
	static boolean isFilterOn;
	static String expected;
	static String filters;
	static String resultsAmount;
	static int numOfResults;
	static List<String> resultsStringList;
	static boolean isListCorrect;
	
	@Test (priority = 1, enabled = true)
  public static void yamahaFilter() throws InterruptedException, AWTException, IOException {
	  
		elements.yamahaFilterTest();       // method that is used in more than one test class, also prints to report
  }
  
  @Test (priority = 2)
  public void classicGuitarFilter() throws InterruptedException, AWTException, IOException {
	 
	  testName = "Classic guitar filter";
	  expected = "קלאסית";
		
		try {
			try {												// try/catch for second test (removingOneFilter)
				pof.classicFilterButton.click();
				Thread.sleep(1000);
			} catch (NoSuchElementException e) {
				testName = "Removing one filter: <2000";
			}
					
			resultsAmount = pof.numOfResults.getText();
			numOfResults = Integer.parseInt(resultsAmount);
			filters = pof.filterButtonsBanner.getText();  							
			
			if (filters != null) {													
				isFilterOn = func.compareStringOrInt(filters, expected, 0, 0);				
				
				resultsStringList = func.getResultsStringList(pof.numOfResultsList);	

				isListCorrect = func.isListCorrect(resultsStringList, expected);	
				
				if (isFilterOn && isListCorrect && numOfResults == resultsStringList.size()) {									
					func.printToReport(true, testName, false);				
					Assert.assertEquals(isFilterOn, true, "Wrong filter");			
				} else {
					func.printToReport(false, testName, false);
					Assert.assertEquals(true, false, "Filter or List are incorrect");
				}				
				
			} else {
				func.printToReport(false, testName, false);
				Assert.assertEquals(true, false, "Null filter");
			}
			
		} catch (Exception e) {
			func.printToReport(isFilterOn, testName, true);
			e.printStackTrace();
			Assert.assertEquals(false, true, "An exception occured");
		} 
		
		resultsStringList.clear();
  }
  
  @Test (priority = 3)
  public void priceFilter() throws AWTException, IOException {
	  
	  testName = "Price filter";
	  expected = "2,000";
	  String result;
	  List<String> pricesList = new ArrayList<String>();
	  
		try {
			pof.under2000Filter.click();
			Thread.sleep(1000);
			
			resultsAmount = pof.numOfResults.getText();
			numOfResults = Integer.parseInt(resultsAmount);
			filters = pof.filterButtonsBanner.getText();  							
			
			if (filters != null) {													
				isFilterOn = func.compareStringOrInt(filters, expected, 0, 0);				
				
				pricesList = func.getResultsStringList(pof.singlePrice);			// set new list of prices as strings

				for (String str : pricesList) {										// converting strings to ints
					String s = str.trim().replace(",", "");					
					String[] stringPrices = s.split(" ");
					int price = Integer.parseInt(stringPrices[0]);
						
						if (price < 2000) {											// Validating that price is lower than 2000
							result = "true";
							resultsStringList.add(result);
						} else {
							result = "false";
							resultsStringList.add(result);
						}
					}
				
				isListCorrect = func.isListCorrect(resultsStringList, "true");		
				
				if (isFilterOn && isListCorrect && numOfResults == resultsStringList.size()) {									
					func.printToReport(true, testName, false);				
					Assert.assertEquals(isFilterOn, true, "Wrong filter");			
				} else {
					func.printToReport(false, testName, false);
					Assert.assertEquals(true, false, "Filter or List are incorrect");
				}				
				
			} else {
				func.printToReport(false, testName, false);
				Assert.assertEquals(true, false, "Null filter");
			}
			
		} catch (Exception e) {
			func.printToReport(isFilterOn, testName, true);
			e.printStackTrace();
			Assert.assertEquals(false, true, "An exception occured");
		} 
		
		resultsStringList.clear();
  }
  
  @Test (priority = 4)
  public void removingOneFilter() throws AWTException, IOException {
	  /*using classicGuitarFilter test method again*/
	  try {
		  pof.closeFilter_3.click();
		  Thread.sleep(1000);
		  classicGuitarFilter();
	  } catch (Exception e) {
		  func.printToReport(isFilterOn, testName, true);
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
	  test = exm.createTest("Filters test", "Filters test");
	  
	  resultsStringList = new ArrayList<String>();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
