package helpers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void initDriver(){

        /**
         Общая конфигурация драйвера
         */
        //Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = Browsers.CHROME;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = true;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 120000;
        Configuration.remoteConnectionTimeout = 60000;
        Configuration.remoteReadTimeout = 60000;
        Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        /**
         Настройки для Хрома
         */
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--proxy-bypass-list=<-loopback>");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        //options.addArguments("--incognito");
        //options.addArguments("headless");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-infobars");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--remote-debugging-port=9222");
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        /**
         Настройки для Selenoid
         */
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("browserVersion", "118.0");
        //selenoidOptions.put("sessionTimeout", "1m");
        capabilities.setCapability("selenoid:options", selenoidOptions);

        Configuration.browserCapabilities = capabilities;

        System.setProperty("webdriver.chrome.driver", "chromedriver/win/chromedriver.exe");

    }
}
