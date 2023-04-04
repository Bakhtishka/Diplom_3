import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


//Страница с формой регистрации
public class SignUpFormPage {

    //локатор поля Имя в форме регистрации
    private final By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //локатор поля Email в форме регистрации
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    //локатор поля Пароль
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    //локатор кнопки Зарегистрироваться
    private final By loginButton = By.xpath("//*[@id='root']/div/main/div/form/button");


    //локатор для кнопки Личный кабинет на главной странице
    private final By personalAccountButton = By.xpath("//*[@id='root']/div/header/nav/a/p");

    //локатор для кнопки Войти в аккаунт
    private final By enterAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");

    //локатор для формы Войти
    private final By enterFormPage = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    //локатор для ссылки Зарегистрироваться в форме Вход
    private final By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");


    //локатор для поля Пароль при не верном вводе данных, менее 6 символов, в форме Вход
    private final By incorrectPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    private final WebDriver driver;

    public SignUpFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //метод открывающий страницу в браузере
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    //метод ктоторый находит кнопку Личный кабинет на главной странице и нажимает на неё
    public void clickPersonalAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();

    }

    // метод кликает на кнопку Войти в аккаунт на главной странице
    public void clickEnterAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        driver.findElement(enterAccountButton).click();

    }

    //метод находит ссылку в окне формы Вход - "Зарегистрироваться" и кликает на неё
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    //метод заполняет поле имя в форме Регистрация
    public void inputUsernameInNameField(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        WebElement nameText = driver.findElement(nameField);
        nameText.click();
        nameText.sendKeys(name);
    }

    //метод заполняет поле Email в форме Регистрация
    public void inputUserEmailInEmailField(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        WebElement nameText = driver.findElement(emailField);
        nameText.click();
        nameText.clear();
        nameText.sendKeys(email);
    }

    //метод заполняет поле пароль в форме Регистрация
    public void inputPasswordInPasswordField(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        WebElement nameText = driver.findElement(passwordField);
        nameText.click();
        nameText.clear();
        nameText.sendKeys(password);
    }

    //метод кликает на кнопку Зарегистрироваться под формой Регистрация
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }


    //метод проверяющий успешную регистрацию, должна открыться главная страница
    public void checkSuccessfulLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterFormPage));
        Assert.assertTrue(driver.findElement(enterFormPage).isDisplayed());
    }

    //метод проверяет выдачу ошибки, при неправильном вводе пароля (5символов)
    public void checkErrorLogWhenInputIncorrectPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPassword));
        Assert.assertTrue(driver.findElement(incorrectPassword).isDisplayed());
    }

}



