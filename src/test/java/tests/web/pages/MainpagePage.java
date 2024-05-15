package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainpagePage {

    private final SelenideElement btnCatalog = $("[data-qa='header_catalog_nav_open_btn']"),
            rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
            btnSelectCity = $("[data-qa='header_city_select_btn']");


    @Step("Открыть главную страницу сайта компании Sokolov")
    public MainpagePage openMainPage() {
        open("");
        return this;
    }

    @Step("Открыть меню каталога изделий")
    public MainpagePage openCatalog() {
        btnCatalog.click();
        return this;
    }

    @Step("Перейти в пункт меню {menuElementName}")
    public void clickMenuItem(String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).click();

    }

    @Step("Открыть окно выбора города покупателя")
    public MainpagePage openSelectCity() {
        btnSelectCity.click();
        return this;
    }

    @Step("Проверить что введенное название города {nameCity} отображется на главной странице")
    public void checkCityName(String nameCity) {
        btnSelectCity.shouldHave(text(nameCity));
    }

}
