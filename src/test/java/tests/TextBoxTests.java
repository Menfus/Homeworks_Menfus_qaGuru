package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxTests extends TestBase {
    TextBoxPage TextBoxPage = new TextBoxPage();


    @Test
    void fillFormTest() {
        TextBoxPage.openPage()
                .setName("Vladimir")
                .setMail("Vladimir@putin.com")
                .setFirstAddress("Red Square")
                .setSecondAddress("Red Square 2")
                .clickSubmit();


TextBoxPage.check("Vladimir")
        .check("Vladimir@putin.com")
        .check("Red Square")
        .check("Red Square 2");
    }
}

