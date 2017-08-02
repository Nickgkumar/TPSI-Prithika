package Test_Online;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class test {

  public static final String USERNAME = "prithikaannam1";
  public static final String AUTOMATE_KEY = "zXpunqhbGiVCmQU3VmVp";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\pannam\\Desktop\\Automation\\Libraries\\chromedriver.exe");
    caps.setCapability("browser", "chrome");
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("build", "First build");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}