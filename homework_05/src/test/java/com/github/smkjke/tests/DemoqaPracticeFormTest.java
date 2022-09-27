package com.github.smkjke.tests;

import com.codeborne.selenide.Configuration;
import com.github.smkjke.entity.SampleUser;
import com.github.smkjke.entity.enums.Hobbies;
import com.github.smkjke.entity.enums.Subjects;
import com.github.smkjke.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import static com.github.smkjke.entity.SampleUser.newBuilder;

public class DemoqaPracticeFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    SampleUser sampleUser = newBuilder()
            .firstName("Vasya")
            .lastName("Pupkin")
            .email("vasya@com.ru")
            .gender("Male")
            .phoneNumber("8999999992")
            .dateOfBirth(LocalDate.of(1988, 12, 17))
            .subject(List.of(Subjects.Maths, Subjects.Economics, Subjects.English))
            .hobbies(List.of(Hobbies.Music, Hobbies.Reading, Hobbies.Sports))
            .currentAddress("Moskow, Lenina str, 7,1")
            .state("NCR")
            .city("Delhi")
            .file(new File("src/test/resources/cat.jpg"))
            .build();


    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillDemoqaAutomationPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName(sampleUser.getFirstName())
                .setLastName(sampleUser.getLastName())
                .setEmail(sampleUser.getEmail())
                .setGender(sampleUser.getGender())
                .setPhoneNumber(sampleUser.getPhoneNumber())
                .setBirthDate(sampleUser.getDateOfBirth().getDayOfMonth(),
                        String.valueOf(sampleUser.getDateOfBirth().getMonthValue() - 1),
                        String.valueOf(sampleUser.getDateOfBirth().getYear()))
                .setSubjects(sampleUser.getSubjects())
                .setHobbies(sampleUser.getHobbies())
                .uploadFile(sampleUser.getFile())
                .setCurrentAddress(sampleUser.getCurrentAddress())
                .setState(sampleUser.getState())
                .setCity(sampleUser.getCity())
                .submit();


//        open("/automation-practice-form");
//        $x(".//input[@id='firstName']").setValue(sampleUser.getFirstName());
//        $x(".//input[@id='lastName']").setValue(sampleUser.getLastName());
//        $x(".//input[@id='userEmail']").setValue(sampleUser.getEmail());
//        $x(String.format(".//input[@value='%s' and @name='gender']/following-sibling::label", sampleUser.getGender())).click();
//        $x(".//input[@id='userNumber']").setValue(sampleUser.getPhoneNumber());
//        $x(".//input[@id='dateOfBirthInput']").click();
//        $x(".//select[contains(@class,'react-datepicker__month-select')]").selectOptionByValue(String.valueOf(sampleUser.getDateOfBirth().getMonthValue() - 1));
//        $x(".//select[contains(@class,'react-datepicker__year-select')]").selectOptionByValue(String.valueOf(sampleUser.getDateOfBirth().getYear()));
//        $x(String.format(".//div[contains(@class,'react-datepicker__day react-datepicker__day--0%d')]", sampleUser.getDateOfBirth().getDayOfMonth())).click();
//        sampleUser.getSubjects().forEach(a -> getSubject(a).sendKeys(Keys.ENTER));
//        sampleUser.getHobbies().forEach(a -> getHobby(a).click());
//        $x(".//input[@id='uploadPicture']").uploadFile(sampleUser.getFile());
//        $x(".//textarea[@id='currentAddress']").setValue(sampleUser.getCurrentAddress());
//
//        $x(".//div[@id='state']").click();
//        $x(String.format(".//div[contains(text()[normalize-space()], '%s')]", sampleUser.getState())).click();
//        $x(".//div[@id='city']").click();
//        $x(String.format(".//div[contains(text()[normalize-space()], '%s')]", sampleUser.getCity())).click();
//        $x(".//button[@id='submit']").click();


        //check values
        registrationFormPage.checkResultsTableVisible();
        registrationFormPage.checkResult("Student Name", sampleUser.getFirstName() + " " + sampleUser.getLastName())
                .checkResult("Student Email", sampleUser.getEmail())
                .checkResult("Student Name", sampleUser.getFirstName() + " " + sampleUser.getLastName())
                .checkResult("Student Email", sampleUser.getEmail())
                .checkResult("Gender", sampleUser.getGender())
                .checkResult("Mobile", sampleUser.getPhoneNumber())
                .checkResult("Date of Birth", sampleUser.getFullBirthdayDateWithFormat())
                .checkResult("Subjects", sampleUser.getSubjects().toString().replace("[", "").replace("]", ""))
                .checkResult("Hobbies", sampleUser.getHobbies().toString().replace("[", "").replace("]", ""))
                .checkResult("Picture", sampleUser.getFile().getName())
                .checkResult("Address", sampleUser.getCurrentAddress())
                .checkResult("State and City", sampleUser.getState() + " " + sampleUser.getCity());
    }
}
