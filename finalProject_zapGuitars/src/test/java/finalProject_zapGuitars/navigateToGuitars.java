package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapElements;
import tools.zapGuitars_POF;

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
	static String testName;
	
  @Test (groups = "search_box", priority = 1, enabled = true)
  public void searchBox_guitar() throws AWTException, IOException {
	  
	  testName = "Guitar search test";
	  searchString = "גיטרה";
	  
	  try {
		isPageCorrect = func.searchBox(elements.mainHeaderSearchBox, elements.mainSearchButton, searchString, guitarPageTitle);
		
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
		isPageCorrect = func.searchBox(elements.mainHeaderSearchBox, elements.mainSearchButton, searchString, guitarPageTitle);
		
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
		  action.moveToElement(elements.allCategories).perform();
		  Thread.sleep(1000);
		  action.moveToElement(elements.categoriesSubmenuSportNLeisure).perform();
		  Thread.sleep(1000);
		  action.moveToElement(elements.submenuGuitars).click().build().perform();
		  Thread.sleep(2000);
		  
		  isPageCorrect = func.guitarsPage(guitarPageTitle);
		  
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
  public void sportAndLeisure() throws AWTException, IOException {
	  
	  testName = "Sports and leisure submenu";
	  
	  try {
		action.moveToElement(elements.mainSportNLeisure).perform();
		Thread.sleep(1000);
		action.moveToElement(elements.musicMenu).perform();
		Thread.sleep(1000);
		action.moveToElement(elements.submenuGuitars).click().build().perform();
		Thread.sleep(2000);
		  
		isPageCorrect = func.guitarsPage(guitarPageTitle);
		  
		func.printToReport(isPageCorrect, testName, false);
		  
		func.returnToMainPage();
		  
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
	  
	//sampling all the elements from elements class, if web page is refreshed all samples needs to be sampled again		
	  elements = PageFactory.initElements(driver, zapElements.class);
	  pof = PageFactory.initElements(driver, zapGuitars_POF.class);
	
	  extent = exm.getExtentReports();
	  test = exm.createTest("Navigating to guitars page Test", "Navigating to guitars page Test");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  extent.flush();
  }

}
