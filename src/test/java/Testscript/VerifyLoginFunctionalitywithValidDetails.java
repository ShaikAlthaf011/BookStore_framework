package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import Reusablecomponent.BussinessComponent;
import Reusablecomponent.DataProviders;

public class VerifyLoginFunctionalitywithValidDetails  extends BussinessComponent{

	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	 public void verifyLoginfunctionalitywithValidDetails(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login(email.trim(),password.trim());
		Hover_mouser_and_click_on_logoutButton();
		verify_99bookstorehomepage();
		
		
	}
	
}
