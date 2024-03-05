package org.example.yandex.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;

    // Имя
    private final By NAME = By.xpath("//input[@placeholder='* Имя']");
    // Фамилия
    private final By SURNAME = By.xpath("//input[@placeholder='* Фамилия']");
    // Адрес
    private final By ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Станция Метро
    private final By METRO = By.className("select-search__input");
    // Телефон
    private final By PHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private final By BUTTON_FOLLOW_WRAPPER = By.className("Order_NextButton__1_rCA");
    private final By BUTTON_FOLLOW = By.xpath("//*[text()='Далее']");
    // Когда привезти самокат
    private final By DATA = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Срок аренды
    private final By DURATION_RENT = By.className("Dropdown-arrow");
    // Выбор срока аренды из дропдауна
    private final By CHOICE_DURATION_RENT = By.xpath("//*[text()='сутки']");
    // Цвет самоката
    private final By COLOR_BLACK = By.id("black");
    private final By COLOR_GREY = By.id("grey");
    // Комментарий для курьера
    private final By DELIVERY = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private final By ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");

    // Кнопка Да
    private final By YES_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");
    // Поп-ап Заказ оформлен
    private final By POPUP_ORDER_BOOK = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        new CookiePopup(driver).acceptCookieIfNecessary();
    }

    private void inputName(String value) {
        driver.findElement(NAME).sendKeys(value);
    }

    private void inputSurname(String value) {
        driver.findElement(SURNAME).sendKeys(value);
    }

    private void inputAddress(String value) {
        driver.findElement(ADDRESS).sendKeys(value);
    }

    private void inputMetro(String value) {
        WebElement metroInput = driver.findElement(METRO);
        metroInput.sendKeys(value);
        metroInput.sendKeys(Keys.DOWN);
        metroInput.sendKeys(Keys.RETURN);

    }

    private void inputTelephone(String value) {
        driver.findElement(PHONE).sendKeys(value);
    }

    private void inputData(String value) {
        driver.findElement(DATA).sendKeys(value);
    }

    private void inputDurationRent() {
        driver.findElement(DURATION_RENT).click();
        driver.findElement(CHOICE_DURATION_RENT).click();
    }

    private void inputColorBlack() {
        driver.findElement(COLOR_BLACK).click();
    }

    private void inputColorGrey() {
        driver.findElement(COLOR_GREY).click();
    }

    private void inputDelivery(String value) {
        driver.findElement(DELIVERY).sendKeys(value);
    }

    private void clickButtonFollow() {
        driver.findElement(BUTTON_FOLLOW_WRAPPER).findElement(BUTTON_FOLLOW).click();
    }

    private void clickOrderButton() {
        WebElement orderInput = driver.findElement(ORDER_BUTTON);
        orderInput.click();
    }

    private void clickYesButton() {
        driver.findElement(YES_BUTTON).click();
    }

    private void waitForLoadResponse() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(POPUP_ORDER_BOOK).getText() != null
                && !driver.findElement(POPUP_ORDER_BOOK).getText().isEmpty()
        ));
    }

    private void waitForYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(YES_BUTTON).getText() != null
                && !driver.findElement(YES_BUTTON).getText().isEmpty()
        ));
    }

    public void fillFirstPart(String name, String surname, String address, String metro, String telephone) {
        inputName(name);
        inputSurname(surname);
        inputAddress(address);
        inputMetro(metro);
        inputTelephone(telephone);
        clickButtonFollow();
    }

    public void fillSecondPart(String data, String color, String delivery) {
        inputData(data);
        inputDurationRent();
        if ("grey".equals(color)) {
            inputColorGrey();
        } else {
            inputColorBlack();
        }
        inputDelivery(delivery);
        clickOrderButton();
        waitForYesButton();
        clickYesButton();
        waitForLoadResponse();
    }

    public String getOrderBookMessage() {
        return driver.findElement(POPUP_ORDER_BOOK).getText();
    }
}