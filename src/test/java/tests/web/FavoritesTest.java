package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.CatalogPage;
import tests.web.pages.FavoritesPage;
import tests.web.pages.ProductCardPage;
import tests.web.pages.CheckingFavoritesPage;
import tests.web.utils.GetValueFromPage;

@Feature("Проверка работы с Избранным")
@Tag("All")
@Tag("Favorites")
public class FavoritesTest extends BaseTests {

    CatalogPage catalogPage = new CatalogPage();
    ProductCardPage productCardPage = new ProductCardPage();
    FavoritesPage favoritesPage = new FavoritesPage();
    CheckingFavoritesPage checkingFavoritesPage = new CheckingFavoritesPage();


    @Story("Добавление изделия в Избранное")
    @DisplayName("Проверить добавление изделия в Избранное")
    @Test
    void checkAddItemToFavorites() {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCardPage.addItemToFavorites();

        String article = new GetValueFromPage().getArticulFromProductCard();

        checkingFavoritesPage.checkIconFavoritesColor()
                .checkFavoritesCounter();

        productCardPage.clickBthFavorites();

        checkingFavoritesPage.checkFavorites()
                .checkArticulNumber(article);

    }

    @Story("Удаление изделия из Избранного")
    @DisplayName("Проверить удаление изделия из Избранного")
    @Test
    void checkDeleteItemFromFavorites() {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCardPage.addItemToFavorites()
                .clickBthFavorites();
        favoritesPage.deleteFromFavorites();
        checkingFavoritesPage.checkFavoritesIsEmpty();
    }
}
