package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("");
        return this;
    }

    public void openProjectsPage() {
        $(byText("Проекты")).click();
    }

}
