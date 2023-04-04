import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




//тестовый класс, проверяет работу Конструктора, переходы в его разделы: Булки, Соусы, Начинки.
//в Яндекс браузере
public class YandexConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\babdu\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);

    }

    @Test
    @DisplayName("Проверка работы перехода в раздел Соусы")
    @Description("Кликаем на кнопку Соусы в конструкторе, окошко должно сместиться к этому раздел")
    public void checkTransitionToSaucesSection() {
        ConstructorSection constructor = new ConstructorSection(driver);
        constructor.open();
        constructor.clickToSaucesButton();
        constructor.checkIsOpenSaucesSection();
    }

    @Test
    @DisplayName("Проверка работы перехода в раздел Булочки")
    @Description("Кликаем на кнопку Булочки в конструкторе, окошко должно сместиться к этому раздел")
    public void checkTransitionToBunsSection() {
        ConstructorSection constructor = new ConstructorSection(driver);
        constructor.open();
        constructor.clickToFillingsButton();
        constructor.clickToBunsButton();
        constructor.checkIsOpenBunsSection();
    }

    @Test
    @DisplayName("Проверка работы перехода в раздел Начинки")
    @Description("Кликаем на кнопку Начинки в конструкторе, окошко должно сместиться к этому раздел")
    public void checkTransitionToFillingsSection() {
        ConstructorSection constructor = new ConstructorSection(driver);
        constructor.open();
        constructor.clickToFillingsButton();
        constructor.checkIsOpenFillingsSection();
    }

    @After
    public void close() {
        driver.quit();
    }
}





