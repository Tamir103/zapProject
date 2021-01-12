package finalProject_zapGuitars;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapElements;
import tools.zapGuitars_POF;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class multiChoiceWinTest extends setUp {
  
	@Test (priority = 1)
  public void test1() throws InterruptedException {
	  pof.AC100PriceCompareLink.click();
	  Thread.sleep(3000);
  }
  
  @Test (priority = 2)
  public void test2() throws InterruptedException {
	  elements.aboutLink.click();
	  Thread.sleep(3000);
  }
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.zap.co.il/models.aspx?sog=g-guitar");
	  driver.manage().window().maximize();
//	  pof = new zapGuitars_POF();
//	  elements = new zapElements();
	  
	  pof = PageFactory.initElements(driver, zapGuitars_POF.class);
	  elements = PageFactory.initElements(driver, zapElements.class);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
