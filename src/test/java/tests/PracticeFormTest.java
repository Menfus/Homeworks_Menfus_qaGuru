package tests;


import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import org.junit.jupiter.api.Tag;


import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;



    public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    //Создаем рандомные данные через библиотеку Faker
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    //String gender = faker.options().option("Male", "Female", "Other");
    String gender = "Male";
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().digits(10);
    String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    String birthMonth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    String birthYear = String.valueOf(faker.number().numberBetween(1950, 2000));

    String subject = faker.options().option(
            "Chemistry", "Maths", "Physics", "Arts", "English",
            "Biology", "History", "Economics", "Computer Science", "Commerce", "Accounting");
    String hobby = "Sport";
    //String hobby = faker.options().option("Sport", "Reading", "Music");
    String streetAddress = faker.address().streetAddress();
    String state = "Haryana";
    String city = "Karnal";

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Tag("simple")
    @Feature("Форма регистрации")
    @Story("Успешная отправка формы")
    @Owner("Menfus")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка Формы регистрации с помощью Lambda шагов")
    @Test
    void successfulRegistrationTest() {

        step("Заполняем поля регистрационной формы", () -> {

            registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setUserNumber(userNumber)
                    .setGender(gender)
                    .setDateOfBirth(birthDay, birthMonth, birthYear)
                    .setSubjects(subject)
                    .setHobby(hobby)
                    .setPicture("testIMG.png")
                    .setAdress(streetAddress)
                    .setState(state)
                    .setCity(city)
                    .getSubmit();
        });
        step("Проверяем отправленные значения в полях регистрационной формы", () -> {

            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .checkResult("Subjects", subject)
                    .checkResult("Picture", "testIMG.png")
                    .checkResult("Address", streetAddress)
                    .checkResult("State and City", state + " " + city)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Gender", gender);
        });
    }

}




