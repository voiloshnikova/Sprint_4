package org.example.yandex.test.logo.samokat;

import org.example.yandex.pom.MainPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class BaseLogoSamokatTest {
    protected WebDriver driver;
    static final String URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    static final String URL_ORDER = "https://qa-scooter.praktikum-services.ru/order";

    void doInternalMain() {
        driver.manage().window().maximize();
        driver.get(URL_MAIN);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSamokatLogo();
        assertEquals(URL_MAIN, driver.getCurrentUrl());
    }

    void doInternalOrder() {
        driver.manage().window().maximize();
        driver.get(URL_ORDER);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSamokatLogo();
        assertEquals(URL_MAIN, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}