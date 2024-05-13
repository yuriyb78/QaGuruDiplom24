package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FavoritesPage {

    private final SelenideElement btnDelete = $(".ProductListItem_delete-product__Gj0GW");

    @Step("Удаление изделия из избранного")
    public void deleteFromFavorites() {
        btnDelete.click();
    }
}
