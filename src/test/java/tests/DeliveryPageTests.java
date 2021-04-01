package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.containTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Delivery page content")
@Tag("web")
class DeliveryPageTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        open("");

        $(byText("Доставка 24/7")).click();

        $(byText("Доставка лекарств")).shouldBe(visible);
    }

    @Test
    @DisplayName("Toggle should be changed")
    void shouldBeChangedWhenIClickButtonTest() {
        open("/company/delivery");

        $(byText("За МКАД")).click();

        $$("tbody>tr>td").shouldHave(containTexts("150 руб.", "Бесплатно"));
    }

    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        open("/company/delivery");

        $(".sec-delivery__sidebox-title").shouldHave(text("КРУГЛОСУТОЧНАЯ  ДОСТАВКА БЕЗ ВЫХОДНЫХ"));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/company/delivery");

        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs).doesNotContain("SEVERE");
    }
}
