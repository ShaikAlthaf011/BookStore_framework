package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import Reusablecomponent.BussinessComponent;
import Reusablecomponent.DataProviders;

public class VerifyLoginFuncationalitywithInValidemail extends BussinessComponent {
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	 public void verifyLoginfunctionalitywithInValidemail(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login("s0@gmail.com",password.trim());
		Verify_error_message("These credentials do not match our records.");	
	}		
	}
