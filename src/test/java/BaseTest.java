import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
protected Logger logger;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\EleonoraBulhakova\\IdeaProjects\\MyTestFramework\\src\\main\\resources\\drivers\\chromedriver1.exe");
        Logger logger = LogManager.getLogger();
        logger.info("Chrome driver object creation is starting");
        driver = new ChromeDriver();
        logger.info("Chrome driver object creation is created");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}