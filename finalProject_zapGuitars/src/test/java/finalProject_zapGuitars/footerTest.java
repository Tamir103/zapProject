package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapElements;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class footerTest extends setUp {

	static boolean isPageTitleTrue;
	static String expectedTitle;
	static String testName;
	static boolean isIframe;
	static String iframeId;
	static String iframeDiv_displayValue;
	static boolean clickLink;

  @Test (groups = "about", priority = 1, enabled = true)
  public void aboutLinkTest() throws InterruptedException {
	
	  testName = "About link";
	  expectedTitle = "אודות zap השוואת מחירים";

	 try { 
		 isPageTitleTrue = func.linkTest(elements.aboutLink, driver, expectedTitle); // Method that returns a boolean, checks if page title is as expected 
	 
		 func.printToReport(isPageTitleTrue, testName, false);						// Method that prints to Extent Report (exception=false)
	 
		 func.returnToMainPage();												// Method that navigates back to main page
	 
		 Assert.assertEquals(isPageTitleTrue, true, "Title incorrect");
		 
	 } catch (Exception e) { 
		func.printToReport(isPageTitleTrue, testName, true);						// Printing failed test as result of an exception (=true)
		
		Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  
  @Test (groups = "about", priority = 2, enabled = true)
  public void termsLink() throws InterruptedException {
	
	  testName = "Terms link";
	  expectedTitle = "תנאי שימוש - זאפ השוואת מחירים";
	 
	  try {
		  isPageTitleTrue = func.linkTest(elements.termsLink, driver, expectedTitle);
			 
		  func.printToReport(isPageTitleTrue, testName, false);
			 
		  func.returnToMainPage();
			 
		  Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		  
	  } catch (Exception e) {
		  func.printToReport(isPageTitleTrue, testName, true);
		
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
  }
  
  @Test (groups = "about", priority = 3, enabled = true)
  public void personalAreaLink() throws InterruptedException {
	  
	  testName = "Personal area link";
	  expectedTitle = "זאפ השואת מחירים - זאפ שלי";
	
	 try { 
		 isPageTitleTrue = func.linkTest(elements.personalLink, driver, expectedTitle);
	  
		 func.printToReport(isPageTitleTrue, testName, false);
	  
		 func.returnToMainPage();
	  
		 Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		 
	 } catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
  }

 @Test (groups = "about", priority = 4, enabled = true)
 public void contactLink() throws InterruptedException {
	 
	 testName = "Contact link";
	 expectedTitle = "שירות לקוחות זאפ השוואת מחירים";
	
	try { 
		isPageTitleTrue = func.linkTest(elements.contactLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
	 
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 5, enabled = true)
 public void QnALink() throws InterruptedException {
	 
	 testName = "Q&A link";
	 expectedTitle = "שאלות כלליות - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.qNaLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 6, enabled = true)
 public void shopGuideLink() throws InterruptedException {
	 
	 testName = "Shop guide link";
	 expectedTitle = "מדריך החנויות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.shopGuideLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
	 
 }

 
 @Test (groups = "useful info", priority = 7)
 public void priceDropLink() {
	 
	 testName = "Price drop link";
	 expectedTitle = "נפילת מחירים - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.priceDropLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "useful info", priority = 8)
 public void allCategoriesLink() {
	 
	 testName = "All cateogories link";
	 expectedTitle = "זאפ השוואת מחירים - כל הקטגוריות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.allCategoriesLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "useful info", priority = 9)
 public void reviewsLink() {
	 
	 testName = "User reviews link";
	 expectedTitle = "חוות דעת אחרונות על מוצרים - זאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.ReviewsLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "useful info", priority = 10, enabled = true)
 public void logInLink() {
	
/* This link opens an iframe block*/
	 
	 iframeId = "iframe_SSO_Login";
	 testName = "Log In link"; 
	 clickLink = true;
	 
	try { 
		iframeDiv_displayValue = elements.logInDiv_iframe.getAttribute("style");
		
		isIframe = func.visibleIframeTest(clickLink, elements.logInLink, elements.logInDiv_iframe, iframeId);
		
		func.printToReport(isIframe, testName, false);
		
		func.closeIframe(elements.closeLoginIframe);
		
		func.returnToMainPage();
		
		Assert.assertEquals(isIframe, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isIframe, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
	
 }
 
 
 @Test (groups = "useful info", priority = 11)
 public void shopingILLink() {
	 
	 testName = "Shoping IL 2020 link";
	 expectedTitle = "2020 Shopping IL - כל המבצעים החמים של שופינג IL בזאפ"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.shopingILLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 12)
 public void addYourShopLink() {
	 
	 testName = "Add your shop link";
	 expectedTitle = "הוספת חנות לזאפ - הופעה בזאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.addYourShopLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 13)
 public void adLink() {
	 
	 testName = "Advertise in the site link";
	 expectedTitle = "פרסום בזאפ השוואת מחירים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.adLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 14)
 public void shopsAndImportsLink() {
	 
	 testName = "Shops and Imports interface link";
	 expectedTitle = "ממשק חנויות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.shopsAndImportsLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "advertising", priority = 15)
 public void adInterfaceLink() {
	 
	 testName = "Advertising interface Link";
	 expectedTitle = "ממשק מפרסמים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.adInterfaceLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 

 @Test (groups = "content world", priority = 16)
 public void tourismLink() {
	 
	 testName = "Tourism Link";
	 expectedTitle = "טיסות – zap תיירות השוואת מחירי טיסות"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.tourismLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 
 @Test (groups = "content world", priority = 17)
 public void supermarketLink() {
	 
	 testName = "Supermarket Link";
	 expectedTitle = "זאפ מרקט - הזאפ של הסופרים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.supermarketLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 18)
 public void dailyDealsLink() {
	 
	 testName = "Daily deals Link";
	 expectedTitle = "זאפ פלוס – דילים והנחות במחירים המשתלמים ביותר!"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.dailyDealsLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 19)
 public void tavoLink() {
	 
	 testName = "Tavo Link";
	 expectedTitle = "TAVO | - zap group"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.tavoLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 20)
 public void wisebuyLink() {
	 
	 testName = "WiseBuy Link";
	 expectedTitle = "מדריכי קנייה, סקירות מוצרים, השוואת מחירים - WiseBuy"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.wiseBuyLink, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
 
 @Test (groups = "content world", priority = 21)
 public void zap360Link() {
	 
	 testName = "Zap 360 Link";
	 expectedTitle = "זאפ גרופ - שיווק דיגיטלי לעסקים"; 
	 
	try { 
		isPageTitleTrue = func.linkTest(elements.zap360Link, driver, expectedTitle);
	 	 
		func.printToReport(isPageTitleTrue, testName, false);
	 
		func.returnToMainPage();
	 
		Assert.assertEquals(isPageTitleTrue, true, testName + " title incorrect");
		
	} catch (Exception e) {
		 func.printToReport(isPageTitleTrue, testName, true);
			
		  Assert.assertEquals(false, true , "An Exception occurred");
	}
 }
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.zap.co.il/");
	  driver.manage().window().maximize();
	  

	//sampling all the elements from elements class, if web page is refreshed all samples needs to be sampled again		
	  elements = PageFactory.initElements(driver, zapElements.class);
	
	  extent = exm.getExtentReports();
	  test = exm.createTest("Footer Links Test", "Footer Links Test");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
