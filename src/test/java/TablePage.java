import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.Test;
import com.github.javafaker.Name.*;
import org.openqa.selenium.support.ui.Select;

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

    String region = "//*[@value='wr.region1']//select";
    String fst = "//*[@value='wr.fst1']//select";
    String style = "//*[@value='wr.style']//select";
    String age = "//*[@value='wr.lictype']//select";
    String year = "//*[@value='wr.expires']//select";

    public int getDropdownItemsCount(String myxpath){
        Select select = new Select($(byXpath(myxpath)));
        int max = select.getOptions().size();
        int min = 1;
        int range = max - min ;
        return ((int)(Math.random()*range) + min);

    }

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
