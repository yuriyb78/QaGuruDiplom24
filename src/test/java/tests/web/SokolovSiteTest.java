package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.Mainpage;
import tests.web.pages.components.CheckCatalogItems;

public class SokolovSiteTest extends BaseTests{

    Mainpage mainpage = new Mainpage();
    CheckCatalogItems checkCatalogItems = new CheckCatalogItems();

    @Feature("Проверка сайта")
    @Story("Проверка раздела Каталог на наличие элемента")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog();
        checkCatalogItems.menuShouldHaveMenuElement(menuElementName);

    }
}
