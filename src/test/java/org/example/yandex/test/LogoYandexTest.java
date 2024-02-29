package org.example.yandex.test;

import org.example.yandex.pom.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LogoYandexTest {
    public static final String URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    public static final String URL_ORDER = "https://qa-scooter.praktikum-services.ru/order";
    public static final String URL_YANDEX = "https://dzen.ru/?yredirect=true";

    private WebDriver driver;

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



    private void doInternalOrder() {
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
