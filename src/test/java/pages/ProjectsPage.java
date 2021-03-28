package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.SearchItems;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {

    private final SelenideElement filtersPanel = $(".filters-panel__list");
    private final SelenideElement casesList = $(".cases__list");

    private final SelenideElement searchBtn = $(" .filters-panel__search-button");
    private final SelenideElement searchInput = $(".filters-search__input");

    public ProjectsPage selectClient(SearchItems client) {
        filtersPanel.$(".select-2 .select__list").click();
        $(byText(client.getElement())).click();
        return this;
    }

    public ProjectsPage selectBranch(SearchItems branch) {
        filtersPanel.$(".select-1 .select__list").click();
        $(byText(branch.getElement())).click();
        return this;
    }

    public void checkFoundItems(SearchItems foundName) {
        casesList.$$(".cases__item p").shouldHave(sizeGreaterThan(5))
                .shouldHave(itemWithText(foundName.getElement()));
    }

    public ProjectsPage searchItem(SearchItems toSearch) {
        searchBtn.click();
        searchInput.val(toSearch.getElement());
        return this;
    }
}
