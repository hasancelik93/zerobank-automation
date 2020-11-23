package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.TransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionsStepDefs {


    @Given("the user navigates to {string} and {string} tab")
    public void the_user_navigates_to_and_tab(String module, String tab) {

        new TransactionsPage().navigateTo(module,tab);

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) throws InterruptedException {

       TransactionsPage transactionsPage = new TransactionsPage();

       BrowserUtils.waitForClickablility(transactionsPage.fromDate,2);
        transactionsPage.fromDate.sendKeys(fromDate);
        Thread.sleep(2000);

        transactionsPage.toDate.sendKeys(toDate);
        Thread.sleep(2000);

    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {


        TransactionsPage transactionsPage= new TransactionsPage();
        BrowserUtils.waitForClickablility(transactionsPage.findButton,2000);
        transactionsPage.findButton.click();

        Thread.sleep(2000);

    }





    @Then("results table	should only	show transactions dates	between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        List<WebElement> dates = new TransactionsPage().tableColums("Date");
        List<String> dateString = BrowserUtils.getElementsText(dates);
        List<Integer> dateInt= new ArrayList<>();

        for (String s : dateString) {
            s=s.replace("-","");
            dateInt.add(Integer.parseInt(s));
        }

        int expectedToDate = Integer.parseInt(toDate.replace("-",""));
        int expectedFromDate= Integer.parseInt(fromDate.replace("-",""));
        Assert.assertTrue(dateInt.get(0)<=expectedToDate);
        Assert.assertTrue(dateInt.get(dateInt.size()-1)>=expectedFromDate);


        System.out.println(dateInt);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results table	should only	not	contain	transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }






}