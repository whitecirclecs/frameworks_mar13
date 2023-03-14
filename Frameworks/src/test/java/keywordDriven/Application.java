package keywordDriven;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.ReadExcel;

public class Application {

	@Test
	public void verifyErrMsgsOnDifferentApplications() throws IOException {
		String[][] data = ReadExcel.getData("resources//TestData.xlsx", "Sheet2");

		for (int i = 1; i < data.length; i++) {
			switch (data[i][3]) {
			case "openBrowser": // when i=1,9,17
				Methods.openBrowser();
				break;

			case "maximizeIt": // when i=2,10,18
				Methods.maximizeIt();
				break;

			case "navigateToApplication": // when i=3,11,19
				Methods.navigateTo(data[i][6]);
				break;

			case "enterInvalidUsername": // when i=4,12,20
				Methods.enterInvalidUsername(data[i][5], data[i][6]);
				break;

			case "enterInvalidPassword": // when i=5,13,21
				Methods.enterInvalidPassword(data[i][5], data[i][6]);
				break;

			case "clickLoginButton": // when i=6,14,22
				Methods.clickLoginBtn(data[i][4], data[i][5]);
				break;

			case "verifyMessage": // when i=7,15,23
				Methods.verifyErrorMsg(data[i][4], data[i][5], data[i][6]);
				break;

			case "closeBrowser": // when i=8,16,24
				Methods.closeBrowser();
				break;

			}
		}
	}

}
