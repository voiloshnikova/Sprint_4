package org.example.yandex.test;

import org.example.yandex.pom.MainPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
    private final String question;
    private final String response;
    private final String questionId;
    private final String responseId;
    private WebDriver driver;

    public ImportantQuestionsTest(String questionId, String responseId, String question, String response) {
        this.question = question;
        this.response = response;
        this.questionId = questionId;
        this.responseId = responseId;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][]{
                {"accordion__heading-0", "accordion__panel-0", "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "accordion__panel-1", "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"accordion__heading-2", "accordion__panel-2", "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"accordion__heading-3", "accordion__panel-3", "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-4", "accordion__panel-4", "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"accordion__heading-5", "accordion__panel-5", "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"accordion__heading-6", "accordion__panel-6", "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                // Оригинальный вопрос со страницы, содержит ошибку в слове "живу", тест будет работать пока разрабы не починят todo удалить после фикса
                {"accordion__heading-7", "accordion__panel-7", "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                // Вопрос без ошибок, тест будет падать пока разрабы не пофиксят
                {"accordion__heading-7", "accordion__panel-7", "Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkQuestionChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        doInternalStuff();
    }

    @Test
    public void checkQuestionFirefox() {
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        doInternalStuff();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

    private void doInternalStuff() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создание объекта главной страницы приложения
        MainPage objMainPage = new MainPage(driver);
        // проверка вопроса
        assertEquals(this.question, objMainPage.getTextQuestion(this.questionId));
        // проверка ответа на вопрос
        assertEquals(this.response, objMainPage.getResponse(this.questionId, this.responseId));
    }
}