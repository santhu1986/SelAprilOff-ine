package com.ebanking.master;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Base 

   {
               Library LB=new Library();
               
	
	@BeforeTest
  public void beforeTest() throws InterruptedException 
  {
       LB.AdminLgn("Admin","Mindq@Sys");
  }

    @BeforeSuite
  public void beforeSuite() throws IOException 
  {
       LB.OpenApp("http://103.211.39.246/ranford2/");
  }

    @AfterSuite
  public void afterSuite() throws InterruptedException 
  {
    LB.Aclose();
  }

    @AfterTest
  public void afterTest() throws InterruptedException 
  {
    	 LB.Alogout();
  }

}
