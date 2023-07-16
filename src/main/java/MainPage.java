import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    By imgLocator = By.xpath("//img[@class='avatar circle'][1]");
    By goToRepositoryButton = By.xpath("//div [@class='wb-break-word']/child::a[@href=\"/EleonoraBulhakova/testRepository\"]");
    By issueButton = By.id("issues-tab");
    private final static String TITLE="Main page";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public WebElement getLogoOnTheMainPage() {
        return driver.findElement(imgLocator);
    }

    public ProfileForm goToProfileForm() {
        Assertions.assertTrue(driver.findElement(imgLocator).isDisplayed());
        driver.findElement(imgLocator).click();
        return new ProfileForm(driver);
    }

    public IssuePage goToIssuePage(){
        driver.findElement(goToRepositoryButton).click();
        driver.findElement(issueButton).click();
        return new IssuePage(driver);
    }
}
