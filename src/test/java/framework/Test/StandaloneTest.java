package framework.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest  {
	
	@Test
	public void failedlogin()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://magento.softwaretestingboard.com/");
		Landingpage landingpage=new Landingpage(driver);
		driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys("shiv");
		driver.findElement(By.id("lastname")).sendKeys("deshmukh");
		driver.findElement(By.id("email_address")).sendKeys("");
		//s.deshmukh1214@mail.com  s@8291949412
		driver.findElement(By.id("password")).sendKeys("s@8291949412");
		driver.findElement(By.id("password-confirmation")).sendKeys("s@8291949412");
		driver.findElement(By.cssSelector(".submit")).click();
		String emailmsg=driver.findElement(By.id("email_address-error")).getText();
		Assert.assertTrue(emailmsg.contains("required field"));
		System.out.println("Email field error:"+ emailmsg);
		driver.close();
	}
	
	@Test
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://magento.softwaretestingboard.com/");
		//Script 1
		driver.findElement(By.xpath("//a[text()='Create an Account']")).click();

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Shivprasad");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("deshmukh");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("email_address")).sendKeys("s1.deshmukh@gmail.com");
		//s.deshmukh1214@mail.com  s@8291949412
		driver.findElement(By.id("password")).sendKeys("s@8291949412");
		driver.findElement(By.id("password-confirmation")).sendKeys("s@8291949412");
		driver.findElement(By.cssSelector(".submit")).click();
		Thread.sleep(500);
		String message=driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
		System.out.println(message);
		Assert.assertTrue(message.contains("Thank you for registering"));
		System.out.println("Succesfull run");
		driver.close();
	}
	
	
	

}
