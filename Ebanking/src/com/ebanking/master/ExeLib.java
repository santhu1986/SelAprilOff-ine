package com.ebanking.master;

import java.io.IOException;

public class ExeLib {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
	      Library LB=new Library();
	      
	     String Rval=LB.OpenApp("http://103.211.39.246/ranford2/");
	     System.out.println(Rval);
	     LB.AdminLgn("Admin","Mindq@Sys");
	     Rval= LB.BranchCre();
	     System.out.println(Rval);
	}

}
