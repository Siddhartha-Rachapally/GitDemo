package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        //result = testCondition ? value1 : value2
        String browser = browser_maven != null ? browser_maven : browser_properties;


        if(driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            if(browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\msedgedriver.exe");
                driver = new EdgeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
