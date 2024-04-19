package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.CatalogPage;
import tests.web.pages.Mainpage;
import tests.web.pages.ProductCard;
import tests.web.pages.components.CheckCatalogItems;

public class SokolovSiteTest extends BaseTests{

    Mainpage mainpage = new Mainpage();
    CheckCatalogItems checkCatalogItems = new CheckCatalogItems();
    CatalogPage catalogPage = new CatalogPage();
    ProductCard productCard = new ProductCard();

    @Feature("Проверка сайта")
    @Story("Проверка раздела Каталог на наличие элемента")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog();
        checkCatalogItems.menuShouldHaveMenuElement(menuElementName);

    }

    @Feature("Проверка сайта")
    @Story("Проверка что при переходе из меню Каталога на странице отображаются карточки изделий ")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить отображение карточек изделий в пункте меню {0}")
    void checkClickMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog()
                .clickMenuItem(menuElementName);
        checkCatalogItems.checkHeaderTitle(menuElementName)
                .checkProductList();

    }

    @Feature("Проверка сайта")
    @Story("Добавление изделия в корзину")
    @DisplayName("Проверить добавление изделия в корзину")
    @Test
    void checkAddItemInProductBasket () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();

        productCard.chooseSizeItem()
                .addToBasket();

    }
}
