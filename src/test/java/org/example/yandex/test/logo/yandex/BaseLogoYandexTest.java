package org.example.yandex.test.logo.yandex;

import org.example.yandex.pom.MainPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseLogoYandexTest {
    protected WebDriver driver;
    static final String URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    static final String URL_ORDER = "https://qa-scooter.praktikum-services.ru/order";
    static final String URL_YANDEX = "https://dzen.ru/?yredirect=true";

    void doInternalMain() {
        driver.manage().window().maximize();
        driver.get(URL_MAIN);
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnYandexLogo();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(titleIs("Дзен"));
        assertEquals(URL_YANDEX, driver.getCurrentUrl());
    }



    void doInternalOrder() {
        driver.manage().window().maximize();
        driver.get(URL_ORDER);
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnYandexLogo();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(titleIs("Дзен"));
        assertEquals(URL_YANDEX, driver.getCurrentUrl());
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
