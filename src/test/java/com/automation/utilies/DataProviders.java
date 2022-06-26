package com.automation.utilies;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider
	public static Object[][] getUIDAndPWD(){
		Object data[][] = new Object[][]{
			{"Admin","admin123"},
			{"Admin","admin1234"}
		};
		
		return data;
	}
	

}
