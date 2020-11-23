package com.zerobank.stepdefinitions;

import com.zerobank.pages.CurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CurrencyStepDefs {

    @Then("following	currencies should	be	available")
    public void following_currencies_should_be_available(List<String> expcurrencyOptions) {

        BrowserUtils.waitFor(2);

        CurrencyPage currencyPage= new CurrencyPage();

        Select select = new Select(currencyPage.currencyOptions);

        List<String> actualCurrencyOptions = BrowserUtils.getElementsText(select.getOptions());

        Assert.assertTrue(actualCurrencyOptions.containsAll(expcurrencyOptions));

//        for (String exp : expcurrencyOptions) {
//            Assert.assertTrue(actualCurrencyOptions.contains(exp));
//        }

//        for (int i = 0; i < expcurrencyOptions.size(); i++) {
//            Assert.assertTrue(actualCurrencyOptions.contains(expcurrencyOptions.get(i)));
//        }






        //System.out.println(menuOptions.size());
        //System.out.println(menuOptions);
        //get the list of webelement and convert them to list of string and assert

        //this method gives you list of webelement you need to convert them to string to compare them
        //new DashboardPage().menuOptions + them use alt+enter it gives you list of web element
        // we need list of string so we change the type
        //List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);


    }

    @When("user tries to calculate cost without selecting a {string}")
    public void user_tries_to_calculate_cost_without_selecting_a(String data) {

        BrowserUtils.waitFor(2);
        CurrencyPage currencyPage= new CurrencyPage();

        if(data.equals("value")){




            Select select = new Select(currencyPage.currencyOptions);

            select.selectByIndex(4);



        }else if (data.equals("currency")){

            currencyPage.amount.sendKeys("55");


        }
        System.out.println(data);
        currencyPage.calculateBtn.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        BrowserUtils.waitFor(2);

        Alert alert = Driver.get().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please, ensure that you have filled all the required fields with valid values."));

    }


}
