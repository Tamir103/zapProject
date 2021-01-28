package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapMainPageID;
import tools.zapGuitars_POF;
import tools.zapMainPageID;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class navigateToGuitars extends setUp {
	
	static final String guitarPageTitle = "גיטרות - זאפ";
	static boolean isPageCorrect;
	static String searchString;
	
  @Test (groups = "search_box", priority = 1, enabled = true)
  public void searchBox_guitar() throws AWTException, IOException {
	  
	  testName = "Guitar search test";
	  searchString = "גיטרה";
	  
	  try {
		isPageCorrect = func.searchBox(mainPageID.mainHeaderSearchBox, mainPageID.mainSearchButton, searchString, guitarPageTitle);
		
		func.printToReport(isPageCorrect, testName, false);
		
		func.returnToMainPage();;
		
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		Assert.assertEquals(false, true, "An exception occurred");
		
	}
  }
  
  @Test (groups = "search box", priority = 2, enabled = true)
  public void searchBox_guitars() throws AWTException, IOException {
	  
	  testName = "Guitars search test";
	  searchString = "גיטרות";
	  
	  try {
		isPageCorrect = func.searchBox(mainPageID.mainHeaderSearchBox, mainPageID.mainSearchButton, searchString, guitarPageTitle);
		
		func.printToReport(isPageCorrect, testName, false);
		
		func.returnToMainPage();;
		
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		
		Assert.assertEquals(false, true, "An exception occurred");	
	}
	  
  }
  
  @Test (groups = "menus", priority = 3)
  public void allCategories() throws AWTException, IOException {
	  
	  testName = "All categories submenus";
	  
	  try {
		  action.moveToElement(mainPageID.allCategories).perform();
		  Thread.sleep(1000);
		  action.moveToElement(mainPageID.categoriesSubmenuSportNLeisure).perform();
		  Thread.sleep(1000);
		  action.moveToElement(mainPageID.submenuGuitars).click().build().perform();
		  Thread.sleep(2000);
		  
		  isPageCorrect = func.checkPageTitle(guitarPageTitle);
		  
		  func.printToReport(isPageCorrect, testName, false);
		  
		  func.returnToMainPage();
		  
		  Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		
		Assert.assertEquals(false, true, "An exception occurred");
		
	}
  }
  
  @Test (groups = "menus", priority = 3)
  public void mainSportAndLeisure() throws AWTException, IOException {
	  
	  testName = "Sports and leisure submenu";
	  
	  try {
		action.moveToElement(mainPageID.mainSportNLeisure).perform();
		Thread.sleep(1000);
		action.moveToElement(mainPageID.musicMenu).perform();
		Thread.sleep(1000);
		action.moveToElement(mainPageID.submenuGuitars).click().build().perform();
		Thread.sleep(2000);
		  
		isPageCorrect = func.checkPageTitle(guitarPageTitle);
		  
		func.printToReport(isPageCorrect, testName, false);
		  
		func.returnToMainPage();
		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		
		Assert.assertEquals(false, true, "An exception occurred");
	}
  }
  
  @Test (priority = 4)
  public void sideSportAndLeisure() throws AWTException, IOException {
	  
	  testName = "Side menu sport and leisure link";
	  
	  try {
		mainPageID.sideSportNLeisure.click();
		Thread.sleep(2000);
		
		mainPageID.submenuGuitars.click();
		Thread.sleep(2000);
		
		isPageCorrect = func.checkPageTitle(guitarPageTitle);
		  
		func.printToReport(isPageCorrect, testName, false);
		  
		func.returnToMainPage();
		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  
		  
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		
		Assert.assertEquals(false, true, "An exception occurred");
	}
	  
  }
  
  @Test (priority = 5)
  public void sideMenuMorebutton() throws AWTException, IOException {
	  
 testName = "Side menu sport and leisure more button link";
	  
	  try {
		mainPageID.moreSportNLeisure.click();
		Thread.sleep(2000);
		
		mainPageID.submenuGuitars.click();
		Thread.sleep(2000);
		
		isPageCorrect = func.checkPageTitle(guitarPageTitle);
		  
		func.printToReport(isPageCorrect, testName, false);
		  
		func.returnToMainPage();
		  
		Assert.assertEquals(isPageCorrect, true, "Wrong page");
		  		  
	} catch (Exception e) {
		func.printToReport(isPageCorrect, testName, true);
		
		e.printStackTrace();
		
		Assert.assertEquals(false, true, "An exception occurred");
	}  
  }
  
  @Test (priority = 6)
  public void allCategoriesPage() throws AWTException, IOException {
	  
	  try {
		  mainPageID.allCategories.click();
		  Thread.sleep(2000);
		  
		  mainPageID.submenuGuitars.click();
		  Thread.sleep(2000);
		  
		  isPageCorrect = func.checkPageTitle(guitarPageTitle);
		  
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
	  driver.get("https://www.zap.co.il/");
	  driver.manage().window().maximize();
	  
	  action = new Actions(driver);
	  
	//sampling all the elements from zapMainPageID class, if web page is refreshed all samples needs to be sampled again		
	  mainPageID = PageFactory.initElements(driver, zapMainPageID.class);
	  pof = PageFactory.initElements(driver, zapGuitars_POF.class);
	
	  extent = exm.getExtentReports();
	  test = exm.createTest("Navigating to guitars page test", "Navigating to guitars page test");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
