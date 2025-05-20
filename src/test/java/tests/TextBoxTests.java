package tests;
import org.junit.jupiter.api.Test;
import pages.components.TextBoxPage;

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

