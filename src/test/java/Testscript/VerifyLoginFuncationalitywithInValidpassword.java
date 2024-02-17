package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import helper.BussinessComponent;
import helper.DataProviders;

public class VerifyLoginFuncationalitywithInValidpassword extends BussinessComponent {
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	 public void verifyLoginfunctionalitywithInValidpassword(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login(email.trim(),"123456");
		Verify_error_message("These credentials do not match our records.");	
	}		
	}