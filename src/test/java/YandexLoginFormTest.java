import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Тестовый класс, проверяет работу формы Вход в ЯБро
public class YandexLoginFormTest {
    private WebDriver driver;

    String email = "baba@baba.ru";
    String password = "babababa";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\babdu\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);

    }


    //проверка сценария входа при нажатии кнопки "Войти в аккаунт" на главной странице
    @Test
    @DisplayName("Проверка сценария входа при нажатии кнопки \"Войти в аккаунт\" на главной странице")
    @Description("Кликаем на кнопку Конструктр, попадаем на морду сайта; кликаем на кнопку " +
            "Войти в аккаунт, попадаем в ворму Вход; заполняем поля; кликаем на кнопку Войти;" +
            "проверяем, что вход прошёл успешно")
    public void loginUserWhenClickEnterToAccountButtonInMainPage() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.checkOpenMainPage();
    }

    //проверка сценария входа при нажатии кнопки "Личный кабинет" на главной странице
    @Test
    @DisplayName("Проверка сценария входа при нажатии кнопки \"Личный кабинет\" на главной странице")
    @Description("Переходим на морду сайта, кликаем на Личный кабинет, переходим в форму Вход;" +
            "логинимся и проверяем успешность звлогина")
    public void loginUserWhenClickEnterToPersonalAccountButtonInMainPage() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickToPersonalAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.checkOpenMainPage();
    }

    //проверка сценария входа при нажатии на ссылку Войти в форме регистрации
    @Test
    @DisplayName("Проверка сценария входа при нажатии на ссылку Войти в форме регистрации")
    @Description("Кликаем по ссылке Регистрацияв фрме Вход, переходим в Регистрацию; кликаем по ссылке" +
            "Вход, логинимся, проверяем успешность действий")
    public void loginUserWhenClickToEnterLink() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.clickLoginLinkInEnterForm();
        enter.clickEnterLinkInLoginForm();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.checkOpenMainPage();
    }

    //проверка сценария входа при нажатии на ссылку Войти в форме Восстановления пароля
    @Test
    @DisplayName("Проверка сценария входа при нажатии на ссылку Войти в форме Восстановления пароля")
    @Description("В форме Вход кликаем на ссылку Восстановить аккаунт; в форме Востановление аккаунта" +
            "кликаем по ссылке Войти; логинимся, проверяем успех")
    public void loginWhenClickToEnterButtonInRecoveryForm() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.clickRecoveryLink();
        enter.clickEnterLinkInRecoveryForm();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.checkOpenMainPage();
    }

    //Проверка перехода по клику в личный кабинет
    @Test
    @DisplayName("Проверка перехода по клику в личный кабинет")
    @Description("Кликаем на кнопку Личный кабинет, в форме Вход логинимся;" +
            "клкикаем на кнопку Личный кабинет, переходим в него и проверяем успех")
    public void checkClick_throughToPersonalAccount() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.clickToPersonalAccountButton();
        enter.checkIsOpenProfilePage();
    }

    //Переход из личного кабинета в конструктор
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Логинимся, переходим в личный кабинет, кликаем на кнопку Конструктор" +
            " переходим на морду сайта и проверяем успех")
    public void swishFromProfilePageToConstructorSection() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.clickToPersonalAccountButton();
        enter.clickConstructorButton();
        enter.checkOpenMainPage();
    }

    //Переход из ЛК в Stellar Burgers
    @Test
    @DisplayName("Переход из ЛК в Stellar Burgers")
    @Description("После залогина переходим в личный кабинет, там кликаем на логотип и" +
            "переходим на морду сайта, проверяем успех")
    public void swishFromProfilePageToMainPageWhenClickInLogo() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.clickToPersonalAccountButton();
        enter.clickLogoStellarBurgers();
        enter.checkOpenMainPage();
    }

    //Проверка выхода из аккаунта
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    @Description("Логинимся, заходим в ЛК, кликаем по кнопке Выход, разлогиниваемся" +
            "и проверяем успех операции")
    public void checkLogout() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(email);
        enter.inputPasswordInPasswordFieldToEnterForm(password);
        enter.clickToEnterButton();
        enter.clickToPersonalAccountButton();
        enter.clickLoginOffButton();
        enter.checkIsOpenEnterForm();
    }


    @After
    public void close() {
        driver.quit();
    }
}


