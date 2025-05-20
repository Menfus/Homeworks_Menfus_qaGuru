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

<<<<<<< HEAD
@Tag("simplee")
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
=======


    
>>>>>>> cc80804fd55e0f8c0979b25a499403830ab4344b

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Feature("Форма регистрации")
    @Story("Успешная отправка формы")
    @Owner("Menfus")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка Формы регистрации с помощью Lambda шагов")
    @Test
    void successfulRegistrationTest() {

        step("Заполняем поля регистрационной формы", () -> {

           $("#firstName").setValue("Alex");
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("alex@egorov.com");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2008");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            $("#currentAddress").setValue("Some address 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Проверяем отправленные значения в полях регистрационной формы", () -> {

             $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
                    text("alex@egorov.com"), text("1234567890"));
        });
    }
}








