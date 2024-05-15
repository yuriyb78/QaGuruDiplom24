package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.MainpagePage;
import tests.web.pages.component.ChooseCityModal;
import tests.web.utils.ChooseClientCity;

@Feature("Проверка главной страницы")
@Tag("Mainpage")
@Tag("All")
public class MainpageTest extends BaseTests {

    MainpagePage mainpagePage = new MainpagePage();
    ChooseClientCity chooseClientCity = new ChooseClientCity();
    ChooseCityModal chooseCityModal = new ChooseCityModal();

    @Story("Смена города покупателя")
    @DisplayName("Проверить смену города покупателя")
    @Test
    void changeCityTest() {
        String nameCity = chooseClientCity.getCityName();
        mainpagePage.openMainPage()
                .openSelectCity();

        chooseCityModal.setInputCity(nameCity);

        mainpagePage.checkCityName(nameCity);
    }

}
