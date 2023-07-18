import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubTest extends BaseTest {

    @Test
    public void checkLogoOnTheLoginPage() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.goToLoginPage().getLogo().isDisplayed(), "Logo is not displayed");
    }

    @Test
    public void checkFailedLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFailed("Elle009", "000");
        loginPage.validateErrorMessage("Incorrect username or password.");
        Logger logger = LogManager.getLogger();
        logger.info("checkFailedLogin passed successfully");
    }

    @Test
    public void checkAddingNewIssue() {
        Logger logger = LogManager.getLogger();
        logger.info("checkAddingNewIssue Test is starting");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccessful("eleonorabulhakova@ukr.net", "eleonora1q2w#E");
        MainPage mainPage = new MainPage(driver);
        logger.info("User is successfully gone to Main page");
        mainPage.getLogoOnTheMainPage();
        Assertions.assertTrue(mainPage.getLogoOnTheMainPage().isDisplayed());
        mainPage.goToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        Assertions.assertTrue(issuePage.getNewIssueButton().isDisplayed());
        issuePage.createNewIssue();
        logger.info("checkAddingNewIssue Test passed successfully");
    }

}

