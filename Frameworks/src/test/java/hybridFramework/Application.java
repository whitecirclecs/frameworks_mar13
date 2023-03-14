package hybridFramework;

import java.io.IOException;

import org.testng.annotations.Test;

import keywordDriven.Methods;
import utils.ReadExcel;

public class Application {

	@Test
	public void verifyErrMsgsOnDifferentApplications() throws IOException {
		String[][] data1 = ReadExcel.getData("resources//TestData.xlsx", "Sheet1");
		String[][] data2 = ReadExcel.getData("resources//TestData.xlsx", "Sheet2");

		for (int k = 1; k < data1.length; k++) {
			for (int i = 1; i < data2.length; i++) {
				switch (data2[i][3]) {
				case "openBrowser": // when i=1,9,17
					Methods.openBrowser();
					break;

				case "maximizeIt": // when i=2,10,18
					Methods.maximizeIt();
					break;

				case "navigateToApplication": // when i=3,11,19
					Methods.navigateTo(data2[i][6]);
					break;

				case "enterInvalidUsername": // when i=4,12,20
					Methods.enterInvalidUsername(data2[i][5], data1[k][1]);
					break;

				case "enterInvalidPassword": // when i=5,13,21
					Methods.enterInvalidPassword(data2[i][5], data1[k][2]);
					break;

				case "clickLoginButton": // when i=6,14,22
					Methods.clickLoginBtn(data2[i][4], data2[i][5]);
					break;

				case "verifyMessage": // when i=7,15,23
					Methods.verifyErrorMsg(data2[i][4], data2[i][5], data2[i][6]);
					break;

				case "closeBrowser": // when i=8,16,24
					Methods.closeBrowser();
					break;
				}
			}
		}
	}

}
