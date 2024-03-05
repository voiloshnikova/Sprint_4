package org.example.yandex.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CookiePopup {
    private final WebDriver driver;

    private final By ACCEPT_COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    public CookiePopup(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookieIfNecessary() {
        List<WebElement> acceptCookieButtons = driver.findElements(ACCEPT_COOKIE_BUTTON);
        if (!acceptCookieButtons.isEmpty()) {
            acceptCookieButtons.get(0).click();
        }
    }
}
