package com.bravenet.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bravenet.pages.LoginPage;

import utils.ReadExcel;

public class VerifyErrMsgTest extends BaseTest{
	
	@Test
	public void verifyErrMsg() throws IOException, InterruptedException {
		//	4) Enter an invalid username
		LoginPage loginPage = new LoginPage(driver);
		
		
		//Read the data from Excel Sheet
		String[][] data = ReadExcel.getData("resources//TestData.xlsx", "Sheet1");
		
		
		for (int i=1; i<6; i++) {
			String username = data[i][1];
			String password = data[i][2];
			
			loginPage.enterUsername(username);
			
			//	5) Enter an invalid password
			loginPage.enterPassword(password);
			
			//	6) Click on Login button
			loginPage.clickLoginBtn();
			
			//	7) Verify the error message - 'You must login with your username' is displayed
			String expectedErrMsg = "You must login with your username";
			String actualErrMsg = loginPage.getErrMsg();
			
			Assert.assertEquals(actualErrMsg, expectedErrMsg);	
			//Thread.sleep(2000);
		}
		
	}

}
