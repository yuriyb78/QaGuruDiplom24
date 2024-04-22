package tests.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckMainpage {

    private final SelenideElement btnSelectCity = $("[data-qa='header_city_select_btn']");

    @Step("Проверяю что введенное название города отображется на главной странице")
    public void checkCityName () {
        btnSelectCity.shouldHave(text("Кострома"));
    }
}