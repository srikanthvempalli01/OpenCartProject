package com.OpenCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//input[@id='input-email']") 
	WebElement e_MailAddress;
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement passwd;
	@FindBy(xpath="//button[normalize-space()='Login']") 
	WebElement login;
	@FindBy(xpath="//a[normalize-space()='Account']") 
	WebElement account;
	
	public void enterEmail(String email)
	{
		e_MailAddress.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		passwd.sendKeys(password);
	}
	public void clickLogin()
	{
		login.click();
	}
	public void clickAccount()
	{
		account.click();
	}
}
