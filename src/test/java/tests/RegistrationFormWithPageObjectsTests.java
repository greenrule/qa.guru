package tests;
//домашка 2
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Ivanov";
    String userEmail ="Alex@test.com";
    String userNumber ="7904540014";
    String subjectsText ="888";
    String currentAddress = "999999";
    String state = "NCR";
    String city = "Delhi";
    String picturePath = "img/1.jpg";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .genderClick()
                .setUserNumber(userNumber);
        registrationPage.setBirthDay("30", "July", "2008");
        registrationPage.setSubjectsInput(subjectsText)
                .sportsClick()
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitButtonClick();


        registrationPage.checkForm("Student Name", firstName + " "+ lastName)
                        .checkForm("Student Email", userEmail)
                        .checkForm("Gender", "Male")
                        .checkForm("Mobile", userNumber)
                        .checkForm("Date of Birth", "30 July,2008")
                        .checkForm("Hobbies", "Sports")
                        .checkForm("Picture", "1.jpg")
                        .checkForm("Address", currentAddress)
                        .checkForm("State and City", state + " "+ city);

        /* $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Alex Ivanov"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("Alex@test.com"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("7904540014"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("30 July,2008"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("999999"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("NCR Delhi"));*/


    }
}
