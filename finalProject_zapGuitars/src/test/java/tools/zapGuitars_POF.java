package tools;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import finalProject_zapGuitars.multiChoiceWindow;

public class zapGuitars_POF {
	

// Cort AC100 info	
	@FindBy (xpath = "//div[@class='ProdInfoTitle']/a[contains(@aria-label, 'Cort AC100')]")
	public static WebElement AC100HeadlineLink;
	
	@FindBy (xpath = "//div[@data-modelid='945294']")
	public static WebElement AC100PriceCompareLink;
	
	@FindBy (xpath = "//div[@class='MoreInfo']//a[contains(@aria-label, 'Cort AC100')]")
	public static WebElement AC100MoreDetailsLink;
	
	@FindBy (linkText = "קנייה בחנות מקומית") 
	public static WebElement localStore;
	
	@FindBy (linkText = "מפרט טכני מלא")
	public static WebElement techSpec;
	
	@FindBy (linkText = "חוות דעת")
	public static WebElement userReviews;

/*
 * Filters
 */	

// Number of results
	@FindBy (xpath = "//div[@class='NumOfItems']//span[@class='number']")
	public static WebElement numOfResults;
	
// Yamaha filter link	
	@FindBy (xpath = "//div[@class='Selection']/a[contains(@aria-label, 'Yamaha')]")
	public static WebElement yamahaFilterButton;
	
// 	Filter banners
	@FindBy (xpath = "//div[@class='FilterButtons']")
	public static WebElement filterButtonsBanner;
	
// Filter Title	
	@FindBy (xpath = "//div[@class='FilterTitleTxt']")
	public static WebElement filterTitle;
	
// closing filters - the number in the div needs to be changed depending on amount of filters used from right to left
	@FindBy (xpath = "//div[@class='FilterButtons']/div[1]/a[@aria-label='לסגירת הסינון']")
	public static WebElement closeFilter_1;
	
// acoustic guitar filter link
	@FindBy (xpath = "//a[contains(@aria-label, 'לסינון לפי סוג גיטרה קלאסית')]")
	public static WebElement classicFilterButton;
	
// closing filters - the number in the div needs to be changed depending on amount of filters used from right to left
	@FindBy (xpath = "//div[@class='FilterButtons']/div[3]/a[@aria-label='לסגירת הסינון']")
	public static WebElement closeFilter_3;

// under 2,000 price filter
	@FindBy (xpath = "//div[contains(@aria-label, 'עד 2,000')]")
	public static WebElement under2000Filter;
	
// number of results
	@FindBy (xpath = "//div[contains(@class, 'ProductBox')]//div[contains(@class,'ProdInfoTitle')]")
	public static List<WebElement> numOfResultsList;
	
// Forward button (check attribute, if disabled)
	@FindBy (xpath = "//a[@aria-label='עבור לדף הבא']/div")
	public static WebElement forwardButton;
	
// prices string if prices are not a range
	@FindBy (xpath = "//div[@class='pricesRow']//span")
	public static List<WebElement> singlePrice;

	/*
	multiple selection window
	*/
// multiple selection by manufacturer	
	@FindBy (xpath = "//div[@class='MultiSelectionBtn']/span[contains(@aria-label, 'יצרן')]")
	public static WebElement multiSelectManufacturerButton;
	
// is multiple choice by manufacturer window open? check style for this element for visible or hidden
	@FindBy (xpath = "//div[@id='moreFiltersPopupOverlay']")
	public static WebElement multiChoiceWindow;
	
// list of items in multiple choice window
	@FindBy (xpath = "//div[@class='Selection']/div")
	public static List<WebElement> multiChoiceItemsList;
	
// list of items quantity as appears in multiple choice window
	@FindBy (xpath = "//div[@class='txtCnt']")
	public static List<WebElement> multiChoiceItemsQuantityList;
	
// one choice button (not multiple choice)
	@FindBy (xpath = "//a[@aria-label='לבחירת מאפיין']/div[@class='txt']")
	public static WebElement oneChoiceButtton;
	
// multiple choice or single choice?
	@FindBy (xpath = "//input[@type='checkbox']")
	public static WebElement checkboxDisplay;
	
// yamaha single option choice in multiple choice window	
	@FindBy (xpath = "//a[@aria-label='בחר יצרן Yamaha ']/div[@class='txtLtr']")
	public static WebElement yamahaSingleChoice;
	
// checkbox for Ibanez in multiple selection window
	@FindBy (xpath = "//input[contains(@aria-label, 'Ibanez') and @type='checkbox']")
	public static WebElement ibanezCheckbox;
	
// checkbox for Fender in multiple selection window
	@FindBy (xpath = "//input[@aria-label='Fender יצרן ']")
	public static WebElement fenderCheckbox;
	
// checbox for Takamine in multiple selection window
	@FindBy (xpath = "//input[@aria-label='Takamine יצרן ']")
	public static WebElement takamineCheckbox;
	
// show filter results button
	@FindBy (id = "uc_Filter_footerMultiFilterBtn")
	public static WebElement filterButton;
	
// sort by alphabetical order button
	@FindBy (linkText = "א-ב")
	public static WebElement alphabetButton;

// sort by quantity button
	@FindBy (linkText = "כמות מוצרים")
	public static WebElement quantityButton;
	
// multiple selection window search box
	@FindBy (id = "filterClientSearch")
	public static WebElement multiSearchbox;
	

}
