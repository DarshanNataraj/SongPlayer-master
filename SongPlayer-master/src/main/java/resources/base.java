package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\darsh\\eclipse-workspace\\Dashboard\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\Drivers/chromedriver.exe");
		    driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			//execute in firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\eclipse\\Drivers\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}else if (browserName.equals("Edge")) {
			//execute in Edge driver
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\eclipse\\Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
				
	}
	
}
