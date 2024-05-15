package tests.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FavoritesPage {

    private final SelenideElement btnDelete = $(".ProductListItem_delete-product__Gj0GW"),
            productItem = $("[class^='ProductListItem_product-link']"),
            iconFavorites = $(".SliderButtons_slider-buttons__icon_marked__AuVry"),
            btnHeaderFavorites = $("[data-qa='header_favorites_btn']"),
            favoritesCounter = btnHeaderFavorites.$("[class^='ButtonTemplate_button-counter']"),
            favoriteIsEmpty = $("[class^='Empty_empty__text']");

    private final ElementsCollection favoriteList = $$("[class^='List_favorites__product-list']");

    private final String msgFavoriteIsEmpty = "Вы пока ничего не добавили в избранное. Посмотрите украшения или часы в каталоге SOKOLOV.";

    @Step("Проверить что иконка Избранного на карточке изделия изменила цвет на синий")
    public FavoritesPage checkIconFavoritesColor() {
        String valueName = "color";
        String colorBlue = "rgba(24, 94, 186, 1)";
        iconFavorites.shouldHave(cssValue(valueName, colorBlue));
        return this;
    }

    @Step("Проверить что появился счетчик Избранного красного цвета")
    public void checkFavoritesCounter() {
        String valueName = "background-color";
        String colorRed = "rgba(204, 55, 60, 1)";
        favoritesCounter.shouldHave(visible)
                .shouldHave(cssValue(valueName, colorRed));
    }

    @Step("Проверить что Избранное не пусто")
    public FavoritesPage checkFavorites() {
        favoriteList.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить что артикул изделия в Избранном соотвествует артикулу изделия выбранного в каталоге")
    public void checkArticulNumber(String article) {
        productItem.shouldHave(attribute("data-qa-article", article));
    }

    @Step("Проверить сообщение об отсуствии изделий в Избранном")
    public void checkFavoritesIsEmpty() {
        favoriteIsEmpty.shouldHave(text(msgFavoriteIsEmpty));
    }

    @Step("Удаление изделия из избранного")
    public FavoritesPage deleteFromFavorites() {
        btnDelete.click();
        return this;
    }
}
