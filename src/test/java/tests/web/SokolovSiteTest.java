package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.*;
import tests.web.pages.components.CheckBasket;
import tests.web.pages.components.CheckCatalogItems;
import tests.web.pages.components.CheckFavorites;
import tests.web.pages.components.CheckMainpage;
import tests.web.utils.GetValueFromPage;

public class SokolovSiteTest extends BaseTests{

    Mainpage mainpage = new Mainpage();
    CheckCatalogItems checkCatalogItems = new CheckCatalogItems();
    CatalogPage catalogPage = new CatalogPage();
    ProductCard productCard = new ProductCard();
    CheckBasket checkBasket = new CheckBasket();
    BasketPage basketPage = new BasketPage();
    CheckMainpage checkMainpage = new CheckMainpage();
    FavoritesPage favoritesPage = new FavoritesPage();
    CheckFavorites checkFavorites= new CheckFavorites();

    @Feature("Проверка каталога")
    @Story("Проверка раздела Каталог на наличие элемента")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog();
        checkCatalogItems.menuShouldHaveMenuElement(menuElementName);

    }

    @Feature("Проверка каталога")
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

    @Feature("Проверка добавления изделия в корзину")
    @Story("Добавление изделия в корзину")
    @DisplayName("Проверить добавление изделия в корзину")
    @Test
    void checkAddItemInProductBasket () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();

        String article = new GetValueFromPage().getArticulFromProductCard();

        productCard.chooseSizeItem()
                .addToBasket()
                .clickButtonConfirmOrder();

        checkBasket.checkBasket()
                .checkArticulNumber(article);

    }

    @Feature("Проверка удаления изделия из корзины")
    @Story("Удаление изделия из корзины")
    @DisplayName("Проверить удаление изделия из корзины")
    @Test
    void checkDeleteItemFromProductBasket () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCard.chooseSizeItem()
                .addToBasket()
                .clickButtonConfirmOrder();
        basketPage.deleteFromCart();
        checkBasket.checkBasketIsEmpty();

    }

    @Feature("Проверка смены города покупателя")
    @Story("Смена города покупателя")
    @DisplayName("Проверить смену города покупателя")
    @Test
    void changeCityTest () {
        mainpage.openMainPage()
                .openSelectCity()
                .setInputCity();

        checkMainpage.checkCityName();
    }

    @Feature("Проверка добавления изделия в избранное")
    @Story("Добавление изделия в избранное")
    @DisplayName("Проверить добавление изделия в избранное")
    @Test
    void checkAddItemToFavorites () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCard.addItemToFavorites();

        String article = new GetValueFromPage().getArticulFromProductCard();

        checkFavorites.checkIconFavoritesColor()
                .checkFavoritesCounter();

        productCard.clickBthFavorites();

        checkFavorites.checkFavorites()
                .checkArticulNumber(article);

    }

    @Feature("Проверка удаления изделия из избранного")
    @Story("Удаление изделия из избранного")
    @DisplayName("Проверить удаление изделия из избранного")
    @Test
    void checkDeleteItemFromFavorites () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCard.addItemToFavorites()
                .clickBthFavorites();
        favoritesPage.deleteFromFavorites();
        checkFavorites.checkFavoritesisEmpty();
    }
}
