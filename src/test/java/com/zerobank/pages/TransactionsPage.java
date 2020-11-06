package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class TransactionsPage extends BasePage{

    @FindBy (id = "aa_description")
    public WebElement description;

    @FindBy(id="aa_fromDate")
    public WebElement fromDate;

    @FindBy(id="aa_toDate")
    public WebElement toDate;

    @FindBy(id="aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id="aa_type")
    public WebElement typeDropdown;

    @FindBy(tagName = "button")
    public WebElement findButton;



    public List<WebElement> tableColums(String type){

        List<WebElement> tableColumn;



        switch (type) {
            case "Date":
                tableColumn = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
                break;
            case "Description":
                tableColumn = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]"));
                break;
            case "Deposit":
                tableColumn = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[3]"));
                break;
            case "Withdrawal":
                tableColumn = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[4]"));
                break;
            default:
                tableColumn=null;
                break;
        }

      return tableColumn;
    }


    public List<WebElement> tableDeposits(){

        List<WebElement>tableDeposit = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[3]"));

        return tableDeposit;
    }

    public List<WebElement> tableWithdraws(){

        List<WebElement>tableWithdraw = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[4]"));

        return tableWithdraw;
    }


}
