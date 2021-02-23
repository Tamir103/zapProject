/*
 * This class tests footer links from main page
 * */

package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapMainPageID;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class footerTest extends setUp {

	static boolean isPageTitleTrue;
	static String expectedTitle;
	static boolean isIframe;
	static String iframeId;
	static String iframeDiv_displayValue;
	static boolean clickLink;
	

  @Test (groups = "about", priority = 1, enabled = true)
  public void aboutLinkTest() throws InterruptedException, AWTException, IOException {
	
	  testName = "About link";
	  expectedTitle = "אודות zap השוואת מחירים";

	 try { 
		 isPageTitleTrue = func.linkTest(mainPageID.aboutLink, driver, expectedTitle); 	// Method that returns a boolean, checks if page title is as expected 	 
		 func.printToReport(isPageTitleTrue, testName, false);							// Method that prints to Extent Report (exception=false)
		 func.returnToMainPage();														// Method that navigates back to main page
		 Assert.assertEquals(isPageTitleTrue, true, "Title incorrect");
		 
	 } catch (Exception e) { 
		func.printToReport(isPageTitleTrue, testName, true);						// Printing failed test as result of an exception (=true)
		e.printStackTrace();
		Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  
  @Test (groups = "about", priority = 2, enabled = true)
  public void termsLink() throws InterruptedException, AWTException, IOException {
	
	  testName = "Terms link";
	  expectedTitle = "תנאי שימוש - זאפ השוואת מחירים";
	 
	  try {
		  isPageTitleTrue = func.linkTest(mainPageID.termsLink, driver, expectedTitle);			 
		  func.printToReport(isPageTitleTrue, testName, false);			 
		  func.returnToMainPage();			 
		  Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageTitleTrue, testName, true);
		  e.printStackTrace();
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
  }
  
  @Test (groups = "about", priority = 3, enabled = true)
  public void personalAreaLink() throws InterruptedException, AWTException, IOException {
	  
	  testName = "Personal area link";
	  expectedTitle = "זאפ השואת מחירים - זאפ שלי";
	
	 try { 
		 isPageTitleTrue = func.linkTest(mainPageID.personalLink, driver, expectedTitle);	  
		 func.printToReport(isPageTitleTrue, testName, false);	  
		 func.returnToMainPage();	  
		 Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		 
	 } catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
  }

 @Test (groups = "about", priority = 4, enabled = true)
 public void contactLink() throws InterruptedException, AWTException, IOException {
	 
	 testName = "Contact link";
	 expectedTitle = "שירות לקוחות זאפ השוואת מחירים";
	
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.contactLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
	 
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 5, enabled = true)
 public void QnALink() throws InterruptedException, AWTException, IOException {
	 
	 testName = "Q&A link";
	 expectedTitle = "שאלות כלליות - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.qNaLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 6, enabled = true)
 public void shopGuideLink() throws InterruptedException, AWTException, IOException {
	 
	 testName = "Shop guide link";
	 expectedTitle = "מדריך החנויות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.shopGuideLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }

 
 @Test (groups = "useful info", priority = 7)
 public void priceDropLink() throws AWTException, IOException {
	 
	 testName = "Price drop link";
	 expectedTitle = "נפילת מחירים - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.priceDropLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "useful info", priority = 8)
 public void allCategoriesLink() throws AWTException, IOException {
	 
	 testName = "All cateogories link";
	 expectedTitle = "זאפ השוואת מחירים - כל הקטגוריות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.allCategoriesLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "useful info", priority = 9)
 public void reviewsLink() throws AWTException, IOException {
	 
	 testName = "User reviews link";
	 expectedTitle = "חוות דעת אחרונות על מוצרים - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.ReviewsLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 10, enabled = true)
 public void logInLink() throws AWTException, IOException {
	
/* This link opens an iframe block*/
	 
	 iframeId = "iframe_SSO_Login";
	 testName = "Log In link"; 
	 clickLink = true;
	 
	try { 
		iframeDiv_displayValue = mainPageID.logInDiv_iframe.getAttribute("style");		
		isIframe = func.visibleIframeTest(clickLink, mainPageID.logInLink, mainPageID.logInDiv_iframe, iframeId);		
		func.printToReport(isIframe, testName, false);		
		func.closeIframe(mainPageID.closeLoginIframe);		
		func.returnToMainPage();		
		Assert.assertEquals(isIframe, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isIframe, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "useful info", priority = 11)
 public void shopingILLink() throws AWTException, IOException {
	 
	 testName = "Shoping IL 2020 link";
	 expectedTitle = "2020 Shopping IL - כל המבצעים החמים של שופינג IL בזאפ"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.shopingILLink, driver, expectedTitle);	 	 
		func.printToReport(isPageTitleTrue, testName, false);	 
		func.returnToMainPage();	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 12)
 public void addYourShopLink() throws AWTException, IOException {
	 
	 testName = "Add your shop link";
	 expectedTitle = "הוספת חנות לזאפ - הופעה בזאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.addYourShopLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 13)
 public void adLink() throws AWTException, IOException {
	 
	 testName = "Advertise in the site link";
	 expectedTitle = "פרסום בזאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.adLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 14)
 public void shopsAndImportsLink() throws AWTException, IOException {
	 
	 testName = "Shops and Imports interface link";
	 expectedTitle = "ממשק חנויות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.shopsAndImportsLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
	 
		// close tabs part due to new tabs being opened from this link	
		try {
			func.closeTab();
			func.returnToMainPage();
			
		} catch (Exception e) {
			func.printToReport(isPageTitleTrue, testName, true);
		}
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 15)
 public void adInterfaceLink() throws AWTException, IOException {
	 
	 testName = "Advertising interface Link";
	 expectedTitle = "ממשק מפרסמים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.adInterfaceLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
	 
		// close tabs part due to new tabs being opened from this link	
		try {
			func.closeTab();
			func.returnToMainPage();
			
		} catch (Exception e) {
			func.printToReport(isPageTitleTrue, testName, true);
		}
		
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 

 @Test (groups = "content world", priority = 16)
 public void tourismLink() throws AWTException, IOException {
	 
	 testName = "Tourism Link";
	 expectedTitle = "טיסות – zap תיירות השוואת מחירי טיסות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.tourismLink, driver, expectedTitle);	 
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "content world", priority = 17)
 public void supermarketLink() throws AWTException, IOException {
	 
	 testName = "Supermarket Link";
	 expectedTitle = "זאפ מרקט - הזאפ של הסופרים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.supermarketLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 18)
 public void dailyDealsLink() throws AWTException, IOException {
	 
	 testName = "Daily deals Link";
	 expectedTitle = "זאפ פלוס – דילים והנחות במחירים המשתלמים ביותר!"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.dailyDealsLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 19)
 public void tavoLink() throws AWTException, IOException {
	 
	 testName = "Tavo Link";
	 expectedTitle = "TAVO | - zap group"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.tavoLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 20)
 public void wisebuyLink() throws AWTException, IOException {
	 
	 testName = "WiseBuy Link";
	 expectedTitle = "מדריכי קנייה, סקירות מוצרים, השוואת מחירים - WiseBuy"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.wiseBuyLink, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false);
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 21)
 public void zap360Link() throws AWTException, IOException {
	 
	 testName = "Zap 360 Link";
	 expectedTitle = "זאפ גרופ - שיווק דיגיטלי לעסקים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(mainPageID.zap360Link, driver, expectedTitle);
		func.printToReport(isPageTitleTrue, testName, false); 
		func.returnToMainPage();
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
		 e.printStackTrace();
		 Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.zap.co.il/");
	  driver.manage().window().maximize();
	  
	//sampling all the web elements from mainPageID class, if web page is refreshed all samples needs to be sampled again		
	  mainPageID = PageFactory.initElements(driver, zapMainPageID.class);

	  extent = exm.getExtentReports();
	  test = exm.createTest("Footer Links Test", "Footer Links Test");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
