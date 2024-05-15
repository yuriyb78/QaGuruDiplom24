package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.CatalogPage;
import tests.web.pages.MainpagePage;

@Feature("Проверка каталога")
@Tag("All")
@Tag("Catalog")
public class CatalogTest extends BaseTests {

    MainpagePage mainpagePage = new MainpagePage();
    CatalogPage catalogPage = new CatalogPage();

    @Story("Проверка раздела Каталог на наличие элемента")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest(String menuElementName) {
        mainpagePage.openMainPage()
                .openCatalog();
        catalogPage.menuShouldHaveMenuElement(menuElementName);

    }

    @Story("Проверка что при переходе из меню Каталога на странице отображаются карточки изделий ")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить отображение карточек изделий в пункте меню {0}")
    void checkClickMenuItemsTest(String menuElementName) {
        mainpagePage.openMainPage()
                .openCatalog()
                .clickMenuItem(menuElementName);
        catalogPage.checkHeaderTitle(menuElementName)
                .checkProductList();

    }
}
