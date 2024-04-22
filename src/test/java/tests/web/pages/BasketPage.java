package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private final SelenideElement btnDelete = $("[data-qa='delete_item_from_cart']");

    public void deleteFromCart () {
        btnDelete.click();
    }
}
