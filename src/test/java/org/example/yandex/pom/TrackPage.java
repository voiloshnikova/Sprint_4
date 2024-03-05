package org.example.yandex.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrackPage {
    private final WebDriver driver;

//    private final By TRACK_NOT_FOUND = By.className("Track_NotFound__6oaoY");
    private final By TRACK_NOT_FOUND = By.xpath("//img[@src='/assets/not-found.png']");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
        new CookiePopup(driver).acceptCookieIfNecessary();
    }

    public boolean checkTrackNotFoundImgDisplayed() {
        return driver.findElement(TRACK_NOT_FOUND).isDisplayed();
    }
}
