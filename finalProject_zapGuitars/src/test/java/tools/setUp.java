package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class setUp {

	public static WebDriver driver;
	public static zapGuitars_functions func = new zapGuitars_functions();
	public static Elements elements = new Elements();
	public static zapGuitars_POF pof = new zapGuitars_POF();
	public static zapMainPageID mainPageID = new zapMainPageID();
	public static Actions action;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentManager exm = new ExtentManager(driver);
	
	public static String testName;
}
