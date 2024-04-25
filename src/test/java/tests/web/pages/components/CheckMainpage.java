package tests.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.web.utils.ChooseClientCity;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckMainpage {

    private final SelenideElement btnSelectCity = $("[data-qa='header_city_select_btn']");

    @Step("Проверяю что введенное название города {nameCity} отображется на главной странице")
    public void checkCityName (String nameCity) {
        btnSelectCity.shouldHave(text(nameCity));
    }
}
