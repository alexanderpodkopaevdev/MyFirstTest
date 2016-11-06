import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandr Podkopaev on 06.11.2016.
 */
public class PreSearchPage {
    private WebDriver driver;
    String nameCategory;
    By marketLink = By.xpath("//a[@href='https://market.yandex.ru/?clid=505']");
    By electronics = By.xpath("//ul/li[1]/a");
    By advancedSearch = By.cssSelector("td * .more .black");

    public PreSearchPage(WebDriver driver, String nameCategory) {
        this.driver = driver;
        this.nameCategory = nameCategory;
    }

    public WebDriver getSiteSearch() throws InterruptedException {
        driver.findElement(marketLink).click();
        /*В FireFox задержку выполнения удалось реализовать только через приостановку потока.
        На явные и неявные ожидания у меня он не реагировал.

        TimeUnit.SECONDS.sleep(5);
        ((new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(electronics))).click();*/

        driver.findElement(electronics).click();
        //TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("//div[1]/div[4]/div[1]/div//div/a[1][contains(text(),'" + nameCategory + "')]")).click();
        //TimeUnit.SECONDS.sleep(5);
        driver.findElement(advancedSearch).click();
        return driver;
    }
}
