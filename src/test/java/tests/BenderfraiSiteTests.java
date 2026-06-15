package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BenderfraiSiteTests extends BaseTest {

    @Test
    @DisplayName("Проверка выпадающего списка СОБАКАМ")
    void shouldCheckDropdownMenu() {
        open("");

        $("[data-menu-submenu-hook='link_sub1_109881485']").hover();

        $$(".t-menusub__menu_show .t-menusub__list-item").shouldHave(size(8));

        $$(".t-menusub__menu_show .t-menusub__link-item").shouldHave(texts(
                "ОШЕЙНИКИ",
                "ШЛЕЙКИ",
                "ПОВОДКИ",
                "ПЕРЕСТЁЖКА-ТРАНСФОРМЕР",
                "ПЕРЕСТЁЖКИ СТАНДАРТНЫЕ",
                "АДРЕСНИКИ, ШНУРКИ",
                "БАНДАНЫ",
                "СОБАКАМ ДО 7 КГ"
        ));
    }

    @Test
    @DisplayName("Проверка выпадающего списка ПРОЧЕЕ")
    void shouldCheckProcheeDropdownMenu() {
        open("");

        // Закрыть другие меню кликом в пустое место
        $("body").click();
        sleep(300);

        // Навести на "ПРОЧЕЕ"
        $("[data-menu-submenu-hook='link_sub3_109881485']").hover();
        sleep(500);

        // Проверить
        $$(".t-menusub__menu_show .t-menusub__list-item").shouldHave(size(5));

        $$(".t-menusub__menu_show .t-menusub__link-item").shouldHave(texts(
                "ПОДАРОЧНАЯ КАРТА",
                "ДЛЯ ЛЮДЕЙ",
                "ИГРУШКИ",
                "ЛАКОМСТВА",
                "ВСЕ КОЛЛЕКЦИИ"
        ));
    }

    @Test
    @DisplayName("Проверка выпадающего списка Информация")
    void shouldCheckInfoDropdownMenu() {
        open("");

        $("[data-menu-submenu-hook='link_sub5_109881485']").hover();

        $$(".t-menusub__menu_show .t-menusub__list-item").shouldHave(size(8));

        $$(".t-menusub__menu_show .t-menusub__link-item").shouldHave(texts(
                "О НАС",
                "ПОКУПКА И ДОСТАВКА",
                "КАК ПОЛЬЗОВАТЬСЯ",
                "ГАРАНТИЯ",
                "ЭКСПЛУАТАЦИЯ, УХОД",
                "ОБМЕН И ВОЗВРАТ",
                "СКИДКА ПОКУПАТЕЛЯ",
                "КОНТАКТЫ"
        ));
    }

    @Test
    @DisplayName("Переход на страницу товара Ошейники для кошек")
    void shouldOpenProductPageAndCheckSku() {
        open("/cats");

        $$(".js-product").findBy(text("ОШЕЙНИКИ ДЛЯ КОШЕК")).click();

        // Проверить артикул
        $(".t-store__prod-popup__sku").shouldHave(text("0645"));

        // Проверить цену
        $(".t-store__prod-popup__price-value").shouldHave(text("850"));
    }

    @Test
    @DisplayName("Переход на страницу товара Анатомическая шлейка для кошек")
    void shouldOpenShleikaProductPageAndCheckSku() {
        open("/cats");

        $$(".js-product").findBy(text("Анатомическая ШЛЕЙКА ДЛЯ КОШЕК с ремнём Гудини")).click();

        // Проверить артикул
        $(".t-store__prod-popup__sku").shouldHave(text("0645"));

        // Проверить цену
        $(".t-store__prod-popup__price-value").shouldHave(text("3 400"));
    }


}