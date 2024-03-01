package com.udilov.it.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {

        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month").click();
    }
}
