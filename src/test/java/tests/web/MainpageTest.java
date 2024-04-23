package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.web.pages.*;
import tests.web.pages.components.CheckMainpage;

public class MainpageTest extends BaseTests{

    Mainpage mainpage = new Mainpage();
    CheckMainpage checkMainpage = new CheckMainpage();

    @Feature("Проверка главной страницы")
    @Story("Смена города покупателя")
    @DisplayName("Проверить смену города покупателя")
    @Test
    void changeCityTest () {
        mainpage.openMainPage()
                .openSelectCity()
                .setInputCity();

        checkMainpage.checkCityName();
    }

}
