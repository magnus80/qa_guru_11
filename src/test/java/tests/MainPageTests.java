package tests;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;

@Tag("web")
@Feature("MainPage tests")
class MainPageTests extends TestBase {

    @Test
    @DisplayName("I can see and check menu")
    void checkMenu() {
        step("Open main page", () ->
                open(""));

        step("Verify registration page is open", () ->
                $$(".header-menu__list>li>a")
                        .shouldHaveSize(7)
                        .shouldHave(texts("Услуги", "Проекты",
                                "Клиенты", "О компании", "Карьера", "Блог", "Контакты")));
    }

    @Test
    @DisplayName("I can change language")
    void checkLanguageChanging() {
        step("Open main page", () ->
                open(""));

        step("Click on Eng button", () ->
                $(".header-menu__lang").click());

        step("Verify registration page is open", () -> {
                    $(".header-menu__lang").shouldHave(exactText("Ru"));
                    $$(".header-menu__list>li>a")
                            .shouldHaveSize(5)
                            .shouldHave(texts("Services", "Team",
                                    "Clients", "About", "Contacts"));
                }
        );
    }

    @Test
    @DisplayName("I can download pdf file")
    void checkPDFFile() {
        File click_on_eng_button;
        step("Open main page", () ->
                open(""));

        click_on_eng_button = step("Click on Eng button", () ->
                $(".footer__download-link").download());

        step("Verify registration page is open", () -> {
            PDF pdf = new PDF(click_on_eng_button);
            assertThat(pdf).containsText("AWG - ведущий digital интегратор");
                }
        );
    }

    @Test
    @DisplayName("I can scroll")
    @AllureId("2314")
    void checkScroll() {
        step("Open main page", () ->
                open(""));
        step("Click on a mouse button",()->
            $(className("data-scroll-btn")).click());
        step("Verify that data-scroll-content is visible",()->
                $(className("data-scroll-content")).shouldBe(visible));
    }
}
