import com.github.javafaker.Faker;
import org.junit.Test;
import com.github.javafaker.Name.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CountItemsInTable extends TestBase {
    String link1 = "//*[@class='col-sm-1 pl-0']//select";
    String link2 = "//*[@class='table table-striped table-hover']";


    @Test
    public void chooseCount(){
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        $(byXpath(link1)).selectOption(getDropdownItemsCount(link1));
        $(byXpath(link2)).findAll("tbody").shouldHave(size(getDropdownItemsCount(link1)));
    }
}
