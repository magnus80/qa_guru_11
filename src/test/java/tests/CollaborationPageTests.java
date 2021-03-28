package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Collaborating page content")
@Tag("web")
class CollaborationPageTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        open("");

        $(".main-slider__tender").click();

        $(".page-title__link").shouldBe(visible)
                .shouldHave(exactText("Начать сотрудничество"));
    }

    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        open("/write-us");

        $(".page-title__link").shouldBe(visible)
                .shouldHave(exactText("Начать сотрудничество"));
    }


    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/write-us");

        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs).doesNotContain("SEVERE");
    }
}
