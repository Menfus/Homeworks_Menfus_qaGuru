package Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;


public class TestPracticeForm {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 5000; // default 4000
        }

        @Test
        void fillFormTest() throws InterruptedException {
            open("/automation-practice-form");//Открываем нужный URL
            $(byText("Practice Form"));// Проверка что мы находимся на "Practice Form"
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); //Доп. проверка формы "practice-form-wrapper" - убедиться что находимся на нужной странице
            $("#firstName").setValue("Kazeshini"); //Заполняем первый инпут "First Name"
            $("#lastName").setValue("Menfus"); //Заполняем input "Last Name"
            $("#userEmail").setValue("Menfus369@gmail.com"); //Заполняем input "Email"

            $(by("for","gender-radio-1")).click();//Кликаем 1 радиобаттон

            $("#userNumber").setValue("9091015433");//Вводим номер тлф

            $("#dateOfBirthInput").click();//Кликаем input календарь - вылазит окно
            $(".react-datepicker__month-select").selectOption("December");//Выставляем Месяц
            $(".react-datepicker__year-select").selectOption("2001");//Год
            $("div.react-datepicker__week").$(".react-datepicker__day--028").click();//Число (Через класс неделя)

            $("#subjectsInput").val("M");//Находим поле Input - прописываем символ
            $("#subjectsInput").pressTab();//С помощью табуляции заполняем форму 1-ым предметом из сортировочного списка
            $("#subjectsInput").val("P");
            $("#subjectsInput").pressTab();

            $(by("for","hobbies-checkbox-1")).click();//Кликаем 1-ый Check box

            $("#currentAddress").setValue("Belinskogo 13");
            $("#state").click();
            $(byText("Haryana")).click();
            $("#city").click();
            $(byText("Karnal")).click();
            $("#submit").click();
            $("html").shouldHave(text("Thanks for submitting the form"));
            sleep(4000);
            $("#closeLargeModal").click();


        }
    }












