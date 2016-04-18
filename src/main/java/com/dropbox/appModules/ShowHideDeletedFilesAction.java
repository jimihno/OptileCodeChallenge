package com.dropbox.appModules;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;

public class ShowHideDeletedFilesAction {

	public static void showDeletedFiles(HomePage home, WebDriverWait wait) {
		home.showDeleted(wait);
	}

	public static void hideDeletedFiles(HomePage home, WebDriverWait wait) {
		home.hideDeleted(wait);
	}
}
