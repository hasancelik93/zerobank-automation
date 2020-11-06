package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBankingPage extends BasePage{


    @FindBy (linkText = "Account Summary")
    public WebElement accountSummary;

    @FindBy(css = "[style='text-decoration: underline']")
    public WebElement savings;



}
