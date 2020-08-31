package singletonpattern.SingletonDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySingletonClass {
	
	
	private static MySingletonClass classinstance=null; //declare static reference variable of class
	private WebDriver driver = null; //checking
	
	private MySingletonClass() { //create private cronstructor so that no one can instantiate it outside of class

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\neaba\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver = new ChromeDriver();
		
	}
	
	
	
	//declare a static method with return type object of class which checks if class is already instantiated once. 
	
	public static MySingletonClass getInstanceMethod() {
		if(classinstance==null) {
			classinstance=new MySingletonClass();
			
		}
		return classinstance;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	

}
