package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	/*
	 * public WebElement Email = driver.findElement(By.id("login-username")); public
	 * WebElement EmailNext = driver.findElement(By.name("signin")); public
	 * WebElement WrongPassword = driver.findElement(By.className("password"));
	 * public WebElement PasswordNext = driver.findElement(By.id("login-signin"));
	 * public WebElement EmailError = driver.findElement(By.id("login-username"));
	 * public WebElement PasswordError =driver.findElement(By.className("error-msg"));
	 * WE CAN NOT USE IT LIKE THIS. WE HAVE TO USE PAGE FACTORY INSTEAD
	 */
	
	@FindBy(id = "login-username")
	public static WebElement Email;
	
	@FindBy(name = "signin")
	public static WebElement EmailNext;
	
	@FindBy(className = "password")
	public static WebElement WrongPassword;
	
	@FindBy(id = "login-signin")
	public static WebElement PasswordNext;
	
	@FindBy(id = "login-username")
	public static WebElement EmailError;
	
	@FindBy(className = "error-msg")
	public static WebElement PasswordError;
	
	
	public void OpenBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("D:\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String browser = prop.getProperty("browser"); // We'll read this data from data file // Chrome, Firefox, IE.
		
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this);
		
	}

	String Yahoo = "https://login.yahoo.com/?.src=ym&.partner=none&.lang=en-CA&.intl=ca&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dca%26.lang%3Den-CA%26.partner%3Dnone%26.src%3Dfp";

	public void OpenYahoo() {
		driver.get(Yahoo);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		  Email.sendKeys(a);
			EmailNext.click();
			Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException  {
		WrongPassword.sendKeys(b);
		PasswordNext.click();
		Thread.sleep(2000);
	}
	
	public String readPassworderr() {
		String actualerr = PasswordError.getText();
		System.out.println(actualerr);
		return actualerr;
	}
	
	public String readEmailerr() {
		String actualerr = EmailError.getText();
		System.out.println(actualerr);
		return actualerr;
	}
}
