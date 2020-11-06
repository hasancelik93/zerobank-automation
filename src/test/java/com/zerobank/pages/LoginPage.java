package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (name = "user_login")
    public WebElement userName;

    @FindBy (name = "user_password")
    public WebElement password;

    @FindBy (name = "submit")
    public WebElement submit;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

    public void login(){

        String userNameStr=ConfigurationReader.get("username");
        String passwordStr= ConfigurationReader.get("password");

        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }

}
