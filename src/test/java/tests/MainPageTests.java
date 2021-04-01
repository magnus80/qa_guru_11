package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("MainPage tests")
class MainPageTests extends TestBase {

    @BeforeEach
    void setUp() {
        step("Open main page", () ->
                open(""));
    }

    @Test
    @DisplayName("I can see and check menu")
    void checkMenu() {

        step("Verify main page is open", () ->
                $$(".header__nav-list>li>a")
                        .shouldHaveSize(9)
                        .shouldHave(texts("Лекарства", "Витамины и БАД",
                                "Красота", "Гигиена", "Линзы", "Мать и дитя", "Медтовары",
                                "Зоотовары", "Медтехника")));
    }

    @Test
    @DisplayName("I can change region")
    void checkLanguageChanging() {

        step("Click on region button", () ->
                $(".select_in").click());

        step("Click Another region button in Popup", () ->
                $(".header__select-start").click()
        );

        step("Choose city Пенза", () -> {
            $(".header__tower-input").val("Пенза");
            $(".header__tower-result .active").click();
        });

        step("Click button in Popup", () ->
                $(".header__tower-search>a[class*=header__skip-search]")
                        .shouldHave(exactText("Да, я тут"))
                        .click());

        step("Verify region is Пенза", () -> {
                    $(".select_in>span").shouldHave(exactText("Пенза"));
                }
        );
    }

}
