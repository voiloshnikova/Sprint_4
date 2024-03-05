package org.example.yandex.test.logo.samokat;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LogoSamokatFirefoxTest extends BaseLogoSamokatTest {

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
