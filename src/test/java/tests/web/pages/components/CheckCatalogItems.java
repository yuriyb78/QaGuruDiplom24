package tests.web.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CheckCatalogItems {

    public void menuShouldHaveMenuElement (String menuElementName) {
        $$("#catalog_menu_navigation li").find(text(menuElementName)).shouldHave(visible);

    }
}
