import com.codeborne.selenide.SelenideElement;
import org.junit.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.ElementShouldNot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    SelenideElement username = $(byXpath("//*[@id='username']//input"));
    SelenideElement password = $(byXpath("//*[@value='user.password']//input"));

    public void logIn(String login, String pass){
        username.click();
        username.sendKeys(login);
        password.click();
        password.sendKeys(pass);
        $(byXpath("//*[@class='btn btn-primary pull-right']")).click();
    }

    public void refreshPage(){
        refresh();
    }

    public int getDropdownItemsCount(String myxpath) {
        Select select = new Select($(byXpath(myxpath)));
        int max = select.getOptions().size();
        int min = 1;
        int range = max - min;
        return ((int) (Math.random() * range) + min);
    }
}


