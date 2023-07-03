package framework.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import framework.TestComponents.BaseTest;
import framework.pageobject.SignupPage;

public class SigninTest extends BaseTest {

	@Test(dataProvider="getValues")
	public  void singin(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		SignupPage signup=new SignupPage(driver);
		signup.SignUp_Account(input.get("email"), input.get("password"));
		String WelcomeMsg=signup.SuccessMsg();
		Assert.assertTrue(WelcomeMsg.contains("Shivprasad"));

		signup.Signout();
		String logoutmsg=signup.SignoutMsg();
		Assert.assertTrue(logoutmsg.contains("signed out"));
		signup.SignUp_Account(input.get("email"),input.get("wrongpassword"));

		String errormsg=signup.FailedMsg();
		Assert.assertTrue(errormsg.contains(" sign-in was incorrect "));

	}
	
	@DataProvider
	public Object[] [] getValues() throws IOException
	{
		List<HashMap<String,String>> data = getjsonData(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\Data\\signupData.json");
		return new Object [] []  {{data.get(0)}};
	}

}
