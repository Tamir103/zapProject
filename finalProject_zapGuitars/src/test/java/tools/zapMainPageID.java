/*
 * The class is named elements because those elements id's are similar in all pages of the website
 * */

package tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class zapMainPageID {
	
	/*
	 Main search box
	  */
	@FindBy (id = "select2-keyword-container")
	public static WebElement mainHeaderSearchBox;
	
	@FindBy (xpath = "//input[@aria-label='��� ������ ����']")
	public static WebElement mainSearchButton;

	
	/*
	 Main Menus
	  */
	@FindBy (linkText = "�� ���������")
	public static WebElement allCategories;
	
	@FindBy (xpath = "//li[@data-title='���� ������']")
	public static WebElement categoriesSubmenuSportNLeisure;
	
	@FindBy (linkText = "������")
	public static WebElement submenuGuitars;
	
	@FindBy (linkText = "���� ������")
	public static WebElement mainSportNLeisure;
	
	@FindBy (xpath = "//ul[@class='all-cat']/li[4]") //list may change
	public static WebElement musicMenu;
	
	
	/*
	 Side Menus
	 */
	@FindBy (xpath = "//a[@aria-label='���� ������']")
	public static WebElement sideSportNLeisure;
	
	@FindBy (xpath = "//a[@aria-label='������ ������ ����� ���� ������']")
	public static WebElement moreSportNLeisure;
	
	/*
	 Footer links
	 */
//about link
	@FindBy (linkText = "����� zap ������ ������")
	public static WebElement aboutLink;
	
//terms of use link
	@FindBy (linkText = "���� �����")
	public static WebElement termsLink;
	
//personal info link
	@FindBy (linkText = "������ �����")
	public static WebElement personalLink;

//contact link
	@FindBy (linkText = "��� ���")
	public static WebElement contactLink;
	
//Q & A link
	@FindBy (linkText = "����� �������")
	public static WebElement qNaLink;
	
//shop guide link	
	@FindBy (linkText = "����� ������")
	public static WebElement shopGuideLink;
	
//price drop link	
	@FindBy (linkText = "����� ������")
	public static WebElement priceDropLink;
	
//all categories link	
	@FindBy (linkText = "�� ���������")
	public static WebElement allCategoriesLink;
	
//guitar reviews link - if clicking from guitars page
	@FindBy (linkText = "���� ��� ������")
	public static WebElement ReviewsLink;
	
//log in link	
	@FindBy (linkText = "����� ����")
	public static WebElement logInLink;
// log in iframe visible 
	@FindBy (id = "SSO_LoginIframe")
	public static WebElement logInDiv_iframe;
// log in iframe close
	@FindBy (id = "close")
	public static WebElement closeLoginIframe;
	
//Shopping IL 2020 link	
	@FindBy (linkText = "������ ��� �� 2020")
	public static WebElement shopingILLink;
	
//add your shop link	
	@FindBy (linkText = "��� ����� � zap")
	public static WebElement addYourShopLink;
	
//Advertise link	
	@FindBy (linkText = "���� ����")
	public static WebElement adLink;
	
//shops / imports interface link	
	@FindBy (partialLinkText = "���� ������ / �������")
	public static WebElement shopsAndImportsLink;
	
//advertisement interface link	
	@FindBy (linkText = "���� �������")
	public static WebElement adInterfaceLink; 
	
//tourism link 	
	@FindBy (linkText = "������")
	public static WebElement tourismLink;
	
//supermarkets link	
	@FindBy (linkText = "����������")
	public static WebElement supermarketLink;
	
//daily deals link	
	@FindBy (linkText = "����� ������")
	public static WebElement dailyDealsLink;
	
//Tavo link	
	@FindBy (linkText = "Tavo")
	public static WebElement tavoLink;
	
//wisebuy link	
	@FindBy (linkText = "WiseBuy")
	public static WebElement wiseBuyLink;
	
//zap 360 - business marketing
	@FindBy (partialLinkText = "zap360")
	public static WebElement zap360Link;
}
