package pages.components;


import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
public class TextBoxPage {
    private SelenideElement firstNameInput = $("#userName"),
    mailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    clickSubmit = $("#submit");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }
    public TextBoxPage setMail(String value) {
        mailInput.setValue(value);

        return this;
    }

    public TextBoxPage setFirstAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setSecondAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setName(String value) {
        firstNameInput.setValue(value);

        return this;
    }


    public TextBoxPage clickSubmit() {
        clickSubmit.click();

        return this;
    }

    public TextBoxPage check(String value) {
        $("#output").shouldHave(text(value));
        return this;
    }



}
