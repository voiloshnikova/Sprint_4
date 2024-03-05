package org.example.yandex.test.logo.yandex;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogoYandexFirefoxTest extends BaseLogoYandexTest {

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
}
