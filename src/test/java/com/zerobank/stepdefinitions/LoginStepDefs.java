package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;

public class LoginStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

        String username = ConfigurationReader.get("username");
        String password= ConfigurationReader.get("password");
        new LoginPage().login(username,password);
        Thread.sleep(2000);
    }
}
