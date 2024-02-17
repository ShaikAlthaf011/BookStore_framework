package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import helper.BussinessComponent;
import helper.DataProviders;

public class VerifyLoginFuncationalityEmptyemailpassword extends BussinessComponent{
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	 public void verifyLoginfunctionalitywithemptyemailpassword(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login("","");
		Verify_error_message_password("The password field is required.");
		Verify_error_message_email("The email field is required.");
		
		
	}
}
