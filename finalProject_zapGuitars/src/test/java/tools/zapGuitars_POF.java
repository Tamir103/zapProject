package tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class zapGuitars_POF {
	

// Cort AC100 info	
	@FindBy (linkText = "������ ������ Cort AC100")
	public static WebElement AC100HeadlineLink;
	
	@FindBy (xpath = "//div[@data-modelid='945294']")
	public static WebElement AC100PriceCompareLink;
	
	@FindBy /*(xpath = "//div[@id='box_945294']//a[contains(@aria-label,'����� ������')]")*/
	(linkText = "����� ������ >")
	public static WebElement AC100MoreDetailsLink;

	
	
// Ibanez filter link	
	@FindBy (linkText = "� Ibanez")
	public static WebElement ibanezFilterButton;
	
// closing filters - the number in the div needs to be changed depending on amount of filters used from right to left
	@FindBy (xpath = "//div[@class='FilterButtons']/div[1]/a[@aria-label='������ ������']")
	public static WebElement closeFilter_1;
	
// acoustic guitar filter link
	@FindBy (linkText = "����� �������")
	public static WebElement acousticFilterButton;
	
// closing filters - the number in the div needs to be changed depending on amount of filters used from right to left
	@FindBy (xpath = "//div[@class='FilterButtons']/div[2]/a[@aria-label='������ ������']")
	public static WebElement closeFilter_2;

// under 2,000 price filter
	@FindBy (xpath = "//div[contains(@aria-label, '�� 2,000')]")
	public static WebElement under2000Filter;

	/*
	multiple selection window
	*/
// multiple selection by manufacturer	
	@FindBy (xpath = "//div[@class='MultiSelectionBtn']/span[contains(@aria-label, '����')]")
	public static WebElement multiSelectManufacturerButton;
	
// checkbox for Ibanez in multiple selection window
	@FindBy (xpath = "//input[contains(@aria-label, 'Ibanez') and @type='checkbox']")
	public static WebElement ibanezCheckbox;
	
// checkbox for Fender in multiple selection window
	@FindBy (xpath = "//input[@aria-label='Fender ���� ']")
	public static WebElement fenderCheckbox;
	
// checbox for Takamine in multiple selection window
	@FindBy (xpath = "//input[@aria-label='Takamine ���� ']")
	public static WebElement takamineCheckbox;
	
// show filter results button
	@FindBy (id = "uc_Filter_footerMultiFilterBtn")
	public static WebElement filterButton;
	
// sort by alphabetical order button
	@FindBy (linkText = "�-�")
	public static WebElement alphabetButoon;

// sort by quantity button
	@FindBy (linkText = "���� ������")
	public static WebElement quantityButton;
	
// multiple selection window search box
	@FindBy (id = "filterClientSearch")
	public static WebElement multiSearchbox;
	

}
