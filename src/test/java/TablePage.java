import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Integer.valueOf;

public class TablePage extends TestBase {

    Faker faker = new Faker();
    String first_name = faker.name().firstName();
    String last_name = faker.name().lastName();
    Date date = faker.date().birthday();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String day_of_birth = dateFormat.format(date);

    String region = "//*[@value='wr.region1']//select";
    String fst = "//*[@value='wr.fst1']//select";
    String style = "//*[@value='wr.style']//select";
    String age = "//*[@value='wr.lictype']//select";
    String year = "//*[@value='wr.expires']//select";
    String link1 = "//*[@class='col-sm-1 pl-0']//select";
    String link2 = "//*[@class='table table-striped table-hover']";

    public void addNewRecord(){
        $(byXpath("//*[@class='btn btn-default']")).waitUntil(exist, 20000).click();
        $(byXpath("//*[@class='panel-heading']")).should(text("Wrestler info"));
        $(byXpath("//*[@value='wr.lname']//input")).setValue(last_name);
        $(byXpath("//*[@value='wr.fname']//input")).setValue(first_name);
        $(byXpath("//*[@value='wr.mname']//input")).setValue(first_name);
        $(byXpath("//*[@value='wr.dob']//input")).setValue(day_of_birth);
        $(byXpath(region)).selectOption(getDropdownItemsCount(region));
        $(byXpath(fst)).selectOption(getDropdownItemsCount(fst));
        $(byXpath(style)).selectOption(getDropdownItemsCount(style));
        $(byXpath(age)).selectOption(getDropdownItemsCount(age));
        $(byXpath(year)).selectOption(getDropdownItemsCount(year));
        $(byXpath("//*[@class='btn btn-lg btn-success']")).click();
    }

    public void searchCreatedRecord(){
        $("input[ng-model='searchFor']").shouldBe(visible);
        $("input[ng-model='searchFor']").setValue(last_name+" "+first_name+" "+first_name);
        $(byXpath("//*[@class='btn btn-primary']")).click();
    }

    public void verifyCreatedRecord(){
        $(byText(last_name+" "+first_name+" "+first_name))
                .shouldHave(exactText(last_name+" "+first_name+" "+first_name));
    }

    @Test
    public void successfullyCreatedNewRecord() {
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        addNewRecord();
        refreshPage();
        logIn(login, pass);
        searchCreatedRecord();
        verifyCreatedRecord();
    }

    @Test
    public void chooseCountItemsInTable(){
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        $(byXpath(link1)).selectOption(getDropdownItemsCount(link1));
        $(byXpath(link2)).findAll("tbody").shouldHave(size(getDropdownItemsCount(link1)));
    }

    @Test
    public void selectFilter_AllRegions(){

    }
}
