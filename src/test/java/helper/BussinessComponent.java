package helper;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Orpage.LoginPage;
import Orpage.Registrationpage;
import config.ExtentFactory;



public class BussinessComponent extends TechnicalComponents {
	
 public Registrationpage rp;
 public LoginPage lp;
 
	public void navigateto_application() throws IOException {
		TechnicalComponents.navigateUrl(getProperties("url"));
		rp= new Registrationpage(driver);
		rp.verify_user_navigatedtheHomepage();
	}
	public void click_onthe_wishlist() {
		rp= new Registrationpage(driver);
		rp.click_on_wishlist(rp.watchlist);
	}
	public void Verifysignup_text() {
		rp=new Registrationpage(driver);
	String actualtext=rp.get_sign_up_text(rp.Verify_sighup);
	Assert.assertEquals(actualtext, "SignUp");
	ExtentFactory.getInstance().getExtent().log(Status.PASS,"signup text is verified");
	}
	public void click_on_sign_up_button() {
		rp=new Registrationpage(driver);
		rp.click_on_sign_up(rp.Verify_sighup);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"signup clicked");
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	}
	 public void verify_registrationfields() {
		 rp=new Registrationpage(driver);
		TechnicalComponents.waitloadpage(rp.your_name_inputfield);
		TechnicalComponents.waitloadpage(rp.email_inputfield);
		TechnicalComponents.waitloadpage(rp.mobile_inputfield);
		TechnicalComponents.waitloadpage(rp.confirmpassword_inputfield);
		TechnicalComponents.waitloadpage(rp.confirmpassword_inputfield);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"registeration page is verfied");
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	 }
	 
	 private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final Random RANDOM = new Random();

	    public static String generateRandomString(int length) {
	        StringBuilder stringBuilder = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            stringBuilder.append(randomChar);
	        }
	        return stringBuilder.toString();
	    }

	 
	public void perfrom_registertion() throws EncryptedDocumentException, InvalidFormatException {
		String randomtext= generateRandomString(5);
		String yourname=randomtext;
		String email=yourname+"@gmail.com";
		 Random random = new Random();
		  StringBuffer s= new StringBuffer();
		  for( int i=0;i<=10;i++) {
	        int randomInt2 = random.nextInt(0,10);
	       s=s.append(String.valueOf(randomInt2));
		  }
		TechnicalComponents.Type(rp.your_name_inputfield,yourname);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,yourname+" is entered in your name field");
		TechnicalComponents.Type(rp.email_inputfield,email);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,email+" is entered in entered field");
		TechnicalComponents.Type(rp.mobile_inputfield, s.toString());
		ExtentFactory.getInstance().getExtent().log(Status.PASS,s+" is entered in your name field");
		TechnicalComponents.Type(rp.Password_inputfield, s.toString());
		ExtentFactory.getInstance().getExtent().log(Status.PASS,s+" is entered in your name field");
		TechnicalComponents.Type(rp.confirmpassword_inputfield,s.toString());
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
		TechnicalComponents.Click(rp.Register_button);
		new Excelutility().write_dataToExcel(yourname,email,s.toString());
		
	}
	public void Hover_mouser_and_click_on_logoutButton() {
	rp=new Registrationpage(driver);
	rp.MouseHover(rp.username);
	TechnicalComponents.Click(rp.Logout_button);
	ExtentFactory.getInstance().getExtent().log(Status.PASS,"clicked on the Logout button");
	
	}
	 public void verify_99bookstorehomepage() {
		 rp=new Registrationpage(driver);
		 rp.verify_user_navigatedtheHomepage();
		 ExtentFactory.getInstance().getExtent().log(Status.PASS,"logout happend successfully");
	 }
	 public void click_onthe_loginbutton() {
		 lp= new LoginPage(driver);
		 lp.click_onthe_loginButton(lp.login_button);
		 ExtentFactory.getInstance().getExtent().log(Status.PASS,"clicked on the login button");
	 }
	  public void perfrom_login(String email, String password) {
		  lp= new LoginPage(driver);
		 lp. perform_login(lp.Email_id, email,lp.Password,password,lp.Login_button);
		 
		 
	  }
	  public void Verify_error_message_email( String text) {
		  lp=new LoginPage(driver);
		String actualtext=lp.get_error_message(lp.Get_error_message_email);
		Assert.assertEquals(actualtext,text);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"Verified error message"+actualtext);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	  }
	  public void Verify_error_message_password( String text) {
		  lp=new LoginPage(driver);
		String actualtext=lp.get_error_message(lp.get_error_message_password);
		Assert.assertEquals(actualtext,text);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"Verified error message"+actualtext);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	  
	  }
	  public void Verify_error_message( String text) {
		  lp=new LoginPage(driver);
		String actualtext=lp.get_error_message(lp.get_error_message);
		Assert.assertEquals(actualtext,text);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"Verified error message"+actualtext);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
				.build());
	  }
	  public void Click_on_Searchbutton() {
		  lp=new LoginPage(driver);
		  lp.Click_onSearchbutton(lp.Search_icon);
		  ExtentFactory.getInstance().getExtent().log(Status.PASS,"performed empty search");
	  }
	  public void VerifySearch_error_message() {
		  lp=new LoginPage(driver);
		  String actualtext=lp.Keyword_error_message(lp.Get_search_keyword_text);
		  Assert.assertEquals(actualtext,"The search keyword field is required.");
		  ExtentFactory.getInstance().getExtent().log(Status.PASS,"Verified error message"+actualtext);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
	  }
	  public void perfrom_searchOperation() {
		  lp=new LoginPage(driver);
		  lp.Searching_Text(lp.Searching,"The Sweetest Oblivion (Paperback)");
		  ExtentFactory.getInstance().getExtent().log(Status.PASS,"Searched book");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
		  Click_on_Searchbutton();
	  }
	  public void Verify_search_result() {
		  lp=new LoginPage(driver);
	        String actialtext =lp.SearchResult(lp.Searching_Result).split(" ")[5];
	        Assert.assertEquals(actialtext,"Sweetest");
	        ExtentFactory.getInstance().getExtent().log(Status.PASS,"results are verified");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
	       }
	  public void Verify_content_Text() {
		  lp=new LoginPage(driver);
		  TechnicalComponents.waitloadpage(lp.Verifiy_text);
		  String actualtext=lp.Content_Text(lp.Verifiy_text);
		  Assert.assertEquals(actualtext,"The Sweetest Oblivion (Paperback)- Lori Danielle");
	  }
	  public void Card_mouse_Hover() {
		  lp=new LoginPage(driver);
		  lp.card_mouse_hover(lp.book_card);
	  }
	  public void Add_to_cart_Whislist() {
		  lp=new LoginPage(driver);
		  lp.click_on_Add_to_cart_whislist(lp.add_Whislist);
		  
	  }
	  public void Verify_text_content() {
		  lp=new LoginPage(driver);
	String actualtext=lp.get_text_content(lp.text_content);
	Assert.assertEquals(actualtext,"The Sweetest Oblivion (Paperback)- Lori Danielle");
	ExtentFactory.getInstance().getExtent().log(Status.PASS,"The Sweetest Oblivion (Paperback)- Lori Danielle is verified");
	ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
			.build());
	  }
	  public void click_removeButton() {
		  lp=new LoginPage(driver);
		  lp.click_on_delete_button(lp.delete_button);
		  ExtentFactory.getInstance().getExtent().log(Status.PASS,"added wishlist item is removed");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
	  }
	  public void  verify_removeButton_shouldnotdisplay() {
		  lp=new LoginPage(driver);
		  TechnicalComponents.element_not_display(lp.delete_button);
	  }
	  public void add_cart_Item() {
		  lp=new LoginPage(driver);
		  lp.click_on_the_add_cart_item(lp.Add_to_Cart_Item);
		  ExtentFactory.getInstance().getExtent().log(Status.PASS," added The Sweetest Oblivion (Paperback)- Lori Danielle is verified");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
	  }
	  public void Add_view_cart_item() {
		  lp=new LoginPage(driver);
		  lp.click_on_the_view_cart(lp.add_view_cart);
		    ExtentFactory.getInstance().getExtent().log(Status.PASS,"navigated to the view cart");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
	  }
	  public void Verify_cart_card_details() {
		  lp=new LoginPage(driver);
		  String actualtext=lp.view_cart_item_text(lp.cart_item_text);
		  Assert.assertEquals(actualtext,"The Sweetest Oblivion (Paperback)- Lori Danielle");
		  ExtentFactory.getInstance().getExtent().log(Status.PASS,"The Sweetest Oblivion (Paperback)- Lori Danielle item is verified");
			ExtentFactory.getInstance().getExtent().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromPath(TechnicalComponents.takescreenshot())
					.build());
		  
	  }
}
