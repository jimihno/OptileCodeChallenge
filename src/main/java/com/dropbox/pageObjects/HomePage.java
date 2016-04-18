package com.dropbox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.utilities.Utils;

public class HomePage {

	@FindBy(id = "sign-in")
	public WebElement linkLogin;

	@FindBy(css = "Button[class*='header-nav-link button-as-link bubble-dropdown-target bubble-dropdown-target'")
	public WebElement linkAccount;

	@FindBy(xpath = "//a[@href='/logout']")
	public WebElement linkLogout;

	@FindBy(xpath = "//img[@class='sprite sprite_web s_web_upload_16']")
	public WebElement linkUploadFile;

	@FindBy(xpath = "//input[@id='choose-button']")
	public WebElement chooseUploadFile;

	@FindBy(xpath = "//input[@id='done-button']")
	public WebElement doneBtn;

	@FindBy(xpath = "//img[@class='sprite sprite_web s_web_folder_add']")
	public WebElement createFolder;

	@FindBy(xpath = "//a[@href='/home/TestingFolder']")
	public WebElement folderToBeDeleted;

	@FindBy(xpath = "//button[@id='delete_button']")
	public WebElement deleteItem;

	@FindBy(xpath = "//button[@class='button-primary dbmodal-button']")
	public WebElement confirmDeletion;

	@FindBy(xpath = "//img[@class='sprite sprite_web s_web_trash-can']")
	public WebElement showDeletedFiles;

	@FindBy(xpath = "//img[@class='sprite sprite_web s_web_trash-can-open']")
	public WebElement hideDeletedFiles;

	@FindBy(className = "pyxl16386")
	public WebElement txtbxSearch;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickLoginBtn() {
		linkLogin.click();
	}

	public void clickLogoutBtn(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(linkAccount));
		linkAccount.click();
		wait.until(ExpectedConditions.visibilityOf(linkLogout));
		linkLogout.click();
	}

	public void clickUploadBtn(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(linkUploadFile));
		linkUploadFile.click();
		wait.until(ExpectedConditions.visibilityOf(chooseUploadFile));
		chooseUploadFile.click();
	}

	public void searchBy(String fileName) {
		Utils.copyPasteFileName(fileName);
		doneBtn.click();
	}

	public void createFolder(WebDriverWait wait, String fileName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(createFolder));
		createFolder.click();
		Utils.copyPasteFileName(fileName);
	}

	public void deleteFolder(WebDriverWait wait, String FileName, Actions action) {
		wait.until(ExpectedConditions.visibilityOf(folderToBeDeleted));
		action.contextClick(folderToBeDeleted).build().perform();
		deleteItem.click();
		confirmDeletion.click();
	}

	public void showDeleted(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(showDeletedFiles));
		showDeletedFiles.click();
	}

	public void hideDeleted(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(hideDeletedFiles));
		hideDeletedFiles.click();
	}
}
