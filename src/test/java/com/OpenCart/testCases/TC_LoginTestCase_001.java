package com.OpenCart.testCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.OpenCart.pageObjects.LoginPage;
import com.OpenCart.utilities.XLUtils;
public class TC_LoginTestCase_001 extends BaseClass
{
	@Test(dataProvider="dp")
	public void loginTest(String email,String password) throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL is opened");  
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		logger.info("entered email");
		Thread.sleep(5000);
		lp.enterPassword(password);
		logger.info("entered password");
		Thread.sleep(5000);
		lp.clickLogin();
		Thread.sleep(5000);
		boolean res=driver.getPageSource().contains("My Affiliate Account");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("login successfully");
			JavascriptExecutor js=(JavascriptExecutor) driver;
			WebElement logout=driver.findElement(By.xpath("//div[@class='list-group mb-3']//a[13]"));
			js.executeScript("arguments[0].click()",logout);
			logger.info("logged out successfully");
		}
		else
		{
		  Assert.assertTrue(false);
		  logger.info("login failed");
		}	
		Thread.sleep(5000);
		lp.clickAccount();
	
	}
	@DataProvider(name="dp")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/OpenCart/testData/LoginDDT.xlsx";
		int rowcount=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][]=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
				
			}
		}
		return loginData;
		
	}
}
