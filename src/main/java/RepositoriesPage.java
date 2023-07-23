import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class RepositoriesPage extends BasePage {

    List<WebElement> repositoriesList = driver.findElements(By.xpath("//a[@itemprop=\"name codeRepository\"]"));
    private final static String TITLE="Repositories page";

    public RepositoriesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public List<String> getRepositories() {
        List<String> repositList = repositoriesList.stream().map(rep -> rep.getText()).collect(Collectors.toList());
        return repositList;
    }

    By repoTest2 = By.xpath("//a[contains(text(), 'test2')]");
    By repoTest1 = By.xpath("//a[contains(text(), 'test1')]");
    By repoTestRepo = By.xpath("//a[contains(text(), 'testRepository')]");
    public RepositoriesPage getRepositoriesText(){
        driver.findElement(repoTest2).getText();
        driver.findElement(repoTest1).getText();
        driver.findElement(repoTestRepo).getText();
        return this;
    }
}