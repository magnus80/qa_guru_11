package pages;

import pages.components.FoundItem;

public class SearchPage {

    FoundItem item = new FoundItem(".cc-item--group.cc-group section");

    public SearchPage addItemToCart(){
        item.addItemToCart();
        return this;
    }
}


