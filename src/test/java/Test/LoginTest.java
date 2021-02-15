package Test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Data.DataFile;
import Pages.LoginPage;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile ();

	@BeforeMethod
	public void beforeMethod() throws IOException {
		lp.OpenBrowser();
		lp.OpenYahoo();
	}

	@AfterMethod
	public void afterMethod() {
		lp.CloseBrowser();
	}

	@Test(priority = 1)
	public void loginwithWronPasswordTest() throws InterruptedException {
		lp.enterEmail(df.correctEmail);
		System.out.println(df.correctEmail);
		lp.enterPassword(df.wrongPassword);
		System.out.println(df.wrongPassword);
		String expectederror = (df.PasswordError);
		String actualerror = lp.readPassworderr();
		Assert.assertEquals(expectederror, actualerror);
	}

	@Test(priority = 2)
	public void loginwithWronEmailTest() throws InterruptedException {
		lp.enterEmail(df.wrongEmail);
		System.out.println(df.wrongPassword);
		String expectederror = (df.EmailError);
		String actualerror = lp.readPassworderr();
		Assert.assertEquals(expectederror, actualerror);
	}
}