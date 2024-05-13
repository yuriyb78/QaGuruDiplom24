package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private final SelenideElement btnDelete = $("[data-qa='delete_item_from_cart']");

    @Step("Нажать кнопку 'Удалить'")
    public void deleteFromCart() {
        btnDelete.click();
    }
}
