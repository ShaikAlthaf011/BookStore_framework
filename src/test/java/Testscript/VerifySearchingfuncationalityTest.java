package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import Reusablecomponent.BussinessComponent;
import Reusablecomponent.DataProviders;

public class VerifySearchingfuncationalityTest extends BussinessComponent{
	
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	public void VerifySearchingfuncationality(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login(email.trim(),password.trim());
		Click_on_Searchbutton();
		VerifySearch_error_message();
		perfrom_searchOperation();
		Verify_search_result();
		Verify_content_Text();
		Hover_mouser_and_click_on_logoutButton();
		verify_99bookstorehomepage();
	}

}
