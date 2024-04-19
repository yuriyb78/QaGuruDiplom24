package tests.web.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GetValueFromPage {

    private final SelenideElement productTitle = $("[class^=ProductTitle_title]");

    public String getArticulFromProductCard () {

        String articulItem= productTitle.getText();
        return articulItem;

    }
}
