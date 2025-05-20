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




