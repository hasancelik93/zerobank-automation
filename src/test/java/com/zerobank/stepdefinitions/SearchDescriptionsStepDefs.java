package com.zerobank.stepdefinitions;

import com.zerobank.pages.TransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchDescriptionsStepDefs {


    @When("the user enters description {string}")
    public void the_user_enters_description(String description) throws InterruptedException {
        Thread.sleep(2000);
        new TransactionsPage().description.sendKeys(description);
        Thread.sleep(2000);

    }

    @Then("results table	should only	show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {

        List<WebElement> table = new TransactionsPage().tableColums(description);

        boolean flag= false;

        for (WebElement element : table) {
            System.out.println(element.getText());
            if(element.getText().contains(description.toUpperCase())){
                flag = true;
            }

        }

        Assert.assertTrue(flag);

    }

    @Then("results table	should not show	descriptions containing	{string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
