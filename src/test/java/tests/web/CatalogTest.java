package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.web.pages.MainpagePage;
import tests.web.pages.CheckingItemsOnCatalogPage;

@Feature("Проверка каталога")
@Tag("All")
@Tag("Catalog")
public class CatalogTest extends BaseTests {

    MainpagePage mainpagePage = new MainpagePage();
    CheckingItemsOnCatalogPage checkingItemsOnCatalogPage = new CheckingItemsOnCatalogPage();


    @Story("Проверка раздела Каталог на наличие элемента")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить наличие в меню пункта {0}")
    void checkMenuItemsTest(String menuElementName) {
        mainpagePage.openMainPage()
                .openCatalog();
        checkingItemsOnCatalogPage.menuShouldHaveMenuElement(menuElementName);

    }

    @Story("Проверка что при переходе из меню Каталога на странице отображаются карточки изделий ")
    @CsvFileSource(resources = "/test-data/menu_elements.csv")
    @ParameterizedTest(name = "Проверить отображение карточек изделий в пункте меню {0}")
    void checkClickMenuItemsTest(String menuElementName) {
        mainpagePage.openMainPage()
                .openCatalog()
                .clickMenuItem(menuElementName);
        checkingItemsOnCatalogPage.checkHeaderTitle(menuElementName)
                .checkProductList();

    }
}
