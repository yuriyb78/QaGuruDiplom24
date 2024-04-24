package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.web.pages.CatalogPage;
import tests.web.pages.FavoritesPage;
import tests.web.pages.ProductCard;
import tests.web.pages.components.CheckFavorites;
import tests.web.utils.GetValueFromPage;

public class FavoritesTest extends BaseTests {

    CatalogPage catalogPage = new CatalogPage();
    ProductCard productCard = new ProductCard();
    FavoritesPage favoritesPage = new FavoritesPage();
    CheckFavorites checkFavorites= new CheckFavorites();

    @Feature("Проверка работы с Избранным")
    @Story("Добавление изделия в Избранное")
    @DisplayName("Проверить добавление изделия в Избранное")
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

    @Feature("Проверка работы с Избранным")
    @Story("Удаление изделия из Избранного")
    @DisplayName("Проверить удаление изделия из Избранного")
    @Test
    void checkDeleteItemFromFavorites () {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCard.addItemToFavorites()
                .clickBthFavorites();
        favoritesPage.deleteFromFavorites();
        checkFavorites.checkFavoritesIsEmpty();
    }
}
