import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubTest {
    private WebDriver driver;

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\EleonoraBulhakova\\IdeaProjects\\MyTestFramework\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");

        WebElement signInButton = driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
        signInButton.click();

        WebElement logo = driver.findElement(By.className("header-logo"));
        assertTrue(logo.isDisplayed(), "Logo isn't displayed");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys("Elle009");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("7242904Bes");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Sign in\"]"));
        loginButton.click();

        WebElement profileLogo = driver.findElement(By.xpath("//span[@class='Button-label']/child::img[@class=\"avatar circle\"]"));
        assertTrue(profileLogo.isDisplayed(), "Logo isn't displayed");

        WebElement repositoryButton = driver.findElement(By.xpath("//div [@class='wb-break-word']/child::a[@href=\"/Elle009/Myproject\"]"));
        repositoryButton.click();
//10 elements on Code tab
        WebElement codeTab = driver.findElement(By.xpath("//a[@id=\"code-tab\"]"));
        WebElement goToFileButton = driver.findElement(By.xpath("//a[contains(text(), 'Go to file')]/parent::div"));
        WebElement actionsTab = driver.findElement(By.xpath("//a[@id=\"actions-tab\"]"));
        WebElement codeButton = driver.findElement(By.xpath("//span[contains(text(), 'Code')]/parent::span[@class=\"Button-content\"]"));
        WebElement addFileButton = driver.findElement(By.xpath("//span[contains(text(), 'Add file')]"));
        WebElement branchButton = driver.findElement(By.className("css-truncate-target"));
        WebElement protectThisBranchButton = driver.findElement(By.xpath("//a[contains(text(), \"Protect this branch\")]"));
        WebElement textAboutProtection = driver.findElement(By.xpath("//h1[text()=\"Your master branch isn't protected\"]"));
        WebElement commitsButton = driver.findElement(By.xpath("//span[contains(text(), 'commits')]"));
        WebElement forkButton = driver.findElement(By.id("fork-button"));

        actionsTab.click();
//5 X path elements on Actions tab
        WebElement searchField = driver.findElement(By.xpath("//input[@name=\"query\"]"));
        WebElement deploymentButton = driver.findElement(By.xpath("//a[contains(text(), \"Deployment\")]"));
        WebElement continiousIntegrationButton = driver.findElement(By.xpath("//a[contains(text(), \" Continuous integration\")]"));
        WebElement AutomationButton = driver.findElement(By.xpath("//a[contains(text(), \" Automation\")]"));
        WebElement PagesButton = driver.findElement(By.xpath("//a[contains(text(), \" Pages\")]"));
        driver.quit();
    }
}
