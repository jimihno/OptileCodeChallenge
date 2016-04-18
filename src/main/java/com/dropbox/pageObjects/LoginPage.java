package com.dropbox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(css = "Input[class*='text-input-input autofocus'")
	public WebElement txtbxUsername;

	@FindBy(css = "Input[class*='password-input text-input-input'")
	public WebElement txtbxPassword;

	@FindBy(css = "Button[class*='login-button button-primary'")
	public WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String username) {
		txtbxUsername.clear();
		txtbxUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtbxPassword.clear();
		txtbxPassword.sendKeys(password);
	}

	public void clickLoginBtn() {
		btnLogin.click();
	}
}