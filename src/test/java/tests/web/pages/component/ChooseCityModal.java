package tests.web.pages.component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ChooseCityModal {

    private final SelenideElement inputCity = $(".react-select__input");
    private final ElementsCollection selectMenu = $$(".react-select__menu");

    @Step("Ввести название города {nameCity} в строку поиска")
    public void setInputCity(String nameCity) {
        inputCity.click();
        inputCity.setValue(nameCity);
        selectMenu.find(text(nameCity)).shouldHave(exist, Duration.ofSeconds(3));
        inputCity.pressEnter();
    }
}
