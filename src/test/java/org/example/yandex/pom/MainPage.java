package org.example.yandex.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    // Логотип Яндекс header
    private final By LOGO_YANDEX = By.className("Header_LogoYandex__3TSOI");
    // Логотип Самокат header
    private final By LOGO_SAMOKAT = By.className("Header_LogoScooter__3lsAR");
    // Кнопка Заказать header
    private final By HEADER_BUTTON_ORDER_WRAPPER = By.className("Header_Nav__AGCXC");
    private final By BUTTON_ORDER = By.className("Button_Button__ra12g");
    // Кнопка Статус заказа header
    private final By BUTTON_STATUS_ORDER = By.className("Header_Link__1TAG7");
    // Поиск заказа header
    private final By HEADER_SEARCH = By.className("Input_Input__1iN_Z");
    // Кнопка Go для поиска заказа header
    private final By SEARCH_BUTTON_GO = By.className("Header_Button__28dPO");
    // Ошибка "Что-то пошло не так"
    private final By ERROR = By.className("Input_ErrorMessage__3HvIb");
    // Кнопка Заказать на главном экране
    private final By MAIN_BUTTON_ORDER_WRAPPER = By.className("Home_FinishButton__1_cWm");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        new CookiePopup(driver).acceptCookieIfNecessary();
    }

    private static By getQuestionLocator(String questionId) {
        return By.id(questionId);
    }

    private static By getResponseLocator(String answerId) {
        return By.id(answerId);
    }


    private void clickOnQuestion(String questionId) {
        driver.findElement(getQuestionLocator(questionId)).sendKeys(" ");
    }

    private void waitResponse(String responseId) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(getResponseLocator(responseId)));
    }

    private String getTextResponse(String responseId) {
        return driver.findElement(getResponseLocator(responseId)).getText();
    }

    public String getResponse(String questionId, String responseId) {
        clickOnQuestion(questionId);
        waitResponse(responseId);
        return getTextResponse(responseId);
    }

    public String getTextQuestion(String questionId) {
        return driver.findElement(getQuestionLocator(questionId)).getText();
    }

    public void clickButtonHeaderOrder() {
        driver.findElement(HEADER_BUTTON_ORDER_WRAPPER).findElement(BUTTON_ORDER).click();
    }

    public void clickButtonMainOrder() {
        WebElement mainButtonWrapper = driver.findElement(MAIN_BUTTON_ORDER_WRAPPER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", mainButtonWrapper);
        mainButtonWrapper.findElement(BUTTON_ORDER).click();
    }

    public void clickOnSamokatLogo(){
        driver.findElement(LOGO_SAMOKAT).click();
    }

    public void clickOnYandexLogo(){
        driver.findElement(LOGO_YANDEX).click();
    }

    private void clickCheckOrderButton() {
        driver.findElement(BUTTON_STATUS_ORDER).click();
    }
    private void fillTrackNumber(String orderId) {
        driver.findElement(HEADER_SEARCH).sendKeys(orderId);
    }

    private void clickGoButton() {
        driver.findElement(SEARCH_BUTTON_GO).click();
    }

    private void waitForTrackNumberInputReady() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(HEADER_SEARCH));
    }

    public void trackOrder(String orderId) {
        clickCheckOrderButton();
        waitForTrackNumberInputReady();
        fillTrackNumber(orderId);
        clickGoButton();
    }
}