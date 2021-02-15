package Data;

import Utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("D:\\Selenium_Workspace\\BasixFramework\\src\\Data\\YahooLoginData.xlsx");
	
	//Login (loginTest)
	public String correctEmail =d.getCellData("Sheet1", 0, 2);
	public String wrongEmail =  d.getCellData("Sheet1", 1, 2);
	public String wrongPassword = d.getCellData("Sheet1", 2, 2);
	public String PasswordError = d.getCellData("Sheet1", 3, 2);
	public String EmailError = d.getCellData("Sheet1", 4, 2);
	public String Browser =  d.getCellData("Sheet1", 5, 2);

}
