package com.dropbox.appModules;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;
import com.dropbox.pageObjects.LoginPage;
import com.dropbox.utilities.Utils;

public class LoginAction {

	public static void loginPrerequisiteSteps(WebDriver driver, Properties properties, HomePage home,
			LoginPage login) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		properties = Utils.readFile();
		driver.get(properties.getProperty("url"));
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}

	public static void login(WebDriver driver, WebDriverWait wait, Properties properties, HomePage home,
			LoginPage login) {
		home.clickLoginBtn();
		wait.until(ExpectedConditions.visibilityOf(login.txtbxUsername));
		login.setUsername(properties.getProperty("username"));
		login.setPassword(properties.getProperty("password"));
		login.clickLoginBtn();
	}
}
