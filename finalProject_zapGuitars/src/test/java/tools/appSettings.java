package tools;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class appSettings {

	public static WebDriver driver;
	public static zapGuitars_functions func = new zapGuitars_functions();
	public static repeatedTests repeatedTests = new repeatedTests();
	public static zapGuitars_POF pof = new zapGuitars_POF();
	public static zapMainPageID mainPageID = new zapMainPageID();
	public static Actions action;
	public static Robot robot;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentManager exm = new ExtentManager(driver);
	public static String extentTestName;
	
	public static String destinationURL;
	public static String testName;
	public static String expected;
}
