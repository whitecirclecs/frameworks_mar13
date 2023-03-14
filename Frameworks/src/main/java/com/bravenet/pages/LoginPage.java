package com.bravenet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "userid")
	private WebElement emailTxtBox;
	
	@FindBy(id = "password")
	private WebElement passwordTxtBox;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement loginBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'md-error')])[1]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		emailTxtBox.clear();
		emailTxtBox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtBox.clear();
		passwordTxtBox.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getErrMsg() {
		String message = errMsg.getText();
		return message;
	}
}
