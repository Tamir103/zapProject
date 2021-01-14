package tools;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

public class zapGuitars_functions extends setUp {
	
	public static void convertFileEncoding(String sourcePath, Optional<String> targetPath, Optional<String> targetEncoding) throws IOException, InterruptedException{
	    
	    // Wait for file to exist - 10 seconds
	    for (int i=0; i<20 ; i++) {
	      if(!Files.exists(Paths.get(sourcePath)))
	        Thread.sleep(500);
	      else
	        break;
	    }
	          
	    File infile = new File(sourcePath);
	    
	    String trgtPath = targetPath.orElse(sourcePath + "Temp") ;
	    String trgtEncoding = targetEncoding.orElse("UTF-8");
	    File outfile = new File(trgtPath);
	    
	    // Convert    
	    InputStreamReader fis = new InputStreamReader(new FileInputStream(infile));
	    Reader in = new InputStreamReader(new FileInputStream(infile),fis.getEncoding());
	    Writer out = new OutputStreamWriter(new FileOutputStream(outfile), trgtEncoding);

	    int c;

	    while ((c = in.read()) != -1){
	      out.write(c);}

	    in.close();
	    out.close();
	    fis.close();

	    // if target path not specified - change the original file to target file
	    if (!targetPath.isPresent()) {
	      infile.delete();
	      outfile.renameTo(new File(sourcePath));
	    }
	    
	    
	  }

	public void printToReport(boolean testResult, String testName, boolean exception) throws AWTException, IOException {
		
		if (!exception) {
			if (testResult) {
				test.pass(testName + " passed");
			} else {
				test.fail(testName + " failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
		
		} else {
			test.fail(testName + " failed by exception, check code");
		}
}
	
	
	public void returnToMainPage() throws InterruptedException {
		
		String currentPageTitle = driver.getTitle();
		String mainPageTitle = "זאפ השוואת מחירים";
		
		if (!currentPageTitle.equalsIgnoreCase(mainPageTitle)) {
			driver.navigate().to("https://www.zap.co.il/");
			Thread.sleep(2000);
		}
		
	}

	public boolean linkTest(WebElement link, WebDriver driver, String expectedTitle, ArrayList<String> tabs) throws InterruptedException {
		
		String target = link.getAttribute("target");
		
		if (target.equalsIgnoreCase("_blank")) {
			link.click();
			Thread.sleep(2000);
			
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			String webPageTitle = driver.getTitle();
			webPageTitle.trim();
			
				if (webPageTitle.equalsIgnoreCase(expectedTitle)) {
					return true;
				} else {
					return false;
				}
			
		} else {
			link.click();
			Thread.sleep(2000);
			
			String webPageTitle = driver.getTitle();
			webPageTitle.trim();
			
				if (webPageTitle.equalsIgnoreCase(expectedTitle)) {
					return true;
				} else {
					return false;
				}
		}
	}
	
	public boolean visibleIframeTest(boolean clickLink, WebElement link, WebElement iframeDiv, String iframeId) throws InterruptedException {
		
		String displayValue = "";
		
		if (clickLink) {
			link.click();
			Thread.sleep(2000);	
		}	

		displayValue = iframeDiv.getAttribute("style");

		// "style = display: block;" in iframe div means that iframe is visible, "style = display: none;" means it's not visible. 	
		if (displayValue.contains("block")) {
			driver.switchTo().frame(driver.findElement(By.id(iframeId)));
			return true;
		} else {
			return false;
		}
			
	}

	public static void closeIframe(WebElement iframeCloseButton) throws InterruptedException {
		
		iframeCloseButton.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
	}
	
	
	public boolean searchBox(WebElement searchBox, WebElement searchButton, String searchString, String expectedTitle) throws InterruptedException {
		
		searchBox.click();
		Thread.sleep(500);

		action.moveToElement(searchBox).sendKeys(searchString).build().perform();
		
		Thread.sleep(1000);
		
		searchButton.click();
		Thread.sleep(2000);
		
		String pageTitle = driver.getTitle();
		pageTitle.trim();
		
		boolean result = (pageTitle.equals(expectedTitle)) ? true : false;
		return result;
		
	}
	
	public boolean guitarsPage(String guitarsPageTiltle) {
		
		String currentPageTitle = driver.getTitle();
		currentPageTitle.trim();
		
		boolean result = (currentPageTitle.equals(guitarsPageTiltle)) ? true : false;
		return result;
		
	}
	
	
	public static boolean isListInAlphabeticalOrder(List<String> listToCheck, int expectedCharsNum) {
		
		/*
		looping throw the list to check that it is in alphabetic order, 
		using ASC2 character numbers (97 = lower case a, 122 = lower case z).
		if counter equals the expected characters number, then the list is in alphabetical order.
		*/
			int counter = 1;
			int charASC2 = 97;
			for (int i = 0; i < listToCheck.size(); i++) {	
				char a = listToCheck.get(i).toLowerCase().charAt(0); //getting the lower case first character of each string in list 
				
				if (a != charASC2) {   			// if not equals to current ASC2 char,
					while(charASC2 <= 122) {	// runs a loop on all letters by alphabetical order, until it finds the next letter by order 
						if (a == charASC2) {	// when it find the letter by order, a counter adds 1, and loop breaks for next list item  
							counter++;
							break;
						} else {
							charASC2++;			// advancing to the next letter value
						}
					}
				}
			}
			
			boolean result = (counter == expectedCharsNum) ? true : false;
			return result;
			
				
	}
	
	public static boolean isListInNumericalOrder(List<Integer> numList, int expectedCount) {
		
		int firstInt, secondInt, counter = 0;	
			firstLoop:
				for (int i = 0; i < numList.size(); i++) {
					firstInt = numList.get(i);					// loop for getting a int value item from the list
					
						for (int j = i+1; j <= i+1; j++) {
							secondInt = numList.get(j);			// loop that runs one time, getting the next int value item from the list
				
							if (firstInt >= secondInt) {		
								counter++;
							} else {
								System.out.println("Not in the right order");
								break firstLoop;
							}
						}
				}
		
		boolean result = (counter == expectedCount) ? true : false;
		return result;
	}
}
