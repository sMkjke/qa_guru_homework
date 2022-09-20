package com.github.smkjke;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.smkjke.entity.SampleUser;
import com.github.smkjke.entity.enums.Hobbies;
import com.github.smkjke.entity.enums.Subjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDate;
import java.util.List;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.github.smkjke.entity.SampleUser.newBuilder;

public class DemoqaPracticeFormTest {

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
        open("/automation-practice-form");
        $x(".//input[@id='firstName']").setValue(sampleUser.getFirstName());
        $x(".//input[@id='lastName']").setValue(sampleUser.getLastName());
        $x(".//input[@id='userEmail']").setValue(sampleUser.getEmail());
        $x(String.format(".//input[@value='%s' and @name='gender']/following-sibling::label", sampleUser.getGender())).click();
        $x(".//input[@id='userNumber']").setValue(sampleUser.getPhoneNumber());
        $x(".//input[@id='dateOfBirthInput']").click();
        $x(".//select[contains(@class,'react-datepicker__month-select')]").selectOptionByValue(String.valueOf(sampleUser.getDateOfBirth().getMonthValue() - 1));
        $x(".//select[contains(@class,'react-datepicker__year-select')]").selectOptionByValue(String.valueOf(sampleUser.getDateOfBirth().getYear()));
        $x(String.format(".//div[contains(@class,'react-datepicker__day react-datepicker__day--0%d')]", sampleUser.getDateOfBirth().getDayOfMonth())).click();
        sampleUser.getSubjects().forEach(a -> getSubject(a).sendKeys(Keys.ENTER));
        sampleUser.getHobbies().forEach(a -> getHobby(a).click());
        $x(".//input[@id='uploadPicture']").uploadFile(sampleUser.getFile());
        $x(".//textarea[@id='currentAddress']").setValue(sampleUser.getCurrentAddress());
        $x(".//div[@id='state']").click();
        $x(String.format(".//div[contains(text()[normalize-space()], '%s')]", sampleUser.getState())).click();
        $x(".//div[@id='city']").click();
        $x(String.format(".//div[contains(text()[normalize-space()], '%s')]", sampleUser.getCity())).click();
        $x(".//button[@id='submit']").click();

        //check values
        checkValue("Student Name", sampleUser.getFirstName() + " " + sampleUser.getLastName());
        checkValue("Student Email", sampleUser.getEmail());
        checkValue("Gender", sampleUser.getGender());
        checkValue("Mobile", sampleUser.getPhoneNumber());
        checkValue("Date of Birth", sampleUser.getFullBirthdayDateWithFormat());
        checkValue("Subjects", sampleUser.getSubjects().toString().replace("[","").replace("]",""));
        checkValue("Hobbies", sampleUser.getHobbies().toString().replace("[","").replace("]",""));
        checkValue("Picture", sampleUser.getFile().getName());
        checkValue("Address", sampleUser.getCurrentAddress());
        checkValue("State and City", sampleUser.getState() + " " + sampleUser.getCity());
    }

    private WebElement getSubject(Subjects subjects) {
        return $x(".//div[contains(@class,'subjects-auto-complete__input')]//input").setValue(subjects.toString());
    }

    private WebElement getHobby(Hobbies hobbies) {
        return $x(String.format(".//label[contains(text()[normalize-space()], '%s')]", hobbies.toString()));
    }

    private void checkValue(String field, String value) {
        $x(String.format(".//td[contains(text()[normalize-space()], '%s')]/following-sibling::td", field)).shouldHave(Condition.text(value));
    }
}
