import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorSection {

    //локатор кнопки Булки
    private final By bunsButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");

    //локатор кнопки Соусы
    private final By saucesButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");

    //локатор кнопки Начинки
    private final By fillingsButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    //локатор раздела булки
    private final By bunsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");

    //локатор раздела соусы
    private final By saucesSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");

    //локатор раздела начинки
    private final By fillingsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    private final WebDriver driver;

    public ConstructorSection(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //метод открывающий страницу в браузере
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    //метод кликает на кнопку Булки
    public void clickToBunsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bunsButton));
        driver.findElement(bunsButton).click();
    }

    //метод проверяет открытие раздела Булки в конструкторе
    public void checkIsOpenBunsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunsSection));
        Assert.assertTrue(driver.findElement(bunsSection).isDisplayed());
    }

    //метод кликает на кнопку Соусы
    public void clickToSaucesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saucesButton));
        driver.findElement(saucesButton).click();
    }

    //метод проверяет открытие раздела Соусы
    public void checkIsOpenSaucesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(saucesSection));
        Assert.assertTrue(driver.findElement(saucesSection).isDisplayed());
    }

    //метод кликает на кнопку Начинки
    public void clickToFillingsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsButton));
        driver.findElement(fillingsButton).click();
    }

    //метод проверяет открытие раздела Начинки
    public void checkIsOpenFillingsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsSection));
        Assert.assertTrue(driver.findElement(fillingsSection).isDisplayed());
    }

}
