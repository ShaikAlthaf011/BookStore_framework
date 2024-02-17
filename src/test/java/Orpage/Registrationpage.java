package Orpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import config.ExtentFactory;
import helper.TechnicalComponents;

public class Registrationpage extends TechnicalComponents{
	
	public Registrationpage(WebDriver driver){
		driver=this.driver;
		PageFactory.initElements(driver,this);
	}
	

@FindBy(xpath="//div[@class='tg-wishlistandcart']/div/a/span[contains(text(),'Wishlist')]")
public WebElement watchlist;

@FindBy(xpath="//input[@type='search']") 
public WebElement search_box;

@FindBy(xpath="//a[contains(text(),'SignUp')]")
public WebElement Verify_sighup;

@FindBy(xpath="//div[@class='register-email mb-10']/input[@name='name']")
public WebElement your_name_inputfield;
 
@FindBy(xpath="//div[@class='register-email mb-10']/input[@name='mobile']")
public WebElement mobile_inputfield;

@FindBy(xpath="//div[@class='register-email mb-10']/input[@name='email']")
public WebElement email_inputfield;

@FindBy(xpath="//div[@class='log-pass mb-10']/input[@name='password']")
public WebElement Password_inputfield;

@FindBy(xpath="//div[@class='log-pass mb-10']/input[@name='password_confirmation']")
public WebElement confirmpassword_inputfield;

@FindBy(xpath="//button[contains(text(),'Register')]")
public WebElement Register_button;

@FindBy(xpath="//*[@id='tg-navigation']/ul/li[9]/a")
public WebElement username;

@FindBy(xpath="//ul[@class='sub-menu']/li/a[contains(text(),'Log Out')]")
public WebElement Logout_button;

public void verify_user_navigatedtheHomepage() {
	ExtentFactory.getInstance().getExtent().log(Status.PASS," Verified user navigated to the homepage");
	TechnicalComponents.waitloadpage(watchlist);
	TechnicalComponents.waitloadpage(search_box);
	ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
			.build());
}

public void click_on_wishlist(WebElement element) {
	TechnicalComponents.Click(element);
	ExtentFactory.getInstance().getExtent().log(Status.PASS,"clicked on the wishlist button");
}
public String get_sign_up_text(WebElement element) {
String text=TechnicalComponents.gettext(element);
return text;
}
public void click_on_sign_up(WebElement element) {
	TechnicalComponents.Click(element);
}
public void Enter_value_inputfield(WebElement element,String text) {
	TechnicalComponents.Type(element, text);
}
public void MouseHover(WebElement element) {
	TechnicalComponents.Mouse_Hover(element);
}
}
