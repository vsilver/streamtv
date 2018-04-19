import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;


public class LoginTest extends TestBase {
    private String login;
    private String pass;

    public LoginTest(){
        this.login = login;
        this.pass = pass;
    }

    @Test
    public void successfullLoginTest(){
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        $(byXpath("//*[@class='btn btn-default']")).waitUntil(exist, 20000);
    }

    @Test
    public void failLoginTest(){
        String login = "qqqq";
        String pass = "aaaa";
        logIn(login, pass);
        $(byXpath("//*[@class='btn btn-default']")).waitUntil(hidden, 20000);
    }


}

