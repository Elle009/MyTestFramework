import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IssuePage extends BasePage {
    By newIssueButton = By.xpath("//span[contains(text(), 'New issue')]");
    By issueField = By.id("issue_title");
    By submitIssueButton = By.xpath("//button[contains (@class, 'btn-primary btn ml-2')]");
    By newIssue = By.xpath("//a[contains(text(), 'New issue2')]");
    private final static String TITLE="Issue page";

    public IssuePage(WebDriver driver) {
        super(driver, TITLE);
    }

    public WebElement getNewIssueButton() {
        return driver.findElement(newIssueButton);
    }

    public IssuePage createNewIssue(){
        driver.findElement(newIssueButton).click();
        driver.findElement(issueField).sendKeys("New issue2");
        driver.findElement(submitIssueButton).click();
        driver.findElement(newIssue).getText();
        return this;
    }
}
