package org.example.yandex.test.order.create;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class CreateOrderChromeTest extends BaseCreateOrderTest {

    public CreateOrderChromeTest(String name, String surname, String address, String metro, String telephone, String data, String color, String delivery) {
        super(name, surname, address, metro, telephone, data, color, delivery);
    }

    @Test
    public void createOrderByHeaderButtonChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        createHeaderOrder();
    }

    @Test
    public void createOrderByMainButtonChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        createMainOrder();
    }
}
