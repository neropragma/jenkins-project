package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


@Tag("UI")
public class UiTests {

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");

        Configuration.browserCapabilities = options;
        Configuration.headless = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void openPage(){
        Selenide.open("https://www.google.com/");
    }

    private void assertAnswer(String value, String result){
        $x("//button[@id='L2AGLb']").click();
        $x("//textarea[@name='q']").sendKeys(value + "=");
        String answer = $x("//*[@id='jZ2SBf']/div[1]/span/b").getText();
        Assertions.assertEquals(result, answer);

    }

    @Test
    public void calcPlusTest2() {
        assertAnswer("1+3", "4");
    }


    @Test
    public void calcMinusTest() {
        assertAnswer("6-2", "2");
    }

    @Test
    public void calcMultipyTest() {
        assertAnswer("2*2", "5");
    }

}
