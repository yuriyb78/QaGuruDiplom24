package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mainpage {

    public final SelenideElement btnCatalog= $("[data-qa='header_catalog_nav_open_btn']");

    @Step("Открываем главную страницу сайта компании Sokolov")
    public Mainpage openMainPage() {
        open("");
        return this;
    }

    @Step("Открываем каталог компании Sokolov")
    public Mainpage openCatalog () {
        btnCatalog.click();
        return this;
    }
}
