package framework.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;

public class CreateAccountTest extends BaseTest {
	
	@Test(dataProvider="getValues")
	public void failedlogin(HashMap<String,String> input) throws InterruptedException,IOException
	{		
		landingpage.create_Account(input.get("name"),input.get("lastname"),input.get("email"),input.get("pass"),input.get("cnfpass"));		
		String emailmsg=landingpage.errormsg();
		System.out.println(emailmsg);
		Assert.assertEquals(emailmsg, "Please enter a valid email address (Ex: johndoe@domain.com).");
	}
	
	@Test(dataProvider="getValues")
	public void login(HashMap<String,String> input) throws InterruptedException, IOException
	{
		landingpage.create_Account(input.get("name"),input.get("lastname"), landingpage.randomEmail(),input.get("pass"),input.get("cnfpass"));
		String message=landingpage.Successmsg();
		System.out.println(message);
		Assert.assertEquals(message,"Thank you for registering with Main Website Store.");
	}
	
	@DataProvider
	public Object[] [] getValues() throws IOException
	{
		List<HashMap<String,String>> data = getjsonData(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\Data\\createAccount.json");
		return new Object [] []  {{data.get(0)}};
	}
	
	

}
