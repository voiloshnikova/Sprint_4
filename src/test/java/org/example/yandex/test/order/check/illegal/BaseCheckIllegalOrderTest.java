package org.example.yandex.test.order.check.illegal;

import org.example.yandex.pom.MainPage;
import org.example.yandex.pom.TrackPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

public class BaseCheckIllegalOrderTest {

    protected WebDriver driver;

    void doInternal(){
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
