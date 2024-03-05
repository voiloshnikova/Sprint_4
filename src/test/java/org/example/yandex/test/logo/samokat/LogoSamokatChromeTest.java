package org.example.yandex.test.logo.samokat;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class LogoSamokatChromeTest extends BaseLogoSamokatTest {

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
