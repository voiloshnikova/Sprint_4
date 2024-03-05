package org.example.yandex.test.question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ImportantQuestionsChromeTest extends BaseImportantQuestionTest {

    public ImportantQuestionsChromeTest(String questionId, String responseId, String question, String response) {
        super(questionId, responseId, question, response);
    }

    @Test
    public void checkQuestionChrome() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        doInternalStuff();
    }
}