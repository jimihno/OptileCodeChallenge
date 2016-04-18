package com.dropbox;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dropbox.appModules.CreateFolderAction;
import com.dropbox.appModules.DeleteFolderAction;
import com.dropbox.appModules.LoginAction;
import com.dropbox.appModules.LogoutAction;
import com.dropbox.appModules.ShowHideDeletedFilesAction;
import com.dropbox.appModules.UploadAction;
import com.dropbox.pageObjects.HomePage;
import com.dropbox.pageObjects.LoginPage;
import com.dropbox.utilities.Utils;

public class CompleteTest {
	public static WebDriver driver = new FirefoxDriver();
	public static WebDriverWait wait = new WebDriverWait(driver, 10);
	public static LoginPage login = new LoginPage(driver);
	public static HomePage home = new HomePage(driver);
	public static Properties properties = Utils.readFile();
	public static Actions action = new Actions(driver);

	@BeforeClass
	public void beforeMethod() {
		LoginAction.loginPrerequisiteSteps(driver, properties, home, login);
		LoginAction.login(driver, wait, properties, home, login);
	}

	@Test(priority = 1)
	public void mainUpload() {
		UploadAction.upload(wait, home, properties);
	}

	@Test(priority = 2, dependsOnMethods = "mainUpload")
	public void mainFolderCreation() {
		CreateFolderAction.folderCreation(home, properties, wait);
	}

	@Test(priority = 3, dependsOnMethods = "mainFolderCreation")
	public void mainFolderDeletion() {
		DeleteFolderAction.folderDeletion(home, wait, properties, action);
	}

	@Test(priority = 4, dependsOnMethods = "mainFolderDeletion")
	public void mainShowHideDeleted() throws InterruptedException {
		ShowHideDeletedFilesAction.showDeletedFiles(home, wait);
		Thread.sleep(5000);
		ShowHideDeletedFilesAction.hideDeletedFiles(home, wait);
	}

	@AfterClass
	public void afterMethod() {
		LogoutAction.logout(driver, wait, home);
	}
}
