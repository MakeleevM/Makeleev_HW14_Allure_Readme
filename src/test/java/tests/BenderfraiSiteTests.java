package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BenderfraiPage;
import testdata.TestData;

import static io.qameta.allure.Allure.step;

@Story("Сайт Benderfrai")
public class BenderfraiSiteTests extends BaseTest {

    BenderfraiPage benderfraiPage = new BenderfraiPage();

    @Test
    @DisplayName("Проверка выпадающего списка СОБАКАМ")
    void shouldCheckDropdownMenu() {
        step("Открыть главную страницу", () ->
                benderfraiPage.openPage()
        );

        step("Навести на меню СОБАКАМ", () ->
                benderfraiPage.hoverSobakamMenu()
        );

        step("Проверить количество пунктов", () ->
                benderfraiPage.checkDropdownSize(TestData.SOBAKAM_SIZE)
        );

        step("Проверить названия пунктов", () ->
                benderfraiPage.checkDropdownTexts(TestData.SOBAKAM_ITEMS)
        );
    }

    @Test
    @DisplayName("Проверка выпадающего списка ПРОЧЕЕ")
    void shouldCheckProcheeDropdownMenu() {
        step("Открыть главную страницу", () ->
                benderfraiPage.openPage()
        );

        step("Навести на меню ПРОЧЕЕ", () ->
                benderfraiPage.hoverProcheeMenu()
        );

        step("Проверить количество пунктов", () ->
                benderfraiPage.checkDropdownSize(TestData.PROCHEE_SIZE)
        );

        step("Проверить названия пунктов", () ->
                benderfraiPage.checkDropdownTexts(TestData.PROCHEE_ITEMS)
        );
    }

    @Test
    @DisplayName("Проверка выпадающего списка Информация")
    void shouldCheckInfoDropdownMenu() {
        step("Открыть главную страницу", () ->
                benderfraiPage.openPage()
        );

        step("Навести на меню Информация", () ->
                benderfraiPage.hoverInfoMenu()
        );

        step("Проверить количество пунктов", () ->
                benderfraiPage.checkDropdownSize(TestData.INFO_SIZE)
        );

        step("Проверить названия пунктов", () ->
                benderfraiPage.checkDropdownTexts(TestData.INFO_ITEMS)
        );
    }

    @Test
    @DisplayName("Переход на страницу товара Ошейники для кошек")
    void shouldOpenProductPageAndCheckSku() {
        step("Открыть страницу Коты", () ->
                benderfraiPage.openCatsPage()
        );

        step("Кликнуть на товар Ошейники для кошек", () ->
                benderfraiPage.clickProductByName(TestData.PRODUCT_OSHEINIKI)
        );

        step("Проверить артикул", () ->
                benderfraiPage.checkProductSku(TestData.SKU_0645)
        );

        step("Проверить цену", () ->
                benderfraiPage.checkProductPrice(TestData.PRICE_850)
        );
    }

    @Test
    @DisplayName("Переход на страницу товара Анатомическая шлейка для кошек")
    void shouldOpenShleikaProductPageAndCheckSku() {
        step("Открыть страницу Коты", () ->
                benderfraiPage.openCatsPage()
        );

        step("Кликнуть на товар Анатомическая шлейка для кошек", () ->
                benderfraiPage.clickProductByName(TestData.PRODUCT_SHLEIKA)
        );

        step("Проверить артикул", () ->
                benderfraiPage.checkProductSku(TestData.SKU_0645)
        );

        step("Проверить цену", () ->
                benderfraiPage.checkProductPrice(TestData.PRICE_3400)
        );
    }
}