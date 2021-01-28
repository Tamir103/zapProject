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
	
	@FindBy (xpath = "//input[@aria-label='לחץ לחיפוש באתר']")
	public static WebElement mainSearchButton;

	
	/*
	 Main Menus
	  */
	@FindBy (linkText = "כל הקטגוריות")
	public static WebElement allCategories;
	
	@FindBy (xpath = "//li[@data-title='פנאי וספורט']")
	public static WebElement categoriesSubmenuSportNLeisure;
	
	@FindBy (linkText = "גיטרות")
	public static WebElement submenuGuitars;
	
	@FindBy (linkText = "פנאי וספורט")
	public static WebElement mainSportNLeisure;
	
	@FindBy (xpath = "//ul[@class='all-cat']/li[4]") //list may change
	public static WebElement musicMenu;
	
	
	/*
	 Side Menus
	 */
	@FindBy (xpath = "//a[@aria-label='פנאי וספורט']")
	public static WebElement sideSportNLeisure;
	
	@FindBy (xpath = "//a[@aria-label='מוצרים נוספים בתחום פנאי וספורט']")
	public static WebElement moreSportNLeisure;
	
	/*
	 Footer links
	 */
//about link
	@FindBy (linkText = "אודות zap השוואת מחירים")
	public static WebElement aboutLink;
	
//terms of use link
	@FindBy (linkText = "תנאי שימוש")
	public static WebElement termsLink;
	
//personal info link
	@FindBy (linkText = "האיזור האישי")
	public static WebElement personalLink;

//contact link
	@FindBy (linkText = "צור קשר")
	public static WebElement contactLink;
	
//Q & A link
	@FindBy (linkText = "שאלות ותשובות")
	public static WebElement qNaLink;
	
//shop guide link	
	@FindBy (linkText = "מדריך חנויות")
	public static WebElement shopGuideLink;
	
//price drop link	
	@FindBy (linkText = "נפילת מחירים")
	public static WebElement priceDropLink;
	
//all categories link	
	@FindBy (linkText = "כל הקטגוריות")
	public static WebElement allCategoriesLink;
	
//guitar reviews link - if clicking from guitars page
	@FindBy (linkText = "חוות דעת מוצרים")
	public static WebElement ReviewsLink;
	
//log in link	
	@FindBy (linkText = "הרשמה לאתר")
	public static WebElement logInLink;
// log in iframe visible 
	@FindBy (id = "SSO_LoginIframe")
	public static WebElement logInDiv_iframe;
// log in iframe close
	@FindBy (id = "close")
	public static WebElement closeLoginIframe;
	
//Shopping IL 2020 link	
	@FindBy (linkText = "שופינג איי אל 2020")
	public static WebElement shopingILLink;
	
//add your shop link	
	@FindBy (linkText = "צרף חנותך ל zap")
	public static WebElement addYourShopLink;
	
//Advertise link	
	@FindBy (linkText = "פרסם באתר")
	public static WebElement adLink;
	
//shops / imports interface link	
	@FindBy (partialLinkText = "ממשק חנויות / יבואנים")
	public static WebElement shopsAndImportsLink;
	
//advertisement interface link	
	@FindBy (linkText = "ממשק מפרסמים")
	public static WebElement adInterfaceLink; 
	
//tourism link 	
	@FindBy (linkText = "תיירות")
	public static WebElement tourismLink;
	
//supermarkets link	
	@FindBy (linkText = "סופרמרקטים")
	public static WebElement supermarketLink;
	
//daily deals link	
	@FindBy (linkText = "דילים יומיים")
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
