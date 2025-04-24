package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $(by("for", "gender-radio-1")),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectInputP = $("#react-select-2-option-0"),
            hobbyCheckBox = $(by("for", "hobbies-checkbox-1")),
            pictureUpload = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateHaryana = $(byText("Haryana")),
            cityInput = $("#city"),
            cityKarnal = $(byText("Karnal")),
            sumbitButton = $("#submit"),
            closeButton = $("#closeLargeModal");


    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender() {
        genderWrapper.click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressTab();
        subjectsInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubjectP(String value) {
        subjectsInput.setValue(value);
        subjectInputP.click();

        return this;
    }


    public RegistrationPage setHobby() {
        hobbyCheckBox.click();
        return this;
    }


    public RegistrationPage setPicture(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }


    public RegistrationPage setAdress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState() {
        stateInput.click();
        stateHaryana.click();
        return this;
    }

    public RegistrationPage setCity() {
        cityInput.click();
        cityKarnal.click();
        return this;
    }

    public RegistrationPage getSubmit() {
        sumbitButton.click();
        return this;
    }

    public RegistrationPage getClose() {
        closeButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}