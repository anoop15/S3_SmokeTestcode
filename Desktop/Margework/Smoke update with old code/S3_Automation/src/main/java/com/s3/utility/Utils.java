package com.s3.utility;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {
	public static WebDriver driver = null;
	public static String chromePath = Constant.CHROME_PATH;
	// Open a particular browser as per the given browser name in data sheet
	public static void OpenBrowser(String browsername, String url)
			throws Exception {
		try {
			//String geckoPath= Constant.GECKO_PATH;
//			System.clearProperty("webdriver.chrome.driver");
			switch (browsername.toLowerCase()) {
			case "firefox":
				//System.setProperty("webdriver.gecko.driver",geckoPath);
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				WebDriverWait wait=new WebDriverWait(driver, 20);
				break;
			case "chrome":
				File chromeFile = new File(chromePath);
				System.setProperty("webdriver.chrome.driver",
						chromeFile.getAbsolutePath());
				ChromeOptions chromeOptions = new ChromeOptions();
				//chromeOptions.addArguments("--kiosk");
				driver = new ChromeDriver(chromeOptions);
				//driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			default:
				//System.setProperty("webdriver.gecko.driver",geckoPath);
				driver = new FirefoxDriver();
				break;
			}
			Log.info("New driver instantiated");
		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "
					+ e.getMessage());
		}
		
		// maximize the browser window
				String OS = System.getProperty("os.name").toLowerCase();
			//	if(OS.contains("win"))
				driver.manage().window().maximize();
			/*	else if (OS.contains("mac")){
					java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Point position = new Point(0, 0);
					driver.manage().window().setPosition(position);
					Dimension maximizedScreenSize =
					new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
					driver.manage().window().setSize(maximizedScreenSize);
					driver.manage().window().maximize();
				}*/	
				// Implicit wait on the driver for 10 seconds
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 30 seconds");
				// pass the URL in browser
				driver.get(url);
				if(browsername.toLowerCase().equals("chrome") && OS.contains("mac")){
										// driver.manage().window().maximize();
			    driver.switchTo().window(driver.getWindowHandle());
				}
				Log.info("Web application launched successfully");
			}

		
		
			
		
	
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void getScreenShot(String file) {
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(file));
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}

	
	public static void waitForElementToBeclick(WebElement element){
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void webDriverWait() {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 30);
		wait.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}

	public static void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void browserClose() {
		driver.close();
	}

	public static void browserQuit() {
		driver.quit();
		//driver = null;
	}
	
	public static String getOS(){
		String OS = System.getProperty("os.name").toLowerCase();
		return OS;
	}

	final public static boolean waitForElToBeRemove(WebDriver driver,
			final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, 60);

			boolean present = wait
					.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(by));

			return present;
		} catch (Exception e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}

}
