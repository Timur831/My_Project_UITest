package app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage{
    private static final SelenideElement signInButton = $x("/html/body/div[1]/div[1]/header/div/div[2]/div/div/a");

    public void clickOnSignInButton(){
        signInButton.click();
    }
}
