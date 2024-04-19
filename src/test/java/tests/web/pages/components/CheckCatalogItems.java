package tests.web.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CheckCatalogItems {

    public final SelenideElement rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
                    catalogHeaderTitle = $("[class^='styles_catalog-layout-header_title']"),
                    productList = $("[data-qa='product-list']");
    @Step("Проверяем наличие пункта меню {menuElementName}")
    public void menuShouldHaveMenuElement (String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).shouldHave(exist,visible);

    }

    @Step("Проверяем что заголовок окна с изделиям имеет значение {menuElementName}")
    public CheckCatalogItems checkHeaderTitle (String menuElementName) {
        catalogHeaderTitle.shouldHave(text(menuElementName));
        return this;
    }

    @Step ("Провеяем что страница с изделиями не пуста")
    public CheckCatalogItems checkProductList () {
        $$("[data-qa='product-list']").shouldBe(sizeGreaterThan(0));
        return this;
    }

}
