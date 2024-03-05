package org.example.yandex.test.order.check.illegal;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckIllegalOrderChromeTest extends BaseCheckIllegalOrderTest {

    @Test
    public void checkIllegalOrderChromeTest() {
        driver = new ChromeDriver();
        doInternal();
    }
}
