package tests.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    private final SelenideElement btnDelete = $("[data-qa='delete_item_from_cart']"),
            productItem = $("[class^='ProductItem_product']"),
            msgBasketIsEmpty = $("[class^='Empty_checkout-empty__title']");

    private final ElementsCollection checkoutProducts = $$("[class^='ProductList_checkout-products']");

    @Step("Проверить что корзина не пуста")
    public BasketPage checkBasket() {
        checkoutProducts.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить что артикул изделия в корзине соотвествует артикулу изделия выбранного в каталоге")
    public void checkArticulNumber(String article) {
        productItem.shouldHave(attribute("data-qa_article", article));
    }

    @Step("Проверить что корзина пуста")
    public void checkBasketIsEmpty() {
        msgBasketIsEmpty.shouldHave(text("Ваша корзина пуста"), Duration.ofSeconds(12));
    }

    @Step("Нажать кнопку 'Удалить'")
    public BasketPage deleteFromCart() {
        btnDelete.click();
        return this;
    }
}
