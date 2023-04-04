import com.github.javafaker.Faker;
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
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String name = faker.name().firstName();
    String eMail = "lololo@lolo.ru";
    String pass = "lolololo";

    @Before
    public void setUp() {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\babdu\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);

    }

    //метод, который регистрирует пользователя
    protected void signUpUser() {
        SignUpFormPage signUp = new SignUpFormPage(driver);
        signUp.open();
        signUp.clickEnterAccountButton();
        signUp.clickLoginLink();
        signUp.inputUsernameInNameField(name);
        signUp.inputUserEmailInEmailField(email);
        signUp.inputPasswordInPasswordField(password);
        signUp.clickLoginButton();
    }

    //проверка сценария входа при нажатии кнопки "Войти в аккаунт" на главной странице
    @Test
    @DisplayName("Проверка сценария входа при нажатии кнопки \"Войти в аккаунт\" на главной странице")
    @Description("Кликаем на кнопку Конструктр, попадаем на морду сайта; кликаем на кнопку " +
            "Войти в аккаунт, попадаем в ворму Вход; заполняем поля; кликаем на кнопку Войти;" +
            "проверяем, что вход прошёл успешно")
    public void loginUserWhenClickEnterToAccountButtonInMainPage() {
        signUpUser();
        LoginFormPage enter = new LoginFormPage(driver);
        enter.clickConstructorButton();
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
        signUpUser();
        LoginFormPage enter = new LoginFormPage(driver);
        enter.clickConstructorButton();
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
        signUpUser();
        LoginFormPage enter = new LoginFormPage(driver);
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
        signUpUser();
        LoginFormPage enter = new LoginFormPage(driver);
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
            "лкикаем на кнопку Личный кабинет, переходим в него и проверяем успех")
    public void checkClick_throughToPersonalAccount() {
        LoginFormPage enter = new LoginFormPage(driver);
        enter.open();
        enter.clickEnterAccountButton();
        enter.inputUserEmailInEmailFieldToEnterForm(eMail);
        enter.inputPasswordInPasswordFieldToEnterForm(pass);
        enter.clickToEnterButton();
        enter.clickToPersonalAccountButton();
        enter.checkIsOpenProfilePage();
    }

    //Переход из личного кабинета в конструктор
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Логинимся, переходим в личный кабинет, кликаем на кнопку Конструктор" +
            "переходим на морду сайта и проверяем успех")
    public void swishFromProfilePageToConstructorSection() {
        signUpUser();
        LoginFormPage enter = new LoginFormPage(driver);
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
        enter.inputUserEmailInEmailFieldToEnterForm(eMail);
        enter.inputPasswordInPasswordFieldToEnterForm(pass);
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
        enter.inputUserEmailInEmailFieldToEnterForm(eMail);
        enter.inputPasswordInPasswordFieldToEnterForm(pass);
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


