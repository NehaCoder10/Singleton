
package singletonpattern.SingletonDesignPattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckInstance {
	
		MySingletonClass first=MySingletonClass.getInstanceMethod();
		
		WebDriver driver=first.getDriver();
		
		//driver.get("http://makeseleniumeasy.com/2018/01/11/singleton-design-pattern-in-selenium-webdriver/");
		
		public WebElement getElement(String xpath) {
			
			return driver.findElement(By.xpath(xpath));
		}
		
		public void closebrowser() {
			driver.close();
		}
		
		public void closeAllBrowsers() {
			driver.quit();
		}
		
		public void launchWebsite(String url) {
			driver.get(url);
		}
		public void moveBack() {
			driver.navigate().back();
		}
		
		public void moveForward() {
			driver.navigate().back();
		}
		public void refreshPage() {
			driver.navigate().refresh();
		}
		public void insertSleep(int time) throws InterruptedException {
			Thread.sleep(time);
		}
		public void insertImplicitWait(long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
	
		public String getTitle() {
			return driver.getTitle();
		}
		
		public String getText(String locator) {
			return driver.findElement(By.xpath(locator)).getText();
		}

		public String getAttribute(String locator, String value) {
			return driver.findElement(By.xpath(locator)).getAttribute(value);
		}
		
		public void validateText(String locator,String expected) {
			String actual=driver.findElement(By.xpath(locator)).getText();
			if(expected.equalsIgnoreCase(actual)) {
				System.out.println("Test passed! text matched");
				
			}
			else {
				System.out.println("Unmatched! test failed");
			}
		}
		
		public void takeScreenshot() {
			  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  try {
				FileUtils.copyFile(src, new File("C:\\Users\\neaba\\Documents\\Screenshots"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to take screenshot!");
			}
		}
		
		public String readPropFile(String prop) {
			Properties pp=new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("C:\\Users\\neaba\\eclipse-workspace\\ClassPractice\\SingletonDesignPattern\\data.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				pp.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return prop;
		}
		
		public Alert controlAlert() {
			Alert al=driver.switchTo().alert();
			return al;
		}
		public Actions performActions() {
			Actions ac=new Actions(driver);
			return ac;
	
		}
		
		public Set<String> windowHandler() {
			Set<String> handles=driver.getWindowHandles();
			return handles;
		}
		
		public void frames(String locator) {
			driver.switchTo().frame(driver.findElement(By.xpath(locator)));
		}
		
		
		
		
		
		
		
		
	
	
	
}
