package finalProject_zapGuitars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import kotlin.collections.ArrayDeque;
import tools.setUp;
import tools.zapGuitars_POF;

public class attempt extends setUp{

//	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		
//		driver.get("https://www.zap.co.il/models.aspx?sog=g-guitar");
//		
		pof = PageFactory.initElements(driver, zapGuitars_POF.class);
//		
//		String expected = "מפרט טכני";
//		boolean isPageCorrect;
//		 try {
//			 // xpath for the link below: "//div[@class='MoreInfo']//a[contains(@aria-label, 'Cort AC100')]"
//			 pof.AC100MoreDetailsLink.click();
//			 Thread.sleep(2000);
//			  
//			 isPageCorrect = func.checkPageTitle(expected);
//			  
//			 System.out.println(isPageCorrect);
//			  
//		  } catch (Exception e) {
//				
//			  e.printStackTrace();
//				
//		  }
//		 
		
		driver.get("https://www.zap.co.il/models.aspx?sog=g-guitar");
		pof.multiSelectManufacturerButton.click();
		Thread.sleep(3000);
		
//		pof.alphabetButoon.click();
		pof.quantityButton.click();
		Thread.sleep(1000);
		
		List<Integer> list = new ArrayList<Integer>();
//		String string;
//		List<WebElement> webList = driver.findElements(By.xpath("//div[contains(@class, 'ProductBox')]//div[contains(@class,'ProdInfoTitle')]"));
		
		for (WebElement w : pof.multiChoiceItemsQuantityList) { 	// converting list from web elements to strings
	 		String s = w.getText().replace("(", "").replace(")", "");
	 		int a = Integer.parseInt(s);
			list.add(a);
	 	}
		
		
//		System.out.println(pof.multiChoiceItemsList.size());
//		
//		for (WebElement w : pof.multiChoiceItemsList) {
//			list.add(w.getText());
//		}
//
//		Collections.sort(list);
//		
//		for (String s : list) {
//			System.out.println(s);
//		}
		
		
		 driver.close();
		
	}

		public static boolean checkPageTitle(String expectedPageTitle) {
		
		String currentPageTitle = driver.getTitle();
		currentPageTitle.trim();
		
		boolean result = (currentPageTitle.contains(expectedPageTitle)) ? true : false;
		return result;
		
	}
}
