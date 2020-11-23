package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NavigationStepDefs {





    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {

        Driver.get().findElement(By.xpath("//a[contains(text(),'"+link+"')]")).click();
        BrowserUtils.waitFor(2);


    }

    @Then("the {string} should be displayed")
    public void the_should_be_displayed(String expectedTitle) {

        BrowserUtils.waitForPageToLoad(5);

        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedDropdown) {

        WebElement dropDown= Driver.get().findElement(By.xpath("//*[@id='aa_accountId']"));

        Select select = new Select(dropDown);
        String actualDropdown = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedDropdown,actualDropdown);



    }








}
