package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.*;
import tests.web.pages.components.CheckBasket;
import tests.web.utils.GetValueFromPage;

public class BasketTest extends BaseTests {

    CatalogPage catalogPage = new CatalogPage();
    ProductCard productCard = new ProductCard();
    CheckBasket checkBasket = new CheckBasket();
    BasketPage basketPage = new BasketPage();

    @Feature("Проверка работы с корзиной")
    @Story("Добавление изделия в корзину")
    @DisplayName("Проверить добавление изделия в корзину")
    @Tag("All")
    @Tag("Basket")
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

    @Feature("Проверка работы с корзиной")
    @Story("Удаление изделия из корзины")
    @DisplayName("Проверить удаление изделия из корзины")
    @Tag("Basket")
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

}
