package tests.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement chooseItem = $("[class^='ProductListItem_product-link']"),
            rightCatalogMenu = $("[class^='RightNav_catalog-menu_right-el-wrapper']"),
            catalogHeaderTitle = $("[class^='styles_catalog-layout-header_title']");

    private final ElementsCollection productList = $$("[data-qa='product-list']");

    @Step("Открыть страницу каталога 'Кольца'")
    public CatalogPage openPageWithItemRings() {
        open("/jewelry-catalog/rings/");
        return this;
    }

    @Step("Выбрать изделие из каталога")
    public void chooseItemFromCatalog() {
        chooseItem.click();
    }

    @Step("Проверить наличие пункта меню {menuElementName}")
    public void menuShouldHaveMenuElement(String menuElementName) {
        rightCatalogMenu.find(byText(menuElementName)).shouldBe(exist, visible);

    }

    @Step("Проверить что заголовок окна с изделиям имеет значение {menuElementName}")
    public CatalogPage checkHeaderTitle(String menuElementName) {
        catalogHeaderTitle.shouldHave(text(menuElementName));
        return this;
    }

    @Step("Проверить что страница с изделиями не пуста")
    public void checkProductList() {
        productList.shouldBe(sizeGreaterThan(0));

    }


}