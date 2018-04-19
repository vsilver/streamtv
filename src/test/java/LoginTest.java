import org.junit.Test;
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
    public void loginTest(){
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        assertEquals("Wrestlers", $(byXpath("//*[@class='tab-heading']")));
    }
}
