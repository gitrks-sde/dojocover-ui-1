package dojocover.tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import dojocover.base.Base;
import dojocover.models.SignInUser;
import dojocover.pages.SignInPage;
import dojocover.utils.JsonDataReader;

public class DataDrivenSignInTest extends Base{
	
	//Data Provider reads the JSON File for data.
	@DataProvider(name = "SignInJsonData")
	public Object[][] getSignInUsers(){
		
		return JsonDataReader.getJsonData("testdata/signinusers.json");
	}
	
	
	@Test(dataProvider = "signInJsonData")
	
	public void signInJsonData(SignInUser users) {
		
		SignInPage signin = new SignInPage(getDriver());
		signin.clickOnSignIn();
		signin.fillSignInCredentials(users.getUsername(), users.getPassword());
		signin.submitSignIn();
		signin.verifyURL();
		signin.signOut();
		
		
		
		
	}

}
