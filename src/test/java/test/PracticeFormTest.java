package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static com.codeborne.selenide.Selectors.byText;



public class PracticeFormTest {

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

        $(by("for", "gender-radio-1")).click();//Кликаем 1 радиобаттон

        $("#userNumber").setValue("9091015433");//Вводим номер тлф

        $("#dateOfBirthInput").click();//Кликаем input календарь - вылазит окно
        $(".react-datepicker__month-select").selectOption("December");//Выставляем Месяц
        $(".react-datepicker__year-select").selectOption("2001");//Год
        $("div.react-datepicker__week").$(".react-datepicker__day--028").click();//Число (Через класс неделя)

        $("#subjectsInput").val("M");//Находим поле Input - прописываем символ
        $("#subjectsInput").pressTab();//С помощью табуляции заполняем форму 1-ым предметом из сортировочного списка
        $("#subjectsInput").setValue("P");//Находим поле Input - прописываем символ
        $("#react-select-2-option-0").click(); //С помощью локатора ID

        $(by("for", "hobbies-checkbox-1")).click();//Кликаем 1-ый Check box
        $("#uploadPicture").uploadFromClasspath("testIMG.png"); // Загрузка картинки

        $("#currentAddress").setValue("Belinskogo 13");
        $("#state").click();
        $(byText("Haryana")).click(); // С помощью byText находим нужный нам элемент для клика в выплывающем баре выбора
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click(); // Отправить форму


        // Провека валидности данных формы после отправки
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Kazeshini Menfus"));// Находим локатор всей формы .table-responsive далее с помощью метода byText внутри этого элемента ищем текст--> А текст в элементе ищем через родительский элемент и shouldHave-"Должен иметь"
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Menfus369@gmail.com")); //Проверка почты
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male")); //Проверка почты
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9091015433"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 November,2001"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths, Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testIMG.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Belinskogo 13"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
        $("html").shouldHave(text("Thanks for submitting the form"));
        sleep(4000); //Оставить форму открытой на 4 сек
        $("#closeLargeModal").click(); //Закрыть форму
    }
}

