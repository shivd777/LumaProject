package framework.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobject.AddItemPage;
import framework.pageobject.CartPage;
import framework.pageobject.CheckoutPage;
import framework.pageobject.OrderSummary;
import framework.pageobject.PlacedOrderPage;
import framework.pageobject.SignupPage;

public class PurchaseTest extends BaseTest{
	
	@Test(dataProvider="getValues")
	public void purchase(HashMap<String,String> input) throws InterruptedException
	{
	SignupPage signin=new SignupPage(driver);
	signin.SignUp_Account(input.get("email"), input.get("password"));	 		
	
	//Adding items
	AddItemPage additem = new AddItemPage(driver);
	additem.addWhatsNew();									
	additem.addWatch();
	additem.addPants();
	
	//view and update CartPage
	CartPage cartpage=new CartPage(driver);
	cartpage.cartItem();
	String initialprize=cartpage.cartValue();
	cartpage.proceedTocheckout();
	CheckoutPage checkout=new CheckoutPage(driver);
	if(checkout.savedAddress().isDisplayed())
	{
		checkout.Radiobut();
	}
	else
	{
		checkout.checkoutDetails( input.get("placeName"),  input.get("cityName"), input.get("RegionName"),  input.get("PinCode"), input.get("countryName"), input.get("mobileNum"));
	}
	checkout.nextBut();
	
	//SummaryPage
	OrderSummary order=new OrderSummary(driver);
	String finalprize=order.validate();
	Assert.assertEquals(finalprize, initialprize);
	order.ClickOnplacedOrder();
	
	//OrderPlaced Successfully
	PlacedOrderPage placeOrder =new PlacedOrderPage(driver);
	String Successmsg=placeOrder.orderplcaed();
	Assert.assertEquals(Successmsg,"Thank you for your purchase!");
	placeOrder.OrderNumber();
	
	}
	
	@DataProvider
	public Object[] [] getValues() throws IOException
	{
		List<HashMap<String,String>> data = getjsonData(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\Data\\purchaseData.json");
		return new Object [] []  {{data.get(0)}};
	}

}
