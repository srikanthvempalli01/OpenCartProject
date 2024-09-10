package com.OpenCart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./configuration\\config.properties");
		try
		{
			FileInputStream file=new FileInputStream(src);
			pro=new Properties();
			pro.load(file);
		}
		catch(Exception e)
		{
			System.out.println("exception is:"+e.getMessage());
		}
	}
	public String geturl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String geteml()
	{
		String eml=pro.getProperty("email");
		return eml;
	}
	public String getpass()
	{
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getChromepath()
	{
		String cpath=pro.getProperty("chromepath");
		return cpath;
	}
	public String getEdgepath()
	{
		String epath=pro.getProperty("edgepath");
		return epath;
	}
	public String getFirefoxpath()
	{
		String fpath=pro.getProperty("firefoxpath");
		return fpath;
	}
	
}
