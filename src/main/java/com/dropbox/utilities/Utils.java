package com.dropbox.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	static String fileLocation = ".\\Dropbox.properties";

	public static Properties readFile() {
		// Creating the File Object
		File file = new File(fileLocation);
		// Creating properties object
		Properties prop = new Properties();

		try {
			// Creating InputStream object to read data
			FileInputStream objInput = new FileInputStream(file);
			// Reading properties key/values in file
			prop.load(objInput);
			// Closing the InputStream
			objInput.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return prop;
	}

	public static void copyPasteFileName(String fileName) {
		StringSelection ss = new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	}
}
