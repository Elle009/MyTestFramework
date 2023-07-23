import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

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
        Assert.assertTrue(mainPage.getLogoOnTheMainPage().isDisplayed());
        mainPage.goToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        Assert.assertTrue(issuePage.getNewIssueButton().isDisplayed());
        issuePage.createNewIssue();
        logger.info("checkAddingNewIssue Test passed successfully");
    }

    @DataProvider(name = "RepositoriesList")
    public Object[][] provideRepoList() {
        return new Object[][]{
                {"test2"},
                {"test1"},
                {"testRepository"}
        };
    }

    @Test(dataProvider = "RepositoriesList")
    public void checkRepositoriesListParametrized(String repo) {

        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("eleonorabulhakova@ukr.net", "eleonora1q2w#E");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm().goToRepositoriesPage();
        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        repositoriesPage.getRepositoriesText();
        Assert.assertEquals(repo, "test2");
        Assert.assertEquals(repo, "test1");
        Assert.assertEquals(repo, "testRepository");
    }
}

