package com.dropbox.appModules;

import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.pageObjects.HomePage;

public class UploadAction {

	public static void upload(WebDriverWait wait, HomePage home, Properties properties) {
		home.clickUploadBtn(wait);
		home.searchBy(properties.getProperty("uploadFilename"));
	}
}
