package tests.web.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class ProductCard {

    private final SelenideElement btnProductBucket = $("[class^='Product_sklv-product-page__add-to-cart']"),
            sizeItem = $("[class^='Sizes_sizes'"),
            btnConfirmOrder = $("[class^='styles_footer']");

    @Step("Выбираю размер изделия")
    public ProductCard chooseSizeItem (){
        sizeItem.find(byText("17")).click();
        return this;
    }

    @Step("Добавляю изделие в корзину")
    public ProductCard addToBasket () {
        btnProductBucket.click();
        return this;
    }

    @Step("Нажать кнопку 'Оформить заказ'")
    public void clickButtonConfirmOrder () {
        btnConfirmOrder.find(byText("Оформить заказ")).click();
    }

}
