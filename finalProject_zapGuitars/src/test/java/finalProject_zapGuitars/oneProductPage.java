package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.Elements;
import tools.zapGuitars_POF;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class oneProductPage extends setUp {
	
	static boolean isPageCorrect;
	
  @Test (priority = 1, enabled = true)
  public void productHeadlineLink() throws InterruptedException, AWTException, IOException {
	  
	  testName = "Product headline link";
	  expected = "גיטרה קלאסית Cort AC100 - זאפ";
	  
	  try {
		  func.clickOnElement(pof.AC100HeadlineLink);		  
		  isPageCorrect = func.checkPageTitle(expected);		  		  		  
		  func.printToReport(isPageCorrect, testName, false);
		  driver.navigate().back();
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageCorrect, testName, true);			
		  e.printStackTrace();			
		  Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 2)
  public void productMoreDetails() throws AWTException, IOException {
	  
	  testName = "Product more details link";
	  expected = "מפרט טכני ‏גיטרה קלאסית";
	  
	  try {
		  func.clickOnElement(pof.AC100MoreDetailsLink);		  
		  isPageCorrect = func.checkPageTitle(expected);		  		  
		  func.printToReport(isPageCorrect, testName, false);
		  driver.navigate().back();
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageCorrect, testName, true);			
		  e.printStackTrace();		
		  Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  
  @Test (priority = 3, enabled = true)
  public void productReviews() throws AWTException, IOException {
	  
	  testName = "User reviews for Cort AC100";
	  expected = "ratemodel";
	  
	  try {
		  func.clickOnElement( pof.AC100reviewsLink);	  
		  isPageCorrect = func.checkPageURL(expected);		  
		  func.printToReport(isPageCorrect, testName, false);
		  driver.navigate().back();
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageCorrect, testName, true);			
		  e.printStackTrace();			
		  Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  
  @Test (priority = 4, enabled = true)
  public void productPriceComparison() throws AWTException, IOException {
	  
	  testName = "Product price comparison link";
	  expected = "גיטרה קלאסית Cort AC100 - זאפ";
	  
	  try {
		  func.clickOnElement( pof.AC100PriceCompareLink);	  
		  isPageCorrect = func.checkPageTitle(expected);		  
		  func.printToReport(isPageCorrect, testName, false);		  
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageCorrect, testName, true);			
		  e.printStackTrace();			
		  Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 5, dependsOnMethods = {"productPriceComparison"} , enabled = true)
  public void localStore() throws AWTException, IOException {
	  
	  /*this test and the following test depends on page that opened in former test "productPriceComparison"*/
	  
	  testName = "Buy product at local Store page";
	  expected = "קניה בחנות מקומית";
	  
	  try {
		func.clickOnElement(pof.localStore);		
		isPageCorrect = func.checkPageTitle(expected);		
		func.printToReport(isPageCorrect, testName, false);		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		 func.printToReport(isPageCorrect, testName, true);			
		 e.printStackTrace();			
		 Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 6, enabled = true)
  public void techSpec() throws AWTException, IOException {
	
	  testName = "Product full technical specification page";
	  expected = "מפרט טכני ‏גיטרה קלאסית";
	  
	  try {
		func.clickOnElement(pof.techSpec);		
		isPageCorrect = func.checkPageTitle(expected);	
		func.printToReport(isPageCorrect, testName, false);		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		 func.printToReport(isPageCorrect, testName, true);			
		 e.printStackTrace();			
		 Assert.assertEquals(false, true, "An exception occurred");
	}
}
  
  @Test (priority = 7, enabled = true)
  public void userReviews() throws AWTException, IOException {
	  
	  testName = "Product user reviews page";
	  expected = "ratemodel";
	  
	  try {
		func.clickOnElement(pof.userReviews);		
		isPageCorrect = func.checkPageURL(expected);  				// using check URL method because this page has no title		
		func.printToReport(isPageCorrect, testName, false);		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		 func.printToReport(isPageCorrect, testName, true);		
		 e.printStackTrace();			
		 Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.zap.co.il/models.aspx?sog=g-guitar");
	  driver.manage().window().maximize();
	  
	  pof = PageFactory.initElements(driver, zapGuitars_POF.class);
	  
	  extent = exm.getExtentReports();
	  test = exm.createTest("One product page test", "One product page test");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
