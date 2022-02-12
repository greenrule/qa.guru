package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Alex@test.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7904540014");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("888"); //исчезает(?)
        $(byText("Sports")).click();
        $("#uploadPicture").setValue("C:\\Users\\Marina\\Desktop\\1.jpg");
        $("#currentAddress").setValue("999999");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Alex Ivanov"));
        $(".table-responsive").shouldHave(text("Alex@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7904540014"));
        $(".table-responsive").shouldHave(text("3 February,2022"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.jpg"));
        $(".table-responsive").shouldHave(text("999999"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}
