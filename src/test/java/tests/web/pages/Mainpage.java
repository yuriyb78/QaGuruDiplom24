package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Mainpage {

    public final SelenideElement btnCatalog= $("[data-qa='header_catalog_nav_open_btn']"),
                                rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']");

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
}
