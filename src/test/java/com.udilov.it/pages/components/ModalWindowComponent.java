package com.udilov.it.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {

    private final SelenideElement modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            registrationTableResults = $(".table-responsive table");

    final String modalTitleText = "Thanks for submitting the form";

    public void checkSubmitForm(String key, String value) {

        modalDialog.should(appear);
        modalTitle.shouldHave(text(modalTitleText));
        registrationTableResults.$(byText(key)).parent().shouldHave(text(value));
    }
}
