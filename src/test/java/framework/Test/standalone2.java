package framework.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class standalone2 {

	@Test
	public  void singin() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//By.xpath("//li[@class='authorization-link'] /a")
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("s.deshmukh1214@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("s@8291949412");
		driver.findElement(By.cssSelector(".action.login.primary")).click();
		Thread.sleep(3000);
		String WelcomeMsg=driver.findElement(By.xpath("//div[@class='panel header'] //span[@class='logged-in']")).getText();
		Assert.assertTrue(WelcomeMsg.contains("Shivprasad"));
		driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
		driver.findElement(By.xpath("//div[@class=\"customer-menu\"] //li[@class=\"authorization-link\"]")).click();
		Thread.sleep(3000);
		String logoutmsg=driver.findElement(By.className("base")).getText();
		System.out.println(logoutmsg);
		Assert.assertTrue(logoutmsg.contains("signed out"));
	
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("s.deshmukh1214@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("s8291949412");
		driver.findElement(By.cssSelector(".action.login.primary")).click();
		Thread.sleep(3000);
		String errormsg=driver.findElement(By.cssSelector(".message-error.error.message	")).getText();
		Assert.assertTrue(errormsg.contains(" sign-in was incorrect "));
		System.out.println(errormsg);
		System.out.println("script run");
		driver.close();
	}

}
