package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{

	public static WebDriver driver;
	public static String ExpVal,ActVal;
	public static FileInputStream FIS;
	public static Properties PR;
	
	public String OpenApp(String URL) throws IOException
	{
		
		FIS=new FileInputStream("D:\\SeleniumMarchOnline\\Ebanking\\src\\com\\ebanking\\properties\\Repo.properties");
        PR=new Properties();
		PR.load(FIS);
		
		ExpVal="Ranford Bank";
		
		 driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get(URL);
		
		ActVal=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparision
		
		if (ExpVal.equalsIgnoreCase(ActVal)) 
		{
			System.out.println("Application Launch Succ");
		}
		else
		{
			System.out.println("Application Failed To Launch");
		}
		return "Pass";
	}
	
	public void AdminLgn(String Un,String Pwd) throws InterruptedException
	{
        ExpVal="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
	
		ActVal=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		
		if (ExpVal.equalsIgnoreCase(ActVal)) 
		{
		System.out.println("Admin Login Succ");	
		}
		else
		{
			System.out.println("Admin Login failed");
		}
		

	}
	
	public String BranchCre() throws InterruptedException
	{
	    ExpVal="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id("BtnNewBR")).click();
	
		driver.findElement(By.id("txtbName")).sendKeys("MqsysHyderabadxyz");
		driver.findElement(By.id("txtAdd1")).sendKeys("Ameerpet");
		driver.findElement(By.id("txtZip")).sendKeys("45458");
		
		//DropDown
		
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText("INDIA");
		
		new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText("Delhi");
		new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("Delhi");
		Thread.sleep(3000);
		driver.findElement(By.id("btn_insert")).click();
		
		//Alert
		Thread.sleep(3000);
		
		ActVal=driver.switchTo().alert().getText();
		
		//Comparision
		
		if (ActVal.contains(ExpVal)) 
		{
		System.out.println("Branch Created");	
		}
		else
		{
			System.out.println("Branch Name Already Exist");
		}
		
		driver.switchTo().alert().accept();
	//Home
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a")).click();
		return ActVal;
	}
	
	
	public String Role(String RN,String RT) throws InterruptedException
	{
		ExpVal="Sucessfully";
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		
		ActVal=driver.switchTo().alert().getText();
		
		System.out.println(ActVal);
		
		Thread.sleep(3000);
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (ActVal.contains(ExpVal)) 
	      {
	    	  System.out.println("Role Created");
	    	 
			
		}
	      else{
	    	  System.out.println("role not created");
	       }
	 return ActVal;     
	}

	
	//LogOut
	
	public void Alogout() throws InterruptedException 
	{
		Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
	}
	
	
	//Close

	public void Aclose() throws InterruptedException 
	{
		Thread.sleep(3000);
	driver.close();	
	}


	//Role Creation
	//Emp Creation
	//Log Out
	//Close App
	
}
