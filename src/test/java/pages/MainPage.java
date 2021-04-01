package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Cart;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.valueOf;

public class MainPage {

    private final SelenideElement searchInput = $(".searchbar__input");
    private final SelenideElement searchBtn = $(".searchbar__button");
    private final SelenideElement cartBtn = $(".badge");

    Cart cart = new Cart();

    public MainPage openPage() {
        open("");
        $(".header__tower-close").click();
        return this;
    }

    public SearchPage searchItem(String itemToSearch) {
        searchInput.val(itemToSearch);
        searchBtn.click();
        return new SearchPage();
    }

    public void checkItemsBadgeInCart(int items) {
        cart.itemsCountInCart.shouldHave(exactText(valueOf(items)));
    }

    public CartPage openCart() {
        cartBtn.click();
        return new CartPage();
    }

}
