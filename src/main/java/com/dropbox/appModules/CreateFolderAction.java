package com.dropbox.appModules;

import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;

public class CreateFolderAction {

	public static void folderCreation(HomePage home, Properties properties, WebDriverWait wait) {
		home.createFolder(wait, properties.getProperty("folderName"));
	}
}
