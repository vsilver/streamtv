import org.junit.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.ElementShouldNot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public void logIn(String login, String pass){
        $(byXpath("//*[@id='username']//input")).click();
        //$(byXpath("//*[@id='username']//input")).sendKeys("auto");
        $(byXpath("//*[@id='username']//input")).sendKeys(login);
        $(byXpath("//*[@value='user.password']//input")).click();
        //$(byXpath("//*[@value='user.password']//input")).sendKeys("test");
        $(byXpath("//*[@value='user.password']//input")).sendKeys(pass);
        $(byXpath("//*[@class='btn btn-primary pull-right']")).submit();
    }
}


