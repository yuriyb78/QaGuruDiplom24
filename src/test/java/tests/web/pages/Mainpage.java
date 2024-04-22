package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

public class Mainpage {

    private final SelenideElement btnCatalog= $("[data-qa='header_catalog_nav_open_btn']"),
                                rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
                                btnSelectCity = $("[data-qa='header_city_select_btn']"),
                                inputCity = $(".react-select__input");

    @Step("Открываем главную страницу сайта компании Sokolov")
    public Mainpage openMainPage() {
        open("");
        return this;
    }

    @Step("Открываем меню каталога изделий")
    public Mainpage openCatalog () {
        btnCatalog.click();
        return this;
    }
    @Step("Переходим в пункт меню {menuElementName}")
    public Mainpage clickMenuItem (String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).click();
        return this;
    }

    @Step("Открываю окно выбора города покупателя")
    public Mainpage openSelectCity() {
        btnSelectCity.click();
        return this;
    }

    @Step("Ввожу название города")
    public void setInputCity () {
        inputCity.click();
        inputCity.setValue("Кострома");
        sleep(2000);
        inputCity.pressEnter();
    }
}
