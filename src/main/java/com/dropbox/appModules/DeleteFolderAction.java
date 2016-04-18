package com.dropbox.appModules;

import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;

public class DeleteFolderAction {

	public static void folderDeletion(HomePage home, WebDriverWait wait, Properties properties, Actions action) {
		home.deleteFolder(wait, properties.getProperty("folderName"), action);
	}
}
