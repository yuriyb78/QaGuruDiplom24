package tests.web.utils;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GetValueFromPage {

    private final SelenideElement productTitle = $("[class^=ProductTitle_title]");

    @Step("Сохраняю артикул в переменную")
    public String getArticulFromProductCard() {

        String articulItem = productTitle.getText();
        String deleteWords = "Кольцо из белого золота с бриллиантами\nАртикул: ";
        String replacement = "";

        return articulItem.replace(deleteWords, replacement);

    }
}
