package Orpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import config.ExtentFactory;
import helper.TechnicalComponents;

public class LoginPage extends TechnicalComponents {
	
	public LoginPage(WebDriver driver){
		driver=this.driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id='tg-navigation']/ul/li[9]/a")
	public WebElement login_button;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement Email_id;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement Password;
	
	@FindBy(xpath="//button[contains(text(),'Log In')]")
	public WebElement Login_button;
	
	@FindBy(xpath="//span[@role='alert']/strong[contains(text(),'The email field is required.')]")
	public WebElement Get_error_message_email;
	
	@FindBy(xpath="//span[@role='alert']/strong[contains(text(),'The password field is required.')]")
	public WebElement get_error_message_password;
 
	@FindBy(xpath="//span[@role='alert']/strong[contains(text(),'These credentials do not match our records.')]")
	public WebElement get_error_message;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Search_icon;
	
	@FindBy(xpath="//span[@class='invalid-feedback']/strong")
	public WebElement Get_search_keyword_text;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement Searching;
	
	@FindBy(xpath="//h2")
	public WebElement Searching_Result;
	
	@FindBy(xpath="//*[@id='ajax-product']/div[1]/div/div/div/h3/a[contains(text(),'Lori')]")
	public WebElement Verifiy_text;
	
	@FindBy(xpath="//div[@class='tg-postbook']/figure/a/div[1]/div[1]/img[@title='The Sweetest Oblivion (Paperback)- Lori Danielle']")
	public WebElement book_card;
	
	@FindBy(xpath="(//a[@class='tg-btnaddtowishlist'])[1]")
	public WebElement add_Whislist;
	
	@FindBy(xpath="//div[@class='cart-detail']/a[@class='cart-prd-name']")
	public WebElement text_content;
	
	@FindBy(xpath="//div[@class='action']/a[@class='cart-remove']")
	public WebElement delete_button;
	
	@FindBy(xpath="//div[@class='d-flex']/a[contains(text(),'Add to cart')]")
	public WebElement Add_to_Cart_Item;
	
	@FindBy(xpath="//div[@class='tg-btns']/a[contains(text(),'View Cart')]")
	public WebElement add_view_cart;
	
	@FindBy(xpath="//div[@class='cart-detail']/a")
	public WebElement cart_item_text;
	
	@FindBy(xpath="//div[@class='cart-price']")
	public WebElement item_price;
	
	public void click_onthe_loginButton(WebElement element) {
		TechnicalComponents.Click(element);
	}
	public void perform_login(WebElement email,String text,WebElement password,String text1, WebElement element) {
		TechnicalComponents.Type(email, text);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,email +"entered  email field");
		TechnicalComponents.Type(password, text1);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,password +"entered  password field");
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
		TechnicalComponents.Click(element);
	}
	public String get_error_message(WebElement element) {
		String text1=TechnicalComponents.gettext(element);
		return text1;
	}
	public void Click_onSearchbutton(WebElement element) {
		TechnicalComponents.Click(element);
	}
	public String Keyword_error_message(WebElement element) {
		String text2=TechnicalComponents.gettext(element);
		return text2;
	}
	public void Searching_Text(WebElement element,String text) {
		TechnicalComponents.Type(element, text);
	}
	public String SearchResult(WebElement element) {
		String text3=TechnicalComponents.gettext(element);
		return text3;
	}
	public String Content_Text(WebElement element) {
		String text4=TechnicalComponents.gettext(element);
		return text4;
	}
	public void card_mouse_hover(WebElement element) {
		TechnicalComponents.Mouse_Hover(element);
	}
	public void click_on_Add_to_cart_whislist(WebElement element) {
		TechnicalComponents.Click(element);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"book is added to wishlist");
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	}
	public String get_text_content(WebElement element) {
	String text5=TechnicalComponents.gettext(element);
	return text5;
	}
	public void click_on_delete_button(WebElement element) {
		TechnicalComponents.Click(element);
	}
	public void click_on_the_add_cart_item(WebElement element) {
		TechnicalComponents.Click(element);
	}
	public void click_on_the_view_cart(WebElement element) {
		TechnicalComponents.Click(element);
	}
	public String view_cart_item_text(WebElement element) {
		String text6=TechnicalComponents.gettext(element);
		return text6;
	}
}
