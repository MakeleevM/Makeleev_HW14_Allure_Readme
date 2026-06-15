package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BenderfraiPage {
    private final SelenideElement sobakamMenu = $("[data-menu-submenu-hook='"
            + testdata.TestData.MENU_SOBAKAM + "']");
    private final SelenideElement procheeMenu = $("[data-menu-submenu-hook='"
            + testdata.TestData.MENU_PROCHEE + "']");
    private final SelenideElement infoMenu = $("[data-menu-submenu-hook='"
            + testdata.TestData.MENU_INFO + "']");
    private final ElementsCollection dropdownItems = $$(".t-menusub__menu_show .t-menusub__list-item");
    private final ElementsCollection dropdownLinks = $$(".t-menusub__menu_show .t-menusub__link-item");
    private final ElementsCollection products = $$(".js-product");
    private final SelenideElement productSku = $(".t-store__prod-popup__sku");
    private final SelenideElement productPrice = $(".t-store__prod-popup__price-value");

    public BenderfraiPage openPage() {
        open(testdata.TestData.BASE_URL);
        return this;
    }

    public BenderfraiPage openCatsPage() {
        open(testdata.TestData.CATS_URL);
        return this;
    }

    public BenderfraiPage hoverSobakamMenu() {
        sobakamMenu.hover();
        return this;
    }

    public BenderfraiPage hoverProcheeMenu() {
        $("body").click();
        sleep(300);
        procheeMenu.hover();
        sleep(500);
        return this;
    }

    public BenderfraiPage hoverInfoMenu() {
        infoMenu.hover();
        return this;
    }

    public BenderfraiPage checkDropdownSize(int expectedSize) {
        dropdownItems.shouldHave(size(expectedSize));
        return this;
    }

    public BenderfraiPage checkDropdownTexts(String... expectedTexts) {
        dropdownLinks.shouldHave(texts(expectedTexts));
        return this;
    }

    public BenderfraiPage clickProductByName(String productName) {
        products.findBy(text(productName)).click();
        return this;
    }

    public BenderfraiPage checkProductSku(String expectedSku) {
        productSku.shouldHave(text(expectedSku));
        return this;
    }

    public BenderfraiPage checkProductPrice(String expectedPrice) {
        productPrice.shouldHave(text(expectedPrice));
        return this;
    }
}