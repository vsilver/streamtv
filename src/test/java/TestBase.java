import org.junit.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.ElementShouldNot;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assume.assumeTrue;

public class TestBase {

    @BeforeClass
    public static void openLink(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        Configuration.browser = "chrome";
        open("http://streamtv.net.ua/base/");
    }

    @Test
    public void logIn(){
        $("#username").click();
        $("#username").setValue("auto");
        $("#text").setValue("auto");
        $(byValue("user.password")).click(); //setValue("test");
        $("#submit").click();

    }
}

