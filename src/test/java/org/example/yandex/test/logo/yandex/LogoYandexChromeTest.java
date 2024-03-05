package org.example.yandex.test.logo.yandex;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoYandexChromeTest extends BaseLogoYandexTest {

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
}
