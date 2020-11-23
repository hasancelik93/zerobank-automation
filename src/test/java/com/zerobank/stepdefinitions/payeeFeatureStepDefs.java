package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayeePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class payeeFeatureStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() throws InterruptedException {

        new LoginPage().login();

        new PayeePage().navigateTo("Pay Bills","Add New Payee");


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userInfo) throws InterruptedException {

        PayeePage payeePage = new PayeePage();

        BrowserUtils.waitFor(2);

        BrowserUtils.waitFor(2);
        payeePage.payeeName.sendKeys(userInfo.get("Payee Name"));
        payeePage.payeeAddress.sendKeys(userInfo.get("Payee Address"));
        payeePage.payeeAccount.sendKeys(userInfo.get("Account"));
        payeePage.payeeDetails.sendKeys(userInfo.get("Payee details"));
        Thread.sleep(2000);
        payeePage.addButton.click();
        BrowserUtils.waitFor(2);



    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks	was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

        String expected = "The new payee The Law Office of Hyde, Price & Scharks was successfully created.";

        String actual = new PayeePage().succesMsg.getText();

        System.out.println(actual);
        Assert.assertTrue(expected.contains(actual));
        Assert.assertTrue(actual.contains(expected));


    }


}
