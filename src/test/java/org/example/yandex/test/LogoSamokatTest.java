package org.example.yandex.test;

import org.example.yandex.pom.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;


public class LogoSamokatTest {
    private WebDriver driver;
    public static final String URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    public static final String URL_ORDER = "https://qa-scooter.praktikum-services.ru/order";

    @Test
    public void checkOpenMainPageFromMainChromeTest() {
        driver = new ChromeDriver();
        doInternalMain();
    }
    @Test
    public void checkOpenMainPageFromOrderChromeTest() {
        driver = new ChromeDriver();
        doInternalOrder();
    }

    @Test
    public void checkOpenMainPageFromMainFirefoxTest() {
        driver = new FirefoxDriver();
        doInternalMain();
    }
    @Test
    public void checkOpenMainPageFromOrderFirefoxTest() {
        driver = new FirefoxDriver();
        doInternalOrder();
    }

    private void doInternalMain() {
        driver.manage().window().maximize();
        driver.get(URL_MAIN);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSamokatLogo();
        assertEquals(URL_MAIN, driver.getCurrentUrl());
    }



    private void doInternalOrder() {
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
