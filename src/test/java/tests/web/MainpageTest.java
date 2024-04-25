package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.*;
import tests.web.pages.components.CheckMainpage;
import tests.web.utils.ChooseClientCity;

public class MainpageTest extends BaseTests{

    Mainpage mainpage = new Mainpage();
    CheckMainpage checkMainpage = new CheckMainpage();
    ChooseClientCity chooseClientCity = new ChooseClientCity();

    @Feature("Проверка главной страницы")
    @Story("Смена города покупателя")
    @DisplayName("Проверить смену города покупателя")
    @Tag("All")
    @Tag("Mainpage")
    @Test
    void changeCityTest () {
        String nameCity = chooseClientCity.getCityName();
        mainpage.openMainPage()
                .openSelectCity()
                .setInputCity(nameCity);

        checkMainpage.checkCityName(nameCity);
    }

}
