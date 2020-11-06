package com.zerobank.stepdefinitions;

import com.zerobank.pages.TransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TypeStepDefs {

    @Then("results table should show at least	one	result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
        BrowserUtils.waitForPageToLoad(5);
        List<WebElement> tableClmResults = new TransactionsPage().tableColums(type);
        System.out.println(tableClmResults.size());
        List<String>tableClmStr= BrowserUtils.getElementsText(tableClmResults);

        int counter =0;

        for (String str : tableClmStr) {
            if(!(str.equals(""))){
                counter++;
            }
        }

        System.out.println(counter);
        Assert.assertTrue(counter>=1);

    }

    @When("user selects type {string}")
    public void user_selects_type(String option) {

        Select dropdown = new Select(new TransactionsPage().typeDropdown);
        dropdown.selectByValue(option.toUpperCase());

    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {

        BrowserUtils.waitForPageToLoad(5);

        List<WebElement> tableClmResults = new TransactionsPage().tableColums(type);

        List<String>tableClmStr= BrowserUtils.getElementsText(tableClmResults);

        int counter =0;

        for (String str : tableClmStr) {
            if(!(str.equals(""))){
                counter++;
            }
        }

        Assert.assertTrue(counter==0);

    }

}
