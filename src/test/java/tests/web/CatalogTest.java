package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.Mainpage;
import tests.web.pages.components.CheckCatalogItems;

public class CatalogTest extends BaseTests {

    Mainpage mainpage = new Mainpage();
    CheckCatalogItems checkCatalogItems = new CheckCatalogItems();

    @Feature("Проверка каталога")
    @Story("Проверка раздела Каталог на наличие элемента")
    @Tag("All")
    @Tag("Catalog")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog();
        checkCatalogItems.menuShouldHaveMenuElement(menuElementName);

    }

    @Feature("Проверка каталога")
    @Story("Проверка что при переходе из меню Каталога на странице отображаются карточки изделий ")
    @Tag("All")
    @Tag("Catalog")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить отображение карточек изделий в пункте меню {0}")
    void checkClickMenuItemsTest (String menuElementName) {
        mainpage.openMainPage()
                .openCatalog()
                .clickMenuItem(menuElementName);
        checkCatalogItems.checkHeaderTitle(menuElementName)
                .checkProductList();

    }
}
