package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {

    private final SelenideElement chooseItem = $("[class^='ProductListItem_product-link']");

    @Step("Открываю страницу каталога Кольца")
    public CatalogPage openPageWithItemRings () {
        open("/jewelry-catalog/rings/");
        return this;
    }

    @Step("Выбираю изделие из каталога")
    public void chooseItemFromCatalog () {
        chooseItem.click();
    }
}