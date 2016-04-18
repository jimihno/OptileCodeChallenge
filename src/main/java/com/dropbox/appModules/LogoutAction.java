package com.dropbox.appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;

public class LogoutAction {

	public static void logout(WebDriver driver, WebDriverWait wait, HomePage home) {
		PageFactory.initElements(driver, HomePage.class);
		home.clickLogoutBtn(wait);
		driver.quit();
	}
}