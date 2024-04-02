package Reusablecomponent;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders  extends Excelutility{

	   @DataProvider(name="getData")
	    public String[][] getData() throws IOException {
		   Excelutility ex= new Excelutility();
	        return   ex.getData1();
	    }
}
