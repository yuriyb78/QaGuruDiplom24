package tests.web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckFavorites {

    private final ElementsCollection favoriteList = $$("[class^='List_favorites__product-list']");
    private final SelenideElement prodictItem = $("[class^='ProductListItem_product-link']"),
            iconFavorites = $(".SliderButtons_slider-buttons__icon_marked__AuVry"),
            favoritesCounter = $("[class^='ButtonTemplate_button-counter']"),
            favoriteIsEmpty = $("[class^='Empty_empty__text']");

    private final String msgFavoriteIsEmpty = "Вы пока ничего не добавили в избранное. Посмотрите украшения или часы в каталоге SOKOLOV.";

    @Step("Проверяю что иконка избранного на карточке изделия изменила цвет на синий")
    public CheckFavorites checkIconFavoritesColor () {
        String valueName = "color";
        String colorBlue = "rgba(24, 94, 186, 1)";
        iconFavorites.shouldHave(cssValue(valueName,colorBlue));
        return this;
    }

    @Step("Проверяю что появился счетчик избранного красного цвета")
    public void checkFavoritesCounter () {
        String valueName = "background-color";
        String colorRed = "rgba(204, 55, 60, 1)";
        favoritesCounter.shouldHave(visible)
                .shouldHave(cssValue(valueName,colorRed))
                .shouldHave(text("1"));
    }
    @Step("Проверяю что избранное не пусто")
    public CheckFavorites checkFavorites () {
        favoriteList.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверяю что артикул изделия в Избранном соотвествует артикулу изделия выбранного в каталоге")
    public void checkArticulNumber (String article) {
        prodictItem.shouldHave(attribute("data-qa-article",article));
    }

    @Step("Проверяю сообщение об отсуствии изделий в Избранном")
    public void checkFavoritesisEmpty () {
        favoriteIsEmpty.shouldHave(text(msgFavoriteIsEmpty));
    }

}
