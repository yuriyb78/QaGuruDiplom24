package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {

    private final SelenideElement chooseItem = $("[class^='ProductListItem_product-link']");

    public CatalogPage openPageWithItemRings () {
        open("/jewelry-catalog/rings/");
        return this;
    }

    public CatalogPage chooseItemFromCatalog () {
        chooseItem.click();
        return this;
    }
}