package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.Elements;
import tools.zapGuitars_POF;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class oneProductPage extends setUp {
	
	static boolean isPageCorrect;
	static String expected;
	
  @Test (priority = 1, enabled = false)
  public void productHeadlineLink() throws InterruptedException, AWTException, IOException {
	  
	  testName = "Product headline link";
	  expected = "‏גיטרה קלאסית Cort AC100 - זאפ";
	  
	  try {
		  pof.AC100HeadlineLink.click();
		  Thread.sleep(2000);
		  
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
  
  @Test (priority = 2, enabled = false)
  public void productPriceComparison() throws AWTException, IOException {
	  
	  testName = "Product price comparison link";
	  expected = "‏גיטרה קלאסית Cort AC100 - זאפ";
	  
	  try {
		  pof.AC100PriceCompareLink.click();
		  Thread.sleep(2000);
		  
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
  
  @Test (priority = 3)
  public void productMoreDetails() throws AWTException, IOException {
	  
	  testName = "Product more details link";
	  expected = "‏מפרט טכני";
	  
	  try {
		  pof.AC100MoreDetailsLink.click();
		  Thread.sleep(2000);
		  
		  isPageCorrect = func.checkPageTitle(expected);
		  
		  func.printToReport(isPageCorrect, testName, false);
		  		  
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageCorrect, testName, true);
			
		  e.printStackTrace();
			
		  Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 4, enabled = false)
  public void localStore() throws AWTException, IOException {
	  
	  testName = "Buy product at local Store page";
	  expected = "קניה בחנות מקומית";
	  
	  try {
		pof.localStore.click();
		Thread.sleep(2000);
		
		isPageCorrect = func.checkPageTitle(expected);
		
		func.printToReport(isPageCorrect, testName, false);
		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		 func.printToReport(isPageCorrect, testName, true);
			
		 e.printStackTrace();
			
		 Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 5, enabled = false)
  public void techSpec() throws AWTException, IOException {
	
	  testName = "Product full technical specification page";
	  expected = "מפרט טכני";
	  
	  try {
		pof.techSpec.click();
		Thread.sleep(2000);
		
		isPageCorrect = func.checkPageTitle(expected);
		
		func.printToReport(isPageCorrect, testName, false);
		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		 func.printToReport(isPageCorrect, testName, true);
			
		 e.printStackTrace();
			
		 Assert.assertEquals(false, true, "An exception occurred");
	}
}
  
  @Test (priority = 6, enabled = false)
  public void userReviews() throws AWTException, IOException {
	  
	  testName = "Product user reviews page";
	  expected = "חוות דעת";
	  
	  try {
		pof.userReviews.click();
		Thread.sleep(2000);
		
		isPageCorrect = func.checkPageTitle(expected);
		
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
