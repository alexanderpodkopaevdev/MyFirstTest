import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


/**
 * Created by Alexandr Podkopaev on 04.11.2016.
 */
public class MyTest1 {


    public void myTest(String device, int cost, String[] brands) throws Exception {

        //Драйвер для Firefox
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        //Драйвер для Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://yandex.ru");

        //Переход по страницам до страницы поиска
        PreSearchPage preSearch = new PreSearchPage(driver, device);

        //Обработка поискового запроса
        SearchPage searchPage = new SearchPage(preSearch.getSiteSearch());
        //Выставление параметров и получение списка товаров
        List<WebElement> list = searchPage.choseCost(cost).
                choseBrand(brands).
                applySearch().
                getList();
        //Проверка, что в списке 12 элементов
        assertEquals(list.size(), 12);
        String listFirstName = searchPage.getListFirstName();
        //Поиск первого товара из списка
        searchPage.findFirstName();
        //Проверка, что наименование найденного товара соответствует запомненному из списка значению
        assertEquals(searchPage.getResultProduct(), listFirstName);
        driver.close();
    }
}
