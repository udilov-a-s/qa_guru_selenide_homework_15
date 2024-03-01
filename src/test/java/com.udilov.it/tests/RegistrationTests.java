package com.udilov.it.tests;

import com.udilov.it.data.TestDataForRegistrationTests;
import com.udilov.it.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataForRegistrationTests testDataForRegistrationTests = new TestDataForRegistrationTests();

    @Test
    @Owner("Udilov_a_s")
    @Feature("Форма регистрации")
    @Story("Проверка формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение всех полей формы")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("POSITIVE")
    })
    void fullRegistrationTest() {

        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Full fill form", () -> {
            registrationPage.setFirstName(testDataForRegistrationTests.firstName)
                    .setLastName(testDataForRegistrationTests.lastName)
                    .setEmail(testDataForRegistrationTests.email)
                    .setGender(testDataForRegistrationTests.gender)
                    .setUserNumber(testDataForRegistrationTests.mobileNumber)
                    .setDateOfBirth(testDataForRegistrationTests.birthDay, testDataForRegistrationTests.birthMonth,
                            testDataForRegistrationTests.birthYear)
                    .setSubjects(testDataForRegistrationTests.subjects)
                    .setHobbies(testDataForRegistrationTests.hobbies)
                    .setPicture(testDataForRegistrationTests.picture)
                    .setAddress(testDataForRegistrationTests.currentAddress)
                    .setState(testDataForRegistrationTests.state)
                    .setCity(testDataForRegistrationTests.city);
        });
        step("Submit form", () -> {
            registrationPage.submitForm();
        });
        step("Check result", () -> {
            registrationPage.checkResult("Student Name", testDataForRegistrationTests.firstName + " "
                    + testDataForRegistrationTests.lastName)
                    .checkResult("Student Email", testDataForRegistrationTests.email)
                    .checkResult("Gender", testDataForRegistrationTests.gender)
                    .checkResult("Mobile", testDataForRegistrationTests.mobileNumber)
                    .checkResult("Date of Birth", testDataForRegistrationTests.birthDay + " "
                            + testDataForRegistrationTests.birthMonth + "," + testDataForRegistrationTests.birthYear)
                    .checkResult("Subjects", testDataForRegistrationTests.subjects)
                    .checkResult("Hobbies", testDataForRegistrationTests.hobbies)
                    .checkResult("Picture", testDataForRegistrationTests.picture)
                    .checkResult("Address", testDataForRegistrationTests.currentAddress)
                    .checkResult("State and City", testDataForRegistrationTests.state + " "
                            + testDataForRegistrationTests.city);
        });
    }

    @Test
    @Owner("Udilov_a_s")
    @Feature("Форма регистрации")
    @Story("Проверка формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение обязательных полей формы")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    void minimalRegistrationTest() {

        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Minimal fill form", () -> {
            registrationPage.setFirstName(testDataForRegistrationTests.firstName)
                    .setLastName(testDataForRegistrationTests.lastName)
                    .setGender(testDataForRegistrationTests.gender)
                    .setUserNumber(testDataForRegistrationTests.mobileNumber);
        });
        step("Submit form", () -> {
            registrationPage.submitForm();
        });
        step("Check result", () -> {
            registrationPage.checkResult("Student Name", testDataForRegistrationTests.firstName + " "
                    + testDataForRegistrationTests.lastName)
                    .checkResult("Gender", testDataForRegistrationTests.gender)
                    .checkResult("Mobile", testDataForRegistrationTests.mobileNumber);
        });
    }

    @Test
    @Owner("Udilov_a_s")
    @Feature("Форма регистрации")
    @Story("Проверка формы регистрации")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Все поля формы не заполнены")
    @Tags({
            @Tag("WEB"),
            @Tag("NEGATIVE")
    })
    void emptyRegistrationTest() {

        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Submit form", () -> {
            registrationPage.submitForm();
        });
        step("Check results", () -> {
            registrationPage.checkValidation();
        });
    }
}
