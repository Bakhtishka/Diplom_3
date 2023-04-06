import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//тестовый класс для проверки сценария регистрации в Яндекс браузере
public class YandexSignUpTest {
    private WebDriver driver;
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String name = faker.name().firstName();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\babdu\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);

    }

    //проверка сценария регистрации при нажатии кнопки "Личный кабинет"
    @Test
    @DisplayName("Проверка сценария регистрации при нажатии кнопки \"Личный кабинет\"")
    @Description("Кликаем по кнопке ЛК, в форме Вход кликаем на ссылку Зарегистрироваться;" +
            "заполняем поля, кликаем по Зарегистрироваться и проверяем успех операции")
    public void signUpUserTestWhenClickPersonalAccountButton() {
        SignUpFormPage registration = new SignUpFormPage(driver);
        registration.open();
        registration.clickPersonalAccountButton();
        registration.clickLoginLink();
        registration.inputUsernameInNameField(name);
        registration.inputUserEmailInEmailField(email);
        registration.inputPasswordInPasswordField(password);
        registration.clickLoginButton();
        registration.checkSuccessfulLogin();
    }


    //проверка ошибки для некорректного пароля из пяти символов
    @Test
    @DisplayName("Проверка ошибки для некорректного пароля из пяти символов")
    @Description("При вводе пароля из менее чем 5 символов включительно, поле Пароль " +
            "подсвечивается красным и выдает ошибку.")
    public void checkErrorWhenInputIncorrectQuantityCharsInPasswordField() {
        SignUpFormPage registration = new SignUpFormPage(driver);
        registration.open();
        registration.clickEnterAccountButton();
        registration.clickLoginLink();
        registration.inputUsernameInNameField(name);
        registration.inputUserEmailInEmailField(email);
        registration.inputPasswordInPasswordField("aassd");
        registration.clickLoginButton();
        registration.checkErrorLogWhenInputIncorrectPassword();
    }

    //проверка сценария регистрации при нажатии на ссылку Зарегистрироваться в форме Воход
    @Test
    @DisplayName("Проверка сценария регистрации при нажатии на ссылку Зарегистрироваться в форме Вход")
    @Description("В форме Вход кликаем по ссылке Зарегистрироваться, переходим в форму Регистрация" +
            "и заполняем все поля, кликаем по Зарегистрироваться и проверяем успех операции")
    public void signUpUserWhenClickEnterToAccountButtonInMainPage() {
        SignUpFormPage registration = new SignUpFormPage(driver);
        registration.open();
        registration.clickEnterAccountButton();
        registration.clickLoginLink();
        registration.inputUsernameInNameField(name);
        registration.inputUserEmailInEmailField(email);
        registration.inputPasswordInPasswordField(password);
        registration.clickLoginButton();
        registration.checkSuccessfulLogin();
    }

    @After
    public void close() {
        driver.quit();
    }
}






