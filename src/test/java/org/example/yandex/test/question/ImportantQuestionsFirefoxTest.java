package org.example.yandex.test.question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class ImportantQuestionsFirefoxTest extends BaseImportantQuestionTest {

    public ImportantQuestionsFirefoxTest(String questionId, String responseId, String question, String response) {
        super(questionId, responseId, question, response);
    }

    @Test
    public void checkQuestionFirefox() {
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        doInternalStuff();
    }
}