package com.project.dataproviders;



import org.testng.annotations.DataProvider;


import com.project.readexcel.ReadExcel;

public class LoginDataProviders {

	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"\\resources\\Data.xls","Sheet1"); 
	}
}
