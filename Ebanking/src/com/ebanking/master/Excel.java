package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// Instance Class
		
		Library LB=new Library();
		LB.OpenApp("http://103.211.39.246/ranford2/");
		LB.AdminLgn("Admin","Mindq@Sys");
		
		
		//To get The Test Data Excel File
		
		FileInputStream FIS=new FileInputStream("D:\\SeleniumMarchOnline\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
	
	     //WorkBook
		
		XSSFWorkbook WB=new XSSFWorkbook(FIS);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("Rdata");
		
		//Row Count
		
		int Rcount=WS.getLastRowNum();
		System.out.println("Row Count is " + Rcount);
		
		//Multiple Iterations -------- For Loop
		
		for (int i=1;i<=Rcount;i++)
		{
		
			//Row
			
			XSSFRow WR=WS.getRow(i);
			
			// Cell
			
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			
			//Cell Values
			
			String Rname=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();
			
			String Res=LB.Role(Rname,Rtyp);
			WC2.setCellValue(Res);
			
	}
		//Results
		
		FileOutputStream FOS=new FileOutputStream("D:\\SeleniumMarchOnline\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
		WB.write(FOS);
		WB.close();
	}
}
