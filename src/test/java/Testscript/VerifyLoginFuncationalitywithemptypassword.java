package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import Reusablecomponent.BussinessComponent;
import Reusablecomponent.DataProviders;

public class VerifyLoginFuncationalitywithemptypassword extends BussinessComponent {
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	 public void verifyLoginfunctionalitywithInValidpassword(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login(email.trim(),"");
		Verify_error_message_password("The password field is required.");
		
		
		
		
	}
	
}
