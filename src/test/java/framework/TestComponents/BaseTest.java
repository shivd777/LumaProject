package framework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import framework.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public WebDriver driver;
	public Landingpage landingpage;
	
	
	public WebDriver initializeDriver() throws IOException 
	{
		Properties prop =new Properties();
		FileInputStream ifs =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\shivprasad\\resource\\GlobalData.properties");
		prop.load(ifs);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{	
			ChromeOptions options =new ChromeOptions(); 
			WebDriverManager.chromedriver().setup();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); //full screen
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenShot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}
			
		public List<HashMap<String, String>> getjsonData(String filepath) throws IOException
		{
			//read json to string
			String jsonContent= FileUtils.readFileToString(new File(filepath),
					StandardCharsets.UTF_8);
					
			//String to HashMap 
			ObjectMapper Omapper= new ObjectMapper();
			List<HashMap<String, String>> data = Omapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
			return data;
		}
		
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage LaunchApp() throws IOException
	{
		 driver= initializeDriver();
		 landingpage=new Landingpage(driver);
		 landingpage.gotoURL();
		 return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void DriverClose() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
	

}
