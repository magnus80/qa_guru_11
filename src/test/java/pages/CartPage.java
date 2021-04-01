package pages;

import pages.components.CartItem;

import static com.codeborne.selenide.Condition.text;

public class CartPage {

    CartItem cartItem = new CartItem("section.commodity");

    public void checkItemsInCart(String expectedTitle) {
        cartItem.drugTitle().should(text(expectedTitle));
    }
}
