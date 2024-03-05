package org.example.yandex.test.order.create;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class CreateOrderFirefoxTest extends BaseCreateOrderTest {

    public CreateOrderFirefoxTest(String name, String surname, String address, String metro, String telephone, String data, String color, String delivery) {
        super(name, surname, address, metro, telephone, data, color, delivery);
    }

    @Test
    public void createOrderByHeaderButtonFirefox() {
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        createHeaderOrder();
    }

    @Test
    public void createOrderByMainButtonFirefox() {
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        createMainOrder();
    }
}
