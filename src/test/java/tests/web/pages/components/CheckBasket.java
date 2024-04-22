package tests.web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBasket {

    private final ElementsCollection checkoutProducts = $$("[class^='ProductList_checkout-products']");
    private final SelenideElement prodictItem = $("[class^='ProductItem_product']"),
                    msgBasketIsEmpty = $("[class^='Empty_checkout-empty__title']");

    @Step("Проверяю что корзина не пуста")
    public CheckBasket checkBasket () {
        checkoutProducts.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверяю что артикул изделия в корзине соотвествует артикулу изделия выбранного в каталоге")
    public void checkArticulNumber (String article) {
        prodictItem.shouldHave(attribute("data-qa_article",article));
    }

    @Step("Проверяю что корзина пуста")
    public void checkBasketIsEmpty () {
        msgBasketIsEmpty.shouldHave(text("Ваша корзина пуста"), Duration.ofSeconds(12));
    }
}
