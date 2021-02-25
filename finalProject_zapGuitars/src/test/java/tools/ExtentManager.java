package tools;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager extends appSettings {

	public static WebDriver driver;
	
	public ExtentManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public static ExtentReports extent;
	
	static ExtentTest test;
	
	public static ExtentSparkReporter sparkReporter;
	
	static DateFormat dFormat = new SimpleDateFormat("yyyy-dd-MM-HH-mm-ss");
	static Date today = Calendar.getInstance().getTime();
	static String reportDate = dFormat.format(today);
	public static String filePath = 
			"D:\\Automation\\Final project\\" + reportDate + "\\exReport.html"; 
	public static ExtentReports getExtentReports() {
		new File("D:\\Automation\\Final project\\" + reportDate).mkdirs();  
				
		if (extent != null) 
			return extent; //avoid creating new instance of html file
		
		
		extent = new ExtentReports();
		extent.attachReporter(getSparkReporter());
		return extent;	
	}
	
//optional, creating a new test function
	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest(name, description);
		return test;
	}
	
	
	private static ExtentSparkReporter getSparkReporter() {
		sparkReporter = new ExtentSparkReporter(filePath);
		sparkReporter.config().setDocumentTitle("QAV automation report");
		sparkReporter.config().setReportName("Regression cycle");
		sparkReporter.config().setEncoding("windows-1255"); //for writing in hebrew in the report
		
		return sparkReporter;
	}
	
	public static String CaptureScreen() throws AWTException, IOException {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("ddHHmmss"));
		String folderPath = ("D:\\Automation\\Final project\\" + reportDate);
		String imagePath = folderPath + "/pic" + time + ".png";
		
		robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(java.awt.Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(imagePath));
		
		return imagePath;
	}
	
}
