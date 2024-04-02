package Reusablecomponent;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import config.DriverFactory;
import config.TestSetup;

public class TechnicalComponents extends TestSetup {
	   public static WebDriver localdriver;
	    public  static void  navigateUrl(String url){
		 try{
			 localdriver= DriverFactory.getInstance().getDriver();
			 localdriver.get(url);
			 localdriver.manage().window().maximize();
			 localdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 localdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			  String curl=driver.getCurrentUrl();
//			   Assert.assertEquals(curl, "https://www.99booksstore.com/");
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

   public static void Click(WebElement element) {
		element.click();
	}
	public static void Type(WebElement element,String Text) {
      element.sendKeys(Text);
	}
	public static void Alert(WebElement element) {
		org.openqa.selenium.Alert ac=driver.switchTo().alert();
		ac.accept();
	}
	public static String gettext(WebElement element){
		 String text = null;
		  try{
			text=  element.getText();
			
		  }catch(Exception e){
			   e.printStackTrace();
		  }
		  return text;
	}
   public static void waitloadpage(WebElement element) {
	   localdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait=new WebDriverWait(localdriver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
   public static void selected(WebElement element,String text) {
	   Select sc=new Select(element);
	   sc.selectByVisibleText(text);
   }
  public  static void Mouse_Hover(WebElement element) {
	   Actions ac=new Actions(localdriver);
	   ac.moveToElement(element).build().perform();
   }
   public static boolean Is_displayed(WebElement element) {
	   boolean b=element.isDisplayed();
	   return b;
	   
	   
   }
   
   public static void element_not_display(WebElement element) {
	   WebDriverWait wait=new WebDriverWait(localdriver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	   
	   
   }
   public static String takescreenshot() {
		String filepath="";
		try {
			ts=(TakesScreenshot) localdriver;
			File f=ts.getScreenshotAs(OutputType.FILE);
			Date d= new Date();
			String screenshotName=(d.getDate() < 10 ? "0" + d.getDate() : d.getDate()) + " " + 
		            (d.getMonth() + 1 < 10 ? "0" + (d.getMonth() + 1) : (d.getMonth() + 1)) + "_" + 
		            (1900 + d.getYear()) + "_" + 
		            (d.getHours() < 10 ? "0" + d.getHours() : d.getHours()) + "_" + 
		            (d.getSeconds() < 10 ? "0" + d.getSeconds() : d.getSeconds());
			filepath=System.getProperty("user.dir")+"/reports/screenshot/"+screenshotName+".jpg";
		    Files.copy(f,  new File(filepath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepath;
	}
	}
	

