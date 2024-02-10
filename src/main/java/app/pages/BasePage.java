package app.pages;

import app.AppConfig;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class BasePage {
    protected String pageUrl = AppConfig.BASE_URL;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public BasePage() {
    }

    @Step("Открыть страницу")
    public void open() {
        Selenide.open(this.pageUrl);
    }

    @Step("Открыть страницу")
    public void refresh() {
        Selenide.refresh();
    }
}
