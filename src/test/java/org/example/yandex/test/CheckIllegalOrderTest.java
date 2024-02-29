package org.example.yandex.test;

import org.example.yandex.pom.MainPage;
import org.example.yandex.pom.TrackPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertTrue;

public class CheckIllegalOrderTest {
    private WebDriver driver;

    @Test
    public void checkIllegalOrderChromeTest() {
        driver = new ChromeDriver();
        doInternal();
    }

    @Test
    public void checkIllegalOrderFirefoxTest() {
        driver = new FirefoxDriver();
        doInternal();
    }

    private void doInternal(){
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.trackOrder("234");

        TrackPage objTrackPage = new TrackPage(driver);
        assertTrue(objTrackPage.checkTrackNotFoundImgDisplayed());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
