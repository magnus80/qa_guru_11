package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartItem {

    private final SelenideElement element;

    public CartItem(String selector) {
        this.element = $(selector);
    }

    public SelenideElement drugTitle() {
        return element.$(".cart-info__link");
    }


}
