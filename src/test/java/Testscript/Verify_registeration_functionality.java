package Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import helper.BussinessComponent;
import helper.Excelutility;

public class Verify_registeration_functionality  extends BussinessComponent{

	@Test
	public void verify_Resgistration() throws Exception {
		navigateto_application();
		click_onthe_wishlist();
		Verifysignup_text();
        click_on_sign_up_button();
        verify_registrationfields();
		perfrom_registertion();
		Hover_mouser_and_click_on_logoutButton();
		verify_99bookstorehomepage();
	}
}
