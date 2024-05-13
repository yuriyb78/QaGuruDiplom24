package tests.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CheckingItemsOnCatalogPage {

    private final SelenideElement rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
            catalogHeaderTitle = $("[class^='styles_catalog-layout-header_title']");

    private final ElementsCollection productList = $$("[data-qa='product-list']");

    @Step("Проверить наличие пункта меню {menuElementName}")
    public void menuShouldHaveMenuElement(String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).shouldBe(exist, visible);

    }

    @Step("Проверить что заголовок окна с изделиям имеет значение {menuElementName}")
    public CheckingItemsOnCatalogPage checkHeaderTitle(String menuElementName) {
        catalogHeaderTitle.shouldHave(text(menuElementName));
        return this;
    }

    @Step("Проверить что страница с изделиями не пуста")
    public void checkProductList() {
        productList.shouldBe(sizeGreaterThan(0));

    }

}
