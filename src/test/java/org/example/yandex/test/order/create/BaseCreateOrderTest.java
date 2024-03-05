package org.example.yandex.test.order.create;

import org.example.yandex.pom.MainPage;
import org.example.yandex.pom.OrderPage;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class BaseCreateOrderTest {

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Наталья", "Иванова", "Москва", "Сокольники", "+79993828899", "08.02.2024", "black", "Оставить у подъезда"},
                {"Софья", "Петрова", "Москва", "ВДНХ", "+79777828899", "09.02.2024", "black", "Оставить у подъезда"},
                {"Александра", "Сидорова", "Москва", "Чистые пруды", "+79099998899", "09.02.2024", "grey", "Оставить у подъезда"}
        };
    }

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String telephone;
    private final String data;
    private final String color;
    private final String delivery;

    public BaseCreateOrderTest(String name, String surname, String address, String metro, String telephone, String data, String color, String delivery) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.telephone = telephone;
        this.data = data;
        this.color = color;
        this.delivery = delivery;
    }

    protected WebDriver driver;

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }


    void createHeaderOrder() {
        driver.manage().window().maximize();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создание объекта главной страницы приложения
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonHeaderOrder();
        doInternal();
    }

    void createMainOrder() {
        driver.manage().window().maximize();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создание объекта главной страницы приложения
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonMainOrder();
        doInternal();
    }

    private void doInternal() {
        // создание объекта страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillFirstPart(this.name, this.surname, this.address, this.metro, this.telephone);
        objOrderPage.fillSecondPart(this.data, this.color, this.delivery);
        assertTrue(objOrderPage.getOrderBookMessage().contains("Заказ оформлен"));
    }

}
