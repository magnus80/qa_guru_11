package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FoundItem {

    private final SelenideElement element;
    public FoundItem(String selector) {
        this.element = $(selector);
    }

    public SelenideElement buyBtn() {return element.$(byText("Купить"));}
    public SelenideElement drugTitle() {return element.$(".cc-item--title");}

    public void addItemToCart() {
        buyBtn().click();
    }

}
