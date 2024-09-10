package com.OpenCart.testCases;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OpenCart.utilities.ReadConfig;

public class BaseClass
{
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.geturl();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("OpenCartProject");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("WebDriver.chrome.Driver",readconfig.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("WebDriver.msedge.Driver",readconfig.getEdgepath());
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("WebDriver.gecko.Driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
	}

	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"//screenshots//" +tname+ ".png");
		FileUtils.copyFile(sourcefile, targetfile);
		System.out.println("screenshot taken");
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
