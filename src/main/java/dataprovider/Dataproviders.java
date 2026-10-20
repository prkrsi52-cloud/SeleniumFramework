package dataprovider;

import org.testng.annotations.DataProvider;

import helper.ExcelUtility;

public class Dataproviders {

	@DataProvider(name = "logincredentials")
	public static Object[][] getData() {

		Object[][] arr = ExcelUtility.getData("logincredentials");
		return arr;

	}

}
