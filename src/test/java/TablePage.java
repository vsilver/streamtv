import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class TablePage extends TestBase {

    public void addNewRecord(){
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        $(byXpath("//*[@class='btn btn-default']")).waitUntil(exist, 20000).click();
        $(byXpath("//*[@class='panel-heading']")).should(text("Wrestler info"));
        $(byXpath("//*[@value='wr.lname']//input")).setValue("Black");
        $(byXpath("//*[@value='wr.fname']//input")).setValue("John");
        $(byXpath("//*[@value='wr.mname']//input")).setValue("Mid");
        $(byXpath("//*[@value='wr.dob']//input")).setValue("01.05.1986");
        $(byXpath("//*[@value='wr.region1']//select")).selectOptionContainingText("Lvivska");
        $(byXpath("//*[@value='wr.fst1']//select")).selectOptionContainingText("Kolos");
        $(byXpath("//*[@value='wr.style']//select")).selectOptionContainingText("FW");
        $(byXpath("//*[@value='wr.lictype']//select")).selectOptionContainingText("Junior");
        $(byXpath("//*[@value='wr.expires']//select")).selectOptionContainingText("2015");
        $(byXpath("//*[@class='btn btn-lg btn-success']")).click();







    }


}
