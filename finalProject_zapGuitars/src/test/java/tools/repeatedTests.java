package tools;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class repeatedTests extends setUp {

	static boolean isFilterOn;
	static String expected;
	static String filters;
	static String resultsAmount;
	static int numOfResults;
	static List<String> resultsStringList;
	static boolean isListCorrect;
	
	public static void yamahaFilterTest() throws AWTException, IOException {
		
	testName = "Yamaha manufacturer filter";
	expected = "Yamaha";
	
	try {
		try {
			func.clickOnElement(pof.yamahaFilterButton);
		} catch (NoSuchElementException e) {
		}
		
		numOfResults = func.getNumOfSearchResultsInt();								// getting the number of results and converting it to int
		filters = pof.filterButtonsBanner.getText();  								// getting filter text
		
		if (filters != null) {														// if filter exist
			isFilterOn = func.compareStringOrInt(filters, expected, 0, 0);			// is filter contains correct filtering string, 0 because not comparing ints			
			resultsStringList = func.getResultsStringList(pof.numOfResultsList);	// getting filtered results list as strings
			isListCorrect = func.isListCorrectOneItem(resultsStringList, expected);						// checking if all results containing key string
			
			if (isFilterOn && isListCorrect && numOfResults == resultsStringList.size()) {			// test pass if filter and list are correct, and amount of results match list size
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
	
	resultsStringList.clear();													// clearing the list

	}
}
