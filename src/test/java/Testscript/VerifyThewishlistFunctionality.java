package Testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import helper.BussinessComponent;
import helper.DataProviders;

public class VerifyThewishlistFunctionality extends BussinessComponent {
	@Test(dataProvider="getData",dataProviderClass=DataProviders.class)
	public void Verify_wishlist_Functionality(String name,String email ,String password) throws IOException {
		navigateto_application();
		click_onthe_wishlist();
		click_onthe_loginbutton();
		perfrom_login(email.trim(),password.trim());
		Click_on_Searchbutton();
		VerifySearch_error_message();
		perfrom_searchOperation();
		Verify_search_result();
		Verify_content_Text();
		Card_mouse_Hover();
		Add_to_cart_Whislist();
		click_onthe_wishlist();
		Verify_text_content();
		click_removeButton();
		verify_removeButton_shouldnotdisplay();
		Hover_mouser_and_click_on_logoutButton();
		verify_99bookstorehomepage();
		}
}
