package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.*;
import tests.web.pages.CheckingBasketPage;
import tests.web.utils.GetValueFromPage;

@Feature("Проверка работы с корзиной")
@Tag("All")
@Tag("Basket")
public class BasketTest extends BaseTests {

    CatalogPage catalogPage = new CatalogPage();
    ProductCardPage productCardPage = new ProductCardPage();
    CheckingBasketPage checkingBasketPage = new CheckingBasketPage();
    BasketPage basketPage = new BasketPage();

    @Story("Добавление изделия в корзину")
    @DisplayName("Проверить добавление изделия в корзину")
    @Test
    void checkAddItemInProductBasket() {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();

        String article = new GetValueFromPage().getArticulFromProductCard();

        productCardPage.chooseSizeItem()
                .addToBasket()
                .clickButtonConfirmOrder();

        checkingBasketPage.checkBasket()
                .checkArticulNumber(article);

    }

    @Story("Удаление изделия из корзины")
    @DisplayName("Проверить удаление изделия из корзины")
    @Test
    void checkDeleteItemFromProductBasket() {
        catalogPage.openPageWithItemRings()
                .chooseItemFromCatalog();
        productCardPage.chooseSizeItem()
                .addToBasket()
                .clickButtonConfirmOrder();
        basketPage.deleteFromCart();
        checkingBasketPage.checkBasketIsEmpty();

    }

}
