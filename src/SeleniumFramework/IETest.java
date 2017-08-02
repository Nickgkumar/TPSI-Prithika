package SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IETest {

	public void openIE(String BaseUrl){
		 System.setProperty("webdriver.IE.driver", "C:\\Users\\pannam\\Desktop\\Automation\\Libraries\\chromedriver.exe");
		 DesiredCapabilities caps = DesiredCapabilities.internetExplorer(); 
		   caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);    
		    WebDriver drivera = new InternetExplorerDriver(caps);     
		    drivera.get(BaseUrl);
		    drivera.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    
		    System.out.println("Successfully opened the website TPSI on IE");
		    try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		    
		 
}
