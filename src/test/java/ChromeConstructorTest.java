import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//тестовый класс, проверяет работу Конструктора, переходы в его разделы: Булки, Соусы, Начинки.
public class ChromeConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
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




