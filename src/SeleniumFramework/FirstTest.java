/**
 * 
 */
package SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author prithika annam
 *
 */
public class FirstTest {
	static WebDriver driver1;
	public static void main(String[] args) {
	
	InputData data = new InputData();
	System.out.println(data.browser);
			if (data.browser == "Chrome" && data.browser != null)		
		{	System.out.println("just before opening browser");
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//capabilities.setCapability("marionette", true);
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pannam\\Desktop\\Automation\\Libraries\\chromedriver.exe");
		 driver1  = new ChromeDriver();
		}
			else  if (data.browser == "IE" && data.browser != null){
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
					ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
							driver1 = new InternetExplorerDriver(ieCapabilities);
					}
				else  if (data.browser == "FF" && data.browser != null){
					System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
					 WebDriver driver = new FirefoxDriver();
				}
				else if (data.browser == "Opera" && data.browser != null){
					System.setProperty("webdriver.opera.driver", "C:\\Users\\pannam\\Desktop\\Automation\\Libraries\\operadriver.exe");
					WebDriver driver = new OperaDriver();	
				} 
			else{
			System.out.println("Please provide browser information");
		}
		 loginPage(data);
	
			//metaSwitchValidations();
	
	}

	public static void loginPage(InputData data) {
		
try{
		System.out.println("test");
		driver1.get(data.baseUrl);	
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		System.out.println("Successfully opened the website TPSI");
		driver1.findElement(By.id("GetStarted")).click();
		driver1.findElement(By.id("AccountNumber")).sendKeys(data.Accountnumber);
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.findElement(By.id("ZipCode")).sendKeys(data.zipcode);
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.findElement(By.id("submitButton")).click();
		
		// to add validations
		System.out.println("Moved out of Login page");
		tearDown();
}
catch(Exception e){}

	}
	public static void tearDown() {
		if(driver1!=null) {
			
			driver1.quit();
			System.out.println("Closing browser");
		}
}
	
	
	
	public static boolean metaSwitchValidations(){
		ChromeDriver drivermeta = new ChromeDriver();
		
		drivermeta.get("http://172.30.105.149:8087/");
		//drivermeta.findElement(By.class("gwt-TextBox")).sendKeys("VirtMetaCapGem");
		//drivermeta.findElement(By.class(gwt-PasswordTextBox)).sendKeys("7]x57YN=");
		
		
		
		
		
		drivermeta.findElement(By.xpath("//html//body//div[2]//div[2]//table//tbody//tr[2]//td//div//table//tbody//tr[2]//td//table//tbody//tr[1]//td[2]//input, ''))]")).sendKeys("VirtMetaCapGem");
		drivermeta.findElement(By.xpath(" , ''))]"));
		drivermeta.findElement(By.className ("gwt-TextBox")).sendKeys("VirtMetaCapGem");
		
		return true;
			
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

