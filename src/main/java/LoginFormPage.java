import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormPage {

    //локатор для ссылки Войти в форме Регистрации //*[@id='root']/div/main/div/div/p[1]/a
    private final By enterLinkInLoginForm = By.xpath("//*[@class='Auth_link__1fOlj']");

    //локатор для кнопки Личный кабинет на главной странице
    private final By personalAccountButton = By.xpath("//*[@id='root']/div/header/nav/a/p");

    //локатор для кнопки Войти в аккаунт на главной странице
    private final By enterAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");

    //локатор для формы Войти
    private final By enterFormPage = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    //локатор для кнопки Войти под формой Вход
    private final By toEnterButton = By.xpath("//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //локатор для поля Email в форме Вход
    private final By emailFieldInEnterForm = By.xpath("//*[@name='name']");

    //локатор для поля Пароль в форме Вход
    private final By passwordFieldInEnterForm = By.xpath("//*[@name='Пароль']");


    //локатор для заголовка Собери бургер на главной странице
    private final By assembleBurger = By.xpath("//*[@class='text text_type_main-large mb-5 mt-10']");

    //локатор для ссылки Зарегистрироваться в форме Вход
    private final By loginLinkInEnterForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");

    // локатор для ссылки Востановление пароля в форме Вход
    private final By recoveryLinkInEnterForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");

    //локатор для ссылки Войти в форме Восстановление пароля
    private final By enterLinkInRecoveryForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    //локатро для кнопки Конструктор
    private final By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    //локатор для страницы профиля пользователя
    private final By profilePage = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");

    //локатор логотипа сайта
    private final By stellarBurger = By.xpath("//*[@id=\"root\"]/div/header/nav");

    //локатор кнопки Выход в личном кабинете
    private final By logOffButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");
    private final WebDriver driver;

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //метод открывающий страницу в браузере
        driver.get("https://stellarburgers.nomoreparties.site/");
    }


    //метод кликает на кнопку Личный кабинет на главной странице
    public void clickToPersonalAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    //метод заполняет поле Email в форме Вход
    public void inputUserEmailInEmailFieldToEnterForm(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(emailFieldInEnterForm));
        WebElement nameText = driver.findElement(emailFieldInEnterForm);
        nameText.click();
        nameText.sendKeys(email);
    }

    //метод заполняет поле Пароль в форме Вход
    public void inputPasswordInPasswordFieldToEnterForm(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(passwordFieldInEnterForm));
        WebElement nameText = driver.findElement(passwordFieldInEnterForm);
        nameText.click();
        nameText.sendKeys(password);
    }

    //метод кликает на кнопку Войти под формой Вход
    public void clickToEnterButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(toEnterButton));
        driver.findElement(toEnterButton).click();
    }

    //метод проверяющий успешный вход пользователя, должна открыться главная страница
    public void checkOpenMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(assembleBurger));
        Assert.assertTrue(driver.findElement(assembleBurger).isDisplayed());
    }

    //метод кликает на ссылку Зарегистрироваться в форме вход
    public void clickLoginLinkInEnterForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(loginLinkInEnterForm));
        driver.findElement(loginLinkInEnterForm).click();
    }

    //метод кликает на ссылку Войти в форме Регистрации
    public void clickEnterLinkInLoginForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enterLinkInLoginForm));
        driver.findElement(enterLinkInLoginForm).click();
    }

    //метод кликает на ссылку Восстановления пароля в форме Вход
    public void clickRecoveryLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(recoveryLinkInEnterForm));
        driver.findElement(recoveryLinkInEnterForm).click();
    }

    //метод кликает на ссылку Вход в форме Восстановление пароля
    public void clickEnterLinkInRecoveryForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(enterLinkInRecoveryForm));
        driver.findElement(enterLinkInRecoveryForm).click();
    }

    //метод проверяет открылась ли форма Вход
    public void checkIsOpenEnterForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterFormPage));
        Assert.assertTrue(driver.findElement(enterFormPage).isDisplayed());

    }

    //метод кликает на кнопку Конструктор в любом окне
    public void clickConstructorButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    //метод проверит открытие страницы профиля пользователя
    public void checkIsOpenProfilePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePage));
        Assert.assertTrue(driver.findElement(profilePage).isDisplayed());

    }

    //метод кликает на логотип сайта Stellar Burgers
    public void clickLogoStellarBurgers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(stellarBurger));
        driver.findElement(stellarBurger).click();
    }

    //метод кликает на кнопку Выход в личном кабинете
    public void clickLoginOffButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logOffButton));
        driver.findElement(logOffButton).click();
    }

    // метод кликает на кнопку Войти в аккаунт на главной странице
    public void clickEnterAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        driver.findElement(enterAccountButton).click();

    }
}



