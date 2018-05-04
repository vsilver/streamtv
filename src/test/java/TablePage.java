import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.Test;
import com.github.javafaker.Name.*;
import java.util.Random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.valueOf;

public class TablePage extends TestBase {

    Faker faker = new Faker();
    String first_name = faker.name().firstName();
    String last_name = faker.name().lastName();
    Date date = faker.date().birthday();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String day_of_birth = dateFormat.format(date);

    //SelenideElement region = $(byXpath("//*[@value='wr.region1']//select"));
    String region = "//*[@value='wr.region1']//select";
    String fst = "//*[@value='wr.fst1']//select";
    String style = "//*[@value='wr.style']//select";
    String age = "//*[@value='wr.lictype']//select";
    String year = "//*[@value='wr.expires']//select";

    public int getDropdownItemsCount(String myxpath){
        ElementsCollection collection = $$(byXpath(myxpath));
        return valueOf((int)(Math.random()*(collection.size()) + 1));
        //return collection.size();
    }

    public void addNewRecord(){
        $(byXpath("//*[@class='btn btn-default']")).waitUntil(exist, 20000).click();
        $(byXpath("//*[@class='panel-heading']")).should(text("Wrestler info"));
        $(byXpath("//*[@value='wr.lname']//input")).setValue(last_name);
        $(byXpath("//*[@value='wr.fname']//input")).setValue(first_name);
        $(byXpath("//*[@value='wr.mname']//input")).setValue(first_name);
        $(byXpath("//*[@value='wr.dob']//input")).setValue(day_of_birth);
       // $(byXpath("//*[@value='wr.region1']//select")).selectOptionContainingText("Lvivska");
        //$(byXpath(region)).selectOptionContainingText("Lvivska");
        $(byXpath(region)).selectOption(getDropdownItemsCount(region));
        //$(byXpath("//*[@value='wr.fst1']//select")).selectOptionContainingText("Kolos");
        $(byXpath(fst)).selectOption(getDropdownItemsCount(fst));
        //$(byXpath("//*[@value='wr.style']//select")).selectOptionContainingText("FW");
        $(byXpath(style)).selectOption(getDropdownItemsCount(style));
        //$(byXpath("//*[@value='wr.lictype']//select")).selectOptionContainingText("Junior");
        $(byXpath(age)).selectOption(getDropdownItemsCount(age));
        //$(byXpath("//*[@value='wr.expires']//select")).selectOptionContainingText("2015");
        $(byXpath(year)).selectOption(getDropdownItemsCount(year));
        $(byXpath("//*[@class='btn btn-lg btn-success']")).click();
    }

    public void searchCreatedRecord(){

    }

    public void verifyCreatedRecord(){


    }

    @Test
    public void successfullyCreatedNewRecord() {
        String login = "auto";
        String pass = "test";
        logIn(login, pass);
        addNewRecord();
    }




}
