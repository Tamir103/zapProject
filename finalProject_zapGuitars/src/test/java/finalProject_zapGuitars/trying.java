package finalProject_zapGuitars;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.setUp;
import tools.zapElements;

public class trying extends setUp {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.zap.co.il/");
		driver.manage().window().maximize();
		
		elements = PageFactory.initElements(driver, zapElements.class);

		
		String iframeId = "iframe_SSO_Login";
		String testName = "Log In link"; 
		boolean clickLink = true;
		 
		try { 
//			elements.logInLink.click();
//			Thread.sleep(1000);
//			String iframeDiv_displayValue = driver.findElement(By.xpath("//div[@class='LoginIframe']")).getAttribute("style");
//			System.out.println(iframeDiv_displayValue);
			
			boolean isIframe = func.visibleIframeTest(clickLink, elements.logInLink, elements.logInDiv_iframe, iframeId);
			
//			func.printToReport(isIframe, testName, false);
			System.out.println(isIframe);
			func.closeIframe(elements.closeLoginIframe);
			
			func.returnToMainPage();
			
//elements.logInDiv_iframe			
//			Assert.assertEquals(isIframe, true, testName + " title incorrect");
			
		} catch (Exception e) {
//			 func.printToReport(isIframe, testName, true);
			
//			e.printStackTrace();
			
//			  Assert.assertEquals(false, true , "An Exception occurred");
		}
	}

}
