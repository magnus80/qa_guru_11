package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Cart {

    public final SelenideElement cartBtn = $(".btn-cart");
    public final SelenideElement itemsCountInCart = cartBtn.$(".badge");



}
