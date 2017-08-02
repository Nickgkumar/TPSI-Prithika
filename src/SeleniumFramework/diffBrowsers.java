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
 * @author pannam
 *
 */
public class  diffBrowsers {
	static WebDriver driver1;
	public   void  test(){
		
	InputData data = new InputData();
	System.out.println(data.browser);
	
		if (data.browser == "Chrome" && data.browser != null)		
		{
			System.out.println("just before opening browser");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("marionette", true);
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pannam\\Desktop\\Automation\\Libraries\\chromedriver.exe");
		 driver1  = new ChromeDriver();
		
		}else  if (data.browser == "IE" && data.browser != null){
		//	driver1  = new InternetExplorerDriver();
					
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					driver1 = new InternetExplorerDriver(ieCapabilities);
			
		}
		else  if (data.browser == "FF" && data.browser != null){
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			 WebDriver driver = new FirefoxDriver();
		}
		
		else if (data.browser == "Opera" && data.browser != null){
			DesiredCapabilities capabilities = DesiredCapabilities.opera();
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("127.0.0.1:1234");
			capabilities.setCapability("proxy", proxy);

			WebDriver driver = new OperaDriver(capabilities);	
		}
	
		else{
			System.out.println("Please provide browser information");
		}
	
	}

	public static void loginPage(InputData data) {

		driver1.get("http://kstllapld01:8090/");
		//driver1.get(data.baseUrl);	
		//driver1.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		//driver1.manage().window().maximize();
	
		System.out.println("Successfully opened the website TPSI");
		driver1.findElement(By.id("GetStarted")).click();
		driver1.findElement(By.id("AccountNumber")).sendKeys("Accountnumber");
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.findElement(By.id("ZipCode")).sendKeys("zipcode");
		driver1.findElement(By.id("submitButton")).click();
		System.out.println("Moved out of Login page");
	}
	public void tearDown() {
		if(driver1!=null) {
			System.out.println("Closing IE browser");
			driver1.quit();
		}
}
}

