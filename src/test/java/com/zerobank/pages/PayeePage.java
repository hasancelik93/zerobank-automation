package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayeePage extends BasePage{

    @FindBy (id ="np_new_payee_name")
    public WebElement payeeName;

    @FindBy (xpath="//input[@id='np_new_payee_name']")
    public WebElement payeeName2;

    @FindBy(id ="np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id="np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id="np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id="add_new_payee")
    public WebElement addButton;

    @FindBy(id ="alert_content")
    public WebElement alert;

    @FindBy(xpath = "//div[contains(text(),'was successfully created.')]")
    public WebElement succesMsg;


}
