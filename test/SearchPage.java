import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandr Podkopaev on 06.11.2016.
 */
public class SearchPage {
    WebDriver driver;
    List<WebElement> list;
    By choseCost = By.id("glf-pricefrom-var");
    By applySearch = By.cssSelector(".n-filter-panel-aside__apply");
    By getList = By.cssSelector(".n-snippet-card");
    By listFirstName = By.xpath("//span[@class='snippet-card__header-text']");
    By findString = By.id("header-search");
    By findButton = By.cssSelector(".button2");
    By resultProduct = By.xpath("//div[1]/div[1]/div/h1");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public SearchPage choseCost(int cost) {
        driver.findElement(choseCost).sendKeys(Integer.toString(cost));
        return this;
    }

    public SearchPage choseBrand(String[] brands) {
        for (String brand : brands) {
            driver.findElement(By.xpath("//span//*[text()[contains(.,'" + brand + "')]]")).click();
        }
        return this;
    }

    public SearchPage applySearch() throws InterruptedException {
        driver.findElement(applySearch);
        TimeUnit.SECONDS.sleep(5);
        return this;
    }

    public List<WebElement> getList() {
        list = driver.findElements(getList);
        return list;
    }


    public String getListFirstName() {
        return list.get(0).findElement(listFirstName).getText();
    }

    public void findFirstName() {
        driver.findElement(findString).sendKeys(getListFirstName());
        driver.findElement(findButton).click();
    }

    public String getResultProduct() {
        return driver.findElement(resultProduct).getText();
    }
}
