package tests;

import app.pages.MainPage;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{
    @Test
    public void testOpening(){
        new MainPage()
                .open();
        new MainPage()
                .clickOnSignInButton();
    }
}
