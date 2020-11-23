package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrencyPage extends BasePage{

    @FindBy (id="pc_currency")
    public WebElement currencyOptions;


    @FindBy(id = "purchase_cash")
    public WebElement purchaseBtn;

    @FindBy(id= "pc_calculate_costs")
    public WebElement calculateBtn;

    @FindBy(id="pc_amount")
    public WebElement amount;

    @FindBy(id="pc_inDollars_true")
    public WebElement inDollarsTrue;

    @FindBy (id="pc_inDollars_false")
    public WebElement inDollarsFalse;

}
