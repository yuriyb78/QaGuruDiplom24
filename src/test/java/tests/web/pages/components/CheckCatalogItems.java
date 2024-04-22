package tests.web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CheckCatalogItems {

    private final SelenideElement rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
            catalogHeaderTitle = $("[class^='styles_catalog-layout-header_title']");

    private final ElementsCollection productList = $$("[data-qa='product-list']");

    @Step("Проверяем наличие пункта меню {menuElementName}")
    public void menuShouldHaveMenuElement (String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).shouldBe(exist,visible);

    }

    @Step("Проверяем что заголовок окна с изделиям имеет значение {menuElementName}")
    public CheckCatalogItems checkHeaderTitle (String menuElementName) {
        catalogHeaderTitle.shouldHave(text(menuElementName));
        return this;
    }

    @Step ("Проверяем что страница с изделиями не пуста")
    public void checkProductList () {
        productList.shouldBe(sizeGreaterThan(0));

    }

}
