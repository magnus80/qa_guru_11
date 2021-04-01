package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("web")
class CartTests extends TestBase {

    MainPage mainPage = new MainPage();

    @BeforeEach
    void setUp() {
        mainPage.openPage();
    }

    @Test
    @DisplayName("I can add drug to cart")
    void shouldAddDrugsToCart() {
        addToCart();
        mainPage.checkItemsBadgeInCart(1);
    }

    private void addToCart() {
        mainPage.searchItem("Аквадетрим")
                .addItemToCart();
    }

    @Test
    @DisplayName("I can check drugs in cart")
    void shouldCheckItemCart() {
        addToCart();
        mainPage.openCart().checkItemsInCart("Аквадетрим");
    }

}
