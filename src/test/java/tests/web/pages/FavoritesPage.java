package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FavoritesPage {

    private final SelenideElement btnDelete = $(".ProductListItem_delete-product__Gj0GW");

    public void deleteFromFavorites () {
        btnDelete.click();
    }
}
