package org.example.yandex.test.order.check.illegal;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckIllegalOrderFirefoxTest extends BaseCheckIllegalOrderTest {

    @Test
    public void checkIllegalOrderFirefoxTest() {
        driver = new FirefoxDriver();
        doInternal();
    }
}
