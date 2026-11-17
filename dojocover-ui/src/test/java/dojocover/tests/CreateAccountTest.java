package dojocover.tests;

import org.testng.annotations.Test;
import dojocover.base.Base;
import dojocover.pages.CreateAccountPage;

public class CreateAccountTest extends Base{
	
	
	@Test(testName="creating new account for user")
	public void createNewAccount() {
		
		CreateAccountPage createPage=new CreateAccountPage(getDriver());
		createPage.clickOnCreateAccount();
		createPage.fillAccountDeatils("Rajinikanth","SUPERSTAR",998935333, "1950-12-12", "Thalivar");
		createPage.confirmAndSubmit();
		createPage.verifyAccountCreatedSuccessfully();
	}

}
